package co.com.lulo.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateStatusMassage implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return SerenityRest.lastResponse().getBody().path("status").toString();
    }

    public static ValidateStatusMassage ofDelete(){
        return new ValidateStatusMassage();
    }
}
