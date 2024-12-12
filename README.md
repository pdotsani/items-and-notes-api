# Theranotes

## Overview
Created by Patrick San Juan and Sabine Scott

The url of the deployed app is: https://notes-and-items-fe.uc.r.appspot.com

frontend:
[https://github.com/pdotsani/items-and-notes-fe](https://github.com/pdotsani/items-and-notes-fe)

Theranotes is a webapp designed to help a massage / physical 
therapist with their day to day administrative work by creating 
"doctor's notes" for their patients. In addition to current diagnosis,
Theranotes also helps provide comprehensive treatment plans to 
better prepare the therapist for future appointments.

## Data
Each note created by Theranotes will have the following data:
- Summary: Consisting of patient name and owner
- Treatment plan: Consisting of patient name and owner

Non-persistent data on the fe:
- Items: The 'outline' for a note. This piece of data is used by
openAI to generate a medical note.

## AI Description
AI will be used in a couple of ways. Firstly, we will use prompts to 
engineer medical notes with the "items" provided. Secondly, we will use 
AI to generate a treatment plan, that the user can save to 
view later.


## Using the App
First, the user enters the name of the patient. Then the user selects the
body part in question from a drop-down menu. The next dropdown menu lists the 
muscles in that part of the body for the user to select. Then, the user types 
in a memo into the memo section. Two blocks of text will be generated using this
data. First, a paragraph which describes the issue the patient has including the 
specific location of the pain, and second, a treatment plan for the patient specific
to the issue in question. 

## Note to Prof
We were working through some issues in version control and our commits got misaligned and
permissions stopped working so Sabine was not able to commit/push the final changes to LoginForm.js and LoginForm.css which consisted of adding a title and font color. (Patrick committed those changes)

## Building the Project
We met several times to discuss architecture, work on features and debug the application.
Sabine made several adds to the backend and frontend, including adding a file to index 
the data so we could sort by date, and adding some style to the login page. Patrick created
some of the foundational work with the controller, api, and frontend. There was much discussion
on UI / UX that was mutually collaborative.

Moving forward, Patrick will continue to work with his friend who is a Massage Therapist
to make the app something he can use daily in his private practice.

## Videos: 
Demo video of the application: 
https://youtu.be/CUL_j3JAmVs




