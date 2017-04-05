import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Items Class
 * @author Russell Sherman
 */
public class Items {
	//Create Items for Marketplace
	String[] itemArray = { "Socks", "Shoes", "Shirt", "Pants", "Toothbrush", "Chair", "Laptop", "Shampoo", "Soap" };
    List<String> abcItem = new ArrayList<String>(Arrays.asList(itemArray));
 
	
	/**
	 * Browse Item
	 */
	public void browse() {
		System.out.println("Item [ Name: "+abcItem+" ]");
	}
	
	/**
	 * Update Item
	 * @param selectItem 
	 */
	public void update(String selectItem) {
		System.out.println("Item [ Name: "+abcItem+" ]");
	}
	
	/**
	 * Remove Item
	 * @param selectItem 
	 */
	public void remove(String selectItem) {
		System.out.println("Item [ Name: "+abcItem+" ]");
	}
	
	/**
	 * Add Item
	 * @param selectItem 
	 * @param string 
	 */
	public void add(String selectItem) {
		System.out.println("Item [ Name: "+abcItem+" ]");
	}
	
	/**
	 * Purchase Item
	 * @param selectItem 
	 */
	public void purchase(String selectItem) {
		System.out.println("Item [ Name: "+abcItem+" ]");
	}

}
