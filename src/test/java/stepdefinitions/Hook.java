package stepdefinitions;

import co.com.lulo.utils.properties.json.ServicesProperties;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static co.com.lulo.utils.constans.GeneralConstant.ACTOR_DEFAULT;
import static co.com.lulo.utils.constans.GeneralConstant.END_POINT;
import static co.com.lulo.utils.properties.json.ServicesProperties.getPropertie;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class Hook {

    @Before
    public static void inicializar(){
        setTheStage(new OnlineCast());
        theActorCalled(ACTOR_DEFAULT);
    }

    @Given("^the user send a request to (.*)$")
    public void theUserSendARequestToEmployees(String path) throws Exception {
        theActorInTheSpotlight().remember(END_POINT, String.format(getPropertie(END_POINT),path));
    }
}
