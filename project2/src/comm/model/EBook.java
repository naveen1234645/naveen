package comm.model;

public class EBook extends Book {
   private String downloadSite;
   private double sizeMB;

public EBook() {
	super();
}

public EBook(String authorName, double costPrice, double salePrice, String title, int pages, String downloadSite,
		double sizeMB) {
	super(authorName, costPrice, salePrice, title, pages);
	this.downloadSite = downloadSite;
	this.sizeMB = sizeMB;
}

public String getDownloadSite() {
	return downloadSite;
}
public void setDownloadSize(String downloadSite) {
	this.downloadSite = downloadSite;
}
public double getSizeMB() {
	return sizeMB;
}
public void setSizeMB(double sizeMB) {
	this.sizeMB = sizeMB;
}


 public double pageSize()
 {
	 return getSizeMB()/getPages();
 }

 public String printTitle()
 {
	 return getTitle();
 }
@Override
public double getTax() {
	// TODO Auto-generated method stub
	return super.getTax();
}


}