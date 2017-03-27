package by.andrewblinets.transport.ui.write;

import by.andrewblinets.transport.entity.Carriage;
import by.andrewblinets.transport.entity.Luggage;
import by.andrewblinets.transport.entity.Passenger;
import by.andrewblinets.transport.entity.PassengerTrain;
import by.andrewblinets.transport.ui.IteamMenu;
import by.andrewblinets.transport.ui.UserInterface;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.nashorn.internal.runtime.JSONListAdapter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class WriteJsonFile implements IteamMenu {

    private JSONObject json;

    public WriteJsonFile() {
        json = new JSONObject();
    }

    @Override
    public boolean MenuIteam(UserInterface userInterface) {
        write(userInterface);
        return true;
    }

    private void write(UserInterface userInterface) {
        JSONObject jsonObject = new JSONObject();
        createLuggages(userInterface.getLuggages(),jsonObject);
        createPassenger(userInterface.getPassengers(),jsonObject);
        createCarriage(userInterface.getCarriages(),jsonObject);
        createTrain(userInterface.getPassengerTrains(),jsonObject);
        try(FileWriter writer = new FileWriter("src\\by\\andrewblinets\\transport\\file\\info.json", false))
        {
            writer.write(new ObjectMapper().writerWithDefaultPrettyPrinter()
                    .writeValueAsString(jsonObject));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createTrain(List<PassengerTrain> passengerTrains, JSONObject jsonObject)
    {
        JSONArray arrayTrains = new JSONArray();
        for (PassengerTrain passengerTrain: passengerTrains) {
            JSONObject objTrain = new JSONObject();
            createIteam(objTrain, String.valueOf(passengerTrain.getId()),"number");
            createIteam(objTrain, passengerTrain.getDeparturePoint(),"DeparturePoint");
            createIteam(objTrain, passengerTrain.getArrivedPoint(),"ArrivedPoint");
            createCarriage(passengerTrain.getCarriages(),objTrain);
            addObject(arrayTrains, objTrain);
        }
        createElement(jsonObject, arrayTrains, "passengertrain");
    }

    private void createCarriage(List<Carriage> carriages, JSONObject jsonObject)
    {
        JSONArray arrayCarriages = new JSONArray();
        for (Carriage carriage: carriages) {
            JSONObject objCarriage = new JSONObject();
            createIteam(objCarriage, String.valueOf(carriage.getId()),"number");
            createIteam(objCarriage, String.valueOf(carriage.getStyle()),"style");
            createPassenger(carriage.getPassengers(),objCarriage);
            addObject(arrayCarriages, objCarriage);
        }
        createElement(jsonObject, arrayCarriages, "carriage");
    }

    private void createIteam(JSONObject jsonObject, String string, String name) {
        jsonObject.put(name, string);
    }

    private void createPassenger(List<Passenger> passengers, JSONObject jsonObject)
    {
        JSONArray arrayPassengers = new JSONArray();
        for (Passenger passenger: passengers) {
            JSONObject objPassenger = new JSONObject();
            createIteam(objPassenger, passenger.getName(),"name");
            createIteam(objPassenger, passenger.getLastName(),"lastname");
            createLuggages(passenger.getLuggages(),objPassenger);
            addObject(arrayPassengers, objPassenger);
        }
        createElement(jsonObject, arrayPassengers, "passanger");
    }

    private void createElement(JSONObject jsonObject, JSONArray jsonArray, String string) {
        jsonObject.put(string, jsonArray);
    }

    private void createLuggages(List<Luggage> luggages, JSONObject jsonObject)
    {
        JSONArray arrayLuggages = new JSONArray();
        for (Luggage luggage: luggages) {
            JSONObject objLuggage = new JSONObject();
            createIteam(objLuggage, luggage.getName(),"name");
            createIteam(objLuggage, String.valueOf(luggage.getWeight()),"weight");
            addObject(arrayLuggages, objLuggage);
        }
        createElement(jsonObject, arrayLuggages, "luggages");
    }

    private void addObject(JSONArray arrayLuggages, JSONObject objLuggage) {
        arrayLuggages.add(objLuggage);
    }
}
