import java.rmi.Naming;

/**
 * Customer Controller for Marketplace
 * @author Russell Sherman
 *
 */
public class CustomerController {
	private MarketplaceModel model;
	private CustomerView view;
	
	//Bring together model and view
	public CustomerController (MarketplaceModel model, CustomerView view){
		this.model = model;
		this.view = view;
	}
	
}
