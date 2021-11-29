package com.wdf.springmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer userId;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;

	@Enumerated(EnumType.STRING)
	@Column(name = "gender")
	private Gender gender;

	@Column(name = "mobile_number")
	private Long mobileNumber;

	@Column(name = "email_id")
	private String emailId;
	private String role;
	/*
	 * @OneToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "address_id") private Address address;
	 * 
	 * @OneToOne
	 * 
	 * @JoinColumn(name = "company_name") private Company company;
	 */
	@NotEmpty
	private String password;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	/*
	 * public Company getCompany() { return company; }
	 * 
	 * public void setCompany(Company company) { this.company = company; }
	 */

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/*
	 * public Address getAddress() { return address; }
	 * 
	 * public void setAddress(Address address) { this.address = address; }
	 */

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User() {
	}

	public User(Integer userId, String firstName, String lastName, Gender gender, Long mobileNumber, String emailId,
			String role, String password) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.role = role;
		this.password = password;
	}

}
