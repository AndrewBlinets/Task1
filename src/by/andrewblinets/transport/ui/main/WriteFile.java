package by.andrewblinets.transport.ui.main;

import by.andrewblinets.transport.ui.ExitFromMenu;
import by.andrewblinets.transport.ui.IteanMenu;
import by.andrewblinets.transport.ui.UserInterface;
import by.andrewblinets.transport.ui.util.IteamMenuManagement;
import by.andrewblinets.transport.ui.write.WriteJsonFile;
import by.andrewblinets.transport.ui.write.WriteTextFile;
import by.andrewblinets.transport.ui.write.WriteXmlFile;

import java.util.ArrayList;

/**
 * Created by Андрей on 21.03.2017.
 */
public class WriteFile extends UserInterface implements IteanMenu {
    private final String WRITE = "\tMenu write\n" +
            "1-Write text file\n" +
            "2-Write xml file\n" +
            //"3-Write json fiel\n" +
            "3-Back";

    public WriteFile() {
        super();
        this.menu = new ArrayList<>();
        this.menu.add(new WriteTextFile());
        this.menu.add(new WriteXmlFile());
       // this.menu.add(new WriteJsonFile());
        this.menu.add(new ExitFromMenu());
    }

    @Override
    public boolean MenuIteam(UserInterface userInterface) {
        do {
            System.out.println(WRITE);
        }
        while (IteamMenuManagement.MainMenu(menu,userInterface));
        return true;
    }
}

