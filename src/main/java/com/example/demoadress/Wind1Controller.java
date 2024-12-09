package com.example.demoadress;

// Імпортуємо необхідні класи
import com.example.demoadress.data.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

// Контролер для вікна (Wind1)
public class Wind1Controller {

    // Оголошення елементів інтерфейсу
    @FXML
    private TextField txtPipDod, txtPhoneDod; // Поля для вводу ПІП та телефону
    @FXML
    private Button buttonDod; // Кнопка для додавання інформації

    // Змінна для збереження об'єкта Person
    private Person person;

    // Сеттер для об'єкта Person
    public void setPerson(Person person) {
        this.person = person;
    }

    // Геттер для отримання об'єкта Person
    public Person getPerson() {
        return person;
    }

    // Метод для обробки події натискання на кнопку "Додати інформацію"
    @FXML
    void dodInfo(ActionEvent event) {
        // Отримуємо введені значення з полів вводу
        String pip = txtPipDod.getText().trim();
        String phone = txtPhoneDod.getText().trim();

        // Перевірка, чи не порожні поля
        if (!pip.isEmpty() && !phone.isEmpty()) {
            // Встановлюємо значення в об'єкт Person
            person.setPIP(pip);
            person.setPHONE(phone);

            // Закриваємо поточне вікно
            Stage stage = (Stage) buttonDod.getScene().getWindow();
            stage.close();
        } else {
            // Якщо поля порожні, показуємо попередження
            showAlert("Помилка", "Поля не можуть бути порожніми!");
        }
    }

    // Метод для показу повідомлення про помилку
    private void showAlert(String title, String message) {
        // Створюємо попередження
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title); // Заголовок
        alert.setHeaderText(null); // Відсутність додаткового заголовка
        alert.setContentText(message); // Повідомлення
        alert.showAndWait(); // Показуємо попередження та чекаємо на його закриття
    }
}
