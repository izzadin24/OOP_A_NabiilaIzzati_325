package Task.Module.com.praktikum.main.java;

import Task.Module.com.praktikum.data.DataStore;
import Task.Module.com.praktikum.gui.LoginPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class LoginSystem1 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Initialize data
        DataStore.initialize();

        // Create login pane
        LoginPane loginPane = new LoginPane(primaryStage);

        // Set up the scene
        Scene scene = new Scene(loginPane, 800, 600);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());

        // Configure the stage
        primaryStage.setTitle("Lost & Found Kampus");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}