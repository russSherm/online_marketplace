import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Items Class
 * @author Russell Sherman
 */
public class Items {
	//Create Items for Marketplace
    ArrayList<String> itemArray  = new ArrayList<String>();
 
	
	/**
	 * Browse Item
	 */
	public void browse() {
		System.out.println("Item [ Name: "+itemArray+" ]");
	}
	
	/**
	 * Update Item
	 * @param selectItem 
	 */
	public void update(String selectItem) {
		System.out.println("Item [ Name: "+itemArray+" ]");
	}
	
	/**
	 * Remove Item
	 * @param selectItem 
	 */
	public void remove(String selectItem) {
		System.out.println("Item [ Name: "+itemArray+" ]");
	}
	
	/**
	 * Add Item
	 * @param selectItem 
	 * @param string 
	 */
	public void add(String selectItem) {
		System.out.println("Item [ Name: "+itemArray+" ]");
	}
	
	/**
	 * Purchase Item
	 * @param selectItem 
	 */
	public void purchase(String selectItem) {
		System.out.println("Item [ Name: "+itemArray+" ]");
	}

}
