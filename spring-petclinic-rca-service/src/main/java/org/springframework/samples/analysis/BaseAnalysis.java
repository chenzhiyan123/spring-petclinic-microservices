package org.springframework.samples.analysis;

import org.springframework.samples.bean.InputFault;
import org.springframework.stereotype.Component;

public interface BaseAnalysis {
    public boolean analysis(InputFault inputFault);
}
