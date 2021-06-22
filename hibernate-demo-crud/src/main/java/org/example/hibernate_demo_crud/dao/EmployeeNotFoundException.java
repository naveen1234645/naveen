package org.example.hibernate_demo_crud.dao;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class EmployeeNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -8095768362454806353L;
	private String message;

}
