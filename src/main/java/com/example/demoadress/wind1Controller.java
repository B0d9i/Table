package com.example.demoadress;

import com.example.demoadress.data.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class wind1Controller {

    @FXML
    private TextField txtPipDod, txtPhoneDod;
    @FXML
    private Button buttonDod;

    private Person person;

    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    @FXML
    void dodInfo(ActionEvent event) {
        String pip = txtPipDod.getText().trim();
        String phone = txtPhoneDod.getText().trim();

        if (!pip.isEmpty() && !phone.isEmpty()) {
            person.setPIP(pip);
            person.setPHONE(phone);
            Stage stage = (Stage) buttonDod.getScene().getWindow();
            stage.close();
        } else {
            showAlert("Помилка", "Поля не можуть бути порожніми!");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
