<img src="https://developer.apple.com/news/images/og/notifications-og.jpg" alt="AWS Service Control Policies Workflow Diagram" width="400"/>


# VCS - Setup Notification 

## Author Information

| **Author**        | **Created on** | **Version** | **Last updated by** | **Last edited on** | **Level**   | **Reviewer**      |
|-------------------|----------------|-------------|---------------------|--------------------|-------------|-------------------|
| Tina Bhatnagar    | 11-08-25       | v1.0        | Tina Bhatnagar      | 11-08-25           | Internal    | Rohit Chopra      |

---

## Table of Content

1. [Introduction](#1-introduction)
2. [Purpose](#2-purpose)
3. [Pre-requisites](#3-pre-requisites)
4. [Steps to Set up Notifications for PR/MR Create, Update, or Comment Events](#4--steps-to-set-up-notifications-for-prmr-create-update-or-comment-events)
5. [GitHub Slack Integration (Optional)](#5-github-slack-integration-optional)
6. [Set up Notifications for Commit Push to Key Branches](#6-set-up-notifications-for-commit-push-to-key-branches)
7. [Notifications for Branch Create/Delete (GitHub Webhook)](#7-notifications-for-branch-createdelete-github-webhook)
8. [Conclusion](#8-conclusion)
9. [FAQs](#9-faqs)
10. [Contact Information](#10-contact-information)  
11. [References](#11-references)

---   

## 1. Introduction
This document outlines the setup process for enabling automated notifications in a Version Control System (VCS) to enhance team collaboration and awareness of repository changes.

---

## 2. Purpose 
The goal is to configure notifications that alert team members when:

- A code review (PR/MR) is created, updated, or commented on.
- A commit is pushed to key branches (e.g., main, develop).
- A new branch is created or deleted.

---

## 3. Pre-requisites

| Requirement | Description |
|-------------|-------------|
| **GitHub Account** | A valid GitHub account is required to access and configure repository settings. |
| **Repository Access** | Read/Write/Admin permissions to the target repository for which you want to receive notifications. |
| **Configuration Permissions** | Ability to modify repository settings and set up integrations (email, Slack, webhook, etc.) |

---

## 4.  Steps to Set up Notifications for PR/MR Create, Update, or Comment Events

- #### GitHub Email Notification Setup

#### Step 1: Sign in to GitHub and open the repository

Go to https://github.com/, log in, and open the target repository where you want PR/MR notifications.

#### Step 2: Watch the repository

- Click the Watch button at the top right.
- Select All Activity so you receive notifications for PR creation, updates, and comments.

<img width="600" height="555" alt="image" src="https://github.com/user-attachments/assets/9837a640-d488-4920-988f-6470e7e15595" />


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

<img width="600" height="463" alt="image" src="https://github.com/user-attachments/assets/99ff05ee-a100-4a9e-bc8a-83caf2d392aa" />

<img width="600" height="500" alt="image" src="https://github.com/user-attachments/assets/4bc365b3-6caa-4a2b-b124-215ed945871c" />

---

## 5. GitHub Slack Integration (Optional)

#### Step 1: Install GitHub Slack App

- Go to your Slack workspace and visit: https://slack.github.com/.
- Click Add to Slack and authorize GitHub.

<img width="600" height="512" alt="image" src="https://github.com/user-attachments/assets/5e3ad719-aa00-498a-b965-1f494f3e0ef9" />
<img width="600" height="512" alt="image" src="https://github.com/user-attachments/assets/84888102-7987-4440-b994-839d9ed1ca8b" />
<img width="600" height="512" alt="image" src="https://github.com/user-attachments/assets/f0517b06-f938-4ebb-826c-be3bec4ca400" />


#### Step 3: Subscribe your GitHub repository to a Slack channel
Go to the Slack channel and run the following command:

/github subscribe owner/repo

**Example:**
```
/github subscribe tina-snatak/sprint-2
```
<img width="600" height="332" alt="image" src="https://github.com/user-attachments/assets/d0105a6f-6403-4f4c-8ad1-b73add6d1c69" />



#### Step 4: Enable PR event notifications in Slack

```
/github subscribe owner/repo pulls comments reviews
```
**Example:**
```
/github subscribe tina-snatak/sprint-2 pulls comments reviews
```
<img width="600" height="422" alt="image" src="https://github.com/user-attachments/assets/e12c07fd-83af-4743-b58b-a3f2ad85a488" />

#### For more information, see the (https://github.com/Snaatak-Apt-Get-Swag/documentation/blob/SCURM-99-sachin/VCS/Pull-Request/POC/README.md).

---

## 6. Set up Notifications for Commit Push to Key Branches

For detailed setup instructions, check the (https://github.com/Snaatak-Apt-Get-Swag/documentation/blob/SCRUM-105-tina/VCS/Notification-System/Introduction/README.md).

---

## 7. Notifications for Branch Create/Delete (GitHub Webhook)

#### Step 1: Open Repository Settings
- Go to your GitHub repository.
- Click Settings (top menu).

<img width="600" height="533" alt="image" src="https://github.com/user-attachments/assets/9703cdc9-c8ca-49e4-acdf-f9bea605dd63" />

#### Step 2: Add a New Webhook
- From the left menu, select Webhooks.
- Click Add webhook.

<img width="600" height="624" alt="image" src="https://github.com/user-attachments/assets/bb3f6326-d620-4d5f-8e9f-f4bb23604b0f" />

#### Step 3: Configure Webhook Details
- Payload URL → Paste your Slack Incoming Webhook URL.
- Content type → Select application/json.
- Secret → You can leave this empty (not required for Slack webhooks).
#### Step 4: Save Webhook
- Click Add webhook to save the configuration.

<img width="600" height="757" alt="image" src="https://github.com/user-attachments/assets/5817e763-1fe3-4f1f-b36f-90e2ab1d034e" />
<img width="600" height="362" alt="image" src="https://github.com/user-attachments/assets/6fc65f2c-1aff-4b8b-9fcd-ad91ceb15b15" />
<img width="600" height="857" alt="image" src="https://github.com/user-attachments/assets/55960023-f1f0-4c39-8120-0b260e0c76b1" />
<img width="600" height="174" alt="image" src="https://github.com/user-attachments/assets/70194544-ae4d-4caa-b5c9-6a10c4e5a0e1" />
<img width="600" height="874" alt="image" src="https://github.com/user-attachments/assets/26d2986a-c0ce-45f7-99a2-2452840473e1" />

- Create (branch creation)
<img width="600" height="444" alt="Screenshot 2025-08-13 142402" src="https://github.com/user-attachments/assets/4f2467f7-0d04-437f-b876-9d159e76cce1" />
<img width="1036" height="382" alt="image" src="https://github.com/user-attachments/assets/62835b97-3833-41db-92e4-f0432c150188" />

- Delete (branch deletion)
<img width="600" height="123" alt="image" src="https://github.com/user-attachments/assets/275ab43c-37d4-4cea-95fe-82ea84903653" />
<img width="600" height="301" alt="image" src="https://github.com/user-attachments/assets/26ba05e6-82d2-450c-82b2-5e525bbe2b1f" />
  
---

## 8. Conclusion
This POC sets up GitHub to send automated notifications for pull requests, key branch commits, and branch creation/deletion. Email alerts use GitHub’s built-in settings, while Slack alerts use GitHub–Slack integration and webhooks. Combined, these methods deliver real-time updates for improved collaboration, visibility, and response speed.

---

## 9. FAQs

**Q1: Will I get notified for all branches using this setup?**  
Yes — if you configure the webhook for **Create** and **Delete** events without specifying branch names, it will trigger for any branch creation or deletion.

**Q2: Can I limit notifications to specific branches only?**  
Yes — in GitHub Actions or your webhook handler, you can filter events by branch name (e.g., `main`, `develop`) before sending notifications.

**Q3: Do I need admin access to configure webhooks?**  
Yes — only repository admins or users with **Manage Webhooks** permission can set up or modify webhooks.

**Q4: Is the Slack Incoming Webhook URL secure?**  
Treat it like a password — do not commit it to source control. Store it in **GitHub Secrets** or an environment variable.

**Q5: Can I test if my webhook works without creating a branch?**  
Yes — GitHub’s Webhook settings page allows you to **Redeliver** past payloads to test your integration.

**Q6: Can I use Microsoft Teams or other chat apps instead of Slack?**  
Yes — the same concept works for **Teams**, **Discord**, or any service that supports incoming webhooks.

 ---

## 10. **Contact Information**


| Name| Email Address      | GitHub | URL |
|-----|--------------------------|-------------|---------|
| Tina Bhatnagar | [tina.bhatnagar@mygurukulam.co](mailto:tina.bhatnagar@mygurukulam.co)|  tina-snatak  | https://github.com/tina-snatak/ |

---


## 11. References

| Link | Description |
|------|-------------|
| [SDet Automation – GitHub Webhook Integration](#) | Detailed guide on configuring GitHub webhooks. |
| [GitHub Webhooks Documentation](#) | Official GitHub docs for webhook events. |
| [Slack Incoming Webhooks](#) | Guide to sending messages to Slack via webhooks. |

