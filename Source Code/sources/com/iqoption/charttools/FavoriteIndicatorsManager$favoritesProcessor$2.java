package com.iqoption.charttools;

import com.iqoption.charttools.model.indicator.x;
import io.reactivex.c.e;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "Lcom/iqoption/core/rx/IQBehaviorProcessor;", "", "Lcom/iqoption/charttools/model/indicator/MetaIndicator;", "invoke"})
/* compiled from: FavoriteIndicatorsManager.kt */
final class FavoriteIndicatorsManager$favoritesProcessor$2 extends Lambda implements kotlin.jvm.a.a<com.iqoption.core.h.a<List<? extends x>>> {
    public static final FavoriteIndicatorsManager$favoritesProcessor$2 asj = new FavoriteIndicatorsManager$favoritesProcessor$2();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "library", "Lcom/iqoption/charttools/IndicatorsLibrary;", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: FavoriteIndicatorsManager.kt */
    static final class a<T> implements e<k> {
        final /* synthetic */ com.iqoption.core.h.a asl;

        a(com.iqoption.core.h.a aVar) {
            this.asl = aVar;
        }

        /* JADX WARNING: Missing block: B:3:0x001c, code:
            if (r5 != null) goto L_0x0023;
     */
        /* renamed from: b */
        public final void accept(com.iqoption.charttools.k r5) {
            /*
            r4 = this;
            r0 = com.iqoption.charttools.i.ash;
            r0 = com.iqoption.charttools.i.arI;
            r1 = "uids";
            r2 = 0;
            r3 = 2;
            r0 = com.iqoption.core.data.d.b.b.a(r0, r1, r2, r3, r2);
            if (r0 == 0) goto L_0x001f;
        L_0x0011:
            r1 = com.iqoption.charttools.i.ash;
            r2 = "library";
            kotlin.jvm.internal.h.d(r5, r2);
            r5 = r1.a(r0, r5);
            if (r5 == 0) goto L_0x001f;
        L_0x001e:
            goto L_0x0023;
        L_0x001f:
            r5 = kotlin.collections.m.emptyList();
        L_0x0023:
            r0 = r4.asl;
            r0.e(r5);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.charttools.FavoriteIndicatorsManager.favoritesProcessor.2.a.b(com.iqoption.charttools.k):void");
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: FavoriteIndicatorsManager.kt */
    static final class b<T> implements e<Throwable> {
        public static final b asm = new b();

        b() {
        }

        /* renamed from: o */
        public final void accept(Throwable th) {
            com.iqoption.core.i.w(i.TAG, "Could not initialize favorite indicators", th);
        }
    }

    FavoriteIndicatorsManager$favoritesProcessor$2() {
        super(0);
    }

    /* renamed from: Kh */
    public final com.iqoption.core.h.a<List<x>> invoke() {
        com.iqoption.core.h.a<List<x>> Yd = com.iqoption.core.h.a.baf.Yd();
        l.asx.Km().h(com.iqoption.core.h.i.Yo()).a((e) new a(Yd), (e) b.asm);
        return Yd;
    }
}
