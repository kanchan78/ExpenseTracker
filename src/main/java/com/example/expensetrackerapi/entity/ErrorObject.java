package com.example.expensetrackerapi.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorObject {
	private Integer statusCode;
	private String message;
	private Long timestamp;

}
