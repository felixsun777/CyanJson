package com.cyan.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cyan.dao.DepartmentDao;
import com.cyan.entity.Department;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insert(Department department) {
		sessionFactory.getCurrentSession().save(department);
		}

	@Override
	public void update(Department department) {
		sessionFactory.getCurrentSession().update(department);
	}

	@Override
	public void delete(Integer departmentId) {
		Department department = (Department) sessionFactory.getCurrentSession().load(Department.class,departmentId);
		sessionFactory.getCurrentSession().delete(department);
	}

	@Override
	public Department getDepartment(Integer departmentId) {
		return (Department) sessionFactory.getCurrentSession().get(Department.class,departmentId);
	}

	@Override
	public List<Department> getAllDepartments() {
		return sessionFactory.getCurrentSession().createQuery("from Department").list();
	}

}
