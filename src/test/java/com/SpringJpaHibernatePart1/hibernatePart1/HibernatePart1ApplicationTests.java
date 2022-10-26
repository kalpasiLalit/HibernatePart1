package com.SpringJpaHibernatePart1.hibernatePart1;

import com.SpringJpaHibernatePart1.hibernatePart1.Entity.Employee;
import com.SpringJpaHibernatePart1.hibernatePart1.Repositry.EmployeeRepo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
class HibernatePart1ApplicationTests {
   @Autowired
	EmployeeRepo repositry;

	@Test
	void contextLoads() {
	}

	@Test
	void CreateTest(){
		Employee employee = new Employee();
		employee.setName("lalit");
		employee.setId(1);
		employee.setAge(22);
		employee.setLocation("pithoragarh");
		repositry.save(employee);
	}
    @Test
	public  void UpdateTest(){
		Employee employee = repositry.findById(1).get();
		employee.setLocation("Noida");
		repositry.save(employee);
	}

	@Test
	public  void deleteTest(){
		repositry.deleteById(1);
	}

	@Test
	public  void readTest(){
		Employee employee = repositry.findById(1).get();
		assertNotNull(employee);
		assertEquals("Noida",employee.getLocation());
	}

	@Test
	public void countTest(){
		System.out.println("****total rows: " + repositry.count() + " ******");
	}

//	@Test
//	public void pagableTest(){
//		Pageable pageable = new PageRequest(0,1);
//
//
//	}
	@Test
	public void findByNameTest(){
		List<Employee> employees = repositry.findByName("lalit");
		employees.forEach(e-> System.out.println(e.getLocation()));
	}

	@Test
	public void findByDescLikeTest(){
		List<Employee> employees = repositry.findByNameLike("A%");
		employees.forEach(e-> System.out.println(e.getLocation()));
	}

	@Test
	public void findByAgeBetween(){
		List<Employee> employees = repositry.findByAgeBetween(20,28);
		employees.forEach(e-> System.out.println(e.getName()));
	}
}
