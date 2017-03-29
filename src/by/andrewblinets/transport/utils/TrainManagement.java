package by.andrewblinets.transport.utils;

import by.andrewblinets.transport.entity.Carriage;
import by.andrewblinets.transport.entity.PassengerTrain;
import by.andrewblinets.transport.enumes.StyleCarriage;

import java.util.ArrayList;
import java.util.List;


public class TrainManagement {

    public static void sortCarriageByIncreaseAmountPassanger(PassengerTrain train)
    {
        Carriage carriage = train.getCarriages().get(0);
        int position = 0;
        List<Carriage> list = new ArrayList<>();
        do {
            for (Carriage obj : train.getCarriages()) {
                if(obj.getPassengers().size() <= carriage.getPassengers().size())
                {
                    carriage = train.getCarriages().get(position);
                    position ++;
                }
                else
                    position++;
            }
            list.add(carriage);
            train.getCarriages().remove(carriage);
            if(train.getCarriages().size() != 0)
                carriage = train.getCarriages().get(0);
            position = 0;
        }
        while (train.getCarriages().size() != 0);
        train.setCarriages(list);
    }

    public static void sortCarriageByDescendingAmountPassanger(PassengerTrain train)
    {
        Carriage carriage = train.getCarriages().get(0);
        int position = 0;
        List<Carriage> list = new ArrayList<>();
        do {
            for (Carriage obj : train.getCarriages()) {
                if(obj.getPassengers().size() >= carriage.getPassengers().size())
                {
                    carriage = train.getCarriages().get(position);
                    position ++;
                }
                else
                    position++;
            }
            list.add(carriage);
            train.getCarriages().remove(carriage);
            if(train.getCarriages().size() != 0)
                carriage = train.getCarriages().get(0);
            position = 0;
        }
        while (train.getCarriages().size() != 0);
        train.setCarriages(list);
    }

    public static void sortCarriageByComfort(PassengerTrain train)
    {
        List<Carriage> list = new ArrayList<>();
        for (Carriage obj : train.getCarriages()) {
            if(obj.getStyle() == StyleCarriage.COMMON)
            {
                list.add(obj);
            }
        }
        for (Carriage obj : train.getCarriages()) {
            if(obj.getStyle() == StyleCarriage.COMPARTMENTS)
            {
                list.add(obj);
            }
        }
        train.setCarriages(list);
    }

    public static int searchCarriageByAmountPassangerByLimit(int a, int b,PassengerTrain train)
    {
        int kol = 0;
        for (Carriage obj:train.getCarriages()) {
            if(obj.getPassengers().size() > a && obj.getPassengers().size() < b)
                kol++;
        }
        return kol;
    }

    public static int searchCarriageByWeightLuggagePassanger(double a, double b, PassengerTrain train)
    {
        int kol = 0;
        for (Carriage obj:train.getCarriages()) {
            if(CarriageManagement.getWeightLuggageCarriage(obj) > a && CarriageManagement.getWeightLuggageCarriage(obj) < b)
                kol++;
        }
        return kol;
    }

    public static int searchCarriageByComfort(StyleCarriage q, PassengerTrain train)
    {
        int kol = 0;
        for (Carriage obj:train.getCarriages()) {
            if(obj.getStyle() == q)
                kol++;
        }
        return kol;
    }
}
