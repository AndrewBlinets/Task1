package by.andrewblinets.transport.ui.edit.carriage;

import by.andrewblinets.transport.ui.IteanMenu;
import by.andrewblinets.transport.ui.UserInterface;
import by.andrewblinets.transport.ui.show.ShowCarriage;
import by.andrewblinets.transport.ui.show.ShowLuggage;
import by.andrewblinets.transport.ui.util.KeyboardWork;

/**
 * Created by Андрей on 22.03.2017.
 */
public class RemoveCarriage implements IteanMenu {

    private KeyboardWork keyboard;

    public RemoveCarriage() {
        keyboard = new KeyboardWork();
    }

    @Override
    public boolean MenuIteam(UserInterface userInterface) {
        if (userInterface.getCarriages().size() != 0) {
            new ShowCarriage().show(userInterface);
            do {
                int iteam = keyboard.readInt("Enter the number of the item to delete\n");
                if(iteam < userInterface.getCarriages().size() + 1)
                {
                    userInterface.getCarriages().remove(iteam - 1);
                    System.out.println("Carriage delete successfully");
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
            System.out.println("Carriage not found");
        }
        return true;
    }
}
