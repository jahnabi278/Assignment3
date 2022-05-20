package com.terra.pojos;

public class ProcessInput {

	private String username;
	private long userContactNumber;
	private DefectiveComponentDetail defectiveComponent;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getUserContactNumber() {
		return userContactNumber;
	}

	public void setUserContactNumber(long userContactNumber) {
		this.userContactNumber = userContactNumber;
	}

	public DefectiveComponentDetail getDefectiveComponent() {
		return defectiveComponent;
	}

	public void setDefectiveComponent(DefectiveComponentDetail defectiveComponent) {
		this.defectiveComponent = defectiveComponent;
	}
}
