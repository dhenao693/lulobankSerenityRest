package co.com.lulo.interaction.services;

import co.com.lulo.models.entitys.ServiceResponse;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Delete;

public class CallDelete implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Delete.from("").with(
                request -> request.contentType(ContentType.JSON)
                        .log().all().relaxedHTTPSValidation())
        );
        SerenityRest.lastResponse().prettyPrint();
        ServiceResponse.setResponse(SerenityRest.lastResponse().getBody().asString());
    }

    public static CallDelete service() {
        return Tasks.instrumented(CallDelete.class);
    }
}
