package model.basic.manyToMany;

import infra.DBEntity;

import javax.persistence.*;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_NEPHEW")
public class Nephew implements DBEntity {
    public Nephew() {
    }
    public Nephew(String name) {
        this.name = name;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @ManyToMany(mappedBy = "nephews")
    private List<Uncle> uncles = new ArrayList<>();

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Uncle> getUncles(){
        return this.uncles;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUncles(List<Uncle> uncles){
        this.uncles = uncles;
    }
}
