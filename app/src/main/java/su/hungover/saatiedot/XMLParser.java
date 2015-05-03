package su.hungover.saatiedot;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


public class XMLParser {


    private String text="",temp="",date="",code="";



    public XMLParser(String URL){

        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = null;
        Document doc = null;

        try {
            docBuilder = docBuilderFactory.newDocumentBuilder();
            doc = docBuilder.parse(URL);
        } catch (Exception e) {}

        doc.getDocumentElement().normalize();

        NodeList nList = doc.getElementsByTagName("yweather:condition");

        for (int tmp = 0; tmp < nList.getLength(); tmp++) {
            Node nNode = nList.item(tmp);
            Element eElement = (Element) nNode;

            text = eElement.getAttribute("text");
            temp = eElement.getAttribute("temp");
            date = eElement.getAttribute("date");
            code = eElement.getAttribute("code");
        }

    }

    public String getText() {
        return text;
    }

    public String getTemp() {
        return temp;
    }

    public String getDate() {
        return date;
    }

    public String getCode() {
        return code;
    }

}
