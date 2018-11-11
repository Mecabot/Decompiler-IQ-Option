package com.facebook.share.internal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.util.Pair;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.HttpMethod;
import com.facebook.i.b;
import com.facebook.i.f;
import com.facebook.internal.a;
import com.facebook.internal.r;
import com.facebook.internal.s;
import com.facebook.internal.w;
import com.facebook.share.a.g;
import com.facebook.share.a.j;
import com.facebook.share.widget.LikeView.ObjectType;
import com.google.android.gms.plus.PlusShare;
import java.io.File;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ShareInternalUtility */
public final class i {
    public static boolean a(int i, int i2, Intent intent, h hVar) {
        a c = c(i, i2, intent);
        if (c == null) {
            return false;
        }
        r.b(c.lv());
        if (hVar == null) {
            return true;
        }
        FacebookException i3 = s.i(s.j(intent));
        if (i3 == null) {
            hVar.a(c, s.h(intent));
        } else if (i3 instanceof FacebookOperationCanceledException) {
            hVar.b(c);
        } else {
            hVar.a(c, i3);
        }
        return true;
    }

    private static a c(int i, int i2, Intent intent) {
        UUID e = s.e(intent);
        if (e == null) {
            return null;
        }
        return a.a(e, i);
    }

    public static JSONObject a(g gVar) {
        return g.a(gVar.os(), new g.a() {
            public JSONObject a(j jVar) {
                Uri ot = jVar.ot();
                if (w.c(ot)) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(PlusShare.KEY_CALL_TO_ACTION_URL, ot.toString());
                        return jSONObject;
                    } catch (Throwable e) {
                        throw new FacebookException("Unable to attach images", e);
                    }
                }
                throw new FacebookException("Only web images may be used in OG objects shared via the web dialog");
            }
        });
    }

    public static JSONArray a(JSONArray jSONArray, boolean z) {
        JSONArray jSONArray2 = new JSONArray();
        for (int i = 0; i < jSONArray.length(); i++) {
            Object obj = jSONArray.get(i);
            if (obj instanceof JSONArray) {
                obj = a((JSONArray) obj, z);
            } else if (obj instanceof JSONObject) {
                obj = a((JSONObject) obj, z);
            }
            jSONArray2.put(obj);
        }
        return jSONArray2;
    }

    public static JSONObject a(JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return null;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            JSONArray names = jSONObject.names();
            for (int i = 0; i < names.length(); i++) {
                String string = names.getString(i);
                Object obj = jSONObject.get(string);
                if (obj instanceof JSONObject) {
                    obj = a((JSONObject) obj, true);
                } else if (obj instanceof JSONArray) {
                    obj = a((JSONArray) obj, true);
                }
                Pair cl = cl(string);
                String str = (String) cl.first;
                String str2 = (String) cl.second;
                if (z) {
                    if (str != null && str.equals("fbsdk")) {
                        jSONObject2.put(string, obj);
                    } else if (str == null || str.equals("og")) {
                        jSONObject2.put(str2, obj);
                    } else {
                        jSONObject3.put(str2, obj);
                    }
                } else if (str == null || !str.equals("fb")) {
                    jSONObject2.put(str2, obj);
                } else {
                    jSONObject2.put(string, obj);
                }
            }
            if (jSONObject3.length() > 0) {
                jSONObject2.put("data", jSONObject3);
            }
            return jSONObject2;
        } catch (JSONException unused) {
            throw new FacebookException("Failed to create json object from share content");
        }
    }

    public static Pair<String, String> cl(String str) {
        Object substring;
        Object str2;
        int indexOf = str2.indexOf(58);
        if (indexOf != -1) {
            int i = indexOf + 1;
            if (str2.length() > i) {
                substring = str2.substring(0, indexOf);
                str2 = str2.substring(i);
                return new Pair(substring, str2);
            }
        }
        substring = null;
        return new Pair(substring, str2);
    }

    public static com.facebook.i a(com.facebook.a aVar, File file, b bVar) {
        Parcelable fVar = new f(ParcelFileDescriptor.open(file, 268435456), "image/png");
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("file", fVar);
        return new com.facebook.i(aVar, "me/staging_resources", bundle, HttpMethod.POST, bVar);
    }

    public static com.facebook.i a(com.facebook.a aVar, Uri uri, b bVar) {
        if (w.e(uri)) {
            return a(aVar, new File(uri.getPath()), bVar);
        }
        if (w.d(uri)) {
            Parcelable fVar = new f((Parcelable) uri, "image/png");
            Bundle bundle = new Bundle(1);
            bundle.putParcelable("file", fVar);
            return new com.facebook.i(aVar, "me/staging_resources", bundle, HttpMethod.POST, bVar);
        }
        throw new FacebookException("The image Uri must be either a file:// or content:// Uri");
    }

    @Nullable
    public static ObjectType a(ObjectType objectType, ObjectType objectType2) {
        if (objectType == objectType2) {
            return objectType;
        }
        if (objectType == ObjectType.UNKNOWN) {
            return objectType2;
        }
        return objectType2 == ObjectType.UNKNOWN ? objectType : null;
    }
}
