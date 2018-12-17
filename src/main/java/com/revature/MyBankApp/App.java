package com.revature.MyBankApp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
//import java.io.IOException;
import java.util.Scanner;


public class App 
{
	 static Scanner sc = new Scanner(System.in);
		//private static User u;
		private static User u = null;   

	public static void main(String[] args) {

		loop: while (true) {

			System.out.println("Options:");
			System.out.println("1 to log into an account");
			System.out.println("2 to create a customer account");
			System.out.println("3 to create an admin account");
			System.out.println("0 to exit system");
			System.out.println("Enter option: ");
			int option = sc.nextInt();
			sc.nextLine();

			switch (option) {
			// Login log out
			case 1:
				System.out.println("Enter your login credentials..");
				login();
				break;
			// create customer account
			case 2:
				System.out.println("Your created a customer account");
				createCustomer();
				break;
			// create admin account
			case 3:
				System.out.println("Your created an admin account");
				// createAdmin();
				break;
			// exit system
			case 0:
				System.out.println("Goodbye");
				break loop;
			}

			if (u != null) {
				loggedIn();

			}
		}
		sc.close();

	}

	public static void loggedIn() {
		/*
		 * if (!u.approved) { System.out.println(u.name +
		 * " are not approved for deposits and withdrawals by an admin. Logging out...\n"
		 * ); u = null; return; }
		 */

		while (true) {
			System.out.println("Options:");
			System.out.println("1 Deposit");
			System.out.println("2 Withdraw");
			/*
			 * if (u.admin) { System.out.println("3 to approve users"); }
			 */ System.out.println("0 to log out of: " + u.name);
			System.out.println("Enter option: ");

			int option = sc.nextInt();
			sc.nextLine();
			/*
			 * if (!u.admin && option > 2) {
			 * System.out.println("Invalid option for a customer. Retry..."); continue; }
			 */
			switch (option) {
			// log out
			case 0:
				System.out.println(u.name + " logging out...");
				u = null;
				return;
			case 1:
				// deposit();
				System.out.println("depositing: ");

				break;
			case 2:
				// withdraw();
				System.out.println("withdrawing: ");

				break;
			case 3:
				// approveUsers();

			}
		}
	}

	public static void login() {
		//System.out.println("Logged in Successful");

		boolean authenticated = false;
		while (!authenticated) {
			System.out.println("Enter your user name: ");
			String name = sc.nextLine();
			System.out.println("Your name is " + name);
			//Check out Later
			//u = existingUsername;
					
			if (u == null) {
				System.out.println("Invalid user name: " + name);
				continue;
			}

			System.out.println("Enter your password: ");
			String password = sc.nextLine();

			if (!u.password.equals(password)) {
				System.out.println("Invalid password for : " + name);

			} else
				authenticated = true;
		}
		// Runtime.getRuntime().exec("clear");
		//System.out.println("Welcome " + u.name);
		System.out.println("Welcome ");

		loggedIn();
	}

	public static void createCustomer() {
		System.out.println("Create a customer account");
		//createUser(false);
		createUser();
		//System.out.println("Customer account created, username: " + u.name);
		System.out.println("Customer account created, username: ");

	}

	public static void createUser()  {

		Scanner keyboard = new Scanner(System.in);
	    FileWriter fw = null;
		try {
			fw = new FileWriter("C:\\Users\\Mike\\eclipse-workspace\\CreateAccounts\\src\\com\\revature\\CreateAccount.txt",true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   //C:\Users\Mike\eclipse-workspace\CreateAccounts\src\com\revature\CreateAccount
	    PrintWriter pw = new PrintWriter(fw);


	    System.out.println("Please enter a username: ");
	    String user = keyboard.nextLine();

		File file = new File("C:\\Users\\Mike\\eclipse-workspace\\CreateAccounts\\src\\com\\revature\\CreateAccount.txt");
	   // @SuppressWarnings("resource")
		Scanner usernameCheck = null;
		try {
			usernameCheck = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    while(usernameCheck.hasNext()){
	        String existingUsername = usernameCheck.nextLine();

	        if(user.equalsIgnoreCase(existingUsername)){

	            System.out.println("Username already exists");
	            System.out.println("Please enter a username: ");
	            user = keyboard.nextLine();
	        }
	    }

	    System.out.println("Please enter a password: ");
	    //@SuppressWarnings("unused")
		String pass = keyboard.nextLine();

	    System.out.println("Account created!");
		
	    keyboard.close();
	    usernameCheck.close();
	    try {
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*BufferedWriter bw = null;
		try {
			String mycontent = "This String would be written" + " to the specified File";
			// Specify the file name and path here
			File file = new File("C:\\Users\\Mike\\eclipse-workspace\\MichaelBankApp\\src\\com\\revature\\testFile.txt");
			//C:\Users\Mike\eclipse-workspace\MichaelBankApp\src\com\revature

			
			 * This logic will make sure that the file gets created if it is not present at
			 * the specified location
			 
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			bw.write(mycontent);
			System.out.println("File written Successfully");

		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (Exception ex) {
				System.out.println("Error in closing the BufferedWriter" + ex);
			}
		}

		System.out.println("Please enter your name");*/
		
		

	}
	
	
	
	

	private static void getUser(String name) {
		// TODO Auto-generated method stub
	
	}
}

/*
 * public static void main(String[] args) {
 * 
 * //user input
 * 
 * //String opt = input.nextLine(); //System.out.println("value = "+);
 * 
 * 
 * 
 * loop: while (true) { private static User u = null; Scanner scanner = new
 * Scanner(System.in); System.out.println("Welcome to Michaels Console BankApp"
 * + "\n");
 * //System.out.println("--------------------------------------------");
 * System.out.println("Select from one of the options below:");
 * System.out.println("--------------------------------------------");
 * 
 * System.out.println("1. Login to your Customer Account");
 * System.out.println("2. Login into Employee Account");
 * System.out.println("3. Quit Application"); System.out.println("");
 * 
 * //Scanner scanner = new Scanner(System.in); int option = scanner.nextInt();
 * scanner.nextLine(); //scanner.close();
 * 
 * //String optionToChoose = sc.nextLine();
 * 
 * switch (option) { case 1: System.out.println("Customer"); break; case 2:
 * System.out.println("Employee"); break; case 3: System.out.println("Quit");
 * break; //default case 0:
 * //System.out.println("Invalid Option, Please Enter 1 or 2"); break loop; }
 * 
 * if (u != null) { System.out.println("");
 * 
 * scanner.close(); }
 */


