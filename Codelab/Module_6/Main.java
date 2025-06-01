package Codelab.Module_6;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.Random;

public class Main extends Application {
    private int angkaTebakan;
    private int jumlahPercobaan;
    private Label feedbackLabel;
    private Label percobaanLabel;
    private TextField inputField;
    private Random random;

    @Override
    public void start(Stage primaryStage) {
        random = new Random();
        angkaTebakan = random.nextInt(100) + 1;
        jumlahPercobaan = 0;

        // Judul
        Label titleLabel = new Label("🎯 Tebak Angka 1–100");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #1a237e;");

        // Subjudul
        Label promptLabel = new Label("Masukkan tebakanmu!");
        promptLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: #2c3e50;");

        // Label feedback
        feedbackLabel = new Label(""); // default kosong
        feedbackLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: #d84315;");

        // Input field
        inputField = new TextField();
        inputField.setPromptText("1–100");
        inputField.setMaxWidth(150);
        inputField.setAlignment(Pos.CENTER);

        // Tombol tebak
        Button tebakButton = new Button("🎲 Coba Tebak!");
        tebakButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold;");
        tebakButton.setOnAction(e -> prosesTebakan());

        // HBox untuk TextField dan button
        HBox inputBox = new HBox(10, inputField, tebakButton); //ini agar horixontal degn inputfield
        inputBox.setAlignment(Pos.CENTER);

        // Label percobaan
        percobaanLabel = new Label("Jumlah percobaan: 0");
        percobaanLabel.setStyle("-fx-font-size: 14px;");

        VBox root = new VBox(10, titleLabel, promptLabel, feedbackLabel, inputBox, percobaanLabel);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        root.setStyle("-fx-background-color: #e3f2fd;");

        Scene scene = new Scene(root, 450, 300);
        primaryStage.setTitle("Tebak Angka Advance");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void prosesTebakan() {
        try {
            int tebakan = Integer.parseInt(inputField.getText());
            jumlahPercobaan++;
            percobaanLabel.setText("Jumlah percobaan: " + jumlahPercobaan);

            if (tebakan < 1 || tebakan > 100) {
                feedbackLabel.setText("Masukkan angka antara 1–100!");
            } else if (tebakan < angkaTebakan) {
                feedbackLabel.setText("Terlalu kecil!");
            } else if (tebakan > angkaTebakan) {
                feedbackLabel.setText("Terlalu besar!");
            } else {
                feedbackLabel.setText("Tebakan benar! Angka baru telah dibuat.");
                angkaTebakan = random.nextInt(100) + 1;
                jumlahPercobaan = 0;
            }
        } catch (NumberFormatException e) {
            feedbackLabel.setText("Masukkan angka yang valid!");
        }
        inputField.clear();
    }

    public static void main(String[] args) {
        launch();
    }
}
