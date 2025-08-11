<img src="https://developer.apple.com/news/images/og/notifications-og.jpg" alt="AWS Service Control Policies Workflow Diagram" width="400"/>



# VCS - Setup Notification 

## Author Information

| **Author**        | **Created on** | **Version** | **Last updated by** | **Last edited on** | **Level**   | **Reviewer**      |
|-------------------|----------------|-------------|----------------------|--------------------|-------------|-------------------|
| Tina Bhatnagar     | 11-08-25       | v1.0        | Tina Bhatnagar       | 11-08-25           | Internal    | Rohit Chopra      |

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


##  Steps to Set up Email Notification

### 1. **Sign in to GitHub**: Go to [GitHub](https://github.com) and log in to your account.
![codecommit drawio (2)](https://github.com/vardaan412/snaatak_phase/blob/9f297e6da5dd54ce6c73cca4781bfaed2f072ffc/commit-img/1.png)


### 2. Create a repository for which you want to configure notifications for code commits.

![Screenshot 2024-09-23 164450](https://github.com/vardaan412/snaatak_phase/blob/9f297e6da5dd54ce6c73cca4781bfaed2f072ffc/commit-img/2.png)

### 3. Now, click on the repository you created and navigate to the Settings tab at the top.

![Screenshot 2024-09-23 173912](https://github.com/vardaan412/snaatak_phase/blob/9f297e6da5dd54ce6c73cca4781bfaed2f072ffc/commit-img/3.png)

### 4. Generate an App Password for Gmail: If you are using Gmail, you'll need to generate an App Password for your Google account:

**Go to your Google Account.**

**Navigate to Security -> Signing in to Google -> App Passwords.**

**Choose Mail and select your device, then generate a password and copy it.**

![Screenshot 2024-09-23 200443](https://github.com/vardaan412/snaatak_phase/blob/9f297e6da5dd54ce6c73cca4781bfaed2f072ffc/commit-img/4.png)

### 5. Set up GitHub Action Workflow:

**Create a GitHub Actions workflow file in your repository to send an email when a code commit is made.**

**In your GitHub repository, create a workflow file in .github/workflows/ (e.g., send-email-on-codecommit.yml):**


```yaml
name: Send Commit Email

on:
  push:
    branches:
      - main

jobs:
  email_notify:
    runs-on: ubuntu-latest
    steps:
      - name: Send Commit Notification Email
        uses: dawidd6/action-send-mail@v3
        with:
          server_address: smtp.gmail.com
          server_port: 465
          username: ${{ secrets.EMAIL_USERNAME }}
          password: ${{ secrets.EMAIL_PASSWORD }}
          subject: "📬 New Commit to ${{ github.repository }}"
          to: saxenavardaan18@gmail.com
          from: GitHub Actions <${{ secrets.EMAIL_USERNAME }}>
          html_body: |
            <h2>✅ New Commit Notification</h2>
            <p><strong>📁 Repository:</strong> ${{ github.repository }}</p>
            <p><strong>🌿 Branch:</strong> ${{ github.ref_name }}</p>
            <p><strong>✍️ Author:</strong> ${{ github.event.head_commit.author.name }} &lt;${{ github.event.head_commit.author.email }}&gt;</p>
            <p><strong>📝 Message:</strong> ${{ github.event.head_commit.message }}</p>
            <p><a href="https://github.com/${{ github.repository }}/commit/${{ github.sha }}">🔗 View Commit on GitHub</a></p>
```

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

##  Contact Information 
|Name|Email Address|
|:---:|:---:|
|**Vardaan Saxena**|vardaan.saxena.snaatak@mygurukulam.co |
