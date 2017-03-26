package by.andrewblinets.transport.ui.edit;

import by.andrewblinets.transport.ui.ExitFromMenu;
import by.andrewblinets.transport.ui.IteamMenu;
import by.andrewblinets.transport.ui.UserInterface;
import by.andrewblinets.transport.ui.edit.carriage.AddPassengerInCarriage;
import by.andrewblinets.transport.ui.edit.carriage.RemoveCarriage;
import by.andrewblinets.transport.ui.util.IteamMenuManagement;

import java.util.ArrayList;

public class EditingOfCarriage extends UserInterface implements IteamMenu {

    private final String EDITOFCARRIAGE = "\tMenu Edit of Carriage\n" +
            "1-Remove Carriage\n" +
            "2-Add passenger\n" +
           // "3-Remove passenger\n" +
           // "2-Change Carriage\n" +
            "3-Back";

    public EditingOfCarriage() {
        super();
        this.iteamsMenu = new ArrayList<>();
        this.iteamsMenu.add(new RemoveCarriage());
        this.iteamsMenu.add(new AddPassengerInCarriage());
        //this.iteamsMenu.add(new RemovePassengerInCarriage());
        //this.iteamsMenu.add(new ChangeCarriage());
        this.iteamsMenu.add(new ExitFromMenu());
    }

    @Override
    public boolean MenuIteam(UserInterface userInterface) {
        do {
            System.out.println(EDITOFCARRIAGE);
        }
        while (IteamMenuManagement.MainMenu(iteamsMenu,userInterface));
        return true;
    }
}
