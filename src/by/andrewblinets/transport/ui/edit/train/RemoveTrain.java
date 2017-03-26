package by.andrewblinets.transport.ui.edit.train;

import by.andrewblinets.transport.ui.IteamMenu;
import by.andrewblinets.transport.ui.UserInterface;
import by.andrewblinets.transport.ui.show.train.SpisokTrains;
import by.andrewblinets.transport.ui.util.KeyboardWork;

public class RemoveTrain implements IteamMenu {

    private KeyboardWork keyboard;

    public RemoveTrain() {
        keyboard = new KeyboardWork();
    }

    @Override
    public boolean MenuIteam(UserInterface userInterface) {
        if (userInterface.getPassengerTrains().size() != 0) {
            new SpisokTrains().show(userInterface);
            do {
                int iteam = keyboard.readInt("Enter the number of the item to delete\n");
                if(iteam < userInterface.getPassengerTrains().size() + 1)
                {
                    userInterface.getPassengerTrains().remove(iteam - 1);
                    System.out.println("Train delete successfully");
                    break;
                }
                else
                {
                    System.out.println("Number not found");
                }
            }
            while (true);
        }
        else
        {
            System.out.println("Train not found");
        }
        return true;
    }
}
