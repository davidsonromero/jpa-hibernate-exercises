package test.basic;

import infra.DAO;
import model.basic.Product;
import java.util.List;

public class DeleteProduct {
    public static void main(String[] args) {
        DAO<Product> dao = new DAO<>(Product.class);
        List<Product> productsToDelete = dao.findByName("Sandwich");
        for(Product product : productsToDelete) {
            dao.delete(product.getId());
        }
        dao.closeEntityManager();
    }
}
