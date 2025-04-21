package com.example.passwordgenerator;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
/**
 * The HelloController class handles the user interface interactions
 * for the password generator application using JavaFX.
 * It connects UI elements (defined in FXML) to their backend functionality.
 */
public class PasswordController {
    /** Button to trigger password generation */
    @FXML
    public Button generatePasswordButton;

    /** Label to display the app title or status messages */
    @FXML
    private Label welcomeText;

    /** Label where the most recently generated password is displayed */
    @FXML
    private Label passwordDisplay;

    /** Button to manually save a generated password */
    @FXML
    private Button savePassword;

    /** TextArea where all saved passwords are shown */
    @FXML
    private TextArea showAllPasswords;

    /** Button to trigger displaying all saved passwords */
    @FXML
    private Button showAllPasswordsButton;

    /** TextField where the user inputs the desired password length */
    @FXML
    private TextField passwordLength;


    /** Label above the generated password instructions */
    @FXML
    private Label generateLabel;

    /** Label for the length input field */
    @FXML
    private Label lengthLabel;

    /** Alternate TextField (not currently used) for password length input */
    @FXML
    private TextField generatePasswordLength;

    /** TitledPane UI element grouping the password generation section */
    @FXML
    private TitledPane titleGenerate;

    /** Instance of the password generator logic */
    private passwordGenerator p = new passwordGenerator(12);

    /**
     * Handles the generate password button click.
     * Retrieves length input, generates a password, and displays it.
     *
     * @param event The ActionEvent triggered by the button
     */
    @FXML
    private void onGeneratePasswordButton(ActionEvent event){
        //Exception Handling
        try {
            int length = Integer.parseInt(passwordLength.getText());
            if (length <= 0 || length > 20){
                //Throw
                throw new IllegalArgumentException("Password length must be between 0 and 20 characters.");
            } else{
                p.setLength(length);
                p.generateP();
                passwordDisplay.setText(p.getLastPassword());
            }

        } catch (NumberFormatException e) {
            passwordDisplay.setText("Password length must be an integer");
        } catch (IllegalArgumentException e) {
            passwordDisplay.setText(e.getMessage());
        }
    }

    /**
     * Handles click events on the password display label.
     * (Currently unused — can be used for copy-to-clipboard or tooltip)
     *
     * @param mouseEvent The MouseEvent triggered by user interaction
     */
    @FXML
    public void onPasswordDisplay(MouseEvent mouseEvent) {
        // Handle clicking on password display (if needed)
    }

    /**
     * Displays all saved passwords in the TextArea.
     *
     * @param event The ActionEvent triggered by clicking "Show Passwords"
     */
    @FXML
    private void onShowAllPasswordsButton(ActionEvent event){
        StringBuilder sb = new StringBuilder();
        for (String pass : p.getSavedPasswords()) {
            sb.append(pass).append("\n");
        }
        showAllPasswords.setText(sb.toString());
    }

    /**
     * Saves the most recently generated password to the saved list.
     *
     * @param event The ActionEvent triggered by clicking "Save Password"
     */
    @FXML
    private void onSavePassword(ActionEvent event) {
        System.out.println("Save password clicked!");
        p.getSavedPasswords().add(p.getLastPassword());
    }
}
