package by.andrewblinets.transport.ui.edit.luggage;

import by.andrewblinets.transport.ui.IteamMenu;
import by.andrewblinets.transport.ui.UserInterface;
import by.andrewblinets.transport.ui.show.ShowLuggage;
import by.andrewblinets.transport.ui.util.KeyboardWork;

public class RemoveLuggage implements IteamMenu {

    private KeyboardWork keyboard;

    public RemoveLuggage() {
        keyboard = new KeyboardWork();
    }

    @Override
    public boolean MenuIteam(UserInterface userInterface) {
        if (userInterface.getLuggages().size() != 0) {
            new ShowLuggage().show(userInterface);
            do {
                int iteam = keyboard.readInt("Enter the number of the item to delete\n");
                if(iteam < userInterface.getLuggages().size() + 1)
                {
                    userInterface.getLuggages().remove(iteam - 1);
                    System.out.println("Luggage delete successfully");
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
            System.out.println("Luggage not found");
        }
        return true;
    }
}
