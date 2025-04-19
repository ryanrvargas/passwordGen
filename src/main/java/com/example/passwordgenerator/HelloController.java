package com.example.passwordgenerator;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;

public class HelloController {
    @FXML
    public Button generatePasswordButton;

    @FXML
    private Label welcomeText;

    @FXML
    private Label passwordDisplay;

    @FXML
    private Button savePassword;

    @FXML
    private TextArea showAllPasswords;

    @FXML
    private Button showAllPasswordsButton;

    @FXML
    private TextField passwordLength;

    @FXML
    private Label generateLabel;

    @FXML
    private Label lengthLabel;

    @FXML
    private TextField generatePasswordLength;

    @FXML
    private TitledPane titleGenerate;

    private passwordGenerator p = new passwordGenerator(12);

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

    @FXML
    public void onPasswordDisplay(MouseEvent mouseEvent) {
        // Handle clicking on password display (if needed)
    }

    @FXML
    private void onShowAllPasswordsButton(ActionEvent event){
        StringBuilder sb = new StringBuilder();
        for (String pass : p.getSavedPasswords()) {
            sb.append(pass).append("\n");
        }
        showAllPasswords.setText(sb.toString());
    }

    @FXML
    private void onSavePassword(ActionEvent event) {
        System.out.println("Save password clicked!");
        p.getSavedPasswords().add(p.getLastPassword());
    }
}
