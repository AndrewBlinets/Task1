package by.andrewblinets.transport.entity;

public class Luggage {

    private long id;
    private String name;
    private double weight;

    public Luggage() {
    }

    public Luggage(long id) {
        this.id = id;
    }

    public Luggage(long id, String name, double weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Luggage luggage = (Luggage) o;

        if (id != luggage.id) return false;
        if (Double.compare(luggage.weight, weight) != 0) return false;
        return name != null ? name.equals(luggage.name) : luggage.name == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "id = " + id +
                " name = " + name  +
                " weight = " + weight;
    }
}
