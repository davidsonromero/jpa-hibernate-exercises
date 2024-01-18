package model.basic.oneToMany;

import infra.DBEntity;

import javax.persistence.*;
import java.util.Date;

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
    public long getId() {
        return Id;
    }

    public Date getDate() {
        return date;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
