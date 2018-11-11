package com.iqoption.videoeducation;

import com.google.android.gms.plus.PlusShare;
import com.iqoption.videoeducation.b.a;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003JA\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, aXE = {"Lcom/iqoption/videoeducation/VideoCatalogItem;", "Lcom/iqoption/videoeducation/VideoCatalogAdapterItem;", "catalog", "Lcom/iqoption/videoeducation/model/VideoCatalog;", "icon", "", "title", "allCount", "newCount", "(Lcom/iqoption/videoeducation/model/VideoCatalog;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAllCount", "()Ljava/lang/String;", "getCatalog", "()Lcom/iqoption/videoeducation/model/VideoCatalog;", "getIcon", "getNewCount", "getTitle", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "IqOption-5.5.1_optionXRelease"})
/* compiled from: VideoCatalogAdapterItems.kt */
public final class g extends e {
    private final String cQm;
    private final a dyH;
    private final String dyI;
    private final String dyJ;
    private final String title;

    /* JADX WARNING: Missing block: B:12:0x0038, code:
            if (kotlin.jvm.internal.h.E(r2.dyJ, r3.dyJ) != false) goto L_0x003d;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x003d;
    L_0x0002:
        r0 = r3 instanceof com.iqoption.videoeducation.g;
        if (r0 == 0) goto L_0x003b;
    L_0x0006:
        r3 = (com.iqoption.videoeducation.g) r3;
        r0 = r2.dyH;
        r1 = r3.dyH;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x003b;
    L_0x0012:
        r0 = r2.cQm;
        r1 = r3.cQm;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x003b;
    L_0x001c:
        r0 = r2.title;
        r1 = r3.title;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x003b;
    L_0x0026:
        r0 = r2.dyI;
        r1 = r3.dyI;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x003b;
    L_0x0030:
        r0 = r2.dyJ;
        r3 = r3.dyJ;
        r3 = kotlin.jvm.internal.h.E(r0, r3);
        if (r3 == 0) goto L_0x003b;
    L_0x003a:
        goto L_0x003d;
    L_0x003b:
        r3 = 0;
        return r3;
    L_0x003d:
        r3 = 1;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.videoeducation.g.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        a aVar = this.dyH;
        int i = 0;
        int hashCode = (aVar != null ? aVar.hashCode() : 0) * 31;
        String str = this.cQm;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = this.title;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = this.dyI;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = this.dyJ;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("VideoCatalogItem(catalog=");
        stringBuilder.append(this.dyH);
        stringBuilder.append(", icon=");
        stringBuilder.append(this.cQm);
        stringBuilder.append(", title=");
        stringBuilder.append(this.title);
        stringBuilder.append(", allCount=");
        stringBuilder.append(this.dyI);
        stringBuilder.append(", newCount=");
        stringBuilder.append(this.dyJ);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final a aHw() {
        return this.dyH;
    }

    public final String arK() {
        return this.cQm;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String aHx() {
        return this.dyI;
    }

    public final String aHy() {
        return this.dyJ;
    }

    public g(a aVar, String str, String str2, String str3, String str4) {
        h.e(aVar, "catalog");
        h.e(str2, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
        super(aVar.aHW().getId(), null);
        this.dyH = aVar;
        this.cQm = str;
        this.title = str2;
        this.dyI = str3;
        this.dyJ = str4;
    }
}
