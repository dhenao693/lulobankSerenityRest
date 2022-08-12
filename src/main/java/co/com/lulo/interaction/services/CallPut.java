package co.com.lulo.interaction.services;

import co.com.lulo.models.entitys.ServiceResponse;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Put;

public class CallPut implements Task {

    private String contenType;
    private String accept;
    private String headerKey;
    private String headerValue;
    private String requestConsume;

    public CallPut(String requestConsume) {
        this.requestConsume = requestConsume;
    }

    public CallPut withMessageInJson() {
        contenType = "application/json; charset=UTF-8";
        accept = "*/*";
        return this;
    }

    public CallPut notHeader() {
        this.headerKey = "";
        this.headerValue = "";
        return this;
    }

    public CallPut andHeader(String headerKey, String headerValue) {
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

    public static CallPut service(String requestConsume) {
        return Tasks.instrumented(CallPut.class, requestConsume);
    }

}
