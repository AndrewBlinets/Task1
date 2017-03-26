package by.andrewblinets.transport.ui.edit;

import by.andrewblinets.transport.ui.ExitFromMenu;
import by.andrewblinets.transport.ui.IteamMenu;
import by.andrewblinets.transport.ui.UserInterface;
import by.andrewblinets.transport.ui.edit.luggage.RemoveLuggage;
import by.andrewblinets.transport.ui.util.IteamMenuManagement;

import java.util.ArrayList;


public class EditingOfLuggage extends UserInterface implements IteamMenu {

    private final String EDITOFLUGGAGE = "\tMenu Edit of luggage\n" +
            "1-Remove luggage\n" +
            "2-Back";

    public EditingOfLuggage() {
        super();
        this.iteamsMenu = new ArrayList<>();
        this.iteamsMenu.add(new RemoveLuggage());
       // this.iteamsMenu.add(new ChangeLuggage());
        this.iteamsMenu.add(new ExitFromMenu());
    }

    @Override
    public boolean MenuIteam(UserInterface userInterface) {
        do {
            System.out.println(EDITOFLUGGAGE);
        }
        while (IteamMenuManagement.MainMenu(iteamsMenu,userInterface));
        return true;
    }
}
