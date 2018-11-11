package com.iqoption.util;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.annotation.RawRes;
import com.iqoption.core.i;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

/* compiled from: FileUtils */
public class ab {
    public static String F(Context context, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open(str, 0)));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    stringBuilder.append(readLine);
                }
            }
        } catch (IOException unused) {
            return stringBuilder.toString();
        }
    }

    @Nullable
    public static <T> T a(Context context, @RawRes int i, Type type) {
        try {
            return ah.aGg().fromJson(new InputStreamReader(context.getResources().openRawResource(i)), type);
        } catch (Throwable e) {
            i.w("FileUtils", e.getMessage(), e);
            return null;
        }
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }
}
