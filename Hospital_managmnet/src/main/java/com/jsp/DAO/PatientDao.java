package com.jsp.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.DTO.Hospital;
import com.jsp.DTO.Patient;

public class PatientDao {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("QA");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();
	
	public void createPatient(int hospitalid,Patient patient) {
		Hospital hospital = manager.find(Hospital.class, hospitalid);
		if(hospital != null) {
			
			List<Patient> patientlist = new ArrayList<Patient>();
			patientlist.add(patient);
			
			transaction.begin();
			hospital.setPatients(patientlist);
			patient.setHospital(hospital);
			manager.persist(patient);
			transaction.commit();
			System.out.println(patient.getP_name()+"added succesfully");
			
			
		}
		else {
			System.out.println("Hospital id with"+hospitalid+"not found");
		}
		
	}
	
	public void removePatient(int id) {
		Patient patient = manager.find(Patient.class, id);
		if(patient != null) {
			transaction.begin();
			manager.remove(patient);
			transaction.commit();
		}
	}
	
	public void viwePatientByName(String name) {
		Query q = manager.createQuery("select p from Patient p where p.p_name=:name");
		q.setParameter("name", name);
		List<Patient> patientlist = q.getResultList();
		
		for(Patient p :patientlist) {
			System.out.println(p.getP_id());
			System.out.println(p.getP_name());
			System.out.println(p.getP_adress());
			System.out.println(p.getP_diagnosis());
		}
	}
	
	public void viewAllPatient() {
		Query q = manager.createQuery("select p from Patient p");
		List<Patient> patientlist = q.getResultList();
		
		for(Patient p: patientlist) {
			
			System.out.println(p.getP_id());
			System.out.println(p.getP_name());
			System.out.println(p.getP_adress());
			System.out.println(p.getP_diagnosis());
		}
	}
	public List<Patient> viewPatientName(String pName)
	{
		Query q = manager.createQuery("select p from Patient p where p.p_name= ?1");
		q.setParameter(1, pName);
		List<Patient> patientDetails = q.getResultList();
		return patientDetails;
	}
	
}
