package com.jumio.core.environment;

public class CpuInfo {
    public static final native int getCpuCount();

    public static final native int getCpuFamily();

    public static final native int getCpuFeatures();
}
