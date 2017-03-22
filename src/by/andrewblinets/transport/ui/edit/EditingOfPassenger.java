package by.andrewblinets.transport.ui.edit;

import by.andrewblinets.transport.ui.ExitFromMenu;
import by.andrewblinets.transport.ui.IteanMenu;
import by.andrewblinets.transport.ui.UserInterface;
import by.andrewblinets.transport.ui.edit.luggage.ChangeLuggage;
import by.andrewblinets.transport.ui.edit.luggage.RemoveLuggage;
import by.andrewblinets.transport.ui.edit.passenger.ChangePassenger;
import by.andrewblinets.transport.ui.edit.passenger.RemovePassenger;
import by.andrewblinets.transport.ui.util.IteamMenuManagement;

import java.util.ArrayList;

/**
 * Created by Андрей on 21.03.2017.
 */
public class EditingOfPassenger extends UserInterface implements IteanMenu {

    private final String EDITOFPASSENGER = "\tMenu Edit of Passenger\n" +
            "1-Remove Passenger\n" +
            "3-Back";

    public EditingOfPassenger() {
        super();
        this.menu = new ArrayList<>();
        this.menu.add(new RemovePassenger());
       // this.menu.add(new ChangePassenger());
        this.menu.add(new ExitFromMenu());
    }

    @Override
    public boolean MenuIteam(UserInterface userInterface) {
        do {
            System.out.println(EDITOFPASSENGER);
        }
        while (IteamMenuManagement.MainMenu(menu,userInterface));
        return true;
    }
}
