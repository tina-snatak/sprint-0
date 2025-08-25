<img width="295" height="180" alt="image" src="https://github.com/user-attachments/assets/1d3d2295-d9c2-414d-860f-63663282c052" />


# Terraform Modules Documentation

---

##   Author Information

| **Author**   | **Created on** | **Version** | **Last updated by** | **Last edited on** | **Level** | **Reviewer**  |
|--------------|----------------|-------------|---------------------|--------------------|-----------|---------------|
| Tina Bhatnagar  | 25-08-25    | v1.0  |  Tina Bhatnagar |25-08-25     | Internal    | Rohit Chopra    |

---

## Table of Contents

1. [Introduction](#1-introduction)  
2. [What are Terraform Modules?](#2-what-are-terraform-modules)  
3. [Why Use Terraform Modules?](#3-why-use-terraform-modules)  
4. [Key Features](#4-key-features)  
5. [Module Structure](#5-module-structure)  
6. [Input Variables](#6-input-variables)  
7. [Output Values](#7-output-values)  
8. [Usage Example](#8-usage-example)  
9. [Best Practices](#9-best-practices)  
10. [Use Cases](#10-use-cases)  
11. [FAQs](#11-faqs)  
12. [Contact Information](#12-contact-information)  
13. [References](#13-references)  

  
---

## 1. Introduction

Terraform Modules are reusable, configurable building blocks for defining and provisioning infrastructure in a consistent and scalable way. By grouping related resources, modules enable teams to create a standardized approach for deploying infrastructure across environments and projects.  

This documentation provides a detailed explanation of what Terraform Modules are, why they are essential, their structure, usage, best practices, and common use cases.

---

## 2. What are Terraform Modules?

A **Terraform Module** is a container for multiple resources that are used together.  
- A module consists of a collection of `.tf` configuration files in a directory.  
- The root module is the main directory where Terraform operations are executed, and it can call other **child modules**.  
- Modules help encapsulate resource definitions and make them reusable, version-controlled, and easier to maintain.

---

## 3. Why Use Terraform Modules?

| Benefit                    | Description                                                                 |
| -------------------------- | --------------------------------------------------------------------------- |
| **Reusability**            | Modules allow teams to reuse configurations across environments and teams. |
| **Consistency**            | Enforces a standard approach to provisioning similar infrastructure.       |
| **Scalability**            | Easily replicate infrastructure at scale with minimal effort.              |
| **Maintainability**        | Centralized codebase makes it easier to apply updates and bug fixes.       |
| **Collaboration**          | Teams can share modules through private registries or version control.     |

---

## 4. Key Features

| S.no  | Feature                                           | Description                                                                 |
|----|--------------------------------------------------|---------------------------------------------------------------------------|
| 1  | **Encapsulation of Infrastructure Components**   | Groups related resources together for modular and reusable design.        |
| 2  | **Version-Controlled Reusable Code**             | Modules can be versioned and reused across multiple projects/environments.|
| 3  | **Dynamic Variables**                            | Accepts input variables to customize infrastructure deployments.          |
| 4  | **Simplified Outputs**                           | Provides outputs for easy integration with other modules or root configs. |
| 5  | **Terraform Registry Compatibility**             | Easily shareable and consumable through Terraform Registry.               |

---

## 5. Module Structure

A typical module directory structure:  

```bash

my-module/
├── main.tf 
├── variables.tf 
├── outputs.tf
├── versions.tf 
└── README.md 
```

**Module Structure Description**

| File Name        | Description                                                                 |
|------------------|-----------------------------------------------------------------------------|
| **main.tf**      | Defines the core infrastructure resources that this module manages.         |
| **variables.tf** | Declares all input variables, their types, descriptions, and default values.|
| **outputs.tf**   | Specifies the output values to share with other modules or the root module. |
| **versions.tf**  | Sets Terraform and provider version constraints for compatibility.          |
| **README.md**    | Provides documentation on the module's purpose, variables, and usage.      |

---

## 6. Input Variables

Input variables are parameters passed to modules to customize their behavior.  
Example:

```hcl
variable "instance_type" {
  description = "Type of EC2 instance"
  type        = string
  default     = "t2.micro"
}
```

---

## 7. Output Values

Outputs allow modules to return values to the root module or other modules.
Example:

```hcl
output "instance_id" {
  description = "The ID of the created EC2 instance"
  value       = aws_instance.my_ec2.id
}
```

---

## 8. Usage Example

Root module calling a reusable EC2 module:

```hcl
module "ec2_instance" {
  source        = "./modules/ec2"
  instance_type = "t3.medium"
  region        = "us-east-1"
}
```

---

## 9. Best Practices

| S.no  | Practice                              | Description                                                            |
|----|--------------------------------------|------------------------------------------------------------------------|
| 1  | **Follow a Consistent Structure**    | Use `main.tf`, `variables.tf`, `outputs.tf`, and `versions.tf` for organization. |
| 2  | **Use Version Pinning**              | Lock module versions to avoid unexpected changes.                      |
| 3  | **Write Clear Documentation**        | Include usage instructions, variables, and outputs in `README.md`.     |
| 4  | **Keep Modules Small and Focused**   | Modules should solve a single infrastructure concern.                 |
| 5  | **Validate Modules**                 | Use `terraform validate` and automated CI/CD checks.                  |
| 6  | **Leverage Terraform Registry**      | Share and consume community-verified modules.                         |
| 7  | **Tag Releases**                     | Use Git tags for version control.                                     |

---

## 10. Use Cases

| S.no  | Use Case                                     | Description                                                      |
|----|---------------------------------------------|------------------------------------------------------------------|
| 1  | **Provisioning VPCs**                       | Create VPCs with subnets, gateways, and route tables.           |
| 2  | **Managing Compute Resources**              | Deploy EC2 instances                    |
| 3  | **Creating IAM Roles and Policies**         | Define access control policies for cloud resources.             |
| 4  | **Deploying Databases**                     | Automate database setup (PostgreSQL).            |
| 5  | **Networking Configurations**               | Configure load balancers, security groups, and network rules.   |
| 6  | **Multi-Cloud Infrastructure**              | Build consistent infra templates for AWS, etc.      |

---

## 11. FAQs  

**Q1. What is a Terraform Module and why should I use it?**  
A Terraform Module is a container for multiple resources that work together.  
You should use modules to make your infrastructure **reusable, consistent, scalable, and maintainable**.  



**Q2. What is the difference between a root module and a child module?**  
- **Root Module**: The main directory where Terraform commands (`init`, `plan`, `apply`) are executed.  
- **Child Module**: A sub-directory or external module that is called by the root module.  



**Q3. Can I reuse Terraform modules across multiple projects?**  
Yes , Terraform modules are designed for **reusability**.  
You can version them, store in VCS (GitHub/GitLab/Bitbucket), or publish in **Terraform Registry** to share with teams.  



**Q4. How do input variables improve module flexibility?**  
Input variables make modules **dynamic and customizable**, allowing users to override values (e.g., instance type, region, CIDR blocks) without changing the module code.  



**Q5. How can I share Terraform modules with my team?**  
Modules can be shared by:  
- Storing them in a **Git repository**  
- Publishing them in a **private registry**  
- Using the official **Terraform Registry** for public modules  


**Q6. What are the best practices while working with modules?**  
- Keep modules **small and focused**  
- Use **version pinning** to avoid breaking changes  
- Write **clear documentation** in `README.md`  
- Validate modules using `terraform validate` and CI/CD pipelines  

---



## 12. Contact Information

| Name| Email Address      | GitHub | URL |
|-----|--------------------------|-------------|---------|
| Tina Bhatnagar | [tina.bhatnagar@mygurukulam.co](mailto:tina.bhatnagar@mygurukulam.co)|  tina-snatak  | https://github.com/tina-snatak/ |

---

## 13. References

| S.no | Resource                          | Link                                                                                      | Description                                       |
|----|----------------------------------|------------------------------------------------------------------------------------------|---------------------------------------------------|
| 1  | Terraform Official Documentation | [View Docs](https://developer.hashicorp.com/terraform/docs)                               | Official documentation for Terraform usage.       |
| 2  | Terraform Registry               | [Visit Registry](https://registry.terraform.io/)                                         | Library of publicly available Terraform modules.  |
| 3  | Terraform Best Practices         | [Read Guide](https://www.terraform.io/docs/language/modules/index.html)                  | Official guide on writing and structuring modules.|
