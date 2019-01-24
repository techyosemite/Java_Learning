package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class TypeOneDriver {
	
	public static void main(String[] args) {
		Connection con ;
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			con=DriverManager.getConnection("jdbc:odbc:datastud");
			con.prepareStatement("select count(*) from tab");
			Statement stmt = con.createStatement();
			stmt.execute("Select * from tab");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
