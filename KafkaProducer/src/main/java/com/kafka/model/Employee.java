package com.kafka.model;

public class Employee {

	private Integer eId;
	private String eName;
	private String emailId;
	private Boolean ifProcessed;

	public Employee() {
	}

	public Employee(Integer eId, String eName, String emailId, Boolean ifProcessed) {
		super();
		this.eId = eId;
		this.eName = eName;
		this.emailId = emailId;
		this.ifProcessed = ifProcessed;
	}

	public Integer geteId() {
		return eId;
	}

	public void seteId(Integer eId) {
		this.eId = eId;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Boolean getIfProcessed() {
		return ifProcessed;
	}

	public void setIfProcessed(Boolean ifProcessed) {
		this.ifProcessed = ifProcessed;
	}

	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", eName=" + eName + ", emailId=" + emailId + ", ifProcessed=" + ifProcessed
				+ "]";
	}

}
