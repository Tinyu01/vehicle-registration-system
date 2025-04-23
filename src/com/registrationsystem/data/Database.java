package com.registrationsystem.data;

import com.registrationsystem.model.Registration;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Stores and manages vehicle registration data.
 * Uses TreeMap to maintain registrations sorted by license plate.
 */
public class Database {
    private TreeMap<String, Registration> treeMap = new TreeMap<>();
    private Registration[] registrations;
    private ArrayList<Registration> registrationList;

    /**
     * Initializes the database with sample registration data.
     * Stores registrations in both a TreeMap and a sorted array.
     */
    public Database() {
        // Initialize the list of registrations
        registrationList = new ArrayList<>(30);
        registrationList.add(new Registration("SGL-6855", "Tyler Lennon"));
        registrationList.add(new Registration("SDN-2659", "Margaret Jeffers"));
        registrationList.add(new Registration("ANA-2866", "Zane Hallworth"));
        registrationList.add(new Registration("DYC-5707", "Jodi Gatfield"));
        registrationList.add(new Registration("GIG-1870", "Harvey Kilkenny"));
        registrationList.add(new Registration("NWK-2057", "Janice Hudson"));
        registrationList.add(new Registration("BYJ-6279", "Larry Newman"));
        registrationList.add(new Registration("ENY-2915", "Helen Pryor"));
        registrationList.add(new Registration("OYW-0632", "Quincy Cromwell"));
        registrationList.add(new Registration("KEC-3996", "Kathy Myers"));
        registrationList.add(new Registration("HOZ-1224", "Hugh Haines"));
        registrationList.add(new Registration("KGJ-5010", "Tammy Mallard"));
        registrationList.add(new Registration("FVA-4467", "Michael Knowles"));
        registrationList.add(new Registration("NEV-9119", "Michael Knowles"));
        registrationList.add(new Registration("BJT-9772", "Karl Yardley"));
        registrationList.add(new Registration("YQD-3410", "Andrea Elsworth"));
        registrationList.add(new Registration("DUY-0288", "Jay Zagorski"));
        registrationList.add(new Registration("ATZ-9783", "Sally Oakes"));
        registrationList.add(new Registration("IAG-6602", "Patrick Hewitt"));
        registrationList.add(new Registration("DCP-2974", "Donna Wardman"));
        registrationList.add(new Registration("FAH-2515", "Jay Newton"));
        registrationList.add(new Registration("GYF-3958", "Carla Collins"));
        registrationList.add(new Registration("NCL-9068", "James McBride"));
        registrationList.add(new Registration("UBJ-1923", "Helen Gibbs"));
        registrationList.add(new Registration("UUG-4837", "Conrad Pryor"));
        registrationList.add(new Registration("GMD-6786", "Tracy Gilbert"));
        registrationList.add(new Registration("QTW-6473", "Donald Gatfield"));
        registrationList.add(new Registration("QQE-3264", "Charlotte Newport"));
        registrationList.add(new Registration("WAO-8258", "Rodney Gilbert"));

        updateDataStructures();
    }

    /**
     * Updates internal data structures based on the registration list.
     * This rebuilds the TreeMap and array from the ArrayList.
     */
    private void updateDataStructures() {
        // Clear and rebuild the TreeMap
        treeMap.clear();
        for (Registration reg : registrationList) {
            treeMap.put(reg.license, reg);
        }

        // Convert TreeMap values to an array
        registrations = treeMap.values().toArray(new Registration[0]);
    }

    /**
     * Gets the array of registrations sorted by license plate.
     *
     * @return An array of Registration objects sorted by license plate
     */
    public Registration[] getRegistrations() {
        return registrations;
    }

    /**
     * Adds a new registration to the database.
     *
     * @param registration The Registration object to add
     * @return true if added successfully, false if a registration with that license already exists
     */
    public boolean addRegistration(Registration registration) {
        // Check if registration with this license already exists
        if (treeMap.containsKey(registration.license)) {
            return false;
        }

        // Add to ArrayList
        registrationList.add(registration);

        // Update TreeMap and array
        updateDataStructures();

        return true;
    }

    /**
     * Removes a registration from the database.
     *
     * @param license The license plate of the registration to remove
     * @return true if removed successfully, false if not found
     */
    public boolean removeRegistration(String license) {
        // Find the registration in the ArrayList
        for (int i = 0; i < registrationList.size(); i++) {
            if (registrationList.get(i).license.equals(license)) {
                registrationList.remove(i);
                updateDataStructures();
                return true;
            }
        }

        return false;
    }
}