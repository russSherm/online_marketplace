import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * ServerImpl that implements ServerInterface class
 * @author Russell Sherman
 *
 */

public class ServerImpl extends UnicastRemoteObject implements ServerInterface {
	private static final long serialVersionUID = -5485952710128132535L;
	
	protected ServerImpl() throws RemoteException {
		super();
	}
	
	//Show client when command has been achieved 
	public String update(Session session) {
		return "Administrator Updated Item";		
	}
	
	public String add(Session session) {
		return "Administrator Added Item";		
	}
	
	public String remove(Session session) {
		return "Administrator Removed Item";		
	}
	
	public String purchase(Session session) {
		return "Customer Purchased Item";		
	}
	
	//Administrator and Customer both able to browse
	public String browse(Session session) {
		return "Customer or Administrator Browsed Items";		
	}
	
	//Create session for user that has logged in
	public Session processLogin(String userType) {
		Session session = new Session(userType);
		return session;
	}
}