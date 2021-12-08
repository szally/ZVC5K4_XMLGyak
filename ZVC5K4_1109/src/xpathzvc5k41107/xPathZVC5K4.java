package xpathzvc5k41107;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;

public class xPathZVC5K4 {
    public static void main(String[] args) {
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = factory.newDocumentBuilder();

            Document doc = dBuilder.parse("hallgatokZVC5K4.xml");

            doc.getDocumentElement().normalize();

            //Xpath készítése
            XPath xPath= XPathFactory.newInstance().newXPath();

            //Feladatok:
            //String expression="class";
            //1.feladat kiíratása
            //String expression="class/student";
            //2.feladat kiíratása
            //String expression="class/student[1]";
            //3.feladat kiíratása
            //String expression="class/student[1]";
            //4.feladat kiíratása
            //String expression="class/student[position()=2]";
            //5.feladat kiíratása
            //String expression="class/student[last()]";
            //6.feladat kiíratása
            //String expression="class/student[last()-1]";
            //7.feladat kiíratása
            //String expression="class/student[position()<3]";
            //8.feladat kiíratása
            //String expression="class/student";
            //9.feladat kiíratása
            //String expression="class/student[@id]";
            //10.feladat kiíratása
            //String expression="class";
            //11.feladat kiíratása
            //String expression="class/student[kor>20]";
            //12.feladat kiíratása
            String expression="";


            NodeList list=(NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);

            for (int i=0;i<list.getLength();i++){
                Node node=list.item(i);
                System.out.println ("\naktuális elem: " + node.getNodeName());


                if(node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals("student")){
                    Element element =(Element) node;

                    System.out.println ("Hallgató ID: "
                            + element.getAttribute("id"));

                    System.out.println ("Keresztnév: "
                            + element.getElementsByTagName("keresztnév").item(0).getTextContent());

                    System.out.println ("Keresztnév: "
                            + element.getElementsByTagName("vezetéknév").item(0).getTextContent());

                    System.out.println ("Becenév: "
                            + element.getElementsByTagName("becenév").item(0).getTextContent());

                    System.out.println ("Kor: "
                            + element.getElementsByTagName("kor").item(0).getTextContent());
                }
            }
        } catch (ParserConfigurationException | XPathExpressionException | IOException | SAXException e){
            e.printStackTrace();
        }

    }
}
