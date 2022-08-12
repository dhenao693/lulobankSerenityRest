package co.com.lulo.interaction.services;

import co.com.lulo.models.entitys.ServiceResponse;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class CallPost implements Interaction {

    private String requestConsume;

    public CallPost(String requestConsume) {
        this.requestConsume = requestConsume;
    }

    public CallPost andRequest(String requestConsume) {
        this.requestConsume = requestConsume;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to("").with(
                request -> request.contentType(ContentType.JSON)
                        .body(requestConsume).log().all().relaxedHTTPSValidation()));
        SerenityRest.lastResponse().prettyPrint();
        ServiceResponse.setRequest(requestConsume);
        ServiceResponse.setResponse(SerenityRest.lastResponse().getBody().asString());
    }

    public static CallPost service(String requestConsume) {
        return Tasks.instrumented(CallPost.class, requestConsume);
    }
}
