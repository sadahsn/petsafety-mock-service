package com.daimler.hack.petsafety.response;

import java.util.List;

import org.springframework.validation.ObjectError;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class NotificationResponse {

	private String message_id;

	private String error;

	private List<ObjectError> errors;

	public String getMessage_id() {
		return message_id;
	}

	public void setMessage_id(String message_id) {
		this.message_id = message_id;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public List<ObjectError> getErrors() {
		return errors;
	}

	public void setErrors(List<ObjectError> errors) {
		this.errors = errors;
	}

	public NotificationResponse(String message_id, String error, List<ObjectError> errors) {
		super();
		this.message_id = message_id;
		this.error = error;
		this.errors = errors;
	}

	public NotificationResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "NotificationResponse [message_id=" + message_id + ", error=" + error + ", errors=" + errors + "]";
	}

}
