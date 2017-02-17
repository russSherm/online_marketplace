import java.rmi.Naming;

/**
 * Customer Controller for Marketplace
 * @author Russell Sherman
 *
 */
public class AdminController {
	private MarketplaceModel model;
	private AdminView view;
	
	//Bring together model and view
	public AdminController (MarketplaceModel model, AdminView view){
		this.model = model;
		this.view = view;
	}

}