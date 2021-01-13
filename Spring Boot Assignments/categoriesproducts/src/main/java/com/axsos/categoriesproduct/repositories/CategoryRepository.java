package com.axsos.categoriesproduct.repositories;



import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.categoriesproduct.models.Category;
import com.axsos.categoriesproduct.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{
List<Category> findAll();
List<Category> findByProductsNotContains(Product product);
}
