package com.DigitalHeros.page_pulse.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuditResponse {

    private String url;
    private int status;
    private long responseTime;

    private String title;

    private int h1Count;

    private int missingAltTags;

    private int wordCount;
}