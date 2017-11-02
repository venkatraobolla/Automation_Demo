/* 
    	Author: Artha Data Solutions Testing Team
    	Date: 2017-10-04
    	Description: This code Will Automate 13 Test cases  for Customer, Audit, Payment & Partners
 */

//Package Statement
package exe;

// Import statement for Files, Excel, Mysql & TestNG
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import jxl.Workbook;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

//Class Declaration 
public class Arthadb_Automation
{
	//public static int Noc;
	Connection con;
	Statement stmt;

	//Database Connection Statement
	@BeforeClass
	public void getDatabaseConnection() throws ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver Loaded and Registered Successfully");
		Reporter.log("Driver Loaded and Registered Successfully");
		
		System.out.println("Opening Database Connection...");
		con=DriverManager.getConnection("jdbc:mysql://192.168.1.144:3306/tmdm64_master","root","mysql"); 
		System.out.println("Connection Established with Database Successfully");
		Reporter.log("Connection Established with Database Successfully");
		
		stmt=con.createStatement(); 
		System.out.println("Statement Object Created Successfully");
		Reporter.log("Statement Object Created Successfully");
	}

	/*
	 * Customer Name Check
	 * 			1. Here we are Validating Both First 
	 * 			2. Mandatory
	 * 			3. Allow Only Alphabets (a to z / A to Z)
	 */
	/*@Test(priority=1)
	public void ArthaDB_Customer_FirstName_Check_TC001() throws SQLException, RowsExceededException, WriteException, IOException 
	{
		StringBuffer TC001r=new StringBuffer();
		try
		{ 
			int Noc=0; 
			ResultSet rs=stmt.executeQuery("select * from tmdm64_master.mdmperson where FirstName regexp '^[^A-Za-z]' or FirstName is null");
			Reporter.log("FirstName Check Query Executeed /");
			List<String> TC001rs=new ArrayList<String>();
			while (rs.next()) 
			{
				Noc=rs.getRow();
				TC001rs.add(rs.getString("SSN"));

			}
			if(Noc==0)
			{
				Assert.assertEquals("CUSTOMERS FirstName check is Passed", 0, Noc);
				System.out.println("CUSTOMERS FirstName check is Passed");
				Reporter.log("CUSTOMERS FirstName check is Passed");
			}
			else
			{
				for(int i=0;i<TC001rs.size();i++)
				{
					TC001r.append(TC001rs.get(i)+","); 	  
				}
				System.out.println("CUSTOMERS FirstName check is Failed");
				Reporter.log("CUSTOMERS FirstName check is Failed");
				Assert.assertEquals("CUSTOMERS FirstName check is Failed at SSN="+TC001r, 0, Noc);
			}  
		}
		catch (Exception e1) 
		{
			e1.printStackTrace();
		} 
	}

	/*
	 * Here we will Check Customer SSN Format
	 * 		1. SSN is Mandatory
	 * 		2. SSN is in Specified Format like 123-45-6796 
	 */
	/* @Test(priority=2)
	public void ArthaDB_Customers_SSN_Check_TC002() throws SQLException, RowsExceededException, WriteException, IOException 
	{
		StringBuffer TC002r=new StringBuffer();
		try
		{ 
			int Noc=0; 
			ResultSet rs=stmt.executeQuery("SELECT * FROM customers WHERE SSN not RLIKE '[[:<:]][0-9]{3}[[:>:]](-)[[:<:]][0-9]{2}[[:>:]](-)[[:<:]][0-9]{4}[[:>:]]' or SSN is null"); 
			Reporter.log("Customers SSN Check Query Executeed /");
			List<String> TC002rs=new ArrayList<String>();
			while (rs.next()) 
			{
				Noc=rs.getRow();
				TC002rs.add(rs.getString("CustomerPK"));

			}
			if(Noc==0)
			{
				Assert.assertEquals("CUSTOMERS SSN check is Passed", 0, Noc);
				System.out.println("CUSTOMERS SSN check is Passed");
				Reporter.log("CUSTOMERS SSN check is Passed");
			}
			else
			{
				for(int i=0;i<TC002rs.size();i++)
				{
					TC002r.append(TC002rs.get(i)+","); 
				}
				System.out.println("CUSTOMERS SSN check is Failed");
				Reporter.log("CUSTOMERS SSN check is Failed");
				Assert.assertEquals("CUSTOMERS SSN check is Failed at CustomerPK="+TC002r, 0, Noc);
			}  
		}
		catch (Exception e1) 
		{
			e1.printStackTrace();
		} 
	}*/

	/*
	 * Customer Phone number is mandatory and it is in specified format (for example +1 333 333 4444)
	 * Input Excel Phone number does not contain PLUS (+) symbol, it contain hyphen(-)
	 * Need to replay hyphen symbol into Space. 
	 */
/*	@Test(priority=3)
	public void ArthaDB_PrimaryPhoneNumber_TC003() throws SQLException
	{
		int Noc=0; 
		ResultSet rs=stmt.executeQuery("SELECT * FROM customers WHERE PrimaryPhoneNumber not REGEXP '[+][1] [0-9]{3} [0-9]{3} [0-9]{4}' or PrimaryPhoneNumber is null");
		Reporter.log("PrimaryPhoneNumber Check Query Executeed /");
		List<String> Phone_rs=new ArrayList<String>();
		while(rs.next())
		{
			Noc=rs.getRow();
			Phone_rs.add(rs.getString("SSN"));
		}
		if(Noc==0)
		{
			Assert.assertEquals("Customer PrimaryPhoneNumber check is Passed",0,Noc);
			System.out.println("Customer PrimaryPhoneNumber check is Passed");
			Reporter.log("Customer PrimaryPhoneNumber check is Passed");
		}
		else
		{
			StringBuffer Phone_r=new StringBuffer();
			for(int k=0;k<Phone_rs.size();k++)
			{
				Phone_r.append(Phone_rs.get(k)+",");
			}
			System.out.println("Customer PrimaryPhoneNumber check is Failed");
			Reporter.log("Customer PrimaryPhoneNumber check is Failed");
			Assert.assertEquals("Customer PrimaryPhoneNumber check is Failed at SSN="+Phone_r, 0, Noc);

		}
	}*/
	
	/*
	 * Customer Name Check
	 * 			1. Here we are Validating Last Name
	 * 			2. Mandatory
	 * 			3. Should allow only alphabets (a to z / A to Z)
	 */
	
	/*@Test(priority=4)
	public void ArthaDB_Customer_LastName_Check_TC004() throws SQLException, RowsExceededException, WriteException, IOException 
	{
		StringBuffer TC004r=new StringBuffer();
		try
		{ 
			int Noc=0; 
			ResultSet rs=stmt.executeQuery("select * from customers where LastName regexp '^[^A-Za-z]' or LastName is null"); 
			Reporter.log("Customer LastName Check Query Executeed /");
			List<String> lastName=new ArrayList<String>();
			while (rs.next()) 
			{
				Noc=rs.getRow();
				lastName.add(rs.getString("SSN"));

			}
			if(Noc==0)
			{
				Assert.assertEquals("CUSTOMERS LastName check is Passed", 0, Noc);
				System.out.println("CUSTOMERS LastName check is Passed");
				Reporter.log("CUSTOMERS LastName check is Passed");
			}
			else
			{
				for(int i=0;i<lastName.size();i++)
				{
					TC004r.append(lastName.get(i)+","); 	  
				}
				System.out.println("CUSTOMERS LastName check is Failed");
				Reporter.log("CUSTOMERS LastName check is Failed");
				Assert.assertEquals("CUSTOMERS LastName check is Failed at SSN="+TC004r, 0, Noc);
			}  
		}
		catch (Exception e1) 
		{
			e1.printStackTrace();
		} 
	} */
	
	
	@Test(priority=1)
	public void ArthaDB_Customer_LastName_Check_TC004() throws Exception 
	{
		StringBuffer TC004r=new StringBuffer();
		try
		{ 
			int Noc=0; 
			ResultSet rs=stmt.executeQuery("select * from tmdm64_master.mdmperson where x_lastname regexp '^[^A-Za-z]' or x_lastname is null"); 
			Reporter.log("Customer LastName Check Query Executeed /");
			List<String> lastName=new ArrayList<String>();
			while (rs.next()) 
			{
				Noc=rs.getRow();
				lastName.add(rs.getString("x_skmember"));

			}
			if(Noc==0)
			{
				Assert.assertEquals("CUSTOMERS LastName check is Passed", 0, Noc);
				System.out.println("CUSTOMERS LastName check is Passed");
				Reporter.log("CUSTOMERS LastName check is Passed");
			}
			else
			{
				for(int i=0;i<lastName.size();i++)
				{
					TC004r.append(lastName.get(i)+","); 	  
				}
				System.out.println("CUSTOMERS LastName check is Failed");
				Reporter.log("CUSTOMERS LastName check is Failed");
				Assert.assertEquals("CUSTOMERS LastName check is Failed at CUSTOMERS ID="+TC004r, 0, Noc);
			}  
		}
		catch (Exception e1) 
		{
			e1.printStackTrace();
		} 
	} 
	
	
	//Closing the Database Connection
		@AfterClass
	    public void tearDown() {
	      if (con != null) {
	                try {
	                    System.out.println("Closing Database Connection...");
	                    con.close();
	                    System.out.println("Closed Database Connection");
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                }
	            }
	      }
	}
