package com.iqoption.videoeducation.b;

import com.iqoption.core.microservices.videoeducation.response.f;
import com.iqoption.core.microservices.videoeducation.response.g;
import java.util.Collection;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0005HÆ\u0003J3\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013¨\u0006\u001f"}, aXE = {"Lcom/iqoption/videoeducation/model/VideoCatalog;", "", "category", "Lcom/iqoption/core/microservices/videoeducation/response/Category;", "videos", "", "Lcom/iqoption/core/microservices/videoeducation/response/Video;", "tags", "Lcom/iqoption/core/microservices/videoeducation/response/Tag;", "(Lcom/iqoption/core/microservices/videoeducation/response/Category;Ljava/util/List;Ljava/util/List;)V", "allVideoCount", "", "getAllVideoCount", "()I", "getCategory", "()Lcom/iqoption/core/microservices/videoeducation/response/Category;", "newVideoCount", "getNewVideoCount", "getTags", "()Ljava/util/List;", "getVideos", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "videoeducation_release"})
/* compiled from: VideoCatalog.kt */
public final class a {
    private final int dAk = this.dyQ.size();
    private final com.iqoption.core.microservices.videoeducation.response.a dAl;
    private final List<g> dyQ;
    private final List<f> gD;
    private final int newVideoCount;

    public static /* bridge */ /* synthetic */ a a(a aVar, com.iqoption.core.microservices.videoeducation.response.a aVar2, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            aVar2 = aVar.dAl;
        }
        if ((i & 2) != 0) {
            list = aVar.dyQ;
        }
        if ((i & 4) != 0) {
            list2 = aVar.gD;
        }
        return aVar.a(aVar2, list, list2);
    }

    public final a a(com.iqoption.core.microservices.videoeducation.response.a aVar, List<g> list, List<f> list2) {
        h.e(aVar, "category");
        h.e(list, "videos");
        h.e(list2, "tags");
        return new a(aVar, list, list2);
    }

    /* JADX WARNING: Missing block: B:8:0x0024, code:
            if (kotlin.jvm.internal.h.E(r2.gD, r3.gD) != false) goto L_0x0029;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x0029;
    L_0x0002:
        r0 = r3 instanceof com.iqoption.videoeducation.b.a;
        if (r0 == 0) goto L_0x0027;
    L_0x0006:
        r3 = (com.iqoption.videoeducation.b.a) r3;
        r0 = r2.dAl;
        r1 = r3.dAl;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0027;
    L_0x0012:
        r0 = r2.dyQ;
        r1 = r3.dyQ;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0027;
    L_0x001c:
        r0 = r2.gD;
        r3 = r3.gD;
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
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.videoeducation.b.a.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        com.iqoption.core.microservices.videoeducation.response.a aVar = this.dAl;
        int i = 0;
        int hashCode = (aVar != null ? aVar.hashCode() : 0) * 31;
        List list = this.dyQ;
        hashCode = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        list = this.gD;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("VideoCatalog(category=");
        stringBuilder.append(this.dAl);
        stringBuilder.append(", videos=");
        stringBuilder.append(this.dyQ);
        stringBuilder.append(", tags=");
        stringBuilder.append(this.gD);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public a(com.iqoption.core.microservices.videoeducation.response.a aVar, List<g> list, List<f> list2) {
        h.e(aVar, "category");
        h.e(list, "videos");
        h.e(list2, "tags");
        this.dAl = aVar;
        this.dyQ = list;
        this.gD = list2;
        Iterable<g> iterable = this.dyQ;
        int i = 0;
        if (!((iterable instanceof Collection) && ((Collection) iterable).isEmpty())) {
            for (g XV : iterable) {
                if (XV.XV()) {
                    i++;
                }
            }
        }
        this.newVideoCount = i;
    }

    public final List<f> XX() {
        return this.gD;
    }

    public final List<g> aHD() {
        return this.dyQ;
    }

    public final com.iqoption.core.microservices.videoeducation.response.a aHW() {
        return this.dAl;
    }

    public final int aHU() {
        return this.dAk;
    }

    public final int aHV() {
        return this.newVideoCount;
    }
}
