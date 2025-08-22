GoLang CI Checks: Bugs Analysis POC
image
Author Information
Created by 	Created on 	Version 	Last Updated On 	Pre Reviewer 	L0 Reviewer 	L1 Reviewer 	L2 Reviewer
Sonal 	11-08-2025 	V 1.0 	11-08-2025 	Anjali 			
Table of Contents

    Introduction

    Prerequisites

    Bugs Analysis Document

    Step-by-Step Instructions
        Install and Configure golangci-lint
        Run Staticcheck for Deep Analysis
        Run GoSec for Security Checks
        Generate and View Reports

    Conclusion

    Contact Information

    Reference Table

Introduction

This POC demonstrates how to integrate GoLang linting, static analysis, and security scanning into a CI pipeline to detect bugs and vulnerabilities before code is merged. It uses a combination of golangci-lint (multi-linter), Staticcheck (bug & performance analysis), and GoSec (security checks).
Prerequisites

    Go 1.20+ installed (go version)
    Access to the Go project (employee-api with go.mod)

Bugs Analysis Document

Refer to the detailed GoLang CI Checks – Bugs Analysis for: "What are CI Checks, Why Important, Workflow Diagram, Tools, Comparison, Advantages, and Best Practices".
Step-by-Step Instructions
Install and Configure golangci-lint
Step 1: Install golangci-lint (latest version)

curl -sSfL https://raw.githubusercontent.com/golangci/golangci-lint/master/install.sh \
  | sh -s -- -b $(go env GOPATH)/bin v1.54.2

Screenshot 2025-08-19 122205
Step 2: Verify Installation

golangci-lint --version

Screenshot 2025-08-19 122344
Step 3: Run Lint Check

golangci-lint run ./...

Screenshot 2025-08-19 122714
Run Staticcheck for Deep Analysis
Step 1: Install Staticcheck

go install honnef.co/go/tools/cmd/staticcheck@latest

Screenshot 2025-08-19 122942
Step 2: Verify Installation

staticcheck -version

Screenshot 2025-08-19 124303
Step 3: (Recommended) Ensure Modules Are Up to Date

go mod tidy
go mod download

Step 4: Run Analysis

staticcheck ./...

Screenshot 2025-08-19 123339
Run GoSec for Security Checks
Step 1: Install GoSec

go install github.com/securego/gosec/v2/cmd/gosec@latest

Screenshot 2025-08-19 123400
Step 2: Verify Installation

gosec --version

Step 3: Run Security Scan

gosec ./...

Screenshot 2025-08-19 123525 Screenshot 2025-08-19 123539 Screenshot 2025-08-19 123549
Generate and View Reports

    golangci-lint → Shows style & bug issues in terminal output
    Staticcheck → Highlights bugs, performance & unused code
    GoSec → Produces security scan results (can be saved as JSON/HTML)

Example saving GoSec report:

gosec -fmt=json -out=gosec-report.json ./...

Conclusion

This POC validated the bug and security analysis workflow for the Employee API using:

    golangci-lint (style, linting, unused code)
    Staticcheck (bug & performance issues)
    GoSec (security vulnerabilities)

By running these tools locally (and later in CI), teams can detect redundant code, unhandled errors, and security risks early, ensuring safer integration with the frontend React app.
Contact Information
Name 	Email
Sonal 	sonal.roha.snaatak@mygurukulam.co
Reference Table
Links 	Overview
golangci-lint Docs 	Multi-linter for Go
Staticcheck Docs 	Advanced bug & performance analysis
GoSec Docs 	Security scanner for Go code
Go Testing Docs 	Unit testing in Go
