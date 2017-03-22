package by.andrewblinets.transport.ui.edit;

import by.andrewblinets.transport.ui.ExitFromMenu;
import by.andrewblinets.transport.ui.IteanMenu;
import by.andrewblinets.transport.ui.UserInterface;
import by.andrewblinets.transport.ui.edit.carriage.AddPassengerInCarriage;
import by.andrewblinets.transport.ui.edit.carriage.RemoveCarriage;
import by.andrewblinets.transport.ui.edit.carriage.RemovePassengerInCarriage;
import by.andrewblinets.transport.ui.edit.passenger.RemovePassenger;
import by.andrewblinets.transport.ui.util.IteamMenuManagement;

import java.util.ArrayList;

/**
 * Created by Андрей on 21.03.2017.
 */
public class EditingOfCarriage extends UserInterface implements IteanMenu {

    private final String EDITOFCARRIAGE = "\tMenu Edit of Carriage\n" +
            "1-Remove Carriage\n" +
            "2-Add passenger\n" +
           // "3-Remove passenger\n" +
           // "2-Change Carriage\n" +
            "3-Back";

    public EditingOfCarriage() {
        super();
        this.menu = new ArrayList<>();
        this.menu.add(new RemoveCarriage());
        this.menu.add(new AddPassengerInCarriage());
        //this.menu.add(new RemovePassengerInCarriage());
        //this.menu.add(new ChangeCarriage());
        this.menu.add(new ExitFromMenu());
    }

    @Override
    public boolean MenuIteam(UserInterface userInterface) {
        do {
            System.out.println(EDITOFCARRIAGE);
        }
        while (IteamMenuManagement.MainMenu(menu,userInterface));
        return true;
    }
}
