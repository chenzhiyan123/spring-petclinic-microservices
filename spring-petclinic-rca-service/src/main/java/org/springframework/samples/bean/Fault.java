package org.springframework.samples.bean;

import com.arangodb.springframework.annotation.ArangoId;
import com.arangodb.springframework.annotation.Document;

@Document("faults")
public class Fault {
    @ArangoId
    private String id;
    private String time;
    private String serviceName;
    private String faultType;
    private String info;
    private String requestUrl;
    private String statusCode;

    public Fault() {
    }

    public Fault(String time, String serviceName, String faultType, String info) {
        this.time = time;
        this.serviceName = serviceName;
        this.faultType = faultType;
        this.info = info;
    }

    public Fault(String id, String time, String serviceName, String faultType, String info) {
        this.id = id;
        this.time = time;
        this.serviceName = serviceName;
        this.faultType = faultType;
        this.info = info;
    }

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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Fault{" +
            "id='" + id + '\'' +
            ", time='" + time + '\'' +
            ", serviceName='" + serviceName + '\'' +
            ", faultType='" + faultType + '\'' +
            ", info='" + info + '\'' +
            '}';
    }
}
