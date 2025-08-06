# **Notification Microservice Documentation**

## Author Information

| **Author**        | **Created on** | **Version** | **Last updated by** | **Last edited on** | **Level**   | **Reviewer**      |
|-------------------|----------------|-------------|----------------------|--------------------|-------------|-------------------|
| Tina Bhatnagar     | 31-07-25       | v1.0        | Tina Bhatnagar       | 31-07-25           | Internal    | Rohit Chopra      |


---

## Table of Contents
1. [Introduction](#1-introduction)  
2. [What is Notification Microservice?](#2-what-is-notification-microservice)  
3. [Why Use Notification Microservice?](#3-why-use-notification-microservice)  
4. [Workflow Diagram](#4-workflow-diagram)  
5. [Setup & Installation](#5-setup--installation)  
6. [Environment Variables](#6-environment-variables)   
7. [Features](#7-features)  
8. [Troubleshooting](#8-troubleshooting)  
9. [Advantages](#9-advantages)
10. [Disadvantages](#10-disadvantages)  
11. [Best Practices](#11-best-practices)  
12. [Conclusion](#12-conclusion)  
13. [Contact Information](#13-contact-information)  
14. [References](#14-references)  

---

## 1. Introduction

This document provides comprehensive information about the **Notification Microservice**, which is responsible for delivering system-generated notifications through different channels like **Email**, **SMS**, and **Push Notifications**. The documentation includes setup, environment configuration, running the service, and debugging support.

---

## 2. What is Notification Microservice?

Notification Microservice is a standalone service that manages the delivery of various types of notifications (email, SMS, push) to users in an asynchronous, event-driven manner. It stores and retrieves notification logs and templates using **Elasticsearch** for fast search and analytics.

---

## 3. Why Use Notification Microservice?

* Decouples notification logic from core applications  
* Enables asynchronous and searchable logging  
* Scalable and reusable across microservices  
* Centralizes notification management  
* Easy to integrate via REST APIs or messaging systems  

---

## 4. Workflow Diagram

<img width="366" height="427" alt="image" src="https://github.com/user-attachments/assets/40651391-56ff-41c3-b0a1-abd7b4638e34" />

#### Dataflow Diagram Explanation

| Step | Description |
|------|-------------|
| 1. Frontend / Any Microservice | A client or microservice triggers the process by sending a REST API request. |
| 2. REST API Request | The request is received and passed to the Notification Service for processing. |
| 3. Notification Service | Handles event logic, logs data to Elasticsearch, and prepares the notification. |
| 4. Elasticsearch & Delivery APIs | Elasticsearch stores logs/search data, and Email/SMS/Push APIs deliver the notification to the end user. |

---

## 5. Setup & Installation

For detailed installation steps, prerequisites, and deployment guidelines, refer to the **[Notification Microservice POC Documentation](https://github.com/Snaatak-Apt-Get-Swag/documentation/blob/scrum-66-sunny/OT-Microservices/Application/Notification/POC/README.md)**.

---

## 6. Environment Variables

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

## 7. Features

| Feature            | Description                                    |
| ------------------ | ---------------------------------------------- |
| Elasticsearch Logs | Stores and searches notification delivery logs |
| Email Notification | Sends templated emails via SMTP                |
| SMS Notification   | Sends messages using SMS APIs (e.g., Twilio)   |
| Push Notification  | Firebase integration for mobile alerts         |
| Template Support   | Dynamic content based on message templates     |

---

## 8. Troubleshooting

| Problem                | Solution                                 |
| ---------------------- | ---------------------------------------- |
| Email not sent         | Verify SMTP credentials and port         |
| Logs not stored        | Check Elasticsearch connection and index |
| SMS gateway fails      | Check API key and balance                |
| Firebase not sending   | Validate your Firebase key and project   |

---

## 9. Advantages

| Advantage                         | Description                                      |
| --------------------------------- | ------------------------------------------------ |
| Centralized Notification Handling | Easier to manage and update templates or logic   |
| Searchable Logs                   | Use Elasticsearch to trace and analyze delivery  |
| Easy to Scale                     | Independent deployment allows horizontal scaling |
| Improved Reliability              | Async processing improves system resilience      |
| Loose Coupling                    | Apps don’t need to handle delivery logic         |

---

## 10. Disadvantages

| Disadvantage                  | Description                                                                 |
| ----------------------------- | --------------------------------------------------------------------------- |
| Dependency on External Services | Relies on Elasticsearch and SMTP; failure in these can halt notifications  |
| Configuration Overhead         | Requires proper setup of SMTP, Elasticsearch, and configs before use       |
| Delay in High Load              | Under heavy event load, processing might be delayed                        |
| Security Risks                  | SMTP credentials and data must be securely stored to avoid misuse          |
| Maintenance Effort              | Regular updates and monitoring needed for dependencies and worker scripts  |

---

## 11. Best Practices

| Best Practice                                      | Description                                                                 |
| -------------------------------------------------- | --------------------------------------------------------------------------- |
| Use versioned templates and fallback logic         | Maintain multiple versions of templates and a fallback in case of failure  |
| Secure secrets using vaults or env variables       | Store SMTP credentials and API keys securely to prevent unauthorized access |
| Index logs in Elasticsearch with timestamps & metadata | Add timestamps and metadata to make logs easier to search and analyze      |
| Enable retry and alerting for failed notifications | Automatically retry failed deliveries and alert administrators             |
| Monitor Elasticsearch index size & query performance | Regularly track index growth and optimize queries for better performance   |

---

## 12. Conclusion

Notification Microservice simplifies and centralizes the task of sending emails, push notifications, and SMS in a microservice architecture. With **Elasticsearch integration**, it allows searchable logging and analytics, making it powerful for observability and audit tracking.

---

## 13. Contact Information


| Name| Email Address      | GitHub | URL |
|-----|--------------------------|-------------|---------|
| Tina Bhatnagar | [tina.bhatnagar@mygurukulam.co](mailto:tina.bhatnagar@mygurukulam.co)|  tina-snatak  | https://github.com/tina-snatak/ |

---

## 14. References

| Name                        | Link                                                                                             |
| --------------------------- | ------------------------------------------------------------------------------------------------ |
| Spring Boot Docs            | [https://spring.io/projects/spring-boot](https://spring.io/projects/spring-boot)                 |
| Elasticsearch Docs          | [https://www.elastic.co/guide/en/elasticsearch/reference/current/index.html](https://www.elastic.co/guide/en/elasticsearch/reference/current/index.html) |
| Firebase Cloud Messaging    | [https://firebase.google.com/docs/cloud-messaging](https://firebase.google.com/docs/cloud-messaging) |
| Twilio SMS API              | [https://www.twilio.com/docs/sms](https://www.twilio.com/docs/sms)                               |

--- 
