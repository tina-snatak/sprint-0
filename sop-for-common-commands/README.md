# SOP for Ubuntu Common Commands

This document serves as a detailed reference guide for commonly used Ubuntu commands, structured for quick and easy access.

<img width="474" height="166" alt="image" src="https://github.com/user-attachments/assets/bd4e93d9-4bdf-42e1-9435-452f9eed7d22" />

---
## Author Information

| Created by      | Created on     | Version          | Last updated ON   | pre Reviewer       | L0 Reviewer     | L1 Reviewer   |    L2 Reviewer                 |
|-----------------|----------------|------------------|-------------------|--------------------|-----------------|---------------|--------------------------------|
| Tina Bhatnagar  |  18-07-2025    | V 1.0            |     18-07-2025    |  Rohit Chopra      | Akshit/Nitik    |  Taran        |  Abhishek dubey/ Rishabh sharma|

---

## Table of Contents
1. [Introduction](#introduction)
2. [Scope](#scope)
3. [Commands with Description and Examples](#commands-with-description-and-examples)
   - [System Commands](#1-system-commands)
   - [Package Management](#2-package-management)
   - [System Shutdown and Reboot](#3-system-shutdown-and-reboot)
   - [Navigation Commands](#4-navigation-commands)
   - [File & Directory Operations](#5-file--directory-operations)
   - [File Content Viewing](#6-file-content-viewing)
   - [User Management](#7-user-management)
   - [Permissions Management](#8-permissions-management)
   - [Process Management](#9-process-management)
   - [Network Diagnostics](#10-network-diagnostics)
   - [Disk and Memory Usage](#11-disk-and-memory-usage)
4. [ Notes ](#notes)
5. [ Troubleshooting ]( #Troubleshooting )
6. [ FAQs ]( #FAQs )
7. [ References ](#References)

---

## Introduction

This document provides a comprehensive list of essential Linux commands that are frequently used in day-to-day system administration, development, and DevOps operations. These commands allow users to interact with the Linux operating system via terminal, perform file operations, manage users, configure permissions, monitor processes, and much more. Mastery of these commands is fundamental for anyone working in a Linux environment.

---

## Scope

This SOP covers frequently used commands related to:

- Navigating the file system
- File and directory management
- Viewing and editing file contents
- User and permission management
- Process monitoring
- Network diagnostics

---

## Commands with Description and Examples


### 1. **System Commands**

| Command           | Description                                | Example                  |
|-------------------|--------------------------------------------|--------------------------|
| `uname -a`        | Show system information                    | `uname -a`               |
| `df -h`           | Display disk space usage                   | `df -h`                  |
| `du -sh <dir>`    | Show size of a directory                   | `du -sh tinabh`          |
| `free -h`         | Display memory usage                       | `free -h`                |
| `uptime`          | Show how long the system has been running | `uptime`                  |
| `hostname`        | Show or set the system hostname            | `hostname`               |
| `lsb_release -a`  | Display details about Ubuntu version       |  `lsb_release -a`        |
| `who`             | Show who is logged in                      | `who`                    |

---


<img width="1353" height="703" alt="image" src="https://github.com/user-attachments/assets/e31444f6-b739-4a1f-9f41-0087c4aeb24b" />


---

### 2. **Package Management**

| Command                    | Description                            | Example                         |
|----------------------------|----------------------------------------|---------------------------------|
| `apt update`              | Update package list                    | `sudo apt update`              |
| `apt upgrade`             | Upgrade installed packages             | `sudo apt upgrade`             |
| `apt install <pkg>`       | Install a new package                  | `sudo apt install curl`        |
| `apt remove <pkg>`        | Remove a package                       | `sudo apt remove nginx`        |
| `apt search <pkg>`        | Search for a package                   | `apt search htop`              |

---

### 3. **System Shutdown and Reboot**

| Command           | Description                          | Example             |
|-------------------|--------------------------------------|---------------------|
| `shutdown now`    | Shutdown the system immediately      | `sudo shutdown now` |
| `shutdown -r now` | Reboot the system immediately        | `sudo shutdown -r now` |
| `reboot`          | Reboot the system                    | `sudo reboot`       |
| `halt`            | Halt the system                      | `sudo halt`         |

---


### 4. **Navigation Commands**

| Command       | Description                             | Example             |
|---------------|-----------------------------------------|---------------------|
|`pwd`          | Print current working directory         | `pwd`               |
| `ls -l`       | List files in long format               | `ls -l /home/user`  |
| `cd`          | Change directory                        | `cd /var/log`       |

---

### 5. **File & Directory Operations**

| Command                  | Description                            | Example                         |
|--------------------------|----------------------------------------|---------------------------------|
| `touch`                  | Create a new empty file                | `touch myfile.txt`             |
| `mkdir`                  | Create a new directory                 | `mkdir newdir`                 |
| `cp`                     | Copy files or directories              | `cp file1.txt backup/`         |
| `mv`                     | Move or rename files/directories       | `mv oldname.txt newname.txt`   |
| `rm`                     | Remove a file                          | `rm temp.txt`                  |
| `rm -r`                  | Remove a directory and its contents    | `rm -r old_backup`             |

---

### 6. **File Content Viewing**

| Command        | Description                          | Example                 |
|----------------|--------------------------------------|-------------------------|
| `cat`          | Show contents of a file              | `cat notes.txt`         |
| `less`         | View large files with scrolling      | `less /var/log/syslog`  |
| `head`         | View first 10 lines of a file        | `head data.csv`         |
| `tail`         | View last 10 lines of a file         | `tail data.csv`         |
| `tail -f`      | Live monitor growing log files       | `tail -f access.log`    |

---

### 7. **User Management**

| Command             | Description                          | Example                |
|---------------------|--------------------------------------|------------------------|
| `whoami`            | Show current logged-in user          | `whoami`               |
| `id`                | Show user and group ID               | `id`                   |
| `adduser`           | Create a new user                    | `sudo adduser tina`    |
| `passwd`            | Change user password                 | `passwd tina`          |
| `su`                | Switch to another user               | `su - root`            |

---

### 8. **Permissions Management**

| Command                 | Description                            | Example                        |
|-------------------------|----------------------------------------|--------------------------------|
| `chmod`                 | Change file permissions                | `chmod 755 script.sh`         |
| `chown`                 | Change file ownership                  | `chown tina:admin file.txt`   |
| `umask`                 | Show default permission settings       | `umask`                       |

---

### 9. **Process Management**

| Command     | Description                            | Example          |
|-------------|----------------------------------------|------------------|
| `ps aux`    | View all running processes             | `ps aux`         |
| `top`       | Live view of system processes          | `top`            |
| `kill`      | Terminate a process by PID             | `kill 1234`      |
| `htop`      | Interactive process monitor (if installed) | `htop`       |

---

### 10. **Network Diagnostics**

| Command       | Description                                 | Example                    |
|---------------|---------------------------------------------|----------------------------|
| `ping`        | Check connectivity to a host                | `ping google.com`         |
| `ifconfig`    | Show network interfaces                     | `ifconfig`                |
| `ip a`        | Show detailed IP information                | `ip a`                    |
| `netstat -tuln` | List listening ports and services         | `netstat -tuln`           |
| `curl`        | Fetch content from a URL                    | `curl http://example.com` |

---

### 11. **Disk and Memory Usage**

| Command         | Description                              | Example              |
|-----------------|------------------------------------------|----------------------|
| `df -h`         | Disk usage of all file systems           | `df -h`              |
| `du -sh *`      | Disk usage of files/folders in dir       | `du -sh *`           |
| `free -h`       | Show memory usage                        | `free -h`            |
| `top`           | Real-time memory and process monitor     | `top`                |
| `vmstat`        | Report memory, CPU, and I/O stats        | `vmstat`             |

---

## Notes

- Use `man <command>` for manual and options.
- Use `--help` with any command to see usage: `ls --help`
- Always use caution with destructive commands like `rm`, especially with `sudo`.

---

## Troubleshooting

| Issue             | Solution                                   |
| ----------------- | ------------------------------------------ |
| Command not found | Install the required package or check PATH |
| Permission denied | Use `sudo` or check file permissions       |
| File not found    | Verify the path or filename is correct     |


---

## FAQs

#### Q. Is this application free?
Yes, it is open-source and pre-installed in most Linux distributions.

#### Q. Can I use these commands on all Linux distributions?
Yes, most commands are compatible across distributions like Ubuntu, CentOS, Debian, etc.

#### Q. Do I need internet to run Linux commands?
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
| [https://linuxcommand.org/lc3_man_page_index.php](https://linuxcommand.org/lc3_man_page_index.php)                           | Linux command documentation     |
| [https://linuxhandbook.com/a-to-z-linux-commands/](https://linuxhandbook.com/a-to-z-linux-commands/)                         | A TO Z Linux commands |
| [https://www.geeksforgeeks.org/linux-commands/](https://www.geeksforgeeks.org/linux-commands/)                               | Tutorials and examples          |







