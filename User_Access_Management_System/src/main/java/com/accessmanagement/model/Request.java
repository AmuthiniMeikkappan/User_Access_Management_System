package com.accessmanagement.model;

public class Request {
	
	private int requestId;
	private int userId;
	private String username;
	private int softwareId;
	private String softwareName;
	private String accessType;
	private String reason;
	private String status;
	
	public Request() {
		super();
	}
	
	public Request(String softwareName, String accessType, String reason) {
		super();
		this.softwareName = softwareName;
		this.accessType = accessType;
		this.reason = reason;
	}
	
	public Request(int userId,int softwareId, String accessType, String reason,String status) {
		super();
		this.userId = userId;
		this.softwareId = softwareId;
		this.accessType = accessType;
		this.reason = reason;
		this.status = status;
	}
	
	public Request(int requestId,int userId,String username,int softwareId, String softwareName, String accessType, String reason,String status) {
		super();
		this.requestId = requestId;
		this.userId = userId;
		this.username = username;
		this.softwareId = softwareId;
		this.softwareName = softwareName;
		this.accessType = accessType;
		this.reason = reason;
		this.status = status;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getAccessType() {
		return accessType;
	}

	public void setAccessType(String accessType) {
		this.accessType = accessType;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Request [softwareName=" + softwareName + ", accessType=" + accessType + ", reason=" + reason + "]";
	}
	
}
