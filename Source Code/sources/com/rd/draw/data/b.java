package com.rd.draw.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

/* compiled from: PositionSavedState */
public class b extends BaseSavedState {
    public static final Creator<b> CREATOR = new Creator<b>() {
        /* renamed from: aw */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel, null);
        }

        /* renamed from: iF */
        public b[] newArray(int i) {
            return new b[i];
        }
    };
    private int dMk;
    private int eiE;
    private int eiF;

    /* synthetic */ b(Parcel parcel, AnonymousClass1 anonymousClass1) {
        this(parcel);
    }

    public b(Parcelable parcelable) {
        super(parcelable);
    }

    private b(Parcel parcel) {
        super(parcel);
        this.eiE = parcel.readInt();
        this.eiF = parcel.readInt();
        this.dMk = parcel.readInt();
    }

    public int aTe() {
        return this.eiE;
    }

    public void cD(int i) {
        this.eiE = i;
    }

    public int aTf() {
        return this.eiF;
    }

    public void iC(int i) {
        this.eiF = i;
    }

    public int aTg() {
        return this.dMk;
    }

    public void iD(int i) {
        this.dMk = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.eiE);
        parcel.writeInt(this.eiF);
        parcel.writeInt(this.dMk);
    }
}
