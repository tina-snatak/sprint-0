# POC for Redis – Setup & Run the Redis 

## Author Information

| Author         | Created on | Version | Last updated by | Last edited on | Level     | Reviewer       |
|----------------|------------|---------|------------------|----------------|-----------|----------------|
| Tina Bhatnagar | 03-08-25   | v1.0    | Tina Bhatnagar   | 03-08-25       | Internal  | Rohit Chopra   |

---

## Table of Contents

1. [Introduction](#1-introduction)  
2. [Purpose](#2-purpose)  
3. [Pre-requisites](#3-pre-requisites)  
4. [Redis Setup](#4-redis-setup)  
   - [Cloud Setup (AWS EC2)](#cloud-setup-aws-ec2)  
   - [Connect via SSH](#connect-via-ssh)  
   - [Install Redis (Ubuntu)](#install-redis-ubuntu)  
   - [Enable Redis To Start On Boot](#enable-redis-to-start-on-boot)  
   - [Verify Redis Service Status](#verify-redis-service-status)  
5. [Verifying Redis Installation](#5-verifying-redis-installation)  
6.  [Check Redis Version](#6-check-redis-version)  
7. [Redis CLI Basics](#7-redis-cli-basics)  
    - [Example Redis CLI Interaction](#example-redis-cli-interaction)  
8. [Redis Use Cases](#8-redis-use-cases)  
9. [Troubleshooting](#9-troubleshooting)  
10. [Conclusion](#10-conclusion)  
11. [Contact Information](#11-contact-information)  
12. [References](#12-references)


---

## 1. Intro

This documentation outlines how to set up and run **Redis** for Proof of Concept (POC) purposes,  on a requested cloud platform (like AWS EC2). 

---

## 2. Purpose

Redis is a lightweight, in-memory data structure store commonly used for caching, session management, real-time analytics, message brokering, and high-speed data processing.

---

## 3. Pre-requisites

| Requirement                                 | Description                                                                 |
|---------------------------------------------|-----------------------------------------------------------------------------|
| Redis Basics                                | Basic understanding of Redis key-value operations                          |
| Terminal Access                             | Access to Linux shell or terminal                                           |
| SSH Access                                  | Secure SSH access to the cloud virtual machine (e.g., AWS EC2)             |
| Internet Connectivity                       | Required to download and install Redis and dependencies                    |
| Admin Privileges                            | Root or sudo access to perform installation and configuration tasks        |


---

## 4. Redis Setup 

###  Cloud Setup (AWS EC2)

- #### Launch a Linux EC2 instance (Ubuntu 24.04 )

   <img width="1447" height="105" alt="image" src="https://github.com/user-attachments/assets/38ed9db4-5599-4c44-81b0-dfcb385997c1" />
---


- #### Connect via SSH:
   ```bash
   ssh -i ~/.ssh/your-key.pem ubuntu@<your-ec2-public-ip>
   ```
   
   <img width="800" height="848" alt="image" src="https://github.com/user-attachments/assets/fc61c5a1-4732-4479-a79d-d0fde4675309" />

   ---

- #### Install Redis (Ubuntu)

   To install Redis on an Ubuntu-based EC2 instance, run the following command:

   ```bash
    sudo apt update && sudo apt install redis -y
   ```

<img width="1073" height="328" alt="image" src="https://github.com/user-attachments/assets/e5dac78c-7d83-4794-90be-63d037c7388a" />
<img width="1241" height="928" alt="image" src="https://github.com/user-attachments/assets/379d596b-f37c-455f-9ecd-1815e0a3fd18" />

---

- #### Enable Redis to Start on Boot

   After installing Redis, enable and start the Redis service using the following commands:

   ```bash
     sudo systemctl enable redis-server
     sudo systemctl start redis-server
  ```
 <img width="1500" height="133" alt="image" src="https://github.com/user-attachments/assets/27b0dfdc-1db8-44eb-9498-b477c1b1c286" />

---

 - #### Verify Redis Service Status

    You can verify the status of the Redis service using the following command:

   ```bash
      sudo systemctl status redis-server
   ```
  <img width="1352" height="427" alt="image" src="https://github.com/user-attachments/assets/1df0ab79-70d1-4f47-8810-7923c70be790" />

  ---

## 5. Verifying Redis Installation

  After starting Redis, you can verify if it’s running properly by using the `redis-cli` command:

  ```bash
   redis-cli ping
 ```
<img width="573" height="95" alt="image" src="https://github.com/user-attachments/assets/5b12777a-bc16-498c-818b-ccc41ba5964e" />

---

## 6. Check Redis Version

To verify which version of Redis is installed on your system, run the following command:

```bash
redis-server --version
```
<img width="1193" height="92" alt="image" src="https://github.com/user-attachments/assets/691184e7-076e-481b-a0b3-95fdf63368d8" />

---
  
## 7. Redis CLI Basics

| Command         | Description                          |
|-----------------|--------------------------------------|
| `SET key value` | Stores a key-value pair              |
| `GET key`       | Retrieves value by key               |
| `DEL key`       | Deletes a key                        |
| `EXISTS key`    | Checks if a key exists               |
| `KEYS *`        | Lists all keys                       |
| `FLUSHALL`      | Clears all keys (**careful!**)       |
| `INCR key`      | Increments a numeric value           |


- #### Example Redis CLI Interaction

 - To start using Redis CLI, run:

  ```bash
   redis-cli
  ```
<img width="507" height="66" alt="image" src="https://github.com/user-attachments/assets/20d940a2-366a-4133-b1c1-a0fcc48fca7c" />

---

- Try the following commands:
  
   ```bash
   SET name "Tina Bhatnagar"
    ```
   ```bash
   GET name
    ```
 <img width="573" height="137" alt="image" src="https://github.com/user-attachments/assets/2d51d50a-9cc7-4d0f-a80e-406db523810e" />

---
- To exit the Redis CLI, type:

  ```bash
   exit
  ```
   <img width="392" height="63" alt="image" src="https://github.com/user-attachments/assets/6c255630-18d5-4cbc-bb44-44a53bb8e03f" />

   ---

## 8. Redis Use Cases 

| Scenario                      | Usage in POC                          |
|------------------------------|---------------------------------------|
| Caching API responses        | Store data in Redis for fast fetch   |
| User session storage         | Temporary in-memory storage          |
| Leaderboard implementation   | Sorted sets usage                    |
| Rate limiting in apps        | Using counters + TTL                 |
| Queueing mechanism (Pub/Sub) | Lightweight messaging                |

---

## 9. Troubleshooting

| Problem                       | Cause                            | Fix                                                      |
|------------------------------|----------------------------------|----------------------------------------------------------|
| `redis-cli` not found        | Not installed properly           | Reinstall using package manager                          |
| Connection refused           | Redis not running                | `sudo systemctl start redis`                             |
| Cannot bind to port 6379     | Port already in use              | Change Redis config file or stop conflicting service     |
| Data not persisting          | Using in-memory only             | Configure RDB or AOF in `redis.conf`                     |
| Redis not accessible externally | Bound to localhost only       | Edit `bind 0.0.0.0` and `protected-mode` in config       |

---

## 10. Conclusion

Setting up Redis for a Proof of Concept (POC) is straightforward and efficient. Its lightweight and in-memory architecture makes it ideal for rapid development and testing scenarios.
For long-term maintainability and future production upgrades, ensure that the Redis setup and configurations are well-documented in project tracking tools like Jira.

---

## 11. Contact Information

| Name| Email Address      | GitHub | URL |
|-----|--------------------------|-------------|---------|
| Tina Bhatnagar | [tina.bhatnagar@mygurukulam.co](mailto:tina.bhatnagar@mygurukulam.co)|  tina-snatak  | https://github.com/tina-snatak/ |

---

## 12. References

| Title                    | Link                                                                 |
|--------------------------|----------------------------------------------------------------------|
| Official Redis Docs      | [Visit](https://redis.io/docs/)                                      |
| Redis Tutorial           | https://www.tutorialspoint.com/redis/index.htm                       |




