package com.rating.exception;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

public class ApiError {

	private HttpStatus status;
	private String message;
	private List<String> errorsList;
	
	public ApiError() {
		super();
	}
	
	public ApiError(final HttpStatus status, final String message, final List<String> errorsList) {
		this.status = status;
		this.message = message;
		this.errorsList = errorsList;
	}
	
	public ApiError(final HttpStatus status, final String message, final String error) {
		this.status = status;
		this.message = message;
		this.errorsList = Arrays.asList(error);
	}
	
	/**
	 * @return the status
	 */
	public HttpStatus getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the errorsList
	 */
	public List<String> getErrorsList() {
		return errorsList;
	}
	/**
	 * @param errorsList the errorsList to set
	 */
	public void setErrorsList(List<String> errorsList) {
		this.errorsList = errorsList;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((errorsList == null) ? 0 : errorsList.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ApiError other = (ApiError) obj;
		if (errorsList == null) {
			if (other.errorsList != null)
				return false;
		} else if (!errorsList.equals(other.errorsList))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (status != other.status)
			return false;
		return true;
	}
	
}
