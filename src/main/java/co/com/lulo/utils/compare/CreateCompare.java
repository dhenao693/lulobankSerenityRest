package co.com.lulo.utils.compare;

import co.com.lulo.models.createservics.CreateResponse;
import co.com.lulo.models.createservics.Data;

public class CreateCompare {
    public static boolean compareData(Data dataRequired, Data dataobtained) {
        return  dataRequired.getAge().equalsIgnoreCase(dataobtained.getAge()) &&
                dataRequired.getName().equalsIgnoreCase(dataobtained.getName()) &&
                dataRequired.getSalary().equalsIgnoreCase(dataobtained.getSalary());
    }

    public static boolean CompareDataInResponse(Data dataRequired, CreateResponse dataobtained) {
        return compareData(dataobtained.getData(), dataRequired);
    }
}
