package model.basic.oneToOne;

import infra.DBEntity;

import javax.persistence.*;

@Entity
@Table(name = "tb_clients")
public class Client implements DBEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "seat_id", unique = true)
    private Seat seat;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }
}
