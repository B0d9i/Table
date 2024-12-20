package com.example.demoadress;

import com.example.demoadress.data.CollectionAddressBook; // Імпорт класу, який містить список осіб.
import javafx.application.Application; // Базовий клас для створення JavaFX-застосунку.
import javafx.fxml.FXMLLoader; // Клас для завантаження FXML-файлів.
import javafx.scene.Scene; // Клас для створення сцени.
import javafx.stage.Stage; // Клас для створення головного вікна.
import java.io.IOException; // Імпорт для обробки можливих помилок вводу/виводу.

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        // Завантаження FXML-файлу для основного інтерфейсу
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));


        // Створення сцени на основі завантаженого FXML.
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        // Налаштування головного вікна.
        stage.setTitle("Address Book Application"); // Встановлення заголовка вікна.
        stage.setScene(scene); // Прив'язка сцени до вікна.
        stage.setMinHeight(600); // Встановлення мінімальної висоти вікна.
        stage.setMinWidth(600); // Встановлення мінімальної ширини вікна.

        stage.show(); // Відображення вікна.

        testData(); // Виклик методу для тестових даних.
    }

    private void testData() {
        // Створюємо об'єкт адресної книги та заповнюємо його тестовими даними
        CollectionAddressBook addressBook = new CollectionAddressBook(); // Створення екземпляра адресної книги.
        addressBook.fillTestData(); // Заповнення тестовими даними.
    }

    // Точка входу в програму.
    public static void main(String[] args) {
        launch(); // Запуск JavaFX-застосунку.
    }
}
