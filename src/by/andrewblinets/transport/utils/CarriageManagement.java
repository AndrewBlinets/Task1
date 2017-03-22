package by.andrewblinets.transport.utils;

import by.andrewblinets.transport.entity.Carriage;
import by.andrewblinets.transport.entity.Passenger;

import java.util.List;

/**
 * Created by Андрей on 20.03.2017.
 */
public class CarriageManagement {

    public static double getWeightLuggageCarriage(Carriage carriage)
    {
        double weight = 0;
        for(Passenger obj : carriage.getPassengers())
        {
            weight += PassengerManagement.getWeightLuggagePassenger(obj);
        }
        return weight;
    }
}
