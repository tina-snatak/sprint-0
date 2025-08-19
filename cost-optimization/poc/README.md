# Cost Tag Reports via Cost Explorer Implementation

<img width="500" height="430" alt="image" src="https://github.com/user-attachments/assets/bd4101f9-625a-44d4-b039-a199125aa9c1" />

---

##   Author Information

| **Author**   | **Created on** | **Version** | **Last updated by** | **Last edited on** | **Level** | **Reviewer**  |
|--------------|----------------|-------------|---------------------|--------------------|-----------|---------------|
| Tina Bhatnagar  | 17-08-25    | v1.0  |  Tina Bhatnagar |17-08-25     | Internal    | Rohit Chopra    |

---

## Table of Contents  

1. [Introduction](#1-introduction)  
2. [Pre-requisites](#2-pre-requisites)  
3. [Step-by-Step Setup Guide](#3-step-by-step-setup-guide)  
   - [Step 1 - Enable Cost Allocation Tags](#step-1--enable-cost-allocation-tags)  
   - [Step 2 - Save the Report in AWS](#step-2--save-the-report-in-aws)  
   - [Step 3 - Save and Export Reports](#step-3--save-and-export-reports)  
4. [Example Use Case](#4-example-use-case)  
5. [Best Practices](#5-best-practices)  
6. [Contact Information](#6-contact-information)  
7. [References](#7-references)  

---

## 1. Introduction

AWS **Cost Tag Reports** help analyze and track costs by associating AWS resource usage with **tags** (e.g., `Project`, `Environment`, `Owner`). Using **AWS Cost Explorer**, you can filter and group costs based on these tags to generate meaningful financial and operational insights.  

 **Related Documentation:**  
 [Cost Tag Reports via Cost Explorer Documentation (Last Sprint)](https://team-snaatak-p-15.atlassian.net/jira/software/projects/SCRUM/boards/1?jql=labels%20%3D%20%22%23tina%22&selectedIssue=SCRUM-127)

---

## 2. Pre-requisites

| Requirement | Description | 
|-------------|-------------|
| AWS Console Access | Ensure you have access to AWS Management Console with Billing permissions | 
| Cost Allocation Tags | Tags should be created and applied to AWS resources | 
| Cost Explorer Enabled | Ensure Cost Explorer is activated in AWS | 

---

## 3. Step-by-Step Setup Guide

### Step 1- Enable Cost Allocation Tags

1. Sign in to the **AWS Management Console**.
2. Navigate to **Billing → Cost Allocation Tags**.


 <img width="600" height="573" alt="image" src="https://github.com/user-attachments/assets/a54d0805-37df-4a06-a048-9d1707dd5b67" />


3. Search for the tag you want to track (e.g., `Project`).
4. Select the checkbox next to your tag.
   
<img width="600" height="573" alt="Screenshot from 2025-08-12 10-58-29" src="https://github.com/user-attachments/assets/7c3aa625-4279-43e9-bce6-ff5bb4bbcfc2" />


5. Click **Activate**.


 <img width="600" height="573" alt="image" src="https://github.com/user-attachments/assets/cb97e21d-c2b0-45c5-bea8-98f31d8fe92b" />



6. Wait up to **24 hours** for the tag to appear in Cost Explorer.



---

### Step 2- Save the Report in AWS

1. Click Save to report library (top right, orange button).


<img width="600" height="584" alt="Screenshot from 2025-08-13 09-12-24" src="https://github.com/user-attachments/assets/16b12a22-67c6-4aa5-9807-590f412dd20f" />


2. Give your report a name (e.g., Project_Tag_Cost_Report).


<img width="600" height="633" alt="Screenshot from 2025-08-13 13-04-25" src="https://github.com/user-attachments/assets/813bb53b-b69c-4f15-9430-c3d4b944cc6c" />


3. Add an optional description for clarity.

4. Click Save.
   
<img width="600" height="782" alt="Screenshot from 2025-08-13 13-05-17" src="https://github.com/user-attachments/assets/c3e3695b-67b0-484d-b4c6-d86493fbf8bb" />


---

### Step 3- Save and Export Reports
1. Once the desired view is ready, click **Save As** to store the report in AWS.
   
<img width="600" height="691" alt="image" src="https://github.com/user-attachments/assets/8ddd41c8-89fe-48d8-8ff4-d36e8258665e" />


2. Optionally, click **Download CSV** to export the data.


<img width="600" height="384" alt="Screenshot from 2025-08-13 13-05-53" src="https://github.com/user-attachments/assets/9819661e-56aa-4d70-851c-f8f550c66d11" />


3. Share the exported file with stakeholders for review.

<img width="600" height="307" alt="image" src="https://github.com/user-attachments/assets/4d46dd8e-bf63-4908-8f55-d9c8fa507a32" />


---

## 4. Example Use Case

| Scenario | Action | Outcome |
|----------|--------|---------|
| Multiple projects running in AWS | Tag all resources for **Project: Alpha** | Easy identification of project-specific costs |
| Cost Reporting | Use Cost Explorer to generate a monthly report filtering only **Project: Alpha** costs | Get a clear monthly cost report |
| Budgeting & Finance | Share the data with finance teams | Helps in accurate budgeting and financial planning |


---

## 5. Best Practices
| Practice                                | Benefit                                  |
|-----------------------------------------|-------------------------------------------|
| Use a **consistent tagging strategy**   | Ensures uniform cost reporting            |
| Enable only **relevant tags**           | Reduces clutter in reports                |
| Review reports monthly                  | Helps detect unusual spending early       |
| Combine with **Budgets & Alerts**       | Enables proactive cost management         |

---

## 6. Contact information


| Name| Email Address      | GitHub | URL |
|-----|--------------------------|-------------|---------|
| Tina Bhatnagar | [tina.bhatnagar@mygurukulam.co](mailto:tina.bhatnagar@mygurukulam.co)|  tina-snatak  | https://github.com/tina-snatak/ |


---

## 7. References

| Topic                                     | Description                                                                 | Link |
|-------------------------------------------|-----------------------------------------------------------------------------|------|
| AWS Cost Explorer                         | Overview of AWS Cost Explorer for visualizing and managing AWS costs.       | [Link](https://docs.aws.amazon.com/cost-management/latest/userguide/ce-what-is.html) |
| User-Defined Cost Allocation Tags         | Guide to creating and activating custom tags for cost tracking.             | [Link](https://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/custom-tags.html) |
| AWS Budgets                               | Documentation for setting up budgets to manage AWS costs proactively.       | [Link](https://docs.aws.amazon.com/cost-management/latest/userguide/budgets-managing-costs.html) |
