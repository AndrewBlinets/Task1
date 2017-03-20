package by.andrewblinets.transport.entity;

import by.andrewblinets.transport.interfaces.Schedullable;

import java.util.Date;

/**
 * Created by Андрей on 20.03.2017.
 */
public abstract class Train implements Schedullable {

    protected long id;
    protected String departurePoint;
    protected String arrivedPoint;
    protected Date departureTime;
    protected Date arrivedTime;
    protected double number;

    public abstract boolean addCarriage(Carriage carriage);
    public abstract boolean removeCarriageByNumber(int numbers);

    public Train() {
    }

    public Train(long id, String departurePoint, String arrivedPoint, Date departureTime, Date arrivedTime, double number) {
        this.id = id;
        this.departurePoint = departurePoint;
        this.arrivedPoint = arrivedPoint;
        this.departureTime = departureTime;
        this.arrivedTime = arrivedTime;
        this.number = number;
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

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivedTime() {
        return arrivedTime;
    }

    public void setArrivedTime(Date arrivedTime) {
        this.arrivedTime = arrivedTime;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Train train = (Train) o;

        if (id != train.id) return false;
        if (Double.compare(train.number, number) != 0) return false;
        if (departurePoint != null ? !departurePoint.equals(train.departurePoint) : train.departurePoint != null)
            return false;
        if (arrivedPoint != null ? !arrivedPoint.equals(train.arrivedPoint) : train.arrivedPoint != null) return false;
        if (departureTime != null ? !departureTime.equals(train.departureTime) : train.departureTime != null)
            return false;
        return arrivedTime != null ? arrivedTime.equals(train.arrivedTime) : train.arrivedTime == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + (departurePoint != null ? departurePoint.hashCode() : 0);
        result = 31 * result + (arrivedPoint != null ? arrivedPoint.hashCode() : 0);
        result = 31 * result + (departureTime != null ? departureTime.hashCode() : 0);
        result = 31 * result + (arrivedTime != null ? arrivedTime.hashCode() : 0);
        temp = Double.doubleToLongBits(number);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", departurePoint='" + departurePoint + '\'' +
                ", arrivedPoint='" + arrivedPoint + '\'' +
                ", departureTime=" + departureTime +
                ", arrivedTime=" + arrivedTime +
                ", number=" + number +
                '}';
    }
}
