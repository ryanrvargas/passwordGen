package com.example.passwordgenerator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
/**
 * The HelloApplication class is the main entry point for the JavaFX application.
 * It loads the FXML file, sets the stage, and launches the GUI.
 */
public class HelloApplication extends Application {
    /**
     * Called automatically when the JavaFX application is launched.
     * It sets up the primary stage and loads the FXML layout.
     *
     * @param stage The primary stage for this application
     * @throws IOException If the FXML file cannot be loaded
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main method, which launches the JavaFX application.
     *
     * @param args The command-line arguments (not used)
     */
    public static void main(String[] args) {
        launch();
    }
}
