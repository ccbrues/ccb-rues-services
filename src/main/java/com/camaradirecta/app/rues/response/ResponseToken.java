package com.camaradirecta.app.rues.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_EMPTY)
public class ResponseToken {
	
	private Boolean success;
	private String message;
	private Integer code;
	private Object response;

	public ResponseToken(String message) {
		this.message = message;
	}
}
