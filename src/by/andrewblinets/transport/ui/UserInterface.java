package by.andrewblinets.transport.ui;

import by.andrewblinets.transport.entity.*;
import by.andrewblinets.transport.ui.main.*;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Андрей on 20.03.2017.
 */
public class UserInterface {

    private List<PassengerTrain> passengerTrains;
    private List<Passenger> passengers;
    private List<Carriage> carriages;
    private List<Luggage> luggages;

    protected List<IteanMenu> menu;


    private final String MENU = "\tMenu\n" +
            "1-Create information\n" +
            "2-Edit information\n" +
            "3-Show information\n" +
            "4-Read file\n" +
            "5-Write file\n" +
            "6-Exit";

    public UserInterface() {
    }

    public UserInterface(int i) {
        super();
        this.menu = new ArrayList<>();
        this.menu.add(new CreateInformation());
        this.menu.add(new EditingOfInformation());
        this.menu.add(new ShowInformation());
        this.menu.add(new ReadFile());
        this.menu.add(new WriteFile());
        this.menu.add(new ExitFromMenu());
        passengers = new ArrayList<>();
        passengerTrains = new ArrayList<>();
        carriages = new ArrayList<>();
        luggages = new ArrayList<>();
    }

    public String getMENU() {
        return MENU;
    }

    public List<IteanMenu> getMenu() {
        return menu;
    }

    public void setMenu(List<IteanMenu> menu) {
        this.menu = menu;
    }

    public List<PassengerTrain> getPassengerTrains() {
        return passengerTrains;
    }

    public void setPassengerTrains(List<PassengerTrain> passengerTrains) {
        this.passengerTrains = passengerTrains;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public List<Carriage> getCarriages() {
        return carriages;
    }

    public void setCarriages(List<Carriage> carriages) {
        this.carriages = carriages;
    }

    public List<Luggage> getLuggages() {
        return luggages;
    }

    public void setLuggages(List<Luggage> luggages) {
        this.luggages = luggages;
    }
}
