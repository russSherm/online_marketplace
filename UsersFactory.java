/**
 * UsersFactory
 * @author Russell Sherman
 *
 */

// Create UsersFactory and use for assigning new users to the correct type
public class UsersFactory extends AbstractFactory {
	@Override
	Users createUser(String userType) {
		if(userType.equalsIgnoreCase("adminstrator")){
			return new Administrators();
		}
		else if(userType.equalsIgnoreCase("customer")){
			return new Customers();
		}
		return null;
		
	}
	
	// Create userRole variable
	private String userRole;
	
	public UsersFactory(String name){
		userRole = name;
	}
	
	// Use auth to return the correct user type
	public boolean auth() {
		if((userRole.equals("administrator")))
			return true;
		else
			return false;
	}

}
