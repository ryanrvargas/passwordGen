package com.example.passwordgenerator;
/*
 * @author Ryan Vargas
 * Date: April 23, 2025
 * Section: 331 002
 *
 */
import java.util.ArrayList;

/**
 * The passwordGenerator class is used to generate random passwords
 * and store them in a list for later retrieval.
 */
public class passwordGenerator implements passwordInterface {

    passwordChecker pc = new passwordChecker();

    /** The most recently generated password */
    private String password;

    /** Desired length of each password */
    private int length;


    /** Character set used for generating passwords */
    private final String c = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()_+-={}[]|:;<>,.?/";

    /** List of all saved passwords */
    ArrayList<String> savedP = new ArrayList<String>();
    /** List of all temporary passwords */
    ArrayList<String> tempP = new ArrayList<String>();

    /**
     * Constructor to initialize the password generator with a given length.
     * @param length The desired length of the password
     */
    public passwordGenerator(int length){
        this.length = length;
        this.password = "";
    }
    /**
     * Default constructor (length should be set later via setLength).
     */
    public passwordGenerator() {
        this.password = "";
    }

    /**
     * Returns the list of saved passwords.
     * @return ArrayList of saved passwords
     */
    public ArrayList<String> getSavedPasswords() {
        return this.savedP;
    }

    /**
     * Returns the list of temporary passwords (most recent).
     * @return ArrayList of temporary passwords
     */
    public ArrayList<String> getTempPasswords() {
        return this.tempP;
    }


    /**
     * Generates a new random password of the current length,
     * adds it to the temporary password list, and resets the internal password field.
     */
    public void generateP(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++){
            sb.append(c.charAt((int)(Math.random() * c.length())));
        }
        this.password = sb.toString(); // Save the new password
        tempP.add(this.password);
    }
    /**
     * Gets the most recently generated password.
     * @return The last generated password, or a message if none have been generated
     */
    public String getLastPassword(){
        if (this.tempP.size() > 0){
            return this.tempP.get(this.tempP.size() - 1);
        }
        else{
            return "No saved passwords";
        }
    }
    /**
     * Sets the length of the passwords to be generated.
     * @param length Desired password length
     */
    public void setLength(int length) {
        if (length < 8){
            throw new IllegalArgumentException("Length must be at least 8 characters");
        } else if (length > 40){
            throw new IllegalArgumentException("Length must be at most 40 characters");
        }
        this.length = length;

    }
}
