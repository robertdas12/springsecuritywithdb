package com.security._2.config;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.security._2.entity.Employee;
import com.security._2.repository.EmployeeRepo;

public class CustomUserDetailsService implements UserDetailsService{
	
	
	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	            Optional<Employee> user = employeeRepo.findByEmail(username);
	            if(user.isPresent()) {
	            	  Employee employee = user.get();
	            	  CustomUserDetail customUserDetail = new CustomUserDetail(employee);
	            	  return customUserDetail;
	            }
	            else {
	            	throw new UsernameNotFoundException("no such user found");
	            }
	}

}
