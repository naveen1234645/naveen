package comm.model.test;

import comm.model.Book;
import comm.model.EBook;

public class TestBook
{
	public static void main(String[] args){                  
		// Main Method - Only this method gets executed
		//Create a Book object
		Book book1 = new Book("Gary", 8.99, 19.99, "How to get rich", 100);  
		//Fetch Book Class specific fields from this book
		System.out.println(" Book Details 1a) Author: " + book1.getAuthorName() + " | cost price: "+ book1.getCostPrice() +" | sale price:"
				+ book1.getSalePrice() +" | pages: "+ book1.getPages()  +" | title: " + book1.getTitle()+"\n");
		//Get Profit and Tax
		System.out.println(" 1a) Author " + book1.getAuthorName() + " nets a per-book profit of $" + book1.netProfit() + " and a tax of $" + book1.getTax());
		//Create an e-book object
		EBook book2 = new EBook("Seth Devilin", 10.0, 23.0, "Bad habits that lead to success", 200, "Amazon", 80.0);
		//Fetch Book Class specific fields from this ebook
		System.out.println(" EBook Details 2a) Author: " + book2.getAuthorName() + " | cost price: "+ book2.getCostPrice() +" | sale price:"
				+ book2.getSalePrice() +" | pages: "+ book2.getPages() +" | title: " + book2.getTitle()+"\n");
		//Get Profit and Tax
		System.out.println(" 2b) Author " + book2.getAuthorName() + " nets a per-book profit of $" + book2.netProfit() + " and a tax of $" + book2.getTax());
		//Get per page size
		System.out.println(" 2c) Book: "+ book2.printTitle() + " has a per-page size of " + book2.pageSize() +" MB\n");
	}
}