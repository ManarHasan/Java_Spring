package com.axsos.categoriesproduct.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.axsos.categoriesproduct.models.Category;
import com.axsos.categoriesproduct.models.CategoryProduct;
import com.axsos.categoriesproduct.models.Product;
import com.axsos.categoriesproduct.repositories.CategoryRepository;
import com.axsos.categoriesproduct.repositories.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;

	public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}
	
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}
	
	public Product findProduct(Long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        } else {
            return null;
        }
	}
	public List<Category> findCategoriesNotInProduct(Product product){
		return categoryRepository.findByProductsNotContains(product);
	}
}
