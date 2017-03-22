package by.andrewblinets.transport.ui.write;

import by.andrewblinets.transport.entity.Carriage;
import by.andrewblinets.transport.entity.Luggage;
import by.andrewblinets.transport.entity.Passenger;
import by.andrewblinets.transport.entity.PassengerTrain;
import by.andrewblinets.transport.ui.IteanMenu;
import by.andrewblinets.transport.ui.UserInterface;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Андрей on 21.03.2017.
 */
public class WriteTextFile implements IteanMenu {
    @Override
    public boolean MenuIteam(UserInterface userInterface) {
        return true;
    }
}
