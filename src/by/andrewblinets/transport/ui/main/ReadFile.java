package by.andrewblinets.transport.ui.main;

import by.andrewblinets.transport.ui.ExitFromMenu;
import by.andrewblinets.transport.ui.IteanMenu;
import by.andrewblinets.transport.ui.UserInterface;
import by.andrewblinets.transport.ui.read.ReadTextFile;
import by.andrewblinets.transport.ui.read.ReadXmlFile;
import by.andrewblinets.transport.ui.util.IteamMenuManagement;

import java.util.ArrayList;

/**
 * Created by Андрей on 21.03.2017.
 */
public class ReadFile extends UserInterface implements IteanMenu {
    private final String READ = "\tMenu Read\n" +
            "1-Read text file\n" +
            "2-Read xml file\n" +
           // "3-Read json fiel\n" +
            "3-Back";

    public ReadFile() {
        super();
        this.menu = new ArrayList<>();
        this.menu.add(new ReadTextFile());
        this.menu.add(new ReadXmlFile());
      //  this.menu.add(new ReadJsonFile());
        this.menu.add(new ExitFromMenu());
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
