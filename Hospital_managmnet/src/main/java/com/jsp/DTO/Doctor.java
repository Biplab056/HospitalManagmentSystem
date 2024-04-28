package com.jsp.DTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Doctor {
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
		private int doc_id;
		private String doc_name;
		private String doc_qualification;
		private double doc_salary;
		
		@ManyToOne
		Hospital hospital;

		public int getDoc_id() {
			return doc_id;
		}

		public void setDoc_id(int doc_id) {
			this.doc_id = doc_id;
		}

		public String getDoc_name() {
			return doc_name;
		}

		public void setDoc_name(String doc_name) {
			this.doc_name = doc_name;
		}

		public String getDoc_qualification() {
			return doc_qualification;
		}

		public void setDoc_qualification(String doc_qualification) {
			this.doc_qualification = doc_qualification;
		}

		public double getDoc_salary() {
			return doc_salary;
		}

		public void setDoc_salary(double doc_salary) {
			this.doc_salary = doc_salary;
		}

		public Hospital getHospital() {
			return hospital;
		}

		public void setHospital(Hospital hospital) {
			this.hospital = hospital;
		}
		
		
}
