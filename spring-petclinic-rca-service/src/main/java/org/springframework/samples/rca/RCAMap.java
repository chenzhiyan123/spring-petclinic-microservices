package org.springframework.samples.rca;

import org.springframework.samples.FaultTypeEnum;
import org.springframework.samples.rca.base.BaseRCA;

import java.util.HashMap;
import java.util.Map;

public class RCAMap {
    public static Map<String, BaseRCA> map = new HashMap<>(1000);
    static {
        map.put(FaultTypeEnum.BUSINESS_CODE_REQUEST.getName(), new BusinessCodeRequestRCA());
        map.put(FaultTypeEnum.RESOURCE_MEMORY.getName(), new ResourceMemoryRCA());
        map.put(FaultTypeEnum.LOG_EXCEPTION.getName(), new LogExceptionRCA());
    }
}
