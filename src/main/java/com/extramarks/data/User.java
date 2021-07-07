package com.extramarks.data;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * This User class provides the attributes of a User object */


@Entity(name="user")               //to make user object ready for storage in JPA-based data store
public class User {
	@Id                               //to indicate id is the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)           //to indicate id gets automatically populated in data store
	private Long id;
	private String name;
	private String email;
	private String mobile;
	private String state;
	private String gender;
	private String skills;
	private String proimg;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	
	
	  
	  public String getProimg() {
		return proimg;
	}
	public void setProimg(String proimg) {
		this.proimg = proimg;
	}
	@Override public String toString() { return "User [id=" + id + ", name=" +
	  name + ", email=" + email + ", mobile=" + mobile + ", state=" + state +
	  ", gender=" + gender + ", skills=" + skills + ", image=" + proimg + "]";}
	 

}
