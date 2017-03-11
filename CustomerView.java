import java.rmi.Naming;

/**
 * Marketplace Customer View 
 * @author Russell Sherman
 *
 */
public class CustomerView {
	String name = "//tesla.cs.iupui.edu:1720/Server";
	ServerInterface server = null;
	Session session = null;
	
	public void showView() {
		System.out.println("Welcome to the Marketplace, Customer! Have a look around!");
		
		try{
			server = (ServerInterface) Naming.lookup(name);	
		} catch(Exception e){
			System.out.println("Client Exception: " + e.getMessage());
		}
	
		try{
			session = server.processLogin("customer");
		} catch(Exception e){
			System.out.println("Client Exception: " + e.getMessage());
		}
	
		try{
			System.out.println(server.update(session));	
		} catch(Exception e){
			System.out.println("Client Exception: " + e.getMessage());
		}
	
		try{
			System.out.println(server.add(session));
		} catch(Exception e){
			System.out.println("Client Exception: " + e.getMessage());
		}
	
		try{
			System.out.println(server.purchase(session));
		} catch(Exception e){
			System.out.println("Client Exception: " + e.getMessage());
		}
	
		try{
			System.out.println(server.browse(session));
		} catch(Exception e){
			System.out.println("Client Exception: " + e.getMessage());
		}
		
		try{
			System.out.println(server.remove(session));
		} catch(Exception e){
			System.out.println("Client Exception: " + e.getMessage());
		}
	}

	public void registerListener(CustomerController ccontroller) {
		//do something
	}
}
