package com.iqoption.core.microservices.risks.response.overnightfee;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.IntRange;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B)\u0012\"\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\n\u001a\u00020\u0004HÖ\u0001J\u001f\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0001\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004HÖ\u0001R-\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0016"}, aXE = {"Lcom/iqoption/core/microservices/risks/response/overnightfee/OvernightFeeMap;", "Landroid/os/Parcelable;", "feeMap", "Ljava/util/HashMap;", "", "Lcom/iqoption/core/microservices/risks/response/overnightfee/FeeData;", "Lkotlin/collections/HashMap;", "(Ljava/util/HashMap;)V", "getFeeMap", "()Ljava/util/HashMap;", "describeContents", "getFee", "", "day", "isCall", "", "(IZ)Ljava/lang/Double;", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "core_release"})
/* compiled from: OvernightFeeMap.kt */
public final class d implements Parcelable {
    public static final Creator CREATOR = new a();
    private final HashMap<Integer, b> aXI;

    @i(aXC = {1, 1, 11})
    public static class a implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            h.e(parcel, "in");
            int readInt = parcel.readInt();
            Object hashMap = new HashMap(readInt);
            while (readInt != 0) {
                hashMap.put(Integer.valueOf(parcel.readInt()), (b) b.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            return new d(hashMap);
        }

        public final Object[] newArray(int i) {
            return new d[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.e(parcel, "parcel");
        Map map = this.aXI;
        parcel.writeInt(map.size());
        for (Entry next : map.entrySet()) {
            parcel.writeInt(((Integer) next.getKey()).intValue());
            ((b) next.getValue()).writeToParcel(parcel, 0);
        }
    }

    public d(HashMap<Integer, b> hashMap) {
        h.e(hashMap, "feeMap");
        this.aXI = hashMap;
    }

    public final HashMap<Integer, b> WL() {
        return this.aXI;
    }

    public final Double i(@IntRange(from = 1, to = 7) int i, boolean z) {
        double WJ;
        b bVar;
        if (z) {
            bVar = (b) this.aXI.get(Integer.valueOf(i));
            if (bVar == null) {
                return null;
            }
            WJ = bVar.WJ();
        } else {
            bVar = (b) this.aXI.get(Integer.valueOf(i));
            if (bVar == null) {
                return null;
            }
            WJ = bVar.WK();
        }
        return Double.valueOf(WJ);
    }
}
