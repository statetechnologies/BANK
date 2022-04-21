package bank.bank;

public class Transactions {

    public Transactions(int accountNo, String bank, String type, int amount, int oldBalance, int newBalance, String date) {
        AccountNo = accountNo;
        Bank = bank;
        Type = type;
        Amount = amount;
        OldBalance = oldBalance;
        NewBalance = newBalance;
        Date = date;
    }

    private int AccountNo;
    private String Bank;

    public int getAccountNo() {
        return AccountNo;
    }

    public void setAccountNo(int accountNo) {
        AccountNo = accountNo;
    }

    public String getBank() {
        return Bank;
    }

    public void setBank(String bank) {
        Bank = bank;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public int getOldBalance() {
        return OldBalance;
    }

    public void setOldBalance(int oldBalance) {
        OldBalance = oldBalance;
    }

    public int getNewBalance() {
        return NewBalance;
    }

    public void setNewBalance(int newBalance) {
        NewBalance = newBalance;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    private String Type;
    private int Amount;
    private int OldBalance;
    private int NewBalance;
    private String Date;

}
