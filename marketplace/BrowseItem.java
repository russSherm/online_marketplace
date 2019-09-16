/**
 * Concrete Command Class
 * @author Russell Sherman
 */
public class BrowseItem implements Initiate {
	private Items abcItem;
	
	/**
	 * Constructor for Purchase Item
	 * @param abcItem
	 */
	public BrowseItem(Items abcItem){
		this.abcItem = abcItem;
	}
	
	/**
	 * Execute Command Method
	 * synchronized
	 */
	synchronized public void execute() {
		abcItem.browse();
	}
}
