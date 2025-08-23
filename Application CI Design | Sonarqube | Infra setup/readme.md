<img width="300" height="220" alt="image" src="https://github.com/user-attachments/assets/36afb877-b797-4912-8a76-2e2939bbe5fc" />



# Sonarqube Infra Diagram 

##  Author Information

| **Author**   | **Created on** | **Version** | **Last updated by** | **Last edited on** | **Level** | **Reviewer**  |
|--------------|----------------|-------------|---------------------|--------------------|-----------|---------------|
| Tina Bhatnagar  | 21-08-25    | v1.0  |  Tina Bhatnagar |21-08-25     | Internal    | Rohit Chopra    |

---

## Table of Contents

1. [Introduction](#introduction)
2. [Infra](#infra)
3. [Important ports](#important-ports)
4. [Conclusion](#conclusion)
5. [Contact Information](#contact-information)
3. [References](#references)

---

# Introduction
SonarQube is a powerful tool designed to continuously inspect your code quality and security. It performs automatic reviews through static code analysis, identifying bugs, vulnerabilities, and code smells in various programming languages. This documentation give details of infra.

---

# Infra






---

# Important ports



| **Port** | **Used By**         | **Purpose**                                         |
|----------|---------------------|-----------------------------------------------------|
| 9000     | SonarQube Web UI    | Access SonarQube Dashboard via browser              |
| 22       | SSH                 | Remote login to SonarQube server (for admin access) |
| 80       | HTTP         | Used by ALB to receive unencrypted web traffic |
| 443      | HTTPS        | Used by ALB to receive encrypted web traffic |

---

# Conclusion
SonarQube infrastructure map offers a holistic view of the components that interact within the system, ensuring an effective and scalable solution for continuous code quality monitoring and improvement.

---

## 6. Contact information


| Name| Email Address      | GitHub | URL |
|-----|--------------------------|-------------|---------|
| Tina Bhatnagar | [tina.bhatnagar@mygurukulam.co](mailto:tina.bhatnagar@mygurukulam.co)|  tina-snatak  | https://github.com/tina-snatak/ |

---


---

# References


| **Title** | **Link** |
|----------------------------------------------------|--------------------|
| Sonar Setup|[Link](https://dev.to/sagary2j/sonarqube-infrastructure-setup-using-aws-ec2-and-postgresql-3lpb) |
|Sonar HA | [link](https://community.sonarsource.com/t/sonarqube-community-edition-high-availability/117618) |











Message Yuvraj Poonia
