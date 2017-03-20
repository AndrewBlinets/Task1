package by.andrewblinets.transport.entity;

import java.util.List;

/**
 * Created by Андрей on 20.03.2017.
 */
public class Passenger {

    private long id;
    private String name;
    private String lastName;
    private int place;
    private List<Luggage> luggages;

    public Passenger() {
    }

    public Passenger(long id, String name, String lastName, int place, List<Luggage> luggages) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.place = place;
        this.luggages = luggages;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public List<Luggage> getLuggages() {
        return luggages;
    }

    public void setLuggages(List<Luggage> luggages) {
        this.luggages = luggages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Passenger passenger = (Passenger) o;

        if (id != passenger.id) return false;
        if (place != passenger.place) return false;
        if (name != null ? !name.equals(passenger.name) : passenger.name != null) return false;
        if (lastName != null ? !lastName.equals(passenger.lastName) : passenger.lastName != null) return false;
        return luggages != null ? luggages.equals(passenger.luggages) : passenger.luggages == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + place;
        result = 31 * result + (luggages != null ? luggages.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", place=" + place +
                ", luggages=" + luggages +
                '}';
    }
}
