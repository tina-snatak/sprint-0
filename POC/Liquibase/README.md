<img width="2000" height="224" alt="image" src="https://github.com/user-attachments/assets/90ca768e-b102-47a6-9252-755adcaa5496" />


# Liquibase POC Documentation

## Author Information

| Created by   | Created on | Version | Last Updated On | Pre Reviewer    | L0 Reviewer | L1 Reviewer | L2 Reviewer |
| ------------ | ---------- | ------- | --------------- | --------------- | ----------- | ----------- | ----------- |
| Divya Mishra | 02-08-2025 | V 1.0   | 02-08-2025      | Sahil/Siddharth |             |             |             |

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

<img width="862" height="601" alt="Screenshot from 2025-08-02 18-33-21" src="https://github.com/user-attachments/assets/73b6ef10-b4ec-42eb-88d4-ad02ff3f7e38" />

---

## 5 Install Liquibase CLI

<details>
<summary><strong>Linux</strong></summary>

**Official Docs:** [Liquibase Installation on Linux](https://docs.liquibase.com/installation/linux.html)

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

To make the PATH update permanent, add the export line to your `~/.bashrc` or `~/.zshrc`.

</details>

<details>
<summary><strong>macOS</strong></summary>

**Official Docs:** [Liquibase Installation on macOS](https://docs.liquibase.com/installation/macos.html)

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

To make the PATH update permanent, add the export line to your `.bash_profile` or `.zshrc`.

</details>

<details>
<summary><strong>Windows</strong></summary>

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

To make the path permanent, add the Liquibase folder to your system’s Environment Variables → Path.

</details>

---

## 6. Install PostgreSQL Database

<details>
<summary><strong>Linux</strong></summary>

**Official Docs:** [Install PostgreSQL on Debian/Ubuntu](https://www.postgresql.org/download/linux/ubuntu/)

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

</details>

<details>
<summary><strong>macOS (Homebrew)</strong></summary>

**Official Docs:** [Install PostgreSQL on macOS](https://www.postgresql.org/download/macosx/)

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

</details>

<details>
<summary><strong>Windows</strong></summary>

**Official Docs:** [PostgreSQL Installer for Windows](https://www.enterprisedb.com/downloads/postgres-postgresql-downloads)

1. Go to the [official installer page](https://www.enterprisedb.com/downloads/postgres-postgresql-downloads).
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

</details>

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

<details>
<summary><strong>Click to view Screenshot</strong></summary>

<img width="1086" height="258" alt="Screenshot from 2025-08-02 17-07-14" src="https://github.com/user-attachments/assets/e0a8118e-5072-42ab-a936-1408144dd82e" />

---

<img width="1638" height="447" alt="Screenshot from 2025-08-02 17-07-42" src="https://github.com/user-attachments/assets/4b117169-409a-4ccf-a132-4d53b07edbba" />

</details>

**Start and enable the PostgreSQL service:**

```bash
sudo systemctl start postgresql
sudo systemctl enable postgresql
```
<details>
<summary><strong>Click to view Screenshot</strong></summary>

<img width="1388" height="148" alt="Screenshot from 2025-08-02 17-08-13" src="https://github.com/user-attachments/assets/4878fd1d-ccd3-4ace-bf66-a3fccc9925b4" />

</details>

**Create user and database:**

```bash
sudo -u postgres psql
```
<details>
<summary><strong>Click to view Screenshot</strong></summary>

<img width="567" height="148" alt="Screenshot from 2025-08-02 17-08-44" src="https://github.com/user-attachments/assets/a24d09be-c0b3-47ca-9f1e-fc69191b69a4" />

</details>

Inside the psql prompt:

```sql
CREATE USER liquibase_user WITH PASSWORD <'enter password'>;
CREATE DATABASE liquibase_demo;
GRANT ALL PRIVILEGES ON DATABASE liquibase_demo TO liquibase_user;
\q
```

<details>
<summary><strong>Click to view Screenshot</strong></summary>

<img width="846" height="227" alt="Screenshot from 2025-08-02 17-09-06" src="https://github.com/user-attachments/assets/47280968-158f-4be3-a7b3-ebbbb68d1d3a" />

</details>

---

### 7.2 Install Java (JDK 11 or higher)

**Liquibase requires Java to run.**

```bash
sudo apt install openjdk-11-jdk -y
```

<details>
<summary><strong>Click to view Screenshot</strong></summary>

<img width="1617" height="287" alt="Screenshot from 2025-08-02 17-09-45" src="https://github.com/user-attachments/assets/5502b264-ee48-4e31-9905-2026b8282e5f" />

</details>

**Verify Java installation:**

```bash
java -version
```

<details>
<summary><strong>Click to view Screenshot</strong></summary>

<img width="1080" height="147" alt="Screenshot from 2025-08-02 17-11-01" src="https://github.com/user-attachments/assets/2b3e802b-83fd-4afc-8344-b1ae4b34d1a4" />

</details>

---

### 7.3 Install Liquibase CLI

**Download and extract Liquibase CLI:**

```bash
wget https://github.com/liquibase/liquibase/releases/download/v4.27.0/liquibase-4.27.0.tar.gz
tar -xzf liquibase-4.27.0.tar.gz
cd liquibase
```

<details>
<summary><strong>Click to view Screenshot</strong></summary>

<img width="1842" height="633" alt="Screenshot from 2025-08-02 17-11-39" src="https://github.com/user-attachments/assets/636d8bfa-184e-4103-8d18-b34726ae4072" />

</details>


**Temporarily add Liquibase to PATH:**

```bash
export PATH=$PATH:$(pwd)
```

**Verify installation:**

```bash
liquibase --version
```

<details>
<summary><strong>Click to view Screenshot</strong></summary>


<img width="1423" height="556" alt="Screenshot from 2025-08-02 17-12-29" src="https://github.com/user-attachments/assets/9de066fa-31e0-4934-b968-0268c7a17f62" />


</details>

Refer: [Liquibase Official Docs](https://www.liquibase.org/download)

---

### 7.4 Download PostgreSQL JDBC Driver

**Liquibase needs a JDBC driver to connect to PostgreSQL.**

```bash
 https://repo1.maven.org/maven2/org/postgresql/postgresql/42.7.3/
```

<details>
<summary><strong>Click to view Screenshot</strong></summary>

<img width="951" height="890" alt="Screenshot from 2025-08-02 18-46-08" src="https://github.com/user-attachments/assets/28938e1d-73db-406a-9328-f75531776a24" />

</details>

---

### Troubleshooting JDBC Driver Download Issue

<details>
<summary><strong>Click to expand troubleshooting steps</strong></summary>

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
curl -o ~/Downloads/postgresql-42.7.3.jar https://jdbc.postgresql.org/download/postgresql-42.7.3.jar
```

---

### 3. Download Manually from Browser

If command-line download fails, you can manually download the driver:

1. Visit: [https://jdbc.postgresql.org/download/]( https://repo1.maven.org/maven2/org/postgresql/postgresql/42.7.3/)
2. Download `postgresql-42.7.3.jar` file.
3. Move it to your project directory:

```bash
mv ~/Downloads/postgresql-42.7.3.jar .
```

```bash
classpath=/home/divya/liquibase/postgresql-42.7.3.jar
```

```bash
realpath postgresql-42.7.3.jar
```

<img width="966" height="153" alt="Screenshot from 2025-08-02 17-24-04" src="https://github.com/user-attachments/assets/99fb288b-0d71-41b8-b919-32ca457a2b65" />

---

### 4. Verify File Exists

Ensure the JAR file was downloaded successfully:

```bash
ls -lh /home/divya/postgresql-42.7.3.jar
```

<img width="967" height="102" alt="Screenshot from 2025-08-02 17-26-53" src="https://github.com/user-attachments/assets/a2eef363-dd8e-46aa-8909-eaadf4256cea" />


You should see the JAR file listed with its size (\~1.2 MB).

</details>

---

### 7.5 Create Liquibase Properties File

**Create configuration file so you don’t pass CLI arguments every time.**

```bash
nano liquibase.properties
```

<img width="605" height="62" alt="Screenshot from 2025-08-02 18-43-41" src="https://github.com/user-attachments/assets/07cf3494-65b1-44c2-a9d8-fe58248c42e3" />


Paste the following content:

```properties
changeLogFile=changelog.sql
url=jdbc:postgresql://localhost:5432/liquibase_demo
username=<Username>    
password=<password> 
driver=org.postgresql.Driver
classpath=/home/<usr>/postgresql-42.7.3.jar
```

Replace `your-username` with your actual username.

<details>
<summary><strong>Click to view Screenshot</strong></summary>

<img width="661" height="215" alt="Screenshot from 2025-08-02 17-29-45" src="https://github.com/user-attachments/assets/e81dcf8c-9c59-4dcf-aa40-cd336cd80f60" />

</details>

---

### 7.6 Create SQL Changelog File

**This file describes the database changes (in order).**

```bash
nano changelog.sql
```
<details>
<summary><strong>Click to view Screenshot</strong></summary>
  
<img width="781" height="65" alt="Screenshot from 2025-08-02 17-34-08" src="https://github.com/user-attachments/assets/60a4261d-09a0-4808-ab7a-46cb230d679a" />

</details>

Paste the following example:

```sql
--liquibase formatted sql

--changeset divya:1
CREATE TABLE departments (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100) NOT NULL
);
--rollback DROP TABLE departments;

--changeset divya:2
CREATE TABLE employees (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100),
  department_id INT REFERENCES departments(id)
);
--rollback DROP TABLE employees;

--changeset divya:3
--comment: tagging database as v1.0
--tag: v1.0
SELECT 1;
```

<details>
<summary><strong>Click to view Screenshot</strong></summary>

<img width="650" height="643" alt="Screenshot from 2025-08-02 17-33-49" src="https://github.com/user-attachments/assets/ce7a5e3d-be81-4f20-83c1-a0a102300fd4" />


</details>

---

### 7.7 Run Update Command

**Apply all defined changes to the database.**

```bash
liquibase update
```

<details>
<summary><strong>Click to view Screenshot</strong></summary>

<img width="1071" height="882" alt="Screenshot from 2025-08-02 17-45-18" src="https://github.com/user-attachments/assets/0951119e-2b45-4a1a-ad58-683f8bf32521" />


</details>

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
