import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 
 * @author Russell Sherman
 *
 */

public interface ServerInterface extends Remote {
	@RequiresRole("administrator")
    public String purchase(Session session) throws RemoteException;
	
	@RequiresRole("customer")
    public String update(Session session) throws RemoteException;
	
	@RequiresRole("customer")
    public String add(Session session) throws RemoteException;
	
	@RequiresRole("customer")
    public String remove(Session session) throws RemoteException;
	
	//Throwing exception for administrator for browse for this assignment
	@RequiresRole("administrator")
    public String browse(Session session) throws RemoteException;
	
	public Session processLogin(String userType) throws RemoteException;
}