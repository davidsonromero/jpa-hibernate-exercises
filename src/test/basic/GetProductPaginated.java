package test.basic;

import infra.DAO;
import model.basic.Product;

import java.util.List;

public class GetProductPaginated {
    public static void main(String[] args) {
        DAO<Product> dao = new DAO<>(Product.class);

        List<Product> products = dao.findPaginated(0, 7);

        for(Product product : products) {
            System.out.println("Product: " + product.getName());
        }

        dao.closeEntityManager();
    }
}
