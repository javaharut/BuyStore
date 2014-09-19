package main;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HARUT1 on 9/19/2014.
 */
public class HarutReader {

    public HarutReader() {

    }

    public void getProducts() throws Exception {
        //Get the DOM Builder Factory
        DocumentBuilderFactory factory =
                DocumentBuilderFactory.newInstance();

        //Get the DOM Builder
        DocumentBuilder builder = factory.newDocumentBuilder();

        //Load and Parse the XML document
        //document contains the complete XML as a Tree.
        Document document =
                builder.parse(
                        ClassLoader.getSystemResourceAsStream("main/products.xml"));


        List<Products> productsList = new ArrayList<Products>();

        //Iterating through the nodes and extracting the data.
        NodeList nodeList = document.getDocumentElement().getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {

            //We have encountered an <employee> tag.
            org.w3c.dom.Node node = nodeList.item(i);
            if (node instanceof Element) {
                Products product = new Products();
                product.setId(Integer.valueOf(node.getAttributes().
                        getNamedItem("id").getNodeValue()));

                NodeList childNodes = node.getChildNodes();
                for (int j = 0; j < childNodes.getLength(); j++) {
                    Node cNode = (Node) childNodes.item(j);

                    //Identifying the child tag of employee encountered.
                    if (cNode instanceof Element) {
                        String content = cNode.getLastChild().
                                getTextContent().trim();
                        String s = cNode.getNodeName();
                        if (s.equals("name")) {
                            product.setName(content);
                        } else if (s.equals("description")) {
                            product.setDescription(content);

                        } else if (s.equals("count")) {
                            product.setCount(Integer.valueOf(content));

                        } else if (s.equals("price")) {
                            product.setPrice(Integer.valueOf(content));

                        }
                    }
                }
                productsList.add(product);
            }

        }

        //Printing the Employee list populated.
        for (Products pr : productsList) {
            System.out.println(pr);
        }
    }
}

