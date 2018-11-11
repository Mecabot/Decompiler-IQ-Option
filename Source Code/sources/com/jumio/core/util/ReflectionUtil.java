package com.jumio.core.util;

import android.support.annotation.Nullable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionUtil {
    public static <T> T invokeVoidMethod(Class<?> cls, String str, Object obj, Object... objArr) {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, new Class[0]);
            if (!declaredMethod.isAccessible()) {
                declaredMethod.setAccessible(true);
            }
            return declaredMethod.invoke(obj, objArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static <T> T invokeMethodWithArgs(Class<?> cls, String str, Class<?>[] clsArr, Object obj, Object... objArr) {
        try {
            Method declaredMethod;
            if (clsArr.length == 1) {
                declaredMethod = cls.getDeclaredMethod(str, new Class[]{clsArr[0]});
            } else {
                declaredMethod = cls.getDeclaredMethod(str, clsArr);
            }
            if (!declaredMethod.isAccessible()) {
                declaredMethod.setAccessible(true);
            }
            return declaredMethod.invoke(obj, objArr);
        } catch (Exception unused) {
            return null;
        }
    }

    @Nullable
    public static Method getMethod(Object obj, String str, Class<?>... clsArr) {
        int i = 0;
        if (clsArr == null || clsArr.length == 0 || clsArr[0] == null) {
            Method[] declaredMethods = obj.getClass().getDeclaredMethods();
            int length = declaredMethods.length;
            while (i < length) {
                Method method = declaredMethods[i];
                if (method.getName().contains(str)) {
                    return method;
                }
                i++;
            }
            return null;
        }
        for (Method method2 : obj.getClass().getDeclaredMethods()) {
            if (method2.getName().equals(str)) {
                Class[] parameterTypes = method2.getParameterTypes();
                if (clsArr.length != parameterTypes.length) {
                    continue;
                } else {
                    Object obj2;
                    for (int i2 = 0; i2 < clsArr.length; i2++) {
                        if (!parameterTypes[i2].isAssignableFrom(clsArr[i2])) {
                            obj2 = null;
                            break;
                        }
                    }
                    obj2 = 1;
                    if (obj2 != null) {
                        return method2;
                    }
                }
            }
        }
        return obj.getClass().getDeclaredMethod(str, clsArr);
    }

    public static void setStaticMember(Class<?> cls, String str, boolean z, Object obj) {
        Field declaredField = cls.getDeclaredField(str);
        if (z) {
            declaredField.setAccessible(true);
        }
        declaredField.set(null, obj);
    }

    public static Object getStaticMember(Class<?> cls, String str, boolean z) {
        Field declaredField = cls.getDeclaredField(str);
        if (z) {
            declaredField.setAccessible(true);
        }
        return declaredField.get(null);
    }

    public static boolean hasClass(String str) {
        boolean z = false;
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    if (Class.forName(str) != null) {
                        z = true;
                    }
                    return z;
                }
            } catch (ClassNotFoundException unused) {
                return false;
            }
        }
        return false;
    }
}
