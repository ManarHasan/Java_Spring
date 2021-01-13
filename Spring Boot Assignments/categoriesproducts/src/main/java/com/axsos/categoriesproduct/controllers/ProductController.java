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
import com.axsos.categoriesproduct.services.ProductService;

@Controller
public class ProductController {
	private final ProductService productService;
	private final CategoryService categoryService;

	public ProductController(ProductService productService, CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}
	
	@RequestMapping("")
	public String root(Model model) {
		return "redirect:/products/new";
	}
	@RequestMapping("/products/new")
	public String productForm(@ModelAttribute(name="product") Product product) {
		return "newProduct.jsp";
	}
	@RequestMapping(value="/product", method=RequestMethod.POST)
	public String addProduct(@Valid @ModelAttribute(name="product") Product product, BindingResult result) {
		if (result.hasErrors()) {
            return "newProduct.jsp";
        } else {
            productService.createProduct(product);
            return "redirect:/product/"+product.getId();
        }
	}
	@RequestMapping("/product/{id}")
	public String showCategory(@ModelAttribute(name="categories_product") CategoryProduct categoryProduct, @PathVariable("id")Long id, Model model){
        Product product = productService.findProduct(id);
        List <Category> categories = productService.findCategoriesNotInProduct(product);
        List<Category> proCategories = product.getCategories();

        model.addAttribute("product",product);
        model.addAttribute("categories",categories);
        model.addAttribute("proCategories",proCategories);
        return "showProduct.jsp";
    }

	@RequestMapping("/addcategory")
	public String addProduct(@Valid @ModelAttribute(name="categories_product") CategoryProduct categoryProduct, BindingResult result) {
		if (result.hasErrors()) {
            return "newProduct.jsp";
        } else {
            categoryService.createProductCategory(categoryProduct);
            return "redirect:/";
        }
	}
}
