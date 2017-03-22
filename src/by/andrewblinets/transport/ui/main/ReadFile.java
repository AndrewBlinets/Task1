package by.andrewblinets.transport.ui.main;

import by.andrewblinets.transport.ui.ExitFromMenu;
import by.andrewblinets.transport.ui.IteanMenu;
import by.andrewblinets.transport.ui.UserInterface;
import by.andrewblinets.transport.ui.create.CreateCarriage;
import by.andrewblinets.transport.ui.create.CreateLuggage;
import by.andrewblinets.transport.ui.create.CreatePassenger;
import by.andrewblinets.transport.ui.create.CreateTrain;
import by.andrewblinets.transport.ui.read.ReadJsonFile;
import by.andrewblinets.transport.ui.read.ReadTextFile;
import by.andrewblinets.transport.ui.read.ReadXmlFile;
import by.andrewblinets.transport.ui.util.IteamMenuManagement;

/**
 * Created by Андрей on 21.03.2017.
 */
public class ReadFile extends UserInterface implements IteanMenu {
    private final String READ = "\tMenu Read\n" +
            "1-Read text file\n" +
            "2-Read xml file\n" +
            "3-Read json fiel\n" +
            "4-Back";

    public ReadFile() {
        super();
        this.menu = new IteanMenu[5];
        this.menu[0] = new ReadTextFile();
        this.menu[1] = new ReadXmlFile();
        this.menu[2] = new ReadJsonFile();
        this.menu[3] = new ExitFromMenu();
    }

    @Override
    public boolean MenuIteam(UserInterface userInterface) {
        do {
            System.out.println(READ);
        }
        while (IteamMenuManagement.MainMenu(menu,userInterface));
        return true;
    }
}
