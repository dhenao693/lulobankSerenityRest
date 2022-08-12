package stepdefinitions;

import co.com.lulo.utils.properties.json.ServicesProperties;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static co.com.lulo.utils.constans.GeneralConstant.ACTOR_DEFAULT;
import static co.com.lulo.utils.constans.GeneralConstant.END_POINT;
import static co.com.lulo.utils.properties.json.ServicesProperties.getPropertie;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class Hook {

    @Before
    public static void inicializar(){
        setTheStage(new OnlineCast());
        theActorCalled(ACTOR_DEFAULT);
    }

    @Given("^the (.*) send a request to (.*)$")
    public void theUserSendARequestToEmployees(String user, String path) throws Exception {
        theActorCalled(user).whoCan(CallAnApi.at(String.format(getPropertie(END_POINT),path)));
    }
}
