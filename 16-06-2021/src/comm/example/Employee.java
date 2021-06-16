package comm.example;



import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Employee implements Serializable{

	private int id;
	private String name;
	/*
	 * @Override public int compareTo(Object o) { // TODO Auto-generated method stub
	 * return 0; }
	 */

}
