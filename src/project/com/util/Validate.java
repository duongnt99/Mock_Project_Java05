package project.com.util;

public class Validate {
	public static boolean checkSearch(String input) {
		if(input.equals(Constant.BY_AUTHOR) || input.equals(Constant.BY_NAME) || input.equals(Constant.BY_CATEGORY) || input.equals(Constant.EXIT_SEARCH))
			return true;
		return false;
	}
	public static boolean chekSearchStr(String input) {
		if(input == null || (input.trim()).equals(""))
			return false;
		return true;
	}
	public static boolean checkAttributeBook(String input) {
		if(input == null || (input.trim()).equals(""))
			return false;
		return true;
	}
	public static boolean checkUser(String user) {
		if(user == null)
			return false;
		if(user.trim().equals("")) {
			return false;
		}
		if(user.contains(" "))
			return false;
		return true;
	}
	
	public static int checkId(String id) throws Exception {
		int result;
		try {
			result = Integer.parseInt(id);
			return result;
		} catch (Exception e) {
			throw new Exception("Id invalid");
		}
	}
}
