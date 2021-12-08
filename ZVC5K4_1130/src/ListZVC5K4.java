import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ListZVC5K4 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        //XML Fájl meghívása.
        File xmlFile = new File("JSONZVC5K4.xml");

        //Dokument builder.
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        //XML Fájl betöltése a dBuilderbe.
        Document document = builder.parse(xmlFile);
        document.getDocumentElement().normalize();

        JSONObject obj = new JSONObject();

        JSONArray list = new JSONArray();

        NodeList studentList = document.getElementsByTagName("students");
        for(int i=0; i<studentList.getLength(); i++) {
            Node nNode = studentList.item(i);
            Element elem = (Element) nNode;

            Node nNode1 = elem.getElementsByTagName("nev").item(0);
            list.add(nNode1.getTextContent());

            Node nNode2 = elem.getElementsByTagName("fizetes").item(0);
            list.add(nNode2.getTextContent());

            Node nNode3 = elem.getElementsByTagName("kor").item(0);
            list.add(nNode3.getTextContent());
        }

        obj.put("Kimenet", list);

        System.out.print(obj);

    }
}

