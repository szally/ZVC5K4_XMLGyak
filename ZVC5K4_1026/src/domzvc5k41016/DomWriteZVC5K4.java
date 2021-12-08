package domzvc5k41016;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class DomWriteZVC5K4 {
    public static void main(String[] args){
        NodeList list;

        try{

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            //Fálj beolvasása
            Document document = builder.parse(new File("usersZVC5K4.xml"));
            document.getDocumentElement().normalize();
            Element root = document.getDocumentElement();
            System.out.println("Gyökér elem: " + root.getNodeName());
            System.out.println("\n");

            //Elem meghatározása
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
            root.setAttribute("xmlns", "domGXN833");

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            Source input = new DOMSource(document);
            Result output = new StreamResult(new File("users1ZVC5K4.xml"));
            transformer.transform(input, output);

        }catch (ParserConfigurationException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
