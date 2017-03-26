package by.andrewblinets.transport.ui.edit;

import by.andrewblinets.transport.ui.ExitFromMenu;
import by.andrewblinets.transport.ui.IteamMenu;
import by.andrewblinets.transport.ui.UserInterface;
import by.andrewblinets.transport.ui.edit.train.*;
import by.andrewblinets.transport.ui.util.IteamMenuManagement;

import java.util.ArrayList;

public class EditingOfTrain extends UserInterface implements IteamMenu {

    private final String EDITOFPASSENGER = "\tMenu Edit of Train\n" +
            "1-Remove Train\n" +
            "2-Add carriage\n" +
            "3-Remove carriage\n" +
            "4-Sort Train\n" +
            "5-Back";

    public EditingOfTrain() {
        super();
        this.iteamsMenu = new ArrayList<>();
        this.iteamsMenu.add(new RemoveTrain());
        this.iteamsMenu.add(new AddToTrainCarriage());
        this.iteamsMenu.add(new RemoveFromTrainCarriage());
        //this.iteamsMenu.add(new ChangeTrain());
        this.iteamsMenu.add(new SortTrain());
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
