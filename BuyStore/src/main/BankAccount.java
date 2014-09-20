package main;

/**
 * Created by USER on 19.09.2014.
 */
public class BankAccount {
    private long id = 1111111111;
    private int balance = 300;
    private final int chargepin = 1212;
    private static BankAccount account = null;

    private BankAccount(){
        account = new BankAccount();
    }
    public static BankAccount getAccount(){
        if(account == null) return new BankAccount();
        else return account;
    }


    public long getID(){
        return id;
    }

    public int getBalance(){
        return balance;
    }
    public void chargeAccount(int moneyin, int pin){
        if(this.chargepin == pin) this.balance =moneyin;
        else System.out.println("Sorry, Invalid data..");
    }

}
