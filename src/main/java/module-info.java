module com.example.bj {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens com.example.bj2122 to javafx.fxml;
    exports com.example.bj2122;
}