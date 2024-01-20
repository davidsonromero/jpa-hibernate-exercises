package test.basic.ondeToMany;

import model.basic.oneToMany.Item;
import infra.DAO;
import java.util.List;

public class GetOrders {
    public static void main(String[] args) {
        DAO<Item> dao = new DAO<>(Item.class);
        List<Item> items = dao.findAll();
        for (Item item : items) {
            System.out.println(item);
        }
    }
}
