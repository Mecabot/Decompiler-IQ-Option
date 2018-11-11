package com.microblink.geometry;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Size;
import java.util.ArrayList;

/* compiled from: line */
public class b implements Parcelable {
    public static final Creator<b> CREATOR = new Creator<b>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new b[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new b(parcel);
        }
    };
    private ArrayList<a> dUr = null;

    public int describeContents() {
        return 0;
    }

    public b(@Size(multiple = 2) float[] fArr) {
        this.dUr = new ArrayList(fArr.length / 2);
        for (int i = 0; i < fArr.length - 1; i += 2) {
            this.dUr.add(new a(fArr[i], fArr[i + 1]));
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.dUr);
    }

    protected b(Parcel parcel) {
        this.dUr = parcel.createTypedArrayList(a.CREATOR);
    }
}
