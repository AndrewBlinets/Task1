package by.andrewblinets.transport.ui.show;

import by.andrewblinets.transport.entity.Carriage;
import by.andrewblinets.transport.ui.IteamMenu;
import by.andrewblinets.transport.ui.UserInterface;

public class ShowCarriage implements IteamMenu {
    @Override
    public boolean MenuIteam(UserInterface userInterface) {
        show(userInterface);
        return true;
    }

    public void show(UserInterface userInterface) {
        int number = 1;
        for (Carriage carriage : userInterface.getCarriages()) {
            System.out.println(number + " - " + carriage.toString());
            number++;
        }
    }
}
