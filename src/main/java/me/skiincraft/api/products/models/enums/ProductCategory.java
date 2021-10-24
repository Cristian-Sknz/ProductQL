package me.skiincraft.api.products.models.enums;

import java.util.Arrays;

public enum ProductCategory {

    FOOD(0, "Comida"),
    UTILITY(1, "Utilidade"),
    AUTOMOTIVE(2, "Automotivo"),
    HOME_APPLIANCES(3, "Eletrodoméstico"),
    UNDEFINED(4, "Indefinido");

    private int id;
    private String name;

    ProductCategory(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static ProductCategory findById(int id) {
        return Arrays.stream(values()).filter((category) -> category.id == id)
                .findFirst()
                .orElse(null);
    }

    public static ProductCategory findByName(String name) {
        return Arrays.stream(values()).filter((category) -> category.name().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
