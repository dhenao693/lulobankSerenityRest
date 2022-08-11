package co.com.lulo.interaction.services;

import co.com.lulo.models.entitys.ServiceResponse;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.abiities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Put;

public class PutServiceInteraction implements Task {

    private String endPointOrWSDL;
    private String contenType;
    private String accept;
    private String headerKey;
    private String headerValue;
    private String requestConsume;

    public PutServiceInteraction(String endPointOrWSDL) {
        this.endPointOrWSDL = endPointOrWSDL;
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

    public PutServiceInteraction andRequest(String requestConsume) {
        this.requestConsume = requestConsume;
        return this;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.whoCan(CallAnApi.at(endPointOrWSDL));
        actor.attemptsTo(Put.to("").with(
                request -> request.contentType(contenType).accept(accept)
                        .header(headerKey, headerValue)
                        .body(requestConsume).log().all().relaxedHTTPSValidation())
        );
        SerenityRest.lastResponse().prettyPrint();
        ServiceResponse.setResponse(SerenityRest.lastResponse().getBody().asString());
    }

    public static PutServiceInteraction callPutServicesIn(String endPoindOrWSDL) {
        return Tasks.instrumented(PutServiceInteraction.class, endPoindOrWSDL);
    }

}
