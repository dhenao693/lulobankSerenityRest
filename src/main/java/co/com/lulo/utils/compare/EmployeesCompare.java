package co.com.lulo.utils.compare;

import co.com.lulo.models.employees.Employee;
import co.com.lulo.models.employees.EmployeesList;

public class EmployeesCompare {

    public static boolean compareEmployee(Employee employee1, Employee employee2) {
        return employee1.getId().equalsIgnoreCase(employee2.getId()) &&
                employee1.getEmployee_age().equalsIgnoreCase(employee2.getEmployee_age()) &&
                employee1.getEmployee_name().equalsIgnoreCase(employee2.getEmployee_name()) &&
                employee1.getEmployee_salary().equalsIgnoreCase(employee2.getEmployee_salary());
    }

    public static boolean compareEmployeeInEmployeesList(EmployeesList employeesList, Employee employee) {
        for (Employee employeeToCompare : employeesList.getData()) {
            if (employeeToCompare.getId().equalsIgnoreCase(employee.getId())) {
                return compareEmployee(employeeToCompare, employee);
            }
        }
        return false;
    }

    public static boolean compareEmployeeListInEmployeesList(EmployeesList employeesListFull, EmployeesList employeesList) {
        for (Employee employeeToCompare : employeesList.getData()) {
            if (!compareEmployeeInEmployeesList(employeesListFull, employeeToCompare)) {return false;}
        }
        return true;
    }
}
