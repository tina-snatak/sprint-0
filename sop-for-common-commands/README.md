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
| `apt remove <pkg>`        | Remove a package                       | `sudo apt remove apache`        |
| `apt search <pkg>`        | Search for a package                   | `apt search htop`              |

---

<img width="1065" height="421" alt="image" src="https://github.com/user-attachments/assets/aa236ffd-d4e6-4b8f-a50f-667721fe4b78" />
<img width="927" height="645" alt="image" src="https://github.com/user-attachments/assets/46b94c2d-b5fc-474f-b5fe-5b6102484cee" />
<img width="802" height="207" alt="image" src="https://github.com/user-attachments/assets/aff56119-83d9-4582-81f6-036a34a0421f" />


---


### 3. **System Shutdown and Reboot**

| Command           | Description                          | Example             |
|-------------------|--------------------------------------|---------------------|
| `shutdown now`    | Shutdown the system immediately      | `sudo shutdown now` |
| `shutdown -r now` | Reboot the system immediately        | `sudo shutdown -r now` |
| `reboot`          | Reboot the system                    | `sudo reboot`       |
| `halt`            | Halt the system                      | `sudo halt`         |

---
<img width="840" height="275" alt="image" src="https://github.com/user-attachments/assets/a7f9710e-7423-4eee-a7d8-f6baa2369e42" />
<img width="896" height="235" alt="image" src="https://github.com/user-attachments/assets/5c2f2400-95c7-465b-b8c7-97d8b3adb847" />
<img width="566" height="218" alt="image" src="https://github.com/user-attachments/assets/7ab03118-2ced-4635-ae2e-a750cb369441" />
<img width="688" height="218" alt="image" src="https://github.com/user-attachments/assets/a07a9770-72a5-40ab-9f7a-69d0377ac7a3" />

---

### 4. **Navigation Commands**

| Command       | Description                             | Example             |
|---------------|-----------------------------------------|---------------------|
|`pwd`          | Print current working directory         | `pwd`               |
| `ls -l`       | List files in long format               | `ls -l           `  |
| `cd`          | Change directory                        | `cd `               |

---

<img width="1018" height="228" alt="image" src="https://github.com/user-attachments/assets/9a7e84e9-5c4e-4374-9476-d3eb31ea8335" />

---

### 5. **File & Directory Operations**

| Command                  | Description                            | Example                         |
|--------------------------|----------------------------------------|---------------------------------|
| `touch`                  | Create a new empty file                | `touch myfile.txt`             |
| `mkdir`                  | Create a new directory                 | `mkdir newdir`                 |
| `cp`                     | Copy files or directories              | `cp cp myfile.txt /tmp/`       |
| `mv`                     | Move or rename files/directories       | ` mv myfile.txt newdir`        |
| `rm`                     | Remove a file                          | `rm myfile.txt`                |
| `rm -r`                  | Remove a directory and its contents    | `rm -r newdir`                 |

---

<img width="905" height="603" alt="image" src="https://github.com/user-attachments/assets/ee951b49-5aec-4fac-9ab0-8a2394b0cb28" />
<img width="687" height="191" alt="image" src="https://github.com/user-attachments/assets/5a378ff1-fcc2-4ed8-85d4-e1e6bdf45b9b" />
<img width="687" height="191" alt="image" src="https://github.com/user-attachments/assets/170b4231-6d31-4abd-87b0-c2e04f14b491" />



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







