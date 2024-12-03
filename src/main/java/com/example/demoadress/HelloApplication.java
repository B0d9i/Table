package com.example.demoadress;

import com.example.demoadress.data.CollectionAddressBook;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("pg");
        stage.setScene(scene);
        stage.setMinHeight(600);//мін висота і довгота
        stage.setMinWidth(600);


        stage.show();
        testData();
    }
    private void testData() {
        CollectionAddressBook addressBook = new CollectionAddressBook();
        addressBook.fillTestData();//задає значення
        System.out.println(addressBook);//виводить
    }
    public static void main(String[] args) {
        launch();
    }
}