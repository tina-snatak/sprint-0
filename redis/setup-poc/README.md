<img width="200" height="200" alt="image" src="https://github.com/user-attachments/assets/870e0fd9-a621-49fd-a9c0-a7ba78503fc5" />


# POC for Redis – Setup & Run the Redis 


---
## Author Information

| Author         | Created on | Version | Last updated by | Last edited on | Level     | Reviewer       |
|----------------|------------|---------|------------------|----------------|-----------|----------------|
| Tina Bhatnagar | 03-08-25   | v1.0    | Tina Bhatnagar   | 03-08-25       | Internal  | Rohit Chopra   |

---

## Table of Contents

1. [Introduction](#1-introduction)  
2. [Purpose of the POC](#2-purpose-of-the-poc)  
3. [Pre-requisites](#3-pre-requisites)  
4. [Infra Provisioning (Cloud Setup)](#4-infra-provisioning-cloud-setup)  
5. [Redis Installation](#5-redis-installation)  
6. [Redis Configuration](#6-redis-configuration)  
7. [Verification Steps (Ping, Set/Get)](#7-verification-steps-ping-setget)  
8. [Redis Use Cases](#8-redis-use-cases)  
9. [Troubleshooting](#9-troubleshooting)  
10. [Conclusion](#10-conclusion)  
11. [Frequently Asked Questions (FAQs)](#11-frequently-asked-questions-faqs)  
12. [Contact Information](#12-contact-information)  
13. [References](#13-references)  

---

## 1. Introduction

 This documentation outlines how to set up and run **Redis** for Proof of Concept (POC) purposes,  on a requested cloud platform (like AWS EC2). 

---

 ## 2. Purpose of the POC
To manually deploy and configure a basic Redis server on a cloud VM (e.g., AWS EC2), validate connectivity and operations, and  explore Sentinel for high availability.

---

 ## 3. Pre-requisites

| Requirement | Description                                                      |
|-------------|------------------------------------------------------------------|
| AWS Account  | Create EC2 instances                                            |
| OS          | Ubuntu 24.04                                                     |                                        
| Access     | SSH client (PuTTY/Linux terminal), browser                        |
| Knowledge   | Basic Linux commands, cloud networking                           |

---

 ## 4. Infra Provisioning (Cloud Setup)
- Launch EC2 Instances:

   One for Redis server.

---

- Connect to Instance:

   Use SSH: 
```bash
ssh -i your-key.pem ubuntu@<EC2-Public-IP>
```

---

## 5. Redis-installation

 - Update system
```bash
sudo apt update
```
- Install Redis 

```bash
sudo apt install -y redis-server
```

- Check Version 
```bash
redis-server --version
```
<img width="700" height="68" alt="image" src="https://github.com/user-attachments/assets/89d4e591-132b-4b1c-9fab-d5c7f469a940" />


## 6. Redis-configuration

```bash
sudo nano /etc/redis/redis.conf
```
- Key settings to update:

```bash
bind 0.0.0.0
protected-mode no
requirepass YourStrongPassword
appendonly yes
```

---

- Restart Redis:
```bash
sudo systemctl restart redis
sudo systemctl status redis-server
```
<img width="700" height="600" alt="image" src="https://github.com/user-attachments/assets/5bfdb96d-e577-4aa6-bd6c-b38b8cab27f7" />


```bash
sudo systemctl enable redis
```
---
## 7. Verification-steps-ping-setget
   From the same instance:

```bash
redis-cli
```
---
```bash
127.0.0.1:6379> PING
```
- output PONG
<img width="700" height="57" alt="image" src="https://github.com/user-attachments/assets/eacdddf6-3818-452b-afc9-f5ab6e8c6a10" />


---
```bash
127.0.0.1:6379> SET name "Tina Bhatnagar"
```
- output OK
<img width="700" height="93" alt="image" src="https://github.com/user-attachments/assets/b50bb811-3ffc-4e77-babe-4b2b7505f2a9" />


--- 
```bash
127.0.0.1:6379> GET name
```
- output "Tina Bhatnagar"
<img width="700" height="93" alt="image" src="https://github.com/user-attachments/assets/0765a596-7e9f-461a-9a45-f7dc8c4a65b5" />

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

| Issue                         | Cause                        | Resolution                                      |
|------------------------------|------------------------------|--------------------------------------------------|
| Cannot connect to Redis      | Port blocked                 | Update SG (Security Group) or `bind` config      |
| Authentication failure       | Wrong password               | Use `requirepass` value in Redis CLI             |
| Redis not starting           | Misconfig in `redis.conf`    | Check logs: `/var/log/redis/redis-server.log`    |
| Sentinel not detecting master| Wrong IP or port in config   | Validate IP, port, and `auth-pass` settings      |

---

## 10. Conclusion
This POC shows how Redis can be manually installed and configured on a cloud virtual machine. It covers the basic setup, connectivity checks like ping and get/set operations, and explains how to make Redis secure. Optional high availability using Sentinel is also explored.

---

## 11. Frequently Asked Questions (FAQs)

**1. Redis ka default port kya hota hai?**  
Redis by default **6379** port pe run hota hai. Agar dusre port pe chalana hai, toh `redis.conf` me `port` value change karo.

**2. Redis ko password ke sath secure kaise karein?**  
`redis.conf` me `requirepass YourStrongPassword` set karo, fir `redis-cli` me connect hote waqt `AUTH YourStrongPassword` chalana padega.

**3. Redis ko remote machine se kaise access karein?**  
`bind 0.0.0.0` set karo, `protected-mode no` rakho, aur Security Group me port **6379** allow karo. Dhyan rahe strong password use ho.

**4. Redis me data permanently store kaise hota hai?**  
AOF (`appendonly yes`) ya RDB snapshot enable karke data disk pe save hota hai. POC me humne AOF enable kiya.

**5. Redis service ko restart karne ka sahi tarika kya hai?**  
Changes ke baad:
```bash
sudo systemctl daemon-reload
sudo systemctl restart redis
sudo systemctl status redis
```
---

## 12. Contact Information

| Name| Email Address      | GitHub | URL |
|-----|--------------------------|-------------|---------|
| Tina Bhatnagar | [tina.bhatnagar@mygurukulam.co](mailto:tina.bhatnagar@mygurukulam.co)|  tina-snatak  | https://github.com/tina-snatak/ |

---

## 13. References

| Title                    | Link                                                                 |
|--------------------------|----------------------------------------------------------------------|
| Official Redis Docs      | [Visit](https://redis.io/docs/)                                      |
| Redis Tutorial           | https://www.tutorialspoint.com/redis/index.htm                       |




