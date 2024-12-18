package com.example.demoadress;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class TestController {

    @FXML
    private CheckBox checkBoxStudent1;
    @FXML
    private CheckBox checkBoxStudent2;
    @FXML
    private CheckBox checkBoxStudent3;
    @FXML
    private Button buttonVerifyMultiAnswer;
    @FXML
    private Label labelMultiAnswerResult;

    @FXML
    private ChoiceBox<String> choiceBoxDepartment;
    @FXML
    private Button buttonVerifyChoice;
    @FXML
    private Label labelChoiceResult;

    @FXML
    private ComboBox<String> comboBoxSpecialization;
    @FXML
    private Label labelComboBoxResult;

    @FXML
    private RadioButton radioButtonFavoriteCourse1;
    @FXML
    private RadioButton radioButtonFavoriteCourse2;
    @FXML
    private RadioButton radioButtonFavoriteCourse3;
    @FXML
    private Button buttonVerifyRadio;
    @FXML
    private Label labelRadioResult;

    @FXML
    public void initialize() {
        // Initialize ChoiceBox
        choiceBoxDepartment.getItems().addAll("Кафедра комп'ютерних наук", "Кафедра інформаційних систем", "Кафедра кібербезпеки","Кафедра інформаційних технологій та систем електронних комунікацій");


        // Initialize ComboBox with suggestions
        ObservableList<String> options = FXCollections.observableArrayList(
                "Комп'ютерні науки","Програмна інженерія",
                "Кібербезпека","Інженерія програмного забезпечення",
                "Інформаційні технології");
        comboBoxSpecialization.setItems(options);
        comboBoxSpecialization.setEditable(true);

        comboBoxSpecialization.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.isEmpty()) {
                labelComboBoxResult.setText("");
                comboBoxSpecialization.hide();
                return;
            }

            // Filter items based on input
            ObservableList<String> filteredOptions = options.filtered(item ->
                    item.toLowerCase().contains(newValue.toLowerCase())
            );
            comboBoxSpecialization.setItems(filteredOptions);

            // If there's a match, show suggestions
            if (!filteredOptions.isEmpty()) {
                comboBoxSpecialization.show();
            }

            // Check if the exact match is selected
            if (options.contains(newValue)) {
                checkComboBoxAnswer(newValue);
            } else {
                labelComboBoxResult.setText("");
            }
        });

        // Listener to handle selection from ComboBox
        comboBoxSpecialization.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null && options.contains(newValue)) {
                checkComboBoxAnswer(newValue);
            }
        });

        // RadioButton Group
        ToggleGroup favoriteCourseGroup = new ToggleGroup();
        radioButtonFavoriteCourse1.setToggleGroup(favoriteCourseGroup);
        radioButtonFavoriteCourse2.setToggleGroup(favoriteCourseGroup);
        radioButtonFavoriteCourse3.setToggleGroup(favoriteCourseGroup);
    }

    @FXML
    public void verifyMultiAnswer(ActionEvent event) {
        boolean isStudent1Correct = checkBoxStudent1.isSelected();
        boolean isStudent2Correct = checkBoxStudent2.isSelected();
        boolean isStudent3Correct = !checkBoxStudent3.isSelected();

        if (isStudent1Correct && isStudent2Correct && isStudent3Correct) {
            labelMultiAnswerResult.setText("Відповідь правильна");
            labelMultiAnswerResult.setStyle("-fx-text-fill: green;");
        } else {
            labelMultiAnswerResult.setText("Відповідь неправильна");
            labelMultiAnswerResult.setStyle("-fx-text-fill: red;");
        }
    }

    @FXML
    public void verifyChoiceBox() {
        String selectedDepartment = choiceBoxDepartment.getValue();
        if ("Кафедра інформаційних технологій та систем електронних комунікацій".equals(selectedDepartment)) {
            labelChoiceResult.setText("Правильно");
            labelChoiceResult.setStyle("-fx-text-fill: green;");
        } else {
            labelChoiceResult.setText("Неправильно");
            labelChoiceResult.setStyle("-fx-text-fill: red;");
        }
    }

    @FXML
    public void verifyRadioButton(ActionEvent event) {
        if (radioButtonFavoriteCourse1.isSelected()) {
            labelRadioResult.setText("Правильно");
            labelRadioResult.setStyle("-fx-text-fill: green;");
        } else {
            labelRadioResult.setText("Неправильно");
            labelRadioResult.setStyle("-fx-text-fill: red;");
        }
    }

    private void checkComboBoxAnswer(String selectedSpecialization) {
        if ("Комп'ютерні науки".equalsIgnoreCase(selectedSpecialization)) {
            labelComboBoxResult.setText("Правильно");
            labelComboBoxResult.setStyle("-fx-text-fill: green;");
        } else {
            labelComboBoxResult.setText("Неправильно");
            labelComboBoxResult.setStyle("-fx-text-fill: red;");
        }
    }
}
