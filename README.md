# Items and Notes

## Overview
frontend:
[https://github.com/pdotsani/items-and-notes-fe](https://github.com/pdotsani/items-and-notes-fe)

Items and nots is a webapp designed to help a massage / physical 
therapist with their day to day administrative work by creating 
"doctor's notes" for their patients. In addition to current diagnosis,
Items and Notes also helps provide comprehensive treatment plans to 
better prepare the therapist for future appointments.

## Data
Items and Notes will have the following data:
- Notes: Consisting of patient name and owner
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


## Features Which We May Add Later
-New feature which allows the use to delete past notes
-New feature which allows user to copy text in notes to clipboard


