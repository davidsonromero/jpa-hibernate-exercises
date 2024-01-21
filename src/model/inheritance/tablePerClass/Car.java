package model.inheritance.tablePerClass;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    private String name;
    private String color;
    private int speed;
    private double price;

    public Car() {
    }

    public Car(String name, String color, int speed, double price) {
        this.name = name;
        this.color = color;
        this.speed = speed;
        this.price = price;
    }

    public Car(int id, String name, String color, int speed, double price) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.speed = speed;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car [id=" + id + ", name=" + name + ", color=" + color + ", speed=" + speed + ", price=" + price + "]";
    }
}
