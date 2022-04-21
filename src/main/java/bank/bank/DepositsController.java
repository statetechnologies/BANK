package bank.bank;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public class DepositsController implements Initializable{

    @FXML
    private TextField amount;

    @FXML
    private Button deposit;

    @FXML
    private Button back;







    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {





        back.setOnAction(event -> {
            DBUtils.changesceneusers(event,"TRANSACT", "Transact.fxml");
        });

        deposit.setOnAction(event -> {
            DBUtils.deposits(event, Integer.parseInt(amount.getText()));
        });

    }


}
