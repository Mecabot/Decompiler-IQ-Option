package io.fabric.sdk.android.services.c;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import io.fabric.sdk.android.h;

/* compiled from: PreferenceStoreImpl */
public class d implements c {
    private final Context context;
    private final String eoN;
    private final SharedPreferences wv;

    public d(Context context, String str) {
        if (context == null) {
            throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
        }
        this.context = context;
        this.eoN = str;
        this.wv = this.context.getSharedPreferences(this.eoN, 0);
    }

    @Deprecated
    public d(h hVar) {
        this(hVar.getContext(), hVar.getClass().getName());
    }

    public SharedPreferences aVG() {
        return this.wv;
    }

    public Editor edit() {
        return this.wv.edit();
    }

    @TargetApi(9)
    public boolean a(Editor editor) {
        if (VERSION.SDK_INT < 9) {
            return editor.commit();
        }
        editor.apply();
        return true;
    }
}
