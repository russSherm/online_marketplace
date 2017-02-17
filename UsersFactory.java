
public class UsersFactory extends AbstractFactory {
	@Override
	Users createUser(String username) {
		/*
		if(userType.equalsIgnoreCase("ADMIN")){
			return new Administrator();
		}
		else if(userType.equalsIgnoreCase("CUSTOMER")){
			return new Customers();
		}
		*/
		return null;
		
	}
	
	private String username;
	private String[][] accounts = {{"Ryan"},{"Andrew"},{"Russell"}};
	
	public UsersFactory(String name){
		username = name;
	}
	
	
	public boolean auth() {
		if((username.equals(accounts[0][0])))
			return true;
		else
			return false;
	}

}
