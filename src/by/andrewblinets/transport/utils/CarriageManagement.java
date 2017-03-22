package by.andrewblinets.transport.utils;

import by.andrewblinets.transport.entity.Passenger;

import java.util.List;

/**
 * Created by Андрей on 20.03.2017.
 */
public class CarriageManagement {

    public static double getWeightLuggageCarriage(List<Passenger> passengers)
    {
        double weight = 0;
        for(Passenger obj : passengers)
        {
           // weight += PassengerManagement.getWeightLuggagePassenger(obj.getLuggages());
        }
        return weight;
    }
}
