package by.andrewblinets.transport.ui.main;

import by.andrewblinets.transport.ui.ExitFromMenu;
import by.andrewblinets.transport.ui.IteamMenu;
import by.andrewblinets.transport.ui.UserInterface;
import by.andrewblinets.transport.ui.edit.EditingOfCarriage;
import by.andrewblinets.transport.ui.edit.EditingOfLuggage;
import by.andrewblinets.transport.ui.edit.EditingOfPassenger;
import by.andrewblinets.transport.ui.edit.EditingOfTrain;
import by.andrewblinets.transport.ui.util.IteamMenuManagement;

import java.util.ArrayList;

public class EditingOfInformation extends UserInterface implements IteamMenu {

    private final String EDIT = "\tMenu Edit\n" +
            "1-Edit Train\n" +
            "2-Edit Carriage\n" +
            "3-Edit Passenger\n" +
            "4-Edit Luggage\n" +
            "5-Exit";

    public EditingOfInformation() {
        super();
        this.iteamsMenu = new ArrayList<>();
        this.iteamsMenu.add(new EditingOfTrain());
        this.iteamsMenu.add(new EditingOfCarriage());
        this.iteamsMenu.add(new EditingOfPassenger());
        this.iteamsMenu.add(new EditingOfLuggage());
        this.iteamsMenu.add(new ExitFromMenu());
    }

    @Override
    public boolean MenuIteam(UserInterface userInterface) {
        do {
            System.out.println(EDIT);
        }
        while (IteamMenuManagement.MainMenu(iteamsMenu,userInterface));
        return true;
    }
}
