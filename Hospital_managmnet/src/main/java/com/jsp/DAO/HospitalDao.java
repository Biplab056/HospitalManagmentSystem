package com.jsp.DAO;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.DTO.Hospital;



public class HospitalDao {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("QA");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();
	
	
	
	public void createHospital(Hospital hospital) {
		
		
		transaction.begin();
		manager.persist(hospital);
		System.out.println(hospital.getHos_name()+" hospital is created");
		transaction.commit();
		
		
	}
	
	public void updateHospitalName(int id, String newname) {
	
		Hospital hospital =manager.find(Hospital.class, id);
		if(hospital != null) {
			
			
			transaction.begin();
			hospital.setHos_name(newname);
			manager.merge(hospital);
			transaction.commit();
			
		}
		else {
			System.out.println("Hospital dosen't exist....");
		}
	}
	
	public void removeHospital(int id) {
		
		Hospital hospital =manager.find(Hospital.class, id);
		if(hospital != null) {
			
			transaction.begin();
			manager.remove(hospital);
			transaction.commit();
			
		}
		
		
	}
	public void viewHospitalByName(String name) {
		
		Query q = manager.createQuery("select h from Hospital h where h.hos_name= ?1");
		q.setParameter(1, name);
		List<Hospital> hospitals = q.getResultList();
		
		 if (hospitals.isEmpty()) {
		        System.out.println("No hospitals found with the name: " + name);
		    } 
		 else {
		        System.out.println("Found hospitals with the name: " + name);
		        for (Hospital h : hospitals) {
		            System.out.println("Hospital ID: " + h.getHos_id());
		            System.out.println("Hospital Name: " + h.getHos_name());
		            System.out.println("Hospital Address: " + h.getHos_address());
		            System.out.println("Hospital City: " + h.getHos_city());
		        }
		    }
		
		
	}
	public void viewAllHospitals() {
		Query q = manager.createQuery("select h from Hospital h");
		List<Hospital> hospitals = q.getResultList();
		
		 if (hospitals.isEmpty()) {
		        System.out.println("No hospitals found");
		    } 
		 else {
		       
		        for (Hospital h : hospitals) {
		            System.out.println("Hospital ID: " + h.getHos_id());
		            System.out.println("Hospital Name: " + h.getHos_name());
		            System.out.println("Hospital Address: " + h.getHos_address());
		            System.out.println("Hospital City: " + h.getHos_city());
		            System.out.println("--------------------------");
		        }
		    }
	}
	
	public List<Hospital> viewHospitalName(String hName)
	{
		Query q = manager.createQuery("select h from Hospital h where h.hos_name= ?1");
		q.setParameter(1, hName);
		List<Hospital> hosDetails = q.getResultList();
		return hosDetails;
	}
	
	

}
