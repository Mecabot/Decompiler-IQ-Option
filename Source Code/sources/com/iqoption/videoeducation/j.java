package com.iqoption.videoeducation;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.collect.Sets;
import com.google.common.primitives.Longs;
import io.reactivex.o;
import io.reactivex.processors.PublishProcessor;
import io.reactivex.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import kotlin.jvm.internal.PropertyReference1Impl;

@kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000o\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0003\u0004\u0007\u0010\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001-B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00140\u001dJ\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001f2\u0006\u0010 \u001a\u00020!H\u0007J\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00162\u0006\u0010$\u001a\u00020!J\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020#0\u001d2\u0006\u0010$\u001a\u00020!J\u0012\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0'0\u0016J\u0012\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0'0\u001dJ\u0014\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0'0\u0016H\u0007J\u0014\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0'0\u001dH\u0007J\u0010\u0010+\u001a\u00020,2\u0006\u0010 \u001a\u00020!H\u0007R\u0010\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u0010\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0004\n\u0002\u0010\bR2\u0010\t\u001a&\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b \f*\u0012\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0018\u00010\n0\nX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \f*\u0004\u0018\u00010\u000e0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u001c\u0010\u0012\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00140\u00140\u0013X\u0004¢\u0006\u0002\n\u0000R?\u0010\u0015\u001a&\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00170\u0017 \f*\u0012\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00170\u0017\u0018\u00010\u00160\u00168BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019¨\u0006."}, aXE = {"Lcom/iqoption/videoeducation/VideoEducationManager;", "", "()V", "CREATE_TIME_ORDERING", "com/iqoption/videoeducation/VideoEducationManager$CREATE_TIME_ORDERING$1", "Lcom/iqoption/videoeducation/VideoEducationManager$CREATE_TIME_ORDERING$1;", "NEW_FLAG_ORDERING", "com/iqoption/videoeducation/VideoEducationManager$NEW_FLAG_ORDERING$1", "Lcom/iqoption/videoeducation/VideoEducationManager$NEW_FLAG_ORDERING$1;", "ORDERING", "Lcom/google/common/collect/Ordering;", "Lcom/iqoption/core/microservices/videoeducation/response/Video;", "kotlin.jvm.PlatformType", "TAG", "", "WEIGHT_ORDERING", "com/iqoption/videoeducation/VideoEducationManager$WEIGHT_ORDERING$1", "Lcom/iqoption/videoeducation/VideoEducationManager$WEIGHT_ORDERING$1;", "eventsProcessor", "Lio/reactivex/processors/PublishProcessor;", "Lcom/iqoption/videoeducation/VideoEducationEvent;", "helperStream", "Lio/reactivex/Single;", "Lcom/iqoption/videoeducation/VideoEducationManager$Helper;", "getHelperStream", "()Lio/reactivex/Single;", "helperStream$delegate", "Lkotlin/Lazy;", "getEvents", "Lio/reactivex/Flowable;", "getVideo", "Lio/reactivex/Maybe;", "videoId", "", "getVideoCatalog", "Lcom/iqoption/videoeducation/model/VideoCatalog;", "categoryId", "getVideoCatalogStream", "getVideoCatalogs", "", "getVideoCatalogsStream", "getVideos", "getVideosStream", "watchVideo", "Lio/reactivex/Completable;", "Helper", "videoeducation_release"})
/* compiled from: VideoEducationManager.kt */
public final class j {
    private static final Ordering<com.iqoption.core.microservices.videoeducation.response.g> ORDERING = dyN.compound((Comparator) dyM).compound((Comparator) dyL);
    private static final String TAG = "j";
    static final /* synthetic */ kotlin.reflect.j[] apP = new kotlin.reflect.j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(j.class), "helperStream", "getHelperStream()Lio/reactivex/Single;"))};
    private static final kotlin.d arK = g.f(VideoEducationManager$helperStream$2.dyX);
    private static final a dyL = new a();
    private static final d dyM = new d();
    private static final c dyN = new c();
    private static final PublishProcessor<i> dyO = PublishProcessor.aXq();
    public static final j dyP = new j();

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u0010J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0013\u001a\u00020\u0010R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003X\u000e¢\u0006\u0002\n\u0000R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0014"}, aXE = {"Lcom/iqoption/videoeducation/VideoEducationManager$Helper;", "", "categories", "", "Lcom/iqoption/core/microservices/videoeducation/response/Category;", "videos", "Lcom/iqoption/core/microservices/videoeducation/response/Video;", "(Ljava/util/List;Ljava/util/List;)V", "catalogs", "Lcom/iqoption/videoeducation/model/VideoCatalog;", "getVideos", "()Ljava/util/List;", "setVideos", "(Ljava/util/List;)V", "getVideoCatalog", "categoryId", "", "getVideoCatalogs", "watchVideo", "videoId", "videoeducation_release"})
    /* compiled from: VideoEducationManager.kt */
    private static final class b {
        private List<com.iqoption.videoeducation.b.a> dyK;
        private List<com.iqoption.core.microservices.videoeducation.response.g> dyQ;

        public b(List<com.iqoption.core.microservices.videoeducation.response.a> list, List<com.iqoption.core.microservices.videoeducation.response.g> list2) {
            kotlin.jvm.internal.h.e(list, "categories");
            kotlin.jvm.internal.h.e(list2, "videos");
            Iterable iterable = list2;
            Ordering a = j.ORDERING;
            kotlin.jvm.internal.h.d(a, "ORDERING");
            this.dyQ = u.a(iterable, (Comparator) a);
            Iterable<com.iqoption.core.microservices.videoeducation.response.a> iterable2 = list;
            Collection arrayList = new ArrayList(n.e(iterable2, 10));
            for (com.iqoption.core.microservices.videoeducation.response.a aVar : iterable2) {
                ArrayList tM = Lists.tM();
                HashSet uI = Sets.uI();
                for (com.iqoption.core.microservices.videoeducation.response.g gVar : list2) {
                    if (aVar.a(gVar)) {
                        tM.add(gVar);
                        gVar.XX();
                        uI.addAll(gVar.XX());
                    }
                }
                kotlin.jvm.internal.h.d(tM, "categoryVideos");
                List list3 = tM;
                ArrayList w = Lists.w(uI);
                kotlin.jvm.internal.h.d(w, "Lists.newArrayList(categoryTags)");
                arrayList.add(new com.iqoption.videoeducation.b.a(aVar, list3, w));
            }
            this.dyK = (List) arrayList;
        }

        public final List<com.iqoption.core.microservices.videoeducation.response.g> aHD() {
            return this.dyQ;
        }

        public final synchronized List<com.iqoption.videoeducation.b.a> aHE() {
            return this.dyK;
        }

        public final synchronized com.iqoption.videoeducation.b.a cs(long j) {
            Object obj;
            for (Object obj2 : this.dyK) {
                Object obj3;
                if (((com.iqoption.videoeducation.b.a) obj2).aHW().getId() == j) {
                    obj3 = 1;
                    continue;
                } else {
                    obj3 = null;
                    continue;
                }
                if (obj3 != null) {
                    break;
                }
            }
            obj2 = null;
            return (com.iqoption.videoeducation.b.a) obj2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x006b A:{Catch:{ all -> 0x00fb }} */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x00f6 A:{Catch:{ all -> 0x00fb }} */
        public final synchronized com.iqoption.core.microservices.videoeducation.response.g ct(long r25) {
            /*
            r24 = this;
            r1 = r24;
            monitor-enter(r24);
            r3 = r1.dyQ;	 Catch:{ all -> 0x00fb }
            r3 = r3.iterator();	 Catch:{ all -> 0x00fb }
            r4 = 0;
            r5 = 0;
        L_0x000b:
            r6 = r3.hasNext();	 Catch:{ all -> 0x00fb }
            r7 = -1;
            r8 = 1;
            if (r6 == 0) goto L_0x002a;
        L_0x0013:
            r6 = r3.next();	 Catch:{ all -> 0x00fb }
            r6 = (com.iqoption.core.microservices.videoeducation.response.g) r6;	 Catch:{ all -> 0x00fb }
            r9 = r6.getId();	 Catch:{ all -> 0x00fb }
            r6 = (r9 > r25 ? 1 : (r9 == r25 ? 0 : -1));
            if (r6 != 0) goto L_0x0023;
        L_0x0021:
            r6 = 1;
            goto L_0x0024;
        L_0x0023:
            r6 = 0;
        L_0x0024:
            if (r6 == 0) goto L_0x0027;
        L_0x0026:
            goto L_0x002b;
        L_0x0027:
            r5 = r5 + 1;
            goto L_0x000b;
        L_0x002a:
            r5 = -1;
        L_0x002b:
            r3 = 0;
            if (r5 == r7) goto L_0x00f9;
        L_0x002e:
            r6 = r1.dyQ;	 Catch:{ all -> 0x00fb }
            r6 = r6.get(r5);	 Catch:{ all -> 0x00fb }
            r9 = r6;
            r9 = (com.iqoption.core.microservices.videoeducation.response.g) r9;	 Catch:{ all -> 0x00fb }
            r10 = 0;
            r12 = 0;
            r14 = 1;
            r13 = 0;
            r15 = 0;
            r16 = 0;
            r17 = 0;
            r18 = 0;
            r19 = 0;
            r20 = 0;
            r21 = 0;
            r22 = 2035; // 0x7f3 float:2.852E-42 double:1.0054E-320;
            r23 = 0;
            r6 = com.iqoption.core.microservices.videoeducation.response.g.a(r9, r10, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23);	 Catch:{ all -> 0x00fb }
            r9 = r1.dyQ;	 Catch:{ all -> 0x00fb }
            r5 = com.iqoption.core.ext.c.b(r9, r5, r6);	 Catch:{ all -> 0x00fb }
            r1.dyQ = r5;	 Catch:{ all -> 0x00fb }
            r3 = (java.util.List) r3;	 Catch:{ all -> 0x00fb }
            r5 = r6.Kj();	 Catch:{ all -> 0x00fb }
            r5 = (java.lang.Iterable) r5;	 Catch:{ all -> 0x00fb }
            r5 = r5.iterator();	 Catch:{ all -> 0x00fb }
        L_0x0065:
            r9 = r5.hasNext();	 Catch:{ all -> 0x00fb }
            if (r9 == 0) goto L_0x00f4;
        L_0x006b:
            r9 = r5.next();	 Catch:{ all -> 0x00fb }
            r9 = (com.iqoption.core.microservices.videoeducation.response.a) r9;	 Catch:{ all -> 0x00fb }
            r10 = r1.dyK;	 Catch:{ all -> 0x00fb }
            r10 = r10.iterator();	 Catch:{ all -> 0x00fb }
            r11 = 0;
        L_0x0078:
            r12 = r10.hasNext();	 Catch:{ all -> 0x00fb }
            if (r12 == 0) goto L_0x009d;
        L_0x007e:
            r12 = r10.next();	 Catch:{ all -> 0x00fb }
            r12 = (com.iqoption.videoeducation.b.a) r12;	 Catch:{ all -> 0x00fb }
            r12 = r12.aHW();	 Catch:{ all -> 0x00fb }
            r12 = r12.getId();	 Catch:{ all -> 0x00fb }
            r14 = r9.getId();	 Catch:{ all -> 0x00fb }
            r16 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1));
            if (r16 != 0) goto L_0x0096;
        L_0x0094:
            r12 = 1;
            goto L_0x0097;
        L_0x0096:
            r12 = 0;
        L_0x0097:
            if (r12 == 0) goto L_0x009a;
        L_0x0099:
            goto L_0x009e;
        L_0x009a:
            r11 = r11 + 1;
            goto L_0x0078;
        L_0x009d:
            r11 = -1;
        L_0x009e:
            if (r11 == r7) goto L_0x0065;
        L_0x00a0:
            r9 = r1.dyK;	 Catch:{ all -> 0x00fb }
            r9 = r9.get(r11);	 Catch:{ all -> 0x00fb }
            r12 = r9;
            r12 = (com.iqoption.videoeducation.b.a) r12;	 Catch:{ all -> 0x00fb }
            r9 = r12.aHD();	 Catch:{ all -> 0x00fb }
            r9 = r9.iterator();	 Catch:{ all -> 0x00fb }
            r10 = 0;
        L_0x00b2:
            r13 = r9.hasNext();	 Catch:{ all -> 0x00fb }
            if (r13 == 0) goto L_0x00cf;
        L_0x00b8:
            r13 = r9.next();	 Catch:{ all -> 0x00fb }
            r13 = (com.iqoption.core.microservices.videoeducation.response.g) r13;	 Catch:{ all -> 0x00fb }
            r13 = r13.getId();	 Catch:{ all -> 0x00fb }
            r15 = (r13 > r25 ? 1 : (r13 == r25 ? 0 : -1));
            if (r15 != 0) goto L_0x00c8;
        L_0x00c6:
            r13 = 1;
            goto L_0x00c9;
        L_0x00c8:
            r13 = 0;
        L_0x00c9:
            if (r13 == 0) goto L_0x00cc;
        L_0x00cb:
            goto L_0x00d0;
        L_0x00cc:
            r10 = r10 + 1;
            goto L_0x00b2;
        L_0x00cf:
            r10 = -1;
        L_0x00d0:
            if (r10 == r7) goto L_0x0065;
        L_0x00d2:
            if (r3 == 0) goto L_0x00d5;
        L_0x00d4:
            goto L_0x00dd;
        L_0x00d5:
            r3 = r1.dyK;	 Catch:{ all -> 0x00fb }
            r3 = (java.util.Collection) r3;	 Catch:{ all -> 0x00fb }
            r3 = kotlin.collections.u.O(r3);	 Catch:{ all -> 0x00fb }
        L_0x00dd:
            r13 = 0;
            r9 = r12.aHD();	 Catch:{ all -> 0x00fb }
            r14 = com.iqoption.core.ext.c.b(r9, r10, r6);	 Catch:{ all -> 0x00fb }
            r15 = 0;
            r16 = 5;
            r17 = 0;
            r9 = com.iqoption.videoeducation.b.a.a(r12, r13, r14, r15, r16, r17);	 Catch:{ all -> 0x00fb }
            r3.set(r11, r9);	 Catch:{ all -> 0x00fb }
            goto L_0x0065;
        L_0x00f4:
            if (r3 == 0) goto L_0x00f8;
        L_0x00f6:
            r1.dyK = r3;	 Catch:{ all -> 0x00fb }
        L_0x00f8:
            r3 = r6;
        L_0x00f9:
            monitor-exit(r24);
            return r3;
        L_0x00fb:
            r0 = move-exception;
            r2 = r0;
            monitor-exit(r24);
            throw r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.videoeducation.j.b.ct(long):com.iqoption.core.microservices.videoeducation.response.g");
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0007"}, aXE = {"com/iqoption/videoeducation/VideoEducationManager$CREATE_TIME_ORDERING$1", "Lcom/google/common/collect/Ordering;", "Lcom/iqoption/core/microservices/videoeducation/response/Video;", "compare", "", "left", "right", "videoeducation_release"})
    /* compiled from: VideoEducationManager.kt */
    public static final class a extends Ordering<com.iqoption.core.microservices.videoeducation.response.g> {
        a() {
        }

        /* renamed from: a */
        public int compare(com.iqoption.core.microservices.videoeducation.response.g gVar, com.iqoption.core.microservices.videoeducation.response.g gVar2) {
            long j = 0;
            long Wh = gVar2 != null ? gVar2.Wh() : 0;
            if (gVar != null) {
                j = gVar.Wh();
            }
            return Longs.compare(Wh, j);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0007"}, aXE = {"com/iqoption/videoeducation/VideoEducationManager$NEW_FLAG_ORDERING$1", "Lcom/google/common/collect/Ordering;", "Lcom/iqoption/core/microservices/videoeducation/response/Video;", "compare", "", "left", "right", "videoeducation_release"})
    /* compiled from: VideoEducationManager.kt */
    public static final class c extends Ordering<com.iqoption.core.microservices.videoeducation.response.g> {
        c() {
        }

        /* renamed from: a */
        public int compare(com.iqoption.core.microservices.videoeducation.response.g gVar, com.iqoption.core.microservices.videoeducation.response.g gVar2) {
            Boolean bool = null;
            Boolean valueOf = gVar != null ? Boolean.valueOf(gVar.XV()) : null;
            if (gVar2 != null) {
                bool = Boolean.valueOf(gVar2.XV());
            }
            if (valueOf == bool) {
                return 0;
            }
            if (gVar == null || !gVar.XV()) {
                return 1;
            }
            return -1;
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0007"}, aXE = {"com/iqoption/videoeducation/VideoEducationManager$WEIGHT_ORDERING$1", "Lcom/google/common/collect/Ordering;", "Lcom/iqoption/core/microservices/videoeducation/response/Video;", "compare", "", "left", "right", "videoeducation_release"})
    /* compiled from: VideoEducationManager.kt */
    public static final class d extends Ordering<com.iqoption.core.microservices.videoeducation.response.g> {
        d() {
        }

        /* renamed from: a */
        public int compare(com.iqoption.core.microservices.videoeducation.response.g gVar, com.iqoption.core.microservices.videoeducation.response.g gVar2) {
            int i = 0;
            int weight = gVar2 != null ? gVar2.getWeight() : 0;
            if (gVar != null) {
                i = gVar.getWeight();
            }
            return Integer.compare(weight, i);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "Lio/reactivex/Maybe;", "Lcom/iqoption/core/microservices/videoeducation/response/Video;", "kotlin.jvm.PlatformType", "it", "Lcom/iqoption/videoeducation/VideoEducationManager$Helper;", "apply"})
    /* compiled from: VideoEducationManager.kt */
    static final class e<T, R> implements io.reactivex.c.f<T, io.reactivex.k<? extends R>> {
        final /* synthetic */ long dyR;

        e(long j) {
            this.dyR = j;
        }

        /* renamed from: a */
        public final io.reactivex.i<com.iqoption.core.microservices.videoeducation.response.g> apply(b bVar) {
            kotlin.jvm.internal.h.e(bVar, "it");
            for (Object next : bVar.aHD()) {
                Object obj;
                if (((com.iqoption.core.microservices.videoeducation.response.g) next).getId() == this.dyR) {
                    obj = 1;
                    continue;
                } else {
                    obj = null;
                    continue;
                }
                if (obj != null) {
                    break;
                }
            }
            Object next2 = null;
            com.iqoption.core.microservices.videoeducation.response.g gVar = (com.iqoption.core.microservices.videoeducation.response.g) next2;
            if (gVar != null) {
                return io.reactivex.i.bZ(gVar);
            }
            return io.reactivex.i.aWe();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "Lcom/iqoption/videoeducation/model/VideoCatalog;", "it", "Lcom/iqoption/videoeducation/VideoEducationManager$Helper;", "apply"})
    /* compiled from: VideoEducationManager.kt */
    static final class f<T, R> implements io.reactivex.c.f<T, R> {
        final /* synthetic */ long dyS;

        f(long j) {
            this.dyS = j;
        }

        /* renamed from: b */
        public final com.iqoption.videoeducation.b.a apply(b bVar) {
            kotlin.jvm.internal.h.e(bVar, "it");
            com.iqoption.videoeducation.b.a cs = bVar.cs(this.dyS);
            if (cs != null) {
                return cs;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Catalog with category ID: ");
            stringBuilder.append(this.dyS);
            stringBuilder.append(" is not found");
            throw new NullPointerException(stringBuilder.toString());
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "Lcom/iqoption/videoeducation/model/VideoCatalog;", "it", "Lcom/iqoption/videoeducation/VideoEducationManager$Helper;", "apply"})
    /* compiled from: VideoEducationManager.kt */
    static final class g<T, R> implements io.reactivex.c.f<T, R> {
        public static final g dyT = new g();

        g() {
        }

        /* renamed from: c */
        public final List<com.iqoption.videoeducation.b.a> apply(b bVar) {
            kotlin.jvm.internal.h.e(bVar, "it");
            return bVar.aHE();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "Lcom/iqoption/videoeducation/model/VideoCatalog;", "it", "Lcom/iqoption/videoeducation/VideoEducationEvent;", "apply"})
    /* compiled from: VideoEducationManager.kt */
    static final class h<T, R> implements io.reactivex.c.f<T, R> {
        public static final h dyU = new h();

        h() {
        }

        /* renamed from: a */
        public final List<com.iqoption.videoeducation.b.a> apply(i iVar) {
            kotlin.jvm.internal.h.e(iVar, "it");
            return iVar.aHz();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "Lcom/iqoption/core/microservices/videoeducation/response/Video;", "it", "Lcom/iqoption/videoeducation/VideoEducationManager$Helper;", "apply"})
    /* compiled from: VideoEducationManager.kt */
    static final class i<T, R> implements io.reactivex.c.f<T, R> {
        public static final i dyV = new i();

        i() {
        }

        /* renamed from: c */
        public final List<com.iqoption.core.microservices.videoeducation.response.g> apply(b bVar) {
            kotlin.jvm.internal.h.e(bVar, "it");
            return bVar.aHD();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002 \u0004*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, aXE = {"<anonymous>", "Lio/reactivex/Flowable;", "", "Lcom/iqoption/core/microservices/videoeducation/response/Video;", "kotlin.jvm.PlatformType", "it", "Lcom/iqoption/videoeducation/VideoEducationEvent;", "apply"})
    /* compiled from: VideoEducationManager.kt */
    static final class j<T, R> implements io.reactivex.c.f<T, org.a.b<? extends R>> {
        final /* synthetic */ io.reactivex.e dyW;

        j(io.reactivex.e eVar) {
            this.dyW = eVar;
        }

        /* renamed from: b */
        public final io.reactivex.e<List<com.iqoption.core.microservices.videoeducation.response.g>> apply(i iVar) {
            kotlin.jvm.internal.h.e(iVar, "it");
            return this.dyW;
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "Lio/reactivex/CompletableSource;", "kotlin.jvm.PlatformType", "video", "Lcom/iqoption/core/microservices/videoeducation/response/Video;", "apply"})
    /* compiled from: VideoEducationManager.kt */
    static final class k<T, R> implements io.reactivex.c.f<com.iqoption.core.microservices.videoeducation.response.g, io.reactivex.c> {
        final /* synthetic */ long dyR;

        @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/videoeducation/VideoEducationManager$Helper;", "kotlin.jvm.PlatformType", "accept"})
        /* compiled from: VideoEducationManager.kt */
        /* renamed from: com.iqoption.videoeducation.j$k$1 */
        static final class AnonymousClass1<T> implements io.reactivex.c.e<b> {
            final /* synthetic */ k dyZ;

            AnonymousClass1(k kVar) {
                this.dyZ = kVar;
            }

            /* renamed from: d */
            public final void accept(b bVar) {
                com.iqoption.core.microservices.videoeducation.response.g ct = bVar.ct(this.dyZ.dyR);
                if (ct != null) {
                    j.dyO.e(new k(ct, bVar.aHE()));
                }
            }
        }

        k(long j) {
            this.dyR = j;
        }

        /* renamed from: e */
        public final io.reactivex.c apply(com.iqoption.core.microservices.videoeducation.response.g gVar) {
            kotlin.jvm.internal.h.e(gVar, "video");
            if (gVar.XV()) {
                return com.iqoption.core.microservices.videoeducation.a.bc(this.dyR).a((s) j.dyP.JX()).d(new AnonymousClass1(this)).aWj();
            }
            return io.reactivex.a.aVR();
        }
    }

    private final o<b> JX() {
        kotlin.d dVar = arK;
        kotlin.reflect.j jVar = apP[0];
        return (o) dVar.getValue();
    }

    private j() {
    }

    public final io.reactivex.e<i> aDA() {
        PublishProcessor publishProcessor = dyO;
        kotlin.jvm.internal.h.d(publishProcessor, "eventsProcessor");
        return publishProcessor;
    }

    public final o<List<com.iqoption.videoeducation.b.a>> aHA() {
        o<List<com.iqoption.videoeducation.b.a>> n = JX().n(g.dyT);
        kotlin.jvm.internal.h.d(n, "helperStream.map { it.getVideoCatalogs() }");
        return n;
    }

    public final io.reactivex.e<List<com.iqoption.videoeducation.b.a>> aHB() {
        io.reactivex.e<List<com.iqoption.videoeducation.b.a>> c = aHA().aWk().c((org.a.b) aDA().d((io.reactivex.c.f) h.dyU));
        kotlin.jvm.internal.h.d(c, "getVideoCatalogs()\n     …ts().map { it.catalogs })");
        return c;
    }

    public final o<com.iqoption.videoeducation.b.a> cp(long j) {
        o<com.iqoption.videoeducation.b.a> n = JX().n(new f(j));
        kotlin.jvm.internal.h.d(n, "helperStream.map {\n     … is not found\")\n        }");
        return n;
    }

    public static final o<List<com.iqoption.core.microservices.videoeducation.response.g>> XP() {
        o<List<com.iqoption.core.microservices.videoeducation.response.g>> n = dyP.JX().n(i.dyV);
        kotlin.jvm.internal.h.d(n, "helperStream.map { it.videos }");
        return n;
    }

    public static final io.reactivex.e<List<com.iqoption.core.microservices.videoeducation.response.g>> aHC() {
        io.reactivex.e aWk = XP().aWk();
        io.reactivex.e<List<com.iqoption.core.microservices.videoeducation.response.g>> c = aWk.c((org.a.b) dyP.aDA().a((io.reactivex.c.f) new j(aWk)));
        kotlin.jvm.internal.h.d(c, "stream.concatWith(getEvents().flatMap { stream })");
        return c;
    }

    public static final io.reactivex.i<com.iqoption.core.microservices.videoeducation.response.g> cq(long j) {
        io.reactivex.i<com.iqoption.core.microservices.videoeducation.response.g> l = dyP.JX().l(new e(j));
        kotlin.jvm.internal.h.d(l, "helperStream.flatMapMayb…)\n            }\n        }");
        return l;
    }

    public static final io.reactivex.a cr(long j) {
        io.reactivex.a i = cq(j).i(new k(j));
        kotlin.jvm.internal.h.d(i, "getVideo(videoId)\n      …      }\n                }");
        return i;
    }
}
