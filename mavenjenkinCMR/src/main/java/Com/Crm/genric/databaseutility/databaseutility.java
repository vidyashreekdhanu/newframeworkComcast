
package Com.Crm.genric.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class databaseutility {
	Connection con;
	public void getdbconnection( String url, String username, String password) throws SQLException
	{
		try{
			Driver d = new Driver();
		DriverManager.registerDriver(d);
		 con = DriverManager.getConnection(url, username, password);
		}catch (Exception e)
		{
			
		}
	}
	public void getDBconnection()
	{

		try{
			Driver d = new Driver();
		DriverManager.registerDriver(d);
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		}catch (Exception e)
		{
			
		}
	}
		public void closedbconnection() throws SQLException
		{
		  try {	
			  con.close();
		  }
		  catch (Exception e) {
			// TODO: handle exception
		              }
		  }
		
		public ResultSet executequery(String query)
		{
			ResultSet result = null;
			try{
				
				Statement stat = con.createStatement();
			 result = stat.executeQuery(query);
			 }
			catch (Exception e) 
			{
				
			}
			return result;
		}
		public int execute_nonselectquerry(String query) throws SQLException
		{
			int result=0;
			try{
				Statement stat = con.createStatement();
		 result = stat.executeUpdate(query);
			}
			catch (Exception e) {
				// TODO: handle exception
			}
			
			return result;
		}
		
		
		
	}

