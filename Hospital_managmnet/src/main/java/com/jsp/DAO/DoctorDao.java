package com.jsp.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.DTO.Doctor;
import com.jsp.DTO.Hospital;

public class DoctorDao {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("QA");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();
	
	
	public void createDoctor(int hospitalid, Doctor doctor) {
		
		Hospital hospital = manager.find(Hospital.class, hospitalid);
		if(hospital != null) {
			List<Doctor> doctorlist = new ArrayList<Doctor>();
			doctorlist.add(doctor);
			
			transaction.begin();
			hospital.setDoctors(doctorlist);
			doctor.setHospital(hospital);
			manager.persist(doctor);
			manager.persist(hospital);
			transaction.commit();
			System.out.println("welcome Dr."+doctor.getDoc_name()+" to this Hospital");
		}
		else {
			System.out.println("Hospital id with "+hospitalid+" not found");
		}
			
		
	}
	
	public void updateDoctorSalary(int id, Double newsalary) {
		Query q = manager.createQuery("update Doctor d set d.doc_salary=:newsalary where d.doc_id =:id");
		q.setParameter("newsalary", newsalary);
		q.setParameter("id", id);
		
		
		transaction.begin();
		q.executeUpdate();
		transaction.commit();
	}
	
	public void removeDoctor(int id) {
		Doctor doctor =manager.find(Doctor.class, id);
		if(doctor != null) {
			
			transaction.begin();
			manager.remove(doctor);
			transaction.commit();
			
		}
		
	}
	
	public void viewDoctorByName(String name) {
		Query q = manager.createQuery("select d from Doctor d where d.doc_name = ?1");
		q.setParameter(1, name);
		List<Doctor> doctors = q.getResultList();
		
		for(Doctor d: doctors) {
		
			System.out.println(d.getDoc_id());
			System.out.println(d.getDoc_name());
			System.out.println(d.getDoc_qualification());
			System.out.println(d.getDoc_salary());
		}
		
	}
	
	public void viewDoctorSpecificHospital(Hospital hospital) {
		 List<Doctor> doctors = hospital.getDoctors();
		 
		 for(Doctor d : doctors) {
			 System.out.println("doctor id: "+d.getDoc_id());
			 System.out.println("doctor name: "+d.getDoc_name());
			 System.out.println("doctor Qualification: "+d.getDoc_qualification());
			 System.out.println("doctor salary: "+d.getDoc_salary());
		 }
		
	}
	

}
