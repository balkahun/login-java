package app.util;
import spark.*;

public class util {
	 public static String getQueryUsername(Request request) {
	        return request.queryParams("username");
	    }

	    public static String getQueryPassword(Request request) {
	        return request.queryParams("password");
	    }

	    public static String getQueryLoginRedirect(Request request) {
	        return request.queryParams("loginRedirect");
	    }
	    public static String getSessionCurrentUser(Request request) {
	        return request.session().attribute("currentUser");
	    }

	    public static boolean removeSessionAttrLoggedOut(Request request) {
	        Object loggedOut = request.session().attribute("loggedOut");
	        request.session().removeAttribute("loggedOut");
	        return loggedOut != null;
	    }

	    public static String removeSessionAttrLoginRedirect(Request request) {
	        String loginRedirect = request.session().attribute("loginRedirect");
	        request.session().removeAttribute("loginRedirect");
	        return loginRedirect;
	    }
}
