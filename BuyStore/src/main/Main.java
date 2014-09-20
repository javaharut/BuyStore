package main;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

public static String chose;

    public static void main(String[] args) throws IOException {
        Store store = new Store();
        store.getProducts();

        IOUser.hi();
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        User.setUser(name);
        IOUser.userHelpInfo();
        IOUser.intro(name);
        IOUser.showProds();

        while(true) {
            in = new Scanner(System.in);
            (chose) = in.nextLine();

            try {

                if (chose.equals("visa")) {
                IOUser.linkVisa();

                }

                else if (chose.equals("buy")){
                    IOUser.buyShoppingCard();

                }
                else if(chose.equals("charge visa")){
                    IOUser.chargeVisa();

                }
                else if(chose.equals("help")){
                    IOUser.userHelpInfo();
                }
                else if (chose.equals("exit")){
                break;
                }
                else if(Integer.parseInt(chose) >0)  {
                    Integer.parseInt(chose);
                    IOUser.addToShoppingCart(Integer.valueOf(chose));
                }


            } catch (Exception ex) {

            }
            IOUser.showProds();
            IOUser.showShoppingCard();

            if(chose.equals("exit")) break;
        }

    }

}





