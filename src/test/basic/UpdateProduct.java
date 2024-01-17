package test.basic;

import infra.DAO;
import model.basic.Product;

import java.util.ArrayList;
import java.util.List;

public class UpdateProduct {
    public static void main(String[] args) {
        DAO<Product> dao = new DAO<>(Product.class);
        List<Product> productsToUpdate = dao.findByName("Notebook");
        List<Product> updatedProducts = new ArrayList<>();
        for(Product product : productsToUpdate) {
            product.setName("Laptop");
            updatedProducts.add(dao.update(product));
        }
        updatedProducts.forEach(System.out::println);
        dao.closeEntityManager();
    }
}
