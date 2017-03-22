package by.andrewblinets.transport.ui.edit.passenger;

import by.andrewblinets.transport.ui.IteanMenu;
import by.andrewblinets.transport.ui.UserInterface;
import by.andrewblinets.transport.ui.show.ShowLuggage;
import by.andrewblinets.transport.ui.show.ShowPassenger;
import by.andrewblinets.transport.ui.util.KeyboardWork;

/**
 * Created by Андрей on 22.03.2017.
 */
public class RemovePassenger implements IteanMenu {
    private KeyboardWork keyboard;

    public RemovePassenger() {
        keyboard = new KeyboardWork();
    }

    @Override
    public boolean MenuIteam(UserInterface userInterface) {
        if (userInterface.getPassengers().size() != 0) {
            new ShowPassenger().show(userInterface);
            do {
                int iteam = keyboard.readInt("Enter the number of the item to delete\n");
                if (iteam < userInterface.getPassengers().size() + 1) {
                    userInterface.getPassengers().remove(iteam - 1);
                    System.out.println("Passenger delete successfully");
                    break;
                } else {
                    System.out.println("Number not found");
                }
            }
            while (true);
        } else {
            System.out.println("Passenger not found");
        }
        return true;
    }
}
