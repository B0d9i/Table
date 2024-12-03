package com.example.demoadress;

import com.example.demoadress.data.Person;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class wind2Controller {

    @FXML
    private TextField pipTextField, phoneTextField;

    private Person person;

    public void setPerson(Person person) {
        this.person = person;
        pipTextField.setText(person.getPIP());
        phoneTextField.setText(person.getPHONE());
    }

    @FXML
    void saveChanges() {
        String pip = pipTextField.getText().trim();
        String phone = phoneTextField.getText().trim();

        if (!pip.isEmpty()) {
            person.setPIP(pip);
        }
        if (!phone.isEmpty()) {
            person.setPHONE(phone);
        }

        Stage stage = (Stage) pipTextField.getScene().getWindow();
        stage.close();
    }
}
