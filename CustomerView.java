import java.rmi.Naming;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Marketplace Customer View 
 * @author Russell Sherman
 *
 */

// Create CustomerView for all customer users
public class CustomerView {
	String name = "//tesla.cs.iupui.edu:1720/Server";
	ServerInterface server = null;
	Session session = null;
	//private static String[] abcItem  = {"Socks", "Shoes", "Shirt", "Pants", "Toothbrush", "Chair", "Laptop", "Shampoo", "Soap"};
	
	// Create showView for customer interaction
	public void showView() throws InterruptedException {
		System.out.println("Welcome to the Marketplace, Customer!");
		Thread.sleep(1000);
		
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
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		int selectTask;
		
		// Ask customer what action they would like to take
		System.out.println("How can we help you?");
		Thread.sleep(2000);
		System.out.println("1.Add Item\n2.Browse Items\n3.Purchase Item\n4.Remove Item\n5.Update Item");
		Thread.sleep(2000);
		System.out.println("Which number would you like to do?");
		selectTask = input.nextInt();
		
		// Create new Items instance
		Items abcItem = new Items();
				
		// Concrete Commands
		BrowseItem browseItem = new BrowseItem(abcItem);
		PurchaseItem purchaseItem = new PurchaseItem(abcItem);
				
		// Invoker Object...
		Clerk clerk = new Clerk();
		
		// Throw exceptions for Update, Add, Remove
		if (selectTask==5){
			try{
				System.out.println(server.update(session));	
			} catch(Exception e){
				System.out.println("Client Exception: " + e.getMessage());
			}
		}
		
		else if (selectTask==1){
			try{
				System.out.println(server.add(session));
			} catch(Exception e){
				System.out.println("Client Exception: " + e.getMessage());
			}
		}
		
		else if (selectTask==3){
			try{
				System.out.println(server.purchase(session));
			} catch(Exception e){
				System.out.println("Client Exception: " + e.getMessage());
			}
			@SuppressWarnings("resource")
			Scanner scan3 = new Scanner(System.in);
			String selectItem = scan3.nextLine();
			abcItem.purchase(selectItem);
			clerk.takeInitiate(purchaseItem);
		}
	
		else if (selectTask==2){
			try{
				System.out.println(server.browse(session));
			} catch(Exception e){
				System.out.println("Client Exception: " + e.getMessage());
			}
			abcItem.browse();
			clerk.takeInitiate(browseItem);
			
		}
		
		else if (selectTask==4){
			try{
				System.out.println(server.remove(session));
			} catch(Exception e){
				System.out.println("Client Exception: " + e.getMessage());
			}
		}
	}

	public void registerListener(CustomerController ccontroller) {
		//do something
	}
}
