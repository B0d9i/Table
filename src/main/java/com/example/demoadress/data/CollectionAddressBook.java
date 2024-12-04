package com.example.demoadress.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

// Клас для роботи з колекцією контактів, який реалізує інтерфейс AddressBook.
public class CollectionAddressBook implements AddressBook {

    // Створення ObservableList для зберігання списку об'єктів Person.
    private ObservableList<Person> personList = FXCollections.observableArrayList();

    // Додає новий об'єкт Person до списку.
    @Override
    public void add(Person person) {
        personList.add(person);
    }

    // Метод для оновлення об'єкта Person у списку (не реалізований, але можна додати логіку).
    @Override
    public void update(Person person) {
        // Optional logic if needed
    }

    // Видаляє об'єкт Person зі списку.
    @Override
    public void delete(Person person) {
        personList.remove(person);
    }

    // Повертає ObservableList зі списком усіх контактів.
    public ObservableList<Person> getPersonList() {
        return personList;
    }

    // Заповнює список тестовими даними для перевірки роботи програми.
    public void fillTestData() {
        personList.add(new Person("Yulia", "12231")); // Додавання тестового контакту.
        personList.add(new Person("Oksana", "02365")); // Додавання тестового контакту.
        personList.add(new Person("Petro", "465875")); // Додавання тестового контакту.
    }
}
