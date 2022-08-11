package co.com.lulo.interaction.services;

import co.com.lulo.models.entitys.ServiceResponse;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.abiities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class PostServiceInteraction implements Interaction {

    private String endPointOrWSDL;
    private String contenType;
    private String accept;
    private String requestConsume;
    private String headerKey1 = "";
    private String headerKey2 = "";
    private String headerKey3 = "";
    private String headerKey4 = "";
    private String headerKey5 = "";
    private String headerKey6 = "";
    private String headerKey7 = "";
    private String headerKey8 = "";
    private String headerKey9 = "";


    private String headerValue1 = "";
    private String headerValue2 = "";
    private String headerValue3 = "";
    private String headerValue4 = "";
    private String headerValue5 = "";
    private String headerValue6 = "";
    private String headerValue7 = "";
    private String headerValue8 = "";
    private String headerValue9 = "";



    public PostServiceInteraction(String endPointOrWSDL) {
        this.endPointOrWSDL = endPointOrWSDL;
    }

    public PostServiceInteraction withMessageInJson() {
        contenType = "application/json; charset=UTF-8";
        accept = "*/*";
        return this;
    }

    public PostServiceInteraction withMessageInXML() {
        contenType = "text/xml; charset=UTF-8";
        accept = "application/xml";
        return this;
    }

    public PostServiceInteraction andRequest(String requestConsume) {
        this.requestConsume = requestConsume;
        return this;
    }



    public PostServiceInteraction andHeader1(String headerKey1, String headerValue1) {
        this.headerKey1 = headerKey1;
        this.headerValue1 = headerValue1;
        return this;
    }

    public PostServiceInteraction andHeader2(String headerKey2, String headerValue2) {
        this.headerKey2 = headerKey2;
        this.headerValue2 = headerValue2;
        return this;
    }

    public PostServiceInteraction andHeader3(String headerKey3, String headerValue3) {
        this.headerKey3 = headerKey3;
        this.headerValue3 = headerValue3;
        return this;
    }

    public PostServiceInteraction andHeader4(String headerKey4, String headerValue4) {
        this.headerKey4 = headerKey4;
        this.headerValue4 = headerValue4;
        return this;
    }

    public PostServiceInteraction andHeader5(String headerKey5, String headerValue5) {
        this.headerKey5 = headerKey5;
        this.headerValue5 = headerValue5;
        return this;
    }
    public PostServiceInteraction andHeader6(String headerKey6, String headerValue6) {
        this.headerKey6 = headerKey6;
        this.headerValue6 = headerValue6;
        return this;
    }

    public PostServiceInteraction andHeader7(String headerKey7, String headerValue7) {
        this.headerKey7 = headerKey7;
        this.headerValue7 = headerValue7;
        return this;
    }

    public PostServiceInteraction andHeader8(String headerKey8, String headerValue8) {
        this.headerKey8 = headerKey8;
        this.headerValue8 = headerValue8;
        return this;
    }

    public PostServiceInteraction andHeader9(String headerKey9, String headerValue9) {
        this.headerKey9 = headerKey9;
        this.headerValue9 = headerValue9;
        return this;
    }

    public PostServiceInteraction andAccept(String accept) {
        this.accept = accept;
        return this;
    }
    public PostServiceInteraction andContenType(String contenType) {
        this.contenType = contenType;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.whoCan(CallAnApi.at(endPointOrWSDL));
        actor.attemptsTo(Post.to("").with(
                request -> request.contentType(contenType).accept(accept)
                        .header(headerKey1, headerValue1)
                        .header(headerKey2, headerValue2)
                        .header(headerKey3, headerValue3)
                        .header(headerKey4, headerValue4)
                        .header(headerKey5, headerValue5)
                        .header(headerKey6, headerValue6)
                        .header(headerKey7, headerValue7)
                        .header(headerKey8, headerValue8)
                        .header(headerKey9, headerValue9)
                        .body(requestConsume).log().all().relaxedHTTPSValidation()));
        SerenityRest.lastResponse().prettyPrint();
        ServiceResponse.setResponse(SerenityRest.lastResponse().getBody().asString());
    }

    public static PostServiceInteraction callPostServicesIn(String endPoindOrWSDL) {
        return Tasks.instrumented(PostServiceInteraction.class, endPoindOrWSDL);
    }


}
