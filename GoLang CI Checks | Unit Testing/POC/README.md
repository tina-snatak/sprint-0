# **GoLang CI Checks – Unit Testing POC**

---

##  Author Information

| **Author**   | **Created on** | **Version** | **Last updated by** | **Last edited on** | **Level** | **Reviewer**  |
|--------------|----------------|-------------|---------------------|--------------------|-----------|---------------|
| Tina Bhatnagar  | 21-08-25    | v1.0  |  Tina Bhatnagar |21-08-25     | Internal    | Rohit Chopra    |

---

## **Table of Contents**

1. [Introduction](#1-introduction)  
2. [Pre-requisites](#2-pre-requisites)  
3. [System Requirements](#3-system-requirements)  
4. [Step-by-Step Instructions](#4-step-by-step-instructions)  
   * [4.1 Setup Unit Testing](#41-setup-unit-testing)  
   * [4.2 Create Sample Unit Test](#42-create-sample-unit-test)  
   * [4.3 Run Unit Tests Locally](#43-run-unit-tests-locally)  
   * [4.4 Configure CI for Unit Testing](#44-configure-ci-for-unit-testing)  
   * [4.5 Run CI Pipeline](#45-run-ci-pipeline)  
5. [Conclusion](#5-conclusion)  
6. [Contact Information](#6-contact-information)  
7. [References](#7-references)  

---

## **1. Introduction**

This POC demonstrates **unit testing for GoLang** integrated into a CI pipeline using **`go test`**. Every code commit triggers automated tests, ensuring functional correctness and early bug detection.

The document provides step-by-step instructions to set up unit tests locally, integrate them into a CI pipeline, and validate results, serving as a reference for developers and DevOps teams.

---

## **2. Pre-requisites**

| **Requirement**           | **Details**                          |
|----------------------------|--------------------------------------|
| GoLang                    | Installed (1.20+ recommended)        |
| Project                   | Existing Go project or sample project |
| Environment               | Terminal / Command-line access       |
| CI/CD Platform            | Access to CI/CD platform (GitHub Actions recommended) |

---

## 3. System Requirements  

| Requirement   | Minimum                                         | Recommended                                       |
|---------------|-------------------------------------------------|---------------------------------------------------|
| CPU           | Dual-core 2 GHz (1 vCPU)                        | 2+ vCPU                                           |
| RAM           | 4 GB                                            | 8 GB (for larger CI pipelines)                    |
| Disk Space    | 1 GB free (Go modules + build cache)            | 5+ GB (for bigger projects and reports)           |
| OS            | Ubuntu 20.04 LTS / Windows 10 / macOS 12+       | Ubuntu 22.04 LTS / Windows 11 / macOS 13+         |
| Go Version    | Go 1.20                                         | Latest stable Go version                          |
| Git           | Git CLI installed (latest stable)               | Git CLI (auto-updated to latest version)          |
| CI/CD Tool    | GitHub Actions / GitLab CI / Jenkins            | GitHub Actions (preferred for this POC)           |

---


## **4. Step-by-Step Instructions**

### **4.1 Setup Unit Testing**

GoLang comes with a built-in testing framework (`go test`). No additional installation is required for basic tests.
For advanced assertions or mocks, optionally install:

```bash
go get github.com/stretchr/testify
go get github.com/golang/mock/gomock
```
<img width="600" height="206" alt="image" src="https://github.com/user-attachments/assets/15592fea-c02d-466e-828a-a5ed10b43b63" />

---

### **4.2 Create Sample Unit Test**

Create a simple function `calculator.go`:

```go
package calculator

func Add(a, b int) int {
    return a + b
}
```

Create a test file `calculator_test.go`:

```go
package calculator

import "testing"

func TestAdd(t *testing.T) {
    result := Add(2, 3)
    expected := 5
    if result != expected {
        t.Errorf("Add(2,3) = %d; want %d", result, expected)
    }
}
```

---

### **4.3 Run Unit Tests Locally**

Run all tests:

```bash
go test ./...
```

Check code coverage:

```bash
go test -cover ./...
```
<img width="600" height="469" alt="image" src="https://github.com/user-attachments/assets/2284d9c7-c148-4a40-922f-70151cddae7d" />

---

### **4.4 Configure CI for Unit Testing**

**GitHub Actions YAML** (`.github/workflows/go-ci.yml`):

```yaml
name: GoLang CI - Unit Tests

on:
  push:
    branches: [ "main" ]
  pull_request:
    branches: [ "main" ]

jobs:
  test:
    runs-on: ubuntu-latest
    steps:
      - name: Checkout code
        uses: actions/checkout@v3

      - name: Setup Go
        uses: actions/setup-go@v4
        with:
          go-version: '1.20'

      - name: Install dependencies
        run: go mod tidy

      - name: Run Unit Tests
        run: go test -v ./...
```

This workflow ensures that every push or pull request triggers unit tests automatically.

---

### **4.5 Run CI Pipeline**

1. Push your changes to the repository.
2. CI pipeline triggers automatically.
3. Review logs and confirm all tests pass before merging.

---

## **5. Conclusion**

This POC validates **`go test`** as the primary tool for unit testing in GoLang CI pipelines. Automated unit testing ensures early bug detection, reliable code, and integration-ready workflows.

Following this approach provides faster feedback for developers and improves code quality in CI/CD environments.

> **Chosen Tool:** `go test`

---

## 6. Contact information


| Name| Email Address      | GitHub | URL |
|-----|--------------------------|-------------|---------|
| Tina Bhatnagar | [tina.bhatnagar@mygurukulam.co](mailto:tina.bhatnagar@mygurukulam.co)|  tina-snatak  | https://github.com/tina-snatak/ |

---

## **7. References**

| Reference                    | Link                                                                                                                                                     | Type                   |
| ---------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------- |
| Go Testing Docs              | [https://pkg.go.dev/testing](https://pkg.go.dev/testing)                                                                                                 | Official Documentation |
| Testify GitHub               | [https://github.com/stretchr/testify](https://github.com/stretchr/testify)                                                                               | Library / Mocks        |
| GoMock                       | [https://github.com/golang/mock](https://github.com/golang/mock)                                                                                         | Library / Mocks        |

---
