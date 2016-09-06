package net.beifeng.mobile_scm.utils;

import java.util.UUID;

public class StringUtils {

    public static String uniqueKey() {
        String key = UUID.randomUUID().toString();
        key = key.replace("-", "");
        return key.toUpperCase();
    }

    public static boolean isEmpty(String str) {
        if (str == null) {
            return true;
        } else {
            return str.trim().length() == 0;
        }
    }
}
