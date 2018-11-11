package com.iqoption.util;

import android.os.Bundle;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: Bundler */
public final class g {
    private final Bundle Jl = new Bundle();

    public Bundle toBundle() {
        return this.Jl;
    }

    public g aA(String str, String str2) {
        this.Jl.putString(str, str2);
        return this;
    }

    public g O(String str, int i) {
        this.Jl.putInt(str, i);
        return this;
    }

    public g e(String str, double d) {
        this.Jl.putDouble(str, d);
        return this;
    }

    public g j(String str, long j) {
        this.Jl.putLong(str, j);
        return this;
    }

    public g a(String str, Parcelable parcelable) {
        this.Jl.putParcelable(str, parcelable);
        return this;
    }

    public g a(String str, ArrayList<? extends Parcelable> arrayList) {
        this.Jl.putParcelableArrayList(str, arrayList);
        return this;
    }

    public g a(String str, Serializable serializable) {
        this.Jl.putSerializable(str, serializable);
        return this;
    }

    public g a(String str, long[] jArr) {
        this.Jl.putLongArray(str, jArr);
        return this;
    }

    public g v(String str, boolean z) {
        this.Jl.putBoolean(str, z);
        return this;
    }

    public g b(String str, String[] strArr) {
        this.Jl.putStringArray(str, strArr);
        return this;
    }

    public g a(String str, int[] iArr) {
        this.Jl.putIntArray(str, iArr);
        return this;
    }

    public g a(String str, float[] fArr) {
        this.Jl.putFloatArray(str, fArr);
        return this;
    }

    public g b(String str, Parcelable parcelable) {
        this.Jl.putParcelable(str, parcelable);
        return this;
    }
}
