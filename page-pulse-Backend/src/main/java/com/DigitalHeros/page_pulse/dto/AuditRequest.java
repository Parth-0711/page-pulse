package com.DigitalHeros.page_pulse.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AuditRequest {

    @NotBlank
    private String url;
}