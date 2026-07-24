# Page Pulse

A lightweight SEO auditing tool built with Spring Boot and React.

## Features

- URL Validation
- Response Time Measurement
- HTTP Status Detection
- Page Title Extraction
- H1 Count
- Missing Alt Tag Detection
- Word Count

## Tech Stack

### Backend
- Java 17
- Spring Boot
- Jsoup

### Frontend
- React
- Vite
- Axios

## API

### POST /api/analyze

Request:

```json
{
  "url": "https://example.com"
}
