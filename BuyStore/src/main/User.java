package main;

/**
 * Created by HARUT1 on 9/19/2014.
 */
public class User {

    private String login;
    private String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin(){ return this.login;}
    public String getPassword(){ return this.password;}

    public void setLogin(String login) { this.login = login;}
    public void setPassword(String password) { this.password = password;}

}
