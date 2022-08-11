package stepdefinitions;

import co.com.lulo.interaction.services.GetServiceInteraction;
import co.com.lulo.models.entitys.ServiceResponse;
import co.com.lulo.utils.constans.GeneralConstant;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.rest.abiities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.actors.OnStage.*;

public class ServicesStepDefinition {


    @When("^When the service is type (.*)$")
    public void whenTheServiceIsType(String typeServices) throws Exception {
        System.out.println(theActorInTheSpotlight().recall(GeneralConstant.END_POINT).toString());
        //theActorInTheSpotlight().attemptsTo(GetServiceInteraction.callGetServicesIn(theActorInTheSpotlight().recall(GeneralConstant.END_POINT).toString()).withMessageInJson());
        theActorInTheSpotlight().whoCan(CallAnApi.at("http://dummy.restapiexample.com/api/v1"));
        theActorInTheSpotlight().attemptsTo(Get.resource("/employees/1").with(
                request -> request.contentType("application/json; charset=UTF-8").accept("*/*")
                        .log().all().relaxedHTTPSValidation())
        );
        SerenityRest.lastResponse().prettyPrint();

    }

    @Then("^status (.*)$")
    public void status(int arg1) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

}
