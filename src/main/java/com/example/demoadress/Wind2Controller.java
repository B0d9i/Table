package com.example.demoadress;

// Імпортуємо необхідні класи
import com.example.demoadress.data.Person;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

// Контролер для другого вікна (Wind2)
public class Wind2Controller {

    // Оголошення полів для вводу ПІП та телефону
    @FXML
    private TextField pipTextField, phoneTextField;

    // Змінна для збереження об'єкта Person
    private Person person;

    // Сеттер для об'єкта Person. Встановлює дані в поля текстових полів
    public void setPerson(Person person) {
        this.person = person;
        // Встановлюємо значення ПІП та телефону у відповідні поля
        pipTextField.setText(person.getPIP());
        phoneTextField.setText(person.getPHONE());
    }

    // Метод для збереження змін у об'єкті Person
    @FXML
    void saveChanges() {
        // Отримуємо значення з текстових полів
        String pip = pipTextField.getText().trim();
        String phone = phoneTextField.getText().trim();

        // Якщо ПІП не порожній, встановлюємо нове значення
        if (!pip.isEmpty()) {
            person.setPIP(pip);
        }
        // Якщо телефон не порожній, встановлюємо нове значення
        if (!phone.isEmpty()) {
            person.setPHONE(phone);
        }

        // Закриваємо поточне вікно
        Stage stage = (Stage) pipTextField.getScene().getWindow();
        stage.close();
    }
}
