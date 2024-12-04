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

    // Ініціалізація: завантажуємо попередньо збережені кольори
    @FXML
    public void initialize() {
        // Завантажуємо збережені кольори з ColorUtils
        Color savedBackgroundColor = ColorUtils.getBackgroundColor();
        Color savedTextColor = ColorUtils.getTextColor();

        // Встановлюємо ці кольори в ColorPicker
        ColorBackground.setValue(savedBackgroundColor);
        ColorText.setValue(savedTextColor);

        // Застосовуємо ці кольори до елементів інтерфейсу
        applyColor(savedBackgroundColor, savedTextColor);
    }

    // Метод для закриття вікна
    public void openWindowEsc(ActionEvent actionEvent) {
        Stage stage = (Stage) buttonEsc.getScene().getWindow();
        stage.close();
    }

    // Метод для застосування кольору фону та тексту
    public void applyColor(ActionEvent actionEvent) {
        // Отримуємо вибраний колір фону та тексту з ColorPickers
        Color bgColor = ColorBackground.getValue();
        Color textColor = ColorText.getValue();

//        // Зберігаємо вибрані кольори в ColorSettings для подальшого використання
//        ColorSettings.setBackgroundColor(bgColor);
//        ColorSettings.setTextColor(textColor);

        // Збереження вибраних кольорів через ColorUtils
        ColorUtils.saveColors(bgColor, textColor);

        // Застосовуємо ці кольори до елементів інтерфейсу
        applyColor(bgColor, textColor);
    }

    // Метод, який безпосередньо застосовує кольори до стилів елементів інтерфейсу
    private void applyColor(Color bgColor, Color textColor) {
        // Застосовуємо колір фону до кореневого контейнера (VBox)
        String bgStyle = String.format("-fx-background-color: rgba(%d, %d, %d, %.2f);",
                (int) (bgColor.getRed() * 255), (int) (bgColor.getGreen() * 255),
                (int) (bgColor.getBlue() * 255), bgColor.getOpacity());
        rootPane.setStyle(bgStyle);

        // Застосовуємо колір тексту до лейблів
        String textStyle = String.format("-fx-text-fill: rgba(%d, %d, %d, %.2f);",
                (int) (textColor.getRed() * 255), (int) (textColor.getGreen() * 255),
                (int) (textColor.getBlue() * 255), textColor.getOpacity());

        // Проходимо через всі дочірні елементи rootPane і застосовуємо стиль тексту до всіх елементів, що мають текст
        rootPane.getChildren().forEach(node -> {
            if (node instanceof Labeled) {
                ((Labeled) node).setStyle(textStyle);
            }
        });

        // Застосовуємо стиль до кнопок (фон та межі)
        String buttonStyle = String.format(
                "-fx-background-color: rgba(%d, %d, %d, %.2f); " +
                        "-fx-border-color: rgba(%d, %d, %d, %.2f); " +
                        "-fx-border-width: 2;",
                (int) (bgColor.getRed() * 255), (int) (bgColor.getGreen() * 255),
                (int) (bgColor.getBlue() * 255), bgColor.getOpacity(),
                (int) (textColor.getRed() * 255), (int) (textColor.getGreen() * 255),
                (int) (textColor.getBlue() * 255), textColor.getOpacity());

        // Застосовуємо стиль до кнопок
        buttonEsc.setStyle(buttonStyle);
        buttonColor.setStyle(buttonStyle);
        buttonData.setStyle(buttonStyle);

        // Оновлюємо стиль тексту для кнопок
        buttonEsc.setStyle(buttonStyle + textStyle);
        buttonColor.setStyle(buttonStyle + textStyle);
        buttonData.setStyle(buttonStyle + textStyle);

        // Оновлення стилю тексту для лейблів
        txtBgColor.setStyle(textStyle);
        txtColor.setStyle(textStyle);
        txtData.setStyle(textStyle);
        txtMedia.setStyle(textStyle);
    }
}
