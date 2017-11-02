
package exe;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DetabaseTesting {
	// Connection object
	static Connection con = null;
	// Statement object
	private static Statement stmt;
	// Constant for Database URL
	public static String DB_URL = "jdbc:mysql://192.168.1.144:3306/tmdm64_master";   
	// Constant for Database Username
	public static String DB_USER = "root";
	// Constant for Database Password
	public static String DB_PASSWORD = "mysql";
	
	@BeforeClass
	public void dbConnection() throws Exception {
		try{
			// Make the database connection
			String dbClass = "com.mysql.jdbc.Driver";
			Class.forName(dbClass).newInstance();
			// Get connection to DB
			Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			// Statement object to send the SQL statement to the Database
			stmt = con.createStatement();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void fetchData() {
		try{
			String query = "SELECT * FROM tmdm64_master.mdmperson";
			// Get the contents of userinfo table from DB
			ResultSet res = stmt.executeQuery(query);
			// Print the result untill all the records are printed
			// res.next() returns true if there is any next record else returns false
			while (res.next())
			{
				System.out.print(res.getString(1));
				System.out.print("\t" + res.getString(2));
				System.out.print("\t" + res.getString(3));
				System.out.print("\t" + res.getString(4));
				System.out.print("\t" + res.getString(5));
				System.out.print("\t" + res.getString(6));
				System.out.print("\t" + res.getString(7));
				System.out.print("\t" + res.getString(8));
				System.out.print("\t" + res.getString(9));
				System.out.print("\t" + res.getString(10));
				System.out.print("\t" + res.getString(11));
				System.out.println("\t" + res.getString(12));
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}     
	}
	@AfterClass
	public void tearDown() throws Exception {
		// Close DB connection
		if (con != null) {
			con.close();
		}
	}
}
