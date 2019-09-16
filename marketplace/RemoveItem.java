/**
 * Concrete Command Class
 * @author Russell Sherman
 */
public class RemoveItem implements Initiate {
	private Items abcItem;
	
	/**
	 * Constructor for Remove Item
	 * @param abcItem
	 */
	public RemoveItem(Items abcItem){
		this.abcItem = abcItem;
	}
	
	/**
	 * Execute Command Method
	 * synchronize method
	 */
	synchronized public void execute() {
		abcItem.remove(null);
	}
}
