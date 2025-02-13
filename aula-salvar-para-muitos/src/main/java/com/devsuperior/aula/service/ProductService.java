package com.devsuperior.aula.service;


import com.devsuperior.aula.dto.CategoryDTO;
import com.devsuperior.aula.dto.ProductDTO;
import com.devsuperior.aula.entities.Category;
import com.devsuperior.aula.entities.Product;
import com.devsuperior.aula.repositories.CategoryRepository;
import com.devsuperior.aula.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private CategoryRepository categoryRepository;

    public ProductDTO insert(@RequestBody ProductDTO dto) {
        Product product = new Product();

        product.setName(dto.getName());
        product.setPrice(dto.getPrice());

        for (CategoryDTO catDTO : dto.getCategories()) {
            Category category = categoryRepository.getReferenceById(catDTO.getId());
            product.getCategories().add(category);
        }
        product = repository.save(product);
        return new ProductDTO(product);

    }
}
