import controllers.HomeController;
import org.junit.Ignore;
import org.junit.Test;
import play.Application;
import play.inject.guice.GuiceApplicationBuilder;
import play.mvc.Result;
import play.test.WithApplication;
import play.twirl.api.Content;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static play.mvc.Http.Status.NOT_FOUND;
import static play.mvc.Http.Status.OK;
import static play.test.Helpers.contentAsString;

public class ApplicationTest extends WithApplication {

    @Override
    protected Application provideApplication() {
        return new GuiceApplicationBuilder()
                .build();
    }

    @Test
    public void testIndex() {
        Result result = new HomeController().index();
        assertEquals(OK, result.status());
        assertEquals("text/html", result.contentType().get());
        assertEquals("utf-8", result.charset().get());
        assertTrue(contentAsString(result).contains("Your new application is ready."));
    }

    @Test
    public void testJson() {
        Result result = new HomeController().json();
        assertEquals(OK, result.status());
        assertEquals("application/json", result.contentType().get());
        assertEquals("{\"key\":\"value\"}", contentAsString(result));
    }

    @Test
    @Ignore
    public void testGetRequest() {
        Result result = new HomeController().getRequest();
        assertEquals(OK, result.status());
    }

    @Test
    public void testPageNotFound() {
        Result result = new HomeController().pageNotFound();
        assertEquals(NOT_FOUND, result.status());
    }

    @Test
    public void testWelcome() {
        Result result = new HomeController().welcome("Fred");
        assertEquals(OK, result.status());
        assertEquals("text/plain", result.contentType().get());
        assertEquals("Hello Fred", contentAsString(result));
    }

    @Test
    public void renderTemplate() {
        Content html = views.html.index.render("Welcome to Play!");
        assertEquals("text/html", html.contentType());
        assertTrue(contentAsString(html).contains("Welcome to Play!"));
    }
}
