import java.rmi.Naming;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Marketplace Admin View 
 * @author Russell Sherman
 *
 */

// Create AdminView for the administrators experience
public class AdminView {
	String name = "//tesla.cs.iupui.edu:1720/Server";
	ServerInterface server = null;
	Session session = null;
	
	// Create showView for administrator interaction
	public void showView() throws InterruptedException {
		System.out.println("Welcome back, Administrator!");
		Thread.sleep(1000);
	
		try{
			server = (ServerInterface) Naming.lookup(name);	
		} catch(Exception e){
			System.out.println("Client Exception: " + e.getMessage());
		}
	
		try{
			session = server.processLogin("administrator");
		} catch(Exception e){
			System.out.println("Client Exception: " + e.getMessage());
		}
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		int selectTask;
		
		System.out.println("What would you like to do?");
		Thread.sleep(1000);
		System.out.println("1.Add Item\n2.Browse Items\n3.Purchase Item\n4.Remove Item\n5.Update Item");
		Thread.sleep(1000);
		System.out.println("Which number would you like to do?");
		selectTask = input.nextInt();
		
		// Create new Items instance
		Items abcItem = new Items();
		
		// Concrete Commands
		AddItem addItem = new AddItem(abcItem);
		RemoveItem removeItem = new RemoveItem(abcItem);
		UpdateItem updateItem = new UpdateItem(abcItem);
		
		// Invoker Object...
	    Clerk clerk = new Clerk();
		
		// Throw exceptions for Purchase and Browse
		if (selectTask==5){
			try{
				System.out.println(server.update(session));	
			} catch(Exception e){
				System.out.println("Client Exception: " + e.getMessage());
			}
			@SuppressWarnings("resource")
			Scanner scan5 = new Scanner(System.in);
			String selectItem = scan5.nextLine();
			abcItem.update(selectItem);
			clerk.takeInitiate(updateItem);
		}
		
		else if (selectTask==1){
			try{
				System.out.println(server.add(session));
			} catch(Exception e){
				System.out.println("Client Exception: " + e.getMessage());
			}
			clerk.takeInitiate(addItem);
			@SuppressWarnings("resource")
			Scanner scan1 = new Scanner(System.in);
			String selectItem = scan1.nextLine();
			abcItem.add(selectItem);
		}
		
		else if (selectTask==3){
			try{
				System.out.println(server.purchase(session));
			} catch(Exception e){
				System.out.println("Client Exception: " + e.getMessage());
			}
		}
	
		else if (selectTask==2){
			try{
				System.out.println(server.browse(session));
			} catch(Exception e){
				System.out.println("Client Exception: " + e.getMessage());
			}
		}
		
		else if (selectTask==4){
			try{
				System.out.println(server.remove(session));
			} catch(Exception e){
				System.out.println("Client Exception: " + e.getMessage());
			}
			@SuppressWarnings("resource")
			Scanner scan4 = new Scanner(System.in);
			String selectItem = scan4.nextLine();
			abcItem.remove(selectItem);
			clerk.takeInitiate(removeItem);
		}
	
	}

	public void registerListener(AdminController acontroller) {
		// do something
	}
	
}