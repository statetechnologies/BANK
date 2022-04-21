package bank.bank;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;

public class DBUtils {


    private static String Users_Names;
    private static String Admin_Names;
    private static String Admin_Pass;
    private static String BankName;
    private static int Accounts;
    private static int Pins;
    private static int balance;
    private static int Accounts1;
    private static int AmountDep;
    private static int AmountWith;
    private static String Titles;
    private static int newBalance;
    private static int newdepBalance;
    private static int newsaveBalance;
    private static int Interest;




    //USE THIS TO SWITH IN ADMIN PAGES
    public static void changesceneadmins(ActionEvent event, String fxmlFile) {
        Parent root = null;

        if (Admin_Names != null && Admin_Pass != null) {
            try {
                FXMLLoader loader = new FXMLLoader(DBUtils.class.getResource(fxmlFile));
                root = loader.load();
                AdminPageController adminPageController = loader.getController();


            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                root = FXMLLoader.load(DBUtils.class.getResource(fxmlFile));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Welcome " + Admin_Names);
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void appPage(ActionEvent event, String Title){


     //  Stage stage1 =(Stage) ((Node)event.getSource()).getScene().getWindow();

        Stage stage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(DBUtils.class.getResource("Home.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setTitle(Title);
        stage.setScene(new Scene(root));
        stage.show();


    }

    public static void changepage(ActionEvent event, String Title, String fxmlFile){
        String name = Users_Names;
        int Accno = Accounts;
        String Banks = BankName;
        int pins = Pins;

        Parent root = null;
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        try {
            if (Title.equals("DEPOSIT")) {

            FXMLLoader loader = new FXMLLoader(DBUtils.class.getResource(fxmlFile));
            root = loader.load();
           // DepositsController depositsController = loader.getController();
                stage.setTitle(Title);
        } else if (Title.equals("WITHDRAW")) {

            FXMLLoader loader = new FXMLLoader(DBUtils.class.getResource(fxmlFile));
            root = loader.load();

           // WithdrawsController withdrawsController = loader.getController();
                stage.setTitle(Title);

        } else if (Title.equals("MINISTATEMENT")) {
            FXMLLoader loader = new FXMLLoader(DBUtils.class.getResource(fxmlFile));
            root = loader.load();
           // MinistatementController ministatementController = loader.getController();
                stage.setTitle(Title);

        } else if (Title.equals("BALANCE")) {

                FXMLLoader loader = new FXMLLoader(DBUtils.class.getResource(fxmlFile));
                root = loader.load();
               // BalanceController balanceController = loader.getController();
                stage.setTitle(Title);


            }else if (Title.equals("SAVINGS")) {

                FXMLLoader loader = new FXMLLoader(DBUtils.class.getResource(fxmlFile));
                root = loader.load();
              // SavingsController savingsController = loader.getController();
                stage.setTitle(Title);


            }else if (Title.equals("CHANGE PIN")) {

                FXMLLoader loader = new FXMLLoader(DBUtils.class.getResource(fxmlFile));
                root = loader.load();
               // PinController pinController = loader.getController();
                stage.setTitle(Title);


            }
            else {
                FXMLLoader loader = new FXMLLoader(DBUtils.class.getResource(fxmlFile));
                root = loader.load();

                //THE CODE BELOW IS USED WHEN PASSING INFORMATION TO THE TARGET CONTROLLER OF THE NEXT PAGE
               // TransactController transactController = loader.getController();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        stage.setTitle(Title);
        stage.setScene(new Scene(root));
        stage.show();

    }

    //REFRESH PAGES
    public static void refreshpage(ActionEvent event, String Title, String fxmlFile){

        Parent root = null;
        FXMLLoader loader = new FXMLLoader(DBUtils.class.getResource(fxmlFile));
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(Title);
        stage.setScene(new Scene(root));
        stage.show();


    }

    //USE THIS TO GET BACK TO TRANSACTIONS PAGE
    public static void changesceneusers(ActionEvent event,String Title,  String fxmlFile) {

        String name = Users_Names;
        int Accno = Accounts;
        String Banks = BankName;
        int pins = Pins;
        Parent root = null;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();




        if (String.valueOf(pins).isEmpty() && String.valueOf(Accno).isEmpty()){

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Fill in the credentials");
            alert.show();

        }else if (Title.equals("DEPOSIT")){

            FXMLLoader loader = new FXMLLoader(DBUtils.class.getResource(fxmlFile));
            try {
                root = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            DepositsController depositsController = loader.getController();
            stage.setTitle(Title);

        } else if (Title.equals("WITHDRAW")){
            FXMLLoader loader = new FXMLLoader(DBUtils.class.getResource(fxmlFile));
            try {
                root = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            WithdrawsController withdrawsController = loader.getController();
            stage.setTitle(Title);
        } else {


            try {

                FXMLLoader loader = new FXMLLoader(DBUtils.class.getResource(fxmlFile));
                root = loader.load();
              //  TransactController transactController = loader.getController();
                stage.setTitle("WELCOME " + Users_Names);



            } catch (IOException e) {
                e.printStackTrace();
            }
        }



        stage.setScene(new Scene(root));
        stage.show();
    }

    //FOR HOME PAGE ONLY
    public static void changescene(ActionEvent event, String Bank_, String Title,String fxmlFile) {
        Parent root = null;

        if (Bank_ != null) {

            try {


                if (Bank_.equals("CRDB")) {
                    Title = Bank_;
                    FXMLLoader loader = new FXMLLoader(DBUtils.class.getResource(fxmlFile));
                    root = loader.load();
                  //  CRDBController crdbController = loader.getController();
                } else if (Bank_.equals("NMB")) {
                    Title = Bank_;
                    FXMLLoader loader = new FXMLLoader(DBUtils.class.getResource(fxmlFile));
                    root = loader.load();
                   // NMBController nmbController = loader.getController();

                } else if (Bank_.equals("NBC")) {
                    Title = Bank_;
                    FXMLLoader loader = new FXMLLoader(DBUtils.class.getResource(fxmlFile));
                    root = loader.load();

                   // NBCController nbcController = loader.getController();


                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                FXMLLoader loader = new FXMLLoader(DBUtils.class.getResource(fxmlFile));
                root = loader.load();

              // UserController userController = loader.getController();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(Title);
        stage.setScene(new Scene(root));
        stage.show();


    }

    public static void loginadmin(ActionEvent event, String Username, String Password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/BankSystem", "root", "root");
            preparedStatement = connection.prepareStatement("SELECT * FROM Admin WHERE Username=?");
            preparedStatement.setString(1, Username);
            resultSet = preparedStatement.executeQuery();

            if (!resultSet.isBeforeFirst()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("User not found");
                alert.show();
            } else {
                while (resultSet.next()) {

                    String pass = resultSet.getString("Password");
                    String users = resultSet.getString("Username");

                   Admin_Pass = pass;
                   Admin_Names = users;

                    if (pass.equals(Password)) {
                            changesceneadmins(event, "AdminPage.fxml");
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("INCORRECT PASSWORD");
                        alert.show();
                    }
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
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
    }

    public static void loginuser(ActionEvent event, int Accno, int Pin, String Bank) {

        Accounts = Accno;
        BankName = Bank;

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;


        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/BankSystem", "root", "root");
            preparedStatement = connection.prepareStatement("SELECT * FROM "+Bank+" WHERE Account_No="+Accno+"");
         //   preparedStatement.setInt(1, Accno);
            resultSet = preparedStatement.executeQuery();

            if (!resultSet.isBeforeFirst()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Account not found");
                alert.show();
            } else {
                while (resultSet.next()) {

                    int pins = resultSet.getInt("Pin");

                    Pins = pins;

                    Users_Names = resultSet.getString("Firstname")+ " "+ resultSet.getString("Middlename") +" "+ resultSet.getString("Surname");

                    if (pins == Pin) {

                        changesceneusers(event,"TRANSACTIONS", "Transact.fxml");

                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("INCORRECT PIN");
                        alert.show();
                    }
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
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
    }

    public static void registeradmins(ActionEvent event, String Fullname, String Email, String Username,
                                      String Password, int Phone){

        Connection connection = null;
        PreparedStatement checkuser = null;
        PreparedStatement insertuser = null;
        ResultSet resultSet = null;

        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/BankSystem", "root", "root");
            checkuser = connection.prepareStatement("SELECT * FROM Admin WHERE Username=?");
            checkuser.setString(1, Username);
            resultSet = checkuser.executeQuery();

            if (resultSet.isBeforeFirst()) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("ACCOUNT ALREADY EXISTS");
                alert.show();


            } else {

                insertuser = connection.prepareStatement("INSERT INTO Admin (FullName, Email, Username, Password, Phone) VALUES(?,?,?,?,?)");
                insertuser.setString(1, Fullname);
                insertuser.setString(2, Email);
                insertuser.setString(3, Username);
                insertuser.setString(4,Password);
                insertuser.setInt(5,Phone);
                insertuser.executeUpdate();

                changesceneadmins(event,"AdminPage.fxml");


            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
            if (insertuser != null) {
                try {
                    insertuser.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
            if (checkuser != null) {
                try {
                    checkuser.close();
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


    }

    public static void registercrdb(ActionEvent event, String Firstname, String Middlename,
                                    String Surname, String Email, int Accno, int Cardno,
                                    int pin, String Sex, String Acctype, int phone, String City) {

        Connection connection = null;
        PreparedStatement checkuser = null;
        PreparedStatement insertuser = null;
        ResultSet resultSet = null;

        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/BankSystem", "root", "root");
            checkuser = connection.prepareStatement("SELECT * FROM CRDB WHERE Account_No=?");
            checkuser.setInt(1, Accno);
            resultSet = checkuser.executeQuery();

            if (resultSet.isBeforeFirst()) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("ACCOUNT ALREADY EXISTS");
                alert.show();


            } else {

                insertuser = connection.prepareStatement("INSERT INTO CRDB (Firstname, Middlename, Surname, Email, Account_No, Card_No,Pin, Sex, AccountType, Phone, City) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                insertuser.setString(1, Firstname);
                insertuser.setString(2, Middlename);
                insertuser.setString(3, Surname);
                insertuser.setString(4, Email);
                insertuser.setInt(5, Accno);
                insertuser.setInt(6, Cardno);
                insertuser.setInt(7, pin);
                insertuser.setString(8, Sex);
                insertuser.setString(9, Acctype);
                insertuser.setInt(10, phone);
                insertuser.setString(11, City);
                insertuser.executeUpdate();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("SUCCESSFUL");
                alert.setTitle("REGISTRATION");
                alert.show();
                if (alert.isShowing()) {


                    changescene(event, "CRDB", "LOGIN", "User.fxml");
                }

            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
            if (insertuser != null) {
                try {
                    insertuser.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
            if (checkuser != null) {
                try {
                    checkuser.close();
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


    }

    public static void registernmb(ActionEvent event, String Firstname, String Middlename,
                                   String Surname, String Email, int Accno, int Cardno,
                                   int pin, String Sex, String Acctype, int phone, String City) {

        Connection connection = null;
        PreparedStatement checkuser = null;
        PreparedStatement insertuser = null;
        ResultSet resultSet = null;

        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/BankSystem", "root", "root");
            checkuser = connection.prepareStatement("SELECT * FROM NMB WHERE Account_No=?");
            checkuser.setInt(1, Accno);
            resultSet = checkuser.executeQuery();

            if (resultSet.isBeforeFirst()) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("ACCOUNT ALREADY EXISTS");
                alert.show();


            } else {

                insertuser = connection.prepareStatement("INSERT INTO NMB (Firstname, Middlename, Surname, Email, Account_No, Card_No,Pin, Sex, AccountType, Phone, City) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                insertuser.setString(1, Firstname);
                insertuser.setString(2, Middlename);
                insertuser.setString(3, Surname);
                insertuser.setString(4, Email);
                insertuser.setInt(5, Accno);
                insertuser.setInt(6, Cardno);
                insertuser.setInt(7, pin);
                insertuser.setString(8, Sex);
                insertuser.setString(9, Acctype);
                insertuser.setInt(10, phone);
                insertuser.setString(11, City);
                insertuser.executeUpdate();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("SUCCESSFUL");
                alert.setTitle("REGISTRATION");
                alert.show();
                if (alert.isShowing()) {
                    changescene(event, "NMB", "LOGIN", "User.fxml");
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
            if (insertuser != null) {
                try {
                    insertuser.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
            if (checkuser != null) {
                try {
                    checkuser.close();
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


    }

    public static void registernbc(ActionEvent event, String Firstname, String Middlename,
                                   String Surname, String Email, int Accno, int Cardno,
                                   int pin, String Sex, String Acctype, int phone, String City) {

        Connection connection = null;
        PreparedStatement checkuser = null;
        PreparedStatement insertuser = null;
        ResultSet resultSet = null;

        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/BankSystem", "root", "root");
            checkuser = connection.prepareStatement("SELECT * FROM NBC WHERE Account_No=?");
            checkuser.setInt(1, Accno);
            resultSet = checkuser.executeQuery();

            if (resultSet.isBeforeFirst()) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("ACCOUNT ALREADY EXISTS");
                alert.show();


            } else {

                insertuser = connection.prepareStatement("INSERT INTO NBC (Firstname, Middlename, Surname, Email, Account_No, Card_No, Pin, Sex, AccountType, Phone, City) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                insertuser.setString(1, Firstname);
                insertuser.setString(2, Middlename);
                insertuser.setString(3, Surname);
                insertuser.setString(4, Email);
                insertuser.setInt(5, Accno);
                insertuser.setInt(6, Cardno);
                insertuser.setInt(7, pin);
                insertuser.setString(8, Sex);
                insertuser.setString(9, Acctype);
                insertuser.setInt(10, phone);
                insertuser.setString(11, City);
                insertuser.executeUpdate();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("SUCCESSFUL");
                alert.setTitle("REGISTRATION");
                alert.show();
                if (alert.isShowing()) {
                    changescene(event, "NBC", "LOGIN", "User.fxml");
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
            if (insertuser != null) {
                try {
                    insertuser.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
            if (checkuser != null) {
                try {
                    checkuser.close();
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


    }

    public static  void deposits(ActionEvent event, int amount) {
        AmountDep = amount;

        int Accno = Accounts;
        String Banks = BankName;

        getbalance(Banks,Accno);
        newdepBalance = balance+amount;





        Connection connection = null;
        Statement preparedStatement = null;
        //ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/BankSystem", "root", "root");
           // preparedStatement = connection.prepareStatement("UPDATE "+Banks+" SET Balance="+(balance+ amount)+" WHERE Account_No="+Accno+"");
//            preparedStatement.setInt(1,  balance + amount);
//            preparedStatement.setInt(2,Accno);
           // resultSet = preparedStatement.executeQuery();

            preparedStatement = connection.createStatement();
            preparedStatement.executeUpdate("UPDATE "+Banks+" SET Balance="+newdepBalance+" WHERE Account_No="+Accno+"");


            String date;
            java.util.Date dates = new java.util.Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
           simpleDateFormat.format(dates);
           date = dates.toString();


         //   Connection connection = null;
            PreparedStatement checktransaction = null;
            PreparedStatement inserttransaction = null;
            ResultSet resultSet = null;

            try {

                connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/BankSystem", "root", "root");
                checktransaction = connection.prepareStatement("SELECT * FROM Transactions WHERE Account_No=?");
                checktransaction.setInt(1, Accno);
                resultSet = checktransaction.executeQuery();



                inserttransaction = connection.prepareStatement("INSERT INTO Transactions (Account_No, Bank, Type, Amount, OldBalance, NewBalance, Date) VALUES (?, ?, ?, ?, ?, ?, ?)");
                inserttransaction.setInt(1,Accno);
                inserttransaction.setString(2,BankName);
                inserttransaction.setString(3, "Deposit");
                inserttransaction.setInt(4,amount);
                inserttransaction.setInt(5,balance);
                inserttransaction.setInt(6,newdepBalance);
                inserttransaction.setString(7,dates.toString());
                inserttransaction.executeUpdate();





            }catch (SQLException e){
                e.printStackTrace();
            }finally {
                if (resultSet != null) {
                    try {
                        resultSet.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (inserttransaction != null) {
                    try {
                        inserttransaction.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (checktransaction != null) {
                    try {
                        checktransaction.close();
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

            //REFRESH PAGE
          //  changesceneusers(event, "DEPOSIT","Deposits.fxml");
            refreshpage(event,"DEPOSIT", "Deposits.fxml");

        }catch (SQLException e){
            e.printStackTrace();
        }finally {



//            if (resultSet != null) {
//                try {
//                    resultSet.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }

            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
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

    }

    public static ObservableList<Transactions> depositsRecords() {

 int amount = AmountDep;
        int Accno = Accounts;
        String Banks = BankName;
        String with = "Deposit";

        getbalance(Banks,Accno);





        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        java.util.Date localDate = new java.util.Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        simpleDateFormat.format(localDate);

        ObservableList<Transactions> trans = FXCollections.observableArrayList();

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/BankSystem", "root", "root");
           // preparedStatement = connection.prepareStatement("SELECT Type="+with+" FROM Transactions WHERE Account_No="+Accounts+"");
            preparedStatement = connection.prepareStatement("SELECT * FROM Transactions");
           // preparedStatement.setInt(1,  Accno);
            resultSet = preparedStatement.executeQuery();

//            Transactions transactions = new Transactions()
            Transactions transac;

            while (resultSet.next()) {
               if (resultSet.getInt("Account_No") == Accounts ) {
                   if (resultSet.getString("Type").equals("Deposit")) {
                       if (resultSet.getString("Bank").equals(BankName)){

                       transac = new Transactions(resultSet.getInt("Account_No"), resultSet.getString("Bank"),
                               resultSet.getString("Type"), resultSet.getInt("Amount"),
                               resultSet.getInt("OldBalance"), resultSet.getInt("NewBalance"),
                               resultSet.getString("Date"));

//                transac = new Transactions(Accounts, resultSet.getString("Bank"),
//                        "Deposit", resultSet.getInt("Amount"),
//                        resultSet.getInt("OldBalance"), resultSet.getInt("NewBalance"),
//                        resultSet.getString("Date"));

                       trans.add(transac);
                       }
                   }
               }

            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {



            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
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


        return trans;
    }

    public static void withdraws(ActionEvent event, int amount) {

AmountWith = amount;
        int Accno = Accounts;
        String Banks = BankName;


        getbalance(Banks,Accno);



        newBalance = balance-amount;
        Connection connection = null;
       Statement preparedStatement = null;
//       PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        if (amount <= balance) {

            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/BankSystem", "root", "root");
//                preparedStatement = connection.prepareStatement("UPDATE " + Banks + " SET Balance=? WHERE Account_No=?");
//                preparedStatement.setInt(1, balance - amount);
//                preparedStatement.setInt(2, Accno);
//                resultSet = preparedStatement.executeQuery();


                preparedStatement = connection.createStatement();
                preparedStatement.executeUpdate("UPDATE "+Banks+" SET Balance="+newBalance+" WHERE Account_No="+Accno+"");


                String date;

                java.util.Date dates = new java.util.Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
                simpleDateFormat.format(dates);
                date = dates.toString();


                //int Accno = Accounts;
               // String Banks = BankName;



               // Connection connection = null;
                PreparedStatement checktransaction = null;
                PreparedStatement inserttransaction = null;
                ResultSet resultSet1 = null;

                try {

                    connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/BankSystem", "root", "root");
                    checktransaction = connection.prepareStatement("SELECT * FROM Transactions WHERE Account_No=?");
                    checktransaction.setInt(1, Accno);
                    resultSet1 = checktransaction.executeQuery();



                    inserttransaction = connection.prepareStatement("INSERT INTO Transactions (Account_No, Bank, Type, Amount, OldBalance, NewBalance, Date) VALUES (?, ?, ?, ?, ?, ?, ?)");
                    inserttransaction.setInt(1,Accno);
                    inserttransaction.setString(2,BankName);
                    inserttransaction.setString(3, "Withdraw");
                    inserttransaction.setInt(4,amount);
                    inserttransaction.setInt(5,balance);
                    inserttransaction.setInt(6,newBalance);
                    inserttransaction.setString(7,date);
                    inserttransaction.executeUpdate();





                }catch (SQLException e){
                    e.printStackTrace();
                }finally {
                    if (resultSet != null) {
                        try {
                            resultSet.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                    if (inserttransaction != null) {
                        try {
                            inserttransaction.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                    if (checktransaction != null) {
                        try {
                            checktransaction.close();
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

                    //REFRESH PAGES
                //changesceneusers(event,"WITHDRAW","Withdraws.fxml");
                refreshpage(event,"WITHDRAW", "Withdraws.fxml");
//                transactions(event,"Deposit", amount,balance);


            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (resultSet != null) {
                    try {
                        resultSet.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (preparedStatement != null) {
                    try {
                        preparedStatement.close();
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
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("BALANCE IS NOT SUFFICIENT");
            alert.show();
        }

    }

    public static  ObservableList<Transactions> withdrawsRecords() {

        int amount = AmountWith;
        int Accno = Accounts;
        String Banks = BankName;
        String dep = "Withdraw";

        getbalance(Banks,Accno);


        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        java.util.Date localDate = new java.util.Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        simpleDateFormat.format(localDate);

        ObservableList<Transactions> trans = FXCollections.observableArrayList();

        if (amount <= balance) {

            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/BankSystem", "root", "root");
              //  preparedStatement = connection.prepareStatement("SELECT Type='"+dep+"' FROM Transactions WHERE Account_No="+Accounts+"");
                preparedStatement = connection.prepareStatement("SELECT * FROM Transactions");
               // preparedStatement.setInt(1, Accno);
                resultSet = preparedStatement.executeQuery();

                Transactions transac;

                while(resultSet.next()) {

                    if (resultSet.getInt("Account_No") == Accounts ) {
                        if (resultSet.getString("Type").equals(dep)) {
                            if (resultSet.getString("Bank").equals(BankName)) {

                                transac = new Transactions(resultSet.getInt("Account_No"),
                                        resultSet.getString("Bank"), resultSet.getString("Type"),
                                        resultSet.getInt("Amount"), resultSet.getInt("OldBalance"),
                                        resultSet.getInt("NewBalance"), resultSet.getString("Date"));
                                trans.add(transac);
                            }
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (resultSet != null) {
                    try {
                        resultSet.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (preparedStatement != null) {
                    try {
                        preparedStatement.close();
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
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("BALANCE IS NOT SUFFICIENT");
            alert.show();
        }

        return trans;

    }

    public static void savings(ActionEvent event, int Amount, int Time){

        String date;

        java.util.Date dates = new java.util.Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        simpleDateFormat.format(dates);
        date = dates.toString();



        if (BankName.equals("CRDB")){
            Interest = Amount * Time * 10/100;
        }else if (BankName.equals("NMB")){
            Interest = Amount * Time * 15/100;
        }else if (BankName.equals("NBC")){
            Interest = Amount * Time * 20/100;
        }

        getbalance(BankName,Accounts);

        Connection connection = null;
        PreparedStatement insertsavings = null;
        ResultSet resultSet = null;
        newsaveBalance = balance - Amount;


        try{

            //ENTER DATA TO SAVINGS DATABASE
            connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/BankSystem", "root", "root");
            if (Amount<= balance) {
                insertsavings = connection.prepareStatement("INSERT INTO Savings (Account, Bank, Amount, Time, Interest, Date) VALUES(?, ?, ?, ?, ?, ?)");
                insertsavings.setInt(1, Accounts);
                insertsavings.setString(2, BankName);
                insertsavings.setInt(3, Amount);
                insertsavings.setInt(4, Time);
                insertsavings.setInt(5, Interest);
                insertsavings.setString(6, date);
                insertsavings.executeUpdate();


                PreparedStatement checktransaction = null;
                PreparedStatement inserttransaction = null;
                Statement preparedStatement = null;
                //  ResultSet resultSet1 = null;

                try {

                    connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/BankSystem", "root", "root");
                    checktransaction = connection.prepareStatement("SELECT * FROM Transactions WHERE Account_No=?");
                    checktransaction.setInt(1, Accounts);
                    resultSet = checktransaction.executeQuery();


                    //INSERT SAVINGS INTO TRANSACTIONS RECORDS
                    inserttransaction = connection.prepareStatement("INSERT INTO Transactions (Account_No, Bank, Type, Amount, OldBalance, NewBalance, Date) VALUES (?, ?, ?, ?, ?, ?, ?)");
                    inserttransaction.setInt(1, Accounts);
                    inserttransaction.setString(2, BankName);
                    inserttransaction.setString(3, "Savings");
                    inserttransaction.setInt(4, Amount);
                    inserttransaction.setInt(5, balance);
                    inserttransaction.setInt(6, newsaveBalance);
                    inserttransaction.setString(7, dates.toString());
                    inserttransaction.executeUpdate();

                    //UPDATE BANK DATA
                    preparedStatement = connection.createStatement();
                    preparedStatement.executeUpdate("UPDATE " + BankName + " SET Balance=" + newsaveBalance + " WHERE Account_No=" + Accounts + "");

                    //REFRESH SCENE
//                    changesceneusers(event, "SAVINGS","Savings.fxml");
                    refreshpage(event,"SAVINGS", "Savings.fxml");

                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    if (resultSet != null) {
                        try {
                            resultSet.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                    if (inserttransaction != null) {
                        try {
                            inserttransaction.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                    if (checktransaction != null) {
                        try {
                            checktransaction.close();
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

            }

        }catch (SQLException e){
            e.printStackTrace();
        } finally {
//            if (resultSet != null) {
//                try {
//                    resultSet.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
            if (insertsavings != null) {
                try {
                    insertsavings.close();
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

    }

    public static ObservableList<Transactions> savingsRecords() {

        int amount = AmountDep;
        int Accno = Accounts;
        String Banks = BankName;
        String status = "Savings";

        getbalance(Banks,Accno);





        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        java.util.Date localDate = new java.util.Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        simpleDateFormat.format(localDate);

        ObservableList<Transactions> trans = FXCollections.observableArrayList();

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/BankSystem", "root", "root");
            // preparedStatement = connection.prepareStatement("SELECT Type="+with+" FROM Transactions WHERE Account_No="+Accounts+"");
            preparedStatement = connection.prepareStatement("SELECT * FROM Transactions");
            // preparedStatement.setInt(1,  Accno);
            resultSet = preparedStatement.executeQuery();

//            Transactions transactions = new Transactions()
            Transactions transac;

            while (resultSet.next()) {
                if (resultSet.getInt("Account_No") == Accounts ) {
                    if (resultSet.getString("Type").equals("Savings")) {
                        if (resultSet.getString("Bank").equals(BankName)){

                            transac = new Transactions(resultSet.getInt("Account_No"), resultSet.getString("Bank"),
                                    resultSet.getString("Type"), resultSet.getInt("Amount"),
                                    resultSet.getInt("OldBalance"), resultSet.getInt("NewBalance"),
                                    resultSet.getString("Date"));

//                transac = new Transactions(Accounts, resultSet.getString("Bank"),
//                        "Deposit", resultSet.getInt("Amount"),
//                        resultSet.getInt("OldBalance"), resultSet.getInt("NewBalance"),
//                        resultSet.getString("Date"));

                            trans.add(transac);
                        }
                    }
                }

            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {



            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
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


        return trans;
    }

    private static void getbalance(String Bank,int Accno) {




        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/BankSystem", "root", "root");
            preparedStatement = connection.prepareStatement("SELECT Balance FROM "+Bank+" WHERE Account_No=?");
            preparedStatement.setInt(1, Accno);
            resultSet = preparedStatement.executeQuery();

            if (!resultSet.isBeforeFirst()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Account not found");
                alert.show();
            } else {
                while (resultSet.next()) {

                    balance = resultSet.getInt("Balance");


                }
            }
            } catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
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
    }

    public static void changepin(ActionEvent event, int oldpin, int newpin, int newpin1){

        String Banks = BankName;
        int Accno = Accounts;

        Connection connection = null;
        Statement statement = null;

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/BankSystem", "root", "root");
            statement = connection.createStatement();
            preparedStatement = connection.prepareStatement("SELECT * FROM "+BankName+"");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                int retrivedpin = resultSet.getInt("Pin");

                if (oldpin == retrivedpin) {

                    if (newpin == newpin1) {
                        statement.executeUpdate("UPDATE " + Banks + " SET Pin=" + newpin + " WHERE Account_No=" + Accounts + "");

                        //REFRESH PAGE
                        refreshpage(event,"CHANGE PIN", "Pin.fxml");
                       // changesceneusers(event, "CHANGE PIN","Pin.fxml");

                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("PIN DO NOT MATCH");
                        alert.show();
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("WRONG PIN");
                    alert.show();
                }

                //  preparedStatement = connection.prepareStatement("UPDATE "+Banks+" SET Pin=? WHERE Account_No=?");
                //    preparedStatement.setInt(1, Accno);
                //   resultSet = preparedStatement.executeQuery();
            }

        } catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
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
    }

    public static void transactions(ActionEvent event, String Type, int amount, int balance){
        String date;

        Date dates = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("DD-MM-YYYY");
        date = simpleDateFormat.format(dates);


        int Accno = Accounts;
        String Banks = BankName;



        Connection connection = null;
        PreparedStatement checktransaction = null;
        PreparedStatement inserttransaction = null;
        ResultSet resultSet = null;

        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/BankSystem", "root", "root");
            checktransaction = connection.prepareStatement("SELECT * FROM Transactions WHERE Account_No=?");
            checktransaction.setInt(1, Accno);
            resultSet = checktransaction.executeQuery();



                inserttransaction = connection.prepareStatement("INSERT INTO Transactions (Account_No, Banks, Type, Amount, Balance, Date) VALUES (?, ?, ?, ?, ?)");
                inserttransaction.setInt(1,Accno);
                inserttransaction.setString(2,Banks);
                inserttransaction.setString(3, Type);
                inserttransaction.setInt(4,amount);
                inserttransaction.setInt(5,balance);
                inserttransaction.setString(6,date);
                inserttransaction.executeUpdate();





        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (inserttransaction != null) {
                try {
                    inserttransaction.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (checktransaction != null) {
                try {
                    checktransaction.close();
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



    }

    public static int getAccounts(){

        return Accounts;
    }

    public static int getBalance(){

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/BankSystem", "root", "root");
            preparedStatement = connection.prepareStatement("SELECT Balance FROM "+BankName+" WHERE Account_No=?");
            preparedStatement.setInt(1, Accounts);
            resultSet = preparedStatement.executeQuery();

            if (!resultSet.isBeforeFirst()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Account not found");
                alert.show();
            } else {
                while (resultSet.next()) {

                    balance = resultSet.getInt("Balance");


                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
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

        return balance;
    }


    }




