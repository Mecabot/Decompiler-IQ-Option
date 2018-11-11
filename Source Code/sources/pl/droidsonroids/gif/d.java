package pl.droidsonroids.gif;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.view.View.BaseSavedState;

/* compiled from: GifViewSavedState */
class d extends BaseSavedState {
    public static final Creator<d> CREATOR = new Creator<d>() {
        /* renamed from: ay */
        public d createFromParcel(Parcel parcel) {
            return new d(parcel, null);
        }

        /* renamed from: nA */
        public d[] newArray(int i) {
            return new d[i];
        }
    };
    final long[][] fkO;

    d(Parcelable parcelable, Drawable... drawableArr) {
        super(parcelable);
        this.fkO = new long[drawableArr.length][];
        for (int i = 0; i < drawableArr.length; i++) {
            Drawable drawable = drawableArr[i];
            if (drawable instanceof b) {
                this.fkO[i] = ((b) drawable).fkA.bFJ();
            } else {
                this.fkO[i] = null;
            }
        }
    }

    private d(Parcel parcel) {
        super(parcel);
        this.fkO = new long[parcel.readInt()][];
        for (int i = 0; i < this.fkO.length; i++) {
            this.fkO[i] = parcel.createLongArray();
        }
    }

    public void writeToParcel(@NonNull Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.fkO.length);
        for (long[] writeLongArray : this.fkO) {
            parcel.writeLongArray(writeLongArray);
        }
    }

    void d(Drawable drawable, int i) {
        if (this.fkO[i] != null && (drawable instanceof b)) {
            b bVar = (b) drawable;
            bVar.el((long) bVar.fkA.a(this.fkO[i], bVar.fkz));
        }
    }
}
