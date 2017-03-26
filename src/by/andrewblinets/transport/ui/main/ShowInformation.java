package by.andrewblinets.transport.ui.main;

import by.andrewblinets.transport.ui.ExitFromMenu;
import by.andrewblinets.transport.ui.IteamMenu;
import by.andrewblinets.transport.ui.UserInterface;
import by.andrewblinets.transport.ui.show.ShowCarriage;
import by.andrewblinets.transport.ui.show.ShowLuggage;
import by.andrewblinets.transport.ui.show.ShowPassenger;
import by.andrewblinets.transport.ui.show.ShowTrain;
import by.andrewblinets.transport.ui.util.IteamMenuManagement;

import java.util.ArrayList;

public class ShowInformation extends UserInterface implements IteamMenu {
    private final String SHOW = "\tMenu Show information\n" +
            "1-Show Train\n" +
            "2-Show Carriage\n" +
            "3-Show Passenger\n" +
            "4-Show Luggage\n" +
            "5-Exit";

    public ShowInformation() {
        super();
        this.iteamsMenu = new ArrayList<>();
        this.iteamsMenu.add(new ShowTrain());
        this.iteamsMenu.add(new ShowCarriage());
        this.iteamsMenu.add(new ShowPassenger());
        this.iteamsMenu.add(new ShowLuggage());
        this.iteamsMenu.add(new ExitFromMenu());
    }

    @Override
    public boolean MenuIteam(UserInterface userInterface) {
        do {
            System.out.println(SHOW);
        }
        while (IteamMenuManagement.MainMenu(iteamsMenu,userInterface));
//        iteamsMenu[new KeyboardWork().readInt(SHOW) - 1].MenuIteam(userInterface);
        return true;
    }
}
