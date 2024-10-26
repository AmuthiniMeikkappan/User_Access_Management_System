package com.accessmanagement.model;

public class Software {
	
	private int softwareId;
	private String softwareName;
	private String description;
	private String accessLevels;
	
	public Software() {
		super();
	}
	
	public Software(int softwareId,String softwareName, String description, String accessLevels) {
		super();
		this.softwareId = softwareId;
		this.softwareName = softwareName;
		this.description = description;
		this.accessLevels = accessLevels;
	}

	public Software(String softwareName, String description, String accessLevels) {
		super();
		this.softwareName = softwareName;
		this.description = description;
		this.accessLevels = accessLevels;
	}
	
	public int getSoftwareId() {
		return softwareId;
	}

	public void setSoftwareId(int softwareId) {
		this.softwareId = softwareId;
	}

	public String getSoftwareName() {
		return softwareName;
	}

	public void setSoftwareName(String softwareName) {
		this.softwareName = softwareName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAccessLevels() {
		return accessLevels;
	}

	public void setAccessLevels(String accessLevels) {
		this.accessLevels = accessLevels;
	}

	@Override
	public String toString() {
		return "Software [softwareId=" + softwareId +"softwareName=" + softwareName + ", description=" + description + ", accessLevels="
				+ accessLevels + "]";
	}
}
