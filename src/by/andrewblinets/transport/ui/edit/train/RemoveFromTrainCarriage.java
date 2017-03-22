package by.andrewblinets.transport.ui.edit.train;

import by.andrewblinets.transport.ui.IteanMenu;
import by.andrewblinets.transport.ui.UserInterface;
import by.andrewblinets.transport.ui.show.train.SpisokTrains;
import by.andrewblinets.transport.ui.util.KeyboardWork;

/**
 * Created by Андрей on 22.03.2017.
 */
public class RemoveFromTrainCarriage implements IteanMenu {

    private KeyboardWork keyboard;

    public RemoveFromTrainCarriage() {
        keyboard = new KeyboardWork();
    }

    @Override
    public boolean MenuIteam(UserInterface userInterface) {

        if (userInterface.getPassengerTrains().size() != 0) {
            new SpisokTrains().show(userInterface);
            do {
                int iteam = keyboard.readInt("Enter the number of the item to remove carriage\n");
                if(iteam < userInterface.getPassengerTrains().size() + 1)
                {
                    System.out.println(userInterface.getPassengerTrains()
                            .get(iteam - 1).toString());
                    do {
                        if (userInterface.getPassengerTrains().get(iteam - 1).getCarriages().size() != 0) {
                            int id = keyboard.readInt("Enter the id carriage to remove from train\n");
                            if (id < userInterface.getPassengerTrains().get(iteam - 1).getCarriages().size() + 1) {
                                userInterface.getPassengerTrains().get(iteam - 1).removeCarriageByNumber(id - 1);
                                break;
                            } else {
                                System.out.println("Number not found");
                            }
                        }
                        else
                        {
                            System.out.println("Train not have carriage");
                            break;
                        }
                    }
                    while (true);
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
