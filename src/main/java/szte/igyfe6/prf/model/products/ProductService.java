package szte.igyfe6.prf.model.products;

import szte.igyfe6.prf.model.products.Product;

import java.util.List;

public interface ProductService {
    void addProduct(Product product);
    List<Product> getProducts();
    Product getProductById(int id);
    void deleteProductById(int id);
    void sellProduct(int productId);
}
