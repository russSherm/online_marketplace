import java.rmi.Naming;
import java.util.Scanner;

/**
 * Front Controller
 * @author Russell Sherman
 */

// Ryan: Why does the Front Controller include the main() method?
// Shouldn't a View have this functionality in it?
public class FrontController {
	//Customer ID Number
	static int id;
	
	// Dispatcher instance
	private Dispatcher dispatcher;
	
	/**
	 * Construct Front Controller
	 */
	public FrontController(){
		dispatcher = new Dispatcher();
	}
	
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
			String name = "//tesla.cs.iupui.edu:1720/MarketplaceModel";
			
			//Locate Marketplace Server
			Marketplace myMarketplace = (Marketplace) Naming.lookup(name);
			
			//Call remote method on Marketplace Server
			id = myMarketplace.get_id();
			
			System.out.println("My Id: " + id);	
			
		} catch(Exception e){
			System.out.println("CustomerView Exception: " + e.getMessage());
			e.printStackTrace();
		}
		
		
	}
	
	
	/**
	 * Check credentials of user
	 */
	private boolean isAuthenticUser() {
		System.out.println("User login complete");
		return true;
	}
	
	/**
	 * Send request to Dispatcher
	 */
	public void dispatchRequest(String request) {
		System.out.println("Logging In...");
		
		//Dispatch request if login is successful
		if(isAuthenticUser()) {
			dispatcher.dispatch(request);
		}
	}

}
