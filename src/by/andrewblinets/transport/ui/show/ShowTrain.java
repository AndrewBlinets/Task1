package by.andrewblinets.transport.ui.show;

import by.andrewblinets.transport.ui.ExitFromMenu;
import by.andrewblinets.transport.ui.IteamMenu;
import by.andrewblinets.transport.ui.UserInterface;
import by.andrewblinets.transport.ui.show.train.ShowAmountFromTo;
import by.andrewblinets.transport.ui.show.train.ShowStyle;
import by.andrewblinets.transport.ui.show.train.ShowWeightFromTo;
import by.andrewblinets.transport.ui.show.train.SpisokTrains;
import by.andrewblinets.transport.ui.util.IteamMenuManagement;

import java.util.ArrayList;

public class ShowTrain extends UserInterface implements IteamMenu {
    private final String SHOW = "\tMenu show\n" +
            "1-show all\n" +
            "2-Show Amount from ... to ... \n" +
            "3-Show Weight from ... to ... \n" +
            "4-Show Style \n" +
            "5-Back";

    public ShowTrain() {
        super();
        this.iteamsMenu = new ArrayList<>();
        this.iteamsMenu.add(new SpisokTrains());
        this.iteamsMenu.add(new ShowAmountFromTo());
        this.iteamsMenu.add(new ShowWeightFromTo());
        this.iteamsMenu.add(new ShowStyle());
        this.iteamsMenu.add(new ExitFromMenu());
    }

    @Override
    public boolean MenuIteam(UserInterface userInterface) {
        do {
            System.out.println(SHOW);
        }
        while (IteamMenuManagement.MainMenu(iteamsMenu,userInterface));
        return true;
    }
}
