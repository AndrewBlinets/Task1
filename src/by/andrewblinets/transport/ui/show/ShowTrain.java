package by.andrewblinets.transport.ui.show;

import by.andrewblinets.transport.ui.ExitFromMenu;
import by.andrewblinets.transport.ui.IteanMenu;
import by.andrewblinets.transport.ui.UserInterface;
import by.andrewblinets.transport.ui.show.train.ShowAmountFromTo;
import by.andrewblinets.transport.ui.show.train.ShowStyle;
import by.andrewblinets.transport.ui.show.train.ShowWeightFromTo;
import by.andrewblinets.transport.ui.show.train.SpisokTrains;
import by.andrewblinets.transport.ui.util.IteamMenuManagement;

import java.util.ArrayList;

/**
 * Created by Андрей on 21.03.2017.
 */
public class ShowTrain extends UserInterface implements IteanMenu {
    private final String SHOW = "\tMenu show\n" +
            "1-show all\n" +
            "2-Show Amount from ... to ... \n" +
            "3-Show Weight from ... to ... \n" +
            "4-Show Style \n" +
            "5-Back";

    public ShowTrain() {
        super();
        this.menu = new ArrayList<>();
        this.menu.add(new SpisokTrains());
        this.menu.add(new ShowAmountFromTo());
        this.menu.add(new ShowWeightFromTo());
        this.menu.add(new ShowStyle());
        this.menu.add(new ExitFromMenu());
    }

    @Override
    public boolean MenuIteam(UserInterface userInterface) {
        do {
            System.out.println(SHOW);
        }
        while (IteamMenuManagement.MainMenu(menu,userInterface));
        return true;
    }
}
