package co.com.lulo.interaction.services;

import co.com.lulo.models.entitys.ServiceResponse;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class GetServiceInteraction implements Task {

    public GetServiceInteraction() {
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource("")
                .with(requestSpecification
                        -> requestSpecification.contentType(ContentType.JSON)
                        .log().all().relaxedHTTPSValidation())
        );

        SerenityRest.lastResponse().prettyPrint();
        ServiceResponse.setResponse(SerenityRest.lastResponse().getBody().asString());
    }
    public static GetServiceInteraction callGetServicesIn() {
        return Tasks.instrumented(GetServiceInteraction.class);
    }
}
