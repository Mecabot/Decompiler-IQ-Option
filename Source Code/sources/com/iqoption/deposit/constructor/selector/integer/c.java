package com.iqoption.deposit.constructor.selector.integer;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\fJ4\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0014J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006!"}, aXE = {"Lcom/iqoption/deposit/constructor/selector/integer/SelectorIntegerMenuParams;", "Landroid/os/Parcelable;", "fieldName", "", "values", "", "", "selectedId", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;)V", "getFieldName", "()Ljava/lang/String;", "getSelectedId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getValues", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;)Lcom/iqoption/deposit/constructor/selector/integer/SelectorIntegerMenuParams;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "deposit_release"})
/* compiled from: SelectorIntegerMenuParams.kt */
public final class c implements Parcelable {
    public static final Creator CREATOR = new a();
    private final Integer bXg;
    private final String fieldName;
    private final List<Integer> values;

    @i(aXC = {1, 1, 11})
    public static class a implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            h.e(parcel, "in");
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            List arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add(Integer.valueOf(parcel.readInt()));
                readInt--;
            }
            return new c(readString, arrayList, parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null);
        }

        public final Object[] newArray(int i) {
            return new c[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    /* JADX WARNING: Missing block: B:8:0x0024, code:
            if (kotlin.jvm.internal.h.E(r2.bXg, r3.bXg) != false) goto L_0x0029;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x0029;
    L_0x0002:
        r0 = r3 instanceof com.iqoption.deposit.constructor.selector.integer.c;
        if (r0 == 0) goto L_0x0027;
    L_0x0006:
        r3 = (com.iqoption.deposit.constructor.selector.integer.c) r3;
        r0 = r2.fieldName;
        r1 = r3.fieldName;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0027;
    L_0x0012:
        r0 = r2.values;
        r1 = r3.values;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0027;
    L_0x001c:
        r0 = r2.bXg;
        r3 = r3.bXg;
        r3 = kotlin.jvm.internal.h.E(r0, r3);
        if (r3 == 0) goto L_0x0027;
    L_0x0026:
        goto L_0x0029;
    L_0x0027:
        r3 = 0;
        return r3;
    L_0x0029:
        r3 = 1;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.deposit.constructor.selector.integer.c.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.fieldName;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List list = this.values;
        hashCode = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        Integer num = this.bXg;
        if (num != null) {
            i = num.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SelectorIntegerMenuParams(fieldName=");
        stringBuilder.append(this.fieldName);
        stringBuilder.append(", values=");
        stringBuilder.append(this.values);
        stringBuilder.append(", selectedId=");
        stringBuilder.append(this.bXg);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:10:0x003d in {3, 6, 8, 9} preds:[]
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
    public void writeToParcel(android.os.Parcel r2, int r3) {
        /*
        r1 = this;
        r3 = "parcel";
        kotlin.jvm.internal.h.e(r2, r3);
        r3 = r1.fieldName;
        r2.writeString(r3);
        r3 = r1.values;
        r0 = r3.size();
        r2.writeInt(r0);
        r3 = r3.iterator();
    L_0x0017:
        r0 = r3.hasNext();
        if (r0 == 0) goto L_0x002b;
    L_0x001d:
        r0 = r3.next();
        r0 = (java.lang.Integer) r0;
        r0 = r0.intValue();
        r2.writeInt(r0);
        goto L_0x0017;
    L_0x002b:
        r3 = r1.bXg;
        if (r3 == 0) goto L_0x003b;
    L_0x002f:
        r0 = 1;
        r2.writeInt(r0);
        r3 = r3.intValue();
    L_0x0037:
        r2.writeInt(r3);
        return;
    L_0x003b:
        r3 = 0;
        goto L_0x0037;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.deposit.constructor.selector.integer.c.writeToParcel(android.os.Parcel, int):void");
    }

    public c(String str, List<Integer> list, Integer num) {
        h.e(str, "fieldName");
        h.e(list, "values");
        this.fieldName = str;
        this.values = list;
        this.bXg = num;
    }

    public final List<Integer> acd() {
        return this.values;
    }

    public final Integer ace() {
        return this.bXg;
    }

    public final String getFieldName() {
        return this.fieldName;
    }
}
