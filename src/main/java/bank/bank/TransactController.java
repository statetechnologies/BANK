package bank.bank;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class TransactController implements Initializable {


    @FXML
    private Button deposit;
    @FXML
    private Button withdraw;
    @FXML
    private Button ministatement;
    @FXML
    private Button savings;
    @FXML
    private Button changepin;
    @FXML
    private Button balance;
    @FXML
    private Button logout;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        deposit.setOnAction(event -> {
            DBUtils.changepage(event, "DEPOSIT","Deposits.fxml");
        });

        withdraw.setOnAction(event -> {
            DBUtils.changepage(event, "WITHDRAW","Withdraws.fxml");
        });

        ministatement.setOnAction(event -> {
         DBUtils.changepage(event, "MINISTATEMENT","Ministatement.fxml");
        });

        balance.setOnAction(event -> {
           DBUtils.changepage(event,  "BALANCE","Balance.fxml");
        });

        savings.setOnAction(event -> {
           DBUtils.changepage(event,  "SAVINGS","Savings.fxml");
        });

        logout.setOnAction(event -> {
            DBUtils.changescene(event,null, "USER LOGIN","User.fxml");
        });

        changepin.setOnAction(event -> {
           DBUtils.changepage(event, "CHANGE PIN", "Pin.fxml");
        });

    }
}
