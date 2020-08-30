package project.com.enity;

public class Bookcase {
	private int bookCaseId;
	private String bookCaseName;
	
	public Bookcase() {
	    // TODO Auto-generated constructor stub
	}

	public Bookcase(int bookCaseId, String bookCaseName) {
	   super();
	   this.bookCaseId = bookCaseId;
	   this.bookCaseName = bookCaseName;
	}
	
	@Override
	  public String toString() {
	    return "bookCaseId=" + bookCaseId + ", bookCaseName=" + bookCaseName;
	  }
}
