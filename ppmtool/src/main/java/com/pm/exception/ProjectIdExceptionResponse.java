package com.pm.exception;

public class ProjectIdExceptionResponse {

	private String projectIdentifier;
	public ProjectIdExceptionResponse(String message) {
		this.projectIdentifier = message;
	}
	public String getProjectIdentifier() {
		return projectIdentifier;
	}
	public void setProjectIdentifier(String projectIdentifier) {
		this.projectIdentifier = projectIdentifier;
	}
}
