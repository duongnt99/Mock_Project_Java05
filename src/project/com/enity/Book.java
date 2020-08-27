package project.com.enity;

public abstract class Book {
	private int id;
	private String bookTitle;
	private String author;
	private String brief;
	private String publisher;
	private String content;
	private String category;

	public Book() {
	    // TODO Auto-generated constructor stub
	}

	public Book(int id, String bookTitle, String author, String brief, String publisher, String content, String category) {
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

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
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

	@Override
	  public String toString() {
	    return "id=" + id + ", bookTitle=" + bookTitle + ", author=" + author + ", category=" + category 	+ ", brief=" + brief + ", content=" + content + ", publisher="
	        + publisher;
	  }

}
