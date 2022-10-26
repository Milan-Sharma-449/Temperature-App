module com.example.temperature_app {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.temperature_app to javafx.fxml;
    exports com.example.temperature_app;
}