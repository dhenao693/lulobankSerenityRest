package stepdefinitions;


import co.com.lulo.interaction.services.GetServiceInteraction;
import co.com.lulo.models.employees.Employee;
import co.com.lulo.models.employees.EmployeesList;
import co.com.lulo.questions.ValidateTheStatus;
import co.com.lulo.questions.ValidetaEmployeesList;
import co.com.lulo.tasks.ServicesPutOrPost;
import co.com.lulo.utils.formats.MapsFormat;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.Matchers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

public class ServicesStepDefinition {


    @When("^When the service is type get$")
    public void whenTheServiceIsTypeGet() throws Exception {
        theActorInTheSpotlight().attemptsTo(GetServiceInteraction.callGetServicesIn());
    }

    @When("^When the service is type (.*) with request (.*)")
    public void whenTheServiceIsType(String typeServices, String request) throws Exception {
        theActorInTheSpotlight().attemptsTo(ServicesPutOrPost.called(typeServices).withRequest(request));
    }

    @Then("^status (.*)$")
    public void status(String statusCode) throws Exception {
        //theActorInTheSpotlight().should(seeThat(ValidateTheStatus.code(), equalTo(statusCode)));
    }


    @Then("validate employees list")
    public void validateEmployeesList( List<Map<String,String>> employees) {
        theActorInTheSpotlight().should(seeThat(ValidetaEmployeesList.of(employees)));

    }

}
