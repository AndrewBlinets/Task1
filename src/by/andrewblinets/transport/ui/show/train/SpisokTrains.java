package by.andrewblinets.transport.ui.show.train;

import by.andrewblinets.transport.entity.PassengerTrain;
import by.andrewblinets.transport.ui.IteamMenu;
import by.andrewblinets.transport.ui.UserInterface;

public class SpisokTrains implements IteamMenu {
    @Override
    public boolean MenuIteam(UserInterface userInterface) {
        show(userInterface);
        return true;
    }

    public void show(UserInterface userInterface) {
        int number = 1;
        for (PassengerTrain train : userInterface.getPassengerTrains()) {
            System.out.println(number + " - " + train.toString());
            number++;
        }
    }
}
