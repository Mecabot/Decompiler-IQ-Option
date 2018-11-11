package com.noveogroup.android.log;

import android.util.Log;
import com.noveogroup.android.log.Logger.Level;

/* compiled from: PatternHandler */
public class e implements b {
    private final Level eca;
    private final String ecb;
    private final String ecc;
    private final d ecd;
    private final d ece;

    public e(Level level, String str, String str2) {
        this.eca = level;
        this.ecb = str;
        this.ecd = d.lc(str);
        this.ecc = str2;
        this.ece = d.lc(str2);
    }

    public boolean a(Level level) {
        return (this.eca == null || level == null || !this.eca.includes(level)) ? false : true;
    }

    public void a(String str, Level level, Throwable th, String str2) {
        if (a(level)) {
            StringBuilder stringBuilder;
            if (str2 == null) {
                if (th == null) {
                    str2 = "";
                } else {
                    str2 = Log.getStackTraceString(th);
                }
            } else if (th != null) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(str2);
                stringBuilder2.append(10);
                stringBuilder2.append(Log.getStackTraceString(th));
                str2 = stringBuilder2.toString();
            }
            StackTraceElement stackTraceElement = null;
            if ((this.ecd != null && this.ecd.isCallerNeeded()) || (this.ece != null && this.ece.isCallerNeeded())) {
                stackTraceElement = g.aRH();
            }
            String a = this.ecd == null ? "" : this.ecd.a(stackTraceElement, str, level);
            str = this.ece == null ? "" : this.ece.a(stackTraceElement, str, level);
            if (str.length() > 0 && !Character.isWhitespace(str.charAt(0))) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(" ");
                str = stringBuilder.toString();
            }
            int intValue = level.intValue();
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(str2);
            Log.println(intValue, a, stringBuilder.toString());
        }
    }

    public void a(String str, Level level, Throwable th, String str2, Object... objArr) {
        if (!a(level)) {
            return;
        }
        if (str2 != null || objArr == null || objArr.length <= 0) {
            if (str2 == null) {
                str2 = null;
            } else {
                str2 = String.format(str2, objArr);
            }
            a(str, level, th, str2);
            return;
        }
        throw new IllegalArgumentException("message format is not set but arguments are presented");
    }
}
