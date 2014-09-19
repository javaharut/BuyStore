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

public class Main {

    public static List<Products> products = new ArrayList<Products>();

    public static void main(String[] args) throws IOException {
        Store store = new Store();
        store.getProducts();

        for (Products prod : products) {

            System.out.println(prod.getName() + " " + prod.getDescription() + " "+
                    prod.getPrice() + " " + prod.getCount());
        }

    }

}

class Store
{

    ArrayList<String> names = new ArrayList<String>();
    ArrayList<String> descr = new ArrayList<String>();
    ArrayList<Integer> counts = new ArrayList<Integer>();
    ArrayList<Integer> prices = new ArrayList<Integer>();

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

                    Products prod = new Products(String.valueOf(names.get(i)), descr.get(i), prices.get(i), counts.get(i) );
                    Main.products.add(prod);
            }
        }
        catch(Exception ex){
        ex.printStackTrace();
        }
    }


}




