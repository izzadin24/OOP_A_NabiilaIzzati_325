package Task.Module.com.praktikum.gui;
import Task.Module.com.praktikum.data.Item;
import Task.Module.com.praktikum.gui.LoginPane;
import Task.Module.com.praktikum.users.Mahasiswa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;
import java.util.stream.Collectors;

public class MahasiswaDashboard extends BorderPane {
    private Mahasiswa mahasiswa;
    private ObservableList<Item> reportedItems;

    public MahasiswaDashboard(Stage primaryStage, Mahasiswa mahasiswa) {
        this.mahasiswa = mahasiswa;
        this.reportedItems = FXCollections.observableArrayList(mahasiswa.viewReportedItems());

        createUI(primaryStage);
        primaryStage.getScene().setRoot(this);
    }

    private void createUI(Stage primaryStage) {
        // Header
        Text welcomeText = new Text("Selamat datang, " + mahasiswa.getUsername());
        welcomeText.setFont(Font.font("Arial", FontWeight.BOLD, 20));

        Button logoutBtn = new Button("Logout");
        logoutBtn.setOnAction(e -> new LoginPane(primaryStage));

        HBox headerBox = new HBox(welcomeText, logoutBtn);
        headerBox.setAlignment(Pos.CENTER_LEFT);
        headerBox.setSpacing(20);
        headerBox.setPadding(new Insets(15));

        // Report section
        Text reportTitle = new Text("Laporkan Barang Hilang/Temuan");
        reportTitle.setFont(Font.font("Arial", FontWeight.BOLD, 16));

        TextField itemNameField = new TextField();
        itemNameField.setPromptText("Nama Barang");

        TextField descriptionField = new TextField();
        descriptionField.setPromptText("Deskripsi");

        TextField locationField = new TextField();
        locationField.setPromptText("Lokasi");

        Button reportBtn = new Button("Laporkan");
        reportBtn.setOnAction(e -> {
            if (itemNameField.getText().isEmpty() || locationField.getText().isEmpty()) {
                showAlert(Alert.AlertType.WARNING, "Nama barang dan lokasi harus diisi");
                return;
            }

            mahasiswa.reportItem(
                    itemNameField.getText(),
                    descriptionField.getText(),
                    locationField.getText()
            );

            reportedItems.setAll(mahasiswa.viewReportedItems());
            showAlert(Alert.AlertType.INFORMATION, "Barang berhasil dilaporkan");

            // Clear fields
            itemNameField.clear();
            descriptionField.clear();
            locationField.clear();
        });

        VBox reportBox = new VBox(10, reportTitle, itemNameField, descriptionField, locationField, reportBtn);
        reportBox.setPadding(new Insets(20));
        reportBox.setStyle("-fx-border-color: #ccc; -fx-border-width: 1; -fx-border-radius: 5;");

        // Reported items table
        Text reportsTitle = new Text("Daftar Laporan Anda");
        reportsTitle.setFont(Font.font("Arial", FontWeight.BOLD, 16));

        TableView<Item> itemsTable = new TableView<>();
        itemsTable.setItems(reportedItems);

        TableColumn<Item, String> nameCol = new TableColumn<>("Nama");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("itemName"));

        TableColumn<Item, String> locationCol = new TableColumn<>("Lokasi");
        locationCol.setCellValueFactory(new PropertyValueFactory<>("location"));

        itemsTable.getColumns().addAll(nameCol, locationCol);
        itemsTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        VBox reportsBox = new VBox(10, reportsTitle, itemsTable);
        reportsBox.setPadding(new Insets(20));

        // Main layout
        VBox centerBox = new VBox(20, reportBox, reportsBox);
        centerBox.setPadding(new Insets(20));

        this.setTop(headerBox);
        this.setCenter(centerBox);
    }

    private void showAlert(Alert.AlertType type, String message) {
        Alert alert = new Alert(type, message);
        alert.setHeaderText(null);
        alert.showAndWait();
    }
}