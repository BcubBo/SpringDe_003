package dao;

public class DaoFactory {
	
	public static ITestDao getInstance() {
		
		return new TestDao();
	}

}
