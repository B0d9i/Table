package com.example.demoadress.data;

import javafx.beans.property.SimpleStringProperty;

// Клас Person представляє окрему особу з властивостями ПІБ (PIP) та номер телефону (PHONE).
public class Person {

    // Властивість для зберігання ПІБ, що підтримує JavaFX binding.
    private SimpleStringProperty PIP = new SimpleStringProperty("");

    // Властивість для зберігання номера телефону, що підтримує JavaFX binding.
    private SimpleStringProperty PHONE = new SimpleStringProperty("");

    // Конструктор для створення об'єкта з вказаними ПІБ та номером телефону.
    public Person(String PIP, String PHONE) {
        this.PIP = new SimpleStringProperty(PIP); // Ініціалізація властивості ПІБ.
        this.PHONE = new SimpleStringProperty(PHONE); // Ініціалізація властивості номера телефону.
    }

    // Конструктор без параметрів для створення порожнього об'єкта.
    public Person() {
    }

    // Повертає значення властивості ПІБ як строку.
    public String getPIP() {
        return PIP.get();
    }

    // Повертає саму властивість ПІБ для використання у JavaFX binding.
    public SimpleStringProperty PIPProperty() {
        return PIP;
    }

    // Встановлює нове значення для властивості ПІБ.
    public void setPIP(String PIP) {
        this.PIP.set(PIP);
    }

    // Повертає значення властивості номера телефону як строку.
    public String getPHONE() {
        return PHONE.get();
    }

    // Повертає саму властивість номера телефону для використання у JavaFX binding.
    public SimpleStringProperty PHONEProperty() {
        return PHONE;
    }

    // Встановлює нове значення для властивості номера телефону.
    public void setPHONE(String PHONE) {
        this.PHONE.set(PHONE);
    }
}
