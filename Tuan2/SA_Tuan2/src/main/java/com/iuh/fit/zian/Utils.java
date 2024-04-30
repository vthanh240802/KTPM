package com.iuh.fit.zian;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static List<String> splipByUpperCase(String input){
        List<String> result = new ArrayList<String>();
        int currentUppercase = 0;
        String currentWord;
        for (int i = 1; i < input.length(); i++) {
            if (Character.isUpperCase(input.charAt(i))) {
                currentWord = input.substring(currentUppercase, i);
                result.add(currentWord);
                currentUppercase = i;
            }
        }
        currentWord = input.substring(currentUppercase);
        result.add(currentWord);
        return result;
    }


    public static boolean isClassCamelCase(String className){
        return className.matches("^([A-Z][a-z]{1,}){1,}$");
    }

    public static boolean isCamelCase(String className){
        return className.matches("^[a-z]{1,}([A-Z][a-z]{1,}){0,}$");
    }

    public static boolean isAllUpperCase(String input){
        return input.matches("^[A-Z]{1,}");
    }


}
