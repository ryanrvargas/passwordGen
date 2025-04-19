package com.example.passwordgenerator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.input.MouseEvent;

import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;

import java.awt.*;
import java.awt.event.ActionListener;

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

    private passwordGenerator p = new passwordGenerator(12);

    @FXML
    private void onGeneratePasswordButton(javafx.event.ActionEvent event){
        p.generateP();
        passwordDisplay.setText(p.getLastPassword());

    }
    @FXML
    public void onPasswordDisplay(MouseEvent mouseEvent) {
    }

    @FXML
    private void onShowAllPasswordsButton(ActionEvent event){
        StringBuilder sb = new StringBuilder();
        for (String pass : p.getSavedPasswords()) {
            sb.append(pass);
            sb.append("\n");

        }
        showAllPasswords.setText(sb.toString());
    }

    @FXML
    private void onSavePassword(ActionEvent event) {
        // Optional: Save the current password to a file or something
        System.out.println("Save password clicked!");
        p.getSavedPasswords().add(p.getLastPassword());
    }

}