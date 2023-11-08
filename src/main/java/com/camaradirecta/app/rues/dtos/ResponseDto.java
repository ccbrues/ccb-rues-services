package com.camaradirecta.app.rues.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {
	
	private Boolean success;
	private String message;
	private Integer code;
	private Object response;
	
	public ResponseDto(String message) {
		this.message = message;
	}
 
}
