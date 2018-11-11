package com.google.gson.internal.reflect;

import com.google.gson.util.VersionUtils;
import java.lang.reflect.AccessibleObject;

public abstract class ReflectionAccessor {
    private static final ReflectionAccessor instance = (VersionUtils.getMajorJavaVersion() < 9 ? new PreJava9ReflectionAccessor() : new UnsafeReflectionAccessor());

    public abstract void makeAccessible(AccessibleObject accessibleObject);

    public static ReflectionAccessor getInstance() {
        return instance;
    }
}
