package model.basic.oneToOne;

import infra.DBEntity;

import javax.persistence.*;

@Entity
@Table(name = "tb_seats")
public class Seat implements DBEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String number;

    @OneToOne(mappedBy = "seat")
    private Client client;

    public long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public Client getClient(){
        return this.client;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setClient(Client client){
        this.client = client;
    }
}
