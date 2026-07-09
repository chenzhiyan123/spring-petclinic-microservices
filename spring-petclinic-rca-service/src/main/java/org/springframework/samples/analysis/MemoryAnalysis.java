package org.springframework.samples.analysis;

import org.springframework.core.io.ClassPathResource;
import org.springframework.samples.bean.Fault;
import org.springframework.samples.bean.InputFault;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
public class MemoryAnalysis implements BaseAnalysis {
    @Override
    public boolean analysis(InputFault inputFault) {
        if ("log-warn".equals(inputFault.getFaultType()) && "customers-service".equals(inputFault.getServiceName())) {
            return false;
        }
        return true;
    }

    public Fault localize(InputFault inputFault) {
        try {
            readLogs();
            readMetrics();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // TODO
        return new Fault(inputFault.getTime(), inputFault.getServiceName(), inputFault.getFaultType(), inputFault.getRelatedInformations());
    }

    private void readLogs() throws IOException {
        ClassPathResource resource = new ClassPathResource("logs/customers-service.log");

        // 方式 A：直接读取为 byte[] 转 String（适合小文件、文本文件）
        byte[] contentBytes = resource.getInputStream().readAllBytes();
        String content = new String(contentBytes, StandardCharsets.UTF_8);

    }

    private void readMetrics() throws IOException {
        ClassPathResource resource = new ClassPathResource("stats/customers-service_memory.csv");

        // 方式 A：直接读取为 byte[] 转 String（适合小文件、文本文件）
        byte[] contentBytes = resource.getInputStream().readAllBytes();
        String content = new String(contentBytes, StandardCharsets.UTF_8);
        System.out.println(content);
    }

}
