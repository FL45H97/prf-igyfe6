package szte.igyfe6.prf.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import szte.igyfe6.prf.model.products.Product;
import szte.igyfe6.prf.model.products.ProductService;

@RestController
@RequestMapping
@CrossOrigin(origins = "*")
public class ProductController {

    ProductService pService;

    @Autowired
    public ProductController(ProductService pService) {
        this.pService = pService;
    }

    @GetMapping("/")
    public String ping() {
        return "It Works!";
    }

    /**
     * A list of products
     * @return A list of all products
     */
    @GetMapping("/products")
    public List<Product> getProducts() {
        try {
            return this.pService.getProducts();
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    /**
     * Create a new product
     * @param p The new product object that should be inserted
     * @return A message on operation outcome.
     */
    @PostMapping(path="/product", consumes = "application/json")
    public String addProduct(@RequestBody Product p) {
        try {
            this.pService.addProduct(p);
            return "Product has been added.";
        } catch (Exception e) {
            System.err.println(e);
            return "Error during creating product.";
        }
    }

    /**
     * Get a specific product
     * @param pid The id of a product
     * @return the details of the product if exists
     */
    @GetMapping("/product")
    public Product getProduct(@RequestParam int pid) {
        try {
            return this.pService.getProductById(pid);
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    /**
     * Delete a product by id
     * @param pid The id of the product
     * @return A message on operation outcome.
     */
    @DeleteMapping("/product")
    public String deleteProduct(@RequestParam int pid) {
        try {
            this.pService.deleteProductById(pid);
            return "Product has been removed!";
        } catch (Exception e) {
            System.out.println(e);
            return "Error! Could not remove product.";
        }
    }
    
}