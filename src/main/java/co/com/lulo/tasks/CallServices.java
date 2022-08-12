package co.com.lulo.tasks;

import co.com.lulo.interaction.services.CallPost;
import co.com.lulo.interaction.services.CallPut;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.conditions.Check;

public class CallServices implements Task {
    private String serviceType;
    private String request;

    public CallServices(String serviceType) {
        this.serviceType = serviceType;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Check.whether(serviceType.equalsIgnoreCase("POST"))
                .andIfSo(CallPost.service(request))
                .otherwise(CallPut.service(request))
        );
    }

    public static CallServices called(String serviceType){
        return Tasks.instrumented(CallServices.class,serviceType);
    }

    public CallServices withRequest(String request){
        this.request = request;
        return this;
    }
}
