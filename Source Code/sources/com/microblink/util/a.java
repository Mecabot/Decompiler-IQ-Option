package com.microblink.util;

import android.content.Context;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.util.Log;
import com.microblink.util.Log.LogLevel;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;

/* compiled from: line */
public class a implements com.microblink.util.Log.a {
    private static String dYR;
    private PrintWriter dYQ;

    public static synchronized String ck(@Nullable Context context) {
        String str;
        synchronized (a.class) {
            if (dYR == null) {
                StringBuilder stringBuilder;
                StringBuilder stringBuilder2;
                if (Environment.getExternalStorageState().equals("mounted")) {
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(Environment.getExternalStorageDirectory());
                    stringBuilder2.append("/microblink");
                    dYR = stringBuilder2.toString();
                } else if (context != null) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(context.getCacheDir().getAbsolutePath());
                    stringBuilder.append("/microblink");
                    dYR = stringBuilder.toString();
                } else {
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(Environment.getDataDirectory().getAbsolutePath());
                    stringBuilder2.append("/microblink");
                    dYR = stringBuilder2.toString();
                }
                if (Log.aQb().ordinal() >= LogLevel.LOG_INFORMATION.ordinal()) {
                    stringBuilder = new StringBuilder("Log folder will be ");
                    stringBuilder.append(dYR);
                    Log.i("LOG", stringBuilder.toString());
                }
            }
            str = dYR;
        }
        return str;
    }

    public void a(String str, String str2, String str3, Throwable th) {
        synchronized (this) {
            if (this.dYQ != null) {
                this.dYQ.write(str);
                Timestamp timestamp = new Timestamp(new Date().getTime());
                this.dYQ.write(" (");
                this.dYQ.write(timestamp.toString());
                this.dYQ.write(") [");
                this.dYQ.write(str2);
                this.dYQ.write("] ");
                this.dYQ.write(str3);
                this.dYQ.write("\n");
                if (th != null) {
                    th.printStackTrace(this.dYQ);
                }
                this.dYQ.flush();
            }
        }
    }
}
