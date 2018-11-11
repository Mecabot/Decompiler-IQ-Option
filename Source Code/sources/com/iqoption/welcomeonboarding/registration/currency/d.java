package com.iqoption.welcomeonboarding.registration.currency;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.iqoption.dto.Currencies.Currency;
import java.util.ArrayList;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000bJ*\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0010J\t\u0010\u0011\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u001e"}, aXE = {"Lcom/iqoption/welcomeonboarding/registration/currency/CurrencyMenuParams;", "Landroid/os/Parcelable;", "currencies", "", "Lcom/iqoption/dto/Currencies$Currency;", "selectedId", "", "(Ljava/util/List;Ljava/lang/Integer;)V", "getCurrencies", "()Ljava/util/List;", "getSelectedId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/util/List;Ljava/lang/Integer;)Lcom/iqoption/welcomeonboarding/registration/currency/CurrencyMenuParams;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "IqOption-5.5.1_optionXRelease"})
/* compiled from: CurrencyMenuParams.kt */
public final class d implements Parcelable {
    public static final Creator CREATOR = new a();
    private final List<Currency> aVv;
    private final Integer bXg;

    @i(aXC = {1, 1, 11})
    public static class a implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            h.e(parcel, "in");
            int readInt = parcel.readInt();
            List arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((Currency) parcel.readParcelable(d.class.getClassLoader()));
                readInt--;
            }
            return new d(arrayList, parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null);
        }

        public final Object[] newArray(int i) {
            return new d[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    /* JADX WARNING: Missing block: B:6:0x001a, code:
            if (kotlin.jvm.internal.h.E(r2.bXg, r3.bXg) != false) goto L_0x001f;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x001f;
    L_0x0002:
        r0 = r3 instanceof com.iqoption.welcomeonboarding.registration.currency.d;
        if (r0 == 0) goto L_0x001d;
    L_0x0006:
        r3 = (com.iqoption.welcomeonboarding.registration.currency.d) r3;
        r0 = r2.aVv;
        r1 = r3.aVv;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x001d;
    L_0x0012:
        r0 = r2.bXg;
        r3 = r3.bXg;
        r3 = kotlin.jvm.internal.h.E(r0, r3);
        if (r3 == 0) goto L_0x001d;
    L_0x001c:
        goto L_0x001f;
    L_0x001d:
        r3 = 0;
        return r3;
    L_0x001f:
        r3 = 1;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.welcomeonboarding.registration.currency.d.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        List list = this.aVv;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        Integer num = this.bXg;
        if (num != null) {
            i = num.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CurrencyMenuParams(currencies=");
        stringBuilder.append(this.aVv);
        stringBuilder.append(", selectedId=");
        stringBuilder.append(this.bXg);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:10:0x0034 in {3, 6, 8, 9} preds:[]
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:238)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.util.ArrayList.forEach(ArrayList.java:1257)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:32)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:293)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
        */
    public void writeToParcel(android.os.Parcel r3, int r4) {
        /*
        r2 = this;
        r0 = "parcel";
        kotlin.jvm.internal.h.e(r3, r0);
        r0 = r2.aVv;
        r1 = r0.size();
        r3.writeInt(r1);
        r0 = r0.iterator();
    L_0x0012:
        r1 = r0.hasNext();
        if (r1 == 0) goto L_0x0022;
    L_0x0018:
        r1 = r0.next();
        r1 = (com.iqoption.dto.Currencies.Currency) r1;
        r3.writeParcelable(r1, r4);
        goto L_0x0012;
    L_0x0022:
        r4 = r2.bXg;
        if (r4 == 0) goto L_0x0032;
    L_0x0026:
        r0 = 1;
        r3.writeInt(r0);
        r4 = r4.intValue();
    L_0x002e:
        r3.writeInt(r4);
        return;
    L_0x0032:
        r4 = 0;
        goto L_0x002e;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.welcomeonboarding.registration.currency.d.writeToParcel(android.os.Parcel, int):void");
    }

    public d(List<? extends Currency> list, Integer num) {
        h.e(list, "currencies");
        this.aVv = list;
        this.bXg = num;
    }

    public final List<Currency> VF() {
        return this.aVv;
    }

    public final Integer ace() {
        return this.bXg;
    }
}
