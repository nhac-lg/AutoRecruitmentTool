/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import dataobjects.Account;
import dataobjects.Recruiter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Eagle
 */
public class Utils {

    public static Recruiter find(String url_find) {
        for (Recruiter re : Information.lstRecruiter) {
            if (re.getName().equalsIgnoreCase(url_find)) {
                return re;
            }
        }
        return null;
    }

    public static void ReadXML() {
        try {
//            String currentpath = System.getProperty("user.dir");
//            String namefile="sample_config.xml";
//            String config=currentpath+"\\"+namefile;
            String config = "F:\\sample_config1.xml";
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = null;
            try {
                doc = db.parse(config);
            } catch (SAXException ex) {
                Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            }
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("recruiter");
            Information.lstRecruiter = new ArrayList<>();
            for (int itr = 0; itr < nodeList.getLength(); itr++) {
                Node node = nodeList.item(itr);
                //System.out.println("\nNode Name :" + node.getNodeName());
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    String source=eElement.getElementsByTagName("name").item(0).getTextContent();
                    String url = eElement.getElementsByTagName("url").item(0).getTextContent();
                    String acc = eElement.getElementsByTagName("account").item(0).getTextContent();
                    String pass = eElement.getElementsByTagName("password").item(0).getTextContent();
                    Account a = new Account(acc, pass);
                    Recruiter r = new Recruiter(source, url, a);

                    Information.lstRecruiter.add(r);
                }
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
