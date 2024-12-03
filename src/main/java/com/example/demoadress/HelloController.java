package com.example.demoadress;

import com.example.demoadress.data.CollectionAddressBook;
import com.example.demoadress.data.Person;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    @FXML
    private Button button_dobavutu;
    @FXML
    private TableColumn<Person, String> columnPIP;
    @FXML
    private TableColumn<Person, String> columnPhone;
    @FXML
    private TableView<Person> tableView;

    @FXML
    private Label labelId;


    private CollectionAddressBook addressBookImpl = new CollectionAddressBook();
    private static Stage stage;

    public static Stage getStage() {
        return stage;
    }


    @FXML
    public void  initialize() {
        columnPIP.setCellValueFactory(new PropertyValueFactory<Person, String>("PIP"));
        columnPhone.setCellValueFactory(new PropertyValueFactory<Person, String>("PHONE"));//в стовпчик сцен білдера ТЕЛЕФОН показує значення змінної PHONE

        addressBookImpl.getPersonList().addListener(new ListChangeListener<Person>() {
            @Override
            public void onChanged(Change<? extends Person> c) {//змінюється напис в label
                labelId.setText("Кількість записів: "+addressBookImpl.getPersonList().size());//  ...+кількість елементів
            }
        });

        addressBookImpl.fillTestData();
        tableView.setItems(addressBookImpl.getPersonList());
    }

        @FXML
    void openWindow(ActionEvent event) throws IOException {

        try {


            stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("wind.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("dodatu");
            stage.setScene(scene);
            stage.setResizable(false);//не редагувати

            stage.initModality(Modality.WINDOW_MODAL);//блокується вікно на якій кнопка
            stage.initOwner(button_dobavutu.getScene().getWindow());


            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    void openWindow1(ActionEvent event) throws IOException {

        try {


            stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("wind2.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Редагування");
            stage.setScene(scene);
            stage.setResizable(false);//не редагувати

            stage.initModality(Modality.WINDOW_MODAL);//блокується вікно на якій кнопка
            stage.initOwner(button_dobavutu.getScene().getWindow());


            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    @FXML
    void openWindow2(ActionEvent event) throws IOException {

        try {


            stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("wind3Del.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("vudalutu");
            stage.setScene(scene);
            stage.setResizable(false);//не редагувати

            stage.initModality(Modality.WINDOW_MODAL);//блокується вікно на якій кнопка
            stage.initOwner(button_dobavutu.getScene().getWindow());


            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openWindowCss(ActionEvent actionEvent) {

        try {


            stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("cssLab.fxml"));// в css вказати pref розміз більший за міn розмір тут
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("css");
            stage.setScene(scene);
//            stage.setResizable(false);//не редагувати
            stage.setMinHeight(500);//мін висота і довгота
            stage.setMinWidth(500);
            stage.setMaxHeight(900);
            stage.setMaxWidth(1000);


            stage.initModality(Modality.WINDOW_MODAL);//блокується вікно на якій кнопка
            stage.initOwner(button_dobavutu.getScene().getWindow());


            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openWindowTest(ActionEvent actionEvent) {

    }
}
