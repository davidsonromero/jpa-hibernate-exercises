package model.basic.oneToMany;

import infra.DBEntity;
import model.basic.Product;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "tb_items")
public class Item implements DBEntity {
    public Item(int quantity, double price, Order order) {
        this.quantity = quantity;
        this.price = price;
        this.order = order;
    }
    public Item() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @Column
    private int quantity;
    @Column
    private Double price;
    @ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    private Order order;
    @ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    private Product product;

    public long getId() {
        return Id;
    }

    public int getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

    public Order getOrder() {
        return order;
    }

    public Product getProduct() {
        return product;
    }

    public void setId(long id) {
        Id = id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setProduct(Product product) {
        this.product = product;
        if(product != null && this.price == null){
            this.price = product.getPrice();
        }
    }

    @Override
    public String toString(){
        return "Quantity: %d - $%f - Order Number %d".formatted(this.quantity, this.price, this.order.getId());
    }
}
