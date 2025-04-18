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
    public void getSavedP(){
        int index = 1;
        for (String p : savedP){
            System.out.printf("%d:Password:%s\n", index, p);
            index += 1;
        }
    }

    /**
     * Generates a new random password of the specified length,
     * adds it to the list of saved passwords, and resets the internal password field.
     */
    public void generateP(){
        for (int i = 0; i < length; i++){
            this.password += c.charAt((int)(Math.random() * c.length()));
        }
        savedP.add(this.password);
        this.password = "";
    }

    public String getLastPassword(){
        if (this.savedP.size() > 0){
            return this.savedP.get(this.savedP.size() - 1);
        }
        else{
            return "No saved passwords";
        }
    }

    public void setLength(int length) {
        this.length = length;
    }
}
