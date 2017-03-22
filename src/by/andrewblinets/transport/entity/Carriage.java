package by.andrewblinets.transport.entity;

import by.andrewblinets.transport.enumes.StyleCarriage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Андрей on 20.03.2017.
 */
public class Carriage {

    private long id;
    private List<Passenger> passengers;
    private StyleCarriage style;

    public Carriage() {
    }

    public Carriage(long id) {
        this.id = id;
        this.passengers = new ArrayList<>();
    }

    public Carriage(long id, int numbers, List<Passenger> passengers, StyleCarriage style) {
        this.id = id;
        this.passengers = passengers;
        this.style = style;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public StyleCarriage getStyle() {
        return style;
    }

    public void setStyle(StyleCarriage style) {
        this.style = style;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Carriage carriage1 = (Carriage) o;

        if (id != carriage1.id) return false;
        if (passengers != null ? !passengers.equals(carriage1.passengers) : carriage1.passengers != null) return false;
        return style == carriage1.style;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (passengers != null ? passengers.hashCode() : 0);
        result = 31 * result + (style != null ? style.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        String str =  "id = " + id +
                " style = " + style +
                " passengers = [";
        for (Passenger passenger : passengers) {
            str += passenger.toString() + " ";
        }
        str += "]";
        return str;
    }
}
