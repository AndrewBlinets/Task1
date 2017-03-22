package by.andrewblinets.transport.ui.util;

import by.andrewblinets.transport.ui.IteanMenu;
import by.andrewblinets.transport.ui.UserInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Андрей on 21.03.2017.
 */
public class IteamMenuManagement {

    public static void MainMenu(UserInterface userInterface)
    {
            boolean flagExit = true;
            do {
                try {
                    flagExit = userInterface.getMenu().get(new KeyboardWork().readInt(userInterface.getMENU() + "\n") - 1)
                            .MenuIteam(userInterface);
                }
                catch (IndexOutOfBoundsException e) {
                    System.out.println("Enter the value corresponding to the menu items!!!");
                }
            }
            while (flagExit);
    }

    public static boolean MainMenu(List<IteanMenu> menu, UserInterface userInterface) {
        do {
            try {
                return menu.get(new KeyboardWork().readInt("") - 1).MenuIteam(userInterface);
            }
            catch (IndexOutOfBoundsException e) {
                System.out.println("Enter the value corresponding to the menu items!!!");
                return true;
            }
        }
        while (true);
    }
}
