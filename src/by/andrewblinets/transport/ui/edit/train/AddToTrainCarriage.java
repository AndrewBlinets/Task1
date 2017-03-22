package by.andrewblinets.transport.ui.edit.train;

import by.andrewblinets.transport.ui.IteanMenu;
import by.andrewblinets.transport.ui.UserInterface;
import by.andrewblinets.transport.ui.create.CreateCarriage;
import by.andrewblinets.transport.ui.show.ShowCarriage;
import by.andrewblinets.transport.ui.show.ShowTrain;
import by.andrewblinets.transport.ui.util.KeyboardWork;

/**
 * Created by Андрей on 22.03.2017.
 */
public class AddToTrainCarriage implements IteanMenu {

    private KeyboardWork keyboard;

    public AddToTrainCarriage() {
        keyboard = new KeyboardWork();
    }

    @Override
    public boolean MenuIteam(UserInterface userInterface) {

        if (userInterface.getPassengerTrains().size() != 0) {
            new ShowTrain().show(userInterface);
            do {
                int iteam = keyboard.readInt("Enter the number of the item to add carriage\n");
                if(iteam < userInterface.getPassengerTrains().size() + 1)
                {
                    userInterface.getPassengerTrains()
                            .get(iteam - 1)
                            .addCarriage(userInterface.getCarriages().get(new CreateCarriage().create(userInterface)));
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
        return true;
    }
}
