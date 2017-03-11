import java.io.Serializable;

/**
 * Create Session Class
 * @author sherman214
 *
 */

public class Session implements Serializable {
	private static final long serialVersionUID = 6590975621573939463L;
	
	private User user;
	
	public Session(String userType) {
		user = new User(userType);
	}
	
	public User getUser() {
		return user;
	}
}