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
    private String headerKey1="";
    private String headerValue1="";
    private String headerKey2="";
    private String headerValue2="";
    private String headerKey3="";
    private String headerValue3="";
    private String headerKey4="";
    private String headerValue4="";
    private String headerKey5="";
    private String headerValue5="";
    private String headerKey6="";
    private String headerValue6="";


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

    public GetServiceInteraction andHeader1(String headerKey, String headerValue) {
        this.headerKey1 = headerKey;
        this.headerValue1 = headerValue;
        return this;
    }

    public GetServiceInteraction andHeader2(String headerKey, String headerValue) {
        this.headerKey2 = headerKey;
        this.headerValue2 = headerValue;
        return this;
    }
    public GetServiceInteraction andHeader3(String headerKey, String headerValue) {
        this.headerKey3 = headerKey;
        this.headerValue3 = headerValue;
        return this;
    }
    public GetServiceInteraction andHeader4(String headerKey, String headerValue) {
        this.headerKey4 = headerKey;
        this.headerValue4 = headerValue;
        return this;
    }
    public GetServiceInteraction andHeader5(String headerKey, String headerValue) {
        this.headerKey5 = headerKey;
        this.headerValue5 = headerValue;
        return this;
    }
    public GetServiceInteraction andHeader6(String headerKey, String headerValue) {
        this.headerKey6 = headerKey;
        this.headerValue6 = headerValue;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.whoCan(CallAnApi.at(endPointOrWSDL));
        actor.attemptsTo(Get.resource("").with(
                request -> request.contentType(contenType).accept(accept)
                        .header(headerKey1, headerValue1)
                        .header(headerKey2, headerValue2)
                        .header(headerKey3, headerValue3)
                        .header(headerKey4, headerValue4)
                        .header(headerKey5, headerValue5)
                        .header(headerKey6, headerValue6)
                        .log().all().relaxedHTTPSValidation())
        );

        SerenityRest.lastResponse().prettyPrint();
        ServiceResponse.setResponse(SerenityRest.lastResponse().getBody().asString());
    }
    public static GetServiceInteraction callGetServicesIn(String endPoindOrWSDL) {
        return Tasks.instrumented(GetServiceInteraction.class, endPoindOrWSDL);
    }
}
