package io.h2o.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.h2o.entity.Department;
import io.h2o.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/departments")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;

	@PostMapping("/")
	public Department saveDepartment(@RequestBody Department department) {
		log.info("inside saveDepartment method of departmentController: "+department);
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping("/{id}")
	public Department findByDepartmentId(@PathVariable("id") Long departmentId) {
		log.info("inside findDepartmentById method of departmentController: "+departmentId);
		return departmentService.findByDepartmentId(departmentId);
	}
	
}
