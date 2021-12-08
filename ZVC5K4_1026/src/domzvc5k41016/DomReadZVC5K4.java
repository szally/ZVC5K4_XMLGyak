package domzvc5k41016;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomReadZVC5K4 {
    public static void main(String[] args){
        NodeList list;

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            //Fálj beolvasása
            Document document = builder.parse(new File("usersZVC5K4.xml"));
            document.getDocumentElement().normalize();
            System.out.println("Gyökér elem: " + document.getDocumentElement().getNodeName());
            System.out.println("\n");

            //Az elem meghatározása
            list = document.getElementsByTagName("user");
            for(int i = 0; i < list.getLength(); i++){
                Node node = list.item(i);
                //Aktuális elem
                System.out.println("Jelenlegi elem " + node.getNodeName());

                //Város adatainak kiíratása
                if (node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;
                    System.out.println("ID: " + element.getAttribute("id"));

                    System.out.println("A felhasználó vezetékneve: " + element.getElementsByTagName("firstname").item(0).getTextContent());
                    System.out.println("A felhasználó keresztneve: " + element.getElementsByTagName("lastname").item(0).getTextContent());
                    System.out.println("A felhasználó foglalkozása: " + element.getElementsByTagName("profession").item(0).getTextContent());
                }
            }













        }catch (ParserConfigurationException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}