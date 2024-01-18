package test.basic.ondeToMany;

import infra.DBEntity;
import infra.DAO;
import model.basic.oneToMany.Item;
import model.basic.oneToMany.Order;
import model.basic.Product;

public class NewOrder {
    DAO<DBEntity> dao = new DAO<>();
    public static void main(String[] args) {
        NewOrder newOrder = new NewOrder();
        Order order = new Order();
        order.setDate(new java.util.Date());
        Item item = new Item(10, 100.0, order);
        Product product = new Product("Pen", "Blue Pen", 1.0);
        item.setProduct(product);
        item.setOrder(order);
        newOrder.dao
                .create(product)
                .create(order)
                .create(item)
                .closeEntityManager();
    }
}
