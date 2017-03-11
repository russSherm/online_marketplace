import java.rmi.Naming;

/**
 * Customer Controller for Marketplace
 * @author Russell Sherman
 *
 */
public class CustomerController {
	private Server model;
	private CustomerView view;
	
	//Bring together model and view
	public CustomerController (Server model, CustomerView view){
		this.model = model;
		this.view = view;
	}
	
}
