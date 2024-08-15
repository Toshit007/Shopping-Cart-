module ca.georgian.test2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens ca.georgian.test2 to javafx.fxml;
    exports ca.georgian.test2;
}