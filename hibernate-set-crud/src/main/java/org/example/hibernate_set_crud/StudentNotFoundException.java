package org.example.hibernate_set_crud;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class StudentNotFoundException extends RuntimeException {
	private String message;

}
