package bank.bank;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class AdminPageController implements Initializable {


        @FXML
        private TableView<Admins> Details;

        @FXML
        private Button add;

        @FXML
        private Button delete;

        @FXML
        private TextField email;

        @FXML
        private TableColumn<Admins, String> email_;

        @FXML
        private TextField fullname;

        @FXML
        private TableColumn<Admins, String> fullname_;

        @FXML
        private TextField number;

        @FXML
        private PasswordField password;

        @FXML
        private TableColumn<Admins, String> password_;

        @FXML
        private TableColumn<Admins, Integer> phone_;

        @FXML
        private Button update;

        @FXML
        private TextField username;

        @FXML
        private TableColumn<Admins, String> username_;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



showadmins();



            add.setOnAction(event -> {
                    bank.bank.DBUtils.registeradmins(event,fullname.getText(), email.getText(),username.getText(),
                            password.getText(),Integer.parseInt(number.getText()));
            });

            update.setOnAction(event -> {

                    Connection connection = null;

                    Statement updateuser = null;
                   // ResultSet resultSet = null;

                    try {

                            connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/BankSystem", "root", "root");

                                    updateuser = connection.createStatement();
                                    updateuser.executeUpdate("UPDATE Admin SET Email= '"+email.getText()+"', Username= '"+username.getText()+"', Password= '"+password.getText()+"', Phone= '"+number.getText()+"' WHERE FullName= '"+fullname.getText()+"'");


                        showadmins();



                    } catch (SQLException e) {
                            e.printStackTrace();
                    } finally {
//                            if (resultSet != null) {
//                                    try {
//                                            resultSet.close();
//                                    } catch (SQLException e) {
//                                            e.printStackTrace();
//                                    }
//
//                            }
                            if (updateuser != null) {
                                    try {
                                            updateuser.close();
                                    } catch (SQLException e) {
                                            e.printStackTrace();
                                    }

                            }
                            if (connection != null) {
                                    try {
                                            connection.close();
                                    } catch (SQLException e) {
                                            e.printStackTrace();
                                    }

                            }
                    }
            });

            delete.setOnAction(event -> {

                    Connection connection = null;
                    Statement deleteuser = null;
                   // ResultSet resultSet = null;

                    try {

                            connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/BankSystem", "root", "root");


                                    deleteuser = connection.createStatement();

                                 deleteuser.executeUpdate("DELETE FROM Admin WHERE Username ='" + username.getText().trim() + "'");

                                   showadmins();





                    } catch (SQLException e) {
                            e.printStackTrace();
                    } finally {
                            if (deleteuser != null) {
                                    try {
                                            deleteuser.close();
                                    } catch (SQLException e) {
                                            e.printStackTrace();
                                    }

                            }
//                            if (resultset != null) {
//                                    try {
//                                           resultset.close();
//                                    } catch (SQLException e) {
//                                            e.printStackTrace();
//                                    }
//
//                            }
                            if (connection != null) {
                                    try {
                                            connection.close();
                                    } catch (SQLException e) {
                                            e.printStackTrace();
                                    }

                            }
                    }

            });


            Details.setOnMouseClicked(event -> {

                    Admins admin = Details.getSelectionModel().getSelectedItem();

                    fullname.setText(admin.getFullname());
                    email.setText(admin.getEmail());
                    username.setText(admin.getUsername());
                    password.setText(admin.getPassword());
                    number.setText(String.valueOf(admin.getPhone()));

            });

    }

    public ObservableList<Admins> getAdmins(){

            ObservableList<Admins> adminsList = FXCollections.observableArrayList();

            Connection connection = null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;

            try {
                    connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/BankSystem", "root", "root");
                    preparedStatement = connection.prepareStatement("SELECT * FROM Admin");
                    resultSet = preparedStatement.executeQuery();

                    Admins admins;

                    while (resultSet.next()){
                            admins = new Admins(resultSet.getString("FullName"),
                                    resultSet.getString("Email"), resultSet.getString("Username"),
                                    resultSet.getString("Password"), resultSet.getInt("Phone"));

                            adminsList.add(admins);
                    }

            } catch (SQLException e) {
                    e.printStackTrace();
            }finally {
                    if (resultSet != null) {
                            try {


                                    resultSet.close();
                            }catch (SQLException e){
                                    e.printStackTrace();
                            }
                    }
                    if (preparedStatement != null) {
                            try {


                                    preparedStatement.close();
                            }catch (SQLException e){
                                    e.printStackTrace();
                            }
                    }
                    if (connection != null) {
                            try {


                                    connection.close();
                            }catch (SQLException e){
                                    e.printStackTrace();
                            }
                    }
            }
            return adminsList;


    }

    public void showadmins(){

            ObservableList<Admins> adminslist = getAdmins();

            fullname_.setCellValueFactory(new PropertyValueFactory<Admins, String>("Fullname"));
            email_.setCellValueFactory(new PropertyValueFactory<Admins, String>("Email"));
            username_.setCellValueFactory(new PropertyValueFactory<Admins, String >("Username"));
            password_.setCellValueFactory(new PropertyValueFactory<Admins, String>("Password"));
            phone_.setCellValueFactory(new PropertyValueFactory<Admins, Integer>("Phone"));

            Details.setItems(adminslist);

    }





}
