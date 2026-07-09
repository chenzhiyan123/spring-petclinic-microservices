package org.springframework.samples.bean;

public class InputFault {
    private String time;
    private String serviceName;
    private String faultType;
    private String relatedObservedData;
    private String relatedInformations;
    private String requestUrl;
    private String statusCode;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getFaultType() {
        return faultType;
    }

    public void setFaultType(String faultType) {
        this.faultType = faultType;
    }

    public String getRelatedObservedData() {
        return relatedObservedData;
    }

    public void setRelatedObservedData(String relatedObservedData) {
        this.relatedObservedData = relatedObservedData;
    }

    public String getRelatedInformations() {
        return relatedInformations;
    }

    public void setRelatedInformations(String relatedInformations) {
        this.relatedInformations = relatedInformations;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
}
