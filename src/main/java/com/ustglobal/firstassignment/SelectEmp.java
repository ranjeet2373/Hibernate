package com.ustglobal.firstassignment;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ustglobal.firstassignment.dto.Emp;

public class SelectEmp {
	
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Emp e =entityManager.find(Emp.class, 2);
		
		System.out.println("Employee Id ="+e.getEid());
		System.out.println("Employee Name ="+e.getEname());
		System.out.println("Employee salary ="+e.getSalary());
		
		entityManager.close();
	}

}
