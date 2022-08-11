package co.com.lulo.interaction.services;

import co.com.lulo.models.entitys.ServiceResponse;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.abiities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class GetServiceInteraction implements Task {

    private String endPointOrWSDL;
    private String contenType;
    private String accept;

    public GetServiceInteraction(String endPointOrWSDL) {
        this.endPointOrWSDL = endPointOrWSDL;
    }

    public GetServiceInteraction withMessageInJson() {
        contenType = "application/json; charset=UTF-8";
        accept = "*/*";
        return this;
    }

    public GetServiceInteraction withMessageInXML() {
        contenType = "text/xml; charset=UTF-8";
        accept = "application/xml";
        return this;
    }



    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.whoCan(CallAnApi.at(endPointOrWSDL));
        actor.attemptsTo(Get.resource("").with(
                request -> request.contentType("application/json; charset=UTF-8").accept("*/*")
                        .log().all().relaxedHTTPSValidation())
        );

        SerenityRest.lastResponse().prettyPrint();
        ServiceResponse.setResponse(SerenityRest.lastResponse().getBody().asString());
    }
    public static GetServiceInteraction callGetServicesIn(String endPoindOrWSDL) {
        return Tasks.instrumented(GetServiceInteraction.class, endPoindOrWSDL);
    }
}
