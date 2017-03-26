package by.andrewblinets.transport.ui.main;

import by.andrewblinets.transport.ui.ExitFromMenu;
import by.andrewblinets.transport.ui.IteamMenu;
import by.andrewblinets.transport.ui.UserInterface;
import by.andrewblinets.transport.ui.read.ReadTextFile;
import by.andrewblinets.transport.ui.read.ReadXmlFile;
import by.andrewblinets.transport.ui.util.IteamMenuManagement;

import java.util.ArrayList;

public class ReadFile extends UserInterface implements IteamMenu {
    private final String READ = "\tMenu Read\n" +
            "1-Read text file\n" +
            "2-Read xml file\n" +
           // "3-Read json fiel\n" +
            "3-Back";

    public ReadFile() {
        super();
        this.iteamsMenu = new ArrayList<>();
        this.iteamsMenu.add(new ReadTextFile());
        this.iteamsMenu.add(new ReadXmlFile());
      //  this.iteamsMenu.add(new ReadJsonFile());
        this.iteamsMenu.add(new ExitFromMenu());
    }

    @Override
    public boolean MenuIteam(UserInterface userInterface) {
        do {
            System.out.println(READ);
        }
        while (IteamMenuManagement.MainMenu(iteamsMenu,userInterface));
        return true;
    }
}
