package com.example.passwordgenerator;

public class passwordChecker extends passwordGenerator {
    private int difficulty;


    public passwordChecker(int length) {
        super(length);
        this.difficulty = 0;
    }

    public passwordChecker() {
        this.difficulty = 0;
    }

    public int checkDifficulty(String password) {
        if (password.length() < 5 && (password.matches("\\d+")
            || password.matches("[a-zA-Z]+"))){}
        else if (password.length() < 8
                && (password.matches(".*\\d+.*")
                || password.matches(".*[a-zA-Z]+.*"))){
            this.difficulty = 1;
        }else if (password.length() < 12 && (password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z0-9]).+$"))){
            this.difficulty = 2;
        }

        return this.difficulty;

    }
}


