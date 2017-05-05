package ec.org.isspol.common;

import java.util.UUID;

/**
 * Created by carlos.calo on 26/04/2017.
 */
public class Util {

    private static final String CLAVE = "511sSp01W36";

    public static String generarToken(String dato){
        return UUID.nameUUIDFromBytes(CLAVE.concat(dato).getBytes()).toString();
    }
}
