package com.jsp.DTO;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Hospital {
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
		private int hos_id;
		private String hos_name;
		private String hos_address;
		private String hos_city;
		
		@OneToMany
		List<Doctor> doctors;
		
		@OneToMany
		List<Patient> patients;
		
		public int getHos_id() {
			return hos_id;
		}

		public void setHos_id(int hos_id) {
			this.hos_id = hos_id;
		}

		public String getHos_name() {
			return hos_name;
		}

		public void setHos_name(String hos_name) {
			this.hos_name = hos_name;
		}

		public String getHos_address() {
			return hos_address;
		}

		public void setHos_address(String hos_address) {
			this.hos_address = hos_address;
		}

		public String getHos_city() {
			return hos_city;
		}

		public void setHos_city(String hos_city) {
			this.hos_city = hos_city;
		}

		public List<Doctor> getDoctors() {
			return doctors;
		}

		public void setDoctors(List<Doctor> doctors) {
			this.doctors = doctors;
		}

		public List<Patient> getPatients() {
			return patients;
		}

		public void setPatients(List<Patient> patients) {
			this.patients = patients;
		}

		
		
		
		
}
