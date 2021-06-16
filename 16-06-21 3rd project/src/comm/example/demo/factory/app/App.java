package comm.example.demo.factory.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.List;
import java.util.Random;

import comm.example.demo.factory.OrderFactory;
import comm.example.demo.model.Order;
import comm.example.demo.service.OrderService;
import comm.example.demo.service.OrderServiceImpl;

public class App {


	public static void main(String[] args) throws NumberFormatException, IOException, ClassNotFoundException {

		
		  OrderService service=new OrderServiceImpl(); 
		  OrderFactory factory=new OrderFactory();
		  int choice=0; 
		  InputStreamReader reader=null;
          BufferedReader bufferedReader=null;
		  
		  
          reader=new InputStreamReader(System.in); bufferedReader=new
        			 BufferedReader(reader); 
		  
		 
		  
		 do 
		 { 
			 System.out.println("1.Create A New Order.");
		    System.out.println("2.Display All Orders From List(in Memory).");
		  System.out.println("3.Save Orders To File.");
		  System.out.println("4. Display All Orders From File(order.ser)");
		 System.out.print("Your Choice");
		  choice=Integer.parseInt(bufferedReader.readLine()); switch (choice) { case 1:
		 System.out.print("Enter Order Quantity: "); int
		  quantity=Integer.parseInt(bufferedReader.readLine());
		  System.out.print("Order By: "); String orderBy=bufferedReader.readLine();
		  System.out.print("Order Name: "); String orderName=bufferedReader.readLine();
		  Order tempOrder=new Order(); tempOrder.setOrderId(new Random().nextInt());
		  tempOrder.setOrderDate(new Date()); tempOrder.setQuantity(quantity);
		  tempOrder.setOrderBy(orderBy); tempOrder.setOrderName(orderName); Order
		  o=service.createOrder(tempOrder);
		  System.out.println("Order Created Sucessfully..-->\n"+o+"\n"); break; case 2:
		  List<Order> list=service.getAllOrder(); for(Order order:list) {
		  System.out.println(order); } break; case 3: List<Order>
		  list1=service.getAllOrder(); System.out.println("saving orders please wait");
		  factory.saveOrder(list1); break; case 4: List<Order>
		  orderList=factory.displayAllOrders(); for(Order order:orderList) {
		  System.out.println(order); } break; case 0:
		  
		  System.out.println("Bye"); System.exit(0); break; default:
		  System.out.println("Invalid choice."); break; }
		  
		  } while (choice !=0);
		 
		
		 		 

		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("myfile.ser")));

		Order order=(Order)objectInputStream.readObject();
		System.out.println(order);

	}

}
