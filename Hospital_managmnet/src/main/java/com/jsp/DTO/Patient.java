package com.jsp.DTO;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Patient {
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
		private int p_id;
		private String p_name;
		private String p_diagnosis;
		private String p_adress;
		
		@ManyToOne
		Hospital hospital;
		
		@OneToMany
		List<MedicalRecord> medicalrecord;

		public int getP_id() {
			return p_id;
		}

		public void setP_id(int p_id) {
			this.p_id = p_id;
		}

		public String getP_name() {
			return p_name;
		}

		public void setP_name(String p_name) {
			this.p_name = p_name;
		}

		public String getP_diagnosis() {
			return p_diagnosis;
		}

		public void setP_diagnosis(String p_diagnosis) {
			this.p_diagnosis = p_diagnosis;
		}

		public String getP_adress() {
			return p_adress;
		}

		public void setP_adress(String p_adress) {
			this.p_adress = p_adress;
		}

		public Hospital getHospital() {
			return hospital;
		}

		public void setHospital(Hospital hospital) {
			this.hospital = hospital;
		}

		public List<MedicalRecord> getMedicalrecord() {
			return medicalrecord;
		}

		public void setMedicalrecord(List<MedicalRecord> medicalrecord) {
			this.medicalrecord = medicalrecord;
		}
		
}
