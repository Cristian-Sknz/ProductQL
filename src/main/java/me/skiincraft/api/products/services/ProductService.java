package me.skiincraft.api.products.services;

import me.skiincraft.api.products.models.Product;
import me.skiincraft.api.products.models.dto.ProductDTO;
import me.skiincraft.api.products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProductService {

    private final ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Collection<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product getProduct(long id) {
        return repository.findById(id).orElse(null);
    }

    public Product createProduct(ProductDTO productDTO) {
        return repository.save(productDTO.toProduct());
    }

    public boolean deleteProduct(long productId) {
        if (repository.existsById(productId)) {
            repository.deleteById(productId);
            return true;
        }
        return false;
    }
}
