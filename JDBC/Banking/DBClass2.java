//import java.util.*;
import java.sql.*;

class DBClass2
{
	ResultSet fetchdataa(String sql)
	{	ResultSet rs;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  

			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","123123");

			Statement stmt=con.createStatement();

 			rs=stmt.executeQuery(sql);

			return rs;
		}
		catch(Exception e)
		{
			System.out.println("Exception :"+e);
		}
		return null;
	}

	
	void moddata(String sql)
	{		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");

			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","123123");

			Statement stmt=con.createStatement();

 			stmt.executeUpdate(sql);
		}
		catch(Exception e)
		{
			System.out.println("Exception :"+e);
		}

	}
}