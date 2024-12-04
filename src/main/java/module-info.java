module com.example.demoadress {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.prefs;


    opens com.example.demoadress to javafx.fxml;
    exports com.example.demoadress;
    exports com.example.demoadress.data;
    opens com.example.demoadress.data to javafx.fxml;
}