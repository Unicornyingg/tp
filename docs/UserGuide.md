# Resumake User Guide

## Introduction

{Give a product intro}

## Quick Start

{Give steps to get started quickly}

1. Ensure that you have Java 17 or above installed.
1. Down the latest version of `Duke` from [here](http://link.to/duke).

## Features 

{Give detailed description of each feature}

### Adding a todo: `todo`
Adds a new item to the list of todo items.

Format: `todo n/TODO_NAME d/DEADLINE`

* The `DEADLINE` can be in a natural language format.
* The `TODO_NAME` cannot contain punctuation.  

Example of usage: 

`todo n/Write the rest of the User Guide d/next week`

`todo n/Refactor the User Guide to remove passive voice d/13/04/2020`

## FAQ

**Q**: How do I transfer my data to another computer? 

**A**: {your answer here}

## Command Summary

> **Note:**
> - Parameters in UPPER_CASE are user inputs
> - Commands are case-insensitive
> - Indices are 1-based unless stated otherwise

| Action               | Format                                                                             | Example                                                                       |
|----------------------|------------------------------------------------------------------------------------|-------------------------------------------------------------------------------|
| **Add Record**       | `project / experience / cca TITLE /role ROLE /tech TECH /from YYYY-MM /to YYYY-MM` | `project "Capo CLI" /role "Developer" /tech "Java" /from 2026-01 /to 2026-03` |
| **Add Bullet**       | `addbullet RECORD_INDEX / BULLET_TEXT`                                             | `addbullet 1 "Implemented persistent storage with file IO"`                   |
| **List Records**     | `list`                                                                             | `list`                                                                        |
| **View Record**      | `view RECORD_INDEX`                                                                | `view 1`                                                                      |
| **Find Records**     | `find KEYWORD`                                                                     | `find java`                                                                   |
| **Filter by Title**  | `find TITLE`                                                                       | `find Google`                                                                 |
| **Filter by Status** | `status STATUS`                                                                    | `status in-progress`                                                          |
| **Edit Record**      | `edit RECORD_INDEX /FIELD VALUE`                                                   | `edit 1 /tech "Java, JUnit, Git"`                                             |
| **Edit Bullet**      | `editbullet RECORD_INDEX BULLET_INDEX NEW_TEXT`                                    | `editbullet 1 2 "Optimized parser with regex to support flexible commands"`   |
| **Reorder Bullets**  | `movebullet RECORD_INDEX FROM_INDEX TO_INDEX`                                      | `movebullet 1 3 1`                                                            |
| **Delete Record**    | `delete RECORD_INDEX`                                                              | `delete 2`                                                                    |
| **Delete Bullet**    | `deletebullet RECORD_INDEX BULLET_INDEX`                                           | `deletebullet 1 2`                                                            |

---