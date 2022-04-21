module bank.bank {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens bank.bank to javafx.fxml;
    exports bank.bank;
}