package co.com.lulo.questions;

import co.com.lulo.models.employees.Employee;
import co.com.lulo.models.employees.EmployeesList;
import co.com.lulo.models.employees.GetEmployeeModel;
import co.com.lulo.models.entitys.ServiceResponse;
import co.com.lulo.utils.compare.EmployeesCompare;
import co.com.lulo.utils.documents.json.JsonUtils;
import co.com.lulo.utils.formats.MapsFormat;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static co.com.lulo.utils.documents.json.JsonUtils.readJsonResponsePersonal;

public class ValidetaEmployee implements Question<Boolean> {
    private GetEmployeeModel employeeObtained;
    private Employee employeeRequired;

    public ValidetaEmployee(List<Map<String,String>> employees) {
        this.employeeRequired  = MapsFormat.employeeToModel(employees.get(0));
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            employeeObtained = JsonUtils.jsonToModel(readJsonResponsePersonal(
//                     "{\n" +
//                             "\"status\": \"success\",\n" +
//                             "\"data\": {\n" +
//                             "\"id\": \"1\",\n" +
//                             "\"employee_name\": \"Tiger Nixon\",\n" +
//                             "\"employee_salary\": \"320800\",\n" +
//                             "\"employee_age\": \"61\",\n" +
//                             "\"profile_image\": \"\"\n" +
//                             "}\n" +
//                             "}"
                     ServiceResponse.getResponse()
                     ,"Employee"), GetEmployeeModel.class);
            System.out.println();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return EmployeesCompare.compareEmployee(employeeObtained.getData(),employeeRequired);
    }

    public static ValidetaEmployee of (List<Map<String,String>> employees){
        return new ValidetaEmployee(employees);
    }
}
