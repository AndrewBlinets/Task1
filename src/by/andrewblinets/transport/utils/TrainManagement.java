package by.andrewblinets.transport.utils;

import by.andrewblinets.transport.entity.Carriage;
import by.andrewblinets.transport.enumes.StyleCarriage;

import java.util.List;

/**
 * Created by Андрей on 20.03.2017.
 */
public class TrainManagement {

    public static int getAmountPassangerTrain(List<Carriage> carriages)
    {
        int kol = 0;
        for (Carriage obj : carriages) {
            kol += obj.getPassengers().size();
        }
        return kol;
    }

    public static double getWeightLuggageTrain(List<Carriage> carriages)
    {
        int weight = 0;
        for (Carriage obj : carriages)
        {
            weight+= CarriageManagement.getWeightLuggageCarriage(obj.getPassengers());
        }
        return weight;
    }

    public static boolean sortCarriageByIncreaseAmountPassanger()
    {
        return false;
    }

    public static boolean sortCarriageByDescendingAmountPassanger()
    {
        return false;
    }

    public static boolean sortCarriageByComfort()
    {
        return false;
    }

    public static int searchCarriageByAmountPassanger(int a, int b)
    {
        return 0;
    }

    public static int searchCarriageByWeightLuggagePassanger(double a, double b)
    {
        return 0;
    }

    public static int searchCarriageByComfort(StyleCarriage q)
    {
        return 0;
    }
}
