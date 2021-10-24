package me.skiincraft.api.products;

import me.skiincraft.api.products.models.Product;
import me.skiincraft.api.products.models.enums.ProductCategory;
import me.skiincraft.api.products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProductApiApplication.class, args);
	}

	private final ProductRepository repository;

	@Autowired
	public ProductApiApplication(ProductRepository repository) {
		this.repository = repository;
	}

	@Override
	// Como o banco de dados está em memória, ele ira gerar alguns dados prontos.
	public void run(String... args) {
		repository.save(new Product("Fatia de Torta", 2.99F, ProductCategory.FOOD));
		repository.save(new Product("Pão caseiro", 7.00F, ProductCategory.FOOD));
		repository.save(new Product("Motor", 3.99F, ProductCategory.AUTOMOTIVE));
		repository.save(new Product("Playstation 5", 3.99F, ProductCategory.HOME_APPLIANCES));
		repository.save(new Product("Cortador de unhas", 3.99F, ProductCategory.UTILITY));
	}
}
