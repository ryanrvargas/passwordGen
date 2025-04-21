package com.example.passwordgenerator;

/**
 * The passwordChecker class is used to evaluate the strength of a given password
 * and assign it a difficulty level based on its composition and length.
 *
 * Difficulty levels:
 * 0 - Weak
 * 1 - Medium
 * 2 - Strong
 */
public class passwordChecker {
    /**
     * Stores the difficulty level of the most recently checked password
     */
    private int difficulty;

    /**
     * Default constructor initializes difficulty level to 0 (weak).
     */
    public passwordChecker() {
        this.difficulty = 0;
    }

}

    /**
     * Evaluates the difficulty of a given password based on length and content:
     * - If the password is less than 5 characters and only digits or letters = Weak (0)
     * - If the password is less than 8 characters and contains letters or digits = Medium (1)
     * - If the password is less than 12 characters and contains at least one lowercase,
     *   one uppercase, one digit, and one special character = Strong (2)
     *
     * @param password The password to evaluate
     * @return An integer representing the password strength (0 = weak, 1 = medium, 2 = strong)
     *
    public int checkDifficulty(String password) {
        if (password.length() < 5 && (password.matches("\\d+") || password.matches("[a-zA-Z]+"))) {
            // Weak: Short + only digits or letters
            this.difficulty = 0;
        } else if (password.length() < 8
                && (password.matches(".*\\d+.*") || password.matches(".*[a-zA-Z]+.*"))) {
            // Medium: Short-ish + digits/letters
            this.difficulty = 1;
        } else if (password.length() < 12 &&
                password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z0-9]).+$")) {
            // Strong: Reasonable length + meets all conditions
            this.difficulty = 2;
        }

        return this.difficulty;
    }
}  **/
