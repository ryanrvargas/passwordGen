package com.example.passwordgenerator;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
/**
 * Controller class for handling user interactions in the password generator UI.
 * Manages password generation, saving, and viewing saved passwords.
 */
public class PasswordController {
    /** Button to trigger password generation */
    @FXML
    public Button generatePasswordButton;

    /** Welcome label (optional placeholder for greeting text) */
    @FXML
    private Label welcomeText;

    /** Label to display the most recently generated password */
    @FXML
    private Label passwordDisplay;

    /** Button to save the most recently generated password */
    @FXML
    private Button savePassword;

    /** Text area to show all saved passwords */
    @FXML
    private TextArea showAllPasswords;

    /** Button to show all saved passwords in a new window */
    @FXML
    private Button showAllPasswordsButton;

    /** Text field to input the desired password length */
    @FXML
    private TextField passwordLength;

    /** Label above the password generation section */
    @FXML
    private Label generateLabel;

    /** Label indicating the password length input */
    @FXML
    private Label lengthLabel;

    /** Additional text field for password length (possibly redundant) */
    @FXML
    private TextField generatePasswordLength;

    /** Titled pane that contains the password generation section */
    @FXML
    private TitledPane titleGenerate;

    /** Instance of the password generator logic class */
    private passwordGenerator p = new passwordGenerator(12);

    /**
     * Handles the action of generating a password when the button is clicked.
     * Retrieves user input for password length and displays the generated password.
     *
     * @param event the action event triggered by the generate button
     */
    @FXML
    private void onGeneratePasswordButton(ActionEvent event){
        try {
            int length = Integer.parseInt(passwordLength.getText());
            p.setLength(length);
            p.generateP();
            passwordDisplay.setText(p.getLastPassword());
        } catch (NumberFormatException e) {
            passwordDisplay.setText("Password length must be an integer");
        } catch (IllegalArgumentException e) {
            passwordDisplay.setText(e.getMessage());
        }
    }

    /**
     * Handles a mouse click on the password display label.
     * Currently empty, but can be used for copying or interacting with the password.
     *
     * @param mouseEvent the mouse event triggered on the label
     */
    @FXML
    public void onPasswordDisplay(MouseEvent mouseEvent) {
        // Handle clicking on password display (if needed)
    }

    /**
     * Handles the action of displaying all saved passwords in a new window.
     * Loads another FXML layout and passes the saved passwords to it.
     *
     * @param event the action event triggered by the show all passwords button
     */
    @FXML
    private void onShowAllPasswordsButton(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SavedPasswords.fxml"));
            Parent root = loader.load();

            SavedPasswordsController controller = loader.getController();
            controller.setPasswords(p.getSavedPasswords());

            Stage stage = new Stage();
            stage.setTitle("Saved Passwords");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles saving the most recently generated password to the saved list.
     * Only saves if the last generated password is valid.
     *
     * @param event the action event triggered by the save password button
     */
    @FXML
    private void onSavePassword(ActionEvent event) {
        System.out.println("Save password clicked!");
        String lastGenerated = p.getLastPassword();
        if (!lastGenerated.equals("No saved passwords")) {
            p.getSavedPasswords().add(lastGenerated);
        }
    }
}
