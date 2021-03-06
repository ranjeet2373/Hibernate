package com.ustglobal.firstassignment;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ustglobal.firstassignment.dto.Emp;

public class DeleteEmp {
	
	public static void main(String[] args) {
		
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			
			entityTransaction.begin();
			
			Emp e = entityManager.find(Emp.class, 1);
			entityManager.remove(e);
			
			System.out.println("record deleted successfully!!!");
			
			entityTransaction.commit();
		}catch (Exception e) {
			
			e.printStackTrace();
			entityTransaction.rollback();
		}
		
		entityManager.close();
	}

}
