import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * AuthorizationInvocationHandler class
 * @author Russell Sherman
 *
 */

// Create Authorization Invocation Handler used with Java Annotations
public class AuthorizationInvocationHandler implements InvocationHandler, Serializable {
	private static final long serialVersionUID = 6925780928377938176L;
	private Object objectImpl;
 
	public AuthorizationInvocationHandler(Object impl) {
	   this.objectImpl = impl;
	}
	// Invoke method to check Annotation in Requires Role class
	// Create new Session
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if (method.isAnnotationPresent(RequiresRole.class)) {
			RequiresRole test = method.getAnnotation(RequiresRole.class);
			Session session = (Session) args[0];
			
			// FIX: If user role type is correct, proceed. If not, throw Authorization Exception.
			if (session.getUser().getRoleType().equals(test.value())) {
				 return method.invoke(objectImpl, args);
            } else {
            	throw new AuthorizationException(method.getName());
            }
		} else {
			return method.invoke(objectImpl, args);
		}   
	}
}
