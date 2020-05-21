package by.nareiko.xml.parser;

import by.nareiko.xml.entity.Paper;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class Analyzer {
    public List<? extends Paper> buildList(Element root){
        List<Paper> papers= new ArrayList<>();
        NodeList papersNodes = root.getElementsByTagName("papers");
        Paper paper = null;
        for (int i = 0; i < papersNodes.getLength(); i++) {
            Node node = papersNodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE){
               Element element = (Element) node;
                "Author: " + element.getElementsByTagName("author").item(0).
                        getChildNodes().item(0).getNodeValue());
            }

        }
        return papers;
    }

    private static Element getBabyElement(Element parent, String chidName){
    NodeList nodeList = parent.getElementsByTagName(chidName);
    Element child = (Element) nodeList.item(0);
    return child;
    }
    private  static String geBabyValue(Element parent, String chidName){
        Element child = getBabyElement(parent, chidName);
        Node node = child.getFirstChild();
        String childValue = node.getNodeValue();
        return childValue;
    }
}
