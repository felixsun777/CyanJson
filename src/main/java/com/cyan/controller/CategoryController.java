package com.cyan.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cyan.entity.Category;
import com.cyan.entity.Department;
import com.cyan.service.CategoryService;

@RestController
@RequestMapping("category")
@CrossOrigin
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/categories")
	public List<Category> categories(HttpServletRequest request) {
		return categoryService.retrieveAllCategories();
	}
	
	@PostMapping("/insert")
	public void insertCategory(@RequestBody Category category) {
		categoryService.insertCategory(category);
	}
	
	@DeleteMapping("/delete/{categoryId}")
	public void deleteCategory(@PathVariable Integer categoryId){
		categoryService.deleteCategory(categoryId);
	}
	
	
	@PutMapping("/update")
	public void updateCategory(@RequestBody Category category){
		categoryService.updateCategory(category);
	}
	
}
