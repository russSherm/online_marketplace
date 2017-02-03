import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/** 
 * Online Marketplace Server
 * @author Russell Sherman
 */
public class MarketplaceServer extends UnicastRemoteObject implements Marketplace {
	private static final long serialVersionUID = 1634478554656874968L;
	private int id = 15;
	private String name;

	/**
	 * Marketplace Server Constructor where 's' throws RemoteException
	 */
	public MarketplaceServer(String s) throws RemoteException {
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
			String name = "//tesla.cs.iupui.edu:1720/MarketplaceServer";
			
			//Create new instance of Marketplace Server
			MarketplaceServer marketplace = new MarketplaceServer(name);
			
			System.out.println("MarketplaceServer: binding it to name: " + name);
			
			//Binding of newly created Marketplace server instance to RMI lookup
			Naming.rebind(name, marketplace);
			
			System.out.println("Connection to Marketplace Server has been established!");
		}catch (Exception e){
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
	}


}