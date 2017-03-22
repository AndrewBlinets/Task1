package by.andrewblinets.transport.ui.main;

import by.andrewblinets.transport.ui.ExitFromMenu;
import by.andrewblinets.transport.ui.IteanMenu;
import by.andrewblinets.transport.ui.UserInterface;
import by.andrewblinets.transport.ui.create.CreateCarriage;
import by.andrewblinets.transport.ui.create.CreateLuggage;
import by.andrewblinets.transport.ui.create.CreatePassenger;
import by.andrewblinets.transport.ui.create.CreateTrain;
import by.andrewblinets.transport.ui.util.IteamMenuManagement;

/**
 * Created by Андрей on 21.03.2017.
 */
public class CreateInformation extends UserInterface  implements IteanMenu {

    private final String CREATE = "\tMenu Create\n" +
            "1-Create Train\n" +
            "2-Create Carriage\n" +
            "3-Create Passenger\n" +
            "4-Create Luggage\n" +
            "5-Back";

    public CreateInformation() {
        super();
        this.menu = new IteanMenu[5];
        this.menu[0] = new CreateTrain();
        this.menu[1] = new CreateCarriage();
        this.menu[2] = new CreatePassenger();
        this.menu[3] = new CreateLuggage();
        this.menu[4] = new ExitFromMenu();
    }

    @Override
    public boolean MenuIteam(UserInterface userInterface) {
        do {
            System.out.println(CREATE);
        }
        while (IteamMenuManagement.MainMenu(menu,userInterface));
        return true;
    }
}
