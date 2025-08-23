<img width="300" height="280" alt="image" src="https://github.com/user-attachments/assets/fff02623-3dd2-4fb3-83e7-836e83a247a2" />


# POC for Jenkins Installation 

##  Author Information

| **Author**   | **Created on** | **Version** | **Last updated by** | **Last edited on** | **Level** | **Reviewer**  |
|--------------|----------------|-------------|---------------------|--------------------|-----------|---------------|
| Tina Bhatnagar  | 22-08-25    | v1.0  |  Tina Bhatnagar |22-08-25     | Internal    | Rohit Chopra    |

---


## Table of Contents
1. [Introduction](#1-introduction)  
2. [Pre-requisites](#2-pre-requisites)  
3. [System Requirements](#3-system-requirements)  
4. [Installation Steps](#4-installation-steps)  
5. [Post-installation](#5-post-installation)  
6. [Conclusion](#6-conclusion)
7. [Troubleshooting](#7-troubleshooting)  
8. [Contact Information](#8-contact-information)  
9. [References](#9-references)  

---

## 1. Introduction

This document outlines the Proof of Concept (POC) for setting up Jenkins manually on a Linux-based system without using automation tools such as Ansible. The purpose of this POC is to validate the core installation steps, ensure Jenkins runs successfully, and provide hands-on understanding of its configuration. Additionally, this document acts as a foundation for the upcoming sprint, where an Ansible role will be developed and implemented to automate the Jenkins installation process. The manual setup covered here will help ensure that the automated role behaves as expected.

---

## 2. Pre-requisites

| Requirement              | Minimum Version / Details |
|--------------------------|----------------------------|
| **Java**                 | OpenJDK 17                 |
| **Port Availability**    | Port **8080** must be open |


---

## 3. System Requirements

| Component       | Minimum Requirements             |
|-----------------|----------------------------------|
| AWS Instance    | t2.medium (recommended)          |
| vCPUs           | 2                                |
| RAM             | 4 GB                             |
| Storage         | 20 GB EBS                        |
| OS              | Ubuntu 22.04 LTS or later        |

---


## 4. Installation Steps

### Step 1: Update system
```bash
sudo apt update
```

### Step 2: Install Java (OpenJDK 17)
```bash
sudo apt install openjdk-17-jdk -y
```

<img width="600" height="163" alt="image" src="https://github.com/user-attachments/assets/074b7ab4-8233-4259-9c4b-89d843a2eeea" />


### Step 3: Add Jenkins repo key securely
```bash
curl -fsSL https://pkg.jenkins.io/debian-stable/jenkins.io-2023.key | sudo tee /usr/share/keyrings/jenkins-keyring.asc > /dev/null
```


### Step 4: Add Jenkins source list
```bash
echo deb [signed-by=/usr/share/keyrings/jenkins-keyring.asc] https://pkg.jenkins.io/debian-stable binary/ | sudo tee /etc/apt/sources.list.d/jenkins.list > /dev/null
```

### Step 5: Update again
```bash
sudo apt update
```

### Step 6: Install Jenkins
```bash
sudo apt install jenkins -y
```

<img width="600" height="185" alt="image" src="https://github.com/user-attachments/assets/24f78721-14ed-41cd-bd74-eca188d666ef" />


### Step 7: Start Jenkins
```bash
sudo systemctl start jenkins
sudo systemctl enable jenkins
```

### Step 8: Check Jenkins status
```bash
sudo systemctl status jenkins
```
<img width="600" height="486" alt="image" src="https://github.com/user-attachments/assets/f64d9cd2-2ef3-4e3f-abaa-cbd0fddf6efd" />

---

## 5. Post-installation

### step-1 Open Jenkins in browser:
```
http://<your-server-ip>:8080
```
<img width="600" height="691" alt="image" src="https://github.com/user-attachments/assets/527017ae-8e77-430d-8dbd-39b78b49eff8" />



### step-2 Retrieve admin password:
```bash
sudo cat /var/lib/jenkins/secrets/initialAdminPassword
```

<img width="600" height="46" alt="image" src="https://github.com/user-attachments/assets/15f90411-1e3b-4e88-b9bf-18613a3c2a4b" />

<img width="600" height="887" alt="image" src="https://github.com/user-attachments/assets/4b476049-3f1e-4e11-8713-b3ddf5698228" />


---

## 6. Conclusion

This setup provides a foundational understanding of the Jenkins installation process, including repository configuration, service management, and accessing the Jenkins dashboard. Additionally, this document serves as a reference for creating an Ansible role to automate the installation in the next sprint. The automation implementation is planned for future execution, ensuring improved scalability, repeatability, and efficiency in Jenkins deployment workflows.

---

## 7. Troubleshooting


| **Issue**                                | **Resolution Steps**                                                                 |
|------------------------------------------|--------------------------------------------------------------------------------------|
| Port 8080 not accessible                  | - Ensure inbound rule for **port 8080** is open in AWS Security Group.<br>- Run `sudo ufw allow 8080`. |
| Jenkins service not starting              | - Check logs: `sudo journalctl -u jenkins -xe`.<br>- Verify Java version compatibility. |
| Java version mismatch                     | - Remove old Java: `sudo apt remove openjdk-*`.<br>- Install Java 17: `sudo apt install openjdk-17-jdk -y`. |
| `initialAdminPassword` file not found     | - Verify Jenkins installed correctly.<br>- Path: `/var/lib/jenkins/secrets/initialAdminPassword`. |

---

## 8. Contact information


| Name| Email Address      | GitHub | URL |
|-----|--------------------------|-------------|---------|
| Tina Bhatnagar | [tina.bhatnagar@mygurukulam.co](mailto:tina.bhatnagar@mygurukulam.co)|  tina-snatak  | https://github.com/tina-snatak/ |

---

## 9. References

| **Title**                      | **Link**                                                                 |
|-------------------------------|--------------------------------------------------------------------------|
| Steps to install Jenkins      | [GeeksforGeeks](https://www.geeksforgeeks.org/install-and-configure-jenkins-in-aws-ec2/) |
| Jenkins Official Website      | [Jenkins Plugins](https://plugins.jenkins.io/ec2/)                        |
