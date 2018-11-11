package com.microblink.recognizers;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.microblink.util.Log;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* compiled from: line */
class NativeResultHolder implements a {
    private long IlIllIlIIl = 0;
    private boolean dVt = false;
    private boolean dVu = true;
    private HashMap<String, Object> dVv = new HashMap();
    private HashSet<String> dVw = null;

    private static native void nativeDestruct(long j);

    private static native String[] nativeGetAllKeys(long j);

    private static native boolean nativeGetBool(long j, String str, boolean z);

    private static native int nativeGetInt(long j, String str, int i);

    private static native Object nativeGetObject(long j, String str);

    private static native String nativeGetString(long j, String str);

    NativeResultHolder(long j, boolean z, boolean z2) {
        this.IlIllIlIIl = j;
        this.dVu = z;
        this.dVt = z2;
    }

    protected void finalize() {
        super.finalize();
        if (this.IlIllIlIIl != 0) {
            nativeDestruct(this.IlIllIlIIl);
        }
    }

    public Set<String> keySet() {
        if (this.dVw == null) {
            this.dVw = new HashSet();
            Collections.addAll(this.dVw, nativeGetAllKeys(this.IlIllIlIIl));
        }
        return this.dVw;
    }

    public String getString(String str) {
        String str2 = (String) this.dVv.get(str);
        if (str2 != null) {
            return str2;
        }
        str2 = nativeGetString(this.IlIllIlIIl, str);
        this.dVv.put(str, str2);
        return str2;
    }

    @Nullable
    public Object getObject(String str) {
        Object obj = this.dVv.get(str);
        if (obj != null) {
            return obj;
        }
        obj = nativeGetObject(this.IlIllIlIIl, str);
        this.dVv.put(str, obj);
        return obj;
    }

    public Parcelable getParcelable(String str) {
        Object object = getObject(str);
        return (object == null || !(object instanceof Parcelable)) ? null : (Parcelable) object;
    }

    public boolean isValid() {
        return this.dVt;
    }

    public boolean isEmpty() {
        return this.dVu;
    }

    public void ai(Parcel parcel) {
        Set<String> keySet = keySet();
        Bundle bundle = new Bundle();
        for (String str : keySet) {
            Object object = getObject(str);
            if (object == null) {
                Log.f(this, "Object for key {} is null. Skipping!", str);
            } else if (object instanceof String) {
                bundle.putString(str, (String) object);
            } else if (object instanceof Parcelable) {
                bundle.putParcelable(str, (Parcelable) object);
            } else if (object instanceof Integer) {
                bundle.putInt(str, ((Integer) object).intValue());
            } else if (object instanceof Boolean) {
                bundle.putBoolean(str, ((Boolean) object).booleanValue());
            } else if (object instanceof byte[]) {
                bundle.putByteArray(str, (byte[]) object);
            } else {
                StringBuilder stringBuilder = new StringBuilder("Cannot write to parcel object of type ");
                stringBuilder.append(object.getClass().getName());
                throw new UnsupportedOperationException(stringBuilder.toString());
            }
        }
        parcel.writeBundle(bundle);
        parcel.writeBooleanArray(new boolean[]{this.dVt, this.dVu});
    }
}
