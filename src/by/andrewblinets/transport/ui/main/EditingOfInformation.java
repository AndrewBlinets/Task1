package by.andrewblinets.transport.ui.main;

import by.andrewblinets.transport.ui.ExitFromMenu;
import by.andrewblinets.transport.ui.IteanMenu;
import by.andrewblinets.transport.ui.UserInterface;
import by.andrewblinets.transport.ui.edit.EditingOfCarriage;
import by.andrewblinets.transport.ui.edit.EditingOfLuggage;
import by.andrewblinets.transport.ui.edit.EditingOfPassenger;
import by.andrewblinets.transport.ui.edit.EditingOfTrain;
import by.andrewblinets.transport.ui.util.IteamMenuManagement;

import java.util.ArrayList;

/**
 * Created by Андрей on 21.03.2017.
 */
public class EditingOfInformation extends UserInterface implements IteanMenu {

    private final String EDIT = "\tMenu Edit\n" +
            "1-Edit Train\n" +
            "2-Edit Carriage\n" +
            "3-Edit Passenger\n" +
            "4-Edit Luggage\n" +
            "5-Exit";

    public EditingOfInformation() {
        super();
        this.menu = new ArrayList<>();
        this.menu.add(new EditingOfTrain());
        this.menu.add(new EditingOfCarriage());
        this.menu.add(new EditingOfPassenger());
        this.menu.add(new EditingOfLuggage());
        this.menu.add(new ExitFromMenu());
    }

    @Override
    public boolean MenuIteam(UserInterface userInterface) {
        do {
            System.out.println(EDIT);
        }
        while (IteamMenuManagement.MainMenu(menu,userInterface));
        return true;
    }
}
