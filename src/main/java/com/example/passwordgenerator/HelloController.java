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
    private TextField passwordLength;
	
	@FXML
	private Label generateLabel;
	
	@FXML
	private Label lengthLabel;
	
	@FXML
	private TextField generatePasswordLength;
	
	@FXML
	private TitledPane titleGenerate;

    @FXML
    private Label passwordDisplay;

    private passwordGenerator p = new passwordGenerator(12);

    @FXML
    private void onGeneratePasswordButton(javafx.event.ActionEvent event){
        try{
            int length = Integer.parseInt(passwordLength.getText());

            p.setLength(length);

            p.generateP();

            passwordDisplay.setText(p.getLastPassword());
        }catch (NumberFormatException e){
            passwordDisplay.setText("Password length must be an integer");
        }catch (IllegalArgumentException e){
            passwordDisplay.setText(e.getMessage());
        }

    }

    @FXML
    public void onPasswordDisplay(MouseEvent mouseEvent) {
    }



}