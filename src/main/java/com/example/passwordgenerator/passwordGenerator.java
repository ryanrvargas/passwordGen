package com.example.passwordgenerator;

import java.util.ArrayList;

/**
 * The passwordGenerator class is used to generate random passwords
 * and store them in a list for later retrieval.
 */
public class passwordGenerator {

    passwordChecker pc = new passwordChecker();

    /** The most recently generated password */
    private String password;

    /** Desired length of each password */
    private int length;


    /** Character set used for generating passwords */
    private final String c = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()_+-={}[]|:;<>,.?/";

    /** List of all previously generated passwords */
    ArrayList<String> savedP = new ArrayList<String>();
    ArrayList<String> tempP = new ArrayList<String>();

    /**
     * Constructor to initialize the password generator with a given length.
     * @param length The desired length of the password
     */
    public passwordGenerator(int length){
        this.length = length;
        this.password = "";
    }

    public passwordGenerator() {
        this.password = "";
    }

    /**
     * Prints all previously saved passwords to the console.
     * Each password is listed with its corresponding index.
     */
    public ArrayList<String> getSavedPasswords() {
        return this.savedP;
    }

    public ArrayList<String> getTempPasswords() {
        return this.tempP;
    }


    /**
     * Generates a new random password of the specified length,
     * adds it to the list of saved passwords, and resets the internal password field.
     */
    public void generateP(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++){
            sb.append(c.charAt((int)(Math.random() * c.length())));
        }
        this.password = sb.toString(); // Save the new password
        tempP.add(this.password);
    }

    public String getLastPassword(){
        if (this.tempP.size() > 0){
            return this.tempP.get(this.tempP.size() - 1);
        }
        else{
            return "No saved passwords";
        }
    }

    public void setLength(int length) {
        this.length = length;
    }
}
