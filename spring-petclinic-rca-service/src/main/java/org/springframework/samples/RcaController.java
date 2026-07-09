package org.springframework.samples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.samples.analysis.BaseAnalysis;
import org.springframework.samples.analysis.FaultAnalysis;
import org.springframework.samples.bean.Fault;
import org.springframework.samples.bean.FaultEdge;
import org.springframework.samples.bean.InputFault;
import org.springframework.samples.rca.RCAMap;
import org.springframework.samples.rca.base.BaseRCA;
import org.springframework.samples.repository.FaultEdgeRepository;
import org.springframework.samples.repository.FaultRepository;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.StreamSupport;

@RequestMapping("/rca")
@RestController
public class RcaController {
    ExecutorService executorService = Executors.newCachedThreadPool();
    private static final Logger log = LoggerFactory.getLogger(RcaController.class);

    @Autowired
    private FaultRepository faultRepository;

    @Autowired
    private FaultEdgeRepository faultEdgeRepository;

    @PutMapping("/fault/insert")
    public String insertFault(InputFault inputFault) {
        String identityNo = FaultUtils.genIdentityNo(inputFault.getServiceName(), inputFault.getFaultType(), inputFault.getRelatedInformations());

        Fault resultFault = faultRepository.save(new Fault(identityNo, inputFault.getTime(), inputFault.getServiceName(), inputFault.getFaultType(), inputFault.getRelatedInformations()));
        log.info("insertFault result:{}", resultFault.toString());
        return RCAConstants.SUCCESS;
    }

    @PostMapping("/fault/localization")
    public String localization(InputFault inputFault) {
        BaseAnalysis faultAnalysis = new FaultAnalysis();
        if (!faultAnalysis.analysis(inputFault)) {
            log.info("no need to localization fault:{}", inputFault.toString());
            return RCAConstants.SUCCESS;
        }
        String identityNo;
        BaseRCA rca = RCAMap.map.get(inputFault.getFaultType());
        if (rca == null) {
            log.error("no classification fault:{}", inputFault.toString());
            return RCAConstants.FAIL;
        }
        rca.doRCA(inputFault, faultRepository, faultEdgeRepository, executorService);
        log.info("localization result:{}", inputFault.toString());
        return RCAConstants.SUCCESS;
    }

}
