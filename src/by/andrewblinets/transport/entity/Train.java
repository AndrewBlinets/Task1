package by.andrewblinets.transport.entity;

import by.andrewblinets.transport.interfaces.Schedullable;

/**
 * Created by Андрей on 20.03.2017.
 */
public abstract class Train implements Schedullable {

    private long id;
    protected String departurePoint;
    protected String arrivedPoint;

    public abstract void addCarriage(Carriage carriage);
    public abstract void removeCarriageByNumber(int numbers);

    public Train() {
    }

    public Train(long id, String departurePoint, String arrivedPoint, int number) {
        this.id = id;
        this.departurePoint = departurePoint;
        this.arrivedPoint = arrivedPoint;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDeparturePoint() {
        return departurePoint;
    }

    public void setDeparturePoint(String departurePoint) {
        this.departurePoint = departurePoint;
    }

    public String getArrivedPoint() {
        return arrivedPoint;
    }

    public void setArrivedPoint(String arrivedPoint) {
        this.arrivedPoint = arrivedPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Train train = (Train) o;

        if (id != train.id) return false;
        if (departurePoint != null ? !departurePoint.equals(train.departurePoint) : train.departurePoint != null)
            return false;
        return arrivedPoint != null ? arrivedPoint.equals(train.arrivedPoint) : train.arrivedPoint == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (departurePoint != null ? departurePoint.hashCode() : 0);
        result = 31 * result + (arrivedPoint != null ? arrivedPoint.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return  " departurePoint = " + departurePoint +
                " arrivedPoint = " + arrivedPoint;
    }
}
