package project.com.enity;

public abstract class Book {
	private int stt;
	private int id;
	private String bookName;
	private String author;
	private String brief;
	private String bookTitle;
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

	
	public int getStt() {
		return stt;
	}

	public void setStt(int stt) {
		this.stt = stt;
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

	@Override
	  public String toString() {
	    return "STT=" + stt + ", id=" + id + ", Name =" + bookName + ", Author=" + author + ", Category=" + category 	+ ", Brief=" + brief + ", Title=" + bookTitle + ", publisher="
	        + publisher;
	  }

}
