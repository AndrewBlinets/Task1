package by.andrewblinets.transport.ui.write;

import by.andrewblinets.transport.entity.Carriage;
import by.andrewblinets.transport.entity.Luggage;
import by.andrewblinets.transport.entity.Passenger;
import by.andrewblinets.transport.entity.PassengerTrain;
import by.andrewblinets.transport.ui.IteamMenu;
import by.andrewblinets.transport.ui.UserInterface;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.*;
import java.util.List;

public class WriteXmlFile implements IteamMenu {

    private DocumentBuilder builder;
    private Document doc;

    public WriteXmlFile() {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            builder = factory.newDocumentBuilder(); }
        catch (ParserConfigurationException e) {
            e.printStackTrace(); }
        doc = builder.newDocument();
    }

    @Override
    public boolean MenuIteam(UserInterface userInterface) {
        write(userInterface);
        return true;
    }

    private void write(UserInterface userInterface){
        Element rootElement = doc.createElement("transport");
        createLuggages(userInterface.getLuggages(),rootElement);
        createPassenger(userInterface.getPassengers(),rootElement);
        createCarriage(userInterface.getCarriages(),rootElement);
        createTrain(userInterface.getPassengerTrains(),rootElement);
        doc.appendChild(rootElement);

       /* Transformer t= null;
        try {
            t = TransformerFactory.newInstance().newTransformer();
            t.setOutputProperty(OutputKeys.METHOD, "xml");
            t.setOutputProperty(OutputKeys.INDENT, "yes");
        } catch (TransformerConfigurationException e) {
            System.out.println(e.getMessage());
        }*/
        try(FileWriter writer = new FileWriter("src\\by\\andrewblinets\\transport\\file\\info.xml", false))
        {
            writer.write(toPrettyXmlString(6, doc));
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
       /* try {
            t.transform(new DOMSource(doc), new StreamResult(new FileOutputStream("src\\by\\andrewblinets\\transport\\file\\info.xml")));
        }catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } catch (TransformerException e) {
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }*/
    }

    private void createTrain(List<PassengerTrain> passengerTrains, Element element) {
        Element passengerTrainElement = doc.createElement("PassengerTrain");
        for (PassengerTrain passengerTrain: passengerTrains) {
            Element item = (Element) passengerTrainElement.appendChild(doc.createElement("iteam"));
            createElementXml(item, doc.createElement("number"), doc.createTextNode(String.valueOf(passengerTrain.getId())));
            createElementXml(item, doc.createElement("DeparturePoint"), doc.createTextNode(passengerTrain.getDeparturePoint()));
            passengerTrainElement.appendChild(item);
            createElementXml(item, doc.createElement("ArrivedPoint"), doc.createTextNode(passengerTrain.getArrivedPoint()));
            passengerTrainElement.appendChild(item);
            createCarriage(passengerTrain.getCarriages(),item);
        }
        element.appendChild(passengerTrainElement);
    }

    private void createElementXml(Element item, Element nameElementInXml, Text textNode) {
        Element element = (Element) item.appendChild(nameElementInXml);
        element.appendChild(textNode);
        item.appendChild(element);
    }

    private void createCarriage(List<Carriage> carriages, Element element) {
        Element carriageElement = doc.createElement("carriage");
        for (Carriage carriage: carriages) {
            Element item = (Element) carriageElement.appendChild(doc.createElement("iteam"));
            createElementXml(item, doc.createElement("number"), doc.createTextNode(String.valueOf(carriage.getId())));
            createElementXml(item, doc.createElement("style"), doc.createTextNode(String.valueOf(carriage.getStyle())));
            carriageElement.appendChild(item);
            createPassenger(carriage.getPassengers(),item);
        }
        element.appendChild(carriageElement);
    }

    private void createLuggages(List<Luggage> luggages,Element element)
    {
        Element luggageElement = doc.createElement("luggage");
        for (Luggage luggage: luggages) {
            Element item = (Element) luggageElement.appendChild(doc.createElement("iteam"));
            createElementXml(item, doc.createElement("name"), doc.createTextNode(luggage.getName()));
            createElementXml(item, doc.createElement("weight"), doc.createTextNode(String.valueOf(luggage.getWeight())));
            luggageElement.appendChild(item);
        }
        element.appendChild(luggageElement);
    }

    private void createPassenger(List<Passenger> passengers,Element element)
    {
        Element passengerElement = doc.createElement("passenger");
        for (Passenger passenger: passengers) {
            Element item = (Element) passengerElement.appendChild(doc.createElement("iteam"));
            createElementXml(item, doc.createElement("name"), doc.createTextNode(passenger.getName()));
            createElementXml(item, doc.createElement("lastName"), doc.createTextNode(passenger.getLastName()));
            passengerElement.appendChild(item);
            createLuggages(passenger.getLuggages(),item);
        }
        element.appendChild(passengerElement);
    }

    private String toPrettyXmlString(int indent, Document document) {
        try {
            XPath xPath = XPathFactory.newInstance().newXPath();
            NodeList nodeList = (NodeList) xPath.evaluate(
                    "//text()[normalize-space()='']",
                    document,
                    XPathConstants.NODESET
            );

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                node.getParentNode().removeChild(node);
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            transformerFactory.setAttribute("indent-number", indent);
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            StringWriter stringWriter = new StringWriter();
            transformer.transform(new DOMSource(document), new StreamResult(stringWriter));
            return stringWriter.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
