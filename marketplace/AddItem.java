import java.util.Scanner;

/**
 * Concrete Command Class
 * @author Russell Sherman
 */

public class AddItem implements Initiate {
	private Items itemArray;
	
	/**
	 * Constructor for Add Item
	 */
	public AddItem(Items itemArray){
		this.itemArray = itemArray;
	}
	
	/**
	 * Execute Command Method
	 * sychronize method
	 */
	public synchronized void execute() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String additem = null;
		
		System.out.println("What product would you like to add?");
		additem = input.nextLine();
		
		itemArray.add(additem);
	}
}
