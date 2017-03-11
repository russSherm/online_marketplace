import java.io.Serializable;

/**
 * Create User class to assign role types
 * @author sherman214
 *
 */

public class User implements Serializable {	
	private static final long serialVersionUID = 5384831049786974499L;
	
	private String roleType;
	
	//Assign roleType to User
	public User(String roleType) {
		this.roleType = roleType;
	}
	
	//Get roleType for User
	public String getRoleType() {
		return roleType;
	}
	
}