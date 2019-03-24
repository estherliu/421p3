
/**
* Make sure the Postgresql JDBC driver is in your classpath.
 * You can download the JDBC 4 driver from here if required.
 * https://jdbc.postgresql.org/download.html
 *
 * take care of the variables usernamestring and passwordstring to use 
 * appropriate database credentials before you compile !
 *
**/

import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

class simpleJDBC {
	public static void main(String[] args) throws SQLException {
		// Unique table names. Either the user supplies a unique identifier as a command
		// line argument, or the program makes one up.

		String url = "jdbc:postgresql://comp421.cs.mcgill.ca:5432/cs421";
		Connection con = DriverManager.getConnection(url, "cs421g24", "Group24@2019");
		
		test(con);
		
		

	}
	
	
	
	public static void test(Connection con) {
		//test
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM address"); 
				ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				System.out.print(rs.getInt(1));
				System.out.print(": ");
				System.out.print(rs.getString(2)+" ");
				System.out.println(rs.getString(3));
			}
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(simpleJDBC.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		}
	}

}
