package com.aegon.ocr.exception;

import java.lang.reflect.Field;
import java.util.Date;

import lombok.Data;

@Data
public class ExceptionResponse {
	private Date timestamp;
	private String message;
	private String details;
	private int error_code;

	public ExceptionResponse(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public ExceptionResponse(Date timestamp, String message, String details, int error_code) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
		this.error_code = error_code;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getName());
		sb.append(": {");
		for (Field f : getClass().getDeclaredFields()) {
			sb.append(f.getName());
			sb.append("=");
			try {
				sb.append(f.get(this));
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sb.append(", ");
		}
		sb.append("}");
		return sb.toString();
	}
}
