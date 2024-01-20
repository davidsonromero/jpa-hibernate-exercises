package test.basic.manyToMany;

import model.basic.manyToMany.*;
import infra.*;
import java.util.List;
import java.util.ArrayList;

public class NewUncleNephew {
    public static void main(String[] args) {
        Uncle uncle1 = new Uncle("Bill Gates");
        Uncle uncle2 = new Uncle("Steve Jobs");
        Nephew nephew1 = new Nephew("Elon Musk");
        Nephew nephew2 = new Nephew("Mark Zuckerberg");

        List<Nephew> nephews = new ArrayList<Nephew>();
        nephews.add(nephew1);
        nephews.add(nephew2);

        List<Uncle> uncles = new ArrayList<Uncle>();
        uncles.add(uncle1);
        uncles.add(uncle2);

        nephew1.setUncles(uncles);
        nephew2.setUncles(uncles);

        uncle1.setNephews(nephews);
        uncle2.setNephews(nephews);

        DAO<DBEntity> dao = new DAO<>();

        dao.create(uncle1)
            .create(uncle2)
            .closeEntityManager();
    }
}
