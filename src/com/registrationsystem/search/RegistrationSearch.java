package com.registrationsystem.search;

import com.registrationsystem.model.Registration;
import com.registrationsystem.data.Database;

/**
 * Implements binary search to find vehicle registrations by license plate number.
 */
public class RegistrationSearch {

    private Registration[] registrations;

    /**
     * Initializes the search with registration data from the database.
     */
    public RegistrationSearch() {
        Database db = new Database();
        registrations = db.getRegistrations();
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
     * Prints all registrations in the database.
     */
    public void printAll() {
        for(Registration reg : registrations) {
            System.out.println(reg);
        }
    }
    
    /**
     * Main method to demonstrate the registration search functionality.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // License plate to search for
        String license = "GIG-1870";
        
        // Create a registration search instance
        RegistrationSearch regSearch = new RegistrationSearch();
        System.out.println();
        
        // Search for the registration
        Registration result = regSearch.search(license);
        
        // Display the result
        if (result != null) {
            System.out.println(result);
        } else {
            System.out.println("Error: Registration with license " + license + " not found.");
        }
    }
}