package com.example.demoadress;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class TestController {

    @FXML
    private CheckBox Bogdan;
    @FXML
    private Button ButtonCheckBox;
    @FXML
    private Button ButtonChoiseBox;
    @FXML
    private Button ButtonRadioButton;
    @FXML
    private CheckBox Ivan;
    @FXML
    private RadioButton KG;
    @FXML
    private RadioButton LMV;
    @FXML
    private CheckBox Natalia;
    @FXML
    private RadioButton TVOI;
    @FXML
    private Label labelCheckBox;
    @FXML
    private Label labelChoiseBox;
    @FXML
    private Label labelComboBox;
    @FXML
    private Label labelRadioButton;

    @FXML
    private ChoiceBox<String> choiceBox; // ChoiceBox для вибору варіанту
    @FXML
    private ComboBox<String> ComboBox; // ComboBox з автозаповненням

    @FXML
    public void initialize() {
        // Додати елементи до ChoiceBox
        choiceBox.getItems().addAll("КН31", "КН32с", "КН33с");

        // Встановити початковий текст у Label
        labelChoiseBox.setText("Оберіть варіант");

        // Додавання варіантів до ComboBox
        ObservableList<String> options = FXCollections.observableArrayList("КН31", "КН32с", "КН33с");
        ComboBox.setItems(options);
        ComboBox.setEditable(true); // Робимо ComboBox редагованим

        // Додаємо слухач для автозаповнення
        ComboBox.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == null || newValue.isEmpty()) {
                ComboBox.setItems(options); // Показуємо всі варіанти
            } else {
                // Фільтруємо варіанти
                ObservableList<String> filteredOptions = options.filtered(option -> option.toLowerCase().contains(newValue.toLowerCase()));
                ComboBox.setItems(filteredOptions);

                // Автоматично відкриваємо випадаючий список
                if (!filteredOptions.isEmpty()) {
                    ComboBox.show();
                }
            }

            // Змінюємо labelComboBox на "Правильно" при виборі "КН32с"
            if ("КН32с".equalsIgnoreCase(newValue)) {
                labelComboBox.setText("Правильно");
            } else {
                labelComboBox.setText("");
            }
        });

        // Обробка вибору
        ComboBox.setOnAction(event -> checkComboBox());

        // Додавання RadioButton до ToggleGroup для забезпечення взаємовиключення
        ToggleGroup radioGroup = new ToggleGroup();
        KG.setToggleGroup(radioGroup);
        LMV.setToggleGroup(radioGroup);
        TVOI.setToggleGroup(radioGroup);
    }

    @FXML
    void checkCheckBox(ActionEvent event) {
        // Перевірка стану CheckBox
        boolean isBogdanSelected = Bogdan.isSelected();
        boolean isNataliaSelected = Natalia.isSelected();
        boolean isIvanSelected = Ivan.isSelected();

        // Логіка перевірки
        if (isBogdanSelected && isNataliaSelected && !isIvanSelected) {
            labelCheckBox.setText("Відповідь правильна");
        } else {
            labelCheckBox.setText("Відповідь не правильна");
        }
    }

    @FXML
    public void checkChoiseBox() {
        // Отримати вибраний елемент
        String selectedOption = choiceBox.getValue();

        // Логіка перевірки
        if ("КН31".equals(selectedOption)) {
            labelChoiseBox.setText("Правильно");
        } else {
            labelChoiseBox.setText("Не правильно");
        }
    }

    @FXML
    private void checkComboBox() {
        // Перевіряємо вибраний елемент у ComboBox
        String selected = ComboBox.getValue();
        if ("КН32с".equalsIgnoreCase(selected)) {
            labelComboBox.setText("Правильно");
        } else {
            labelComboBox.setText("Неправильно");
        }
    }

    @FXML
    void checkRadioButton(ActionEvent event) {
        // Перевіряємо, який RadioButton вибрано
        if (LMV.isSelected()) {
            labelRadioButton.setText("Правильно"); // Якщо вибрано LMV
        } else {
            labelRadioButton.setText("Неправильно"); // Для інших варіантів
        }
    }
}