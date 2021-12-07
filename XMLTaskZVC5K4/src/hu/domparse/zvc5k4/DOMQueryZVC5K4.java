package hu.domparse.zvc5k4;

import java.io.File;
import java.lang.reflect.Array;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMQueryZVC5K4 {
    public static void main(String[] args){
        NodeList list;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            //Fálj beolvasása
            Document document = builder.parse(new File("XMLZVC5K4.xml"));
            document.getDocumentElement().normalize();

            //Az XML fálj belolvasása és elemzése után a gyökér elem
            System.out.println("Gyökér elem: " + document.getDocumentElement().getNodeName());
            System.out.println("\n");

            //Első lekérdezés, ahol az állatok adatait írja ki
            System.out.println("Az eltárolt állatok adatai: \n");
            list = document.getElementsByTagName("allat");
            for (int i = 0; i < list.getLength(); i++){
                Node node = list.item(i);
                System.out.println("Jelenleg ennek az elemnek a tulajdonságait lehet látni: " + node.getNodeName());
                if (node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;
                    System.out.println("ID: " + element.getAttribute("id"));
                    System.out.println("A menhely nyilvántartási azonosítója: " + element.getAttribute("nyilvantartasi_azonS"));
                    System.out.println("Az örökbefogadó személyi igazolvány száma: " + element.getAttribute("sz_szam"));

                    System.out.println("Az állat neve: " + element.getElementsByTagName("nev").item(0).getTextContent());
                    System.out.println("Az állat fajtája: " + element.getElementsByTagName("faj").item(0).getTextContent());
                    System.out.println("Az állat kora évben: " + element.getElementsByTagName("eletkor").item(0).getTextContent());
                }
            }
            System.out.println("\n");

            //Második lekérdezés, kilistázza azoknak az örökbefogadónak az adatait, akik házasok
            System.out.println("Házas örökbefogadók: \n");
            list = document.getElementsByTagName("orokbefogado");
            for (int i = 0; i< list.getLength(); i++){
                Node node = list.item(i);

                if(node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;

                    Node node1 = element.getElementsByTagName("csaladi_allapot").item(0);
                    String allapot = node1.getTextContent();

                    if("házas".equals(allapot)){
                        System.out.println("Az örökbefogadó személyi igazolvány száma: " + element.getAttribute("sz_szam"));

                        System.out.println("Az örökbefogdó neve: " + element.getElementsByTagName("nev").item(0).getTextContent());
                        System.out.println("Az örökbefogadó életkora: " + element.getElementsByTagName("kor").item(0).getTextContent());
                        System.out.println("Az örökbefogadó jövedelme: " + element.getElementsByTagName("havi_jovedelem").item(0).getTextContent());
                        System.out.println("Az örökbefogdó családi állapota: " + element.getElementsByTagName("csaladi_allapot").item(0).getTextContent());
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
