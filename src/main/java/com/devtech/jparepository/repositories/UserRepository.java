package com.devtech.jparepository.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devtech.jparepository.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query(		"SELECT 	obj "
			+ 	"FROM		User obj "
			+ 	"WHERE		obj.salary >= :minSalary "
			+ 	"	AND		obj.salary <= :maxSalary")
	Page<User> searchSalary(Double minSalary, Double maxSalary, Pageable pageable);
	
	Page<User> findBySalaryBetween(Double minSalary, Double maxSalary, Pageable pageable); // Método pronto do Query Methods do Spring JPA

	@Query(		"SELECT 	obj "
			+ 	"FROM		User obj "
			+ 	"WHERE		LOWER(obj.name) "
			+ 	"	LIKE	LOWER(CONCAT('%', :name, '%'))")
	Page<User> searchName(String name, Pageable pageable);
	
	Page<User> findByNameContainingIgnoreCase(String name, Pageable pageable); // Método pronto do Query Methods do Spring JPA
}
