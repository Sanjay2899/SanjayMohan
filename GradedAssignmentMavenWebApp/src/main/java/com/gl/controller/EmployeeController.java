package com.gl.controller;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.gl.dbModel.Employee;

@Controller
public class EmployeeController {
	
	@RequestMapping("/")
	public String welcome()
	{
		return"welcome";
	}
	@RequestMapping("/Employess-list")
	public String employeeList(Model data)
	{
SessionFactory seFactory=new Configuration().configure().buildSessionFactory();
		
		try {
			
			Session session=seFactory.openSession();
			Transaction tx=session.beginTransaction();
			
			Query q1=session.createQuery("from Employee ");
			List<Employee> employees=q1.getResultList();
			data.addAttribute("employees",employees);
			
			
			tx.commit();
			
		}
		catch (Exception e) {
			System.out.println("hibernate error :"+e.getMessage());
		}
		return "Employess-list";
	}
	@RequestMapping("/AddEmployee")
	public String addEmployee() {
		
		return "AddEmployee";
	}
	@PostMapping("/insert-employee")
	public String insertEmployee(@RequestParam String employeeName,@RequestParam String employeeAddress,@RequestParam String employeePhone,@RequestParam double employeeSalary)
	{
		
SessionFactory seFactory=new Configuration().configure().buildSessionFactory();
		
		try {
			
			Session session=seFactory.openSession();
			Transaction tx=session.beginTransaction();
			
			Employee e1=new Employee(employeeName, employeeAddress, employeePhone, employeeSalary);
			session.save(e1);
			
			
			tx.commit();
			
		}
		catch (Exception e) {
			System.out.println("hibernate error :"+e.getMessage());
		}
		return "welcome";
	}
	@RequestMapping("/update-employee-form")
	public String updateForm(@RequestParam int empid,Model data)
	{
SessionFactory seFactory=new Configuration().configure().buildSessionFactory();
		
		try {
			
			Session session=seFactory.openSession();
			Transaction tx=session.beginTransaction();
			
			Employee e1=session.get(Employee.class,empid);
			data.addAttribute("emp",e1);
			
			
			tx.commit();
			
		}
		catch (Exception e) {
			System.out.println("hibernate error :"+e.getMessage());
		}
		return"update-employee";
	}
	
	@PostMapping("/update-save-employee")
	public String updatesaveemployee(@RequestParam int empId,@RequestParam String employeeName,@RequestParam String employeeAddress,@RequestParam String employeePhone,@RequestParam double employeeSalary)
	{
		
SessionFactory seFactory=new Configuration().configure().buildSessionFactory();
		
		try {
			
			Session session=seFactory.openSession();
			Transaction tx=session.beginTransaction();
			
			Employee e1=new Employee(empId,employeeName, employeeAddress, employeePhone, employeeSalary);
			System.out.println(e1.getEmployeeName());
			session.update(e1);
			
			
			tx.commit();
			
		}
		catch (Exception e) {
			System.out.println("hibernate error :"+e.getMessage());
		}
		
		return"welcome";
	}
	
	@GetMapping("/delete-employee")
	public String deleteemployee(@RequestParam int empid)
	{
SessionFactory seFactory=new Configuration().configure().buildSessionFactory();
		
		try {
			
			Session session=seFactory.openSession();
			Transaction tx=session.beginTransaction();
			
			session.delete(new Employee(empid, null, null, null, 0));
			
			
			
			tx.commit();
			
		}
		catch (Exception e) {
			System.out.println("hibernate error :"+e.getMessage());
		}
		
		return"welcome";
	}

	
}


