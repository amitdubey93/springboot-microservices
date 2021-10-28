package io.h2o.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.h2o.entity.Department;
import io.h2o.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	public Department saveDepartment(Department department) {
		log.info("inside saveDepartment method of departmentService: "+department);
		return departmentRepository.save(department);
	}

	public Department findByDepartmentId(Long departmentId) {
		log.info("inside findDepartmentById method of departmentService: "+departmentId);
		return departmentRepository.findByDepartmentId(departmentId);
	}


	
	
}
