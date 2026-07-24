package com.DigitalHeros.page_pulse.controller;

import com.DigitalHeros.page_pulse.dto.AuditRequest;
import com.DigitalHeros.page_pulse.dto.AuditResponse;
import com.DigitalHeros.page_pulse.service.AuditService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AuditController {

    private final AuditService auditService;

    @PostMapping("/analyze")
    public AuditResponse analyze(
            @Valid @RequestBody AuditRequest request) {

        return auditService.analyze(
                request.getUrl()
        );
    }
}