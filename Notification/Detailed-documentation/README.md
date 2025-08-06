# **Notification Microservice Documentation**

## Author Information

| Created By | Created On | Version | Last Updated By | Pre Reviewer | L0 Reviewer | L1 Reviewer | L2 Reviewer |
| ---------- | ---------- | ------- | --------------- | ------------ | ----------- | ----------- | ----------- |
| Anuj Jain  | 22-07-2025 | V1      | —               | Prashant     | —           | —           | —           |

---

## Table of Contents
1. [Introduction](#introduction)  
2. [What is Notification Microservice?](#what-is-notification-microservice)  
3. [Why Use Notification Microservice?](#why-use-notification-microservice)  
4. [Workflow Diagram](#workflow-diagram)  
5. [Setup & Installation](#setup--installation)  
6. [Environment Variables](#environment-variables)  
7. [How to Run](#how-to-run)  
8. [Features](#features)  
9. [Troubleshooting](#troubleshooting)  
10. [Advantages](#advantages)  
11. [Best Practices](#best-practices)  
12. [Conclusion](#conclusion)  
13. [Contact Information](#contact-information)  
14. [References](#references)  

---

## Introduction

This document provides comprehensive information about the **Notification Microservice**, which is responsible for delivering system-generated notifications through different channels like **Email**, **SMS**, and **Push Notifications**. The documentation includes setup, environment configuration, running the service, and debugging support.

---

## What is Notification Microservice?

Notification Microservice is a standalone service that manages the delivery of various types of notifications (email, SMS, push) to users in an asynchronous, event-driven manner. It stores and retrieves notification logs and templates using **Elasticsearch** for fast search and analytics.

---

## Why Use Notification Microservice?

* Decouples notification logic from core applications  
* Enables asynchronous and searchable logging  
* Scalable and reusable across microservices  
* Centralizes notification management  
* Easy to integrate via REST APIs or messaging systems  

---

## Workflow Diagram

```
Frontend / Any Microservice  
           ↓  
     REST API Request  
           ↓  
 Notification Service  
           ↓  
  Elasticsearch (for logging/search)  
           ↓  
Email / SMS / Push APIs  
```

---

## Setup & Installation

For detailed installation steps, prerequisites, and deployment guidelines, refer to the **[Notification Microservice POC Documentation](https://github.com/Snaatak-Cloudops-Crew/documentation/tree/SCRUM-4-meenu/OT-Microservices/Applications/Notification%20-API/POC#readme)**.

---

## Environment Variables

| Variable Name        | Description                                                               |
| -------------------- | ------------------------------------------------------------------------- |
| `MAIL_HOST`          | SMTP mail server                                                          |
| `MAIL_PORT`          | SMTP port                                                                 |
| `MAIL_USERNAME`      | Sender email                                                              |
| `MAIL_PASSWORD`      | Sender email password/app token                                           |
| `ELASTICSEARCH_HOST` | Elasticsearch host (e.g., [http://localhost:9200](http://localhost:9200)) |
| `SMS_API_KEY`        | SMS Gateway key (if using SMS)                                            |
| `FIREBASE_KEY`       | Firebase server key for push                                              |

---

## Features

| Feature            | Description                                    |
| ------------------ | ---------------------------------------------- |
| Elasticsearch Logs | Stores and searches notification delivery logs |
| Email Notification | Sends templated emails via SMTP                |
| SMS Notification   | Sends messages using SMS APIs (e.g., Twilio)   |
| Push Notification  | Firebase integration for mobile alerts         |
| Template Support   | Dynamic content based on message templates     |

---

## Troubleshooting

| Problem                | Solution                                 |
| ---------------------- | ---------------------------------------- |
| Email not sent         | Verify SMTP credentials and port         |
| Logs not stored        | Check Elasticsearch connection and index |
| Docker container exits | Use `docker logs <container_id>`         |
| SMS gateway fails      | Check API key and balance                |
| Firebase not sending   | Validate your Firebase key and project   |

---

## Advantages

| Advantage                         | Description                                      |
| --------------------------------- | ------------------------------------------------ |
| Centralized Notification Handling | Easier to manage and update templates or logic   |
| Searchable Logs                   | Use Elasticsearch to trace and analyze delivery  |
| Easy to Scale                     | Independent deployment allows horizontal scaling |
| Improved Reliability              | Async processing improves system resilience      |
| Loose Coupling                    | Apps don’t need to handle delivery logic         |

---

## Best Practices

* Use versioned templates and fallback logic  
* Secure secrets using vaults or env variables  
* Index logs in Elasticsearch with timestamps and metadata  
* Enable retry and alerting for failed notifications  
* Monitor Elasticsearch index size and query performance  

---

## Conclusion

Notification Microservice simplifies and centralizes the task of sending emails, push notifications, and SMS in a microservice architecture. With **Elasticsearch integration**, it allows searchable logging and analytics, making it powerful for observability and audit tracking.

---

## Contact Information

| **Name**  | **Email Address**                                                         |
| --------- | ------------------------------------------------------------------------- |
| Anuj Jain | [anujjain.snaatak@mygurukulam.co](mailto:anujjain.snaatak@mygurukulam.co) |

---

## References

* [Spring Boot Docs](https://spring.io/projects/spring-boot)  
* [Elasticsearch Docs](https://www.elastic.co/guide/en/elasticsearch/reference/current/index.html)  
* [Firebase Cloud Messaging](https://firebase.google.com/docs/cloud-messaging)  
* [Twilio SMS API](https://www.twilio.com/docs/sms)  

--- 
