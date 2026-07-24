package com.DigitalHeros.page_pulse.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AuditServiceTest {

    private final AuditService auditService =
            new AuditService();

    @Test
    void invalidUrlShouldThrowException() {

        RuntimeException exception =
                assertThrows(RuntimeException.class,
                        () -> auditService.analyze("abc"));

        assertTrue(exception.getMessage()
                .contains("Invalid URL"));
    }

    @Test
    void validUrlShouldReturnData() {

        var response =
                auditService.analyze("https://example.com");

        assertEquals(200,
                response.getStatus());
    }

    @Test
    void nonHtmlUrlShouldThrowException() {

        assertThrows(RuntimeException.class,
                () -> auditService.analyze(
                        "https://api.github.com"));
    }
}