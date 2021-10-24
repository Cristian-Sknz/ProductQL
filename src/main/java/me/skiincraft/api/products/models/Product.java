package me.skiincraft.api.products.models;

import me.skiincraft.api.products.models.enums.ProductCategory;

import javax.persistence.*;

@Entity
@Table(name = "db_produtos")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private float price;
    @Enumerated(EnumType.ORDINAL)
    private ProductCategory category;

    public Product() {}

    public Product(String name, float price, ProductCategory category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }
}
