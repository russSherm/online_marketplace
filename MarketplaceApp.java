
public class MarketplaceApp {
	public static void main(String[] args){
		//Create the MVC
		MarketplaceModel model = new MarketplaceModel();
		CustomerView cview = new CustomerView();
		AdminView aview = new AdminView();
		CustomerController ccontroller = new CustomerController(model,cview);
		AdminController acontroller = new AdminController(model, aview);
	
		//Connect View and Controller
		cview.registerListener(ccontroller);
		aview.registerListener(acontroller);
	
	}
}
