package co.com.lulo.tasks;

import co.com.lulo.interaction.services.PostServiceInteraction;
import co.com.lulo.interaction.services.PutServiceInteraction;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.conditions.Check;

public class ServicesPutOrPost implements Task {
    private String serviceType;
    private String request;

    public ServicesPutOrPost(String serviceType) {
        this.serviceType = serviceType;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Check.whether(serviceType.equalsIgnoreCase("POST"))
                .andIfSo(PostServiceInteraction.callPostServicesIn(request))
                .otherwise(PutServiceInteraction.callPutServicesIn(request))
        );
    }

    public static ServicesPutOrPost called(String serviceType){
        return Tasks.instrumented(ServicesPutOrPost.class,serviceType);
    }

    public ServicesPutOrPost withRequest(String request){
        this.request = request;
        return this;
    }
}
