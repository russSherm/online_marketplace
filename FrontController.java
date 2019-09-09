/**
 * Front Controller
 * @author Russell Sherman
 */

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
	 * Create Database
	 */
	Database database = new Database();
	
	/**
	 * Check credentials of user
	 * @throws InterruptedException 
	 */
	private boolean isAuthenticUser() throws InterruptedException {
		System.out.println("User login complete");
		Thread.sleep(1000);
		return true;
	}
	
	/**
	 * Send request to Dispatcher
	 * @param marketplaceItem 
	 * @throws InterruptedException 
	 */
	public void dispatchRequest(String request) throws InterruptedException {
		System.out.println("Logging In...");
		Thread.sleep(1000);
		
		//Dispatch request if login is successful
		if(isAuthenticUser()) {
			dispatcher.dispatch(request);
		}
	}

}
