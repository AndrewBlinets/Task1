package by.andrewblinets.transport.ui.main;

import by.andrewblinets.transport.ui.ExitFromMenu;
import by.andrewblinets.transport.ui.IteamMenu;
import by.andrewblinets.transport.ui.UserInterface;
import by.andrewblinets.transport.ui.util.IteamMenuManagement;
import by.andrewblinets.transport.ui.write.WriteJsonFile;
import by.andrewblinets.transport.ui.write.WriteTextFile;
import by.andrewblinets.transport.ui.write.WriteXmlFile;

import java.util.ArrayList;

public class WriteFile extends UserInterface implements IteamMenu {
    private final String WRITE = "\tMenu write\n" +
            "1-Write text file\n" +
            "2-Write xml file\n" +
            "3-Write json fiel\n" +
            "4-Back";

    public WriteFile() {
        super();
        this.iteamsMenu = new ArrayList<>();
        this.iteamsMenu.add(new WriteTextFile());
        this.iteamsMenu.add(new WriteXmlFile());
        this.iteamsMenu.add(new WriteJsonFile());
        this.iteamsMenu.add(new ExitFromMenu());
    }

    @Override
    public boolean MenuIteam(UserInterface userInterface) {
        do {
            System.out.println(WRITE);
        }
        while (IteamMenuManagement.MainMenu(iteamsMenu,userInterface));
        return true;
    }
}

