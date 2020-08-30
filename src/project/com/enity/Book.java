package project.com.enity;

public class Book {
	private int id;
	private String bookName;
	private String author;
	private String brief;
	private String bookTitle;
	private String publisher;
	private String content;
	private String category;
	
	public Book() {
	    
	}

	public Book(int id, String bookName, String bookTitle, String author, String brief, String publisher, String content, String category) {
	   super();
	   this.id = id;
	   this.bookName = bookName;
	   this.bookTitle = bookTitle;
	   this.author = author;
	   this.brief = brief;
	   this.publisher = publisher;
	   this.content = content;
	   this.category = category;
	}

	
	
	public Book(int id, String bookName, String bookTitle, String author, String publisher, String category) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.bookTitle = bookTitle;
		this.author = author;
		this.publisher = publisher;
		this.category = category;
	}
	


	public Book(int id, String author, String brief, String bookTitle, String publisher,
			String content, String category) {
		super();
		this.id = id;
		this.bookTitle = bookTitle;
		this.author = author;
		this.brief = brief;
		this.publisher = publisher;
		this.content = content;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public void display () {
		System.out.println(this);
	}
	
	@Override
	  public String toString() {
	    return "id=" + id + ", Name =" + bookName + ", Author=" + author + ", Category=" + category 	+ ", Brief=" + brief + ", Title=" + bookTitle + ", publisher="
	        + publisher;
	  }

}
