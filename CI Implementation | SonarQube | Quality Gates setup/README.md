#  SonarQube- Quality Gates setup

##   Author Information

| **Author**   | **Created on** | **Version** | **Last updated by** | **Last edited on** | **Level** | **Reviewer**  |
|--------------|----------------|-------------|---------------------|--------------------|-----------|---------------|
| Tina Bhatnagar  | 8-09-25    | v1.0         |  Tina Bhatnagar |8-09-25     | Internal   | Rohit Chopra    |



# Table of Contents  

1. [Introduction](#1-introduction)
2. [Prerequisites](#2-Prerequisites)
3. [System Requirements](#3-System-Requirements)
4. [Setup Instructions](#4-setup-instructions)  
   4.1 [Install SonarQube Locally](#41-install-sonarqube-locally)  
   4.2 [Configure SonarQube Project](#42-configure-sonarqube-project)  
   4.3 [Install SonarScanner](#43-install-sonarscanner)  
   4.4 [Create sonar-project.properties](#44-create-sonar-projectproperties)
   4.5 [Set up quality gates](#45-set-up-quality-gates)
   4.6 [Run the Analysis](#46-run-the-analysis)  
6. [Conclusion](#5-conclusion)
7. [Troubleshooting](#6-Troubleshooting) 
8. [Contacts](#7-contacts)  
9. [References](#8-references)  



---

## 1. Introduction

This document demonstrates manual setup of **SonarQube Quality Gates** for analyzing code quality and identifying bugs, vulnerabilities, and code smells

---
## 2. Prerequisites

| Dependency            | Version                   |
| --------------------- | ------------------------- |
| **Java**              | JDK 11+                   |
| **SonarQube**         | v9.x or above             |
| **SonarQube Scanner** | Latest compatible version |

---

## 3. System Requirements

| Hardware/Software | Minimum Recommendation                     |
| ----------------- | ------------------------------------------ |
| **Processor**     | 2 CPU cores                                |
| **RAM**           | 4 GiB                                      |
| **Disk**          | 10 GB                                      |
| **OS**            | Ubuntu 22.04 LTS / Windows 10+ / macOS 11+ |

---

## 4. Setup Instructions

 #### 4.1 Install SonarQube Locally

To install the Sonarqube follow this [link](https://github.com/Snaatak-Apt-Get-Swag/documentation/blob/SCRUM-181-sharik/Applications/CI-Design/Sonarqube/Software-Configuration/README.md)
Make sure it runs locally or on a server accessible via browser:
```
http://<YOUR_PUBLIC_IP>:9000
```

 #### 4.2 Configure SonarQube Project

1. Log in to the SonarQube dashboard.
2. Create a **new project**.
3. Note the **Project Key** and generate a **token** for authentication.

---

 #### 4.3 Install SonarScanner

 ```
sudo apt install unzip
```

```bash
# Download & install
wget https://binaries.sonarsource.com/Distribution/sonar-scanner-cli/sonar-scanner-cli-5.0.1.3006-linux.zip
unzip sonar-scanner-cli-5.0.1.3006-linux.zip
sudo mv sonar-scanner-*/ /opt/sonar-scanner

# Make it available on PATH
echo 'export PATH=$PATH:/opt/sonar-scanner/bin' >> ~/.bashrc
source ~/.bashrc
sonar-scanner -v

```
<img width="600" height="731" alt="image" src="https://github.com/user-attachments/assets/973de0d6-43d8-4ae7-85da-e035c1929447" />
<img width="600" height="138" alt="image" src="https://github.com/user-attachments/assets/886cb47d-d61e-4e56-b280-0a840e5224d3" />

---

 #### 4.4 Create `sonar-project.properties`

In the root of your React project, create a file:

```
sonar.projectKey=my-project
sonar.projectName=my-project
sonar.projectVersion=1.0
# Analyze the following folders in your Python/Flask project
sonar.sources=app.py,models,router,utils,scripts
# Python code
sonar.language=py
sonar.sourceEncoding=UTF-8
sonar.host.url=http://<YOUR_PUBLIC_IP>:9000
sonar.login=<YOUR_GENERATED_TOKEN>

```

Replace `<YOUR_PUBLIC_IP>` with your real IP:
Replace `<YOUR_GENERATED_TOKEN>` with the token you generated in the UI.

<img width="600" height="299" alt="image" src="https://github.com/user-attachments/assets/fdaf0a49-fc0c-4f2a-ae25-4904445eb345" />


---
#### 4.5 Set up quality gates

<img width="700" height="782" alt="image" src="https://github.com/user-attachments/assets/b39b3492-0524-4fde-97af-f8418a21c0d0" />


 #### 4.6 Run the Analysis

```bash
sonar-scanner
```
<img width="600" height="269" alt="image" src="https://github.com/user-attachments/assets/9b6b1170-9ab7-4976-8c61-84b5f3d531a4" />

<img width="600" height="445" alt="image" src="https://github.com/user-attachments/assets/247f514b-040b-4ba4-b6f4-f7a579aed539" />



- #### You can see the Quality Gates

```bash

http://13.53.138.136:9000/projects

```
<img width="600" height="778" alt="image" src="https://github.com/user-attachments/assets/d7035070-9504-4537-9c75-9320f57e6b9a" />


**Note**- Change here with your public IP

---

## 5. Conclusion

This POC demonstrates how SonarQube Quality Gates can be used to monitor code quality and detect issues early in a React application. Manual analysis ensures developers can catch bugs, vulnerabilities, and code smells before deployment.

---


## 6. Troubleshooting

| Issue | Possible Cause | Solution |
|-------|----------------|----------|
| SonarQube service not starting | Insufficient RAM (needs 2GB+ free) | Allocate more memory or increase swap space |
| Port 9000 not accessible | Firewall blocking / Security Group not open | Allow inbound traffic on port 9000 |
| "Java not found" error | Java not installed or PATH not set | Verify with `java -version` and install JDK 11+ |
| SonarScanner not recognized | PATH not updated | Run `source ~/.bashrc` or add scanner bin path manually |
| Authentication failed (token) | Wrong/expired token used | Regenerate token in SonarQube UI and update command |

---

## 7. Contacts


| Name| Email Address      | GitHub | URL |
|-----|--------------------------|-------------|---------|
| Tina Bhatnagar | [tina.bhatnagar@mygurukulam.co](mailto:tina.bhatnagar@mygurukulam.co)|  tina-snatak  | https://github.com/tina-snatak/ |

---

## 8. References

| Title                   | Link                                                                 |
|-------------------------|----------------------------------------------------------------------|
| SonarQube Documentation | [https://docs.sonarsource.com/sonarqube/](https://docs.sonarsource.com/sonarqube/) |
| SonarScanner CLI        | [https://docs.sonarsource.com/latest/scanners/sonarscanner/](https://docs.sonarsource.com/latest/scanners/sonarscanner/) |
