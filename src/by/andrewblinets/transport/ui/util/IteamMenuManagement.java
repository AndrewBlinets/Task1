package by.andrewblinets.transport.ui.util;

import by.andrewblinets.transport.ui.IteamMenu;
import by.andrewblinets.transport.ui.UserInterface;

import java.util.List;

public class IteamMenuManagement {

    public static void MainMenu(UserInterface userInterface)
    {
            boolean flagExit = true;
            do {
                try {
                    flagExit = userInterface.getIteamsMenu().get(new KeyboardWork().readInt(userInterface.getMAINMENU() + "\n") - 1)
                            .MenuIteam(userInterface);
                }
                catch (IndexOutOfBoundsException e) {
                    System.out.println("Enter the value corresponding to the iteamsMenu items!!!");
                }
            }
            while (flagExit);
    }

    public static boolean MainMenu(List<IteamMenu> menu, UserInterface userInterface) {
            try {
                return menu.get(new KeyboardWork().readInt("") - 1).MenuIteam(userInterface);
            }
            catch (UnsupportedOperationException e) {
                System.out.println("At the moment the implementation of the method is not supported, sorry.");
                return true;
            }
            catch (IndexOutOfBoundsException e) {
                System.out.println("Enter the value corresponding to the iteamsMenu items!!!");
                return true;
            }
    }
}
