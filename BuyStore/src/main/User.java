package main;


public class User {

    private String login;
    private String password;
    int balance;

    public User(String login, String password, int balance) {
        this.login = login;
        this.password = password;
        this.balance = balance;
    }

    public String getLogin(){ return this.login;}
    public String getPassword(){ return this.password;}
    public int getBalance(){ return this.balance;}

    public void setLogin(String login) { this.login = login;}
    public void setPassword(String password) { this.password = password;}
    public void setBalance(int balance) {this.balance = balance;}

}
