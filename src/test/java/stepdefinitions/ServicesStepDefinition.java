package stepdefinitions;


import co.com.lulo.interaction.services.DeleteServiceInteraction;
import co.com.lulo.interaction.services.GetServiceInteraction;
import co.com.lulo.questions.ValidateCreate;
import co.com.lulo.questions.ValidateMassage;
import co.com.lulo.questions.ValidateStatusMassage;
import co.com.lulo.questions.ValidateTheStatus;
import co.com.lulo.questions.ValidetaEmployee;
import co.com.lulo.questions.ValidetaEmployeesList;
import co.com.lulo.tasks.ServicesPutOrPost;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

public class ServicesStepDefinition {


    @When("^the service is type get$")
    public void whenTheServiceIsTypeGet() throws Exception {
        theActorInTheSpotlight().attemptsTo(GetServiceInteraction.callGetServicesIn());
    }

    @When("^the service is type delete")
    public void whenTheServiceIsTypeDelete() throws Exception {
        theActorInTheSpotlight().attemptsTo(DeleteServiceInteraction.callDeleteServices());
    }

    @When("^the service is type (.*) with request (.*)")
    public void TheServiceIsType(String typeServices, String request) throws Exception {
        theActorInTheSpotlight().attemptsTo(ServicesPutOrPost.called(typeServices).withRequest(request));
    }

    @Then("^status (.*)$")
    public void status(String statusCode) throws Exception {
       // theActorInTheSpotlight().should(seeThat(ValidateTheStatus.code(), equalTo(statusCode)));
    }

    @Then("validate create response")
    public void validateCreateResponse() {
        theActorInTheSpotlight().should(seeThat(ValidateCreate.services()));
    }

    @Then("validate employees list")
    public void validateEmployeesList( List<Map<String,String>> employees) {
        theActorInTheSpotlight().should(seeThat(ValidetaEmployeesList.of(employees)));

    }

    @Then("validate employee")
    public void validateEmployee( List<Map<String,String>> employee) {
        theActorInTheSpotlight().should(seeThat(ValidetaEmployee.of(employee)));

    }

    @Then("validate status and massage")
    public void validateStatusAndMassage( List<Map<String,String>> dataDelete) {
        //theActorInTheSpotlight().should(seeThat(ValidateMassage.ofDelete(), equalTo(dataDelete.get(0).get("massage"))));
        //theActorInTheSpotlight().should(seeThat(ValidateStatusMassage.ofDelete(), equalTo(dataDelete.get(0).get("status"))));
    }

}
