package com.firebase.jobdispatcher;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.google.firebase.analytics.FirebaseAnalytics.b;

/* compiled from: GooglePlayDriver */
public final class g implements c {
    private final v JS;
    private final PendingIntent JT;
    private final i JU;
    private final boolean JV = true;
    private final Context context;

    public boolean isAvailable() {
        return true;
    }

    public g(Context context) {
        this.context = context;
        this.JT = PendingIntent.getBroadcast(context, 0, new Intent(), 0);
        this.JU = new i();
        this.JS = new b(context);
    }

    public int a(@NonNull n nVar) {
        GooglePlayReceiver.b(nVar);
        this.context.sendBroadcast(e(nVar));
        return 0;
    }

    public int cr(@NonNull String str) {
        this.context.sendBroadcast(cs(str));
        return 0;
    }

    @NonNull
    protected Intent cs(@NonNull String str) {
        Intent ct = ct("CANCEL_TASK");
        ct.putExtra("tag", str);
        ct.putExtra("component", new ComponentName(this.context, oC()));
        return ct;
    }

    @NonNull
    protected Class<GooglePlayReceiver> oC() {
        return GooglePlayReceiver.class;
    }

    @NonNull
    public v oz() {
        return this.JS;
    }

    @NonNull
    private Intent e(r rVar) {
        Intent ct = ct("SCHEDULE_TASK");
        ct.putExtras(this.JU.a(rVar, ct.getExtras()));
        return ct;
    }

    @NonNull
    private Intent ct(String str) {
        Intent intent = new Intent("com.google.android.gms.gcm.ACTION_SCHEDULE");
        intent.setPackage("com.google.android.gms");
        intent.putExtra("scheduler_action", str);
        intent.putExtra("app", this.JT);
        intent.putExtra(b.SOURCE, 8);
        intent.putExtra("source_version", 1);
        return intent;
    }
}
