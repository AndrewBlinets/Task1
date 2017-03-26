package by.andrewblinets.transport.ui.create;

import by.andrewblinets.transport.entity.Luggage;
import by.andrewblinets.transport.ui.IteamMenu;
import by.andrewblinets.transport.ui.UserInterface;
import by.andrewblinets.transport.ui.util.KeyboardWork;

public class CreateLuggage implements IteamMenu {

    private KeyboardWork keyboard;

    public CreateLuggage() {
        keyboard = new KeyboardWork();
    }

    @Override
    public boolean MenuIteam(UserInterface userInterface) {
        create(userInterface);
        return true;
    }

    public long create(UserInterface userInterface)
    {
        Luggage luggage;
        if(userInterface.getLuggages().size() != 0)
            luggage = new Luggage(userInterface.getLuggages().get(userInterface.getLuggages().size() - 1).getId() + 1);
        else
            luggage = new Luggage(1);
        luggage.setName(keyboard.readString("Enter the name of the luggage"));
        luggage.setWeight(keyboard.readDouble("Enter the weight of the luggage"));
        userInterface.getLuggages().add(luggage);
        System.out.println("Luggage  " + luggage.toString() + " successfully created!");
        return luggage.getId();
    }
}