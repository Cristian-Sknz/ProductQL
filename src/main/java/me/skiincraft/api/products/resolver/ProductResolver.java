package me.skiincraft.api.products.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import me.skiincraft.api.products.models.Product;
import me.skiincraft.api.products.models.dto.ProductDTO;
import me.skiincraft.api.products.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class ProductResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    private final ProductService service;

    @Autowired
    public ProductResolver(ProductService service) {
        this.service = service;
    }

    public Collection<Product> getAllProducts() {
        return service.getAllProducts();
    }

    public Product getProductById(long id) {
        return service.getProduct(id);
    }

    public Product saveProduct(ProductDTO input) {
        return service.createProduct(input);
    }

    public boolean deleteProduct(long id) {
        return service.deleteProduct(id);
    }
}
