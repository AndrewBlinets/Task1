package by.andrewblinets.transport.ui.show;

import by.andrewblinets.transport.entity.Luggage;
import by.andrewblinets.transport.ui.IteanMenu;
import by.andrewblinets.transport.ui.UserInterface;

/**
 * Created by Андрей on 21.03.2017.
 */
public class ShowLuggage implements IteanMenu {
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
