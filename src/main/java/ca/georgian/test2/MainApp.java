package ca.georgian.test2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class MainApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ca/georgian/test2/table-view.fxml"));
        primaryStage.setTitle("Customer Management");
        primaryStage.setScene(new Scene(loader.load()));

        String filePath = "src/main/resources/ca/georgian/test2/customers.json"; // Update this path if needed
        ArrayList<Customer> customers = JsonParser.parseCustomersJson(filePath);


        TableViewController controller = loader.getController();
        controller.loadCustomersIntoTable(customers);

        primaryStage.show();
    }
}
