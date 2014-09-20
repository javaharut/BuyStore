package main;

import java.util.ArrayList;

/**
 * Created by USER on 20.09.2014.
 */

public class IOUser{
    private static ArrayList<Products> shopCart = new ArrayList<Products>();
    private static int n;
    public static void hi(){
        System.out.println("Hi, please input your name to register in system!");
    }
    public static void intro(String str){
        System.out.println( str +", here are what you can buy at our online store, input number to buy OR type 'visa' to link your card! ");
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
                    teeemp.setCount(teemp - 1);
                    Store.products.get(index - 1).equals(teeemp);
                    cheked = false;
                    break;

                }
            }

            if(cheked){
                Products temp = new Products(Store.products.get(--index));
                temp.setCount(1);
                shopCart.add(temp);
                Products teeemp = (Store.products.get(index));
                int teemp = teeemp.getCount();
                teeemp.setCount(teemp - 1);
                Store.products.get(index - 1).equals(teeemp);
                cheked =false;
            }

        }
        else {
            Products temp = new Products(Store.products.get(--index));
            temp.setCount(1);
            shopCart.add(temp);
            Products teeemp = (Store.products.get(index));
            int teemp = teeemp.getCount();
            teeemp.setCount(teemp - 1);
            Store.products.get(index - 1).equals(teeemp);
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
            System.out.print("\t\t\t\t\t\t\t\t\t\t\t\tTotal price: "); for(Products prod : shopCart) {tot +=(prod.getPrice()*prod.getCount());}System.out.println(tot);
            System.out.print("\t\t\t\t\t\t\t\t\t\t\t\tYour Balance: ");System.out.println(balanc);
        }
        else System.out.println("Empty ShoppingCard");
    }


    public static void linkVisa(){

    }


}