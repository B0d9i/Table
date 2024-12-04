package com.example.demoadress;

// Імпортуємо необхідні класи
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

// Контролер для вікна видалення запису (Wind3Del)
public class wind3DelController {

    // Оголошення елементів інтерфейсу
    @FXML
    private Button buttonDod; // Кнопка для виконання операції (видалення запису)

    @FXML
    private TextField txtPhoneDod; // Поле для вводу телефону (не використовується в даному методі)

    @FXML
    private TextField txtPipDod; // Поле для вводу ПІП (не використовується в даному методі)

    // Метод для обробки події видалення запису
    @FXML
    void deleteRecord(ActionEvent event) {
        // Створюємо повідомлення про результат операції видалення
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("delete"); // Заголовок повідомлення
        alert.setHeaderText("Результат:"); // Заголовок інформаційного вікна
        alert.setContentText("Ви видалили запис"); // Повідомлення про успішне видалення

        alert.showAndWait(); // Показуємо повідомлення та чекаємо на його закриття

        // Закриваємо поточне вікно
        Stage stage = (Stage) buttonDod.getScene().getWindow();
        stage.close();
        //HelloController.getStage().close(); // Закриття через інший спосіб
    }
}
