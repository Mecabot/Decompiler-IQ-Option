package com.iqoption.portfolio;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: PortfolioState */
public final class m implements Parcelable {
    public static final Creator<m> CREATOR = new Creator<m>() {
        /* renamed from: W */
        public m createFromParcel(Parcel parcel) {
            return new m(parcel);
        }

        /* renamed from: fK */
        public m[] newArray(int i) {
            return new m[i];
        }
    };
    private final Bundle cYL;
    private final Bundle cYM;
    private final Bundle cYN;
    private final Long cYO;
    private final Long cYP;

    /* compiled from: PortfolioState */
    public static final class a {
        private Bundle cYL;
        private Bundle cYM;
        private Bundle cYN;
        private Long cYO;
        private Long cYP;

        public a ag(Bundle bundle) {
            this.cYL = bundle;
            return this;
        }

        public a ah(Bundle bundle) {
            this.cYM = bundle;
            return this;
        }

        public a ai(Bundle bundle) {
            this.cYN = bundle;
            return this;
        }

        public a b(Long l, Long l2) {
            this.cYO = l;
            this.cYP = l2;
            return this;
        }

        public m awA() {
            return new m(this, null);
        }
    }

    public int describeContents() {
        return 0;
    }

    /* synthetic */ m(a aVar, AnonymousClass1 anonymousClass1) {
        this(aVar);
    }

    private m(a aVar) {
        this.cYL = aVar.cYL;
        this.cYM = aVar.cYM;
        this.cYN = aVar.cYN;
        this.cYO = aVar.cYO;
        this.cYP = aVar.cYP;
    }

    public Bundle awv() {
        return this.cYL;
    }

    public Bundle aww() {
        return this.cYM;
    }

    public Bundle awx() {
        return this.cYN;
    }

    public Long awy() {
        return this.cYO;
    }

    public Long awz() {
        return this.cYP;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.cYL);
        parcel.writeBundle(this.cYM);
        parcel.writeBundle(this.cYN);
        parcel.writeValue(this.cYO);
        parcel.writeValue(this.cYP);
    }

    protected m(Parcel parcel) {
        this.cYL = parcel.readBundle(getClass().getClassLoader());
        this.cYM = parcel.readBundle(getClass().getClassLoader());
        this.cYN = parcel.readBundle(getClass().getClassLoader());
        this.cYO = (Long) parcel.readValue(Long.class.getClassLoader());
        this.cYP = (Long) parcel.readValue(Long.class.getClassLoader());
    }
}
