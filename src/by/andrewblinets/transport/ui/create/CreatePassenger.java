package by.andrewblinets.transport.ui.create;

import by.andrewblinets.transport.entity.Luggage;
import by.andrewblinets.transport.entity.Passenger;
import by.andrewblinets.transport.ui.IteamMenu;
import by.andrewblinets.transport.ui.UserInterface;
import by.andrewblinets.transport.ui.show.ShowLuggage;
import by.andrewblinets.transport.ui.util.KeyboardWork;

public class CreatePassenger implements IteamMenu {

    private KeyboardWork keyboard;

    public CreatePassenger() {
        keyboard = new KeyboardWork();
    }

    @Override
    public boolean MenuIteam(UserInterface userInterface) {
        create(userInterface);
        return true;
    }

    public int create(UserInterface userInterface) {
        Passenger passenger;
        if(userInterface.getPassengers().size() != 0)
            passenger = new Passenger(userInterface.getPassengers().get(userInterface.getPassengers().size() - 1).getId() + 1);
        else
            passenger = new Passenger(1);
        passenger.setName(keyboard.readString("Enter the name of the passenger"));
        passenger.setLastName(keyboard.readString("Enter the lastname of the passenger"));
        createLuggagePassenger(userInterface, passenger);
        System.out.println("Passenger " + passenger.toString() + " successfully created!");
        userInterface.getPassengers().add(passenger);
        return userInterface.getPassengers().size() - 1;
    }

    private void createLuggagePassenger(UserInterface userInterface, Passenger passenger) {
        boolean flagStop = true;
        do {
            switch (keyboard.readInt("Add luggage to the passenger?\n1-Add existing\n2-Create new\n3-Not, Thank you\n"))
            {
                case 1:
                {
                    addExistingLuggage(userInterface, passenger);
                    break;
                }
                case 2:
                {
                    passenger.getLuggages().add(userInterface.getLuggages().get((int)new CreateLuggage().create(userInterface) - 1));
                    break;
                }
                case 3:
                {
                    flagStop = false;
                    break;
                }
                default:
                    System.out.println("Enter a value from 1 to 3");
            }
        }
        while (flagStop);
    }

    private void addExistingLuggage(UserInterface userInterface, Passenger passenger) {
        if(userInterface.getLuggages().size() == 0)
        {
            System.out.println("There is no Luggages");
        }
        else
        new ShowLuggage().show(userInterface);
        int number;
        do {
            number = keyboard.readInt("Enter the item number\n");
            if(number > userInterface.getLuggages().size())
                System.out.println("Sorry, There is no such number");
            else
                break;
        }
        while (true);
        if (searchLuggeshOtherPassangers(number,userInterface))
        {
            System.out.println("It's someone else's luggages");
        }
        else
        {
            passenger.getLuggages().add(userInterface.getLuggages().get(number));
        }
    }

    private boolean searchLuggeshOtherPassangers(int number, UserInterface userInterface) {
        long id = userInterface.getLuggages().get(number - 1).getId();
        for (Passenger passanger: userInterface.getPassengers()) {
            for (Luggage luggages: passanger.getLuggages()) {
                if(luggages.getId() == id)
                    return true;
            }
        }
        return false;
    }
}
