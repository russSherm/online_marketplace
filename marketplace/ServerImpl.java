import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

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
		return "Which item would you like to update?: ";		
	}
	
	public String add(Session session) {
		return "What item would you like to add?: ";
		
	}
	
	public String remove(Session session) {
		return "Which item would you like to remove?: ";		
	}
	
	public String purchase(Session session) {
		return "Which item would you like to purchase?: ";		
	}
	
	//Administrator and Customer both able to browse
	public String browse(Session session) {
		return "Here are the available items: ";
		
	}
	
	//Create session for user that has logged in
	public Session processLogin(String userType) {
		Session session = new Session(userType);
		return session;
	}
}
