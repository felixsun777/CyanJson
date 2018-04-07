package com.cyan.dao;

import java.util.List;

import com.cyan.entity.Department;

public interface DepartmentDao {

	public void insert(Department department);
	public void update(Department department);
	public void delete(Integer departmentId);
	public Department getDepartment(Integer departmentId);
	public List<Department> getAllDepartments();
	
}
