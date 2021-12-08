package domzvc5k41016;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;

public class DomQueryZVC5K4 {
    public static void main(String[] args){
        NodeList list;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            //Fálj beolvasása
            Document document = builder.parse(new File("carsZVC5K4.xml"));
            document.getDocumentElement().normalize();

            //Az XML fálj belolvasása és elemzése után a gyökér elem
            System.out.println("Gyökér elem: " + document.getDocumentElement().getNodeName());
            System.out.println("\n");

            list = document.getElementsByTagName("supercars");
            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                System.out.println("\nCurrent Element :");
                System.out.print(node.getNodeName());

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.print("company : ");
                    System.out.println(element.getAttribute("company"));
                    NodeList carNameList = element.getElementsByTagName("carname");

                    for (int j = 0; j < carNameList.getLength(); j++) {
                        Node node1 = carNameList.item(j);

                        if (node1.getNodeType() == node1.ELEMENT_NODE) {
                            Element car = (Element) node1;
                            System.out.print("car name : ");
                            System.out.println(car.getTextContent());
                            System.out.print("car type : ");
                            System.out.println(car.getAttribute("type"));
                        }
                    }
                }
            }

        }catch (ParserConfigurationException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
