package by.nareiko.xml.parser;

import by.nareiko.xml.entity.Paper;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DOMParser {
    public List<? extends Paper> parse(String filePath){
        try {
            long id = 0;
            String title = "";
            String periodical = "";
            boolean isColour = false;
            int volume = 0;
            boolean subscription = false;
            Date publishingDate = null;
            SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");
            File xmlFile = new File(filePath);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);
            Element root = document.getDocumentElement();
            NodeList list = root.getElementsByTagName();


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
