package com.example.spring_hibernate_integration;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.spring_hibernate_integration.model.Book;
import com.example.spring_hibernate_integration.repo.BookNotFoundException;
import com.example.spring_hibernate_integration.service.BookService;
import com.example.spring_hibernate_integration.service.BookServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try {
    	ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = context.getBean("bookServiceImpl",BookServiceImpl.class);
        

        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        int choice=0;
		String bookName=null;
		double bookPrice=0.0;
        
		do {
			System.out.println("1.Add A New Book");
			System.out.println("2.Display All Book");
			System.out.println("3.Find Book By ID");
			System.out.println("4.Update Book");
			System.out.println("5.Delete the book");
			System.out.println("0: Exit");
			System.out.print("your choice: ");
			choice=Integer.parseInt(bufferedReader.readLine());
			switch (choice) {
			case 1:
				System.out.print("Book Name: ");
				bookName=bufferedReader.readLine();
				System.out.println("Book Price: ");
				bookPrice=Double.parseDouble(bufferedReader.readLine());
				System.out.println(bookService.createBook(new Book(new Random().nextInt(1000),bookName,bookPrice)));
				break;
			case 2:
				List<Book> list= bookService.getAllBook();
				for(Book book:list)
				{
					System.out.println(book);
				}
				break;
			
			case 3:
				System.out.print("Book Id: ");
				int id1 = Integer.parseInt(bufferedReader.readLine());
				Book book1 = bookService.findbyId(id1);
				System.out.println(book1);
				break;
			case 4:
				try {

					System.out.print("Book Id: ");
					int id = Integer.parseInt(bufferedReader.readLine());
					bookService.updateBook(id);
					System.out.println("updated");
				}

				catch (BookNotFoundException e) {
					System.err.println(e.getMessage());
				}
				
				break;
			
			case 5:
				
				System.out.print("Book Id: ");
				int id2 = Integer.parseInt(bufferedReader.readLine());
				bookService.deleteBook(id2);
				System.out.println("deleted");
				break;

			default:
				break;
			}
			
		} while (choice!=0);
		
		
        }catch (Exception e) {
			// TODO: handle exception
        	e.printStackTrace();
		}
    
    
    
    }
}