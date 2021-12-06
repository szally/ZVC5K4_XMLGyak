package hu.domparse.zvc5k4;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMModifyZVC5K4 {

    public static void main(String[] args){
        NodeList list;

        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("XMLZVC5K4.xml"));
            document.getDocumentElement().normalize();
            list = document.getElementsByTagName("betegseg");

            for(int i = 0; i < list.getLength(); i++){
                Node node = list.item(i);
                System.out.println("Jelenleg ennek az elemnek a tulajdonságait lehet látni: " + node.getNodeName());
                if (node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;

                    String latin_nev = element.getAttribute("latin_nev");

                    System.out.println("A betegség latin neve: " + element.getAttribute("latin_nev"));
                    System.out.println("Annak az állatnak az id-je amelyik rendelkezik ezzel a betegséggel: " + element.getAttribute("id"));

                    System.out.println("A betegség neve: " + element.getElementsByTagName("nev").item(0).getTextContent());
                    System.out.println("A betegség gyógyítási módja: " + element.getElementsByTagName("gyogyitas_modja").item(0).getTextContent());

                    if(latin_nev.equals("myxomatosis")){
                        element.getElementsByTagName("gyogyulasi_ido").item(0).setTextContent("20");
                    }

                    System.out.println("A betegség gyógyulási ideje napban megadva: " + element.getElementsByTagName("gyogyulasi_ido").item(0).getTextContent());
                }
            }

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            Source input = new DOMSource(document);
            Result output = new StreamResult(new File("XMLZVC5K4Modify.xml"));
            transformer.transform(input, output);

        }catch (ParserConfigurationException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
