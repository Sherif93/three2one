package com.three2one.assessement.Exception;

public class StudentOrCourseException extends Exception {

	private static final long serialVersionUID = 1L;
	private String msg;

	public StudentOrCourseException() {
	}

	public StudentOrCourseException(String message) {
		super(message);
		this.setMsg(message);
	}

	public StudentOrCourseException(String message, Throwable cause) {
		super(message, cause);
		this.setMsg(message);
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
