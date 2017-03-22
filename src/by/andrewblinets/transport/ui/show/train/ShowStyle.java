package by.andrewblinets.transport.ui.show.train;

import by.andrewblinets.transport.enumes.StyleCarriage;
import by.andrewblinets.transport.ui.IteanMenu;
import by.andrewblinets.transport.ui.UserInterface;
import by.andrewblinets.transport.ui.util.KeyboardWork;
import by.andrewblinets.transport.utils.TrainManagement;

/**
 * Created by Андрей on 22.03.2017.
 */
public class ShowStyle implements IteanMenu {

    private KeyboardWork keyboard;

    public ShowStyle() {
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
                    boolean flagStop = false;
                    do {
                        switch (keyboard.readInt("Specify the type of carriage\n1-COMMON\n2-COMPARTMENTS\n"))
                        {
                            case 1: {
                                System.out.println("In this train there are" +
                                        TrainManagement
                                        .searchCarriageByComfort(
                                                StyleCarriage.COMMON,
                                                userInterface.getPassengerTrains()
                                                        .get(iteam - 1))
                                        + "carriage of the specified type");
                                return true;
                            }
                            case 2:
                            {
                                System.out.println("In this train there are" +
                                        TrainManagement
                                        .searchCarriageByComfort(
                                                StyleCarriage.COMPARTMENTS,
                                                userInterface.getPassengerTrains()
                                                        .get(iteam - 1))
                                        + "carriage of the specified type");
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