import java.rmi.Naming;
import java.util.Scanner;

/**
 * Front Controller
 * @author Russell Sherman
 */

// Ryan: Why does the Front Controller include the main() method?
// Shouldn't a View have this functionality in it?
// Fix: Removed main() method from Front Controller.
// Added main() method to Client.java
public class FrontController {
	// Dispatcher instance
	private Dispatcher dispatcher;
	
	/**
	 * Construct Front Controller
	 */
	public FrontController(){
		dispatcher = new Dispatcher();
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
