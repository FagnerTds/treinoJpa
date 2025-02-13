package com.devsuperior.aula.dto;

import com.devsuperior.aula.entities.Category;
import com.devsuperior.aula.entities.Product;


import java.util.HashSet;
import java.util.Set;

public class ProductDTO {

    private Long id;
    private String name;
    private Double price;
    private Set<CategoryDTO> categories = new HashSet<>();

    public ProductDTO(Long id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public ProductDTO(Product entity) {
        id = entity.getId();
        name = entity.getName();
        price = entity.getPrice();

        for (Category cat : entity.getCategories()) {
            categories.add(new CategoryDTO(cat));
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Set<CategoryDTO> getCategories() {
        return categories;
    }
}
