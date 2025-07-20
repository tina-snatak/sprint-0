# SOP for JQ – JSON Query Processor

<img width="828" height="431" alt="image" src="https://github.com/user-attachments/assets/b9e9d745-af06-4405-8b59-01c968130a4f" />

---

### Author Information

| Created by      | Created on     | Version          | Last updated ON   | pre Reviewer       | L0 Reviewer     | L1 Reviewer   |    L2 Reviewer                 |
|-----------------|----------------|------------------|-------------------|--------------------|-----------------|---------------|--------------------------------|
| Tina Bhatnagar  |  18-07-2025    | V 1.0            |     18-07-2025    |  Rohit Chopra      | Akshit/Nitik    |  Taran        |  Abhishek dubey/ Rishabh sharma|
---

### Table of Contents

1. [Prerequisites](#prerequisites)    
2. [Installation Guide](#installation-guide)  
   - [Check for Existing Installation](#check-for-existing-installation)  
   - [Ubuntu](#ubuntu)  
   - [RedHat](#redhat)  
   - [macOS](#macos)  
3. [Example JSON Data](#example-json-data)  
4. [Basic Usage](#basic-usage)  
5. [Advanced Queries](#advanced-queries)
6. [Use Cases](#use-cases)
7. [Known Errors in jq Usage](#known-errors-in-jq-usage)
8. [Conclusion](#conclusion)  
9. [Contact Information](#contact-information)  
10. [References](#references)  

---

## Introduction

This documentation outlines practical value of the jq command-line tool, highlighting why it was created, what it offers, and how its features align with modern data processing and automation requirements in software development.

---


## Prerequisites

- Basic understanding of JSON format  
- Terminal or Command Line Interface access  
- Internet access for installation (if not already installed)

---

## Installation Guide

- ### Check for Existing Installation
  > Before installing, check if jq is already present:

```bash
jq --version
```


If this command returns a version (e.g., jq-1.6), you already have it installed.

- ### Ubuntu
  > Update your system 

```bash
sudo apt install jq -y
```

<img width="765" height="235" alt="image" src="https://github.com/user-attachments/assets/5be418cf-cc6e-4874-bd39-afa3fa916e90" />


- ### RedHat

```bash
sudo yum install epel-release -y
sudo yum install jq -y
```

- ### macOS

```bash
brew install jq
```

---

## Example JSON Data

Save the following content in a file called data.json for practice:

```json
{
  "user": {
    "name": "Tina",
    "roles": ["admin", "editor"],
    "age": 23,
    "address": {
      "city": "Moradabad",
      "zip": "244001"
    }
  },
  "items": [
    {"id": 1, "name": "Item One"},
    {"id": 2, "name": "Item Two"}
  ]
}
```
<img width="547" height="427" alt="image" src="https://github.com/user-attachments/assets/4d71ca39-f9a6-4cf5-a01f-786446094714" />

---

## Basic Usage

- ### View Entire JSON
  > Prints the entire contents of the JSON file in a human-readable and color-formatted layout.

```bash
cat data.json | jq '.'
```
<img width="712" height="581" alt="image" src="https://github.com/user-attachments/assets/d1a78a57-1fe1-4fc2-ba5b-f99d7bf63a62" />


- ### Filter a Field
> Extracts and displays the value of the name field nested inside the user object.

```bash
jq '.user.name' data.json
```

<img width="741" height="82" alt="image" src="https://github.com/user-attachments/assets/7f9ab3c9-5bdf-4eb0-bf91-9ca45b0fadaa" />


---

## Advanced Queries

- ### Access Nested Values
> Accesses the nested city field inside address, which is itself a key inside the user object.

```bash
jq '.user.address.city' data.json
```

<img width="830" height="77" alt="image" src="https://github.com/user-attachments/assets/ee826f4f-63a5-462d-942e-a24b18d4099a" />



- ### Loop Over Arrays
> Iterates over each object in the items array and returns the value of the name key for each item.

```bash
jq '.items[] | .name' data.json
```

<img width="818" height="108" alt="image" src="https://github.com/user-attachments/assets/4f6827f0-63c4-4af4-b0c0-ee55afd39a51" />



- ### Search by Index Value

#### Query:
> Retrieves the first element (index 0) from the roles array within the user object.

```bash
jq '.user.roles[0]' data.json
```

<img width="771" height="72" alt="image" src="https://github.com/user-attachments/assets/6edbaada-047c-41d8-abb7-557b1d221675" />



---

## Use cases
| Scenario | How jq Helps |
|----------|---------------|
| Log Analysis in DevOps Pipelines | Quickly extract and format key data from JSON-formatted logs or API responses for monitoring tools. |
| REST API Response Parsing | Process JSON outputs from curl or other HTTP clients to extract relevant fields programmatically. |
| CI/CD Workflow Automation | Use in scripts to parse build metadata, environment variables, or deployment status in JSON format. |
| Configuration File Manipulation | Read or validate JSON-based config files used by tools like Docker Compose, Terraform, or Kubernetes. |
| Database Migration or Sync Scripts | Parse and transform JSON data exported from NoSQL databases like MongoDB for further automation. |
| Security Auditing | Filter large JSON outputs from security tools (e.g., AWS Inspector, audit logs) to extract vulnerabilities. |
| Cloud Resource Management | Process JSON responses from AWS CLI, Azure CLI, or GCP CLI to summarize or report resource states.|
| Data Transformation in ETL Pipelines | Clean, reshape, or enrich incoming JSON data as part of Extract-Transform-Load workflows. |
| Debugging Microservices | Decode structured log files or API payloads from microservices communicating in JSON. |
| Infrastructure as Code (IaC) Audits | Validate and inspect JSON-based state files from Terraform or CloudFormation. |

---

## Known Errors in jq Usage

This section outlines common issues users may encounter when using jq and how to resolve them.

---

- ###  File Not Found

```bash
jq '.' data.json
```
> jq: error: Could not open file data.json: No such file or directory


*Cause:* File data.json doesn't exist in the current directory. 

*Fix:* Ensure the file is present and the path is correct.

---

- ###  Invalid JSON Format

```bash
cat broken.json | jq '.'
```
> parse error: Unfinished JSON...


*Cause:* The JSON file is not properly formatted (e.g., missing commas, brackets, quotes).  

*Fix:* Validate the JSON using a linter or online JSON validator before using jq.

---

- ###  Null Output

```bash
jq '.user.phone' data.json
```
> null


*Cause:* The queried field does not exist in the JSON. 

*Fix:* Double-check the field name and structure. Use jq 'keys' or jq '.' to inspect structure first.

---

- ###  Index Out of Range

```bash
jq '.user.roles[5]' data.json
```
> null


*Cause:* You're accessing an index that doesn’t exist in the array. 

*Fix:* Use jq '.user.roles | length' to verify array size before indexing.

---

- ###  Permission Denied 

```bash
jq '.' /root/data.json
```
> jq: error: Could not open file /root/data.json: Permission denied


*Cause:* File is not readable by the current user.

*Fix:* Run with elevated permissions (e.g., sudo) or change file permissions.

---

## Conclusion 

jq bridges the gap between human-readable JSON and machine-level automation needs—allowing for cleaner, scalable, and more maintainable workflows.

---
## Contact Information

| Name           | Email address                                                         |
| -------------- | --------------------------------------------------------------------- |
| Tina Bhatnagar | [tina.bhatnagar@mygurukulam.co](mailto:tina.bhatnagar@mygurukulam.co) |
---

## References
| **Title**                        | **Link**                                        |
|----------------------------------|-------------------------------------------------|
| Official jq Manual | [Visit](https://stedolan.github.io/jq/manual/)  |
| jq GitHub Releases | [Visit](https://github.com/jqlang/jq/blob/master/)  |
