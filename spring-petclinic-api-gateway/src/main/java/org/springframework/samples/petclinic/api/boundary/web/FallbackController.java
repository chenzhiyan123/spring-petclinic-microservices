package org.springframework.samples.petclinic.api.boundary.web;

import org.apache.hc.core5.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {
    private static final Logger log = LoggerFactory.getLogger(FallbackController.class);

    @PostMapping("/fallback")
    public ResponseEntity<String> fallback() {
        log.info("service unavailable:{}", HttpStatus.SC_SERVICE_UNAVAILABLE);
        return ResponseEntity.status(HttpStatus.SC_SERVICE_UNAVAILABLE)
                .body("Chat is currently unavailable. Please try again later.");
    }
}
