package com.registrationsystem.model;

/**
 * Represents a vehicle registration with license plate and owner information.
 */
public class Registration {
    public String license;
    public String owner;

    /**
     * Creates a new registration with the specified license plate and owner.
     *
     * @param license The license plate number
     * @param owner The name of the vehicle owner
     */
    public Registration(String license, String owner) {
        this.license = license;
        this.owner = owner;
    }

    /**
     * Returns a string representation of the registration.
     *
     * @return A string in the format "license : owner"
     */
    @Override
    public String toString() {
        return license + "\t: " + owner;
    }
}