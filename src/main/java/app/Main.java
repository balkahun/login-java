package app;
import static spark.Spark.*;
import static spark.debug.DebugScreen.*;

import app.index.*;
import app.login.*;
import app.user.*;
import app.util.*;
public class Main {
	
	public static userdao userDao;
public static void main(String[] args){
	 // Configure Spark
    port(4567);
    staticFiles.location("/public");
    staticFiles.expireTime(600L);
    enableDebugScreen();
    
    userDao = new userdao();

	
	get(path.Web.INDEX,          indexcontroller.serveIndexPage);
    get(path.Web.LOGIN,          logincontroller.serveLoginPage);
    post(path.Web.LOGIN,         logincontroller.handleLoginPost);
    post(path.Web.LOGOUT,        logincontroller.handleLogoutPost);
    get("*",                     viewutil.notFound);

}

}
