package co.com.lulo.interaction.services;

import co.com.lulo.models.entitys.ServiceResponse;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Put;

public class PutServiceInteraction implements Task {

    private String contenType;
    private String accept;
    private String headerKey;
    private String headerValue;
    private String requestConsume;

    public PutServiceInteraction(String requestConsume) {
        this.requestConsume = requestConsume;
    }

    public PutServiceInteraction withMessageInJson() {
        contenType = "application/json; charset=UTF-8";
        accept = "*/*";
        return this;
    }

    public PutServiceInteraction notHeader() {
        this.headerKey = "";
        this.headerValue = "";
        return this;
    }

    public PutServiceInteraction andHeader(String headerKey, String headerValue) {
        this.headerKey = headerKey;
        this.headerValue = headerValue;
        return this;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Put.to("").with(
                request -> request.contentType(ContentType.JSON)
                        .header(headerKey, headerValue)
                        .body(requestConsume).log().all().relaxedHTTPSValidation())
        );
        SerenityRest.lastResponse().prettyPrint();
        ServiceResponse.setResponse(SerenityRest.lastResponse().getBody().asString());
    }

    public static PutServiceInteraction callPutServicesIn(String requestConsume) {
        return Tasks.instrumented(PutServiceInteraction.class, requestConsume);
    }

}
