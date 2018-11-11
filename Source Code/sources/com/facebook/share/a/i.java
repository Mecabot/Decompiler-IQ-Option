package com.facebook.share.a;

import android.os.Bundle;
import android.os.Parcel;
import android.support.annotation.Nullable;
import java.util.Set;

/* compiled from: ShareOpenGraphValueContainer */
public abstract class i<P extends i, E extends a> implements e {
    private final Bundle Jl;

    /* compiled from: ShareOpenGraphValueContainer */
    public static abstract class a<P extends i, E extends a> {
        private Bundle Jl = new Bundle();

        public E N(String str, @Nullable String str2) {
            this.Jl.putString(str, str2);
            return this;
        }

        public E a(P p) {
            if (p != null) {
                this.Jl.putAll(p.getBundle());
            }
            return this;
        }
    }

    public int describeContents() {
        return 0;
    }

    protected i(a<P, E> aVar) {
        this.Jl = (Bundle) aVar.Jl.clone();
    }

    i(Parcel parcel) {
        this.Jl = parcel.readBundle(a.class.getClassLoader());
    }

    @Nullable
    public Object get(String str) {
        return this.Jl.get(str);
    }

    @Nullable
    public String getString(String str) {
        return this.Jl.getString(str);
    }

    public Bundle getBundle() {
        return (Bundle) this.Jl.clone();
    }

    public Set<String> keySet() {
        return this.Jl.keySet();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.Jl);
    }
}
