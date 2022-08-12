package co.com.lulo.questions;

import co.com.lulo.models.createservics.CreateResponse;
import co.com.lulo.models.createservics.Data;
import co.com.lulo.models.employees.GetEmployeeModel;
import co.com.lulo.models.entitys.ServiceResponse;
import co.com.lulo.utils.compare.CreateCompare;
import co.com.lulo.utils.documents.json.JsonUtils;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.io.IOException;

import static co.com.lulo.utils.documents.json.JsonUtils.readJsonResponsePersonal;

public class ValidateCreate implements Question<Boolean> {
    private CreateResponse createResponse;
    private Data createRequest;
    private String request;

    @Override
    public Boolean answeredBy(Actor actor) {
        try {

            createRequest = JsonUtils.jsonToModel(readJsonResponsePersonal(
                    ServiceResponse.getRequest()
                    , "CreateRequest"), Data.class);


            createResponse = JsonUtils.jsonToModel(readJsonResponsePersonal(
//                    "{\n" +
//                            "    \"status\": \"success\",\n" +
//                            "    \"data\": {\n" +
//                            "        \"name\": \"test\",\n" +
//                            "        \"salary\": \"123\",\n" +
//                            "        \"age\": \"23\",\n" +
//                            "        \"id\": 25\n" +
//                            "    }\n" +
//                            "}"
                    ServiceResponse.getResponse()
                    , "CreateResponse"), CreateResponse.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return CreateCompare.CompareDataInResponse(createRequest, createResponse);
    }

    public static ValidateCreate services() {
        return new ValidateCreate();
    }
}
