/**
 * Concrete Command Class
 * @author Russell Sherman
 */
public class AddItem implements Initiate {
	private Items abcItem;
	
	/**
	 * Constructor for Add Item
	 * @param abcItem
	 */
	public AddItem(Items abcItem){
		this.abcItem = abcItem;
	}
	
	/**
	 * Execute Command Method
	 */
	public void execute() {
		abcItem.add(null);
	}
}