package com.crashlytics.android;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import io.fabric.sdk.android.c;
import io.fabric.sdk.android.services.common.m;

public class CrashlyticsInitProvider extends ContentProvider {

    interface a {
        boolean J(Context context);
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public boolean onCreate() {
        Context context = getContext();
        if (a(context, new m(), new b())) {
            try {
                c.a(context, new a());
                c.aUg().i("CrashlyticsInitProvider", "CrashlyticsInitProvider initialization successful");
            } catch (IllegalStateException unused) {
                c.aUg().i("CrashlyticsInitProvider", "CrashlyticsInitProvider initialization unsuccessful");
                return false;
            }
        }
        return true;
    }

    boolean a(Context context, m mVar, a aVar) {
        return mVar.cS(context) && aVar.J(context);
    }
}
