package by.andrewblinets.transport.ui.show;

import by.andrewblinets.transport.entity.Passenger;
import by.andrewblinets.transport.ui.IteamMenu;
import by.andrewblinets.transport.ui.UserInterface;

public class ShowPassenger implements IteamMenu {
    @Override
    public boolean MenuIteam(UserInterface userInterface) {
       show(userInterface);
        return true;
    }

    public void show(UserInterface userInterface) {
        int number = 1;
        for (Passenger passenger : userInterface.getPassengers()) {
            System.out.println(number + " - " + passenger.toString());
            number++;
        }
    }
}