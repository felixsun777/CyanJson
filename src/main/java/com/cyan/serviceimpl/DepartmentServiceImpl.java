package com.cyan.serviceimpl;

import java.util.List;

import javax.persistence.TableGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyan.dao.DepartmentDao;
import com.cyan.entity.Customer;
import com.cyan.entity.Department;
import com.cyan.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentDao departmentDao;

	@Override
	@Transactional
	public List<Department> retrieveAllDepartments() {

		return departmentDao.getAllDepartments();
	}

	@Override
	@Transactional
	public boolean insertDepartment(Department department) {
		departmentDao.insert(department);
		return true;
	}
	
	@Override
	@Transactional
	public boolean deleteDepartment(Integer departmentId) {
		
		departmentDao.delete(departmentId);
		return true;
	}

	@Override
	@Transactional
	public boolean updateDepartment(Department department) {
		departmentDao.update(department);
		return true;
	}
	

}
