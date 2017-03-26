package by.andrewblinets.transport.ui.write;

import by.andrewblinets.transport.entity.Carriage;
import by.andrewblinets.transport.entity.Luggage;
import by.andrewblinets.transport.entity.Passenger;
import by.andrewblinets.transport.entity.PassengerTrain;
import by.andrewblinets.transport.ui.IteamMenu;
import by.andrewblinets.transport.ui.UserInterface;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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

    private void write(UserInterface userInterface) {
        Element rootElement = doc.createElement("transport");
        createLuggages(userInterface.getLuggages(),rootElement);
        createPassenger(userInterface.getPassengers(),rootElement);
        createCarriage(userInterface.getCarriages(),rootElement);
        createTrain(userInterface.getPassengerTrains(),rootElement);
        doc.appendChild(rootElement);
        Transformer t= null;
        try {
            t = TransformerFactory.newInstance().newTransformer();
            t.setOutputProperty(OutputKeys.METHOD, "xml");
            t.setOutputProperty(OutputKeys.INDENT, "yes");
        } catch (TransformerConfigurationException e) {
            e.printStackTrace(); //   Change
        }
        try {
            t.transform(new DOMSource(doc), new StreamResult(new FileOutputStream("src\\by\\andrewblinets\\transport\\file\\info.xml")));
        } catch (TransformerException e) {
            e.printStackTrace();//   Change
        } catch (FileNotFoundException e) {
            e.printStackTrace();//   Change
        }
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
            createCarriage(passengerTrain.getCarriages(),passengerTrainElement);
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
            createPassenger(carriage.getPassengers(),carriageElement);
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
            createLuggages(passenger.getLuggages(),passengerElement);
        }
        element.appendChild(passengerElement);
    }
}
