package by.andrewblinets.transport.ui.create;

import by.andrewblinets.transport.entity.PassengerTrain;
import by.andrewblinets.transport.ui.IteamMenu;
import by.andrewblinets.transport.ui.UserInterface;
import by.andrewblinets.transport.ui.util.KeyboardWork;

public class CreateTrain implements IteamMenu {

    private KeyboardWork keyboard;

    public CreateTrain() {
        keyboard = new KeyboardWork();
    }

    @Override
    public boolean MenuIteam(UserInterface userInterface) {
        createTrain(userInterface);
        return true;
    }

    private void createTrain(UserInterface userInterface) {
        PassengerTrain passengerTrain;
        if(userInterface.getPassengerTrains().size() != 0)
            passengerTrain = new PassengerTrain(userInterface.getPassengerTrains().
                    get(userInterface.getPassengerTrains().size() - 1).getId() + 1);
        else
            passengerTrain = new PassengerTrain(1);
        passengerTrain.setDeparturePoint(keyboard.readString("Enter the point of departure"));
        passengerTrain.setArrivedPoint(keyboard.readString("Enter the point of arrived"));
        userInterface.getPassengerTrains().add(passengerTrain);
        System.out.println("Passenger Train " + passengerTrain.toString() + " successfully created!");
    }
}
