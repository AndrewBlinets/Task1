package by.andrewblinets.transport.ui.show.train;

import by.andrewblinets.transport.ui.IteamMenu;
import by.andrewblinets.transport.ui.UserInterface;
import by.andrewblinets.transport.ui.util.KeyboardWork;
import by.andrewblinets.transport.utils.TrainManagement;

public class ShowWeightFromTo implements IteamMenu {

    private KeyboardWork keyboard;

    public ShowWeightFromTo() {
        keyboard = new KeyboardWork();
    }

    @Override
    public boolean MenuIteam(UserInterface userInterface) {
        if (userInterface.getPassengerTrains().size() != 0) {
            new SpisokTrains().show(userInterface);
            do {
                int iteam = keyboard.readInt("Enter the number of the Train show\n");
                if(iteam < userInterface.getPassengerTrains().size() + 1)
                {
                        double start = keyboard.readDouble("Enter start value weight luggage passanger carriage");
                        double finish = keyboard.readDouble("Enter finish value weight luggage passanger carriage");
                    System.out.println("In this train there are" +
                            TrainManagement
                                    .searchCarriageByWeightLuggagePassanger(start,finish,
                                            userInterface.getPassengerTrains().get(iteam - 1))
                            + "carriage of weight luggage passanger from " + start + " to " + finish);
                    return true;
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

        return false;
    }
}
