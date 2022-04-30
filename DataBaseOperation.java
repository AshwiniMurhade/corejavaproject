package com.ashwini;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;




public class DataBaseOperation {
	static Connection conn=null;
	static BufferedReader br;
	static String bn,bl;
	static int bid;
     static Statement st=null;
     static ResultSet rs=null;
     static Scanner sc;
	public static void addRecord() throws IOException, SQLException {
		int c=-1;
		try {
			conn=DataBaseConnectivity.getConnection();
			
			st=conn.createStatement();
			
			String sel="select count(*) cnt from mybank";
			rs=st.executeQuery(sel);
			if(rs.next()) {
				c=rs.getInt("cnt");
			}
			if(c==0) {
				bid=1111;
			} 
			else {
				String sel1="select max(bank_id) id from mybank";
				rs=st.executeQuery(sel1);
				if(rs.next()) {
					bid=rs.getInt("id")+1;  //next number is generated
				}
			}
			br=new BufferedReader( new InputStreamReader(System.in));
			
			System.out.println("Enter Your BankName");
			bn=br.readLine();
			System.out.println("Enter Your BankLocation");
			bl=br.readLine();
			//int bid = Integer.parseInt(br.readLine());
			String sel2="select * from mybank where bank_id="+bid;
			ResultSet rs=st.executeQuery(sel2);
			if(!rs.next()) {
			String ins="insert into mybank values("+bid+",'"+bn+"','"+bl+"')"; 
			int i=st.executeUpdate(ins);
			if(i>0) {
				System.out.println("Your Bank Details Added");
				}
			}
			else {
				System.out.println("Error Occured");
			}
			}catch(SQLException e) {
			e.printStackTrace();
			
		
		}
		

	}
	
		
	
		
	

		
	
	public static void updateRecord() throws IOException, SQLException {
		try {
			conn=DataBaseConnectivity.getConnection();
			st=conn.createStatement();
			 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Enter Bank id");
				int bid=Integer.parseInt(br.readLine());
				
			String sel="select * from mybank where bank_id="+bid;
			ResultSet rs=st.executeQuery(sel);
			if(rs.next()) {
				System.out.println("enter bank name");
				String bn=br.readLine();
				System.out.println("enter bank location");
				String bl=br.readLine();
				String up="update mybank set bank_name= '"+bn+"',bank_location='"+bl+"' where bank_id="+bid; 
				System.out.println(up);
				int i=st.executeUpdate(up);
				if(i>0) {
					System.out.println("record is updated");
				}
				else {
					System.out.println("record is not updated");
				}
				}
				else {
					System.out.println(bid+"bank_id is not exist update is not possible");
				}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	
}
		
		
	
	public static void displayRecord() throws IOException, SQLException {
		 try {
			 conn = DataBaseConnectivity.getConnection();
			 st=conn.createStatement();
			 
			 String sel="select * from mybank";
			// st=conn.createStatement();
			 
			 ResultSet rs=st.executeQuery(sel);
			 System.out.println("bi\tbn\tbl");
			 while(rs.next()) {
				 System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
			 }
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		 		 
		}
	 
		

	public static void displayPerticularRecord() throws SQLException {
		try {
			 conn = DataBaseConnectivity.getConnection();
			 st=conn.createStatement();
			 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
			   System.out.println("bank_id");
			   bid=Integer.parseInt(br.readLine());
			 String query="select * from mybank where bank_id="+bid;
	    //   int bid=rs.getInt(1111);
			 ResultSet rs=st.executeQuery(query);
			 System.out.println("bn\tbL");
			 if(rs.next()) {
				 System.out.println(rs.getInt(1)+"\t"+rs.getString(2));
			 }
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		
			 
		}



		
	
	public static void deleteRecord()throws IOException, SQLException  {
		

		try {
			conn=DataBaseConnectivity.getConnection();
			st=conn.createStatement();

			 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Enter  bank id");
				 int bid= Integer.parseInt(br.readLine());
				
			String sel="select * from mybank where bank_id="+bid;
			ResultSet rs=st.executeQuery(sel);
			if(rs.next()) {
			String del="delete from mybank where bank_id="+bid; 
			System.out.println(del);
			int i=st.executeUpdate(del);
			if(i>0) {
				System.out.println("record is deleted");
			}
			else {
				System.out.println("record is not deleted");
			}
			}
			else {
				System.out.println(bid+"bank_id is not exist delete is not possible");
			}

		} catch (Exception e) {
				
			e.printStackTrace();
		}
		


	
}
}
