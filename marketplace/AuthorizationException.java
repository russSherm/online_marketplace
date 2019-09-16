
/**
 * Create custom exception for any denied authorization commands
 * @author Russell Sherman
 *
 */

public class AuthorizationException extends RuntimeException {
	private static final long serialVersionUID = 5528415690278423524L;

	public AuthorizationException(String methodName) {
		super("Sorry, you don't have access to the " + methodName + " function!");
	}
}
