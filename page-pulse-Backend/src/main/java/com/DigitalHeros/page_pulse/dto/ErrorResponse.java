package com.DigitalHeros.page_pulse.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {

    private String error;
}