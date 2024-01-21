package model.inheritance.tablePerClass;

import javax.persistence.Entity;

@Entity
public class LuxuryCar extends Car {
    private boolean hasAC;
    private boolean hasLeatherSeats;

    public LuxuryCar() {
    }

    public LuxuryCar(String name, String color, int speed, double price, boolean hasAC, boolean hasLeatherSeats) {
        super(name, color, speed, price);
        this.hasAC = hasAC;
        this.hasLeatherSeats = hasLeatherSeats;
    }

    public LuxuryCar(int id, String name, String color, int speed, double price, boolean hasAC, boolean hasLeatherSeats) {
        super(id, name, color, speed, price);
        this.hasAC = hasAC;
        this.hasLeatherSeats = hasLeatherSeats;
    }

    @Override
    public String toString() {
        return "LuxuryCar [hasAC=" + hasAC + ", hasLeatherSeats=" + hasLeatherSeats + ", toString()=" + super.toString()
                + "]";
    }
}
