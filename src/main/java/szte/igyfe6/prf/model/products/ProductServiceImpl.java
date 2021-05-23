package szte.igyfe6.prf.model.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import szte.igyfe6.prf.model.products.Product;
import szte.igyfe6.prf.model.products.ProductRepository;
import szte.igyfe6.prf.model.products.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void addProduct(Product product) {
        this.productRepository.save(product);
    }

    @Override
    public List<Product> getProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public Product getProductById(int id) {
        return this.productRepository.findById(id).get();
    }

    @Override
    public void deleteProductById(int id) {
        this.productRepository.deleteById(id);
    }

    @Override
    public void sellProduct(int productId){
        Product product = getProductById(productId);
        product.setQuantity(product.getQuantity()-1);
        this.productRepository.save(product);
    }
    
}
