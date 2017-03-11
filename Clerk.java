import java.util.ArrayList;
import java.util.List;

/**
 * Invoker Object
 * @author Russell Sherman
 */

public class Clerk {
	private List<Initiate> initiateList = new ArrayList<Initiate>();
	
	/**
	 * Given a command request initiate the command
	 * 
	 * @param initiate
	 */
	public void takeInitiate(Initiate initiate){
		initiateList.add(initiate);
	}
	
	/**
	 * Initiate each command that has been taken
	 */
	public void placeInitiate() {
		for (Initiate initiate : initiateList) {
			initiate.execute();
		}
		initiateList.clear();
	}
	
}
