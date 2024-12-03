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
    private Button button_dobavutu, button_vudalutu, button_redaguvatu;
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
    public void initialize() {
        columnPIP.setCellValueFactory(new PropertyValueFactory<>("PIP"));
        columnPhone.setCellValueFactory(new PropertyValueFactory<>("PHONE"));

        addressBookImpl.getPersonList().addListener((ListChangeListener<Person>) c ->
                labelId.setText("Кількість записів: " + addressBookImpl.getPersonList().size())
        );

        addressBookImpl.fillTestData();
        tableView.setItems(addressBookImpl.getPersonList());
    }

    @FXML
    void openWindowAdd(ActionEvent event) throws IOException {
        try {
            stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("wind.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Додати запис");
            stage.setScene(scene);
            stage.setResizable(false);

            wind1Controller controller = fxmlLoader.getController();
            controller.setPerson(new Person());

            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(button_dobavutu.getScene().getWindow());

            stage.showAndWait();

            Person person = controller.getPerson();
            if (person.getPIP() != null && !person.getPIP().isEmpty() &&
                    person.getPHONE() != null && !person.getPHONE().isEmpty()) {
                addressBookImpl.add(person);
            } else {
                showAlert("Помилка", "Поля не можуть бути порожніми!");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void openWindowEdit(ActionEvent event) {
        Person selectedPerson = tableView.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            try {
                Stage editStage = new Stage();
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("wind2.fxml"));
                Scene scene = new Scene(loader.load());
                editStage.setTitle("Редагування запису");
                editStage.setScene(scene);

                wind2Controller controller = loader.getController();
                controller.setPerson(selectedPerson);

                editStage.initModality(Modality.WINDOW_MODAL);
                editStage.initOwner(button_redaguvatu.getScene().getWindow());

                editStage.showAndWait();

                tableView.refresh();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            showAlert("Попередження", "Виберіть рядок для редагування!");
        }
    }

    @FXML
    void openWindowDelete(ActionEvent event) {
        Person selectedPerson = tableView.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                    "Ви дійсно хочете видалити цей запис?",
                    ButtonType.YES, ButtonType.NO);
            alert.setTitle("Підтвердження видалення");
            alert.setHeaderText(null);

            alert.showAndWait().ifPresent(buttonType -> {
                if (buttonType == ButtonType.YES) {
                    addressBookImpl.delete(selectedPerson);
                }
            });
        } else {
            showAlert("Попередження", "Виберіть рядок для видалення!");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void openWindowCss(ActionEvent actionEvent) {//кнопка css, cssLab.fxml
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

    public void screach(ActionEvent actionEvent) {
    }
}

