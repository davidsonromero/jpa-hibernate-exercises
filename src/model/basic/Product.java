package model.basic;

import javax.persistence.*;
import infra.DBEntity;
import model.basic.oneToMany.Item;
import java.util.List;

@Entity
@Table(name = "TB_PRODUCTS")
public class Product implements DBEntity {
    public Product() {
    }
    public Product(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "product", cascade = CascadeType.MERGE)
    private java.util.List<Item> items;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private double price;
    public void setId(long id) {
        this.id = id;
    }
    public void setItems(java.util.List<Item> items) {
        this.items = items;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public long getId() {
        return id;
    }
    public List<Item> getItems() {
        return items;
    }
    public String getName() {
        return name;
    }
    public String getDescription(){
        return description;
    }
    public double getPrice(){
        return price;
    }

    @Override
    public String toString(){
        return "%s - %s - %f".formatted(this.name, this.description, this.price);
    }
}
