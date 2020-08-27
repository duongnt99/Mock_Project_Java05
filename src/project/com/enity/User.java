package project.com.enity;

public abstract class User {
	private int id;
	private String userName;
	private String passWord;
	private int  state;


	public User() {
	    // TODO Auto-generated constructor stub
	}

	public User(int id, String userName, String passWord, int  state) {
	   super();
	   this.id = id;
	   this.userName = userName;
	   this.passWord = passWord;
	   this.state = state;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@Override
	  public String toString() {
	    return "id=" + id + ", username=" + userName + ", password=" + passWord + ", state=" + state;
	  }
}
