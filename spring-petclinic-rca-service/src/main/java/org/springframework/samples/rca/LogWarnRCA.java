package org.springframework.samples.rca;

import org.springframework.samples.FaultUtils;
import org.springframework.samples.analysis.FaultAnalysis;
import org.springframework.samples.bean.Fault;
import org.springframework.samples.bean.InputFault;
import org.springframework.samples.rca.base.BusinessCodeRCA;
import org.springframework.samples.repository.FaultEdgeRepository;
import org.springframework.samples.repository.FaultRepository;

import java.util.concurrent.ExecutorService;

public class LogWarnRCA extends BusinessCodeRCA {
    @Override
    public void doRCA(InputFault inputFault, FaultRepository faultRepository, FaultEdgeRepository faultEdgeRepository, ExecutorService executorService) {
        String identityNo = FaultUtils.genIdentityNo(inputFault.getServiceName(), inputFault.getFaultType(), inputFault.getRelatedInformations());
        Fault saveFaultResult = faultRepository.save(new Fault(identityNo, inputFault.getTime(), inputFault.getServiceName(), inputFault.getFaultType(), inputFault.getRelatedInformations()));
    }
}
