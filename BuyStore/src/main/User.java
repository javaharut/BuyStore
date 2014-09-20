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
    public static User getUser() {

        return user;
    }

    public String getName(){ return user.name;}
    public int getBalance(){ return user.balance;}
    public void setBalance(int balance) {user.balance += balance;}
    public void doPurchase(int money){user.balance -=money;}

}
