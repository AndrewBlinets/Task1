package by.andrewblinets.transport.ui.write;

import by.andrewblinets.transport.entity.Carriage;
import by.andrewblinets.transport.entity.Luggage;
import by.andrewblinets.transport.entity.Passenger;
import by.andrewblinets.transport.entity.PassengerTrain;
import by.andrewblinets.transport.ui.IteamMenu;
import by.andrewblinets.transport.ui.UserInterface;

import java.io.FileWriter;
import java.io.IOException;

public class WriteTextFile implements IteamMenu {
    @Override
    public boolean MenuIteam(UserInterface userInterface) {
        write(userInterface);
        return true;
    }

    private void write(UserInterface userInterface) {
        try(FileWriter writer = new FileWriter("src\\by\\andrewblinets\\transport\\file\\info.txt", false))
        {
            String text = "Luggage:\n";
            for (Luggage obj:userInterface.getLuggages()) {
                text += obj.toString() + "\n";
            }
            text += ": Passenger:\n";
            for (Passenger obj:userInterface.getPassengers()) {
                text += obj.toString() + "\n";
            }
            text += ": Carriage:\n";
            for (Carriage obj:userInterface.getCarriages()) {
                text += obj.toString() + "\n";
            }
            text += ": Train:\n";
            for (PassengerTrain obj:userInterface.getPassengerTrains()) {
                text += obj.toString() + "\n";
            }
            writer.write(text);
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println("The data was successfully saved in a text file");
    }
}
