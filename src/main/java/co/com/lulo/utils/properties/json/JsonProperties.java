package co.com.lulo.utils.properties.json;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class JsonProperties {

    private static Properties prop = null;
    private JsonProperties() {
        throw new IllegalStateException();
    }
    public static void cargarPropiedades() throws IOException {
        if (prop == null) {
            prop = new Properties();
            File objclasspathRoot = new File(System.getProperty("user.dir"));
            String strFilePath = objclasspathRoot.getAbsolutePath();
            prop.load(new FileReader(strFilePath + "/json.properties"));
        }
    }
    public static String getJsonResponseDefaulthPaht() throws IOException {
        cargarPropiedades();
        return prop.getProperty("JsonResponseDefaultPath");
    }
}
