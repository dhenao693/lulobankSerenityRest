package co.com.lulo.models.entitys;

public class ServiceResponse {

    private static String response;
    private static String status;

    public static String getStatus() {return status;}

    public static void setStatus(String status) {ServiceResponse.status = status;}

    public static String getResponse() {
        return ServiceResponse.response;
    }

    public static void setResponse(String response) {
        ServiceResponse.response = response;
    }

}
