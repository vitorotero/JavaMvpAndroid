package br.com.tecapp.mvparchitecture.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        if ((mail == null) || (mail.trim().length() == 0)) {
            return true;
        }

        String mailPattern = "\\b(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b";
        Pattern pattern = Pattern.compile(mailPattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(mail);

        return !matcher.matches();
    }
}
