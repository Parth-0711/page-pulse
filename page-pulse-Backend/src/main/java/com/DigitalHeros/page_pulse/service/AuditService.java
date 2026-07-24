package com.DigitalHeros.page_pulse.service;

import com.DigitalHeros.page_pulse.dto.AuditResponse;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import java.net.URL;

@Service
public class AuditService {

    private void validateUrl(String url) {

        try {
            new URL(url);
        } catch (Exception e) {
            throw new RuntimeException("Invalid URL format");
        }
    }

    public AuditResponse analyze(String url) {

        validateUrl(url);

        try {

            long start = System.currentTimeMillis();

            Connection.Response response =
                    Jsoup.connect(url)
                            .timeout(5000)
                            .execute();

            String contentType = response.contentType();

            if(contentType == null ||
                    !contentType.contains("text/html")) {

                throw new RuntimeException(
                        "URL does not return HTML content");
            }

            long end = System.currentTimeMillis();

            Document document = response.parse();

            String title = document.title();

            int h1Count =
                    document.select("h1").size();

            int missingAltTags =
                    document.select("img:not([alt])").size();

            String text =
                    document.body().text();

            int wordCount =
                    text.split("\\s+").length;

            return AuditResponse.builder()
                    .url(url)
                    .status(response.statusCode())
                    .responseTime(end - start)
                    .title(title)
                    .h1Count(h1Count)
                    .missingAltTags(missingAltTags)
                    .wordCount(wordCount)
                    .build();

        } catch (RuntimeException e) {
            throw e;
        }
        catch (Exception e) {

            e.printStackTrace();

            throw new RuntimeException(
                    "Unable to analyze URL: " + e.getMessage());
        }

    }
}