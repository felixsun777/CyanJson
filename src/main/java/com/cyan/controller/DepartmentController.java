package com.cyan.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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

import com.cyan.entity.Department;
import com.cyan.service.DepartmentService;


@RestController
@RequestMapping("/department")
@CrossOrigin
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("/departments")
	public List<Department> departments(HttpServletRequest request) {
		
		return departmentService.retrieveAllDepartments();
		
	}
	
	@PostMapping("/insert")
	public void insertDepartment(@ RequestBody Department department) {
		departmentService.insertDepartment(department);
	}
	
	@DeleteMapping("/delete/{departmentId}")
	public void deleteDepartment(@PathVariable Integer departmentId){
		departmentService.deleteDepartment(departmentId);
	}
	
	@PutMapping("/update")
	public void updateDepartment(@RequestBody Department department) {
		departmentService.updateDepartment(department);
	}
	
}
