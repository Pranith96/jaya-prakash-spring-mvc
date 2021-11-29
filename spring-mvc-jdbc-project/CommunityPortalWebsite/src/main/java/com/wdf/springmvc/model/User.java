package com.wdf.springmvc.model;

public class User {

	private Integer userId;
	private String firstName;
	private String lastName;
	private String gender;
	private Long mobileNumber;
	private String emailId;
	private String role;
	private String plotNo;
	private String streeNo;
	private String colonyName;
	private String city;
	private String state;
	private String country;
	private String companyName;
	private String password;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPlotNo() {
		return plotNo;
	}

	public void setPlotNo(String plotNo) {
		this.plotNo = plotNo;
	}

	public String getStreeNo() {
		return streeNo;
	}

	public void setStreeNo(String streeNo) {
		this.streeNo = streeNo;
	}

	public String getColonyName() {
		return colonyName;
	}

	public void setColonyName(String colonyName) {
		this.colonyName = colonyName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public User(Integer userId, String firstName, String lastName, String gender, Long mobileNumber, String emailId,
			String role, String plotNo, String streeNo, String colonyName, String city, String state, String country,
			String companyName, String password) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.role = role;
		this.plotNo = plotNo;
		this.streeNo = streeNo;
		this.colonyName = colonyName;
		this.city = city;
		this.state = state;
		this.country = country;
		this.companyName = companyName;
		this.password = password;
	}

	public User() {
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", mobileNumber=" + mobileNumber + ", emailId=" + emailId + ", role=" + role + ", plotNo=" + plotNo
				+ ", streeNo=" + streeNo + ", colonyName=" + colonyName + ", city=" + city + ", state=" + state
				+ ", country=" + country + ", companyName=" + companyName + ", password=" + password + "]";
	}

}
