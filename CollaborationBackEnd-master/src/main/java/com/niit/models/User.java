package com.niit.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;



@Component
@Entity
@Table(name="USERS1")
public class User extends BaseDomain {
	
	@Id
	@Column(name="USERID")
	private String id;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="USER_ROLE")
	private String userrole;
	
	@Column(name="DOB")
	private Date dob;
    
	@Column(name="FIRSTNAME")
	private String name;
	
	@Column(name="password")
	private String password;
	
	@Column(name="phoneno")
	private String phoneno;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="ISONLINE")
	private Character isOnline;
	
	@Column(name="profilepic")
	private String imagepath;

	@Transient
	private MultipartFile file; 
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserrole() {
		return userrole;
	}

	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

		public Character getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(Character isOnline) {
		this.isOnline = isOnline;
	}

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

		
}

