package app.login;

import spark.*;
import java.util.*;
import app.util.*;
import app.user.*;
import static app.util.util.*;

public class logincontroller {
	public static Route serveLoginPage = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();
        model.put("loggedOut", util.removeSessionAttrLoggedOut(request));
        model.put("loginRedirect", util.removeSessionAttrLoginRedirect(request));
        return viewutil.render(request, model, path.Template.LOGIN);
    };

    public static Route handleLoginPost = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();
        if (!usercontroller.authenticate(getQueryUsername(request), getQueryPassword(request))) {
            model.put("authenticationFailed", true);
            return viewutil.render(request, model, path.Template.LOGIN);
        }
        model.put("authenticationSucceeded", true);
        request.session().attribute("currentUser", getQueryUsername(request));
        if (util.getQueryLoginRedirect(request) != null) {
            response.redirect(util.getQueryLoginRedirect(request));
        }
        return viewutil.render(request, model, path.Template.LOGIN);
    };

    public static Route handleLogoutPost = (Request request, Response response) -> {
        request.session().removeAttribute("currentUser");
        request.session().attribute("loggedOut", true);
        response.redirect(path.Web.LOGIN);
        return null;
    };

    // The origin of the request (request.pathInfo()) is saved in the session so
    // the user can be redirected back after login
    public static void ensureUserIsLoggedIn(Request request, Response response) {
        if (request.session().attribute("currentUser") == null) {
            request.session().attribute("loginRedirect", request.pathInfo());
            response.redirect(path.Web.LOGIN);
        }
    };

}
