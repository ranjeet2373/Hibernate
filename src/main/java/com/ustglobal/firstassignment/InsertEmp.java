package com.ustglobal.firstassignment;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ustglobal.firstassignment.dto.Emp;

public class InsertEmp {
	
	public static void main(String[] args) {
		
		Emp e = new Emp();
		e.setEid(3);
		e.setEname("Rahul");
		e.setSalary(35000);
		
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			
			entityTransaction.begin();
			entityManager.persist(e);
			System.out.println("record saved successfully!!!!!");
			entityTransaction.commit();
			
		}catch (Exception e1) {
			e1.printStackTrace();
			entityTransaction.rollback();
		}
		
		entityManager.close();
	}

}
