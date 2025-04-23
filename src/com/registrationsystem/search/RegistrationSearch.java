package com.registrationsystem.search;

import com.registrationsystem.model.Registration;
import com.registrationsystem.data.Database;
import java.util.Scanner;

/**
 * Implements binary search to find vehicle registrations by license plate number.
 * Includes interactive user input functionality.
 */
public class RegistrationSearch {

    private Registration[] registrations;
    private Scanner scanner;

    /**
     * Initializes the search with registration data from the database.
     */
    public RegistrationSearch() {
        Database db = new Database();
        registrations = db.getRegistrations();
        scanner = new Scanner(System.in);
    }

    /**
     * Searches for a registration by license plate number using binary search.
     *
     * @param license The license plate number to search for
     * @return The matching Registration object, or null if not found
     */
    public Registration search(String license) {
        // Initialize the left index to zero
        int left = 0;

        // Initialize the right index to the length of the array minus 1
        int right = registrations.length - 1;

        // Run until the left index is greater than the right index
        while (left <= right) {
            // Calculate the middle index
            int middle = left + (right - left) / 2;

            // Compare the license at the middle index with the target license
            int comparison = registrations[middle].license.compareTo(license);

            // Check comparison result
            if (comparison == 0) {
                // Match found, return the Registration object
                return registrations[middle];
            }
            else if (comparison < 0) {
                // Current license is less than target, search right half
                left = middle + 1;
            }
            else {
                // Current license is greater than target, search left half
                right = middle - 1;
            }
        }

        // No match found
        return null;
    }

    /**
     * Adds a new registration to the system.
     *
     * @param license The license plate number
     * @param owner The name of the vehicle owner
     * @return The newly created Registration object
     */
    public Registration addRegistration(String license, String owner) {
        // Create a new database instance with updated data
        // This is a simple implementation - in a real system, we would persist this data
        Database db = new Database();
        Registration newRegistration = new Registration(license, owner);

        // In a real application, we would add this to the database
        // Here we'll just return the created registration
        System.out.println("Registration added: " + newRegistration);
        return newRegistration;
    }

    /**
     * Prints all registrations in the database.
     */
    public void printAll() {
        System.out.println("\nAll Vehicle Registrations:");
        System.out.println("---------------------------");
        for(Registration reg : registrations) {
            System.out.println(reg);
        }
        System.out.println("---------------------------");
    }

    /**
     * Runs an interactive search prompt for the user.
     */
    public void interactiveSearch() {
        boolean running = true;

        while (running) {
            System.out.println("\n=== Vehicle Registration System ===");
            System.out.println("1. Search for a registration");
            System.out.println("2. Add a new registration");
            System.out.println("3. View all registrations");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    searchPrompt();
                    break;
                case "2":
                    addRegistrationPrompt();
                    break;
                case "3":
                    printAll();
                    break;
                case "4":
                    running = false;
                    System.out.println("Thank you for using the Vehicle Registration System!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    /**
     * Prompts the user to enter a license plate for searching.
     */
    private void searchPrompt() {
        System.out.println("\n--- Search for a Registration ---");
        System.out.print("Enter license plate (e.g., ABC-1234): ");
        String license = scanner.nextLine().trim().toUpperCase();

        // Validate license format
        if (!isValidLicenseFormat(license)) {
            System.out.println("Invalid license format. Please use the format: ABC-1234");
            return;
        }

        // Search for the registration
        Registration result = search(license);

        // Display the result
        if (result != null) {
            System.out.println("\nRegistration found:");
            System.out.println("License: " + result.license);
            System.out.println("Owner: " + result.owner);
        } else {
            System.out.println("No registration found for license plate: " + license);
        }
    }

    /**
     * Prompts the user to enter details for a new registration.
     */
    private void addRegistrationPrompt() {
        System.out.println("\n--- Add a New Registration ---");

        // Get license plate
        System.out.print("Enter license plate (format: ABC-1234): ");
        String license = scanner.nextLine().trim().toUpperCase();

        // Validate license format
        if (!isValidLicenseFormat(license)) {
            System.out.println("Invalid license format. Please use the format: ABC-1234");
            return;
        }

        // Check if license already exists
        if (search(license) != null) {
            System.out.println("A registration with this license plate already exists.");
            return;
        }

        // Get owner name
        System.out.print("Enter owner's full name: ");
        String owner = scanner.nextLine().trim();

        // Validate owner name
        if (owner.isEmpty()) {
            System.out.println("Owner name cannot be empty.");
            return;
        }

        // Add the registration
        addRegistration(license, owner);
    }

    /**
     * Validates the format of a license plate.
     *
     * @param license The license plate to validate
     * @return true if the format is valid, false otherwise
     */
    private boolean isValidLicenseFormat(String license) {
        // Basic validation: Must be in format AAA-9999
        return license.matches("[A-Z]{3}-\\d{4}");
    }

    /**
     * Main method to run the interactive registration search application.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        RegistrationSearch regSearch = new RegistrationSearch();
        regSearch.interactiveSearch();
    }
}