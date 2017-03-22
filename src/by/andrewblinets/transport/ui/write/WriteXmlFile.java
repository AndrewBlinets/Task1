package by.andrewblinets.transport.ui.write;

import by.andrewblinets.transport.entity.Carriage;
import by.andrewblinets.transport.entity.Luggage;
import by.andrewblinets.transport.entity.Passenger;
import by.andrewblinets.transport.entity.PassengerTrain;
import by.andrewblinets.transport.ui.IteanMenu;
import by.andrewblinets.transport.ui.UserInterface;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

/**
 * Created by Андрей on 21.03.2017.
 */
public class WriteXmlFile implements IteanMenu {
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
            e.printStackTrace();
        }
        try {
            t.transform(new DOMSource(doc), new StreamResult(new FileOutputStream("src\\by\\andrewblinets\\transport\\file\\info.xml")));
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void createTrain(List<PassengerTrain> passengerTrains, Element element) {
        Element passengerTrainElement = doc.createElement("PassengerTrain");
        for (PassengerTrain passengerTrain: passengerTrains) {
            Element item = (Element) passengerTrainElement.appendChild(doc.createElement("iteam"));
            Element number = (Element) item.appendChild(doc.createElement("number"));
            number.appendChild(doc.createTextNode(String.valueOf(passengerTrain.getId())));
            item.appendChild(number);
            Element departurePoint = (Element) item.appendChild(doc.createElement("DeparturePoint"));
            departurePoint.appendChild(doc.createTextNode(passengerTrain.getDeparturePoint()));
            item.appendChild(departurePoint);
            passengerTrainElement.appendChild(item);
            Element arrivedPoint = (Element) item.appendChild(doc.createElement("ArrivedPoint"));
            arrivedPoint.appendChild(doc.createTextNode(passengerTrain.getArrivedPoint()));
            item.appendChild(arrivedPoint);
            passengerTrainElement.appendChild(item);
            createCarriage(passengerTrain.getCarriages(),passengerTrainElement);
        }
        element.appendChild(passengerTrainElement);
    }

    private void createCarriage(List<Carriage> carriages, Element element) {
        Element carriageElement = doc.createElement("carriage");
        for (Carriage carriage: carriages) {
            Element item = (Element) carriageElement.appendChild(doc.createElement("iteam"));
            Element number = (Element) item.appendChild(doc.createElement("number"));
            number.appendChild(doc.createTextNode(String.valueOf(carriage.getId())));
            item.appendChild(number);
            Element style = (Element) item.appendChild(doc.createElement("style"));
            style.appendChild(doc.createTextNode(String.valueOf(carriage.getStyle())));
            item.appendChild(style);
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
            Element name = (Element) item.appendChild(doc.createElement("name"));
            name.appendChild(doc.createTextNode(luggage.getName()));
            item.appendChild(name);
            Element weight = (Element) item.appendChild(doc.createElement("weight"));
            weight.appendChild(doc.createTextNode(String.valueOf(luggage.getWeight())));
            item.appendChild(weight);
            luggageElement.appendChild(item);
        }
        element.appendChild(luggageElement);
    }

    private void createPassenger(List<Passenger> passengers,Element element)
    {
        Element passengerElement = doc.createElement("passenger");
        for (Passenger passenger: passengers) {
            Element item = (Element) passengerElement.appendChild(doc.createElement("iteam"));
            Element name = (Element) item.appendChild(doc.createElement("name"));
            name.appendChild(doc.createTextNode(passenger.getName()));
            item.appendChild(name);
            Element lastName = (Element) item.appendChild(doc.createElement("lastName"));
            lastName.appendChild(doc.createTextNode(passenger.getLastName()));
            item.appendChild(lastName);
            passengerElement.appendChild(item);
            createLuggages(passenger.getLuggages(),passengerElement);
        }
        element.appendChild(passengerElement);
    }
}
