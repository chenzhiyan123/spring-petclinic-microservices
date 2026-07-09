package org.springframework.samples;

public final class FaultUtils {
    public static String genIdentityNo(String serviceName, String faultType, String info) {
//        todo
        return serviceName + "*" + faultType + "*" + info.replaceAll(" ", ";");
    }
}


