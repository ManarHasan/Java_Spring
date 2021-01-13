package com.axsos.categoriesproduct.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.axsos.categoriesproduct.models.Category;
import com.axsos.categoriesproduct.models.CategoryProduct;
import com.axsos.categoriesproduct.models.Product;
import com.axsos.categoriesproduct.services.CategoryService;


@Controller
public class CategoryController {
	private final CategoryService categoryService;


	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	@RequestMapping("/categories/new")
	public String categoryForm(@ModelAttribute(name="category") Category category) {
		return "newCategory.jsp";
	}
	@RequestMapping(value="/category", method=RequestMethod.POST)
	public String addCategory(@Valid @ModelAttribute(name="category") Category category, BindingResult result) {
		if (result.hasErrors()) {
            return "newCategory.jsp";
        } else {
            categoryService.createCategory(category);
            return "redirect:/category/"+category.getId();
        }
	}
	@RequestMapping("/category/{id}")
	public String showCategory(@ModelAttribute(name="categories_product") CategoryProduct categoryProduct, @PathVariable("id")Long id, Model model){
        Category category = categoryService.findCategory(id);
        List <Product> products = categoryService.findProductsNotInCategory(category);
        List<Product> catProducts = category.getProducts();

        model.addAttribute("category",category);
        model.addAttribute("products",products);
        model.addAttribute("catProducts",catProducts);
        return "showCategory.jsp";
    }
	@RequestMapping("/addproduct")
	public String addProduct(@Valid @ModelAttribute(name="categories_product") CategoryProduct categoryProduct, BindingResult result) {
		if (result.hasErrors()) {
            return "newCategory.jsp";
        } else {
            categoryService.createProductCategory(categoryProduct);
            return "redirect:/";
        }
	}
	
	
	
}
