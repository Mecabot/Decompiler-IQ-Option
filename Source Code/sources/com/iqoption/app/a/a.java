package com.iqoption.app.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.iqoption.app.IQApp;
import com.iqoption.app.ae;
import com.iqoption.app.af;
import com.iqoption.app.b.b.j;
import com.iqoption.core.g;
import com.iqoption.core.i;
import java.util.Locale;

/* compiled from: IQBaseAccount */
public abstract class a extends ae implements g {
    private static final String TAG = "com.iqoption.app.a.a";
    private boolean alt = false;
    private String uQ = "";
    private long userId;

    public a(Context context) {
        init(context);
    }

    protected void clear() {
        this.uQ = "";
        this.userId = -1;
        bt(false);
    }

    protected String FC() {
        return this.uQ;
    }

    protected void aS(Context context) {
        this.uQ = "";
        af.aR(context).DY().edit().putString("session_id", this.uQ).apply();
    }

    public long getUserId() {
        return this.userId;
    }

    public void h(Long l) {
        if (l != null) {
            this.userId = l.longValue();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("time_first_login");
            stringBuilder.append(l);
            if (af.getLong(stringBuilder.toString()) == 0) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("time_first_login");
                stringBuilder.append(l);
                af.setLong(stringBuilder.toString(), System.currentTimeMillis());
            }
            com.crashlytics.android.a.aI(l.toString());
            return;
        }
        this.userId = -1;
        com.crashlytics.android.a.aI("-1");
    }

    public void FD() {
        i.d(TAG, "anonymousUser = true");
        bt(true);
    }

    public void FE() {
        i.d(TAG, "anonymousUser = false");
        bt(false);
    }

    public void aN(Context context) {
        Editor edit = af.aR(context).DY().edit();
        edit.putBoolean("anonym_register_successful", this.alt);
        edit.putString("session_id", this.uQ);
        edit.putLong("user_id", this.userId);
        edit.apply();
    }

    private void init(Context context) {
        String str;
        SharedPreferences DY = af.aR(context).DY();
        this.alt = DY.getBoolean("anonym_register_successful", false);
        this.uQ = DY.getString("session_id", "");
        this.userId = DY.getLong("user_id", -1);
        if (this.userId == -1) {
            str = "unregistered";
        } else {
            str = String.format(Locale.US, "%04d", new Object[]{Long.valueOf(this.userId)});
        }
        com.crashlytics.android.a.aI(str);
    }

    private void bt(boolean z) {
        if (this.alt != z) {
            this.alt = z;
            IQApp.Dn().aE(new j().setValue(Boolean.valueOf(z)));
        }
    }
}
