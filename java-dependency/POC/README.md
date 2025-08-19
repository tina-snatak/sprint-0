<img width="400" height="376" alt="image" src="https://github.com/user-attachments/assets/adae343f-32b7-44e2-81f3-b8da98af9784" />


#  POC of Dependency Scanning in Java CI Checks

##   Author Information

| **Author**   | **Created on** | **Version** | **Last updated by** | **Last edited on** | **Level** | **Reviewer**  |
|--------------|----------------|-------------|---------------------|--------------------|-----------|---------------|
| Tina Bhatnagar  | 17-08-25    | v1.0  |  Tina Bhatnagar |17-08-25     | Internal    | Rohit Chopra    |



## Table of Contents

[Introduction](#introduction)
[OWASP Dependency-Check using Maven](#owasp-dependency-check-using-maven)
  - [Step 1. Clone the repo from GitHub](#step-1-clone-the-repo-from-github)
  - [Step 2. Change directory to the cloned repo](#step-2-change-directory-to-the-cloned-repo)
  - [Step 3. Dependency checking](#step-3-dependency-checking)
  - [Step 4. View the Dependency Result](#step-4-view-the-dependency-result)
  [Contact Information](#contact-information)
  [References](#references)



## 1. Introduction

A situation in which you need something or someone and are unable to continue normally without them.Dependency is when one thing needs to happen before another thing can happen. It describes the relationship among activities and specifies the particular order in which they need to be performed. 


## 2. OWASP Dependency-Check using Maven

### Before starting dependency test, ensure that you have Maven installed on your system. 

####  Step 1. Clone the repo from github

```
sudo git clone https://github.com/OT-MICROSERVICES/salary-api.git
```

<img width="600" height="187" alt="image" src="https://github.com/user-attachments/assets/b7270856-908e-4309-9bee-42955c6c8144" />


#### Step 2. Change the repo choose the github repo which is cloned already

```
cd salary-api
```

<img width="600" height="81" alt="image" src="https://github.com/user-attachments/assets/92cd41a7-4e8a-41f2-8dbb-619bd94bd199" />


####  Step 3. Dependency checking
```
mvn org.owasp:dependency-check-maven:check
```



#### Step 4. View the Dependency Result 

```
google-chrome target/site/index.html

```

## 6. Contact information


| Name| Email Address      | GitHub | URL |
|-----|--------------------------|-------------|---------|
| Tina Bhatnagar | [tina.bhatnagar@mygurukulam.co](mailto:tina.bhatnagar@mygurukulam.co)|  tina-snatak  | https://github.com/tina-snatak/ |


# References

| **Title** | **Link** |
|-----------|----------|
| Dependancy Scanning |[Link](https://docs.gitlab.com/ee/user/application_security/dependency_scanning/) 
| Dependancy Scanning tool |[Link](https://finitestate.io/blog/best-java-scanner)
