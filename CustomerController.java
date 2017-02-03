import java.rmi.Naming;

/**
 * Customer Controller for Marketplace
 * @author Russell Sherman
 *
 */
public class CustomerController {
	private MarketplaceModel model;
	private CustomerView view;
	//Customer ID Number
	static int id;
	
	//Bring together model and view
	public CustomerController (MarketplaceModel model, CustomerView view){
		this.model = model;
		this.view = view;
	}
	
	public static void main(String args[]){
		//Java RMI Security Manager
		System.setSecurityManager(new SecurityManager());
		
		//Use Try-Catch for remote exceptions
		try {
			/*
			 * Show hostname where RMI Server is running.
			 * Hard code the port to avoid using default 1099
			 */
			String name = "//tesla.cs.iupui.edu:1720/MarketplaceServer";
			
			//Locate Marketplace Server
			Marketplace myMarketplace = (Marketplace) Naming.lookup(name);
			
			//Call remote method on Marketplace Server
			id = myMarketplace.get_id();
			
			System.out.println("Welcome to the Marketplace! Have a look around!");
			System.out.println("Your Customer Id is: " + id);
		} catch(Exception e){
			System.out.println("CustomerView Exception: " + e.getMessage());
			e.printStackTrace();
		}
		
	}


}
