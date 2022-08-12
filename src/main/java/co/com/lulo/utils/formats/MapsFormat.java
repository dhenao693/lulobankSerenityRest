package co.com.lulo.utils.formats;

import co.com.lulo.models.employees.Employee;
import co.com.lulo.models.employees.EmployeesList;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapsFormat {
    private static  ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper

    public static Employee employeeToModel(Map<String,String> map){
        return mapper.convertValue(map, Employee.class);
    }

    public static EmployeesList employeesList (String status, String massage, List<Map<String,String>> employees){
        List<Employee> employeesList = new ArrayList<>();
        for (Map<String,String> map: employees) {
            employeesList.add(employeeToModel(map));
        }
        return new EmployeesList(status,employeesList,massage);
    }
}
