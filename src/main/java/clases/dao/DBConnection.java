package clases.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection
{
private static Connection conn = null;
	
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String url="jdbc:postgresql://";
	private static final String user="";
	private static final String pw="";
	
	private DBConnection() {}
	
	public synchronized static Connection get() {
		
		if(conn != null)
			return conn;
		
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(url, user, pw);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return conn;
		
	}
	
	public synchronized static void close() {
		try {
			DBConnection.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
