# Secure Async Notifier

A simple Spring Boot application demonstrating:
- **Spring Boot 4.0.0**
- **Java 25**
- **Spring Security** (Basic Auth)
- **Asynchronous Processing** (Multithreading)
- **CI/CD** (GitHub Actions)
- **Docker**

## Prerequisites

- Java 25
- Maven
- Docker

## Getting Started

### Build and Run Locally

```bash
./mvnw spring-boot:run
```

### Build Docker Image

```bash
docker build -t secure-async-notifier .
```

### Run Docker Container

```bash
docker run -p 8080:8080 secure-async-notifier
```

## API Usage

### Send Notification

**Endpoint:** `POST /notify`
**Auth:** Basic Auth (user:password)
**Param:** `message` (String)

```bash
curl -u user:password -X POST "http://localhost:8080/notify?message=Hello World"
```

## Features

- **Secure**: Endpoints are protected using Spring Security.
- **Async**: Notification processing happens in a separate thread.
