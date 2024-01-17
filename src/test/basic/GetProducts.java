package test.basic;

import infra.DAO;
import model.basic.Product;

public class GetProducts {
    public static void main(String[] args) {
        DAO<Product> dao = new DAO<>(Product.class);

        for(Product product : dao.findAll()) {
            System.out.println("Product: " + product.getName() + " - " + product.getDescription());
        }

        dao.closeEntityManager();
    }
}
