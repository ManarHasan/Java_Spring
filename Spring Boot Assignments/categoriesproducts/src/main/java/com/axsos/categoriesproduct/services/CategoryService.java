package com.axsos.categoriesproduct.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.axsos.categoriesproduct.models.Category;
import com.axsos.categoriesproduct.models.CategoryProduct;
import com.axsos.categoriesproduct.models.Product;
import com.axsos.categoriesproduct.repositories.CategoryProductRepository;
import com.axsos.categoriesproduct.repositories.CategoryRepository;
import com.axsos.categoriesproduct.repositories.ProductRepository;


@Service
public class CategoryService {
	private final CategoryRepository categoryRepository;
	private final ProductRepository productRepository;
	private final CategoryProductRepository categoryProductRepository;
	

	public CategoryService(CategoryRepository categoryRepository, ProductRepository productRepository, CategoryProductRepository categoryProductRepository) {
		this.categoryRepository = categoryRepository;
		this.productRepository = productRepository;
		this.categoryProductRepository = categoryProductRepository;
	}
	
	public List<Category> findAll(){
		return categoryRepository.findAll();
	}
	
	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	public Category findCategory(Long id) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            return optionalCategory.get();
        } else {
            return null;
        }
    }
	public List<Product> findProductsNotInCategory(Category category){
		return productRepository.findByCategoriesNotContains(category);
	}
	
	public CategoryProduct createProductCategory(CategoryProduct categoryProduct) {
		return categoryProductRepository.save(categoryProduct);
	}
	
	
}
