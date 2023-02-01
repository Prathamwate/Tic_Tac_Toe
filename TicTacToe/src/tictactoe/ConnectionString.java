package tictactoe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class ConnectionString  {
	
	public Connection getConnection() {
	
	try {
		 Class.forName("com.mysql.cj.jdbc.Driver");  
		 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/tictactoe","root","Pratham@1129"); 
	}
	catch(Exception e) {
		System.out.println(e);
	}
	 return getConnection();
	}
}
