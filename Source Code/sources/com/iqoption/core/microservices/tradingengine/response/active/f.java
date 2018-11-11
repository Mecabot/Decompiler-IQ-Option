package com.iqoption.core.microservices.tradingengine.response.active;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\t\u0010\b\u001a\u00020\tHÖ\u0001J\b\u0010\n\u001a\u00020\tH\u0016J\u000f\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\fJ\u000f\u0010\r\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\fJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0017\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0001H\u0016J\u0019\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\tHÖ\u0001R\u001c\u0010\u0003\u001a\u00020\u00048\u0016XD¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006 "}, aXE = {"Lcom/iqoption/core/microservices/tradingengine/response/active/EmptyActive;", "Lcom/iqoption/core/microservices/tradingengine/response/active/Active;", "()V", "image", "", "image$annotations", "getImage", "()Ljava/lang/String;", "describeContents", "", "getActiveId", "getCommission", "()Ljava/lang/Integer;", "getGroupId", "getNextSchedule", "", "timeSync", "getPrecision", "getStartTime", "getTicker", "isBuybackEnabled", "", "isEnabled", "isExpired", "isTopTradersEnabled", "update", "", "value", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "core_release"})
/* compiled from: EmptyActive.kt */
public final class f extends a {
    public static final Creator CREATOR = new a();
    private final String image = "";

    @i(aXC = {1, 1, 11})
    public static class a implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            h.e(parcel, "in");
            return parcel.readInt() != 0 ? new f() : null;
        }

        public final Object[] newArray(int i) {
            return new f[i];
        }
    }

    public String Xg() {
        return null;
    }

    public boolean Xh() {
        return false;
    }

    public Integer Xi() {
        return null;
    }

    public boolean Xj() {
        return false;
    }

    public Integer Xk() {
        return null;
    }

    public boolean ba(long j) {
        return false;
    }

    public long bb(long j) {
        return 0;
    }

    public int describeContents() {
        return 0;
    }

    public int getActiveId() {
        return -1;
    }

    public int getPrecision() {
        return 0;
    }

    public long getStartTime() {
        return 0;
    }

    public boolean isExpired() {
        return false;
    }

    public void r(a aVar) {
        h.e(aVar, b.VALUE);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:6:0x000e in {2, 4, 5} preds:[]
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:238)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.util.ArrayList.forEach(ArrayList.java:1257)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:32)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
        	at java.lang.Iterable.forEach(Iterable.java:75)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
        	at jadx.core.ProcessClass.process(ProcessClass.java:37)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:293)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
        */
    public void writeToParcel(android.os.Parcel r1, int r2) {
        /*
        r0 = this;
        r2 = "parcel";
        kotlin.jvm.internal.h.e(r1, r2);
        if (r0 == 0) goto L_0x000c;
    L_0x0007:
        r2 = 1;
    L_0x0008:
        r1.writeInt(r2);
        return;
    L_0x000c:
        r2 = 0;
        goto L_0x0008;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.microservices.tradingengine.response.active.f.writeToParcel(android.os.Parcel, int):void");
    }

    public String getImage() {
        return this.image;
    }
}
