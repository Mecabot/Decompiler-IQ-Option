package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.HitBuilders.ExceptionBuilder;
import com.google.android.gms.internal.zzatc;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;

public class ExceptionReporter implements UncaughtExceptionHandler {
    private final Context mContext;
    private final UncaughtExceptionHandler zzduf;
    private final Tracker zzdug;
    private ExceptionParser zzduh;
    private GoogleAnalytics zzdui;

    public ExceptionReporter(Tracker tracker, UncaughtExceptionHandler uncaughtExceptionHandler, Context context) {
        if (tracker == null) {
            throw new NullPointerException("tracker cannot be null");
        } else if (context == null) {
            throw new NullPointerException("context cannot be null");
        } else {
            this.zzduf = uncaughtExceptionHandler;
            this.zzdug = tracker;
            this.zzduh = new StandardExceptionParser(context, new ArrayList());
            this.mContext = context.getApplicationContext();
            String str = "ExceptionReporter created, original handler is ";
            String valueOf = String.valueOf(uncaughtExceptionHandler == null ? "null" : uncaughtExceptionHandler.getClass().getName());
            zzatc.v(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
    }

    public ExceptionParser getExceptionParser() {
        return this.zzduh;
    }

    public void setExceptionParser(ExceptionParser exceptionParser) {
        this.zzduh = exceptionParser;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        String str = "UncaughtException";
        if (this.zzduh != null) {
            str = this.zzduh.getDescription(thread != null ? thread.getName() : null, th);
        }
        String str2 = "Reporting uncaught exception: ";
        String valueOf = String.valueOf(str);
        zzatc.v(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        this.zzdug.send(new ExceptionBuilder().setDescription(str).setFatal(true).build());
        if (this.zzdui == null) {
            this.zzdui = GoogleAnalytics.getInstance(this.mContext);
        }
        zza zza = this.zzdui;
        zza.dispatchLocalHits();
        zza.zzvr().zzyc().zzxt();
        if (this.zzduf != null) {
            zzatc.v("Passing exception to the original handler");
            this.zzduf.uncaughtException(thread, th);
        }
    }

    final UncaughtExceptionHandler zzvv() {
        return this.zzduf;
    }
}
