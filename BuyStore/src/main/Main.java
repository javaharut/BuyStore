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
        IOUser.intro(name);
        IOUser.showProds();

        while(true) {
            try {
                in = new Scanner(System.in);
                (chose) = in.nextLine();

                if (chose.equals("visa")) {

                } else {
                    Integer.parseInt(chose);
                    IOUser.addToShoppingCart(Integer.valueOf(chose));
                }

            } catch (Exception ex) {

            }
            IOUser.showShoppingCard();
            IOUser.showProds();
            if(!in.hasNext()) break;
        }

    }

}

  class IOUser{
    private static ArrayList<Products>  shopCart = new ArrayList<Products>();
    private static int n;
    public static void hi(){
        System.out.println("Hi, please input your name to register in system!");
    }
      public static void intro(String str){
          System.out.println( str +", here are what you can buy at our online store, input number to buy OR type 'visa' to link your card! ");
      }

      public static void showProds(){

          System.out.println("--------------------------------------------------------------------");
          System.out.println("N\tName\t\t\tDescription\t\t\t\t\t  Quantity\t Price");
          for (Products prod : Store.products) {

              System.out.println(prod.getID()+" "+ prod.getName() + "  " + prod.getDescription() + " \t\t "+
                      prod.getCount() + "   \t  " +prod.getPrice() );
          }
          System.out.println("--------------------------------------------------------------------");
      }


      public static void addToShoppingCart(int index){
          if(shopCart.size()>0) {
              for (Products prod : shopCart) {

                      if (prod.getID() == --index) {
                          int temp = prod.getCount();
                          prod.setCount(++temp);
                          Products teeemp =(Store.products.get(index));
                          int teemp =teeemp.getCount();
                          teeemp.setCount(teemp-1);
                          Store.products.get(index-1).equals( teeemp);
                          break;

                      }

                       else {
                          Products temp = new Products(Store.products.get(--index));
                          temp.setCount(1);
                          shopCart.add(temp);
                          Products teeemp =(Store.products.get(index));
                          int teemp =teeemp.getCount();
                          teeemp.setCount(teemp-1);
                          Store.products.get(index-1).equals( teeemp);
                          break;
                      }

              }
          }
          else{

                  Products temp = new Products (Store.products.get(--index));
                  temp.setCount(1);
                  shopCart.add(temp);
                  Products teeemp =(Store.products.get(index));
                  int teemp =teeemp.getCount();
                  teeemp.setCount(teemp-1);
                  Store.products.get(index-1).equals( teeemp);


          }


      }

      public static void showShoppingCard(){

          if(shopCart.size()>0) {
              System.out.println("--------------------------------------------------------------------");
              for (Products prod : shopCart) {
                  System.out.println(prod.getID() + " " + prod.getName() + "  " + prod.getDescription() + " \t\t " +
                          prod.getCount() + "   \t  " + prod.getPrice() );

              }
              System.out.println("--------------------------------------------------------------------");
          }
          else System.out.println("Empty");
      }


}



class Store
{
    public static List<Products> products = new ArrayList<Products>();
    private ArrayList<String> names = new ArrayList<String>();
    private ArrayList<String> descr = new ArrayList<String>();
    private ArrayList<Integer> counts = new ArrayList<Integer>();
    private ArrayList<Integer> prices = new ArrayList<Integer>();

    public void getProducts()throws IOException{
        try {
            File file = new File("BuyStore/src/main/products.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nodeLst = doc.getElementsByTagName("product");

            for (int s = 0; s < nodeLst.getLength(); s++) {

                Node fstNode = nodeLst.item(s);

                if (fstNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element fstElmnt = (Element) fstNode;

                    NodeList namelist = fstElmnt.getElementsByTagName("name");
                    Element nameelem = (Element) namelist.item(0);
                    NodeList nm = nameelem.getChildNodes();
                    names.add(((Node) nm.item(0)).getNodeValue());

                    NodeList desclist = fstElmnt.getElementsByTagName("description");
                    Element descelem = (Element) desclist.item(0);
                    NodeList dsc = descelem.getChildNodes();
                     descr.add(((Node) dsc.item(0)).getNodeValue());

                    NodeList countlist = fstElmnt.getElementsByTagName("count");
                    Element countls = (Element) countlist.item(0);
                    NodeList cnt = countls.getChildNodes();
                    counts.add(Integer.valueOf(((Node) cnt.item(0)).getNodeValue()));

                    NodeList pricelist = fstElmnt.getElementsByTagName("price");
                    Element pricelst = (Element) pricelist.item(0);
                    NodeList prc = pricelst.getChildNodes();
                    prices.add( Integer.valueOf(((Node) prc.item(0)).getNodeValue()));

                }

            }


            for (int i =0; i < names.size(); i++) {

                    Products prod = new Products(names.get(i), descr.get(i), counts.get(i),prices.get(i));
                    products.add(prod);
            }
        }
        catch(Exception ex){
        ex.printStackTrace();
        }
    }


}




