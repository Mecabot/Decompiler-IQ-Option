package com.airbnb.lottie;

import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.os.TraceCompat;
import android.util.Log;

@RestrictTo({Scope.LIBRARY})
/* compiled from: L */
public class d {
    private static boolean iH = false;
    private static String[] iI;
    private static long[] iJ;
    private static int iK;
    private static int iL;

    public static void warn(String str) {
        Log.w("LOTTIE", str);
    }

    public static void beginSection(String str) {
        if (!iH) {
            return;
        }
        if (iK == 20) {
            iL++;
            return;
        }
        iI[iK] = str;
        iJ[iK] = System.nanoTime();
        TraceCompat.beginSection(str);
        iK++;
    }

    public static float X(String str) {
        if (iL > 0) {
            iL--;
            return 0.0f;
        } else if (!iH) {
            return 0.0f;
        } else {
            iK--;
            if (iK == -1) {
                throw new IllegalStateException("Can't end trace section. There are none.");
            } else if (str.equals(iI[iK])) {
                TraceCompat.endSection();
                return ((float) (System.nanoTime() - iJ[iK])) / 1000000.0f;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unbalanced trace call ");
                stringBuilder.append(str);
                stringBuilder.append(". Expected ");
                stringBuilder.append(iI[iK]);
                stringBuilder.append(".");
                throw new IllegalStateException(stringBuilder.toString());
            }
        }
    }
}
