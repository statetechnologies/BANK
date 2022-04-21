package bank.bank;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;

import java.net.URL;
import java.util.ResourceBundle;

public class PinController implements Initializable{

    @FXML
    private PasswordField oldpin;
    @FXML
    private PasswordField newpin;
    @FXML
    private PasswordField newpin1;
    @FXML
    private Button done;
    @FXML
    private Button home;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        home.setOnAction(event -> {
           DBUtils.changesceneusers(event,"TRANSACT", "Transact.fxml");
        });

        done.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               DBUtils.changepin(event,Integer.parseInt(oldpin.getText()),Integer.parseInt(newpin.getText()),Integer.parseInt(newpin1.getText()));
            }
        });

    }
}
