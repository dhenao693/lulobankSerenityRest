package co.com.lulo.exceptions;

import static co.com.lulo.utils.constans.ConstantException.JSONTOMODELFAILURE;

public class JsonToModelException extends RuntimeException {

    public JsonToModelException(Throwable cause) {
        super(JSONTOMODELFAILURE);
    }

}
