package io.h2o.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.h2o.entity.User;
import io.h2o.repository.UserRepository;
import io.h2o.vo.Department;
import io.h2o.vo.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public User saveUser(User user) {
		log.info("inside saveUser method in userService: "+user);
		return userRepository.save(user);
	}

	public ResponseTemplateVO getUserWithDepartment(Long userId) {
		ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
		User user = userRepository.	findByUserId(userId);
		System.out.println("getUserWithDepartment:   "+user);
		Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(), Department.class);
		
		log.info("inside getUserWithDepartment method in userService: "+user);
		log.info("inside getUserWithDepartment method in userService: "+department);
		responseTemplateVO.setUser(user);
		responseTemplateVO.setDepartment(department);
		return responseTemplateVO;
	}

}
