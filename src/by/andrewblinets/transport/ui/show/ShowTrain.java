package by.andrewblinets.transport.ui.show;

import by.andrewblinets.transport.entity.Passenger;
import by.andrewblinets.transport.entity.PassengerTrain;
import by.andrewblinets.transport.ui.IteanMenu;
import by.andrewblinets.transport.ui.UserInterface;

/**
 * Created by Андрей on 21.03.2017.
 */
public class ShowTrain implements IteanMenu {
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
