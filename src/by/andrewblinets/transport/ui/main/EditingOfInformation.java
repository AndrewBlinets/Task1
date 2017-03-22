package by.andrewblinets.transport.ui.main;

import by.andrewblinets.transport.ui.ExitFromMenu;
import by.andrewblinets.transport.ui.IteanMenu;
import by.andrewblinets.transport.ui.UserInterface;
import by.andrewblinets.transport.ui.edit.EditingOfCarriage;
import by.andrewblinets.transport.ui.edit.EditingOfLuggage;
import by.andrewblinets.transport.ui.edit.EditingOfPassenger;
import by.andrewblinets.transport.ui.edit.EditingOfTrain;
import by.andrewblinets.transport.ui.util.IteamMenuManagement;

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
        this.menu = new IteanMenu[5];
        this.menu[0] = new EditingOfTrain();
        this.menu[1] = new EditingOfCarriage();
        this.menu[2] = new EditingOfPassenger();
        this.menu[3] = new EditingOfLuggage();
        this.menu[4] = new ExitFromMenu();
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
