import java.rmi.Naming;
import java.util.Scanner;

public class Client {
	//Customer ID Number
		static int id;
	
	/**
	 * Connect to Marketplace Server using Java RMI
	 * @param args
	 */
	public static void main(String args[]){
		//Java RMI Security Manager
		System.setSecurityManager(new SecurityManager());
		
		//Use Try-Catch for remote exceptions
		try {
			/*
			 * Show hostname where RMI Server is running.
			 * Hard code the port to avoid using default 1099
			 */
			String name = "//tesla.cs.iupui.edu:1720/Server";
			
			//Locate Marketplace Server
			Marketplace myMarketplace = (Marketplace) Naming.lookup(name);
			
			//Call remote method on Marketplace Server
			id = myMarketplace.get_id();
			
			System.out.println("My Id: " + id);	
			
		} catch(Exception e){
			System.out.println("CustomerView Exception: " + e.getMessage());
			e.printStackTrace();
		}
		
		//Create new instance of a Front Controller
		FrontController frontController = new FrontController();
		
		//Ask user to log in to Marketplace
		Scanner input = new Scanner(System.in);
								
		String userRole;
								
		System.out.println("Are you a customer or administrator: ");
		userRole = input.nextLine();
								
		UsersFactory check = new UsersFactory(userRole);
								
						
		//Dispatch request based on login from user
		//Checking Authorization is a work in progress
		if(check.auth())
			frontController.dispatchRequest("administrator");
		else 
			frontController.dispatchRequest("customer");
		
	}

}
