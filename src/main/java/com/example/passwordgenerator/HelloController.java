package com.example.passwordgenerator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloController {
    @FXML
    public Button generatePasswordButton;
    @FXML
    private Label welcomeText;
    @FXML
    private Label passwordDisplay;
    private passwordGenerator p = new passwordGenerator(12);

    @FXML
    private void onGeneratePasswordButton(javafx.event.ActionEvent event){
        p.generateP();
        passwordDisplay.setText(p.getLastPassword());

    }
    @FXML
    public void onPasswordDisplay(MouseEvent mouseEvent) {
    }
}