module com.example.demoadress {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demoadress to javafx.fxml;
    exports com.example.demoadress;
}