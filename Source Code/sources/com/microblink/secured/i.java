package com.microblink.secured;

import com.microblink.util.Log;

/* compiled from: line */
public class i {
    private static boolean dWd = false;
    private static Error dWe;

    public static boolean aPu() {
        if (!dWd) {
            try {
                if (aa.aPN()) {
                    for (String str : af.dYn) {
                        Log.a(i.class, "Loading lib{}.so", str);
                        System.loadLibrary(str);
                    }
                    dWd = true;
                } else {
                    throw new UnsatisfiedLinkError("Incompatible CPU!");
                }
            } catch (Throwable e) {
                dWd = false;
                Log.a(i.class, e, "error loading native library", new Object[0]);
                dWe = e;
            }
        }
        return dWd;
    }

    public static boolean aPv() {
        return dWd;
    }

    public static Error aPw() {
        return dWe;
    }

    public static void aPx() {
        if (!aPu()) {
            Error error = dWe;
            if (error != null) {
                throw error;
            }
            throw new RuntimeException("Native library is not loaded");
        }
    }
}
