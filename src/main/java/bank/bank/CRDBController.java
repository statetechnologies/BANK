package bank.bank;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class CRDBController implements Initializable {

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
    @FXML
    private ImageView profile;

//    Image crdbpic;
//FileChooser pictures = new FileChooser();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<String> gender = FXCollections.observableArrayList("Male","Female");
        sex.setItems(gender);

        ObservableList<String> types = FXCollections.observableArrayList("Savings", "Investment", "Student","Boss");
        account_type.setItems(types);

        home.setOnAction(event -> {
            DBUtils.changescene(event,null, "HOME","Home.fxml");
        });

        register.setOnAction(event -> {
         DBUtils.registercrdb(event,firstname.getText(),middlename.getText(),surname.getText(),email.getText(),
                    Integer.valueOf(account_no.getText()),Integer.valueOf(card_no.getText()),Integer.valueOf(pin.getText()),sex.getValue(),account_type.getValue(),
                    Integer.valueOf(phone.getText()),City.getText());
        });



//pictures.setInitialDirectory(new File("//Users//mrshanas//Desktop//Programming"));
//        pictures.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image", "*.jpeg", "*.jpg", "*.png"));
//        File selectedFile = pictures.showOpenDialog(null);
//        if (selectedFile != null){
//           crdbpic = selectedFile.getAbsolutePath();
//            profile.setImage(selectedFile.getAbsolutePath());
  //      }




    }
}
