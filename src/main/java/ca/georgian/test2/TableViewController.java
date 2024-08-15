package ca.georgian.test2;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

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
    private ListView<String> purchaseListView;
    @FXML
    private ImageView imageView;
    @FXML
    private Label msrpLabel;
    @FXML
    private Label saleLabel;
    @FXML
    private Label savingsLabel;

    @FXML
    public void initialize() {
        // Initialize table columns
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        totalPurchaseColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getTotalPurchasesFormatted()));

        // Update the number of rows whenever items are added or removed
        tableView.itemsProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                newValue.addListener((ListChangeListener<Customer>) c -> updateRowsInTableLabel());
            }
            updateRowsInTableLabel();
        });

        // Add a listener to populate purchases when a customer is selected
        tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Customer>() {
            @Override
            public void changed(ObservableValue<? extends Customer> observable, Customer oldValue, Customer newValue) {
                if (newValue != null) {
                    populatePurchaseListView(newValue.getPurchases());
                } else {
                    purchaseListView.setItems(FXCollections.observableArrayList());
                }
            }
        });
    }

    private void populatePurchaseListView(List<Product> purchases) {
        if (purchases != null) {
            purchaseListView.setItems(FXCollections.observableArrayList(
                    purchases.stream()
                            .map(p -> p.getName() + " - $" + p.getSalePrice())
                            .toList()
            ));
        } else {
            purchaseListView.setItems(FXCollections.observableArrayList());
        }
    }

    private void updateRowsInTableLabel() {
        rowsInTableLabel.setText("Rows in table: " + tableView.getItems().size());
    }

    @FXML
    private void top10Customers() {
        // Implement the logic to show top 10 customers
    }

    @FXML
    private void customersSavedOver5() {
        // Implement the logic to show customers who saved over $5
    }

    @FXML
    private void loadAllCustomers() {
        // Implement the logic to load all customers
    }

    public void loadCustomersIntoTable(List<Customer> customers) {
        tableView.setItems(FXCollections.observableArrayList(customers));
        updateRowsInTableLabel(); // Update the label after loading customers
    }
}