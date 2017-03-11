import java.lang.reflect.Proxy;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Server Class to initiate RMI functionality
 * @author Russell Sherman
 *
 */

public class Server extends UnicastRemoteObject implements Marketplace {
	private static final long serialVersionUID = 1634478554656874968L;
	private int id = 15;
	private String name;
	
	/**
	 * Marketplace Server Constructor where 's' throws RemoteException
	 */
	public Server(String s) throws RemoteException {
		//Call to UnicastRemoteObject's constructor
		super();
		name = s;
	}

	//Return ID of the User
	public synchronized int get_id() throws RemoteException{
		id++;
		return id;
	}
	

	public static void main(String args[]) {
	
		// Set the RMI Security Manager...
		System.setSecurityManager(new SecurityManager());
		
		try {
			System.out.println("Creating a Server!");
			
			// Location of Server
			String name = "//tesla.cs.iupui.edu:1720/Server";
			
			System.out.println("Server: Binding it to name: " + name);
			
			ServerInterface assignment = (ServerInterface) Proxy.newProxyInstance(ServerInterface.class.getClassLoader(),
	                new Class<?>[] {ServerInterface.class},
	                new AuthorizationInvocationHandler(new ServerImpl()));
						
			// Binds the Server to the RMI Service.
			Naming.rebind(name, assignment);
			
			System.out.println("Server Ready!");
		} catch (Exception e){
			System.out.println("Server Exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
}