package login.restro.registration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnectionProvider implements MyProvider {
	
	 static Connection con=null;
			
	public static Connection getCon() {
		try {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con=DriverManager.getConnection(connUrl,username,pwd);
			//System.out.println("connection establisheed");
		}catch(NullPointerException | SQLException | ClassNotFoundException e) {
			//System.out.println(e);
			
	}
		return con;
}
	}