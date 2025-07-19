# Linux Common Commands

| Author          | Created on | Version   | Last updated by | Last edited on |
|----------------|------------|-----------|------------------|----------------|
| Tina Bhatnagar | 19-07-2025 | Version 1 | Tina Bhatnagar   | 19-07-2025     |

---

## Introduction

This document provides a comprehensive list of essential Linux commands that are frequently used in day-to-day system administration, development, and DevOps operations. These commands allow users to interact with the Linux operating system via terminal, perform file operations, manage users, configure permissions, monitor processes, and much more. Mastery of these commands is fundamental for anyone working in a Linux environment.

---

## Purposes

This documentation serves as a quick reference and onboarding guide for team members and beginners. It outlines the purpose, usage, and syntax of common Linux commands used in practical scenarios such as:

- Navigating the file system
- Managing files and directories
- Monitoring system performance
- Controlling permissions and access
- Managing packages and dependencies

---

## Key Features

- Covers all foundational Linux command categories
- Clear and structured tabular format for readability
- Ideal for developers, admins, and DevOps professionals
- Encourages best practices in command-line usage
- Enhances troubleshooting and monitoring capabilities

---

## Getting Started

### Pre-requisites

| License Type               | Description                                    | Commercial Use | Open Source |
|----------------------------|------------------------------------------------|----------------|-------------|
| GNU General Public License v3.0 | Free and open for public use and modification | Yes            | Yes         |

---

## Software Overview

| Software       | Version    |
|----------------|------------|
| Linux Terminal | Built-in   |

---

## System Requirement

| Requirement             | Minimum Recommendation    |
|--------------------------|---------------------------|
| Processor/Instance Type  | Dual-Core / T2.micro       |
| RAM                      | 1 GB or Higher             |
| ROM (Disk Space)         | 5 GB or Higher             |
| OS Required              | Ubuntu / CentOS (Stable)   |

---

## Important Ports

| Port | Description                                  |
|------|----------------------------------------------|
| 22   | SSH remote terminal access (default port)    |

---

## Dependencies

### Run-time Dependency

| Dependency | Version | Description                         |
|------------|---------|-------------------------------------|
| bash       | 4.x+    | Command interpreter for shell usage |

### Other Dependency

| Dependency  | Version | Description                                           |
|-------------|---------|-------------------------------------------------------|
| coreutils   | latest  | Collection of essential commands like `ls`, `cp`, etc |

---

## How to Setup/Install Linux Command Utilities

Most common commands come pre-installed in all major Linux distros. If not, install `coreutils`:

```bash
# Debian/Ubuntu
sudo apt update
sudo apt install coreutils

# CentOS/RHEL
sudo yum install coreutils

## High Availability

To ensure minimal downtime for automated tasks or processes:

* Use `cron` for job scheduling
* Implement monitoring with tools like `monit` or `systemd` units for custom scripts
* Keep a list of critical scripts and commands well-documented and version-controlled

---

## Troubleshooting

| Issue             | Solution                                   |
| ----------------- | ------------------------------------------ |
| Command not found | Install the required package or check PATH |
| Permission denied | Use `sudo` or check file permissions       |
| File not found    | Verify the path or filename is correct     |

---

## FAQs

**Q. Is this application free?**
Yes, it is open-source and pre-installed in most Linux distributions.

**Q. Can I use these commands on all Linux distributions?**
Yes, most commands are compatible across distributions like Ubuntu, CentOS, Debian, etc.

**Q. Do I need internet to run Linux commands?**
No, basic commands work offline. Internet is only needed for package installation and updates.

---

## Contact Information

| Name           | Email address                                                         |
| -------------- | --------------------------------------------------------------------- |
| Tina Bhatnagar | [tina.bhatnagar@mygurukulam.co](mailto:tina.bhatnagar@mygurukulam.co) |

---

## References

| Links                                                                                                                        | Descriptions                    |
| ---------------------------------------------------------------------------------------------------------------------------- | ------------------------------- |
| [https://tldp.org/LDP/GNU-Linux-Tools-Summary/html/index.html](https://tldp.org/LDP/GNU-Linux-Tools-Summary/html/index.html) | Linux command documentation     |
| [https://man7.org/linux/man-pages/](https://man7.org/linux/man-pages/)                                                       | Manual pages for Linux commands |
| [https://www.geeksforgeeks.org/linux-commands/](https://www.geeksforgeeks.org/linux-commands/)                               | Tutorials and examples          |


