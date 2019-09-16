import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Server Interface
 * @author Russell Sherman
 *
 */

// Create ServerInterface interface to assign roles to the different operations
public interface ServerInterface extends Remote {
	@RequiresRole("customer")
    public String purchase(Session session) throws RemoteException;
	
	@RequiresRole("administrator")
    public String update(Session session) throws RemoteException;
	
	@RequiresRole("administrator")
    public String add(Session session) throws RemoteException;
	
	@RequiresRole("administrator")
    public String remove(Session session) throws RemoteException;
	
	//Throwing exception for administrator for browse for this assignment
	@RequiresRole("customer")
    public String browse(Session session) throws RemoteException;
	
	public Session processLogin(String userType) throws RemoteException;
}
