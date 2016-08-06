package app.util;

import org.apache.velocity.app.*;
import org.eclipse.jetty.http.*;
import spark.*;
import spark.template.velocity.*;
import java.util.*;

public class viewutil {
	 public static String render(Request request, Map<String, Object> model, String templatePath) {
	 
	        model.put("currentUser", util.getSessionCurrentUser(request));
	        model.put("WebPath", path.Web.class); // Access application URLs from templates
	        return strictVelocityEngine().render(new ModelAndView(model, templatePath));
	    }

	    public static Route notAcceptable = (Request request, Response response) -> {
	        response.status(HttpStatus.NOT_ACCEPTABLE_406);
	        return "ERROR_406_NOT_ACCEPTABLE";
	    };

	    public static Route notFound = (Request request, Response response) -> {
	        response.status(HttpStatus.NOT_FOUND_404);
	        return render(request, new HashMap<>(), path.Template.NOT_FOUND);
	    };

	    private static VelocityTemplateEngine strictVelocityEngine() {
	        VelocityEngine configuredEngine = new VelocityEngine();
	        configuredEngine.setProperty("runtime.references.strict", true);
	        configuredEngine.setProperty("resource.loader", "class");
	        configuredEngine.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
	        return new VelocityTemplateEngine(configuredEngine);
	    }
}
