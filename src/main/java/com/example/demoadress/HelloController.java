package com.example.demoadress;

import com.example.demoadress.data.CollectionAddressBook;
import com.example.demoadress.data.Person;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lombok.Getter;

import java.io.IOException;

public class HelloController {

    @FXML @Getter
    private ColorPicker ColorBackground;// Поле для вибору кольору фону.
    @FXML @Getter
    private ColorPicker ColorText;// Поле для вибору кольору тексту.
    // FXML-поля для елементів інтерфейсу
    @FXML
    private VBox rootPane;
    @FXML
    private Button button_dobavutu, button_vudalutu, button_redaguvatu; // Кнопки для додавання, видалення та редагування записів
    @FXML
    private TextField textFieldScreach;
    @FXML
    private TableColumn<Person, String> columnPIP; // Колонка для відображення імені (PIP)
    @FXML
    private TableColumn<Person, String> columnPhone; // Колонка для відображення телефону
    @FXML
    private TableView<Person> tableView; // Таблиця, що відображає список осіб
    @FXML
    private Label labelId; // Мітка для відображення кількості записів

    private CollectionAddressBook addressBookImpl = new CollectionAddressBook(); // Об'єкт для роботи зі списком осіб
    private Stage stage; // Головна сцена, яка використовується у додатку

    CssLabController cssLabController=new CssLabController();
    CollectionAddressBook collectionAddressBook=new CollectionAddressBook();

    ObservableList<Person> filteredList = FXCollections.observableArrayList();

    public Stage getStage() {
        return stage;
    }

    // Метод, який викликається автоматично після завантаження FXML
    @FXML
    public void initialize() {
        // Налаштовуємо колонки таблиці для відображення даних з класу Person
        columnPIP.setCellValueFactory(new PropertyValueFactory<>("PIP")); // Відображення властивості PIP
        columnPhone.setCellValueFactory(new PropertyValueFactory<>("PHONE")); // Відображення властивості PHONE

        // Додаємо слухача до списку осіб для автоматичного оновлення мітки з кількістю записів
        addressBookImpl.getPersonList().addListener((ListChangeListener<Person>) c ->
                labelId.setText("Кількість записів: " + addressBookImpl.getPersonList().size())
        );

        // Заповнюємо таблицю тестовими даними
        addressBookImpl.fillTestData();
        tableView.setItems(addressBookImpl.getPersonList()); // Прив'язуємо список осіб до таблиці
        //updateStyle();

//        // Завантажуємо збережені кольори з ColorUtils
//        Color savedBackgroundColor = getBackgroundColor();
//        Color savedTextColor = ColorUtils.getTextColor();
//
//        // Якщо кольори не задані, використовуємо значення за замовчуванням
//        if (savedBackgroundColor == null) {
//            savedBackgroundColor = Color.WHITE; // Значення за замовчуванням для фону
//        }
//        if (savedTextColor == null) {
//            savedTextColor = Color.BLACK; // Значення за замовчуванням для тексту
//        }
//
//        // Встановлюємо ці кольори в ColorPicker
//        ColorBackground.setValue(savedBackgroundColor);
//        ColorText.setValue(savedTextColor);
//
//        // Застосовуємо ці кольори до елементів інтерфейсу
//        cssLabController.applyColor(savedBackgroundColor, savedTextColor);
    }

    // Метод для відкриття вікна додавання нового запису
    @FXML
    void openWindowAdd(ActionEvent event) throws IOException {
        try {
            stage = new Stage(); // Створення нового вікна
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("wind.fxml")); // Завантаження FXML
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Додати запис"); // Заголовок вікна
            stage.setScene(scene);
            stage.setResizable(false); // Заборона зміни розміру вікна

            // Отримуємо контролер нового вікна
            Wind1Controller controller = fxmlLoader.getController();
            controller.setPerson(new Person()); // Передаємо новий об'єкт Person

            // Налаштування модального режиму (вікно блокує основне)
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(button_dobavutu.getScene().getWindow()); // Встановлюємо власника вікна

            stage.showAndWait(); // Очікуємо закриття вікна

            // Отримуємо дані з вікна
            Person person = controller.getPerson();
            if (person.getPIP() != null && !person.getPIP().isEmpty() &&
                    person.getPHONE() != null && !person.getPHONE().isEmpty()) {
                addressBookImpl.add(person); // Додаємо нову особу до списку
            } else {
                showAlert("Помилка", "Поля не можуть бути порожніми!"); // Попередження, якщо поля порожні
            }

        } catch (IOException e) {
            e.printStackTrace(); // Обробка помилки завантаження FXML
        }
    }

    // Метод для відкриття вікна редагування запису
    @FXML
    void openWindowEdit(ActionEvent event) {
        Person selectedPerson = tableView.getSelectionModel().getSelectedItem(); // Отримуємо вибраний рядок
        if (selectedPerson != null) {
            try {
                Stage editStage = new Stage(); // Створюємо нове вікно
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("wind2.fxml")); // Завантажуємо FXML
                Scene scene = new Scene(loader.load());
                editStage.setTitle("Редагування запису"); // Заголовок вікна
                editStage.setScene(scene);

                // Передаємо вибраного користувача в контролер нового вікна
                Wind2Controller controller = loader.getController();
                controller.setPerson(selectedPerson);

                // Налаштовуємо модальність
                editStage.initModality(Modality.WINDOW_MODAL);
                editStage.initOwner(button_redaguvatu.getScene().getWindow());

                editStage.showAndWait(); // Очікуємо завершення редагування

                tableView.refresh(); // Оновлюємо таблицю після редагування
            } catch (IOException e) {
                e.printStackTrace(); // Обробка помилки
            }
        } else {
            showAlert("Попередження", "Виберіть рядок для редагування!"); // Попередження, якщо нічого не вибрано
        }
    }

    // Метод для видалення вибраного запису
    @FXML
    void openWindowDelete(ActionEvent event) {
        Person selectedPerson = tableView.getSelectionModel().getSelectedItem(); // Отримуємо вибраний рядок
        if (selectedPerson != null) {
            // Підтвердження видалення через Alert
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                    "Ви дійсно хочете видалити цей запис?",
                    ButtonType.YES, ButtonType.NO);
            alert.setTitle("Підтвердження видалення");
            alert.setHeaderText(null);

            // Якщо користувач підтвердив видалення
            alert.showAndWait().ifPresent(buttonType -> {
                if (buttonType == ButtonType.YES) {
                    addressBookImpl.delete(selectedPerson); // Видаляємо особу зі списку
                }
            });
        } else {
            showAlert("Попередження", "Виберіть рядок для видалення!"); // Попередження, якщо нічого не вибрано
        }
    }

    // Метод для відображення попередження або помилки
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title); // Заголовок
        alert.setHeaderText(null); // Відсутність підзаголовка
        alert.setContentText(message); // Текст повідомлення
        alert.showAndWait(); // Показ спливаючого вікна
    }

    // Метод для відкриття вікна CSS-налаштувань
    public void openWindowCss(ActionEvent actionEvent) {
        try {
            stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("cssLab.fxml")); // Завантаження FXML
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("css"); // Заголовок вікна
            stage.setScene(scene);

            // Налаштування мінімального та максимального розміру вікна
            stage.setMinHeight(500);
            stage.setMinWidth(500);
            stage.setMaxHeight(900);
            stage.setMaxWidth(1000);

            // Налаштування модальності
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(button_dobavutu.getScene().getWindow());

            stage.show(); // Відображення вікна
        } catch (IOException e) {
            e.printStackTrace(); // Обробка помилки завантаження FXML
        }
    }

    // Метод для відкриття тестового вікна (ще не реалізований)
    public void openWindowTest(ActionEvent actionEvent) throws IOException {
            stage = new Stage(); // Створення нового вікна
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("test.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("TEST");
            stage.setScene(scene);
            stage.setMinWidth(1200);
            stage.setMinHeight(400);
            stage.show();
    }

    // Метод для пошуку (ще не реалізований)
    @FXML
    public void screach() {
        String searchText = textFieldScreach.getText().toLowerCase();
        filteredList = FXCollections.observableArrayList();
        for (Person person : addressBookImpl.getPersonList()) {
            if (person.getPIP().toLowerCase().contains(searchText) || person.getPHONE().contains(searchText)) {
                filteredList.add(person);
            }
        }
        tableView.setItems(filteredList);
    }

}
