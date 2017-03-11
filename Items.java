/**
 * Items Class
 * @author Russell Sherman
 */
public class Items {
	//Create Items for Marketplace
	//Sample Item for commands only
	private String name = "Socks";
	private int quantity = 2;
	
	/**
	 * Browse Item
	 */
	public void browse() {
		System.out.println("Item [ Name: "+name+", Browsed: " +quantity+" ]");
	}
	
	/**
	 * Update Item
	 */
	public void update() {
		System.out.println("Item [ Name: "+name+", Updated: " +quantity+" ]");
	}
	
	/**
	 * Remove Item
	 */
	public void remove() {
		System.out.println("Item [ Name: "+name+", Removed: " +quantity+" ]");
	}
	
	/**
	 * Add Item
	 */
	public void add() {
		System.out.println("Item [ Name: "+name+", Added: " +quantity+" ]");
	}
	
	/**
	 * Purchase Item
	 */
	public void purchase() {
		System.out.println("Item [ Name: "+name+", Purchased: " +quantity+" ]");
	}

}
