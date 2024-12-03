package com.example.demoadress;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class wind3DelController {

    @FXML
    private Button buttonDod;

    @FXML
    private TextField txtPhoneDod;

    @FXML
    private TextField txtPipDod;



    @FXML
    void deleteRecord(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("delete");
        alert.setHeaderText("Результат:");
        alert.setContentText("Ви видалили запис");

        alert.showAndWait();
        HelloController.getStage().close();
    }

}
