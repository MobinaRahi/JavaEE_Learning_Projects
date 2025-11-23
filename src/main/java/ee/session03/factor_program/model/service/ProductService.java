package ee.session03.factor_program.model.service;

import ee.session03.factor_program.model.entity.Product;
import ee.session03.factor_program.model.repository.ProductRepository;

import java.util.List;
import java.util.Optional;


public class ProductService {
    public void SaveProduct(Product product) {
        ProductRepository productRepository = new ProductRepository();
        productRepository.save(product);
    }

    public void updateProduct(Product product) {
        ProductRepository productRepository = new ProductRepository();
        productRepository.update(product);
    }

    public void deleteProduct(Integer id) {
        ProductRepository productRepository = new ProductRepository();
        productRepository.delete(id);
    }

    public Optional<Product> getProduct(Integer id) {
        ProductRepository productRepository = new ProductRepository();
        return productRepository.findById(id);
    }

    public List<Product> getAllProducts() {
        ProductRepository productRepository = new ProductRepository();
        return productRepository.findAll();
    }

    public Optional<Product> getProductByName(String name) {
        ProductRepository productRepository = new ProductRepository();
        return productRepository.findByName(name);
    }
}
