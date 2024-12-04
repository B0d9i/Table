package com.example.demoadress;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class cssLabController {

    @FXML
    private ColorPicker ColorBackground;// Поле для вибору кольору фону.
    @FXML
    private ColorPicker ColorText;// Поле для вибору кольору тексту.
    @FXML
    private Button buttonColor;// Кнопка для застосування кольору.
    @FXML
    private Button buttonData;// Кнопка для оновлення даних (функціонал поки не реалізований).
    @FXML
    private Button buttonEsc;// Кнопка для закриття вікна.
    @FXML
    private VBox rootPane;// Контейнер VBox, до якого застосовуються стилі.
    @FXML
    private Label txtBgColor;// Лейбли для відображення текстових повідомлень.

    @FXML
    private Label txtColor;
    @FXML
    private Label txtData;
    @FXML
    private Label txtMedia;

    // Метод для закриття вікна.
    public void openWindowEsc(ActionEvent actionEvent) {
        Stage stage = (Stage) buttonEsc.getScene().getWindow();// Закриття основного вікна через статичний метод `HelloController`.
        stage.close();
        //можлива альтернатива, але кучеряво.
        //HelloController.getStage().close();
    }

    // Метод для застосування кольору фону і тексту.
    public void aplyColor(ActionEvent actionEvent) {
        // Отримання вибраного кольору для фону.
        Color bgColor = ColorBackground.getValue();
        String bgStyle = String.format("-fx-background-color: rgba(%d, %d, %d, %.2f);",
                (int) (bgColor.getRed() * 255), // Червона компонента кольору.
                (int) (bgColor.getGreen() * 255), // Зелена компонента кольору.
                (int) (bgColor.getBlue() * 255), // Синя компонента кольору.
                bgColor.getOpacity()); // Прозорість кольору.
        rootPane.setStyle(bgStyle); // Застосування стилю до контейнера VBox.

        // Отримання вибраного кольору для тексту.
        Color textColor = ColorText.getValue();
        String textStyle = String.format("-fx-text-fill: rgba(%d, %d, %d, %.2f);",
                (int) (textColor.getRed() * 255),
                (int) (textColor.getGreen() * 255),
                (int) (textColor.getBlue() * 255),
                textColor.getOpacity());// Застосування стилю до тексту

        // Проходження через всі дочірні елементи VBox. метод не працює))))
        rootPane.getChildren().forEach(node -> {
            if (node instanceof Labeled) { // Якщо елемент підтримує текст.
                ((Labeled) node).setStyle(textStyle);
            }
        });

        // Застосування стилів до кнопок (фон і контур).
        String buttonStyle = String.format(
                "-fx-background-color: rgba(%d, %d, %d, %.2f); " + // Фон кнопки.
                        "-fx-border-color: rgba(%d, %d, %d, %.2f); " + // Контур кнопки.
                        "-fx-border-width: 2;", // Ширина контуру.
                (int) (bgColor.getRed() * 255), (int) (bgColor.getGreen() * 255),
                (int) (bgColor.getBlue() * 255), bgColor.getOpacity(),
                (int) (textColor.getRed() * 255), (int) (textColor.getGreen() * 255),
                (int) (textColor.getBlue() * 255), textColor.getOpacity());

        buttonEsc.setStyle(buttonStyle);
        buttonColor.setStyle(buttonStyle);
        buttonData.setStyle(buttonStyle);

        // Застосування стилю тексту для кнопок, якщо вони містять текст.
        buttonEsc.setStyle(buttonStyle + textStyle);
        buttonColor.setStyle(buttonStyle + textStyle);
        buttonData.setStyle(buttonStyle + textStyle);

        // Оновлення стилю для лейблів вручну (якщо потрібно).
        txtBgColor.setStyle(textStyle);
        txtColor.setStyle(textStyle);
        txtData.setStyle(textStyle);
        txtMedia.setStyle(textStyle);
    }

    // Метод для застосування даних (поки не реалізовано).
    public void aplyData(ActionEvent actionEvent) {
        // треба зробити щоб label відображав вказану дату
    }
}
