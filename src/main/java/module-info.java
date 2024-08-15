//NAME - Toshit Narwal
//STUDENT NO. - 20056512

module ca.georgian.test2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;

    opens ca.georgian.test2 to javafx.fxml, com.google.gson;
    exports ca.georgian.test2;
}
