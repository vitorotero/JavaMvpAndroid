package com.example.vitormachado.mvparchitecture.util;

/**
 * @author vitor.machado on 12/06/18.
 */
public class StringUtil {

    public static final String EMPTY_STRING = "";

    public StringUtil() {
    }

    public static boolean isEmpty(String text) {
        if (text == null) {
            return true;
        }

        if (text.trim().length() == 0 || EMPTY_STRING.equals(text)) {
            return true;
        }

        return false;
    }

    public static boolean isNotEmpty(String text) {
        return !isEmpty(text);
    }

    public static boolean isMailNotValid(String mail) {
        return false;
    }
}
