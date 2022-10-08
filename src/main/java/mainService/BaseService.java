package mainService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseService {
	public static final String url = "jdbc:sqlserver://DESKTOP-6B231M6:1433;databaseName=Wish;trustServerCertificate=true;";
	public static final String user = "sa";
	public static final String pass = "123";
	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection(url,user,pass);
			return conn;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		try {
			System.out.println(getConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
