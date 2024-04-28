package com.jsp.CONTROLLER;

import java.util.*;

import com.jsp.DAO.DoctorDao;
import com.jsp.DAO.HospitalDao;
import com.jsp.DAO.MedicalRecordDao;
import com.jsp.DAO.PatientDao;
import com.jsp.DTO.Doctor;
import com.jsp.DTO.Hospital;
import com.jsp.DTO.MedicalRecord;
import com.jsp.DTO.Patient;

public class Controller {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	HospitalDao hos = new HospitalDao();
	DoctorDao doc = new DoctorDao();
	PatientDao pat = new PatientDao();
	MedicalRecordDao med = new MedicalRecordDao();
	
	while(true) {
		System.out.println("======WELCOME========");
		System.out.println("Make your choice");
		System.out.println("1.Hospital\n2.Doctor\n3.Patient\n4.MedicalRecord\n5.Exist");
		System.out.println("Enter your choice here");

		int value = sc.nextInt();
		
		switch(value) {
		
		case 1:
				while(true) {
					System.out.println("-----------welcome to Hospital Section-----------");
					System.out.println("Make your choice");
					System.out.println("1.Create_Hospital\n2.Update_Hospital_Name\n3.Remove_Hospital\n4.View_HospitalByName\n5.View_AllHospital\n6.Exist");
					System.out.println("Enter your choice here");
						int choice = sc.nextInt();
					switch(choice) {
						
					case 1:
						
						
						System.out.println("Enter the name of Hospital");
						String name = sc.next();
						
						System.out.println("Enter the address of Hospital");
						String address = sc.nextLine();
						
						System.out.println("Enter the city of Hospital");
						String city = sc.nextLine();
						

						Hospital h = new Hospital();
						h.setHos_name(name);
						h.setHos_address(address);
						h.setHos_city(city);
						
						hos.createHospital(h);
						
						break;	
						
					case 2:
						System.out.println("Enter the id of Hospital ");
						int id = sc.nextInt();
						sc.nextLine(); 
						System.out.println("Enter the newname of Hospital");
						String newname = sc.nextLine();
						
						hos.updateHospitalName(id,newname);
						
						break;	
					case 3:
						System.out.println("Enter the id of Hospital ");
						int id_remove = sc.nextInt();
						hos.removeHospital(id_remove);
						
						
						break;	
					case 4:
						System.out.println("Enter the name of Hospital");
						String name_h = sc.next();
						
						
						hos.viewHospitalByName(name_h);
						break;
					case 5:
						hos.viewAllHospitals() ;
						break;
					case 6:
						System.out.println("----- THANK YOU ------");
						return;
					
					}
				
					 
				}
		      	
					
		case 2:
			while(true) {
				System.out.println("-----------welcome to Doctor Section-----------");
				System.out.println("Make your choice");
				System.out.println("1.Create_Doctor\n2.Update_Doctor_Salary\n3.Remove_Doctor\n4.View_DoctorByName\n5.View_Doctor_SpecificHospital\n6.Exist");
				System.out.println("Enter your choice here");
					int choice = sc.nextInt();
					
				switch(choice) {
				
				case 1:
					System.out.println("Enter Hospital_Id ");
					int h_id = sc.nextInt();
					
					System.out.println("Enter Doctor name");
					String d_name = sc.next();
					
					System.out.println("Enter Doctor Qualification");
					String d_qualification = sc.next();
					
					System.out.println("Enter Doctor Salary");
					double d_salary = sc.nextDouble();
					
					Doctor d = new Doctor();
					
					d.setDoc_name(d_name);
					d.setDoc_qualification(d_qualification);
					d.setDoc_salary(d_salary);
					
					doc.createDoctor(h_id, d);
					
					
					break;
				case 2:
					System.out.println("Enter the doctor_id");
					int d_id = sc.nextInt();
					System.out.println("Enter the salary");
					Double update_salary = sc.nextDouble();
					
					doc.updateDoctorSalary(d_id, update_salary);	
					break;
					
				case 3:
					System.out.println("Enter the doctor_id");
					int remove_id = sc.nextInt();
					
					doc.removeDoctor(remove_id);
					
					break;	
				case 4:
					System.out.println("Enter Doctor name");
					String viwe_name = sc.next();
					
					doc.viewDoctorByName(viwe_name);
					
					break;
				case 5:
			
					System.out.println("Enter the Hospital Name :\n");
					String hosName = sc.next();
					
					List<Hospital> hosDetailsByName = hos.viewHospitalName(hosName);
					
					Hospital hp = new Hospital();
					
					for(int i=0;i<hosDetailsByName.size();i++)
					{
						hp.setDoctors(hosDetailsByName.get(i).getDoctors());
					}
					
					doc.viewDoctorSpecificHospital(hp);
					
					break;	
				case 6:
					System.out.println("------- THANK YOU -------");
					return;	
					
				}			
			}
			
		case 3:
				while(true) {
					System.out.println("-----------welcome to Patient Section-----------");
					System.out.println("Make your choice");
					System.out.println("1.Create_Patient\n2.removePatient\n3.viwe_PatientByName\n4.viwe_PatientByName\n5.Exist");
					System.out.println("Enter your choice here");
						int choice = sc.nextInt();
						
						switch(choice) {
						case 1:
							System.out.println("Enter Hospital_Id ");
							int h_id = sc.nextInt();
							
							System.out.println("Enter patient name");
							String p_name = sc.next();
							
							System.out.println("Enter patient Diagnosis");
							String p_diagnisis = sc.next();
							
							System.out.println("Enter patient address");
							String p_address= sc.next();
							
							Patient p = new Patient();
							p.setP_name(p_name);
							p.setP_diagnosis(p_diagnisis);
							p.setP_adress(p_address);
							
							pat.createPatient(h_id,p);
							
							break;
						case 2:
							System.out.println("Enter the patient id");
							int p_id = sc.nextInt();
							
							pat.removePatient(p_id);
							
							break;
							
						case 3:
							System.out.println("Enter patient name");
							String viwe_name = sc.next();
							
							pat.viwePatientByName(viwe_name);
							
							break;
						case 4:
							pat.viewAllPatient();
							
							break;
						case 5:
							System.out.println("-------- THANK YOU -------");
							break;
						}
						
				}
		case 4:
			while(true) {
				System.out.println("-----------welcome to MedicalReport Section-----------");
				System.out.println("Make your choice");
				System.out.println("1.Create_record\n2.Update_DateOfExamination\n3.Remove_MedicalRecord\n4.viwe_ReportByPatientName\n5.Exist");
				System.out.println("Enter your choice here");
					int choice = sc.nextInt();
					
					switch(choice) {
					case 1:
						System.out.println("Enter patient id:");
						int p_id = sc.nextInt();
						
						System.out.println("State the problem:");
						String problem = sc.next();
						
						System.out.println("Enter the date_of_Examination:");
						String DOE = sc.next();
						
						MedicalRecord m = new MedicalRecord();
						
						m.setProblem(problem);
						m.setDate_of_examination(DOE);
						
						med.createMedicalRecord(p_id, m);
						break;
					case 2:
						System.out.println("Enter the record id");
						int id = sc.nextInt();
						System.out.println("Enter the date of examination");
						String new_DOE = sc.next();
						
						med.updateDOE(id, new_DOE);
						break;
					case 3:
						System.out.println("Enter the record id");
						int remove_id = sc.nextInt();
						
						med.removeMedicalRecord(remove_id);
						break;
					case 4:
						System.out.println("Enter the Patient Name :\n");
						String patName = sc.next();
						
						List<Patient> patientDetails = pat.viewPatientName(patName);
						
						Patient p = new Patient();
						
						for(int i=0;i<patientDetails.size();i++)
						{
							p.setMedicalrecord(patientDetails.get(i).getMedicalrecord());
						}
						
						med.viewMedicalReportSpecificPatient(p);
						break;
					}
					
			}
		
		case 5:
			System.out.println("------ THANK YOU -------");
			return;
		
		
			
			
		}
		
	}

}
}
