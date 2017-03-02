package start.com;

//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
import org.testng.annotations.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;
 
public class SelDBT {
	
       // Connection object
       static Connection con = null;
       // Statement object
       private static Statement stmt;
       // Constant for Database URL
       public static String DB_URL = "jdbc:mysql://localhost:3306/test";   
       // Constant for Database Username
       public static String DB_USER = "root";
       // Constant for Database Password
       public static String DB_PASSWORD = "root";
 
       @BeforeClass
       public void setUp() throws Exception {
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
 
       @Test(enabled = false,priority = 0,groups={"Select"})
       public void Selectquery() {    	  
              try{
            	  String query;            	  
             //String query = "INSERT INTO persons (PersonID,LastName,FirstName,Address,City) VALUES ('2664','chris','Gayle','weststreet','Westindian')";	
            	  query = "select * from potluck"; 
            	  //query = "select * from userinfo";
          
              // Get the contents of userinfo table from DB
              ResultSet res = stmt.executeQuery(query);
             // ResultSet res1 = stmt.executeQuery(query1);
              
              // Print the result untill all the records are printed
              // res.next() returns true if there is any next record else returns false
              while (res.next())
              {            	 
              System.out.print(res.getString(1));
              System.out.print("\t" + res.getString(2));
              System.out.print("\t" + res.getString(3));
              System.out.println("\t" + res.getString(4));
              System.out.println("\t" + res.getString(5));         
              }
              }
              catch(Exception e)
              {
                     e.printStackTrace();
              }     
       }
       @Test(priority = 1,groups={"Retry"})
       public void Retryquery() {
     	  
           try{
         	  String query;
         	  query = "select * from potluck where name ='Tom'";
         	  
           //query = "INSERT INTO persons(PersonID,LastName,FirstName,Address,City) VALUES ('2664','chris','Gayle','weststreet','Westindian')";	
         	// query = "select * from place"; 	                
       
           // Get the contents of userinfo table from DB
           ResultSet res1 = stmt.executeQuery(query);    
           
           // Print the result untill all the records are printed
           // res.next() returns true if there is any next record else returns false
           while (res1.next())
           {            	 
        	   System.out.print(res1.getString(1));
               System.out.print("\t" + res1.getString(2));
               System.out.print("\t" + res1.getString(3));
               System.out.println("\t" + res1.getString(4));
               System.out.println("\t" + res1.getString(5));                       
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
