<img width="325" height="180" alt="image" src="https://github.com/user-attachments/assets/f29492b9-fc7e-4f3a-9463-574d581dd64a" />

# GoLang CI Checks - Unit Testing Documentation

---

##   Author Information

| **Author**   | **Created on** | **Version** | **Last updated by** | **Last edited on** | **Level** | **Reviewer**  |
|--------------|----------------|-------------|---------------------|--------------------|-----------|---------------|
| Tina Bhatnagar  | 17-08-25    | v1.0  |  Tina Bhatnagar |17-08-25     | Internal    | Rohit Chopra    |

---


## Table of Contents

1. [Introduction](#1-introduction)  
2. [What is Unit Testing?](#2-what-is-unit-testing)  
3. [Why Unit Testing in GoLang CI?](#3-why-unit-testing-in-golang-ci)  
4. [Workflow Diagram](#4-workflow-diagram)   
5. [Different Tools](#5-different-tools)  
6. [Tool Comparison Table](#6-tool-comparison-table)  
7. [Advantages](#7-advantages)  
8. [Disadvantages](#8-disadvantages)  
9. [POC](#9-poc)  
10. [Best Practices](#10-best-practices)  
11. [Conclusion](#11-conclusion)  
12. [FAQs](#12-faqs)  
13. [Contact Information](#13-contact-information)  
14. [References](#14-references)  



---

## 1. Introduction

This document provides a comprehensive overview of Unit Testing in GoLang CI (Continuous Integration) pipelines. It covers the fundamentals of unit testing, its importance in CI/CD workflows, the typical workflow followed in GoLang projects, different types of testing approaches, along with their advantages and best practices.

---

## 2. What is Unit Testing?

Unit testing is a fundamental practice in software development where individual components (functions, methods, or packages) are tested in isolation.
In GoLang Continuous Integration (CI) pipelines, unit tests play a critical role in ensuring that code is reliable, maintainable, and bug-free before moving to higher environments.

---

## 3. Why Unit Testing in GoLang CI?

| Benefit / Purpose                                 | Description                                                      |
|--------------------------------------------------|------------------------------------------------------------------|
| Code Correctness                                  | Ensures code correctness during every commit or merge           |
| Early Bug Detection                               | Detects bugs early in the development lifecycle                 |
| Developer Confidence                              | Improves developer confidence when refactoring                  |
| CI Automation                                     | Automates verification in CI pipelines                           |
| Code Quality Maintenance                          | Helps maintain code quality across teams                        |


---

## 4. **Workflow Diagram**

<img width="332" height="575" alt="image" src="https://github.com/user-attachments/assets/caedc978-2052-4299-8ea6-2386c036a7e3" />


| **Step** | **Description** |
|----------|-----------------|
| 1 | Developer writes the code to implement new features or fixes. |
| 2 | Code is committed to the Git repository. |
| 3 | The commit triggers the Continuous Integration (CI) pipeline. |
| 4 | CI pipeline runs GoLang unit tests. |
| 5 | A check is made to see if all tests have passed successfully. |
| 6 | If tests pass, the build/deployment proceeds; if not, the pipeline fails and feedback is sent. |

---

## 5. **Different Tools**

| **Tool**     | **Purpose** | **Pros** | **Cons** |
|--------------|-------------|----------|----------|
| Go`testing`  | Built-in Go testing framework for unit tests & benchmarks | Lightweight, no setup required, integrated with Go | Limited assertion features |
| Testify      | Provides rich assertions & mocking support | Easy to use, better readability, simplifies error handling | Slight learning curve |
| GoMock       | Mocking framework for Go interfaces | Strong mocking support, works well with large projects | Requires code generation |
| Ginkgo       | BDD-style testing framework | Readable, expressive, structured test cases | Verbose, extra dependency |

---

## 6. Tool Comparison Table

| **Tool**        | **Purpose** | **Pros** | **Cons** |
|------------------|-------------|----------|----------|
| GolangCI-Lint    | Fast Go linters aggregator for code quality | Runs multiple linters at once, improves code quality | Not for functional/unit testing |
| SonarQube        | Code quality & static analysis platform | Detects bugs, code smells, security issues | Requires setup & server |
| Mockery          | Mock code generator for Go interfaces | Simplifies mocking, auto-generates mocks | Extra dependency, code generation required |
| JaCoCo (via CI)  | Code coverage analysis tool | Tracks test coverage, integrates with CI/CD | Not Go-native, needs integration setup |

---

## 7. **Advantages**

| Advantage                       | Description                                                     |
| ------------------------------- | --------------------------------------------------------------- |
| **Early Bug Detection**         | Identifies issues before they propagate to higher environments. |
| **Continuous Delivery Support** | Provides confidence for frequent releases and deployments.      |
| **Reduced Debugging Time**      | Faster root cause analysis and quicker fixes.                   |
| **Improved Code Design**        | Encourages modular, maintainable, and testable code.            |
| **Reusability**                 | Ensures tested components can be reused safely across projects. |

---

## 8. Disadvantages

| **Disadvantage** | **Description** |
|------------------|-----------------|
| Initial Overhead | Writing tests requires extra time and effort. |
| False Sense of Security | 100% test coverage doesn’t guarantee bug-free code. |
| Maintenance Effort | Tests need to be updated when code changes. |
| Limited Scope | Unit tests can’t catch integration or system-level issues. |

---

## 9. POC

_Follow this link for POC_  
(**[Click here to view Setup guide](https://github.com/Snaatak-Apt-Get-Swag/documentation/blob/SCRUM-162-tina/Applications/Java-CI-Checks/Dependency-Scanning/POC/README.md)**)

---


## 10. **Best Practices**

| Best Practice                      | Description                                                   |
| ---------------------------------- | ------------------------------------------------------------- |
| **Keep Tests Small & Independent** | Each test should focus on a single functionality.             |
| **Follow AAA Pattern**             | Arrange, Act, Assert – ensures test clarity and structure.    |
| **Use Mocks & Stubs**              | Isolate units by mocking dependencies.                        |
| **Clear Naming Conventions**       | Test names should describe the scenario and expected outcome. |
| **Fast & Automated Execution**     | Ensure tests run quickly in the CI pipeline.                  |
| **Measure Code Coverage**          | Regularly track coverage to maintain quality assurance.       |

---

## 11. **Conclusion**

Unit testing in GoLang CI pipelines is crucial for maintaining **high-quality, bug-free applications**.
By automating test execution, developers gain faster feedback, reduce risks, and improve overall productivity.

---

## 12. FAQs

**Q1. Is unit testing mandatory in GoLang CI pipelines?**  
No, but it is highly recommended to ensure code quality and avoid regressions.  

**Q2. Which GoLang package is most commonly used for testing?**  
The built-in `testing` package is the most commonly used, often extended with Testify.  

**Q3. How are mocks created in GoLang?**  
Mocks can be created using frameworks like GoMock, Mockery, or manually.  

**Q4. How does unit testing integrate with CI/CD?**  
Unit tests run automatically on every commit/merge in the CI pipeline to prevent faulty code from progressing.  

**Q5. What is the recommended code coverage for GoLang projects?**  
Generally, 70–80% coverage is considered good, but focus should be on critical business logic.  

**Q6. Can unit tests replace integration tests?**  
No, unit tests ensure function-level correctness, while integration tests validate component interactions.  

---

## 13. Contact information


| Name| Email Address      | GitHub | URL |
|-----|--------------------------|-------------|---------|
| Tina Bhatnagar | [tina.bhatnagar@mygurukulam.co](mailto:tina.bhatnagar@mygurukulam.co)|  tina-snatak  | https://github.com/tina-snatak/ |

---

## 14. **References**

| Reference                                       | Link                                                                                                                                                          |
| ----------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **GoLang Testing Package**                      | [https://pkg.go.dev/testing](https://pkg.go.dev/testing)                                                                                                      |
| **GoLang Official Documentation**               | [https://go.dev/doc/](https://go.dev/doc/)                                                                                                                    |
| **Martin Fowler – Unit Testing Best Practices** | [https://martinfowler.com/](https://martinfowler.com/)                                                                                                        |

---
