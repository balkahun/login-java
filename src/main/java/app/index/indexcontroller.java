package app.index;

import spark.*;


import java.util.*;

import app.user.userdao;
import app.util.*;


public class indexcontroller {
	public static Route serveIndexPage = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();
        model.put("users", userdao.getAllUserNames());
        return viewutil.render(request, model, path.Template.INDEX);
    };
}
