package com.jsp.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.DTO.MedicalRecord;
import com.jsp.DTO.Patient;

public class MedicalRecordDao {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("QA");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();
	
	public void createMedicalRecord(int patientid, MedicalRecord medicalrecord) {
		Patient patient = manager.find(Patient.class, patientid);
		if(patient!= null) {
			List<MedicalRecord> medicalrecordlist = new ArrayList<MedicalRecord>();
			medicalrecordlist.add(medicalrecord);
			
			transaction.begin();
			patient.setMedicalrecord(medicalrecordlist);
			medicalrecord.setPatient(patient);
			manager.persist(medicalrecord);
			transaction.commit();
			System.out.println("medical record of the patient "+patient.getP_name()+" added succesfully");
			
			
		}
		else {
			System.out.println("patient id with"+patientid+"not found");
		}
	}
	
	public void updateDOE(int id ,String DOE) {
		Query q = manager.createQuery("update MedicalRecord m set m.date_of_examination=:DOE where m.record_id =:id");	
		q.setParameter("DOE", DOE);
		q.setParameter("id", id);
		
		transaction.begin();
		q.executeUpdate();
		transaction.commit();	 
	}
	
	public void removeMedicalRecord(int id) {
		
		MedicalRecord medicalrecord = manager.find(MedicalRecord.class, id);
		
		if(medicalrecord != null) {
			transaction.begin();
			manager.remove(medicalrecord);
			transaction.commit();
		}
		
	}
	public void viewMedicalReportSpecificPatient(Patient patient) {
		List<MedicalRecord> medicalreportlist = patient.getMedicalrecord();
		
		for(MedicalRecord m :medicalreportlist ) {
			System.out.println("report id: "+m.getRecord_id());
			System.out.println("patient problem: "+m.getProblem());
			System.out.println("date of examonation: "+m.getDate_of_examination());
		}
	}
	
	
}
