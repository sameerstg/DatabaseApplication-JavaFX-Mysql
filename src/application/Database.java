package application;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;





public class Database {
	
	private static Database database = new Database();
	public static String id;
	public static String name,email,phoneNumber;

	

	
	 private Database(){}  
	   
	 public static Database getInstance() {    
         if (database==null)  
       {  
        	 database=new  Database();  
       }  
         return database;  
}  		
		
		
	


	public static void CreateTable() {
		Connection conn = getConnection();
		try {
			PreparedStatement statement = conn.prepareStatement("CREATE TABLE IF NOT EXISTS studentdata(id int NOT NULL AUTO_INCREMENT,first varchar(255),last varchar(255),PRIMARY KEY(id))");
			statement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
		System.out.println("function complete");
		
		}
	}
	 public static  Connection getConnection(){
		  {
			  String url = "jdbc:mysql://localhost:3306/studentdatabase";
			  String username = "root";
			  String pass = "";
			  try {
				
				  Connection conn = DriverManager.getConnection(url,username,pass);
				  System.out.println("connected");
			  return conn;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		 }
	}
	 public static void Post(String name,String email,String phonenumber) {
			
		 Connection con = getConnection();
		 try {
			PreparedStatement post = con.prepareStatement("INSERT INTO studentdata(name,email,phonenumber)VALUES('"+name+"','"+email+"','"+phonenumber+"')");
			post.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 finally {
			 System.out.println("Data Upadated");
		 }
	 }


}
