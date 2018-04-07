package com.cyan.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyan.dao.EmployeeDao;
import com.cyan.entity.Employee;
import com.cyan.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	@Transactional
	public Employee getEmployee(String username) {
		if(employeeDao.getEmployeeByUsername(username).isEmpty()) {
			return null;
		}else {
			return employeeDao.getEmployeeByUsername(username).get(0);
		}
		
	}

}
