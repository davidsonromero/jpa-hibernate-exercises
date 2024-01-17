package test.basic;

import infra.DAO;
import model.basic.Product;

public class NewProduct {
    public static void main(String[] args) {
        Product product = new Product("Sandwich", "Big Mac", 5.0);

        DAO<Product> dao = new DAO<>(Product.class);
        dao.create(product).closeEntityManager();

        System.out.println("Product id: " + product.getId());
    }
}
