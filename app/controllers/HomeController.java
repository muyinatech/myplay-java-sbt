package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class HomeController extends Controller {

    public Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public Result json() {
        ObjectNode result = Json.newObject();
        result.put("key", "value");
        return ok(result);
    }

    public Result getRequest() {
        return ok("Got request " + request() + "!");
    }

    public Result pageNotFound() {
        return notFound();
    }

    public Result welcome(String name) {
        return ok("Hello " + name);
    }
}
