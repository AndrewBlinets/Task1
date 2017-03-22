package by.andrewblinets.transport;

import by.andrewblinets.transport.ui.UserInterface;
import by.andrewblinets.transport.ui.util.IteamMenuManagement;

/**
 * Created by Андрей on 20.03.2017.
 */
public class TransportSystem {

    public static void main (String [] args)
    {
        UserInterface userInterface = new UserInterface(1);
        IteamMenuManagement.MainMenu(userInterface);
    }
}
