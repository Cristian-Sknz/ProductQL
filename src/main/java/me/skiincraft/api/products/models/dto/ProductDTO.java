package me.skiincraft.api.products.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import graphql.schema.GraphQLInputType;
import me.skiincraft.api.products.models.Product;
import me.skiincraft.api.products.models.enums.ProductCategory;

public class ProductDTO implements GraphQLInputType {

    @JsonProperty(value = "name")
    private String name;
    @JsonProperty(value = "price")
    private Float price;
    @JsonProperty(value = "category")
    private String category;

    public ProductDTO() {
    }

    public ProductDTO(String name, Float price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Product toProduct() {
        return new Product(this.name, this.price, ProductCategory.findByName(this.category));
    }

    @Override
    public String getName() {
        return name;
    }
}
