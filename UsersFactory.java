// Ryan: Please include useful comments in each file.
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
	
	private String userRole;
	private String[][] accounts = {{"customer"},{"administrator"}};
	
	public UsersFactory(String name){
		userRole = name;
	}
	
	
	public boolean auth() {
		if((userRole.equals(accounts[0][0])))
			return true;
		else
			return false;
	}

}
