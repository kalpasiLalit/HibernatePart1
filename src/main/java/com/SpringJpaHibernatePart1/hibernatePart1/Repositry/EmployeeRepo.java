package com.SpringJpaHibernatePart1.hibernatePart1.Repositry;

//import org.springframework.data.repository.CrudRepository;



import com.SpringJpaHibernatePart1.hibernatePart1.Entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
    List<Employee> findByName(String name);
    List<Employee> findByNameLike(String desc);
    List<Employee> findByAgeBetween(int age1,int age2);

    Page<Employee> findAllByAge(int age, Pageable pageable);
}

