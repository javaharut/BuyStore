package main;

public class User {

    private String name;
    private int balance;
    private static User user = null;

       private User(String name){
           this.balance = 0;
            this.name=name;

    }

    public static User setUser(String name){

        if(user==null) {
            user = new User(name);
        }
        return user;
    }
    public static User getUser() throws NullPointerException{

        return user;
    }

    public String getName(){ return this.name;}
    public int getBalance(){ return this.balance;}
    public void setBalance(int balance) {this.balance = balance;}

}
