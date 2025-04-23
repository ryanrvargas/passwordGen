package com.example.passwordgenerator;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 * Controller class for displaying a list of saved passwords in a ListView.
 * Used in the secondary window opened from the main password generator UI.
 */
public class SavedPasswordsController {

    /** The ListView used to display saved passwords */
    @FXML
    private ListView<String> passwordListView;

    /**
     * Populates the ListView with a list of saved passwords.
     * This method is typically called by the main controller when the "Saved Passwords" window is opened.
     *
     * @param passwords a List of saved password strings
     */
    public void setPasswords(java.util.List<String> passwords) {
        ObservableList<String> items = FXCollections.observableArrayList(passwords);
        passwordListView.setItems(items);
    }

}
