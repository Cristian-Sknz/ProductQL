package me.skiincraft.api.products.controller;

import me.skiincraft.api.products.models.Product;
import me.skiincraft.api.products.models.dto.ProductDTO;
import me.skiincraft.api.products.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequestMapping(path = "/api")
@RestController
public class ProductController {

    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping(value = "/produtos")
    public ResponseEntity<Collection<Product>> getProducts() {
        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping(value = "/produtos/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable(name = "id") long id) {
        Product product = service.getProduct(id);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping(value = "/produtos")
    public ResponseEntity<Product> addProduct(@RequestBody ProductDTO dto) {
        return new ResponseEntity<>(service.createProduct(dto), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/produtos/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable(name = "id") int id) {
        return ResponseEntity.ok(null);
    }
}
