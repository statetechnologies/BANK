package bank.bank;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class MinistatementController implements Initializable {


        @FXML
        private Label Account;
        @FXML
        private Button home;
        @FXML
        private Button savings;
        @FXML
        private Button deposits;
        @FXML
        private Button withdraws;
        @FXML
        private TableView<Transactions> Records;

        @FXML
        private TableColumn<Transactions, Integer> account_no;

        @FXML
        private TableColumn<Transactions, Integer> amount_;

        @FXML
        private TableColumn<Transactions, Integer> OldBalance;
        @FXML
        private TableColumn<Transactions, Integer> NewBalance;

        @FXML
        private TableColumn<Transactions, String > bank_;

        @FXML
        private TableColumn<Transactions, String> date_;

        @FXML
        private TableColumn<Transactions, String> type_;

        DBUtils dbUtils;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

//     deposits.setOnAction(event -> {
//         showdeposits();
//     });
//     withdraws.setOnAction(event -> {
//         showwithdraws();
//     });
      //  showdeposits();

//showall();
      //  showall();

        Account.setText("Account: "+ Integer.toString(DBUtils.getAccounts()));

        home.setOnAction(event -> {
            DBUtils.changesceneusers(event,"TRANSACT", "Transact.fxml");
        });


    }

    public ObservableList<Transactions> getdeposits(){

        DBUtils.depositsRecords();

        return DBUtils.depositsRecords();
    }

    public ObservableList<Transactions> getwithdraws(){
        DBUtils.withdrawsRecords();

        return DBUtils.withdrawsRecords();

    }

    public ObservableList<Transactions> getsavings(){

        DBUtils.savingsRecords();

        return DBUtils.savingsRecords();
    }

    public void showdeposits(ActionEvent event){

        ObservableList<Transactions> depositing = getdeposits();
        //ObservableList<Transactions> withdrawing = getwithdraws();

        account_no.setCellValueFactory(new PropertyValueFactory<Transactions, Integer>("AccountNo"));
        bank_.setCellValueFactory(new PropertyValueFactory<Transactions, String >("Bank"));
        type_.setCellValueFactory(new PropertyValueFactory<Transactions, String >("Type"));
        amount_.setCellValueFactory(new PropertyValueFactory<Transactions, Integer>("Amount"));
        OldBalance.setCellValueFactory(new PropertyValueFactory<Transactions, Integer>("OldBalance"));
        NewBalance.setCellValueFactory(new PropertyValueFactory<Transactions, Integer>("NewBalance"));
        date_.setCellValueFactory(new PropertyValueFactory<Transactions, String >("Date"));

        Records.setItems(depositing);
       // Records.setItems(withdrawing);

    }

    public void showwithdraws(ActionEvent event){


        ObservableList<Transactions> withdrawing = getwithdraws();

        account_no.setCellValueFactory(new PropertyValueFactory<Transactions, Integer>("AccountNo"));
        bank_.setCellValueFactory(new PropertyValueFactory<Transactions, String >("Bank"));
        type_.setCellValueFactory(new PropertyValueFactory<Transactions, String >("Type"));
        amount_.setCellValueFactory(new PropertyValueFactory<Transactions, Integer>("Amount"));
        OldBalance.setCellValueFactory(new PropertyValueFactory<Transactions, Integer>("OldBalance"));
        NewBalance.setCellValueFactory(new PropertyValueFactory<Transactions, Integer>("NewBalance"));
        date_.setCellValueFactory(new PropertyValueFactory<Transactions, String >("Date"));

        Records.setItems(withdrawing);

    }

    public void showsavings(ActionEvent event){


        ObservableList<Transactions> saving = getsavings();

        account_no.setCellValueFactory(new PropertyValueFactory<Transactions, Integer>("AccountNo"));
        bank_.setCellValueFactory(new PropertyValueFactory<Transactions, String >("Bank"));
        type_.setCellValueFactory(new PropertyValueFactory<Transactions, String >("Type"));
        amount_.setCellValueFactory(new PropertyValueFactory<Transactions, Integer>("Amount"));
        OldBalance.setCellValueFactory(new PropertyValueFactory<Transactions, Integer>("OldBalance"));
        NewBalance.setCellValueFactory(new PropertyValueFactory<Transactions, Integer>("NewBalance"));
        date_.setCellValueFactory(new PropertyValueFactory<Transactions, String >("Date"));

        Records.setItems(saving);

    }

    public void showall(){
//        showwithdraws();
//        showdeposits();

        ObservableList<Transactions> depositing = getdeposits();
        ObservableList<Transactions> withdrawing = getwithdraws();




        account_no.setCellValueFactory(new PropertyValueFactory<Transactions, Integer>("AccountNo"));
        bank_.setCellValueFactory(new PropertyValueFactory<Transactions, String >("Bank"));
        type_.setCellValueFactory(new PropertyValueFactory<Transactions, String >("Type"));
        amount_.setCellValueFactory(new PropertyValueFactory<Transactions, Integer>("Amount"));
        OldBalance.setCellValueFactory(new PropertyValueFactory<Transactions, Integer>("OldBalance"));
        NewBalance.setCellValueFactory(new PropertyValueFactory<Transactions, Integer>("NewBalance"));
        date_.setCellValueFactory(new PropertyValueFactory<Transactions, String >("Date"));

        Records.setItems(depositing);
         Records.setItems(withdrawing);

    }

}

