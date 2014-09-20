package main;

import java.nio.file.AccessDeniedException;

/**
 * Created by USER on 19.09.2014.
 */
public class BankAccount {
    private long id = 1111111111;
    private int balance = 300;
    private final int chargepin = 1212;
    private static BankAccount account = new BankAccount() ;

    private BankAccount(){

    }
    public static BankAccount getAccount(){
        if(account == null) {
            account = new BankAccount();
            return account;
        }
        else
            return account;
    }


    public long getID(){
        return id;
    }

    public int getBalance() {
        int temp = this.balance;
        this.balance = 0;
        return temp;
    }
        public void setBalance(long numb, int bal) {
            if (this.id == numb) {
                this.balance -= bal;

            }
            else
                System.out.println("invalid card number..");
        }



    public void chargeAccount(int moneyin, int pin) throws AccessDeniedException {
        if(this.chargepin == pin) this.balance +=moneyin;
        else throw new AccessDeniedException("Sorry, Invalid data..");
    }

}
