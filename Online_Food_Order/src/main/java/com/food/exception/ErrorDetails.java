package com.food.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString
public class ErrorDetails {
	
	
	private LocalDateTime timestamp;
     private String message;
     private String description;
     
     
	

}
