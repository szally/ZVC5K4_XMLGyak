package hu.domparse.zvc5k4;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMReadZVC5K4 {

    public static void main(String[] args){
        NodeList list;

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("XMLZVC5K4.xml"));
            document.getDocumentElement().normalize();
            System.out.println("Gyökér elem: " + document.getDocumentElement().getNodeName());
            System.out.println("\n");
            list = document.getElementsByTagName("varos");

            for(int i = 0; i < list.getLength(); i++){
                Node node = list.item(i);
                System.out.println("Jelenleg ennek az elemnek a tulajdonságait lehet látni: " + node.getNodeName());

                if (node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;
                    System.out.println("Irányítószám" + element.getAttribute("iranyitoszam"));

                    System.out.println("A város neve: " + element.getElementsByTagName("nev").item(0).getTextContent());
                    System.out.println("A város területe: " + element.getElementsByTagName("terulet").item(0).getTextContent());
                    System.out.println("A város lakossága: " + element.getElementsByTagName("lakossag").item(0).getTextContent());
                }
            }

            list = document.getElementsByTagName("menhely");
            for(int i = 0; i < list.getLength(); i++){
                Node node = list.item(i);
                System.out.println("Jelenleg ennek az elemnek a tulajdonságait lehet látni: " + node.getNodeName());

                if (node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;
                    System.out.println("Menhely nyilvántartási azonosítója: " + element.getAttribute("nyilvantart_azon"));

                    System.out.println("A menhely neve: " + element.getElementsByTagName("nev").item(0).getTextContent());
                    System.out.println("A menhely kapacitása: " + element.getElementsByTagName("kapacitas").item(0).getTextContent());

                    Node lakcim = list.item(i);
                    if(lakcim.getNodeType() == Node.ELEMENT_NODE){
                        Element lakcimElement = (Element) node;

                        System.out.println("A menhely címe: ");

                        System.out.println("Utca: " + lakcimElement.getElementsByTagName("utca").item(0).getTextContent());
                        System.out.println("Hászám: " + lakcimElement.getElementsByTagName("hazszam").item(0).getTextContent());
                    }
                }
            }
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


            list = document.getElementsByTagName("betegseg");
            for (int i = 0; i < list.getLength(); i++){
                Node node = list.item(i);
                System.out.println("Jelenleg ennek az elemnek a tulajdonságait lehet látni: " + node.getNodeName());
                if (node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;
                    System.out.println("A betegség latin neve: " + element.getAttribute("latin_nev"));
                    System.out.println("Annak az állatnak az id-je amelyik rendelkezik ezzel a betegséggel: " + element.getAttribute("id"));

                    System.out.println("A betegség neve: " + element.getElementsByTagName("nev").item(0).getTextContent());
                    System.out.println("A betegség gyógyítási módja: " + element.getElementsByTagName("gyogyitas_modja").item(0).getTextContent());
                    System.out.println("A betegség gyógyulási ideje napban megadva: " + element.getElementsByTagName("gyogyulasi_ido").item(0).getTextContent());
                }
            }

            list = document.getElementsByTagName("rendelkezik");
            for (int i = 0; i < list.getLength(); i++){
                Node node = list.item(i);
                System.out.println("Jelenleg ennek az elemnek a tulajdonságait lehet látni: " + node.getNodeName());
                if (node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;
                    System.out.println("Az állat, amely betegséggel rendelkezik: " + element.getAttribute("id"));
                    System.out.println("A betegség latin neve: " + element.getAttribute("latin_nev"));

                    System.out.println("A betegségek mennyisége, amellyel a megadott állat rendelkezik: " + element.getElementsByTagName("mennyiseg").item(0).getTextContent());
                }
            }

            list = document.getElementsByTagName("tunet");
            for (int i = 0; i < list.getLength(); i++){
                Node node = list.item(i);
                System.out.println("Jelenleg ennek az elemnek a tulajdonságait lehet látni: " + node.getNodeName());
                if (node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;
                    System.out.println("A betegség latin neve, amelyhez a tünet tartozik: " + element.getAttribute("latin_nev"));

                    System.out.println("A tünet neve: " + element.getElementsByTagName("tunet_neve").item(0).getTextContent());
                }
            }

            list = document.getElementsByTagName("orokbefogado");
            for (int i = 0; i < list.getLength(); i++){
                Node node = list.item(i);
                System.out.println("Jelenleg ennek az elemnek a tulajdonságait lehet látni: " + node.getNodeName());
                if (node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;
                    System.out.println("Az örökbefogadó személyi igazolvány száma: " + element.getAttribute("sz_szam"));

                    System.out.println("Az örökbefogdó neve: " + element.getElementsByTagName("nev").item(0).getTextContent());
                    System.out.println("Az örökbefogadó életkora: " + element.getElementsByTagName("kor").item(0).getTextContent());
                    System.out.println("Az örökbefogadó jövedelme: " + element.getElementsByTagName("havi_jovedelem").item(0).getTextContent());
                    System.out.println("Az örökbefogdó családi állapota: " + element.getElementsByTagName("csaladi_allapot").item(0).getTextContent());
                }
            }

        }catch (ParserConfigurationException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
