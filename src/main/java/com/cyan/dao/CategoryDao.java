package com.cyan.dao;

import java.util.List;

import com.cyan.entity.Category;


public interface CategoryDao {

	public void insert(Category category);
	public void update(Category category);
	public void delete(Integer categoryId);
	public Category getDepartment(Integer categoryId);
	public List<Category> getAllCategories();
	
}
