package com.accolite.spring.entity;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="onboarding")
public class Onboarding {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	private int demandId;
	private String name;
	private String email;
	private String college;
	private int cgpa;
	private long personalNumber;
	private String permanentAddress;
	private String presentAddress;
	private String location;
	private String onboardingStart;
	private String eta;
	public Onboarding(int id, int demandId, String name, String email, String college, int cgpa, long personalNumber,
			String permanentAddress, String presentAddress, String location, String onboardingStart, String eta,
			String bgvCheck, String onboardingStatus, String skills) {
		super();
		this.id = id;
		this.demandId = demandId;
		this.name = name;
		this.email = email;
		this.college = college;
		this.cgpa = cgpa;
		this.personalNumber = personalNumber;
		this.permanentAddress = permanentAddress;
		this.presentAddress = presentAddress;
		this.location = location;
		this.onboardingStart = onboardingStart;
		this.eta = eta;
		this.bgvCheck = bgvCheck;
		this.onboardingStatus = onboardingStatus;
		this.skills = skills;
	}
	private String bgvCheck;
	private String onboardingStatus;
	private String skills;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDemandId() {
		return demandId;
	}
	public void setDemandId(int demandId) {
		this.demandId = demandId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public int getCgpa() {
		return cgpa;
	}
	public void setCgpa(int cgpa) {
		this.cgpa = cgpa;
	}
	public long getPersonalNumber() {
		return personalNumber;
	}
	public void setPersonalNumber(long personalNumber) {
		this.personalNumber = personalNumber;
	}
	public String getPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	public String getPresentAddress() {
		return presentAddress;
	}
	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getOnboardingStart() {
		return onboardingStart;
	}
	public void setOnboardingStart(String onboardingStart) {
		this.onboardingStart = onboardingStart;
	}
	public String getEta() {
		return eta;
	}
	public void setEta(String eta) {
		this.eta = eta;
	}
	public String getBgvCheck() {
		return bgvCheck;
	}
	public void setBgvCheck(String bgvCheck) {
		this.bgvCheck = bgvCheck;
	}
	public String getOnboardingStatus() {
		return onboardingStatus;
	}
	public void setOnboardingStatus(String onboardingStatus) {
		this.onboardingStatus = onboardingStatus;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	
	
	
	
	
	
	
	

}
