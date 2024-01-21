package model.inheritance.joined;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type", length = 2, discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("SP")
public class Smartphone {
    @Id
    private Long id;

    private String name;

    private String brand;

    private Double price;

    public Smartphone() {
    }

    public Smartphone(Long id, String name, String brand, Double price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Smartphone setName(String name) {
        this.name = name;
        return this;
    }

    public String getBrand() {
        return this.brand;
    }

    public Smartphone setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public Double getPrice() {
        return this.price;
    }

    public Smartphone setPrice(Double price) {
        this.price = price;
        return this;
    }
}
