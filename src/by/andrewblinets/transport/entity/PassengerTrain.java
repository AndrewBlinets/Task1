package by.andrewblinets.transport.entity;

import java.util.ArrayList;
import java.util.List;

public class PassengerTrain extends Train {

    private List<Carriage> carriages;

    public PassengerTrain(long id) {
        super(id);
        this.carriages = new ArrayList<>();
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

        return carriages != null ? carriages.equals(that.carriages) : that.carriages == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (carriages != null ? carriages.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        String str =  "id = " + super.toString() +
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
    public void addCarriage(Carriage carriage) {
        carriages.add(carriage);
        System.out.println("Carriage add successfully");
    }

    @Override
    public void removeCarriageByNumber(int numbers) {
        carriages.remove(numbers);
        System.out.println("Carriage delete successfully");
    }
}
