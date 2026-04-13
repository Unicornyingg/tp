# justinpoonjj - Project Portfolio Page

## Overview

**ResuMake CLI** is a Java command-line application that helps users manage resume content such as projects, experiences, CCAs, and bullet points. Users interact with the application through text commands, which are parsed into command objects and executed against the resume record list.

Given below are my contributions to the project.

## Summary of Contributions

### Code Contributed

- Functional code and tests: [RepoSense link](https://nus-cs2113-ay2526-s2.github.io/tp-dashboard/?search=&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2026-02-20T00%3A00%3A00&filteredFileName=)

### Enhancements Implemented

- **Parser for command interpretation**: Implemented and improved parsing of raw user input into executable commands, including add, edit, delete, and bullet-related commands. Added validation for malformed formats, missing fields, field order, invalid command flags, invalid indices, and date formats.

- **Consistent exception-based parsing**: Refactored parser error handling to use `ResumakeException` more consistently instead of relying on `null` command returns. This makes parser failures clearer and helps the main application loop display user-facing error messages without crashing.

- **Add-record command flow**: Integrated `project`, `experience`, and `cca` commands with the shared `Record` abstraction and record subclasses (`Project`, `Experience`, `Cca`). Added duplicate record checks so identical records are rejected before being added.

- **Bullet-point support**: Implemented and improved `AddBulletCommand` so users can add bullet points to existing records. Added validation for invalid record indices, blank bullets, and duplicate bullets.

- **Add bullets during record creation**: Enhanced `AddCommand` so users can add bullet points immediately after creating a record. The flow supports repeated bullet entry until `esc`, handles blank and duplicate bullets, and re-prompts when users enter an invalid `y/n` answer instead of silently skipping bullet entry.

- **Tests and regression coverage**: Added and expanded tests for `Parser`, `AddCommand`, `AddBulletCommand`, `Record`, and `Resumake`. Covered duplicate records, duplicate bullets, blank bullet input, invalid prompt input, invalid command formats, and add-record flows.

- **Code quality**: Added Javadocs for newly introduced public APIs where needed, reformatted `Parser` to satisfy checkstyle rules, standardized user-facing error messages, and used Java logging to trace parser and command execution paths during debugging.

### Contributions to the User Guide

- Documented the command formats for adding records and bullet points.
- Clarified required field order, date format expectations, and examples for commands I worked on.
- Updated the add-record workflow to explain that users can add bullet points immediately after creating a record.

### Contributions to the Developer Guide

- Documented the `Parser` component and how parsed input is converted into command objects.
- Explained how parser output connects to command execution and the `Record` model.
- Added implementation notes for validation and exception handling decisions in the parser flow.

### Contributions to Team-Based Tasks

- Helped structure the core application flow from `Parser` to `Command` execution and storage.
- Contributed to discussions on exception handling, command consistency, and parser behavior.
- Reviewed teammates' code and provided feedback on command structure and parsing logic.

### Tools

- Used JUnit for parser and command testing.
- Used Gradle (`test`, `checkstyleMain`, `checkstyleTest`) for verification.
- Used Java logging for debugging and tracing command behavior.
