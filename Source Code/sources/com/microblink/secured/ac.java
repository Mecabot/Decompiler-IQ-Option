package com.microblink.secured;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.microblink.recognizers.a;
import java.util.Set;

/* compiled from: line */
public final class ac implements a {
    private boolean dVt = false;
    private boolean dVu = true;
    private Bundle dXX;

    public ac(Parcel parcel) {
        this.dXX = parcel.readBundle(getClass().getClassLoader());
        this.dXX.setClassLoader(getClass().getClassLoader());
        boolean[] zArr = new boolean[2];
        parcel.readBooleanArray(zArr);
        this.dVt = zArr[0];
        this.dVu = zArr[1];
    }

    public final Set<String> keySet() {
        return this.dXX.keySet();
    }

    public final void ai(Parcel parcel) {
        parcel.writeBundle(this.dXX);
        parcel.writeBooleanArray(new boolean[]{this.dVt, this.dVu});
    }

    public final Parcelable getParcelable(String str) {
        return this.dXX.getParcelable(str);
    }

    public final String getString(String str) {
        return this.dXX.getString(str);
    }

    public final Object getObject(String str) {
        return this.dXX.get(str);
    }

    public final boolean isValid() {
        return this.dVt;
    }

    public final boolean isEmpty() {
        return this.dVu;
    }
}
