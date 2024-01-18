package infra;

import model.basic.Product;

public class ProductDAO extends DAO<Product>{
    public ProductDAO() {
        super(Product.class);
    }

    public void applyDiscount(long id, double discount) {
        Product product = this.findById(id);
        product.setPrice(product.getPrice() * (1 - discount));
        this.update(product);
    }
}
