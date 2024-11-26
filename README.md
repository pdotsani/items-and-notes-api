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
