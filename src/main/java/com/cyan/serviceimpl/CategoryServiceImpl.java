package com.cyan.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyan.dao.CategoryDao;
import com.cyan.entity.Category;
import com.cyan.entity.Department;
import com.cyan.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	@Transactional
	public List<Category> retrieveAllCategories() {
		return categoryDao.getAllCategories();
	}

	@Override
	@Transactional
	public boolean insertCategory(Category category) {
		categoryDao.insert(category);
		return true;
	}

	@Override
	@Transactional
	public boolean deleteCategory(Integer categoryId) {
		categoryDao.delete(categoryId);
		return true;
	}

	@Override
	@Transactional
	public boolean updateCategory(Category category) {
		categoryDao.update(category);
		return true;
	}

}
