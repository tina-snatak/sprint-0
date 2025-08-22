# GoLang CI Checks: Bugs Analysis POC

## Author Information

| Created by | Created on | Version | Last Updated On | Pre Reviewer | L0 Reviewer | L1 Reviewer | L2 Reviewer |
| ---------- | ---------- | ------- | --------------- | ------------ | ----------- | ----------- | ----------- |
| Sonal      | 11-08-2025 | V 1.0   | 11-08-2025      | Anjali       |             |             |             |

---

## Table of Contents

* [Introduction](#introduction)
* [Prerequisites](#prerequisites)
* [Bugs Analysis Document](#bugs-analysis-document)
* [Step-by-Step Instructions](#step-by-step-instructions)

  * [Install and Configure golangci-lint](#install-and-configure-golangci-lint)
  * [Run Staticcheck for Deep Analysis](#run-staticcheck-for-deep-analysis)
  * [Run GoSec for Security Checks](#run-gosec-for-security-checks)
  * [Generate and View Reports](#generate-and-view-reports)
* [Conclusion](#conclusion)
* [Contact Information](#contact-information)
* [Reference Table](#reference-table)

---

## Introduction

This POC demonstrates how to integrate **GoLang linting, static analysis, and security scanning** into a CI pipeline to detect bugs and vulnerabilities **before code is merged**.
It uses a combination of **golangci-lint** (multi-linter), **Staticcheck** (bug & performance analysis), and **GoSec** (security checks).

---

## Prerequisites

* Go 1.20+ installed (`go version`)
* Access to the Go project (employee-api with go.mod)

---

## Bugs Analysis Document

Refer to the detailed [GoLang CI Checks – Bugs Analysis](https://github.com/Snaatak-Cloudops-Crew/documentation/blob/SCRUM-168-Sonal/Applications/CI-Design/GoLang-CI-Checks/Bugs-Analysis/Introduction/README.md) for:
*"What are CI Checks, Why Important, Workflow Diagram, Tools, Comparison, Advantages, and Best Practices"*.

---

## Step-by-Step Instructions

### Install and Configure golangci-lint

#### Step 1: Install golangci-lint (latest version)

```bash
curl -sSfL https://raw.githubusercontent.com/golangci/golangci-lint/master/install.sh \
  | sh -s -- -b $(go env GOPATH)/bin v1.54.2
```

<img width="998" height="128" alt="Screenshot 2025-08-19 122205" src="https://github.com/user-attachments/assets/2414eb9c-2feb-4446-b185-d1526ca93d20" />


#### Step 2: Verify Installation

```bash
golangci-lint --version
```

<img width="727" height="62" alt="Screenshot 2025-08-19 122344" src="https://github.com/user-attachments/assets/e66df965-305a-47b0-a08f-f148164fd740" />



#### Step 3: Run Lint Check

```bash
golangci-lint run ./...
```
<img width="870" height="504" alt="Screenshot 2025-08-19 122714" src="https://github.com/user-attachments/assets/dd9a7f57-2829-48d9-b413-53692ffbeea1" />



---

### Run Staticcheck for Deep Analysis


#### Step 1: Install Staticcheck

```bash
go install honnef.co/go/tools/cmd/staticcheck@latest
```

<img width="682" height="156" alt="Screenshot 2025-08-19 122942" src="https://github.com/user-attachments/assets/1c8b5a7f-8968-4ab4-b02a-cd4490d99937" />


#### Step 2: Verify Installation

```bash
staticcheck -version
```
<img width="442" height="53" alt="Screenshot 2025-08-19 124303" src="https://github.com/user-attachments/assets/1f0675dd-2562-42a4-8e82-aa41a9e5625a" />



#### Step 3: (Recommended) Ensure Modules Are Up to Date

```bash
go mod tidy
go mod download
```



#### Step 4: Run Analysis

```bash
staticcheck ./...
```

<img width="642" height="122" alt="Screenshot 2025-08-19 123339" src="https://github.com/user-attachments/assets/1edec6ce-81a6-4e73-a8d9-ee5781fda376" />


---

### Run GoSec for Security Checks

#### Step 1: Install GoSec

```bash
go install github.com/securego/gosec/v2/cmd/gosec@latest
```
<img width="708" height="124" alt="Screenshot 2025-08-19 123400" src="https://github.com/user-attachments/assets/13d6b6fa-4c96-4e34-9c0a-2b6a8999cbe5" />



#### Step 2: Verify Installation

```bash
gosec --version
```

#### Step 3: Run Security Scan

```bash
gosec ./...
```

<img width="708" height="465" alt="Screenshot 2025-08-19 123525" src="https://github.com/user-attachments/assets/f87547f4-3ec5-4ac8-bcd4-254dc9c9cf3a" />

<img width="837" height="678" alt="Screenshot 2025-08-19 123539" src="https://github.com/user-attachments/assets/81735a45-a570-44e5-8308-c32fcd470808" />

<img width="787" height="231" alt="Screenshot 2025-08-19 123549" src="https://github.com/user-attachments/assets/eeb2b728-cc54-442b-baa1-6c18fef9a210" />

---

### Generate and View Reports

* **golangci-lint** → Shows style & bug issues in terminal output
* **Staticcheck** → Highlights bugs, performance & unused code
* **GoSec** → Produces security scan results (can be saved as JSON/HTML)

Example saving GoSec report:

```bash
gosec -fmt=json -out=gosec-report.json ./...
```

---

## Conclusion

This POC validated the **bug and security analysis workflow** for the Employee API using:

* **golangci-lint** (style, linting, unused code)
* **Staticcheck** (bug & performance issues)
* **GoSec** (security vulnerabilities)

By running these tools locally (and later in CI), teams can **detect redundant code, unhandled errors, and security risks early**, ensuring safer integration with the **frontend React app**.



---

## Contact Information

| Name  | Email                                                                         |
| ----- | ----------------------------------------------------------------------------- |
| Sonal | [sonal.roha.snaatak@mygurukulam.co](mailto:sonal.roha.snaatak@mygurukulam.co) |

---

## Reference Table

| Links                                            | Overview                            |
| ------------------------------------------------ | ----------------------------------- |
| [golangci-lint Docs](https://golangci-lint.run/) | Multi-linter for Go                 |
| [Staticcheck Docs](https://staticcheck.io/docs/) | Advanced bug & performance analysis |
| [GoSec Docs](https://github.com/securego/gosec)  | Security scanner for Go code        |
| [Go Testing Docs](https://pkg.go.dev/testing)    | Unit testing in Go                  |
