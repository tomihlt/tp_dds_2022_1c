package clases.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DBConnection
{
	private static Connection conn = null;

	private static final String DRIVER = "org.postgresql.Driver";
	private static final String url = "jdbc:postgresql://127.0.0.1:5432/postgres";
	private static final String user = "postgres";
	private static final String pw = "admin";

	private DBConnection()
	{
	}

	public synchronized static Connection get()
	{

		if (conn != null)
			return conn;

		try
		{
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(url, user, pw);
		} catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, "No se pudo obtener la conexión a la base de datos",
					"Error de conexión", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

		return conn;

	}

	public synchronized static void close()
	{
		if (conn != null)
			try
			{
				DBConnection.conn.close();
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
	}
}
