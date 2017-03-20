package by.andrewblinets.transport.utils;

import by.andrewblinets.transport.entity.Luggage;

import java.util.List;

/**
 * Created by Андрей on 20.03.2017.
 */
public class PassengerManagement {

    public static double getWeightLuggagePassenger(List<Luggage> luggages)
    {
        double weight = 0;
        for (Luggage obj : luggages)
        {
            weight += obj.getWeight();
        }
        return weight;
    }

}
