package model.inheritance.joined;

import javax.persistence.*;

@Entity
public class iPhone extends Smartphone{
    private String color;

    public iPhone() {
    }

    public iPhone(Long id, String name, Double price, String color) {
        super(id, name, "Apple", price);
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

    public iPhone setColor(String color) {
        this.color = color;
        return this;
    }
}
