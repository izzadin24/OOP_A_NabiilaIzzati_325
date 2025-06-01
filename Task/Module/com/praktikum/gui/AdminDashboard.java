package Task.Module.com.praktikum.gui;

import Task.Module.com.praktikum.data.DataStore;
import Task.Module.com.praktikum.data.Item;
import Task.Module.com.praktikum.gui.LoginPane;
import Task.Module.com.praktikum.users.Admin;
import Task.Module.com.praktikum.users.Mahasiswa;
import Task.Module.com.praktikum.users.User;
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
import java.util.Optional;
import java.util.stream.Collectors;

public class AdminDashboard extends BorderPane {
    private Admin admin;
    private ObservableList<Item> allItems;
    private ObservableList<User> students;

    public AdminDashboard(Stage primaryStage, Admin admin) {
        this.admin = admin;
        this.allItems = FXCollections.observableArrayList(DataStore.reportedItems);
        this.students = FXCollections.observableArrayList(
                DataStore.userList.stream()
                        .filter(user -> user instanceof Mahasiswa)
                        .collect(Collectors.toList())
        );

        createUI(primaryStage);
        primaryStage.getScene().setRoot(this);
    }

    private void createUI(Stage primaryStage) {
        // Header
        Text welcomeText = new Text("Admin Dashboard - " + admin.getUsername());
        welcomeText.setFont(Font.font("Arial", FontWeight.BOLD, 20));

        Button logoutBtn = new Button("Logout");
        logoutBtn.setOnAction(e -> new LoginPane(primaryStage));

        HBox headerBox = new HBox(welcomeText, logoutBtn);
        headerBox.setAlignment(Pos.CENTER_LEFT);
        headerBox.setSpacing(20);
        headerBox.setPadding(new Insets(15));

        // Tab pane for different sections
        TabPane tabPane = new TabPane();

        // Items management tab
        Tab itemsTab = new Tab("Kelola Barang");
        itemsTab.setClosable(false);
        itemsTab.setContent(createItemsTab());

        // Students management tab
        Tab studentsTab = new Tab("Kelola Mahasiswa");
        studentsTab.setClosable(false);
        studentsTab.setContent(createStudentsTab());

        tabPane.getTabs().addAll(itemsTab, studentsTab);

        // Main layout
        this.setTop(headerBox);
        this.setCenter(tabPane);
    }

    private VBox createItemsTab() {
        // Items table
        TableView<Item> itemsTable = new TableView<>();
        itemsTable.setItems(allItems);

        TableColumn<Item, String> nameCol = new TableColumn<>("Nama Barang");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("itemName"));

        TableColumn<Item, String> descCol = new TableColumn<>("Deskripsi");
        descCol.setCellValueFactory(new PropertyValueFactory<>("description"));

        TableColumn<Item, String> locCol = new TableColumn<>("Lokasi");
        locCol.setCellValueFactory(new PropertyValueFactory<>("location"));

        TableColumn<Item, String> statusCol = new TableColumn<>("Status");
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        itemsTable.getColumns().addAll(nameCol, descCol, locCol, statusCol);

        // Mark as claimed button
        Button markClaimedBtn = new Button("Tandai sebagai Dikembalikan");
        markClaimedBtn.setOnAction(e -> {
            Item selected = itemsTable.getSelectionModel().getSelectedItem();
            if (selected != null) {
                admin.markItemAsClaimed(selected);
                itemsTable.refresh();
            } else {
                showAlert(Alert.AlertType.WARNING, "Pilih barang terlebih dahulu");
            }
        });

        HBox buttonBox = new HBox(markClaimedBtn);
        buttonBox.setSpacing(10);
        buttonBox.setPadding(new Insets(10, 0, 0, 0));

        VBox itemsTab = new VBox(10, itemsTable, buttonBox);
        itemsTab.setPadding(new Insets(20));

        return itemsTab;
    }

    private VBox createStudentsTab() {
        // Students table
        TableView<User> studentsTable = new TableView<>();
        studentsTable.setItems(students);

        TableColumn<User, String> nameCol = new TableColumn<>("Nama");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("username"));

        TableColumn<User, String> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

        studentsTable.getColumns().addAll(nameCol, idCol);

        // Add/remove buttons
        Button addBtn = new Button("Tambah Mahasiswa");
        addBtn.setOnAction(e -> showAddStudentDialog());

        Button removeBtn = new Button("Hapus Mahasiswa");
        removeBtn.setOnAction(e -> {
            User selected = studentsTable.getSelectionModel().getSelectedItem();
            if (selected != null) {
                if (admin.removeStudent(selected.getId())) {
                    students.remove(selected);
                    showAlert(Alert.AlertType.INFORMATION, "Mahasiswa berhasil dihapus");
                }
            } else {
                showAlert(Alert.AlertType.WARNING, "Pilih mahasiswa terlebih dahulu");
            }
        });

        HBox buttonBox = new HBox(10, addBtn, removeBtn);
        buttonBox.setPadding(new Insets(10, 0, 0, 0));

        VBox studentsTab = new VBox(10, studentsTable, buttonBox);
        studentsTab.setPadding(new Insets(20));

        return studentsTab;
    }

    private void showAddStudentDialog() {
        Dialog<User> dialog = new Dialog<>();
        dialog.setTitle("Tambah Mahasiswa Baru");
        dialog.setHeaderText("Masukkan data mahasiswa");

        // Set the button types
        ButtonType addButtonType = new ButtonType("Tambah", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(addButtonType, ButtonType.CANCEL);

        // Create the form
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 10, 10, 10));

        TextField nameField = new TextField();
        nameField.setPromptText("Nama");
        TextField idField = new TextField();
        idField.setPromptText("ID");

        grid.add(new Label("Nama:"), 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(new Label("ID:"), 0, 1);
        grid.add(idField, 1, 1);

        dialog.getDialogPane().setContent(grid);

        // Convert the result to a user when the add button is clicked
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == addButtonType) {
                return new Mahasiswa(nameField.getText(), idField.getText());
            }
            return null;
        });

        Optional<User> result = dialog.showAndWait();

        result.ifPresent(student -> {
            admin.addStudent(student.getUsername(), student.getId());
            students.add(student);
            showAlert(Alert.AlertType.INFORMATION, "Mahasiswa berhasil ditambahkan");
        });
    }

    private void showAlert(Alert.AlertType type, String message) {
        Alert alert = new Alert(type, message);
        alert.setHeaderText(null);
        alert.showAndWait();
    }
}