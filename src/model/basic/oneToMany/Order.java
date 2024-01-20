package model.basic.oneToMany;

import infra.DBEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_orders")
public class Order implements DBEntity {

    public Order(Date date) {
        this.date = date;
    }

    public Order() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @Column
    private Date date;
    @OneToMany(mappedBy = "order", cascade = CascadeType.MERGE)
    private List<Item> items;
    public long getId() {
        return Id;
    }

    public List<Item> getItems() {
        return items;
    }
    public Date getDate() {
        return date;
    }

    public void setId(long Id) {
        this.Id = Id;
    }
    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
