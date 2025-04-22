package com.example.passwordgenerator;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class SavedPasswordsController {

    @FXML
    private ListView<String> passwordListView;

    public void setPasswords(java.util.List<String> passwords) {
        ObservableList<String> items = FXCollections.observableArrayList(passwords);
        passwordListView.setItems(items);
    }

}
