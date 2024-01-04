module com.example.bj {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.bj2122 to javafx.fxml;
    exports com.example.bj2122;
}