package by.andrewblinets.transport.ui.edit;

import by.andrewblinets.transport.ui.ExitFromMenu;
import by.andrewblinets.transport.ui.IteanMenu;
import by.andrewblinets.transport.ui.UserInterface;
import by.andrewblinets.transport.ui.edit.train.*;
import by.andrewblinets.transport.ui.util.IteamMenuManagement;

import java.util.ArrayList;

/**
 * Created by Андрей on 21.03.2017.
 */
public class EditingOfTrain extends UserInterface implements IteanMenu {

    private final String EDITOFPASSENGER = "\tMenu Edit of Train\n" +
            "1-Remove Train\n" +
            "2-Add carriage\n" +
            "3-Remove carriage\n" +
            "4-Sort Train\n" +
            "5-Back";

    public EditingOfTrain() {
        super();
        this.menu = new ArrayList<>();
        this.menu.add(new RemoveTrain());
        this.menu.add(new AddToTrainCarriage());
        this.menu.add(new RemoveFromTrainCarriage());
        //this.menu.add(new ChangeTrain());
        this.menu.add(new SortTrain());
        this.menu.add(new ExitFromMenu());
    }

    @Override
    public boolean MenuIteam(UserInterface userInterface) {
        do {
            System.out.println(EDITOFPASSENGER);
        }
        while (IteamMenuManagement.MainMenu(menu,userInterface));
        return true;
    }
}
