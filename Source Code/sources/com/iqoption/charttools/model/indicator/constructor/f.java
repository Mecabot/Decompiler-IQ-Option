package com.iqoption.charttools.model.indicator.constructor;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B!\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0010HÖ\u0001R\u001e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, aXE = {"Lcom/iqoption/charttools/model/indicator/constructor/Inputs;", "Landroid/os/Parcelable;", "()V", "groups", "", "Lcom/iqoption/charttools/model/indicator/constructor/InputGroup;", "inputs", "Lcom/iqoption/charttools/model/indicator/constructor/InputItem;", "([Lcom/iqoption/charttools/model/indicator/constructor/InputGroup;[Lcom/iqoption/charttools/model/indicator/constructor/InputItem;)V", "getGroups", "()[Lcom/iqoption/charttools/model/indicator/constructor/InputGroup;", "[Lcom/iqoption/charttools/model/indicator/constructor/InputGroup;", "getInputs", "()[Lcom/iqoption/charttools/model/indicator/constructor/InputItem;", "[Lcom/iqoption/charttools/model/indicator/constructor/InputItem;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "techtools_release"})
/* compiled from: Inputs.kt */
public final class f implements Parcelable {
    public static final Creator CREATOR = new b();
    private static final f azc = new f();
    public static final a azd = new a();
    @SerializedName("input_groups")
    private final c[] ayR;
    @SerializedName("inputs")
    private final InputItem[] ayS;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, aXE = {"Lcom/iqoption/charttools/model/indicator/constructor/Inputs$Companion;", "", "()V", "EMPTY", "Lcom/iqoption/charttools/model/indicator/constructor/Inputs;", "getEMPTY", "()Lcom/iqoption/charttools/model/indicator/constructor/Inputs;", "techtools_release"})
    /* compiled from: Inputs.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final f MF() {
            return f.azc;
        }
    }

    @i(aXC = {1, 1, 11})
    public static class b implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            h.e(parcel, "in");
            int readInt = parcel.readInt();
            c[] cVarArr = new c[readInt];
            for (int i = 0; readInt > i; i++) {
                cVarArr[i] = (c) c.CREATOR.createFromParcel(parcel);
            }
            readInt = parcel.readInt();
            InputItem[] inputItemArr = new InputItem[readInt];
            for (int i2 = 0; readInt > i2; i2++) {
                inputItemArr[i2] = (InputItem) InputItem.CREATOR.createFromParcel(parcel);
            }
            return new f(cVarArr, inputItemArr);
        }

        public final Object[] newArray(int i) {
            return new f[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        h.e(parcel, "parcel");
        c[] cVarArr = this.ayR;
        int length = cVarArr.length;
        parcel.writeInt(length);
        for (i2 = 0; length > i2; i2++) {
            cVarArr[i2].writeToParcel(parcel, 0);
        }
        InputItem[] inputItemArr = this.ayS;
        length = inputItemArr.length;
        parcel.writeInt(length);
        for (i2 = 0; length > i2; i2++) {
            inputItemArr[i2].writeToParcel(parcel, 0);
        }
    }

    public f(c[] cVarArr, InputItem[] inputItemArr) {
        h.e(cVarArr, "groups");
        h.e(inputItemArr, "inputs");
        this.ayR = cVarArr;
        this.ayS = inputItemArr;
    }

    public final c[] Mq() {
        return this.ayR;
    }

    public final InputItem[] MD() {
        return this.ayS;
    }

    public f() {
        this(new c[0], new InputItem[0]);
    }
}
