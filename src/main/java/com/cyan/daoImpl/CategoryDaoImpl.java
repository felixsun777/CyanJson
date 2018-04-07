package com.cyan.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cyan.dao.CategoryDao;
import com.cyan.entity.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void insert(Category category) {
		sessionFactory.getCurrentSession().save(category);
	}

	@Override
	public void update(Category category) {
		sessionFactory.getCurrentSession().update(category);
	}

	@Override
	public void delete(Integer categoryId) {
		Category category = (Category) sessionFactory.getCurrentSession().load(Category.class, categoryId);
		sessionFactory.getCurrentSession().delete(category);
	}

	@Override
	public Category getDepartment(Integer categoryId) {
		return (Category) sessionFactory.getCurrentSession().get(Category.class, categoryId);
	}

	@Override
	public List<Category> getAllCategories() {
		return sessionFactory.getCurrentSession().createQuery("from Category").list();
	}

}
