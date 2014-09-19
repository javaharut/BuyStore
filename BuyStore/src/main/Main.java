package main;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {

    List<Products> products = new ArrayList<Products>();


    public static void main(String[] args) {

    HarutReader hr = new HarutReader();

        try {
            hr.getProducts();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}

class Reader
{
    List<ArrayList> all = new ArrayList<ArrayList>();
    ArrayList<String> names = new ArrayList<String>();
    ArrayList<String> descr = new ArrayList<String>();
    ArrayList<Integer> counts = new ArrayList<Integer>();

    public void getProducts()throws IOException{
        try {
            File file = new File("\\products.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nodeLst = doc.getElementsByTagName("product");

            for (int s = 0; s < nodeLst.getLength(); s++) {

                Node fstNode = nodeLst.item(s);

                if (fstNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element fstElmnt = (Element) fstNode;
                    NodeList fstNmElmntLst = fstElmnt.getElementsByTagName("name");

                    Element fstNmElmnt = (Element) fstNmElmntLst.item(0);
                    NodeList fstNm = fstNmElmnt.getChildNodes();
                    names.add(((Node) fstNm.item(0)).getNodeValue());

                    NodeList lstNmElmntLst = fstElmnt.getElementsByTagName("lastname");
                    Element lstNmElmnt = (Element) lstNmElmntLst.item(0);
                    NodeList lstNm = lstNmElmnt.getChildNodes();
                    System.out.println("Last Name : " + ((Node) lstNm.item(0)).getNodeValue());


                }
            }
        }
        catch(Exception ex){

        }
    }



}




