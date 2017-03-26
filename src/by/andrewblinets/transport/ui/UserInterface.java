package by.andrewblinets.transport.ui;

import by.andrewblinets.transport.entity.*;
import by.andrewblinets.transport.ui.main.*;

import java.util.ArrayList;
import java.util.List;

public class UserInterface {

    private List<PassengerTrain> passengerTrains;
    private List<Passenger> passengers;
    private List<Carriage> carriages;
    private List<Luggage> luggages;

    protected List<IteamMenu> iteamsMenu;


    private final String MAINMENU = "\tMenu\n" +
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
        this.iteamsMenu = new ArrayList<>();
        this.iteamsMenu.add(new CreateInformation());
        this.iteamsMenu.add(new EditingOfInformation());
        this.iteamsMenu.add(new ShowInformation());
        this.iteamsMenu.add(new ReadFile());
        this.iteamsMenu.add(new WriteFile());
        this.iteamsMenu.add(new ExitFromMenu());
        passengers = new ArrayList<>();
        passengerTrains = new ArrayList<>();
        carriages = new ArrayList<>();
        luggages = new ArrayList<>();
    }

    public String getMAINMENU() {
        return MAINMENU;
    }

    public List<IteamMenu> getIteamsMenu() {
        return iteamsMenu;
    }

    public void setIteamsMenu(List<IteamMenu> iteamsMenu) {
        this.iteamsMenu = iteamsMenu;
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
