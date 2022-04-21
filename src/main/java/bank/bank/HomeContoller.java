package bank.bank;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeContoller implements Initializable {


    @FXML
    private ComboBox<String> banks;
    ObservableList<String> bank_ = FXCollections.observableArrayList("CRDB", "NMB", "NBC");



    @FXML
    private Button admin;

    @FXML
    private Button user;





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        banks.setItems(bank_);


        user.setOnAction(event -> {
           DBUtils.changescene(event,null, "USER LOGIN","User.fxml");
        });

        admin.setOnAction(event -> {

           DBUtils.changescene(event,null, "ADMIN LOGIN","Adminlog.fxml");

        });



    }


    public void display(ActionEvent event){

        if (banks.getValue().equals("CRDB")){

            DBUtils.changescene(event,banks.getValue(), "CRDB","CRDB.fxml");

        }else if (banks.getValue().equals("NMB")){

            DBUtils.changescene(event,banks.getValue(), "NMB","NMB.fxml");

        }else if (banks.getValue().equals("NBC")){

            DBUtils.changescene(event,banks.getValue(), "NBC","NBC.fxml");

        }

        System.out.println(banks.getValue());



    }



}




