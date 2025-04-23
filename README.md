# Vehicle Registration System

A Java application for managing and searching vehicle registrations using binary search algorithm.

## Overview

This repository contains a simple vehicle registration management system that demonstrates:
- Object-oriented programming in Java
- Data storage using collections (ArrayList, TreeMap)
- Binary search algorithm implementation
- Basic file organization

## Table of Contents
- [Project Structure](#project-structure)
- [Classes](#classes)
- [How It Works](#how-it-works)
- [Implementation Details](#implementation-details)
- [How to Run](#how-to-run)
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

### RegistrationSearch

Implements binary search to find registrations:
- Searches by license plate number
- Demonstrates efficient search in a sorted array
- Includes a main method to demonstrate functionality

## How It Works

1. The `Database` class initializes with a predefined set of registrations
2. Registrations are stored in a TreeMap to ensure they're sorted by license plate number
3. The `RegistrationSearch` class retrieves the sorted array of registrations
4. Binary search is used to efficiently find a registration by license plate number
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

## How to Run

```bash
# Compile the Java files
javac com/registrationsystem/model/Registration.java
javac com/registrationsystem/data/Database.java
javac com/registrationsystem/search/RegistrationSearch.java

# Run the RegistrationSearch class
java com.registrationsystem.search.RegistrationSearch
```

## Sample Output

When searching for license plate "GIG-1870":
```
GIG-1870	: Harvey Kilkenny
```

When searching for a non-existent license plate:
```
Error: Registration with license ABC-1234 not found.
```