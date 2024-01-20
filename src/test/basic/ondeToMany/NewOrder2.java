package test.basic.ondeToMany;

import infra.DBEntity;
import infra.DAO;
import infra.ProductDAO;
import model.basic.oneToMany.Item;
import model.basic.oneToMany.Order;
import model.basic.Product;

public class NewOrder2 {
    public static void main(String[] args) {
        DAO<DBEntity> dao = new DAO<>();
        ProductDAO daoProduct = new ProductDAO();
        Order order = new Order();
        order.setDate(new java.util.Date());
        Item item = new Item(10, 100.0, order);
        Product product = daoProduct.findById(1L);
        item.setProduct(product);
        item.setOrder(order);
        dao.create(order)
           .create(item)
           .closeEntityManager();
    }
}
