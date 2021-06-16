package comm.example.demo.model;



import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Setter
@Getter
@ToString
@AllArgsConstructor
public class Order implements Serializable {
	private static final long serialVersionUID = 8187990866280259103L;
	private Integer orderId;
	private Date orderDate;
	private Integer quantity;
	private String orderName;
	private transient String orderBy;
	//private boolean iscompleted;

}
