<img width="700" height="216" alt="image" src="https://github.com/user-attachments/assets/2c4c4fd5-40a5-46fd-9904-2d3b2cea48c9" />



# Liquibase POC Documentation

## Author Information

| **Author**        | **Created on** | **Version** | **Last updated by** | **Last edited on** | **Level**   | **Reviewer**      |
|-------------------|----------------|-------------|----------------------|--------------------|-------------|-------------------|
| Tina Bhatnagar     | 31-07-25       | v1.0        | Tina Bhatnagar       | 31-07-25           | Internal    | Rohit Chopra      |

---

## Table of Contents

1. [Introduction](#1-introduction)
2. [What is Liquibase](#2-what-is-liquibase)
3. [Pre-requisites](#3-pre-requisites)
4. [Architecture Overview](#4-architecture-overview)

<details>
<summary><strong>5. Step-by-Step Setup Guide</strong></summary>

* [5.1 Install Liquibase CLI](#51-install-liquibase-cli)
* [5.2 Install PostgreSQL Database](#52-install-postgresql-database)
* [5.3 Install Java (JDK)](#53-install-java-jdk-11-or-higher)
* [5.4 Download PostgreSQL JDBC Driver](#54-download-postgresql-jdbc-driver)
* [5.5 Create Liquibase Properties File](#55-create-liquibase-properties-file)
* [5.6 Create SQL Changelog File](#56-create-sql-changelog-file)
* [5.7 Run Update Command](#57-run-update-command)
* [5.8 Verify Schema in PostgreSQL](#58-verify-schema-in-postgresql)
* [5.9 Tag a Version](#59-tag-a-version)

</details>

6. [Best Practices](#6-best-practices)

<details>
<summary><strong>7. Backup and Rollback Strategy</strong></summary>

* [7.1 Backup Before Applying Changes](#71-backup-before-applying-changes)
* [7.2 Writing Changesets with Rollback](#72-writing-changesets-with-rollback)
* [7.3 Rollback Commands](#73-rollback-commands)
* [7.4 Additional Tips](#74-additional-tips)

</details>

8. [Conclusion](#8-conclusion)
9. [Contact Information](#9-contact-information)
10. [References](#10-references)

---


## 1. Introduction

This Liquibase POC demonstrates a structured, Docker-free approach to database change management in PostgreSQL. Using SQL changelogs and Liquibase CLI, it enables teams to adopt a reliable process for applying, tracking, and rolling back schema changes

---

## 2. Purpose

The purpose of this POC is to demonstrate a controlled and automated approach to managing PostgreSQL schema changes using Liquibase. It ensures version-controlled deployments with rollback capability for safer and consistent database updates.

## 2. What is Liquibase

Liquibase is an open‑source database schema change management solution that enables you to safely and reliably deliver schema changes from development through production. It uses structured change files—called changelogs—in SQL, XML, YAML, or JSON. 

These changelogs contain ordered “changesets” that Liquibase tracks in your database via internal tables (DATABASECHANGELOG and DATABASECHANGELOGLOCK). When you run Liquibase, it automatically applies only the unapplied changesets, ensuring deployment consistency, supporting rollback, and enabling automation within CI/CD pipelines.

---

## 3. Pre-requisites

| Component                  | Description                                                                   |
| -------------------------- | ----------------------------------------------------------------------------- |
| **Java (JDK 8 or higher)** | Required to run Liquibase CLI                                                 |
| **Liquibase CLI**          | Version 4.27.0 or later, installed and added to system PATH                   |
| **PostgreSQL Database**    | Access to a test or staging environment (local or remote)                     |
| **JDBC Driver**            | PostgreSQL JDBC driver (`postgresql-<version>.jar`) must be available locally |
| **Database User**          | Must have privileges to create/modify schema (DDL operations)                 |
| **Git Repository**         | Used to version and track changelog files across environments                 |


---

## 4. Architecture Overview

<img width="600" height="511" alt="image" src="https://github.com/user-attachments/assets/37b3e599-f2df-4d9c-b1b6-a2494abe5f62" />


---

## 5 Install Liquibase CLI

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

## 6. Install PostgreSQL Database

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

```bash
brew update
brew install postgresql
```

**Start PostgreSQL**

```bash
brew services start postgresql
```

**Access PostgreSQL Shell**

```bash
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

```cmd
psql -U postgres
```

---

## 7. Step-by-Step Setup Guide

This guide walks you through how to use Liquibase with PostgreSQL from scratch. You’ll install the required tools, set up the environment, and perform schema versioning, tagging, and rollback—all using CLI and changelog files.

---

### 7.1 Install PostgreSQL (Linux)

**Install PostgreSQL and its basic components.**

```bash
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

Test the Connection

```
psql -U liquibase_user -d liquibase_demo -h localhost -W
```

<img width="700" height="421" alt="image" src="https://github.com/user-attachments/assets/2daf7284-25ac-48a2-a5a9-0175512ad580" />


---

### 7.2 Install Java (JDK 11 or higher)

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

### 7.3 Install Liquibase CLI

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

### 7.4 Download PostgreSQL JDBC Driver

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
### 5. Move the JAR file to the library folder

```
  mv postgresql-42.7.3.jar ~/liquibase/lib/
```
### 6. Set the classpath

```
  classpath=/home/ubuntu/liquibase/lib/postgresql-42.7.3.jar
```
### 7. Verify the absolute path

```
  realpath ~/liquibase/lib/postgresql-42.7.3.jar
```

<img width="700" height="601" alt="image" src="https://github.com/user-attachments/assets/2354e579-098f-4add-8acd-f40aeb104ddf" />

---

### 7.5 Create Liquibase Properties File

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

### 7.6 Create SQL Changelog File

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

### 7.7 Run Update Command

**Apply all defined changes to the database.**

```bash
liquibase update
```

<img width="700" height="486" alt="image" src="https://github.com/user-attachments/assets/06e31720-a270-436f-b654-29db88add1e2" />

---

<details>
<summary><strong>Troubleshooting: PostgreSQL "permission denied for schema public" (Liquibase)</strong></summary>

This error occurs when the PostgreSQL user (e.g. `liquibase_user`) does not have sufficient privileges on the `public` schema to create Liquibase metadata tables like `databasechangelog`.

---

### Solution Steps

1. **Login as PostgreSQL Superuser:**

```bash
sudo -u postgres psql
````

<img width="628" height="102" alt="Screenshot from 2025-08-02 17-43-34" src="https://github.com/user-attachments/assets/a06b98e7-9a45-4edf-b9ca-75f3d5a24f57" />


2. **Grant Permissions to liquibase\_user:**

```sql
GRANT USAGE ON SCHEMA public TO liquibase_user;
GRANT CREATE ON SCHEMA public TO liquibase_user;
ALTER SCHEMA public OWNER TO liquibase_user;
```

<img width="810" height="180" alt="Screenshot from 2025-08-02 17-43-50" src="https://github.com/user-attachments/assets/67ff9e7e-ffba-40f9-9d20-f6a80b8c3229" />


3. **Also grant ownership of the database (optional but safe):**

```sql
ALTER DATABASE liquibase_demo OWNER TO liquibase_user;
```

<img width="825" height="67" alt="Screenshot from 2025-08-02 17-44-18" src="https://github.com/user-attachments/assets/3682171c-85d7-45fd-b98b-c5f64b420641" />

4. **Ensure liquibase\_user is the owner of the schema and has full rights:**

```sql
\dn+ public
```

<img width="1086" height="215" alt="Screenshot from 2025-08-02 17-44-44" src="https://github.com/user-attachments/assets/07d90b01-9328-4259-8d81-114358c175f1" />


You should see `Owner: liquibase_user` and privileges should include `Create, Usage`.

5. **Exit PostgreSQL shell:**

```sql
\q
```

<img width="251" height="43" alt="Screenshot from 2025-08-02 17-45-00" src="https://github.com/user-attachments/assets/7cfd7250-2edc-475b-9ebb-1967bbbfb497" />


6. **Try again:**

```bash
liquibase update
```

<img width="1071" height="882" alt="Screenshot from 2025-08-02 17-45-18" src="https://github.com/user-attachments/assets/c06f7054-b3d4-43b3-9bcd-0d0fee98840a" />


</details>

---

### 7.8 Verify Schema in PostgreSQL

**Check if tables were created and changelog tracked.**

```bash
sudo -u postgres psql liquibase_demo -c "\dt"
sudo -u postgres psql liquibase_demo -c "SELECT * FROM DATABASECHANGELOG;"
```

<details>
<summary><strong>Click to view Screenshot</strong></summary>

<img width="1837" height="381" alt="Screenshot from 2025-08-02 17-46-14" src="https://github.com/user-attachments/assets/5c5672b7-8c63-4cdd-833c-1a23e323b959" />

---

<img width="988" height="305" alt="Screenshot from 2025-08-02 17-47-00" src="https://github.com/user-attachments/assets/124b1ee1-9e24-4fa8-8e97-d9a22ec443d0" />


</details>

---

### 7.9 Tag a Version

**Tag the current database state.**

```bash
liquibase tag v2.0
```

<details>
<summary><strong>Click to view Screenshot</strong></summary>

<img width="1106" height="576" alt="Screenshot from 2025-08-02 17-47-22" src="https://github.com/user-attachments/assets/27ca1b46-0f83-486c-a777-d04e5fa067a6" />

</details>

---


## 8. Best Practices

| Best Practice           | Explanation                                         |
| ----------------------- | --------------------------------------------------- |
| Use rollback statements | Always provide rollback for each changeset          |
| Use Git                 | Store changelogs under version control              |
| Add comments            | Add meaningful comments to each changeset           |
| Use tags                | Tag major releases to manage rollback points easily |
| Unique IDs              | Use meaningful IDs (e.g. author\:ticketNumber)           |
| Always Define Rollback  | Enables safe rollback in production                      |
| Avoid Manual DB Changes | Always use changelogs to maintain auditability           |
| Small Changesets        | Break large changes into multiple, small, testable units |


---

## 9. Backup and Rollback Strategy

Before applying any changes to a live database, it's essential to prepare for failure scenarios. This section explains how to create backups, structure changesets for rollback, and use Liquibase rollback commands safely.

---

### 9.1 Backup Before Applying Changes

Always take a full database backup before applying changes to ensure recoverability.

#### For PostgreSQL:

```bash
pg_dump -U postgres liquibase_demo > liquibase_demo_backup.sql
````

Replace `liquibase_demo` with your actual database name. Ensure the user has permission to read the database.

---

<details>
<summary>Why Backup Is Critical</summary>

* Prevents data loss during unintended schema or data changes.
* Allows restoring to the state before applying Liquibase updates.
* Essential for production environments and automated pipelines.

</details>

---

### 9.2 Writing Changesets with Rollback

Each `changeset` should have a corresponding `--rollback` clause.

<details>
<summary>Click to expand</summary>

#### Example with rollback:

```sql
--changeset divya:1
CREATE TABLE departments (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100)
);
--rollback DROP TABLE departments;
```

#### Example without rollback (not recommended):

```sql
--changeset divya:2
INSERT INTO departments(name) VALUES ('HR');
```

Add rollback like this:

```sql
--rollback DELETE FROM departments WHERE name = 'HR';
```

If rollback is not needed or not possible:

```sql
--rollback empty
```

</details>

---

<details>
<summary>Rollback Best Practices</summary>

* Use `--rollback` for every DDL/DML change.
* Use `--rollback empty` when rollback is intentionally skipped.
* Keep changelog files version-controlled and synced with production.
* Always tag each successful release using `liquibase tag`.

</details>

---

### 9.3 Rollback Commands

<details>
<summary>Click to expand</summary>

#### Rollback the last 1 changeset:

```bash
liquibase rollbackCount 1
```

#### Rollback to a tagged version:

```bash
liquibase rollback v1.0
```

#### Rollback to a specific date:

```bash
liquibase rollbackToDate 2025-08-01
```

</details>

---

<details>
<summary>When to Use Each Rollback Command</summary>

* `rollbackCount`: Use in development or testing to undo last few changes.
* `rollback vX.X`: Useful in production where each release is tagged.
* `rollbackToDate`: Restore the database to its state at a specific point in time.

</details>

---

### 9.4 Additional Tips

* Run validation before applying updates:

```bash
liquibase validate
```

* Keep regular backups, even with rollback scripts.
* Test both `update` and `rollback` in a non-production environment.
* Integrate rollback logic into CI/CD pipelines when possible.


---

## 10. Conclusion

This POC demonstrates a complete Liquibase lifecycle on a PostgreSQL database — from setup to schema deployment, tagging, and rollback. It uses the CLI, avoids Docker, and promotes clean changelog tracking with Git. This guide is suitable for beginners and teams aiming to implement database DevOps workflows reliably.

---

## 11. Contact Information

| Name         | Email                                                                             |
| ------------ | --------------------------------------------------------------------------------- |
| Divya Mishra | [divya.mishra.snaatak@mygurukulam.co](mailto:divya.mishra.snaatak@mygurukulam.co) |

---

## 12. References

| Link                                                                              | Description                 |
| --------------------------------------------------------------------------------- | --------------------------- |
| [Liquibase Docs](https://www.liquibase.org/documentation)                         | Official Documentation      |
| [Formatted SQL Changelog](https://www.liquibase.org/blog/formatted-sql-liquibase) | SQL-based changelog example |
| [Liquibase GitHub](https://github.com/liquibase/liquibase)                        | Source Repository           |
