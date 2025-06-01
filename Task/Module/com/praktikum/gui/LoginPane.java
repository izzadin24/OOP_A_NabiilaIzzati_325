package Task.Module.com.praktikum.gui;

import Task.Module.com.praktikum.data.DataStore;
import Task.Module.com.praktikum.gui.AdminDashboard;
import Task.Module.com.praktikum.gui.MahasiswaDashboard;
import Task.Module.com.praktikum.users.Admin;
import Task.Module.com.praktikum.users.Mahasiswa;
import Task.Module.com.praktikum.users.User;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class LoginPane extends StackPane {
    private Stage primaryStage;

    public LoginPane(Stage primaryStage) {
        this.primaryStage = primaryStage;
        createUI();
    }

    private void createUI() {
        // Title
        Text title = new Text("Login Sistem Lost & Found");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 24));

        // Toggle group for user type
        ToggleGroup userTypeGroup = new ToggleGroup();
        RadioButton mahasiswaBtn = new RadioButton("Mahasiswa");
        mahasiswaBtn.setToggleGroup(userTypeGroup);
        mahasiswaBtn.setSelected(true);
        RadioButton adminBtn = new RadioButton("Admin");
        adminBtn.setToggleGroup(userTypeGroup);

        HBox userTypeBox = new HBox(20, mahasiswaBtn, adminBtn);
        userTypeBox.setAlignment(Pos.CENTER);

        // Form fields
        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();
        usernameField.setPromptText("Nama/NIS");

        Label passwordLabel = new Label("Password/ID:");
        PasswordField passwordField = new PasswordField();

        Button loginBtn = new Button("Login");
        loginBtn.setDefaultButton(true);

        // Error message
        Label errorLabel = new Label();
        errorLabel.getStyleClass().add("error");
        errorLabel.setVisible(false);

        // Form layout
        GridPane formGrid = new GridPane();
        formGrid.setHgap(10);
        formGrid.setVgap(10);
        formGrid.add(usernameLabel, 0, 0);
        formGrid.add(usernameField, 1, 0);
        formGrid.add(passwordLabel, 0, 1);
        formGrid.add(passwordField, 1, 1);
        formGrid.add(loginBtn, 1, 2);
        formGrid.add(errorLabel, 0, 3, 2, 1);

        // Main layout
        VBox mainBox = new VBox(20, title, userTypeBox, formGrid);
        mainBox.setAlignment(Pos.CENTER);
        mainBox.setPadding(new Insets(40));
        mainBox.setMaxWidth(400);

        this.getChildren().add(mainBox);

        // Login button action
        loginBtn.setOnAction(e -> {
            String username = usernameField.getText().trim();
            String password = passwordField.getText().trim();

            if (username.isEmpty() || password.isEmpty()) {
                showError(errorLabel, "Username dan password harus diisi");
                return;
            }

            User authenticatedUser = null;
            if (mahasiswaBtn.isSelected()) {
                authenticatedUser = DataStore.authenticateMahasiswa(username, password);
            } else {
                authenticatedUser = DataStore.authenticateAdmin(username, password);
            }

            if (authenticatedUser != null) {
                if (authenticatedUser instanceof Admin) {
                    new AdminDashboard(primaryStage, (Admin) authenticatedUser);
                } else {
                    new MahasiswaDashboard(primaryStage, (Mahasiswa) authenticatedUser);
                }
            } else {
                showError(errorLabel, "Login gagal, periksa kredensial");
            }
        });
    }

    private void showError(Label errorLabel, String message) {
        errorLabel.setText(message);
        errorLabel.setVisible(true);
    }
}