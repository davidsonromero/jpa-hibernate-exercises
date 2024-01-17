package test.basic;

import infra.DAO;
import model.basic.Product;
import java.util.List;
import java.util.Scanner;

public class GetProductByName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        DAO<Product> dao = new DAO<>(Product.class);
        System.out.println("Enter the product name: ");
        String name = scanner.nextLine();

        List<Product> products = dao.findByName(name);

        for(Product product : products){
            System.out.println(product.getName());
        }

        dao.closeEntityManager();
        scanner.close();
    }
}
