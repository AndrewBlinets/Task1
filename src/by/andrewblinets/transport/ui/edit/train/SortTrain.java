package by.andrewblinets.transport.ui.edit.train;

import by.andrewblinets.transport.ui.IteamMenu;
import by.andrewblinets.transport.ui.UserInterface;
import by.andrewblinets.transport.ui.show.train.SpisokTrains;
import by.andrewblinets.transport.ui.util.KeyboardWork;
import by.andrewblinets.transport.utils.TrainManagement;

public class SortTrain implements IteamMenu {

    private KeyboardWork keyboard;

    public SortTrain() {
        keyboard = new KeyboardWork();
    }
    @Override
    public boolean MenuIteam(UserInterface userInterface) {
        if (userInterface.getPassengerTrains().size() != 0) {
            new SpisokTrains().show(userInterface);
            do {
                int iteam = keyboard.readInt("Enter the number of the item to sort carriage\n");
                if(iteam < userInterface.getPassengerTrains().size() + 1)
                {
                    boolean flagStop;
                    do {
                        switch (keyboard.readInt("Select type\n1-IncreaseAmountPassanger\n" +
                                "2-DescendingAmountPassanger\n" +
                                "3-Comfort\n"))
                        {
                            case 1: {
                                TrainManagement.sortCarriageByIncreaseAmountPassanger(
                                        userInterface.getPassengerTrains().get(iteam - 1));
                                System.out.println("Sort successfully!");
                                return true;
                            }
                            case 2:
                            {
                                TrainManagement.sortCarriageByDescendingAmountPassanger(
                                        userInterface.getPassengerTrains().get(iteam - 1));
                                System.out.println("Sort successfully!");
                                return true;
                            }
                            case 3:
                            {
                                TrainManagement.sortCarriageByComfort(
                                        userInterface.getPassengerTrains().get(iteam - 1));
                                System.out.println("Sort successfully!");
                                return true;
                            }
                            default:
                            {
                                flagStop = true;
                                System.out.println("Enter a value from 1 to 2");
                            }
                        }
                    }
                    while (flagStop);
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
