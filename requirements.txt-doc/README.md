# requirements.txt Documentation

<img width="850" height="350" alt="image" src="https://github.com/user-attachments/assets/f8ac0b19-774b-426b-b47b-24f4d1fdbb52" />

## Author Metadata

| Author      | Created on | Version   | Last updated by | Last edited on |
| ----------- | ---------- | --------- | --------------- | -------------- |
| Sneha Joshi | 18-07-25   | version 1 | Sneha Joshi     | 18-07-25       |

---

## Table of Content

1. [Introduction](#introduction)
2. [What is requirements.txt](#what-is-requirementstxt)
3. [Why Use requirements.txt](#why-use-requirementstxt)
4. [How to Create and Use requirements.txt](#how-to-create-and-use-requirementstxt)
5. [Use Cases](#use-cases)
6. [Best Practices](#best-practices)
7. [Syntax of requirements.txt](#syntax-of-requirementstxt)
8. [Difference Between pip with requirements.txt and pip for single module](#difference-between-pip-with-requirementstxt-and-pip-for-single-module)
9. [Poetry Overview](#poetry-overview)
10. [FAQs](#faqs)
11. [Conclusion](#conclusion)
12. [Contacts](#contacts)
13. [References](#references)

---

## Introduction

This guide provides a comprehensive overview of the requirements.txt file in Python projects—its purpose, advantages, best practices, and syntax. By understanding and using this file effectively, developers can ensure consistent environments, simplify dependency management, and improve reliability across development, testing, and production stages.

---

## What is requirements.txt

The requirements.txt file is a plain text file used in Python projects to list all the dependencies (i.e., external packages and libraries) required for the project to run. It provides a centralized and version-controlled way to declare the exact versions of packages, ensuring consistency across development, testing, and production environments. By maintaining this file, teams can reproduce environments reliably and manage third-party packages efficiently.

---

## Why Use requirements.txt

| *Reason*                          | *Explanation*                                                                                 |
| --------------------------------- | --------------------------------------------------------------------------------------------- |
| *Consistency Across Environments* | Ensures everyone uses the same package versions, preventing "it works on my machine" issues.  |
| *Ease of Setup*                   | Enables quick installation of dependencies using one command: pip install -r requirements.txt |
| *Reliable Deployments*            | Locks package versions to prevent unexpected behavior from version upgrades.                  |
| *Simplifies Dependency Tracking*  | Easier to audit, update, and manage all third-party packages in one file.                     |

---

## How to Create and Use requirements.txt

Creating and using a requirements.txt file is straightforward and plays a critical role in managing dependencies across environments.

### Step 1: Create a Virtual Environment

```bash
python -m venv venv  
source venv/bin/activate  #(on Linux/Mac)  
venv\Scripts\activate     #(on Windows)
```

### Step 2: Install the Required Packages

```bash
pip install flask  
pip install requests
```

### Step 3: Generate the requirements.txt File

```bash
pip freeze > requirements.txt
```

### Step 4: Share or Use the File in Other Environments

```bash
pip install -r requirements.txt
```

---

## Use Cases

| *Scenario*                    | **How requirements.txt Helps**                                                           |
| ----------------------------- | ---------------------------------------------------------------------------------------- |
| *Development*                 | New developers can install all dependencies quickly and reliably.                        |
| *CI/CD Pipelines*             | Automated systems can replicate the environment consistently for testing and deployment. |
| *Production*                  | Ensures stable and tested versions are used in live environments.                        |
| *Debugging & Reproducibility* | Helps recreate specific environments to trace and fix bugs easily.                       |

---

## Best Practices

### 1. Use Exact Version Pinning

```bash
flask==2.1.3 \
requests==2.28.1 \
sqlalchemy==1.4.46
```

### 2. Avoid Loose Versioning

```bash
# Not Recommended:
flask \
requests>=2.0

# Recommended:
flask==2.1.3 \
requests==2.28.1
```

### 3. Separate Production and Development Dependencies

```bash
# Production
django==3.2

# Development
pytest==7.2.1 \
black==23.1.0
```

Use separate files if needed:

* requirements.txt → Production
* dev-requirements.txt → Development

### 4. Use pip freeze to Lock All Installed Packages

```bash
pip freeze > requirements.txt
```

### 5. Consider Using Hashes for Security

```bash
requests==2.28.1 \
--hash=sha256:aaa... \
--hash=sha256:bbb...
```

---

## Syntax of requirements.txt

| *Syntax*               | *Description*                                        | *Example*                                              |
| ---------------------- | ---------------------------------------------------- | ------------------------------------------------------ |
| package                | Installs the latest version of a package             | flask                                                  |
| package==version       | Installs the exact version                           | requests==2.28.1                                       |
| package>=version       | Installs the specified version or newer              | sqlalchemy>=1.4                                        |
| package<=version       | Installs the specified version or older              | django<=3.2                                            |
| package\~=version      | Compatible release — allows minor updates            | pandas\~=1.3.0                                         |
| -e git+URL#egg=package | Installs directly from a Git repo in "editable" mode | -e git+[https://github.com/](https://github.com/)...   |
| --index-url <url>      | Specifies a custom package index                     | --index-url [https://example.com](https://example.com) |
| --find-links <url>     | Finds packages in local/remote locations             | --find-links ./packages                                |
| # comment              | Inline comments for readability                      | flask==2.1.3  # Web framework                          |
| -r otherfile.txt       | Includes another requirements file                   | -r dev-requirements.txt                                |

---

## Difference Between pip with requirements.txt and pip for single module

| *Aspect*              | **requirements.txt**                                  | **pip Command**                                          |
| --------------------- | ----------------------------------------------------- | -------------------------------------------------------- |
| *Purpose*             | Stores a list of dependencies for reuse and sharing   | Installs packages one-by-one or from a requirements file |
| *Format*              | Plain text file listing packages and versions         | Command-line tool for Python package installation        |
| *Usage*               | Used with pip install -r requirements.txt             | Used as pip install <package>                            |
| *Reproducibility*     | Promotes consistent environments across systems       | Manual installs may vary over time                       |
| *Version Control*     | Can be committed to version control for collaboration | Pip commands are transient (used interactively)          |
| *Dependency Tracking* | Can include pinned versions, hashes, and comments     | Tracks only what’s installed at that moment              |
| *Automation*          | Easily integrates with CI/CD tools for automation     | Less structured for automation                           |

---

## Poetry Overview

### What is Poetry?

Poetry is a modern Python dependency management tool that uses `pyproject.toml` instead of `requirements.txt`.

### Why Use Poetry?

| Feature            | Benefit                                        |
| ------------------ | ---------------------------------------------- |
| Central Config     | `pyproject.toml` holds metadata + dependencies |
| Dependency Locking | `poetry.lock` ensures exact reproducibility    |
| Built-in venv      | Manages virtual environment automatically      |
| Publish Friendly   | Easy to publish packages to PyPI               |

### Basic Poetry Commands

```bash
poetry init                   # Start a new project
poetry add flask              # Add package
poetry install                # Install all packages
poetry update                 # Update packages
poetry shell                  # Enter venv
```

### Exporting requirements.txt from Poetry

```bash
poetry export -f requirements.txt --output requirements.txt --without-hashes
```

---

## FAQs

### 1. Can I use multiple requirements files for different environments?

Yes. You can separate files like:

```bash
pip install -r requirements.txt
pip install -r dev-requirements.txt
```

### 2. How do I update a specific package and reflect that in requirements.txt?

```bash
pip install --upgrade package-name
pip freeze > requirements.txt
```

### 3. What happens if a package is missing from requirements.txt?

It will not be installed, which can cause runtime errors like `ModuleNotFoundError`.

### 4. How can I install only dev tools for local testing?

```bash
pip install -r dev-requirements.txt
```

### 5. What is the difference between `pip freeze` and `pip list`?

| Command    | Purpose                                                |
| ---------- | ------------------------------------------------------ |
| pip list   | Shows installed packages and versions (human-readable) |
| pip freeze | Outputs in requirements.txt format (machine-usable)    |

---

## Conclusion

The requirements.txt file is more than just a list of packages—it's a tool that fosters collaboration, reduces bugs, and increases deployment reliability. By following best practices, teams can maintain cleaner, safer, and more efficient Python environments.

---

## Contacts

| Name        | Email Address                                                                   |
| ----------- | ------------------------------------------------------------------------------- |
| Sneha Joshi | [sneha.joshi.snaatak@mygurukulam.co](mailto:sneha.joshi.snaatak@mygurukulam.co) |

---

## References

| *Title*                                  | *Link*                                                                                                                                     |
| ---------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------ |
| Official pip Documentation               | [https://pip.pypa.io/en/stable/reference/requirements-file-format/](https://pip.pypa.io/en/stable/reference/requirements-file-format/)     |
| Free Code Camp How-To Guide              | [https://www.freecodecamp.org/news/python-requirementstxt-explained/](https://www.freecodecamp.org/news/python-requirementstxt-explained/) |
| Best Practices for Dependency Management | [https://docs.python-guide.org/dev/virtualenvs/#requirements-files](https://docs.python-guide.org/dev/virtualenvs/#requirements-files)     |

