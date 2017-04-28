import java.lang.reflect.Proxy;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Server Class to initiate RMI functionality
 * @author Russell Sherman
 *
 */

public class Server extends UnicastRemoteObject implements ServerInterface {
	private static final long serialVersionUID = 1634478554656874968L;
	@SuppressWarnings("unused")
	private String name;
	
	/**
	 * Marketplace Server Constructor where 's' throws RemoteException
	 */
	public Server(String s) throws RemoteException {
		//Call to UnicastRemoteObject's constructor
		super();
		name = s;
	}
	
	public static void main(String args[]) {
	
		// Set the RMI Security Manager...
		System.setSecurityManager(new SecurityManager());
		
		try {
			System.out.println("Creating a Server!");
			Thread.sleep(1000);
			
			// Location of Server
			String name = "//tesla.cs.iupui.edu:1720/Server";
			
			System.out.println("Server: Binding it to name: " + name);
			Thread.sleep(1000);
			
			ServerInterface assignment = (ServerInterface) Proxy.newProxyInstance(ServerInterface.class.getClassLoader(),
	                new Class<?>[] {ServerInterface.class},
	                new AuthorizationInvocationHandler(new ServerImpl()));
						
			// Binds the Server to the RMI Service.
			Naming.rebind(name, assignment);
			
			System.out.println("Server Ready!");
			
			//Create connection to Database
			//Could not connect, Exception thrown
			//"No suitable driver found for jdbc:"
			//Database database = new Database();
			//database.main(args);

		} catch (Exception e){
			System.out.println("Server Exception: " + e.getMessage());
			e.printStackTrace();
		}
	}

	//ServerInterface commands
	@Override
	public String purchase(Session session) throws RemoteException {
		return null;
	}

	@Override
	public String update(Session session) throws RemoteException {
		return null;
	}

	@Override
	public String add(Session session) throws RemoteException {
		return null;
	}

	@Override
	public String remove(Session session) throws RemoteException {
		return null;
	}

	@Override
	public String browse(Session session) throws RemoteException {
		return null;
	}

	@Override
	public Session processLogin(String userType) throws RemoteException {
		return null;
	}
}