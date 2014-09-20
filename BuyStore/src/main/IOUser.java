package main;

import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by USER on 20.09.2014.
 */

public class IOUser{
    private static ArrayList<Products> shopCart = new ArrayList<Products>();
    private static int totalamount;
    public static void hi(){
        System.out.println("Hi, please input your name to register in system!");
    }
    public static void intro(String str){
        System.out.println( str +", here are what you can buy at our  store, for help type 'help' ");
    }

    public static void showProds(){

        System.out.println("-------------------------Products-----------------------------------");
        System.out.println("N\tName\t\t\tDescription\t\t\t\t\t  Quantity\t Price");
        for (Products prod : Store.products) {

            System.out.println(prod.getID()+" "+ prod.getName() + "  " + prod.getDescription() + " \t\t "+
                    prod.getCount() + "   \t  " +prod.getPrice() );
        }
        System.out.println("--------------------------------------------------------------------");
    }


    public static void addToShoppingCart(int index){
        boolean cheked = true;
        if(shopCart.size()>0) {

            for (Products prod : shopCart) {
                cheked =true;
                if (prod.getID() == index) {
                    int temp = prod.getCount();
                    prod.setCount(++temp);
                    Products teeemp = (Store.products.get(--index));
                    int teemp = teeemp.getCount();
                    if((teemp-1>=0)) {
                        teeemp.setCount(teemp - 1);
                        Store.products.get(index - 1).equals(teeemp);
                        cheked = false;
                    }
                    else System.out.println("Sorry product isn't available anymore..");
                    break;

                }
            }

            if(cheked){
                Products temp = new Products(Store.products.get(--index));
                temp.setCount(1);
                shopCart.add(temp);
                Products teeemp = (Store.products.get(index));
                int teemp = teeemp.getCount();
                if((teemp-1>=0)) {
                    teeemp.setCount(teemp - 1);
                    Store.products.get(index - 1).equals(teeemp);
                    cheked = false;
                }
                else System.out.println("Sorry product isn't available anymore..");
            }

        }
        else {
            Products temp = new Products(Store.products.get(--index));
            temp.setCount(1);
            shopCart.add(temp);
            Products teeemp = (Store.products.get(index));
            int teemp = teeemp.getCount();
            if((teemp-1>=0)) {
                teeemp.setCount(teemp - 1);
                Store.products.get(index - 1).equals(teeemp);
            }
            else System.out.println("Sorry product isn't available anymore..");
        }



    }


    public static void showShoppingCard(){
       int tot =0;
        int balanc = User.getUser().getBalance();
        if(shopCart.size()>0) {
            System.out.println("-----------------------------ShoppingCard---------------------------");
            for (Products prod : shopCart) {
                System.out.println(prod.getID() + " " + prod.getName() + "  " + prod.getDescription() + " \t\t " +
                        prod.getCount() + "   \t  " + prod.getPrice() );

            }
            System.out.println("--------------------------------------------------------------------");
            System.out.print("\t\t\t\t\t\t\t\t\t\t\t\tTotal price:      "); for(Products prod : shopCart) {tot +=(prod.getPrice()*prod.getCount()); totalamount =tot;}System.out.println(tot);
            System.out.print("\t\t\t\t\t\t\t\t\t\t\t\tYour Balance:     ");System.out.println(User.getUser().getBalance());
            System.out.print("\t\t\t\t\t\t\t\t\t\t\t\tAfter Purchasing: ");System.out.println(balanc - tot);
        }
        else
        {
            System.out.println("Empty ShoppingCard");
            System.out.print("\t\t\t\t\t\t\t\t\t\t\t\tTotal price:      ");System.out.println(tot);
            System.out.print("\t\t\t\t\t\t\t\t\t\t\t\tYour Balance:     ");System.out.println(User.getUser().getBalance());
            System.out.print("\t\t\t\t\t\t\t\t\t\t\t\tAfter Purchasing: ");System.out.println(balanc - tot);

        }
    }


    public static void linkVisa(){
        int timer =4;
        long visanumb = 0;
        BankAccount myaccount = BankAccount.getAccount();
        System.out.println("Please, enter your Visa card's number:");

        while(--timer>0) {
            Scanner in = new Scanner(System.in);
            try {
                visanumb = Long.valueOf(in.nextLine());
                break;
            }
            catch (Exception ex){
                System.out.println("Invalid input.. tries stays: "+timer);
            }
        }


        while(timer-- >0) {

            if (visanumb-myaccount.getID()==0) {
                int tempbalvis = myaccount.getBalance();
                User.getUser().setBalance(tempbalvis);
                System.out.println("Thank you, your card is verified and balance updated");
                break;
            } else{
                System.out.println("Sorry, we can't verify that account, tries stays: "+timer );
                Scanner in = new Scanner(System.in);
                visanumb = Long.valueOf(in.nextLong());
            }
        }

    }

    public static void chargeVisa(){
        System.out.println("Please enter\n----super PIN  and\n----amount of money\n\t\t\t to get permission for charge:" );
        int timer =3;
        int pintemp=0;
        int moneyin=0;
        BankAccount myaccount = BankAccount.getAccount();
        while(--timer>0) {
            Scanner in = new Scanner(System.in);
            try {
                pintemp = Integer.valueOf(in.nextLine());
                moneyin = Integer.valueOf(in.nextLine());
                myaccount.chargeAccount(moneyin,pintemp);
                System.out.println("Thank you, your charge was successful: ");
                User.getUser().setBalance(moneyin);
                break;
            }
            catch (AccessDeniedException ex){
                System.out.println(ex.toString());
                 in = new Scanner(System.in);

            }
            catch (Exception ex){

                System.out.println("Invalid input.. tries stays: "+timer);
                in = new Scanner(System.in);

            }
        }
    }


    public static void buyShoppingCard(){

        long id = 0;
        if(shopCart.size()>=0 && User.getUser().getBalance()>=totalamount) {

            Scanner in = new Scanner(System.in);
            System.out.println("Please confirm your purchase by entering your registered card number ");


            try{
                id = in.nextLong();
                if(id == BankAccount.getAccount().getID()) {
                    for (Products prod : shopCart) {
                        shopCart.remove(prod);

                    }
                    shopCart.remove(0);
                    User.getUser().doPurchase(totalamount);
                    System.out.println("Congrats..Your purchase is done!!");
                }
                else System.out.println("Sorry wrong identification..");
            }
            catch (Exception ex){
                System.out.println("Sorry wrong identification..try again..");
            }


        }
        else System.out.println("You can't purchase at this time, check your balance and shopping card...");
    }

    public static void userHelpInfo(){
        System.out.println("Type 'visa' to link your visa card\n" +
                "Type 'buy' to buy the content of your shopping card\n" +
                "Type 'charge visa' to upgrade your balance\n" +
                "Type the N number of the product you want, add it to your shooping card\n" +
                "Type 'exit' to live the store with peace\n");

    }

}