package ca.georgian.test2;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    private ObservableList<Customer> allCustomers;

    @FXML
    public void initialize() {
        // Initialize table columns
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        totalPurchaseColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getTotalPurchasesFormatted()));

        allCustomers = FXCollections.observableArrayList();

        // Update the number of rows whenever items are added or removed
        tableView.itemsProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                newValue.addListener((ListChangeListener<Customer>) c -> updateRowsInTableLabel());
            }
            updateRowsInTableLabel();
        });

        // Add a listener to populate purchases when a customer is selected
        tableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                populatePurchaseListView(newValue.getPurchases());
                updatePurchaseLabels(newValue.getPurchases());

                if (!newValue.getPurchases().isEmpty()) {
                    String imageUrl = newValue.getPurchases().get(0).getImage();
                    imageView.setImage(new javafx.scene.image.Image(imageUrl));
                } else {
                    imageView.setImage(null);
                }
            } else {
                purchaseListView.setItems(FXCollections.observableArrayList());
                clearPurchaseLabels();
            }
        });
    }

    private void populatePurchaseListView(List<Product> purchases) {
        if (purchases != null) {
            purchaseListView.setItems(FXCollections.observableArrayList(
                    purchases.stream()
                            .map(p -> p.getName() + " - $" + p.getSalePrice())
                            .collect(Collectors.toList())
            ));
        } else {
            purchaseListView.setItems(FXCollections.observableArrayList());
        }
    }

    private void updateRowsInTableLabel() {
        rowsInTableLabel.setText("Rows in table: " + tableView.getItems().size());
    }

    private void updatePurchaseLabels(List<Product> purchases) {
        if (purchases != null && !purchases.isEmpty()) {
            double totalRegularPrice = purchases.stream()
                    .mapToDouble(Product::getRegularPrice)
                    .sum();
            double totalSalePrice = purchases.stream()
                    .mapToDouble(Product::getSalePrice)
                    .sum();
            double totalSavings = totalRegularPrice - totalSalePrice;

            msrpLabel.setText(String.format("Total MSRP: $%.2f", totalRegularPrice));
            saleLabel.setText(String.format("Total Sale Price: $%.2f", totalSalePrice));
            savingsLabel.setText(String.format("Total Savings: $%.2f", totalSavings));
        } else {
            clearPurchaseLabels();
        }
    }

    private void clearPurchaseLabels() {
        msrpLabel.setText("Total MSRP: $0.00");
        saleLabel.setText("Total Sale Price: $0.00");
        savingsLabel.setText("Total Savings: $0.00");
    }

    @FXML
    private void top10Customers() {
        if (allCustomers.isEmpty()) {
            loadAllCustomers();
        }

        List<Customer> top10Customers = allCustomers.stream()
                .sorted(Comparator.comparingDouble(Customer::getTotalPurchases).reversed())
                .limit(10)
                .collect(Collectors.toList());

        updateTableView(top10Customers);
    }

    @FXML
    private void customersSavedOver5() {
        if (allCustomers.isEmpty()) {
            loadAllCustomers();
        }
        List<Customer> filteredCustomers = allCustomers.stream()
                .filter(Customer::hasSavedFiveOrMore)
                .collect(Collectors.toList());

        updateTableView(filteredCustomers);
    }

    @FXML
    private void loadAllCustomers() {
        List<Customer> customers = getAllCustomers();
        allCustomers.setAll(customers);
        updateTableView(customers);
    }
    private void updateTableView(List<Customer> customers) {
        tableView.getSelectionModel().clearSelection();
        tableView.setItems(FXCollections.observableArrayList(customers));
        updateRowsInTableLabel();
        purchaseListView.setItems(FXCollections.observableArrayList());
        clearPurchaseLabels();
    }
    public void loadCustomersIntoTable(List<Customer> customers) {
        allCustomers.setAll(customers);
        updateTableView(customers);
    }

    private List<Customer> getAllCustomers() {
        return List.of();
    }
}