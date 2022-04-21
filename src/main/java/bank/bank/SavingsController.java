package bank.bank;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SavingsController implements Initializable {

    @FXML
    private TextField amount;

    @FXML
    private Button home;

    @FXML
    private Button save;

    @FXML
    private TextField time;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        home.setOnAction(event -> {
           DBUtils.changesceneusers(event,"TRANSACT", "Transact.fxml");
        });

        save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
              DBUtils.savings(event,Integer.parseInt(amount.getText()),Integer.parseInt(time.getText()));
            }
        });


    }
}
