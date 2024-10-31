package com.example.demoadress;

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


            Stage stage = new Stage();
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
    void deleteRecord(ActionEvent event) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("del");
            alert.setHeaderText("Results:");
            alert.setContentText("Ви видалили запис");

            alert.showAndWait();

    }
    @FXML
    void openWindow1(ActionEvent event) throws IOException {

        try {


            Stage stage = new Stage();
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


            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("wind.fxml"));
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

}
