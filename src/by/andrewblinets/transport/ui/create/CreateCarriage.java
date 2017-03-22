package by.andrewblinets.transport.ui.create;

import by.andrewblinets.transport.entity.Carriage;
import by.andrewblinets.transport.enumes.StyleCarriage;
import by.andrewblinets.transport.ui.IteanMenu;
import by.andrewblinets.transport.ui.UserInterface;
import by.andrewblinets.transport.ui.util.KeyboardWork;

/**
 * Created by Андрей on 21.03.2017.
 */
public class CreateCarriage implements IteanMenu {

    private KeyboardWork keyboard;

    public CreateCarriage() {
        keyboard = new KeyboardWork();
    }

    @Override
    public boolean MenuIteam(UserInterface userInterface) {
        create(userInterface);
        return true;
    }

    private void create(UserInterface userInterface) {
        Carriage carriage;
        if(userInterface.getCarriages().size() != 0)
            carriage = new Carriage(userInterface.getCarriages().get(userInterface.getCarriages().size() - 1).getId() + 1);
        else
            carriage = new Carriage(1);
        carriage.setStyle(style());
        userInterface.getCarriages().add(carriage);
        System.out.println("Carriage  " + carriage.toString() + " successfully created!");
    }

    private StyleCarriage style()
    {
        boolean flagStop = false;
        do {
            switch (keyboard.readInt("Specify the type of carriage\n1-COMMON\n2-COMPARTMENTS\n"))
            {
                case 1:
                    return StyleCarriage.COMMON;
                case 2:
                    return StyleCarriage.COMPARTMENTS;
                default:
                {
                    flagStop = true;
                    System.out.println("Enter a value from 1 to 2");
                }
            }
        }
        while (flagStop);
        return StyleCarriage.COMMON;
    }
}
