package by.andrewblinets.transport;

import by.andrewblinets.transport.ui.UserInterface;
import by.andrewblinets.transport.ui.util.IteamMenuManagement;


public class TransportSystem {

    public static void main (String [] args)
    {
        UserInterface userInterface = new UserInterface(1);
        IteamMenuManagement.MainMenu(userInterface);
    }
}
