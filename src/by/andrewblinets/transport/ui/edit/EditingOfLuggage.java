package by.andrewblinets.transport.ui.edit;

import by.andrewblinets.transport.ui.ExitFromMenu;
import by.andrewblinets.transport.ui.IteanMenu;
import by.andrewblinets.transport.ui.UserInterface;
import by.andrewblinets.transport.ui.create.CreateCarriage;
import by.andrewblinets.transport.ui.create.CreateLuggage;
import by.andrewblinets.transport.ui.create.CreatePassenger;
import by.andrewblinets.transport.ui.create.CreateTrain;
import by.andrewblinets.transport.ui.edit.luggage.ChangeLuggage;
import by.andrewblinets.transport.ui.edit.luggage.RemoveLuggage;
import by.andrewblinets.transport.ui.util.IteamMenuManagement;

import java.util.ArrayList;

/**
 * Created by Андрей on 21.03.2017.
 */
public class EditingOfLuggage extends UserInterface implements IteanMenu {

    private final String EDITOFLUGGAGE = "\tMenu Edit of luggage\n" +
            "1-Remove luggage\n" +
            "2-Back";

    public EditingOfLuggage() {
        super();
        this.menu = new ArrayList<>();
        this.menu.add(new RemoveLuggage());
       // this.menu.add(new ChangeLuggage());
        this.menu.add(new ExitFromMenu());
    }

    @Override
    public boolean MenuIteam(UserInterface userInterface) {
        do {
            System.out.println(EDITOFLUGGAGE);
        }
        while (IteamMenuManagement.MainMenu(menu,userInterface));
        return true;
    }
}
