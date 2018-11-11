package com.facebook.share.a;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;

/* compiled from: ShareOpenGraphAction */
public final class f extends i<f, a> {
    public static final Creator<f> CREATOR = new Creator<f>() {
        /* renamed from: x */
        public f createFromParcel(Parcel parcel) {
            return new f(parcel);
        }

        /* renamed from: ai */
        public f[] newArray(int i) {
            return new f[i];
        }
    };

    /* compiled from: ShareOpenGraphAction */
    public static final class a extends com.facebook.share.a.i.a<f, a> {
        public a cn(String str) {
            N("og:type", str);
            return this;
        }

        public f or() {
            return new f(this, null);
        }

        public a a(f fVar) {
            if (fVar == null) {
                return this;
            }
            return ((a) super.a((i) fVar)).cn(fVar.oq());
        }

        a y(Parcel parcel) {
            return a((f) parcel.readParcelable(f.class.getClassLoader()));
        }
    }

    /* synthetic */ f(a aVar, AnonymousClass1 anonymousClass1) {
        this(aVar);
    }

    private f(a aVar) {
        super((com.facebook.share.a.i.a) aVar);
    }

    f(Parcel parcel) {
        super(parcel);
    }

    @Nullable
    public String oq() {
        return getString("og:type");
    }
}
