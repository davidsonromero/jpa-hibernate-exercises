package model.basic.manyToMany;

import infra.DBEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_UNCLE")
public class Uncle implements DBEntity {
    public Uncle(){
    }
    public Uncle(String name){
        this.name = name;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @ManyToMany(cascade = {CascadeType.ALL})
    private List<Nephew> nephews = new ArrayList<>();

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Nephew> getNephews(){
        return this.nephews;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNephews(List<Nephew> nephews){
        this.nephews = nephews;
    }
}
