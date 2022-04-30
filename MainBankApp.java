package com.ashwini;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class MainBankApp {

	public static void main(String[] args) throws IOException, SQLException { 
		
		int ch;
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("***************Menu****************");
			System.out.println("1. Add Bank Information");
			System.out.println("2. Update Bank Details");
			System.out.println("3. Display Bank Details");
			System.out.println("4. Display Perticular Bank Details");
			System.out.println("5. Delete Bank Details");
			System.out.println("Enter your Choice");
			ch = sc.nextInt();
			
			switch(ch) {
			case 1:DataBaseOperation.addRecord();
			break;
			case 2:	DataBaseOperation.updateRecord();
			break;
			case 3: DataBaseOperation.displayRecord();
			break;
			case 4: DataBaseOperation.displayPerticularRecord();
			break;
			case 5: DataBaseOperation.deleteRecord();
			break;
			}
		
		}
	}

}
