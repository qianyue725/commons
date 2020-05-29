package com.qianyue.commons.serialize.util;

public class ReflectionUtils {

    @SuppressWarnings("unchecked")
    public static boolean checkZeroArgConstructor(Class clazz) {
        try {
            clazz.getDeclaredConstructor();
            return true;
        } catch (NoSuchMethodException e) {
            return false;
        }
    }
}