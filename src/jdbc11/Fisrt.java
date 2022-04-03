package jdbc11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
 
public class Fisrt {

		   // JDBC driver name and database URL                              
		   private static final String DATABASE_URL = "jdbc:oracle:thin:@199.212.26.208:1521:SQLD";
		   private static final String USERNAME = "COMP228_w22_sy_48";
		   private static final String PASSWORD = "password";
		   
		   public static void main(String args[])
		   {
		      // connect to database books and query database
		      try (JdbcRowSet rowSet =
		         RowSetProvider.newFactory().createJdbcRowSet())
		      {
		         // specify JdbcRowSet properties 
		         rowSet.setUrl(DATABASE_URL);        
		         rowSet.setUsername(USERNAME);          
		         rowSet.setPassword(PASSWORD);          
		         rowSet.setCommand("SELECT * FROM player"); // set query
		         rowSet.execute(); // execute query                        

		         // process query results
		         ResultSetMetaData metaData = rowSet.getMetaData();
		         int numberOfColumns = metaData.getColumnCount();
		         System.out.println("Authors Table of Books Database:\n");

		         // display rowset header
		         for (int i = 1; i <= numberOfColumns; i++)
		            System.out.printf("%-8s\t", metaData.getColumnName(i));
		         System.out.println();
		         
		         // display each row
		         while (rowSet.next()) 
		         {
		            for (int i = 1; i <= numberOfColumns; i++)
		               System.out.printf("%-8s\t", rowSet.getObject(i));
		            System.out.println();
		         }
		      }
		      catch (SQLException sqlException) 
		      {
		         sqlException.printStackTrace();
		         System.exit(1);
		      }
		   } 
		} // end class JdbcRowSetTest