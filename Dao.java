

import java.sql.*;

public class Dao {

	static Connection cn;
	public static Connection con(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Priya","Gautam");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return cn;
	}
	
}
