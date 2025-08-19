#  POC for React CI Check Bugs Analysis 

##   Author Information

| **Author**   | **Created on** | **Version** | **Last updated by** | **Last edited on** | **Level** | **Reviewer**  |
|--------------|----------------|-------------|---------------------|--------------------|-----------|---------------|
| Tina Bhatnagar  | 17-08-25    | v1.0  |  Tina Bhatnagar |17-08-25     | Internal    | Rohit Chopra    |


- [Introduction](#-introduction)  
- [Setup Instructions](#-setup-instructions)  
  - [Install SonarQube Locally](#install-sonarqube-locally)  
  - [Configure SonarQube Project](#configure-sonarqube-project)  
  - [Install SonarScanner](#install-sonarscanner)  
  - [Create `sonar-project.properties`](#create-sonar-projectproperties)  
  - [Run the Analysis](#run-the-analysis)  
  - [Conclusion](#conclusion)
- [Contacts](#contacts)  
- [References](#references)

---

## 1. Introduction

This Proof of Concept (POC) demonstrates how to analyze a **React codebase using SonarQube** for detecting bugs, vulnerabilities, and code smells — **without CI tools like Jenkins, GitHub Actions, Docker, or YAML pipelines**.

---

## 2.  Setup Instructions

- ####  Install SonarQube Locally

Before setting up, make sure the following packages and tools are installed:

- #### Update system & install basic tools
```
sudo apt update
sudo apt install -y ca-certificates curl gnupg lsb-release unzip ufw
```

- #### Install Node.js LTS (Recommended for JS analysis)
```
curl -fsSL https://deb.nodesource.com/setup_lts.x | sudo -E bash -
sudo apt install -y nodejs
```

- #### Verify installation
```
node -v
```
- #### Install Docker

```
# Install Docker 
sudo apt-get install -y apt-transport-https software-properties-common
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
sudo add-apt-repository \
  "deb [arch=amd64] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable"
sudo apt update
sudo apt install -y docker-ce docker-ce-cli containerd.io
docker --version
```
- #### Run SonarQube

```bash
docker run -d --name sonarqube -p 9000:9000 sonarqube:lts
```
<img width="600" height="327" alt="image" src="https://github.com/user-attachments/assets/ea6d2cdd-f4eb-498e-abdc-1b3a1895aa0a" />

Access the dashboard at:  
`http://localhost:9000`  
(Default login: `admin` / `admin`)

---

- ####  Configure SonarQube Project

1. Log in to the SonarQube dashboard.
2. Create a **new project**.
3. Note the **Project Key** and generate a **token** for authentication.

---

- ####  Install SonarScanner

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

- ####  Create `sonar-project.properties`

In the root of your React project, create a file:

```
sonar.projectKey=react-app
sonar.projectName=react-app
sonar.projectVersion=1.0
sonar.sources=src
sonar.language=js
sonar.sourceEncoding=UTF-8
sonar.host.url=http://<YOUR_PUBLIC_IP>:9000
sonar.login=<YOUR_GENERATED_TOKEN>
```

Replace `<YOUR_PUBLIC_IP>` with your real IP:
Replace `<YOUR_GENERATED_TOKEN>` with the token you generated in the UI.

<img width="600" height="309" alt="image" src="https://github.com/user-attachments/assets/60664a52-4d18-4d85-a314-4d7ee0534eb3" />



---

- ####   Run the Analysis

```bash
sonar-scanner
```
<img width="600" height="294" alt="image" src="https://github.com/user-attachments/assets/39d7812a-cbb3-47c7-992f-836d322759ca" />
<img width="600" height="557" alt="image" src="https://github.com/user-attachments/assets/03e70645-5dbc-42a9-887c-f5318c056466" />


- #### You can see the bugs by the URL

```bash

http://65.2.168.91:9000/dashboard?id=react-app

```
<img width="600" height="966" alt="image" src="https://github.com/user-attachments/assets/be68ddf3-c88d-41a3-bfe1-4289af4e7006" />


**Note**- Change here with your public IP

---

## 3. Conclusion

This POC successfully demonstrates how to perform bug analysis and code quality checks on a React application using SonarQube without any CI/CD tools. By manually configuring and running the scanner, developers can identify bugs, vulnerabilities, and code smells early in the development cycle.

---

## 4. Contacts


| Name| Email Address      | GitHub | URL |
|-----|--------------------------|-------------|---------|
| Tina Bhatnagar | [tina.bhatnagar@mygurukulam.co](mailto:tina.bhatnagar@mygurukulam.co)|  tina-snatak  | https://github.com/tina-snatak/ |

---

## 5.  References

| Title                   | Link                                                                 |
|-------------------------|----------------------------------------------------------------------|
| SonarQube Documentation | [https://docs.sonarsource.com/sonarqube/](https://docs.sonarsource.com/sonarqube/) |
| SonarScanner CLI        | [https://docs.sonarsource.com/latest/scanners/sonarscanner/](https://docs.sonarsource.com/latest/scanners/sonarscanner/) |
| ESLint Formatters       | [https://eslint.org/docs/latest/use/formatters/](https://eslint.org/docs/latest/use/formatters/) |
