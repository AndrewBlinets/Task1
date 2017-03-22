package by.andrewblinets.transport.ui.edit.carriage;

import by.andrewblinets.transport.ui.IteanMenu;
import by.andrewblinets.transport.ui.UserInterface;
import by.andrewblinets.transport.ui.create.CreateCarriage;
import by.andrewblinets.transport.ui.create.CreatePassenger;
import by.andrewblinets.transport.ui.show.ShowCarriage;
import by.andrewblinets.transport.ui.show.train.SpisokTrains;
import by.andrewblinets.transport.ui.util.KeyboardWork;

/**
 * Created by Андрей on 22.03.2017.
 */
public class AddPassengerInCarriage implements IteanMenu {

    private KeyboardWork keyboard;

    public AddPassengerInCarriage() {
        keyboard = new KeyboardWork();
    }

    @Override
    public boolean MenuIteam(UserInterface userInterface) {
        addPassenger(userInterface);
        return true;
    }

    private void addPassenger(UserInterface userInterface) {
        if (userInterface.getCarriages().size() != 0) {
            new ShowCarriage().show(userInterface);
            do {
                int iteam = keyboard.readInt("Enter the number of the item \n");
                if(iteam < userInterface.getCarriages().size() + 1)
                {
                    userInterface.getCarriages()
                            .get(iteam - 1)
                            .getPassengers()
                            .add(userInterface.getPassengers().get(new CreatePassenger().create(userInterface)));
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
            System.out.println("Train not found, create please!");
        }
    }
}
