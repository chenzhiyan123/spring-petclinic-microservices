package org.springframework.samples.rca;

import org.springframework.samples.FaultUtils;
import org.springframework.samples.analysis.FaultAnalysis;
import org.springframework.samples.bean.Fault;
import org.springframework.samples.bean.InputFault;
import org.springframework.samples.rca.base.BaseRCA;
import org.springframework.samples.repository.FaultEdgeRepository;
import org.springframework.samples.repository.FaultRepository;

import java.util.Optional;
import java.util.concurrent.ExecutorService;

public class CrashRCA implements BaseRCA {

    @Override
    public void doRCA(InputFault inputFault, FaultRepository faultRepository, FaultEdgeRepository faultEdgeRepository,  ExecutorService executorService) {
        String identityNo = FaultUtils.genIdentityNo(inputFault.getServiceName(), inputFault.getFaultType(), inputFault.getRelatedInformations());
        Optional<Fault> fault1 = faultRepository.findById(identityNo);
        if (fault1.isEmpty()) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    Fault faultToSave = new Fault(identityNo, inputFault.getTime(), inputFault.getServiceName(), inputFault.getFaultType(), inputFault.getRelatedInformations());
                    faultToSave.setRequestUrl(inputFault.getRequestUrl());
                    faultToSave.setStatusCode(inputFault.getStatusCode());
                    Fault saveFaultResult = faultRepository.save(faultToSave);
                }
            });
        }

    }
}
