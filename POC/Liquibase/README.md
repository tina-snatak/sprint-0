<img width="700" height="216" alt="image" src="https://github.com/user-attachments/assets/2c4c4fd5-40a5-46fd-9904-2d3b2cea48c9" />


# Liquibase POC Documentation


## Author Information

| **Author**        | **Created on** | **Version** | **Last updated by** | **Last edited on** | **Level**   | **Reviewer**      |
|-------------------|----------------|-------------|----------------------|--------------------|-------------|-------------------|
| Tina Bhatnagar     | 31-07-25       | v1.0        | Tina Bhatnagar       | 31-07-25           | Internal    | Rohit Chopra      |

---


## Table of Contents

1. [Introduction](#1-introduction)  
2. [Purpose](#2-purpose)  
3. [What is Liquibase](#3-what-is-liquibase)  
4. [Pre-requisites](#4-pre-requisites)  
5. [Architecture Overview](#5-architecture-overview)  
6. [Install Liquibase CLI](#6-install-liquibase-cli)  
   - [Install on Linux](#install-liquibase-on-linux)  
   - [Install on macOS](#install-liquibase-on-macos)  
   - [Install on Windows](#install-liquibase-on-windows)  
7. [Install PostgreSQL Database](#7-install-postgresql-database)  
   - [Install on Linux](#install-postgresql-on-linux)  
   - [Install on macOS](#install-postgresql-on-a-mac-with-homebrew)  
   - [Install on Windows](#install-postgresql-on-windows)  
8. [Step-by-Step Setup Guide](#8-step-by-step-setup-guide)  
   - [Install PostgreSQL (Linux)](#install-postgresql-linux)  
   - [Install Java (JDK 11 or higher)](#install-java-jdk-11-or-higher)  
   - [Install Liquibase CLI](#install-liquibase-cli)  
   - [Download PostgreSQL JDBC Driver](#download-postgresql-jdbc-driver)  
   - [Troubleshooting JDBC Driver Download Issue](#troubleshooting-jdbc-driver-download-issue)  
   - [Create Liquibase Properties File](#create-liquibase-properties-file)  
   - [Create SQL Changelog File](#create-sql-changelog-file)  
   - [Run Update Command](#run-update-command)  
   - [Troubleshooting PostgreSQL Permission Error](#troubleshooting-postgresql-permission-denied-for-schema-public-liquibase)  
   - [Verify Schema in PostgreSQL](#verify-schema-in-postgresql)  
   - [Tag a Version](#tag-a-version)  
9. [Best Practices](#9-best-practices)  
10. [Backup Strategy](#10-backup--strategy)  
    - [Backup Before Applying Changes](#backup-before-applying-changes)  
    - [Why Backup Is Critical](#why-backup-is-critical)  
11. [Conclusion](#11-conclusion)  
12. [Contact Information](#12-contact-information)  
13. [References](#13-references)  

---


## 1. Introduction

This Liquibase POC demonstrates a structured, Docker-free approach to database change management in PostgreSQL. Using SQL changelogs and Liquibase CLI, it enables teams to adopt a reliable process for applying, tracking, and rolling back schema changes

---

## 2. Purpose

The purpose of this POC is to demonstrate a controlled and automated approach to managing PostgreSQL schema changes using Liquibase. It ensures version-controlled deployments with rollback capability for safer and consistent database updates.

## 3. What is Liquibase

Liquibase is an open‑source database schema change management solution that enables you to safely and reliably deliver schema changes from development through production. It uses structured change files—called changelogs—in SQL, XML, YAML, or JSON. 

These changelogs contain ordered “changesets” that Liquibase tracks in your database via internal tables (DATABASECHANGELOG and DATABASECHANGELOGLOCK). When you run Liquibase, it automatically applies only the unapplied changesets, ensuring deployment consistency, supporting rollback, and enabling automation within CI/CD pipelines.

---

## 4. Pre-requisites

| Component                  | Description                                                                   |
| -------------------------- | ----------------------------------------------------------------------------- |
| **Java (JDK 8 or higher)** | Required to run Liquibase CLI                                                 |
| **Liquibase CLI**          | Version 4.27.0 or later, installed and added to system PATH                   |
| **PostgreSQL Database**    | Access to a test or staging environment (local or remote)                     |
| **JDBC Driver**            | PostgreSQL JDBC driver (`postgresql-<version>.jar`) must be available locally |
| **Database User**          | Must have privileges to create/modify schema (DDL operations)                 |
| **Git Repository**         | Used to version and track changelog files across environments                 |


---

## 5. Architecture Overview

<img width="600" height="511" alt="image" src="https://github.com/user-attachments/assets/37b3e599-f2df-4d9c-b1b6-a2494abe5f62" />


---

## 6 Install Liquibase CLI

- ## Install Liquibase on Linux
  
  **Official Docs:** [Liquibase Installation on Linux](https://docs.liquibase.com/start/install/liquibase-linux.html)

  **Download Liquibase**

   ```bash
   wget https://github.com/liquibase/liquibase/releases/download/v4.27.0/liquibase-4.27.0.tar.gz
   ```

  **Extract and Navigate**

  ```bash
  tar -xzf liquibase-4.27.0.tar.gz
  cd liquibase-4.27.0
  ```

   **Add Liquibase to PATH (temporary)**

   ```bash
     export PATH=$PATH:$(pwd)
   ```

  **Verify Installation**

  ```bash
     liquibase --version
  ```

- ## Install Liquibase on macOS

  **Official Docs:** [Liquibase Installation on macOS](https://docs.liquibase.com/start/install/liquibase-macos.html)

  **Option 1: Install via Homebrew**

  ```bash
   brew install liquibase
   liquibase --version
  ```

  **Option 2: Manual Installation**

  ```bash
   curl -LO https://github.com/liquibase/liquibase/releases/download/v4.27.0/liquibase-4.27.0.tar.gz
   tar -xzf liquibase-4.27.0.tar.gz
   cd liquibase-4.27.0
   export PATH=$PATH:$(pwd)
   liquibase --version
  ```

- ## Install Liquibase on Windows

   **Official Docs:** [Liquibase Installation on Windows](https://docs.liquibase.com/installation/windows.html)

   **Download Liquibase**

    ```powershell
       Invoke-WebRequest https://github.com/liquibase/liquibase/releases/download/v4.27.0/liquibase-4.27.0.zip -OutFile liquibase.zip
    ```

   **Extract Liquibase**

    ```powershell
       Expand-Archive .\liquibase.zip -DestinationPath .\liquibase
       cd .\liquibase
    ```

   **Add to PATH (temporary)**

   ```powershell
      $env:Path += ";$(Resolve-Path .\)"
   ```

   **Verify Installation**

   ```powershell
       liquibase --version
   ```


---

## 7. Install PostgreSQL Database

- ## Install PostgreSQL on Linux

**Official Docs:** [Install PostgreSQL on Debian/Ubuntu](https://www.geeksforgeeks.org/postgresql/install-postgresql-on-linux/)

**Update Package Index**

```bash
sudo apt update
```

**Install PostgreSQL**

```bash
sudo apt install postgresql postgresql-contrib -y
```

**Start and Enable Service**

```bash
sudo systemctl start postgresql
sudo systemctl enable postgresql
```

**Access PostgreSQL Shell**

```bash
sudo -u postgres psql
```


- ## Install PostgreSQL on a Mac with Homebrew

**Official Docs:** [Install PostgreSQL on macOS](https://www.geeksforgeeks.org/postgresql/how-to-install-postgresql-on-a-mac-with-homebrew/)

**Install PostgreSQL via Homebrew**

```
brew update
brew install postgresql
```

**Start PostgreSQL**

```
brew services start postgresql

```

**Access PostgreSQL Shell**

```
psql postgres

```

- ## Install PostgreSQL on Windows

**Official Docs:** [PostgreSQL Installer for Windows](https://www.geeksforgeeks.org/postgresql/install-postgresql-on-windows/)

1. Go to the [official installer page](https://www.geeksforgeeks.org/postgresql/install-postgresql-on-windows/).
2. Download the installer for your Windows version.
3. Run the installer and follow the wizard:

   * Set port (default is 5432)
   * Choose password for the `postgres` user
   * Finish installation
4. Open **pgAdmin** or **Command Prompt** to connect.

**Access via Command Prompt**

```
psql -U postgres

```

---

## 8. Step-by-Step Setup Guide

This guide walks you through how to use Liquibase with PostgreSQL from scratch. You’ll install the required tools, set up the environment, and perform schema versioning, tagging, and rollback—all using CLI and changelog files.

---

### Install PostgreSQL (Linux)

**Install PostgreSQL and its basic components.**

```
sudo apt update
sudo apt install postgresql postgresql-contrib -y
```
<img width="700" height="146" alt="image" src="https://github.com/user-attachments/assets/a7e4d83c-945e-433c-955b-778c86bbb64d" />
<img width="700" height="87" alt="image" src="https://github.com/user-attachments/assets/c5a77af6-ab7e-49e5-9543-f014bb6d6da5" />


**Start and enable the PostgreSQL service:**

```bash
sudo systemctl start postgresql
sudo systemctl enable postgresql
```
<img width="700" height="308" alt="image" src="https://github.com/user-attachments/assets/d884c806-e34d-442b-b7e4-8773ceb6a3a4" />


**Create user and database:**

```bash
sudo -u postgres psql
```
<img width="700" height="122" alt="image" src="https://github.com/user-attachments/assets/c0ca941f-df53-4d61-a77c-fba0edeb6f9e" />


Inside the psql prompt:

```sql
CREATE USER liquibase_user WITH PASSWORD <'enter password'>;
CREATE DATABASE liquibase_demo;
GRANT ALL PRIVILEGES ON DATABASE liquibase_demo TO liquibase_user;
\q
```

**Test the Connection**

```
psql -U liquibase_user -d liquibase_demo -h localhost -W
```

<img width="700" height="421" alt="image" src="https://github.com/user-attachments/assets/2daf7284-25ac-48a2-a5a9-0175512ad580" />


---

###  Install Java (JDK 11 or higher)

**Liquibase requires Java to run.**

```bash
sudo apt install openjdk-11-jdk -y
```

**Verify Java installation:**

```bash
java -version
```
<img width="700" height="97" alt="image" src="https://github.com/user-attachments/assets/e8366f8e-eccd-4f49-980e-6d3226aee13a" />


---

###  Install Liquibase CLI

**Download and extract Liquibase CLI:**

```bash
wget https://github.com/liquibase/liquibase/releases/download/v4.27.0/liquibase-4.27.0.tar.gz
tar -xzf liquibase-4.27.0.tar.gz
cd liquibase
```

<img width="700" height="623" alt="image" src="https://github.com/user-attachments/assets/70221825-6a72-47d4-a2bd-f1c78e6eb292" />



**Temporarily add Liquibase to PATH:**

```bash
export PATH=$PATH:$(pwd)
```
<img width="700" height="26" alt="image" src="https://github.com/user-attachments/assets/904bd0cc-fe12-4a0f-9b4b-bc2bea94a07e" />

**Verify installation:**

```bash
liquibase --version
```
<img width="700" height="897" alt="image" src="https://github.com/user-attachments/assets/30ddb373-ff14-45d0-9b85-bf1b24b50efe" />

---

###  Download PostgreSQL JDBC Driver

**Liquibase needs a JDBC driver to connect to PostgreSQL.**

```bash
 https://repo1.maven.org/maven2/org/postgresql/postgresql/42.7.3/
```
<img width="700" height="51" alt="image" src="https://github.com/user-attachments/assets/90b651ff-6422-48ce-bf8d-50a2b92f9876" />


---

### Troubleshooting JDBC Driver Download Issue

- #### here to see the detailed troubleshooting instructions.

### 1. Check Network Connectivity

Make sure your system can reach the PostgreSQL JDBC server:

```bash
ping jdbc.postgresql.org
```

If there's no response, the issue may be with your DNS or network connection.

---

### 2. Use `curl` Instead of `wget`

If `wget` hangs or fails, try using `curl`:

```bash
   wget https://jdbc.postgresql.org/download/postgresql-42.7.3.jar
```

---

### 3. Check if liquibase exists as a file

  ```
   ls -l ~ | grep liquibase
 ```
 - #### If the output shows a file named liquibase (not a folder), remove it:

  ```
    rm ~/liquibase

  ```
- #### Create required directories 

 ```
   mkdir -p ~/liquibase/lib
 ```
### 4. Move the JAR file to the library folder

```
  mv postgresql-42.7.3.jar ~/liquibase/lib/
```
### 5. Set the classpath

```
  classpath=/home/ubuntu/liquibase/lib/postgresql-42.7.3.jar
```
### 6. Verify the absolute path

```
  realpath ~/liquibase/lib/postgresql-42.7.3.jar
```

<img width="700" height="601" alt="image" src="https://github.com/user-attachments/assets/2354e579-098f-4add-8acd-f40aeb104ddf" />

---

###  Create Liquibase Properties File

**Create configuration file so you don’t pass CLI arguments every time.**

```bash
vim liquibase.properties
```

Paste the following content:

```
changeLogFile=changelog.sql
url=jdbc:postgresql://localhost:5432/liquibase_demo
username=postgres            # Replace with your actual DB username
password=your_password       # Replace with your actual DB password
driver=org.postgresql.Driver
classpath=/home/ubuntu/liquibase/lib/postgresql-42.7.3.jar

```

<img width="700" height="32" alt="image" src="https://github.com/user-attachments/assets/75dfb872-35df-42b9-931e-43d632135481" />

<img width="700" height="178" alt="image" src="https://github.com/user-attachments/assets/d7a8f0c9-30bd-4779-9679-655d89e9b84c" />

---

###  Create SQL Changelog File

**This file describes the database changes (in order).**

```bash
vim changelog.sql
```


Paste the following example:

```
-- liquibase formatted sql

-- changeset tina:1
CREATE TABLE departments (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);
-- rollback DROP TABLE departments;

-- changeset tina:2
CREATE TABLE employees (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    department_id INT REFERENCES departments(id)
);
-- rollback DROP TABLE employees;

-- changeset tina:3
-- comment: tagging database as v1.0
-- tag: v1.0
SELECT 1;


```

<img width="700" height="33" alt="image" src="https://github.com/user-attachments/assets/56f79113-c2ea-4061-a67a-10bf599360de" />

<img width="700" height="527" alt="image" src="https://github.com/user-attachments/assets/941324aa-ca27-40bc-bd8f-084dd23972b0" />


---

###  Run Update Command

**Apply all defined changes to the database.**

```bash
liquibase update
```

<img width="700" height="486" alt="image" src="https://github.com/user-attachments/assets/06e31720-a270-436f-b654-29db88add1e2" />

---

###  Troubleshooting: PostgreSQL "permission denied for schema public" (Liquibase)

This error occurs when the PostgreSQL user (e.g. `liquibase_user`) does not have sufficient privileges on the `public` schema to create Liquibase metadata tables like `databasechangelog`.

---

### Solution Steps

1. **Login as PostgreSQL Superuser:**

```bash
sudo -u postgres psql
````

<img width="700" height="122" alt="image" src="https://github.com/user-attachments/assets/1d1dcc7f-18e0-4120-8bcc-6ee727a80d78" />


2. **Grant Permissions to liquibase\_user:**

```
GRANT USAGE ON SCHEMA public TO liquibase_user;
GRANT CREATE ON SCHEMA public TO liquibase_user;
ALTER SCHEMA public OWNER TO liquibase_user;

```

<img width="700" height="265" alt="image" src="https://github.com/user-attachments/assets/5220e461-339d-4a09-adde-a8779e6b859a" />


3. **Also grant ownership of the database (optional but safe):**

```
ALTER DATABASE liquibase_demo OWNER TO liquibase_user;
```

<img width="700" height="66" alt="image" src="https://github.com/user-attachments/assets/d5ac8b8a-6b63-4907-b91c-e2e9a08672c3" />


4. **Ensure liquibase\_user is the owner of the schema and has full rights:**

```
\dn+ public
```

<img width="700" height="228" alt="image" src="https://github.com/user-attachments/assets/4268ad91-2023-4c86-9a32-98196f260bb2" />

5. **Exit PostgreSQL shell:**

```
\q
```

6. **Try again:**

```bash
liquibase update
```

<img width="700" height="485" alt="image" src="https://github.com/user-attachments/assets/589e0b67-8640-4bb2-8e44-46f63a499bff" />

---

###  Verify Schema in PostgreSQL

**Check if tables were created and changelog tracked.**

```bash
sudo -u postgres psql liquibase_demo -c "\dt"
sudo -u postgres psql liquibase_demo -c "SELECT * FROM DATABASECHANGELOG;"
```

<img width="700" height="217" alt="image" src="https://github.com/user-attachments/assets/65873e6d-b701-4f12-a718-c23fb4a1d2ac" />

<img width="700" height="331" alt="image" src="https://github.com/user-attachments/assets/e3d13e48-0df4-4a99-b65b-401c74f8904b" />

---

###  Tag a Version

**Tag the current database state.**

```bash
liquibase tag v2.0
```

<img width="1008" height="485" alt="image" src="https://github.com/user-attachments/assets/fbe65007-0138-4fc4-864c-9877cdb0662c" />

---


## 9. Best Practices

| Best Practice           | Explanation                                         |
| ----------------------- | --------------------------------------------------- |
| Add comments            | Add meaningful comments to each changeset           |
| Use tags                | Tag major releases to manage rollback points easily |
| Unique IDs              | Use meaningful IDs (e.g. author\:ticketNumber)           |
| Always Define Rollback  | Enables safe rollback in production                      |
| Avoid Manual DB Changes | Always use changelogs to maintain auditability           |
| Small Changesets        | Break large changes into multiple, small, testable units |


---

## 10. Backup  Strategy

Before applying any changes to a live database, it's essential to prepare for failure scenarios. This section explains how to create backups, structure changesets for rollback, and use Liquibase rollback commands safely.

---

###  Backup Before Applying Changes

Always take a full database backup before applying changes to ensure recoverability.

#### For PostgreSQL:

```bash
pg_dump -U postgres -h localhost liquibase_demo > liquibase_demo_backup.sql

````

Replace `liquibase_demo` with your actual database name. Ensure the user has permission to read the database.

---

#### Why Backup Is Critical

* Prevents data loss during unintended schema or data changes.
* Allows restoring to the state before applying Liquibase updates.
* Essential for production environments and automated pipelines.
  
---


## 11. Conclusion

This POC demonstrates a complete Liquibase lifecycle on a PostgreSQL database — from setup to schema deployment, tagging, and rollback. It uses the CLI, avoids Docker, and promotes clean changelog tracking with Git. This guide is suitable for beginners and teams aiming to implement database DevOps workflows reliably.

---

## 12. Contact Information

| Name| Email Address      | GitHub | URL |
|-----|--------------------------|-------------|---------|
| Tina Bhatnagar | [tina.bhatnagar@mygurukulam.co](mailto:tina.bhatnagar@mygurukulam.co)|  tina-snatak  | https://github.com/tina-snatak/ |


---

## 13. References

| Link                                                                              | Description                 |
| --------------------------------------------------------------------------------- | --------------------------- |
| [Liquibase Docs](https://www.liquibase.org/documentation)                         | Official Documentation      |
| [Formatted SQL Changelog](https://www.liquibase.org/blog/formatted-sql-liquibase) | SQL-based changelog example |
| [Liquibase GitHub](https://github.com/liquibase/liquibase)                        | Source Repository           |
