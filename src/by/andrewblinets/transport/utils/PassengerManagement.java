package by.andrewblinets.transport.utils;

import by.andrewblinets.transport.entity.Luggage;
import by.andrewblinets.transport.entity.Passenger;

import java.util.List;

/**
 * Created by Андрей on 20.03.2017.
 */
public class PassengerManagement {

    public static double getWeightLuggagePassenger(Passenger passenger)
    {
        double weight = 0;
        for (Luggage obj : passenger.getLuggages())
        {
            weight += obj.getWeight();
        }
        return weight;
    }

}
