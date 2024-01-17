package test.basic;

import infra.DAO;
import model.basic.Product;

public class GetProduct {
    public static void main(String[] args) {
        DAO<Product> dao = new DAO<>(Product.class);

        Product product = dao.findById(1L);

        System.out.println("Product: " + product.getName());
    }
}
