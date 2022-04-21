package bank.bank;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class NMBController implements Initializable {

    @FXML
    private Button home;
    @FXML
    private Button register;

    @FXML
    private TextField firstname;

    @FXML
    private TextField middlename;
    @FXML
    private TextField surname;
    @FXML
    private TextField email;
    @FXML
    private TextField account_no;
    @FXML
    private TextField card_no;
    @FXML
    private TextField pin;
    @FXML
    private TextField City;
    @FXML
    private TextField phone;

    @FXML
    private ComboBox<String> sex;
    @FXML
    private ComboBox<String> account_type;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<String> gender = FXCollections.observableArrayList("Male","Female");
        sex.setItems(gender);

        ObservableList<String> types = FXCollections.observableArrayList("SAvings", "Investment", "Student","Boss");
        account_type.setItems(types);

        home.setOnAction(event -> {
           DBUtils.changescene(event,null, "HOME","Home.fxml");
        });

        register.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

               DBUtils.registernmb(event,firstname.getText(),middlename.getText(),surname.getText(),email.getText(),
                        Integer.valueOf(account_no.getText()),Integer.valueOf(card_no.getText()),Integer.valueOf(pin.getText()),sex.getValue(),account_type.getValue(),
                        Integer.valueOf(phone.getText()),City.getText());

            }
        });

    }
}
