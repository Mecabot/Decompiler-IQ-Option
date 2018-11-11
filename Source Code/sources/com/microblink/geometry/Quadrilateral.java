package com.microblink.geometry;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Keep;
import android.support.annotation.Size;
import com.microblink.util.Log;

/* compiled from: line */
public class Quadrilateral implements Parcelable {
    public static final Creator<Quadrilateral> CREATOR = new Creator<Quadrilateral>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Quadrilateral[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new Quadrilateral(parcel);
        }
    };
    a dUs;
    a dUt;
    a dUu;
    a dUv;
    boolean dUw;
    int mColor;

    public int describeContents() {
        return 0;
    }

    public Quadrilateral() {
        this.mColor = -1;
        this.dUw = false;
        a(100, 100, 200, 200, 1);
    }

    public void a(int i, int i2, int i3, int i4, int i5) {
        Log.e(this, "Setting margins: top={}, bottom={}, left={}, right={}", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        float f;
        float f2;
        float f3;
        float f4;
        if (i5 == 1 || i5 == 9) {
            f = (float) i4;
            f2 = (float) i;
            this.dUs = new a(f, f2);
            f3 = (float) i3;
            this.dUt = new a(f3, f2);
            f4 = (float) i2;
            this.dUu = new a(f, f4);
            this.dUv = new a(f3, f4);
            return;
        }
        f3 = (float) i3;
        f2 = (float) i;
        this.dUs = new a(f3, f2);
        f4 = (float) i2;
        this.dUt = new a(f3, f4);
        f = (float) i4;
        this.dUu = new a(f, f2);
        this.dUv = new a(f, f4);
    }

    public Quadrilateral(a aVar, a aVar2, a aVar3, a aVar4) {
        this.mColor = -1;
        this.dUw = false;
        a(aVar, aVar2, aVar3, aVar4);
    }

    @Keep
    public Quadrilateral(@Size(8) float[] fArr) {
        this.mColor = -1;
        this.dUw = false;
        a(new a(fArr[0], fArr[1]), new a(fArr[2], fArr[3]), new a(fArr[6], fArr[7]), new a(fArr[4], fArr[5]));
    }

    public void a(a aVar, a aVar2, a aVar3, a aVar4) {
        this.dUs = aVar;
        this.dUt = aVar2;
        this.dUu = aVar3;
        this.dUv = aVar4;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Quadrilateral{mUpperLeft=");
        stringBuilder.append(this.dUs);
        stringBuilder.append(", mUpperRight=");
        stringBuilder.append(this.dUt);
        stringBuilder.append(", mLowerLeft=");
        stringBuilder.append(this.dUu);
        stringBuilder.append(", mLowerRight=");
        stringBuilder.append(this.dUv);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void setColor(int i) {
        this.mColor = i;
    }

    public void fJ(boolean z) {
        this.dUw = z;
    }

    /* renamed from: aOE */
    public Quadrilateral clone() {
        Quadrilateral quadrilateral = new Quadrilateral(this.dUs, this.dUt, this.dUu, this.dUv);
        quadrilateral.fJ(this.dUw);
        quadrilateral.setColor(this.mColor);
        return quadrilateral;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.dUs, 0);
        parcel.writeParcelable(this.dUt, 0);
        parcel.writeParcelable(this.dUu, 0);
        parcel.writeParcelable(this.dUv, 0);
        parcel.writeInt(this.mColor);
        parcel.writeByte(this.dUw);
    }

    protected Quadrilateral(Parcel parcel) {
        this.mColor = -1;
        boolean z = false;
        this.dUw = false;
        this.dUs = (a) parcel.readParcelable(a.class.getClassLoader());
        this.dUt = (a) parcel.readParcelable(a.class.getClassLoader());
        this.dUu = (a) parcel.readParcelable(a.class.getClassLoader());
        this.dUv = (a) parcel.readParcelable(a.class.getClassLoader());
        this.mColor = parcel.readInt();
        if (parcel.readByte() != (byte) 0) {
            z = true;
        }
        this.dUw = z;
    }
}
