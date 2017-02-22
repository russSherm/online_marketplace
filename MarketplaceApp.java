import java.rmi.RemoteException;

// Ryan: Please include useful comments in each file.
public class MarketplaceApp {
	public static void main(String[] args) throws RemoteException {
		String s = null;
		
		//Create the MVC
		MarketplaceModel model = new MarketplaceModel(s);
		CustomerView cview = new CustomerView();
		AdminView aview = new AdminView();
		FrontController controller = new FrontController();
		CustomerController ccontroller = new CustomerController(model,cview);
		AdminController acontroller = new AdminController(model, aview);
	
		//Connect View and Controller
		cview.registerListener(ccontroller);
		aview.registerListener(acontroller);
	
	}
}
