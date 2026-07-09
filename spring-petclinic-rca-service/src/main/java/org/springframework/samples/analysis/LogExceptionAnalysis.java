package org.springframework.samples.analysis;

import org.springframework.samples.bean.Fault;
import org.springframework.samples.bean.InputFault;

import java.io.IOException;

public class LogExceptionAnalysis implements BaseAnalysis {
    @Override
    public boolean analysis(InputFault inputFault) {
        return false;
    }

    public Fault localize(InputFault inputFault) {
        // TODO
        return new Fault(inputFault.getTime(), inputFault.getServiceName(), inputFault.getFaultType(), inputFault.getRelatedInformations());
    }

}
