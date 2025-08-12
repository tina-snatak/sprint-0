<img src="https://developer.apple.com/news/images/og/notifications-og.jpg" alt="AWS Service Control Policies Workflow Diagram" width="400"/>


# VCS - Setup Notification 

## Author Information

| **Author**        | **Created on** | **Version** | **Last updated by** | **Last edited on** | **Level**   | **Reviewer**      |
|-------------------|----------------|-------------|---------------------|--------------------|-------------|-------------------|
| Tina Bhatnagar    | 11-08-25       | v1.0        | Tina Bhatnagar      | 11-08-25           | Internal    | Rohit Chopra      |

---

# Table of Content 
1. [ Purpose](#purpose)
2. [ Prerequisites](#prerequisites)
3. [Steps to Set up Email Notificatin](#steps-to-set-up-email-notification)
4. [ Conclusion](#conclusion)
5. [ References](#references ) 
6. [ Contact Information ](#contact-information )
   

#  Introduction
This document outlines the setup process for enabling automated notifications in a Version Control System (VCS) to enhance team collaboration and awareness of repository changes.

     
#  Purpose 
The goal is to configure notifications that alert team members when:

- A code review (PR/MR) is created, updated, or commented on.
- A commit is pushed to key branches (e.g., main, develop).
- A new branch is created or deleted.


## Pre-requisites

| Requirement | Description |
|-------------|-------------|
| **GitHub Account** | A valid GitHub account is required to access and configure repository settings. |
| **Repository Access** | Read/Write/Admin permissions to the target repository for which you want to receive notifications. |
| **Configuration Permissions** | Ability to modify repository settings and set up integrations (email, Slack, webhook, etc.). |

---

### 1.  Steps to Set up Notifications for PR/MR Create, Update, or Comment Events

- #### GitHub Email Notification Setup

#### Step 1: Sign in to GitHub and open the repository

Go to https://github.com/, log in, and open the target repository where you want PR/MR notifications.

#### Step 2: Watch the repository

- Click the Watch button at the top right.
- Select All Activity so you receive notifications for PR creation, updates, and comments.

<img width="700" height="555" alt="image" src="https://github.com/user-attachments/assets/9837a640-d488-4920-988f-6470e7e15595" />


#### Step 3: Configure email notifications

- Click your profile icon → Settings.
- Go to Notifications in the left sidebar.
- Under Participating & @mentions, check Email.

<img width="600" height="532" alt="image" src="https://github.com/user-attachments/assets/78d460e5-4e92-46bb-989b-ed49ee6e28ad" />

<img width="600" height="440" alt="image" src="https://github.com/user-attachments/assets/4901487b-d2a7-450e-a4e9-706c02aa066b" />


#### Step 4: Customize PR event triggers

In Customize email updates, enable:

- Pull Request opened
- Pull Request updated
- Pull Request review comment
- Click Save

<img width="700" height="463" alt="image" src="https://github.com/user-attachments/assets/99ff05ee-a100-4a9e-bc8a-83caf2d392aa" />

<img width="700" height="500" alt="image" src="https://github.com/user-attachments/assets/4bc365b3-6caa-4a2b-b124-215ed945871c" />

### 2. GitHub Slack Integration (Optional)

#### Step 1: Install GitHub Slack App

- Go to your Slack workspace and visit: https://slack.github.com/.
- Click Add to Slack and authorize GitHub.

<img width="700" height="512" alt="image" src="https://github.com/user-attachments/assets/5e3ad719-aa00-498a-b965-1f494f3e0ef9" />
<img width="700" height="512" alt="image" src="https://github.com/user-attachments/assets/84888102-7987-4440-b994-839d9ed1ca8b" />
<img width="700" height="512" alt="image" src="https://github.com/user-attachments/assets/f0517b06-f938-4ebb-826c-be3bec4ca400" />


#### Step 3: Subscribe your GitHub repository to a Slack channel
Go to the Slack channel and run the following command:

/github subscribe owner/repo

**Example:**
```
/github subscribe tina-snatak/sprint-2
```
<img width="600" height="422" alt="image" src="https://github.com/user-attachments/assets/d235c37b-0e6f-434f-8a09-2d2472b52bfb" />

#### Step 4: Enable PR event notifications in Slack

```
/github subscribe owner/repo pulls comments reviews
```
**Example:**
```
/github subscribe tina-snatak/sprint-2 pulls comments reviews
```
<img width="600" height="422" alt="image" src="https://github.com/user-attachments/assets/e12c07fd-83af-4743-b58b-a3f2ad85a488" />


### 6. Add Gmail Credentials to GitHub Secrets:

**Go to your GitHub repository.**

**Click on Settings -> Secrets -> Actions -> New repository secret.**

**Add two secrets:**

**EMAIL_USERNAME: Your Gmail address (e.g., your-email@gmail.com).**

**EMAIL_PASSWORD: The App Password you generated earlier from Gmail.**

![Screenshot 2024-09-23 200808](https://github.com/vardaan412/snaatak_phase/blob/9f297e6da5dd54ce6c73cca4781bfaed2f072ffc/commit-img/6.png)

### 7. Commit and Push the Workflow File:

**Once you add the workflow file, every time a commit is pushed to the specified repo (e.g., code-commit-demo), the GitHub Action will send an email with the details of the commit (message, author, and URL).**

![Screenshot 2024-09-23 235555](https://github.com/vardaan412/snaatak_phase/blob/9f297e6da5dd54ce6c73cca4781bfaed2f072ffc/commit-img/7.png)

![Screenshot 2024-09-23 235555](https://github.com/vardaan412/snaatak_phase/blob/9f297e6da5dd54ce6c73cca4781bfaed2f072ffc/commit-img/8.png)

##  Conclusion
The POC successfully demonstrates an automated email notification system for new code commits, in a GitHub repository. It uses GitHub Actions and a secure email integration via Gmail credentials. This solution ensures timely notifications for relevant code changes while filtering out unnecessary merge events.
 
##  References 
|links | Description |
|-------|------------|
|https://youtu.be/oMU9MUIXPyI?feature=shared%7C**Rainbow talks** |
|https://www.youtube.com/watch?v=qToZN5S67AM%7C **SDet Automation**|
|https://tinyurl.com/bdpf3ajc%7C**GIT**%7C

