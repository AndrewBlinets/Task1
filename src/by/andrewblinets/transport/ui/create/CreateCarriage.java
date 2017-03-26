package by.andrewblinets.transport.ui.create;

import by.andrewblinets.transport.entity.Carriage;
import by.andrewblinets.transport.enumes.StyleCarriage;
import by.andrewblinets.transport.ui.IteamMenu;
import by.andrewblinets.transport.ui.UserInterface;
import by.andrewblinets.transport.ui.util.KeyboardWork;

public class CreateCarriage implements IteamMenu {

    private KeyboardWork keyboard;

    public CreateCarriage() {
        keyboard = new KeyboardWork();
    }

    @Override
    public boolean MenuIteam(UserInterface userInterface) {
        create(userInterface);
        return true;
    }

    public int create(UserInterface userInterface) {
        Carriage carriage;
        if(userInterface.getCarriages().size() != 0)
            carriage = new Carriage(userInterface.getCarriages().get(userInterface.getCarriages().size() - 1).getId() + 1);
        else
            carriage = new Carriage(1);
        carriage.setStyle(style());
        userInterface.getCarriages().add(carriage);
        System.out.println("Carriage  " + carriage.toString() + " successfully created!");
        return userInterface.getCarriages().size() - 1;
    }

    private StyleCarriage style()
    {
        do {
            switch (keyboard.readInt("Specify the type of carriage\n1-COMMON\n2-COMPARTMENTS\n"))
            {
                case 1:
                    return StyleCarriage.COMMON;
                case 2:
                    return StyleCarriage.COMPARTMENTS;
                default:
                {
                    System.out.println("Enter a value from 1 to 2");
                }
            }
        }
        while (true);
    }
}
