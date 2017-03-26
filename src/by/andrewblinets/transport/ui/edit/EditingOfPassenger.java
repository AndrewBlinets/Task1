package by.andrewblinets.transport.ui.edit;

import by.andrewblinets.transport.ui.ExitFromMenu;
import by.andrewblinets.transport.ui.IteamMenu;
import by.andrewblinets.transport.ui.UserInterface;
import by.andrewblinets.transport.ui.edit.passenger.RemovePassenger;
import by.andrewblinets.transport.ui.util.IteamMenuManagement;

import java.util.ArrayList;

public class EditingOfPassenger extends UserInterface implements IteamMenu {

    private final String EDITOFPASSENGER = "\tMenu Edit of Passenger\n" +
            "1-Remove Passenger\n" +
            "3-Back";

    public EditingOfPassenger() {
        super();
        this.iteamsMenu = new ArrayList<>();
        this.iteamsMenu.add(new RemovePassenger());
       // this.iteamsMenu.add(new ChangePassenger());
        this.iteamsMenu.add(new ExitFromMenu());
    }

    @Override
    public boolean MenuIteam(UserInterface userInterface) {
        do {
            System.out.println(EDITOFPASSENGER);
        }
        while (IteamMenuManagement.MainMenu(iteamsMenu,userInterface));
        return true;
    }
}
