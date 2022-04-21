package bank.bank;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class UserController implements Initializable {

    @FXML
    private Button home;

    @FXML
    private TextField Accno;

    @FXML
    private Button login;

    @FXML
    private PasswordField pin;

    @FXML
    private ComboBox<String> bank;

    ObservableList<String> banks = FXCollections.observableArrayList("CRDB","NMB","NBC");




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        bank.setItems(banks);

        home.setOnAction(e-> {
           DBUtils.changescene(e,null, "HOME","Home.fxml");
        });

        login.setOnAction(event -> {

           DBUtils.loginuser(event,Integer.parseInt(Accno.getText()),Integer.parseInt(pin.getText()), bank.getValue());

        });


    }

//    public void display(ActionEvent event){
//
//        if (bank.getValue().equals("CRDB")){
//
//            DBUtils.changesceneusers(event, "CRDB.fxml");
//
//        }else if (bank.getValue().equals("NMB")){
//
//            DBUtils.changesceneusers(event,"NMB.fxml");
//
//        }else if (bank.getValue().equals("NBC")){
//
//            DBUtils.changesceneusers(event,"NBC.fxml");
//
//        }
//
//        System.out.println(bank.getValue());
//
//
//
//    }

}
