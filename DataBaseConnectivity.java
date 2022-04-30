package com.ashwini;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnectivity {
   
	static Connection conn=null;
	static Statement st=null;
     final static String Database_Driver = "com.mysql.cj.jdbc.Driver";
	          final static String DB_URL = "jdbc:mysql://localhost:3306/edudb";
	     final static String DB_USERNAME = "root";
	     final static String DB_PASSWORD = "root";
	     
       public static Connection getConnection() throws SQLException {
    	     
    	   try {
    		   Class.forName(Database_Driver);
    		       conn = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
    		      
    			  if(conn!=null) {
    				  System.out.println("Successfully connected.");
    				  }
    			else {
    				  System.out.println("Failed to connect");
    			  }
    		   }catch(Exception e) {
    			 e.printStackTrace();  
    	   }
    	   
  	
  		 
    	   return conn;
    	   
       }
    	
       

}
