/**
 * Concrete Command Class
 * @author Russell Sherman
 */
public class UpdateItem implements Initiate {
	private Items abcItem;
	
	/**
	 * Constructor for Purchase Item
	 * @param abcItem
	 */
	public UpdateItem(Items abcItem){
		this.abcItem = abcItem;
	}
	
	/**
	 * Execute Command Method
	 * sychronize method
	 */
	synchronized public void execute() {
		abcItem.update(null);
	}
}