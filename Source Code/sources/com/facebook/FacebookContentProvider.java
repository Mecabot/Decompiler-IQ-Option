package com.facebook;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.util.Pair;
import com.facebook.internal.r;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.UUID;

public class FacebookContentProvider extends ContentProvider {
    private static final String TAG = "com.facebook.FacebookContentProvider";

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public ParcelFileDescriptor openFile(Uri uri, String str) {
        Pair b = b(uri);
        if (b == null) {
            throw new FileNotFoundException();
        }
        try {
            File a = r.a((UUID) b.first, (String) b.second);
            if (a != null) {
                return ParcelFileDescriptor.open(a, 268435456);
            }
            throw new FileNotFoundException();
        } catch (FileNotFoundException e) {
            str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Got unexpected exception:");
            stringBuilder.append(e);
            Log.e(str, stringBuilder.toString());
            throw e;
        }
    }

    Pair<UUID, String> b(Uri uri) {
        try {
            String[] split = uri.getPath().substring(1).split("/");
            Object obj = split[0];
            CharSequence charSequence = split[1];
            if (!"..".contentEquals(obj) && !"..".contentEquals(charSequence)) {
                return new Pair(UUID.fromString(obj), charSequence);
            }
            throw new Exception();
        } catch (Exception unused) {
            return null;
        }
    }
}
