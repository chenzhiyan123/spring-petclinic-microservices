package org.springframework.samples.rca;

import org.springframework.samples.FaultUtils;
import org.springframework.samples.analysis.FaultAnalysis;
import org.springframework.samples.analysis.MemoryAnalysis;
import org.springframework.samples.bean.Fault;
import org.springframework.samples.bean.FaultEdge;
import org.springframework.samples.bean.InputFault;
import org.springframework.samples.rca.base.ResourceRCA;
import org.springframework.samples.repository.FaultEdgeRepository;
import org.springframework.samples.repository.FaultRepository;

import java.util.Optional;
import java.util.concurrent.ExecutorService;

public class ResourceMemoryRCA extends ResourceRCA {
    @Override
    public void doRCA(InputFault inputFault, FaultRepository faultRepository, FaultEdgeRepository faultEdgeRepository, ExecutorService executorService) {
        String identityNo = FaultUtils.genIdentityNo(inputFault.getServiceName(), inputFault.getFaultType(), inputFault.getRelatedInformations());
        Optional<Fault> fault = faultRepository.findById(identityNo);
        if (fault.isEmpty()) {
            MemoryAnalysis memoryAnalysis = new MemoryAnalysis();
            Fault rootFault = memoryAnalysis.localize(inputFault);
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    Fault faultToSave = new Fault(identityNo, inputFault.getTime(), inputFault.getServiceName(), inputFault.getFaultType(), inputFault.getRelatedInformations());
                    faultToSave.setRequestUrl(inputFault.getRequestUrl());
                    faultToSave.setStatusCode(inputFault.getStatusCode());
                    Fault saveFaultResult = faultRepository.save(faultToSave);
                }
            });
            if (inputFault.getServiceName().equals(rootFault.getServiceName())) {
                return;
            }
            if (rootFault != null) {
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        FaultEdge saveFaultEdgeResult = faultEdgeRepository.save(new FaultEdge(rootFault.getId(), identityNo));
                    }
                });
            }


        }
    }
}
