package com.example.demoadress;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import javafx.scene.control.Button;

import java.awt.*;


public class cssLabController {
    @FXML
    private ColorPicker ColorBackground;

    @FXML
    private ColorPicker ColorText;

    @FXML
    private Button buttonColor;

    @FXML
    private Button buttonData;

    @FXML
    private Button buttonEsc;

    @FXML
    private VBox rootPane;

    @FXML
    private Label txtBgColor;

    @FXML
    private Label txtColor;

    @FXML
    private Label txtData;

    @FXML
    private Label txtMedia;

    public void openWindowEsc(ActionEvent actionEvent) {
        HelloController.getStage().close();
    }

    public void aplyColor(ActionEvent actionEvent) {
        // Отримання кольору фону
        Color bgColor = ColorBackground.getValue();
        String bgStyle = String.format("-fx-background-color: rgba(%d, %d, %d, %.2f);",
                (int) (bgColor.getRed() * 255),
                (int) (bgColor.getGreen() * 255),
                (int) (bgColor.getBlue() * 255),
                bgColor.getOpacity());
        rootPane.setStyle(bgStyle);

        // Отримання кольору тексту
        Color textColor = ColorText.getValue();
        String textStyle = String.format("-fx-text-fill: rgba(%d, %d, %d, %.2f);",
                (int) (textColor.getRed() * 255),
                (int) (textColor.getGreen() * 255),
                (int) (textColor.getBlue() * 255),
                textColor.getOpacity());

        // Застосовуємо стиль до всіх текстових елементів
        rootPane.getChildren().forEach(node -> {
            if (node instanceof Labeled) { // Для компонентів, що підтримують текст (Label, Button тощо)
                ((Labeled) node).setStyle(textStyle);
            }
            else if (node instanceof javafx.scene.control.TextField) { // Для TextField
                ((javafx.scene.control.TextField) node).setStyle(textStyle);
            }
        });

        // Додатково застосовуємо стиль до кнопок вручну
        buttonEsc.setStyle(textStyle);
        buttonColor.setStyle(textStyle);
        buttonData.setStyle(textStyle);
        txtBgColor.setStyle(textStyle); // Лейбл для кольору фону
        txtColor.setStyle(textStyle); // Лейбл для кольору тексту
        txtData.setStyle(textStyle); // Лейбл для даних
        txtMedia.setStyle(textStyle); // Лейбл для медіа
    }



    public void aplyData(ActionEvent actionEvent) {

    }
}
