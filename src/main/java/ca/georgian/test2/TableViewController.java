//NAME - Toshit Narwal
//STUDENT NO. - 20056512

package ca.georgian.test2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.util.List;

public class TableViewController {

    @FXML
    private TableView<Customer> tableView;

    @FXML
    private TableColumn<Customer, Integer> idColumn;

    @FXML
    private TableColumn<Customer, String> firstNameColumn;

    @FXML
    private TableColumn<Customer, String> lastNameColumn;

    @FXML
    private TableColumn<Customer, String> phoneColumn;

    @FXML
    private TableColumn<Customer, String> totalPurchaseColumn;

    @FXML
    private Label rowsInTableLabel;

    @FXML
    private ListView<Product> purchaseListView;

    @FXML
    private ImageView imageView;

    @FXML
    private StackPane stackPane;

    @FXML
    private Label msrpLabel;

    @FXML
    private Label saleLabel;

    @FXML
    private Label savingsLabel;

    @FXML
    private Button top10Customers;

    @FXML
    private Button customersSavedOver5;

    @FXML
    private Button loadAllCustomers;

    @FXML
    public void initialize() {
        // Initialize TableView columns
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        totalPurchaseColumn.setCellValueFactory(new PropertyValueFactory<>("totalPurchases"));

        // Initialize other components if needed
    }

    public void loadCustomersIntoTable(List<Customer> customers) {
        tableView.getItems().setAll(customers);
        rowsInTableLabel.setText("Rows in table: " + tableView.getItems().size());
    }

    // Implement event handler methods for buttons
    @FXML
    private void top10Customers() {
        // Implementation
    }

    @FXML
    private void customersSavedOver5() {
        // Implementation
    }

    @FXML
    private void loadAllCustomers() {
        // Implementation
    }
}
