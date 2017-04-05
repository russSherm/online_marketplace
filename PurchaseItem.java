/**
 * Concrete Command Class
 * @author Russell Sherman
 */
public class PurchaseItem implements Initiate {
	private Items abcItem;
	
	/**
	 * Constructor for Purchase Item
	 * @param abcItem
	 */
	public PurchaseItem(Items abcItem){
		this.abcItem = abcItem;
	}
	
	/**
	 * Execute Command Method
	 */
	public void execute() {
		abcItem.purchase(null);
	}
}
