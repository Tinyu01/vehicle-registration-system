# Vehicle Registration System - User Guide

## Table of Contents
1. Introduction
2. Getting Started
3. Using the System
   - Searching for a Registration
   - Adding a New Registration
   - Viewing All Registrations
4. Data Format Guidelines
5. Troubleshooting
6. FAQ

## 1. Introduction

The Vehicle Registration System is a Java application that allows users to search for vehicle registrations, add new registrations, and view all registrations in the database. This guide will help you navigate and use the system effectively.

## 2. Getting Started

### System Requirements
- Java Runtime Environment (JRE) 8 or higher

### Running the Application
1. Download the application files
2. Open a terminal or command prompt
3. Navigate to the directory containing the application
4. Run the following command:
   ```
   java com.registrationsystem.search.RegistrationSearch
   ```

## 3. Using the System

When you start the application, you'll see the main menu with four options:
```
=== Vehicle Registration System ===
1. Search for a registration
2. Add a new registration
3. View all registrations
4. Exit
```

Enter the number of your desired option and press Enter.

### Searching for a Registration

To search for a registration:
1. Select option `1` from the main menu
2. Enter the license plate number when prompted
   - The license plate must be in the format: ABC-1234 (three letters, followed by a hyphen, followed by four digits)
   - Example: `GIG-1870`
3. The system will display the registration information if found, or notify you if no matching registration exists

Example search:
```
--- Search for a Registration ---
Enter license plate (e.g., ABC-1234): GIG-1870

Registration found:
License: GIG-1870
Owner: Harvey Kilkenny
```

### Adding a New Registration

To add a new registration:
1. Select option `2` from the main menu
2. Enter the license plate number when prompted
   - Follow the format: ABC-1234
3. Enter the owner's full name when prompted
4. The system will confirm that the registration has been added

Example:
```
--- Add a New Registration ---
Enter license plate (format: ABC-1234): XYZ-1234
Enter owner's full name: John Smith
Registration added: XYZ-1234 : John Smith
```

### Viewing All Registrations

To view all registrations in the system:
1. Select option `3` from the main menu
2. The system will display a list of all registrations with their license plates and owners

Example:
```
All Vehicle Registrations:
---------------------------
ANA-2866	: Zane Hallworth
ATZ-9783	: Sally Oakes
BJT-9772	: Karl Yardley
BYJ-6279	: Larry Newman
...
---------------------------
```

## 4. Data Format Guidelines

### License Plate Format
- Must consist of 3 uppercase letters, followed by a hyphen, followed by 4 digits
- Valid examples: ABC-1234, XYZ-9876
- Invalid examples: AB-1234, ABCD-123, ABC1234, abc-1234

### Owner Name Format
- Must not be empty
- Should be the person's full name
- Examples: John Smith, Mary Johnson, Robert Williams

## 5. Troubleshooting

### Common Issues

**Issue**: Invalid license plate format error
**Solution**: Ensure you're using the ABC-1234 format (three letters, hyphen, four digits)

**Issue**: Registration not found
**Solution**: 
- Double-check the license plate number for typos
- Make sure you've entered it in the correct format with uppercase letters
- The registration may not exist in the database

**Issue**: Duplicate license plate error when adding a registration
**Solution**: Each license plate must be unique. Choose a different license plate number or update the existing registration.

## 6. FAQ

**Q: Can I export the registration data?**
A: The current version doesn't support data export. This feature may be added in future versions.

**Q: Is the data saved when I add a new registration?**
A: In this demonstration version, data is only stored in memory during the current session. When you exit the application, any new registrations will be lost.

**Q: Can I modify an existing registration?**
A: The current version doesn't support updating existing registrations. You can add new registrations or search for existing ones.

**Q: How many registrations can the system handle?**
A: The system can handle a large number of registrations. Performance remains efficient due to the binary search algorithm.

**Q: What happens if I enter lowercase letters in the license plate?**
A: The system automatically converts lowercase letters to uppercase when processing your input.