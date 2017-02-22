import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

// Ryan: A better solution would be to break the RMI functionality out from
// the Application Logic.

/** 
 * Online Marketplace Model
 * @author Russell Sherman
 */
public class MarketplaceModel extends UnicastRemoteObject implements Marketplace {
	private static final long serialVersionUID = 1634478554656874968L;
	private int id = 15;
	private String name;

	/**
	 * Marketplace Server Constructor where 's' throws RemoteException
	 */
	public MarketplaceModel(String s) throws RemoteException {
		//Call to UnicastRemoteObject's constructor
		super();
		name = s;
	}

	//Return ID of the User
	public synchronized int get_id() throws RemoteException{
		id++;
		return id;
	}
	
	
	/**
	 * Start the Marketplace Server and bind to Java RMI lookup
	 */
	public static void main (String args[]) {
		//Java RMI Security Manager
		System.setSecurityManager(new SecurityManager());
		
		//Use Try-Catch for binding of Marketplace Server
		try{
			System.out.println("Creating Marketplace Server!");
			
			/*
			 * Show hostname where RMI Server is running.
			 * Hard code the port to avoid using default 1099
			 */
			String name = "//tesla.cs.iupui.edu:1720/MarketplaceModel";
			
			//Create new instance of Marketplace Server
			MarketplaceModel marketplace = new MarketplaceModel(name);
			
			System.out.println("MarketplaceServer: binding it to name: " + name);
			
			//Binding of newly created Marketplace server instance to RMI lookup
			Naming.rebind(name, marketplace);
			
			System.out.println("Connection to Marketplace Server has been established!");
		}catch (Exception e){
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		
		//Create new instance of a Front Controller
		FrontController frontController = new FrontController();
		
		//Ask user to log in to Marketplace
		Scanner input = new Scanner(System.in);
						
		String username;
						
		System.out.println("Please type your name: ");
		username = input.nextLine();
						
		UsersFactory check = new UsersFactory(username);
						
				
		//Dispatch request based on login from user
		//Checking Authorization is a work in progress
		if(check.auth())
			frontController.dispatchRequest("Ryan");
		else 
			frontController.dispatchRequest("Zach");
		
	}

}