package co.com.lulo.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateMassage implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return SerenityRest.lastResponse().getBody().path("message").toString();
    }

    public static ValidateMassage ofDelete(){
        return new ValidateMassage();
    }
}
