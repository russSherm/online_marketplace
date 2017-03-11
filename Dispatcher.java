/**
 * Dispatcher Class for Front Controller
 * @author Russell Sherman
 */
public class Dispatcher {
	//Identify Concrete Views
	private CustomerView customerView;
	private AdminView adminView;
	
	/**
	 * Construct Dispatcher
	 */
	public Dispatcher() {
		customerView = new CustomerView();
		adminView = new AdminView();
	}
	
	/**
	 * Dispatch correct view based on login credentials
	 */
	public void dispatch(String request) {
		if(request.equalsIgnoreCase("administrator")) {
			adminView.showView();
		}
		else {
			customerView.showView();
		}
	}

}
