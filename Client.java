import java.rmi.Naming;
import java.util.Scanner;

public class Client {	
	/**
	 * Connect to Marketplace Server using Java RMI
	 * @param args
	 * @param marketplaceItem 
	 * @throws InterruptedException 
	 */
	public static void main(String args[]) throws InterruptedException{
		//Java RMI Security Manager
		System.setSecurityManager(new SecurityManager());
		/*
		 * Show hostname where RMI Server is running.
		 * Hard code the port to avoid using default 1099
		 */
		String name = "//tesla.cs.iupui.edu:1720/Server";
		
		//Use Try-Catch for remote exceptions
		try {
			//Locate Marketplace Server
			@SuppressWarnings("unused")
			ServerInterface server = (ServerInterface) Naming.lookup(name);	
			
		} catch(Exception e){
			System.out.println("CustomerView Exception: " + e.getMessage());
			e.printStackTrace();
		}
		
		//Create new instance of a Front Controller
		FrontController frontController = new FrontController();
		
		//Ask user to log in to Marketplace
		@SuppressWarnings("resource")
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
