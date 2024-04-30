# Online Version Control File System

## Overview

The Online Version Control File System is a web-based version control system designed to manage files and folders similar to Git, but with the constraint of being available only online. This system ensures strong concurrency and read capability, prioritizing read operations over write operations to prevent obstruction during concurrent operations. It provides APIs to display files, perform file and folder operations, view differences (diffs), handle conflicts, and perform merges. Binary files are ignored in this system.

## Features

- **File and Folder Management**: Create, read, update, and delete files and folders.
- **Conflicts Resolution**: Handle conflicts that arise during merges or updates.
- **Merges**: Perform merges between different versions of files.

## Getting Started

To get started with the Online Version Control File System, follow these steps:

1. **Clone the Repository**: Clone the repository to your local machine.
2. **Install Dependencies**: Install any dependencies required for the project.
3. **Configure Database**: Set up the database connection in the `application.properties` file.
4. **Build and Run**: Build and run the application using your preferred IDE or the command line.
5. **Explore APIs**: Explore the provided APIs to perform file and folder operations, view diffs, handle conflicts, and perform merges.

## Usage

- **File Operations**:
  - Use the provided APIs to create, read, update, and delete files.
  - Files are stored in folders, and folder structure can be managed using folder APIs.

- **Folder Operations**:
  - Use the folder APIs to create, read, update, and delete folders.
  - Manage folder hierarchy to organize files.

- **Diffs and Conflicts**:
  - Use the provided APIs to view differences (diffs) between file versions.
  - Handle conflicts that arise during merges or updates.

- **Merges**:
  - Perform merges between different versions of files to incorporate changes.


