package com.microblink.geometry;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: line */
public class c implements Parcelable {
    public static final Creator<c> CREATOR = new Creator<c>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new c[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new c(parcel, (byte) 0);
        }
    };
    private float dUo;
    private float dUp;
    private float dUx;
    private float dUy;

    private static boolean Q(float f) {
        return f >= 0.0f && f <= 1.0f;
    }

    public int describeContents() {
        return 0;
    }

    /* synthetic */ c(Parcel parcel, byte b) {
        this(parcel);
    }

    public c(float f, float f2, float f3, float f4) {
        this.dUo = f;
        this.dUp = f2;
        this.dUx = f3;
        this.dUy = f4;
    }

    public boolean isRelative() {
        return Q(this.dUo) && Q(this.dUp) && Q(this.dUx) && Q(this.dUy) && this.dUo + this.dUx <= 1.0f && this.dUp + this.dUy <= 1.0f;
    }

    private c(Parcel parcel) {
        this.dUo = parcel.readFloat();
        this.dUp = parcel.readFloat();
        this.dUx = parcel.readFloat();
        this.dUy = parcel.readFloat();
    }

    public static c aOF() {
        return new c(0.0f, 0.0f, 1.0f, 1.0f);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Rectangle[");
        stringBuilder.append(this.dUo);
        stringBuilder.append(", ");
        stringBuilder.append(this.dUp);
        stringBuilder.append(", ");
        stringBuilder.append(this.dUx);
        stringBuilder.append(", ");
        stringBuilder.append(this.dUy);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public float getX() {
        return this.dUo;
    }

    public float getY() {
        return this.dUp;
    }

    public float getWidth() {
        return this.dUx;
    }

    public float getHeight() {
        return this.dUy;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.dUo);
        parcel.writeFloat(this.dUp);
        parcel.writeFloat(this.dUx);
        parcel.writeFloat(this.dUy);
    }
}
