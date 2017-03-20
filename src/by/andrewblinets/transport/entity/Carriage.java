package by.andrewblinets.transport.entity;

import by.andrewblinets.transport.enumes.StyleCarriage;

import java.util.List;

/**
 * Created by Андрей on 20.03.2017.
 */
public class Carriage {

    private long id;
    private double numbers;
    private List<Passenger> passengers;
    private StyleCarriage carriage;

    public Carriage() {
    }

    public Carriage(long id, double numbers, List<Passenger> passengers, StyleCarriage carriage) {
        this.id = id;
        this.numbers = numbers;
        this.passengers = passengers;
        this.carriage = carriage;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getNumbers() {
        return numbers;
    }

    public void setNumbers(double numbers) {
        this.numbers = numbers;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public StyleCarriage getCarriage() {
        return carriage;
    }

    public void setCarriage(StyleCarriage carriage) {
        this.carriage = carriage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Carriage carriage1 = (Carriage) o;

        if (id != carriage1.id) return false;
        if (Double.compare(carriage1.numbers, numbers) != 0) return false;
        if (passengers != null ? !passengers.equals(carriage1.passengers) : carriage1.passengers != null) return false;
        return carriage == carriage1.carriage;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        temp = Double.doubleToLongBits(numbers);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (passengers != null ? passengers.hashCode() : 0);
        result = 31 * result + (carriage != null ? carriage.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Carriage{" +
                "id=" + id +
                ", numbers=" + numbers +
                ", passengers=" + passengers +
                ", carriage=" + carriage +
                '}';
    }
}
