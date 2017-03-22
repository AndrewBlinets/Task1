package by.andrewblinets.transport.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Андрей on 20.03.2017.
 */
public class PassengerTrain extends Train {

    private long id;
    private List<Carriage> carriages;

    public PassengerTrain(long id) {
        super();
        this.id = id;
        this.carriages = new ArrayList<>();
    }

    public PassengerTrain(long id, String departurePoint, String arrivedPoint, int number, long id1, List<Carriage> carriages) {
        super(id, departurePoint, arrivedPoint, number);
        this.id = id1;
        this.carriages = carriages;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public List<Carriage> getCarriages() {
        return carriages;
    }

    public void setCarriages(List<Carriage> carriages) {
        this.carriages = carriages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        PassengerTrain that = (PassengerTrain) o;

        if (id != that.id) return false;
        return carriages != null ? carriages.equals(that.carriages) : that.carriages == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (carriages != null ? carriages.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {

        String str =  "id = " + id + " " + super.toString() +
                " carriages = [";
        for (Carriage carriage : carriages) {
            str += carriage.toString() + " ";
        }
        str += "]";
        return str;
    }

    @Override
    public void arrived() {

    }

    @Override
    public void departure() {

    }

    @Override
    public boolean addCarriage(Carriage carriage) {
        return false;
    }

    @Override
    public boolean removeCarriageByNumber(int numbers) {
        return false;
    }
}
