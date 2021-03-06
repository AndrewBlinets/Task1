package by.andrewblinets.transport.ui.edit.train;

import by.andrewblinets.transport.ui.IteamMenu;
import by.andrewblinets.transport.ui.UserInterface;
import by.andrewblinets.transport.ui.create.CreateCarriage;
import by.andrewblinets.transport.ui.show.ShowCarriage;
import by.andrewblinets.transport.ui.show.train.SpisokTrains;
import by.andrewblinets.transport.ui.util.KeyboardWork;

public class AddToTrainCarriage implements IteamMenu {

    private KeyboardWork keyboard;

    public AddToTrainCarriage() {
        keyboard = new KeyboardWork();
    }

    @Override
    public boolean MenuIteam(UserInterface userInterface) {
        if (userInterface.getPassengerTrains().size() != 0) {
            return addCarriage(userInterface);
        }
        else
        {
            System.out.println("Train not found, create please!");
        }
        return true;
    }

    private boolean addCarriage(UserInterface userInterface) {
        new SpisokTrains().show(userInterface);
        do {
            int iteam = keyboard.readInt("Enter the number of the item to add carriage\n");
            if(iteam < userInterface.getPassengerTrains().size() + 1)
            {
                return switchAddCarriage(userInterface, iteam);
            }
            else
            {
                System.out.println("Number not found");
            }
        }
        while (true);
    }

    private boolean switchAddCarriage(UserInterface userInterface, int iteam) {
        do {
            switch (keyboard.readInt("Add carriage\n1-new\n2-existing\n"))
            {
                case 1: {
                    userInterface.getPassengerTrains()
                            .get(iteam - 1)
                            .addCarriage(userInterface
                                    .getCarriages()
                                    .get(new CreateCarriage().create(userInterface)));
                    return true;
                }
                case 2:
                {
                    userInterface.getPassengerTrains()
                            .get(iteam - 1)
                            .addCarriage(userInterface.getCarriages().get(selectionCarriage(userInterface)));
                    return true;
                }
                default:
                {
                    System.out.println("Enter a value from 1 to 2");
                }
            }
        }
        while (true);
    }

    private int selectionCarriage(UserInterface userInterface) {
        new ShowCarriage().show(userInterface);
        do {
            int iteam = keyboard.readInt("Enter the number of the item\n");
            if(iteam < userInterface.getCarriages().size() + 1)
            {
                iteam--;
                return iteam;
            }
            else
            {
                System.out.println("Number not found");
            }
        }
        while (true);
    }
}
