package co.com.lulo.interaction.services;

import co.com.lulo.models.entitys.ServiceResponse;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Delete;

public class DeleteServiceInteraction  implements Task {

    private String endPointOrWSDL;
    private String contenType;
    private String accept;
    private String paramKey;
    private String paramValue;

    public DeleteServiceInteraction(String endPointOrWSDL) {
        this.endPointOrWSDL = endPointOrWSDL;
    }

    public DeleteServiceInteraction withMessageInJson() {
        contenType = "application/json; charset=UTF-8";
        accept = "*/*";
        return this;
    }

    public DeleteServiceInteraction andParam(String paramKey, String paramValue) {
        this.paramKey = paramKey;
        this.paramValue = paramValue;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.whoCan(CallAnApi.at(endPointOrWSDL));
        actor.attemptsTo(Delete.from("").with(
                request -> request.contentType(contenType).accept(accept)
                        .param(paramKey,paramValue)
                        .log().all().relaxedHTTPSValidation())
        );

        SerenityRest.lastResponse().prettyPrint();
        ServiceResponse.setResponse(SerenityRest.lastResponse().getBody().asString());
    }

    public static DeleteServiceInteraction callDeleteServicesIn(String endPoindOrWSDL) {
        return Tasks.instrumented(DeleteServiceInteraction.class, endPoindOrWSDL);
    }
}
