package by.andrewblinets.transport.ui.main;

import by.andrewblinets.transport.ui.ExitFromMenu;
import by.andrewblinets.transport.ui.IteanMenu;
import by.andrewblinets.transport.ui.UserInterface;
import by.andrewblinets.transport.ui.show.ShowCarriage;
import by.andrewblinets.transport.ui.show.ShowLuggage;
import by.andrewblinets.transport.ui.show.ShowPassenger;
import by.andrewblinets.transport.ui.show.ShowTrain;
import by.andrewblinets.transport.ui.util.IteamMenuManagement;
import by.andrewblinets.transport.ui.util.KeyboardWork;

/**
 * Created by Андрей on 21.03.2017.
 */
public class ShowInformation extends UserInterface implements IteanMenu {
    private final String SHOW = "\tMenu Show information\n" +
            "1-Show Train\n" +
            "2-Show Carriage\n" +
            "3-Show Passenger\n" +
            "4-Show Luggage\n" +
            "5-Exit";

    public ShowInformation() {
        super();
        this.menu = new IteanMenu[5];
        this.menu[0] = new ShowTrain();
        this.menu[1] = new ShowCarriage();
        this.menu[2] = new ShowPassenger();
        this.menu[3] = new ShowLuggage();
        this.menu[4] = new ExitFromMenu();
    }

    @Override
    public boolean MenuIteam(UserInterface userInterface) {
        do {
            System.out.println(SHOW);
        }
        while (IteamMenuManagement.MainMenu(menu,userInterface));
//        menu[new KeyboardWork().readInt(SHOW) - 1].MenuIteam(userInterface);
        return true;
    }
}
