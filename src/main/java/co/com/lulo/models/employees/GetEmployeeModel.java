package co.com.lulo.models.employees;

public class GetEmployeeModel {
    private Employee data;
    private String status;

    public Employee getData() {
        return data;
    }

    public void setData(Employee data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
