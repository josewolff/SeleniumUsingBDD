package utils;

import java.util.UUID;

public class Utils {

    public static String generateGUID(){
        UUID uuid = UUID.randomUUID();
        String guid = uuid.toString();
        return guid;
    }
}
