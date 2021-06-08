package comm.model;

public class Book {
   private String authorName;
   private double costPrice;
   private double salePrice;
   private String title;
   private int pages;

   public Book() {

}

public Book(String authorName, double costPrice, double salePrice, String title, int pages) {

	this.authorName = authorName;
	this.costPrice = costPrice;
	this.salePrice = salePrice;
	this.title = title;
	this.pages = pages;
}


public String getAuthorName() {
	return authorName;
}

public void setAuthorName(String authorName) {
	this.authorName = authorName;
}

public double getCostPrice() {
	return costPrice;
}

public void setCostPrice(double costPrice) {
	this.costPrice = costPrice;
}

public double getSalePrice() {
	return salePrice;
}

public void setSalePrice(double salePrice) {
	this.salePrice = salePrice;
}

public int getPages() {
	return pages;
}

public void setPages(int pages) {
	this.pages = pages;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public double netProfit()
{
	return Math.round(this.salePrice - this.costPrice);
}

public double getTax()
{
	return netProfit()*0.05;
}



}
