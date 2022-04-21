package bank.bank;

public class Admins {

    public Admins(String fullname, String email, String username, String password, int phone) {
        Fullname = fullname;
        Email = email;
        Username = username;
        Password = password;
        Phone = phone;
    }

    private String  Fullname;
    private String Email;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    private String Username;

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String fullname) {
        Fullname = fullname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getPhone() {
        return Phone;
    }

    public void setPhone(int phone) {
        Phone = phone;
    }

    private String Password;
    private int Phone;


}
