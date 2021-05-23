package szte.igyfe6.prf.model.products;

import org.springframework.data.jpa.repository.JpaRepository;
import szte.igyfe6.prf.model.products.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    
}
