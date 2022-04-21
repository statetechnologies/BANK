package bank.bank;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;

public class AdminController implements Initializable {

    @FXML
    private Button login;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button home;
    @FXML
    private Label date;
    @FXML
    private Label time;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

//        LocalDate ld = LocalDate.now();
        Date dates = new Date();
        SimpleDateFormat formats = new SimpleDateFormat("dd-MM-yyy");
        formats.format(dates);

        LocalTime lt = LocalTime.now();
       lt.format(DateTimeFormatter.ofPattern("hh-mm-ss"));

        date.setText("Date: "+dates.toString());
        time.setText("Time: " + lt.toString());




        home.setOnAction(event -> {
            DBUtils.changescene(event,null, "HOME","Home.fxml");
        });

        login.setOnAction(event -> {
           DBUtils.loginadmin(event,username.getText(),password.getText());
        });


    }


}
