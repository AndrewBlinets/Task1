package by.andrewblinets.transport.ui.show;

import by.andrewblinets.transport.entity.Luggage;
import by.andrewblinets.transport.ui.IteamMenu;
import by.andrewblinets.transport.ui.UserInterface;

public class ShowLuggage implements IteamMenu {
    @Override
    public boolean MenuIteam(UserInterface userInterface) {
        show(userInterface);
        return true;
    }

    public void show (UserInterface userInterface)
    {
        int number = 1;
        for (Luggage luggage: userInterface.getLuggages()) {
            System.out.println(number + " - " + luggage.toString());
            number++;
        }
    }
}
