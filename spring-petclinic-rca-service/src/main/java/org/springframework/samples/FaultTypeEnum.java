package org.springframework.samples;

public enum FaultTypeEnum {
    RESOURCE_MEMORY("resource-memory"),
    LOG_WARN("log-warn"),
    LOG_EXCEPTION("log-exception"),
    BUSINESS_CODE_REQUEST("business-code-request"),
    CRASH("crash");

    String name;

    FaultTypeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
