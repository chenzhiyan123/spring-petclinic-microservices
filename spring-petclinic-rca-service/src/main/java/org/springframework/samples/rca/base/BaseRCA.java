package org.springframework.samples.rca.base;

import org.springframework.samples.analysis.FaultAnalysis;
import org.springframework.samples.bean.InputFault;
import org.springframework.samples.repository.FaultEdgeRepository;
import org.springframework.samples.repository.FaultRepository;

import java.util.concurrent.ExecutorService;

public interface BaseRCA {
    public void doRCA(InputFault inputFault, FaultRepository faultRepository, FaultEdgeRepository faultEdgeRepository, ExecutorService executorService);
}
