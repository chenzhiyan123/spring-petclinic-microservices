package org.springframework.samples.analysis;

import org.springframework.samples.bean.Fault;
import org.springframework.samples.bean.InputFault;
import org.springframework.stereotype.Component;

public class FaultAnalysis implements BaseAnalysis {
    @Override
    public boolean analysis(InputFault inputFault) {
        if ("log-warn".equals(inputFault.getFaultType()) && "customers-service".equals(inputFault.getServiceName())) {
            return false;
        }
        return true;
    }

}
