package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import models.Task;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import views.html.tasks;

public class Application extends Controller {

    public Result index() {
//        response().setHeader(CACHE_CONTROL, "max-age=3600");
//        response().setHeader(ETAG, "xxx");
//        response().setCookie("theme", "blue");
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

    public Result pageNotFoundPage() {
        return notFound("<h1>Page not found</h1>").as("text/html");
    }

    public Result welcome(String name) {
        return ok("Hello " + name);
    }

    public Result error() {
        return internalServerError("Error");
    }

    public Result status() {
        return status(200, "Success");
    }

    public Result redirect() {
        return redirect("http://www.bbc.co.uk/news");
    }

    public Result newWelcome(String name) {
        return redirect(Application.welcome(name));
    }

    public Result tasks() {
        return ok(tasks.render(Task.find.all()));
    }
}
