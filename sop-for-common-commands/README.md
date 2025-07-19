# Linux Common Commands

| Author | Created on | Version | Last updated by | Last edited on |
|--------|-------------|---------|------------------|----------------|
| Tina Bhatnagar | 19-07-2025 | Version 1 | Tina Bhatnagar | 19-07-2025 |

---

## Introduction

This document outlines the basic usage of Linux common commands. These commands serve as the foundation for navigating and interacting with a Linux system through the terminal. It helps developers, DevOps engineers, and system administrators perform essential tasks efficiently.

---

## Purposes

To demonstrate how commonly used Linux commands can be applied to perform day-to-day administrative, file management, process control, and system monitoring tasks efficiently in real-world scenarios.

---

## Key Features

- Easy-to-use and essential for beginners and professionals
- Helps automate repetitive system tasks
- Facilitates file and user management
- Simplifies system monitoring and performance tracking

---

## Getting Started

### Pre-requisites

| License Type | Description | Commercial Use | Open Source |
|--------------|-------------|----------------|-------------|
| GNU General Public License v3.0 | Free and open for public use and modification | Yes | Yes |

---

## Software Overview

| Software | Version     |
|----------|-------------|
| Linux Terminal | N/A (Built-in) |

---

## System Requirement

| Requirement           | Minimum Recommendation     |
|-----------------------|----------------------------|
| Processor/Instance Type | Dual-Core/T2.micro instance |
| RAM                   | 1 GB or Higher             |
| ROM (Disk Space)      | 5 GB or Higher             |
| OS Required           | Ubuntu/CentOS (Any Stable Version) |

---

## Important Ports

| Ports | Description |
|-------|-------------|
| 22    | Used for SSH connections to remotely access the Linux terminal |

---

## Dependencies

### Run-time Dependency

| Run-time Dependency | Version | Description |
|---------------------|---------|-------------|
| bash                | 4.x+    | Required for executing shell commands |

### Other Dependency

| Other Dependency | Version | Description |
|------------------|---------|-------------|
| coreutils         | latest  | Provides basic commands like `ls`, `cp`, `mv`, `rm`, etc. |

---

## How to Setup/Install Linux Command Utilities

Linux common commands are pre-installed in most distributions. However, if missing, install `coreutils` package:

```bash
# For Debian/Ubuntu
sudo apt update
sudo apt install coreutils

# For RHEL/CentOS
sudo yum install coreutils
````

---

## Configuration

No explicit configuration is required for basic Linux commands. However, you can customize your shell environment in:

* `~/.bashrc`
* `~/.zshrc`

Example:

```bash
alias ll='ls -la'
```

---

## Maintenance

Use the following commands for updates and upgrades:

```bash
# For update
sudo apt update
sudo yum update

# To upgrade packages
sudo apt upgrade
sudo yum upgrade
```

---

## Monitoring

Check whether commands are available and running:

```bash
which ls
which top
```

You can verify system processes:

```bash
top
ps aux
```

Check logs if any issue occurs:

```bash
journalctl -xe
dmesg
```

---

## Disaster Recovery

* Maintain backup of user-created shell scripts.
* In case of corrupted shell config files, restore defaults using:

```bash
cp /etc/skel/.bashrc ~/
```

* Use version control for script-based automation.

---

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


