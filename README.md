# Vehicle Registration System

A Java application for managing and searching vehicle registrations using binary search algorithm. This system allows users to search for registrations, add new registrations, and view all registrations in the database.

## Overview

This repository contains a simple vehicle registration management system that demonstrates:
- Object-oriented programming in Java
- Data storage using collections (ArrayList, TreeMap)
- Binary search algorithm implementation
- Interactive command-line interface
- User input validation

## Table of Contents
- [Project Structure](#project-structure)
- [Classes](#classes)
- [Features](#features)
- [How It Works](#how-it-works)
- [Implementation Details](#implementation-details)
- [How to Run](#how-to-run)
- [User Guide](#user-guide)
- [Sample Output](#sample-output)

## Project Structure

```
vehicle-registration-system/
├── src/
│   ├── com/
│   │   └── registrationsystem/
│   │       ├── model/
│   │       │   └── Registration.java
│   │       ├── data/
│   │       │   └── Database.java
│   │       └── search/
│   │           └── RegistrationSearch.java
├── docs/
│   └── UserGuide.md
├── README.md
└── LICENSE
```

## Classes

### Registration

Stores information about a vehicle registration:
- License plate number
- Owner name

### Database

Manages a collection of registrations:
- Stores registrations in a TreeMap (sorted by license plate)
- Provides array access to the sorted registrations
- Contains sample registration data
- Allows adding new registrations

### RegistrationSearch

Implements binary search and user interaction:
- Searches by license plate number using binary search
- Provides an interactive command-line interface
- Handles user input for searching and adding registrations
- Validates user input for correct formatting

## Features

- **Search for Registrations**: Quickly find vehicle registrations using binary search
- **Add New Registrations**: Add new registrations to the system
- **View All Registrations**: Display all registrations in the database
- **User Input Validation**: Ensures license plates follow the correct format
- **Interactive Menu System**: Easy-to-use command-line interface

## How It Works

1. The application displays a menu with options for searching, adding, viewing, or exiting
2. User selects an option and follows the prompts
3. For searches, binary search efficiently finds registrations by license plate
4. New registrations are added to the system (in memory for this version)
5. Results are displayed to the user

## Implementation Details

### Binary Search Algorithm

The binary search implementation:
1. Initializes left and right indices
2. Computes the middle index
3. Compares the target license plate with the middle element
4. Adjusts search boundaries based on comparison
5. Repeats until the element is found or the search space is exhausted

The time complexity is O(log n), making it efficient for searching large datasets.

### Data Format

- License plates must follow the format: ABC-1234 (three letters, hyphen, four digits)
- Owner names should be non-empty strings representing the vehicle owner's full name

## How to Run

```bash
# Compile the Java files
javac com/registrationsystem/model/Registration.java
javac com/registrationsystem/data/Database.java
javac com/registrationsystem/search/RegistrationSearch.java

# Run the RegistrationSearch class
java com.registrationsystem.search.RegistrationSearch
```

## User Guide

See the [User Guide](docs/UserGuide.md) for detailed instructions on using the system.

## Sample Output

### Main Menu:
```
=== Vehicle Registration System ===
1. Search for a registration
2. Add a new registration
3. View all registrations
4. Exit
Enter your choice (1-4):
```

### Searching for a Registration:
```
--- Search for a Registration ---
Enter license plate (e.g., ABC-1234): GIG-1870

Registration found:
License: GIG-1870
Owner: Harvey Kilkenny
```

### Adding a New Registration:
```
--- Add a New Registration ---
Enter license plate (format: ABC-1234): ABC-1234
Enter owner's full name: John Smith
Registration added: ABC-1234 : John Smith
```