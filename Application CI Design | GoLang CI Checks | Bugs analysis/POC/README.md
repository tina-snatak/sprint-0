<img width="200" height="363" alt="image" src="https://github.com/user-attachments/assets/c9ad19f3-e3ff-42f0-9cfe-1885619878f2" />

# GoLang CI Checks: Bugs Analysis POC

##  Author Information

| **Author**   | **Created on** | **Version** | **Last updated by** | **Last edited on** | **Level** | **Reviewer**  |
|--------------|----------------|-------------|---------------------|--------------------|-----------|---------------|
| Tina Bhatnagar  | 21-08-25    | v1.0  |  Tina Bhatnagar |21-08-25     | Internal    | Rohit Chopra    |

---

## Table of Contents

1. [Introduction](#1-introduction)  
2. [Pre-requisites](#2-pre-requisites)  
3. [System Requirements](#3-system-requirements)  
4. [Setup and Execution](#4-setup-and-execution)  
   - [4.1 Clone the Repository](#41-clone-the-repository)  
   - [4.2 Install and Configure golangci-lint](#42-install-and-configure-golangci-lint)  
   - [4.3 Run Staticcheck for Deep Analysis](#43-run-staticcheck-for-deep-analysis)  
   - [4.4 Run GoSec for Security Checks](#44-run-gosec-for-security-checks)  
   - [4.5 Generate and View Reports](#45-generate-and-view-reports)  
5. [Conclusion](#5-conclusion)  
6. [Contact Information](#6-contact-information)  
7. [Reference Table](#7-reference-table)  



---

## 1. Introduction

This POC demonstrates how to integrate **GoLang linting, static analysis, and security scanning** into a CI pipeline to detect bugs and vulnerabilities **before code is merged**.
It uses a combination of **golangci-lint** (multi-linter), **Staticcheck** (bug & performance analysis), and **GoSec** (security checks).

---

## 2. Pre-requisites

| Requirement                  | Description                                      |
|-------------------------------|-------------------------------------------------|
| Go Version                     | 1.20+ installed (`go version`)                 |
| Project Access                 | Access to the Go project (employee-api with go.mod) |

---

## 3. System Requirements

| Requirement  | Minimum                               | Recommended                                  |
|--------------|--------------------------------------|---------------------------------------------|
| CPU          | 1 vCPU                                | 2+ vCPU                                     |
| RAM          | 2 GB                                   | 4+ GB                                       |
| Disk Space   | 2 GB (for CVE DB cache)               | 5+ GB (for large CVE database + reports)  |
| OS           | Ubuntu 20.04 LTS / Windows 10 / macOS 12+ | Ubuntu 22.04 LTS / Windows 11 / macOS 13+ |

---

## 4. Setup and Execution

#### 4.1 Clone the Repository
```
git clone https://github.com/OT-MICROSERVICES/employee-api.git
```
```
 cd employee-api
```

## 4.2 Install and Configure golangci-lint

#### Step 1: Install golangci-lint (latest version)
```
sudo apt update
sudo apt install golang-go -y
```

#### Step 2: Install golangci-lint (latest version)

```bash
curl -sSfL https://raw.githubusercontent.com/golangci/golangci-lint/master/install.sh \
  | sh -s -- -b $(go env GOPATH)/bin v1.54.2
```
<img width="600" height="123" alt="image" src="https://github.com/user-attachments/assets/73d6ef92-0abf-49fc-9245-9e1e5b44b6e1" />

```
 sudo snap install golangci-lint --classic
```
<img width="600" height="50" alt="image" src="https://github.com/user-attachments/assets/6ad63bc6-2fc8-46f5-996d-2a41b7035585" />


#### Step 3: Verify Installation

```bash
golangci-lint --version
```
<img width="600" height="55" alt="image" src="https://github.com/user-attachments/assets/509fcad7-1cd5-4ea9-a314-2d5a6e3ed912" />


#### Step 4: Run Lint Check

```bash
golangci-lint run ./...
```
<img width="600" height="808" alt="image" src="https://github.com/user-attachments/assets/2845d696-dec1-4ed1-be8f-4dcff963a53b" />

---

## 4.3 Run Staticcheck for Deep Analysis


#### Step 1: Install Staticcheck

```
go install honnef.co/go/tools/cmd/staticcheck@latest
```
```
 export PATH=$PATH:$(go env GOPATH)/bin
```

<img width="600" height="212" alt="image" src="https://github.com/user-attachments/assets/24f5b668-b29f-4ea0-86ef-3a18ee54f23c" />


#### Step 2: Verify Installation

```bash
staticcheck -version
```
<img width="600" height="47" alt="image" src="https://github.com/user-attachments/assets/7833dff7-f1b1-43bb-b39a-0eac912bf728" />



#### Step 3: (Recommended) Ensure Modules Are Up to Date

```bash
go mod tidy
go mod download
```

#### Step 4: Run Analysis

```bash
staticcheck ./...
```

<img width="600" height="120" alt="image" src="https://github.com/user-attachments/assets/61fb1e52-d3a0-440b-a051-7c705bcca118" />

---

## 4.4 Run GoSec for Security Checks

#### Step 1: Install GoSec

```bash
go install github.com/securego/gosec/v2/cmd/gosec@latest
```


#### Step 2: Verify Installation

```bash
gosec --version
```

<img width="600" height="89" alt="image" src="https://github.com/user-attachments/assets/ea729475-ceca-4243-9765-2308eaa58d53" />

#### Step 3: Run Security Scan

```bash
gosec ./...
```

<img width="600" height="727" alt="image" src="https://github.com/user-attachments/assets/c6a67b60-0211-4e29-b370-efe7d5d0f6fe" />

<img width="600" height="958" alt="image" src="https://github.com/user-attachments/assets/0a2067dd-f945-4b59-87c3-3f45e83019d2" />

---

## 4.5 Generate and View Reports

| Tool            | Purpose / Output                                         |
|-----------------|----------------------------------------------------------|
| golangci-lint   | Shows style and bug issues directly in the terminal output |
| Staticcheck     | Highlights bugs, performance issues, and unused code    |
| GoSec           | Produces security scan results (can be saved as JSON/HTML) |

Example saving GoSec report:

```bash
gosec -fmt=json -out=gosec-report.json ./...
```
<img width="600" height="710" alt="image" src="https://github.com/user-attachments/assets/c3c59cdb-9adf-45dd-8167-35259e0484c5" />

---

## 5. Conclusion

| Tool            | Purpose / Output                                               |
|-----------------|---------------------------------------------------------------|
| golangci-lint   | Style checks, linting, and detection of unused code          |
| Staticcheck     | Detection of bugs and performance issues                     |
| GoSec           | Identification of security vulnerabilities                  |

**Summary:**  
Running these tools locally (and later in CI) helps teams **detect redundant code, unhandled errors, and security risks early**, ensuring safer integration with the **frontend React app**.



---

## 6. Contact information


| Name| Email Address      | GitHub | URL |
|-----|--------------------------|-------------|---------|
| Tina Bhatnagar | [tina.bhatnagar@mygurukulam.co](mailto:tina.bhatnagar@mygurukulam.co)|  tina-snatak  | https://github.com/tina-snatak/ |

---

## 7. Reference Table

| Links                                            | Overview                            |
| ------------------------------------------------ | ----------------------------------- |
| [golangci-lint Docs](https://golangci-lint.run/) | Multi-linter for Go                 |
| [Staticcheck Docs](https://staticcheck.io/docs/) | Advanced bug & performance analysis |
| [GoSec Docs](https://github.com/securego/gosec)  | Security scanner for Go code        |
| [Go Testing Docs](https://pkg.go.dev/testing)    | Unit testing in Go                  |
