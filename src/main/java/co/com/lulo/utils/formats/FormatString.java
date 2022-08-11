package co.com.lulo.utils.formats;

import java.text.Normalizer;

public class FormatString {

    public static String removeAccents(String cadena){
        String formatoCadena = Normalizer.normalize(cadena,Normalizer.Form.NFD);
        formatoCadena = formatoCadena.replaceAll("[^\\p{ASCII}(N\u0303)(n\u0303)(\u00A1)(\u00BF)(\u00B0)(U\u0308)(u\u0308)]", "");
        return formatoCadena;
    }
}
