package com.cyan.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cyan.dao.EmployeeDao;
import com.cyan.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Employee> getEmployeeByUsername(String username) {
		
		String hql = "from Employee where username=?";
		
		return sessionFactory.getCurrentSession().createQuery(hql).setString(0, username).list();
		
	}

}
