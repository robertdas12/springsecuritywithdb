package com.security._2.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.security._2.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>{

	public Optional<Employee> findByEmail(String email);
}
