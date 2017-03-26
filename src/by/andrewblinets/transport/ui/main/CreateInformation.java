package by.andrewblinets.transport.ui.main;

import by.andrewblinets.transport.ui.ExitFromMenu;
import by.andrewblinets.transport.ui.IteamMenu;
import by.andrewblinets.transport.ui.UserInterface;
import by.andrewblinets.transport.ui.create.CreateCarriage;
import by.andrewblinets.transport.ui.create.CreateLuggage;
import by.andrewblinets.transport.ui.create.CreatePassenger;
import by.andrewblinets.transport.ui.create.CreateTrain;
import by.andrewblinets.transport.ui.util.IteamMenuManagement;

import java.util.ArrayList;

public class CreateInformation extends UserInterface  implements IteamMenu {

    private final String CREATE = "\tMenu Create\n" +
            "1-Create Train\n" +
            "2-Create Carriage\n" +
            "3-Create Passenger\n" +
            "4-Create Luggage\n" +
            "5-Back";

    public CreateInformation() {
        super();
        this.iteamsMenu = new ArrayList<>();
        this.iteamsMenu.add(new CreateTrain());
        this.iteamsMenu.add(new CreateCarriage());
        this.iteamsMenu.add(new CreatePassenger());
        this.iteamsMenu.add(new CreateLuggage());
        this.iteamsMenu.add(new ExitFromMenu());
    }

    @Override
    public boolean MenuIteam(UserInterface userInterface) {
        do {
            System.out.println(CREATE);
        }
        while (IteamMenuManagement.MainMenu(iteamsMenu,userInterface));
        return true;
    }
}
