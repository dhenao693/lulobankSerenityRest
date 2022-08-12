package co.com.lulo.questions;

import co.com.lulo.models.employees.Employee;
import co.com.lulo.models.employees.EmployeesList;
import co.com.lulo.models.entitys.ServiceResponse;
import co.com.lulo.utils.documents.json.JsonUtils;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.io.IOException;
import java.util.List;

import static co.com.lulo.utils.documents.json.JsonUtils.readJsonResponsePersonal;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.*;

public class ValidetaEmployeesList implements Question<Boolean> {
    private EmployeesList employeesList;
    private List<Employee> employeesList2;

    public ValidetaEmployeesList(List<Employee> employeesList2) {
        this.employeesList2 = employeesList2;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
             employeesList = JsonUtils.jsonToModel(readJsonResponsePersonal(
                    "{\n" +
                            "\"status\": \"success\",\n" +
                            "\"data\": [\n" +
                            "\t{\n" +
                            "\t\"id\": \"1\",\n" +
                            "\t\"employee_name\": \"Tiger Nixon\",\n" +
                            "\t\"employee_salary\": \"320800\",\n" +
                            "\t\"employee_age\": \"61\",\n" +
                            "\t\"profile_image\": \"\"\n" +
                            "\t}\n" +
                            "\t]\n" +
                            "}"
                    //ServiceResponse.getResponse()
                    ,"Test"), EmployeesList.class);


            System.out.println();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static ValidetaEmployeesList of (List<Employee> emplyees){
        return new ValidetaEmployeesList(emplyees);
    }
}
