package bank.bank;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class BalanceController extends bank.bank.DBUtils implements Initializable {

    @FXML
    private Label balance;

    @FXML
    private Button home;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        balance.setText("Your Balance is " + String.valueOf(getBalance()));
        home.setOnAction(event -> {
            bank.bank.DBUtils.changesceneusers(event,"HOME","Transact.fxml");
        });

    }
}
