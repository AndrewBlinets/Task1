package by.andrewblinets.transport.entity;

import java.util.Date;
import java.util.List;

/**
 * Created by Андрей on 20.03.2017.
 */
public class PassengerTrain extends Train {

    private long Id;
    private List<Carriage> carriages;

    public PassengerTrain(long id, List<Carriage> carriages) {
        Id = id;
        this.carriages = carriages;
    }

    public PassengerTrain(long id, String departurePoint, String arrivedPoint, Date departureTime, Date arrivedTime, double number, long id1, List<Carriage> carriages) {
        super(id, departurePoint, arrivedPoint, departureTime, arrivedTime, number);
        Id = id1;
        this.carriages = carriages;
    }

    @Override
    public long getId() {
        return Id;
    }

    @Override
    public void setId(long id) {
        Id = id;
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

        if (Id != that.Id) return false;
        return carriages != null ? carriages.equals(that.carriages) : that.carriages == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (int) (Id ^ (Id >>> 32));
        result = 31 * result + (carriages != null ? carriages.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PassengerTrain{" +
                "Id=" + Id +
                ", carriages=" + carriages +
                '}';
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
