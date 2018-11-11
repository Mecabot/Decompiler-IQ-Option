package com.facebook.marketing.internal;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.facebook.h;
import com.facebook.h.a;

public final class MarketingInitProvider extends ContentProvider {
    private static final String TAG = "MarketingInitProvider";

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
        try {
            if (h.isInitialized()) {
                nL();
            } else {
                h.a(getContext(), new a() {
                    public void ji() {
                        MarketingInitProvider.this.nL();
                    }
                });
            }
        } catch (Throwable e) {
            Log.i(TAG, "Failed to auto initialize the Marketing SDK", e);
        }
        return false;
    }

    private void nL() {
        com.facebook.marketing.a.c((Application) h.getApplicationContext());
        f.nO();
        new d((Application) h.getApplicationContext(), h.it()).nM();
    }
}
