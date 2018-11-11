package com.iqoption.chat.repository;

import com.google.common.base.d;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.b;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.iqoption.util.af;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005RN\u0010\u0003\u001aB\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00070\u0007 \u0006* \u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, aXE = {"Lcom/iqoption/chat/repository/UserInfoRepository;", "", "()V", "cache", "Lcom/google/common/cache/Cache;", "", "kotlin.jvm.PlatformType", "Lcom/iqoption/chat/repository/UserInfo;", "getUserInfo", "Lcom/google/common/util/concurrent/ListenableFuture;", "userId", "countryId", "IqOption-5.5.1_optionXRelease"})
/* compiled from: UserInfoRepository.kt */
public final class h {
    private static final b<Long, g> aJR = CacheBuilder.qh().A(10).a(10, TimeUnit.MINUTES).qw();
    public static final h aJS = new h();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0010\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "Lcom/iqoption/chat/repository/UserInfo;", "it", "", "", "apply"})
    /* compiled from: UserInfoRepository.kt */
    static final class a<F, T> implements d<List<? extends Object>, g> {
        public static final a aJT = new a();

        a() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:34:0x00a9  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x00a7  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x00ca  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x00ac  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x00ce  */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x00d8  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0079  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x009d  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x00a7  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x00a9  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x00ac  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x00ca  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x00ce  */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x00d8  */
        /* JADX WARNING: Missing block: B:21:0x007b, code:
            if (r0 != null) goto L_0x0080;
     */
        /* JADX WARNING: Missing block: B:30:0x00a1, code:
            if (r0.intValue() == -1) goto L_0x00a4;
     */
        /* renamed from: U */
        public final com.iqoption.chat.repository.g apply(java.util.List<? extends java.lang.Object> r22) {
            /*
            r21 = this;
            if (r22 == 0) goto L_0x0005;
        L_0x0002:
            r0 = r22;
            goto L_0x0009;
        L_0x0005:
            r0 = kotlin.collections.m.emptyList();
        L_0x0009:
            r1 = r0.isEmpty();
            if (r1 == 0) goto L_0x0019;
        L_0x000f:
            r0 = new java.lang.RuntimeException;
            r1 = "No data has been received";
            r0.<init>(r1);
            r0 = (java.lang.Throwable) r0;
            throw r0;
        L_0x0019:
            r1 = kotlin.collections.u.bV(r0);
            r2 = r1 instanceof com.iqoption.microservice.c.a.b;
            r3 = 0;
            if (r2 != 0) goto L_0x0023;
        L_0x0022:
            r1 = r3;
        L_0x0023:
            r1 = (com.iqoption.microservice.c.a.b) r1;
            if (r1 == 0) goto L_0x00ec;
        L_0x0027:
            r2 = 1;
            r4 = kotlin.collections.u.h(r0, r2);
            r4 = (com.iqoption.microservice.c.a.c) r4;
            if (r4 == 0) goto L_0x003b;
        L_0x0030:
            r4 = r4.cSj;
            if (r4 == 0) goto L_0x003b;
        L_0x0034:
            r4 = kotlin.collections.u.bV(r4);
            r4 = (com.iqoption.microservice.c.a.c.a) r4;
            goto L_0x003c;
        L_0x003b:
            r4 = r3;
        L_0x003c:
            r5 = 2;
            r0 = kotlin.collections.u.h(r0, r5);
            r0 = (com.iqoption.dto.entity.iqbus.Country) r0;
            r20 = new com.iqoption.chat.repository.g;
            r5 = r1.userId;
            r6 = "profile.userId";
            kotlin.jvm.internal.h.d(r5, r6);
            r6 = r5.longValue();
            r8 = r1.userName;
            r5 = "profile.userName";
            kotlin.jvm.internal.h.d(r8, r5);
            r9 = r1.cSc;
            r5 = r1.cSi;
            r10 = r5.longValue();
            r5 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
            r12 = (long) r5;
            r10 = r10 * r12;
            r5 = r1.cSd;
            r12 = "profile.isVip";
            kotlin.jvm.internal.h.d(r5, r12);
            r12 = r5.booleanValue();
            r5 = com.iqoption.core.util.f.bgP;
            r13 = r1.flag;
            r13 = r5.aA(r13);
            if (r0 == 0) goto L_0x007e;
        L_0x0079:
            r0 = r0.name;
            if (r0 == 0) goto L_0x007e;
        L_0x007d:
            goto L_0x0080;
        L_0x007e:
            r0 = "";
        L_0x0080:
            r14 = r0;
            r0 = r1.cSh;
            r5 = "profile.selectedBalanceType";
            kotlin.jvm.internal.h.d(r0, r5);
            r15 = r0.intValue();
            r0 = r1.cSf;
            r5 = -1;
            if (r0 != 0) goto L_0x0092;
        L_0x0091:
            goto L_0x0098;
        L_0x0092:
            r0 = r0.intValue();
            if (r0 == r5) goto L_0x00a4;
        L_0x0098:
            r0 = r1.cSg;
            if (r0 != 0) goto L_0x009d;
        L_0x009c:
            goto L_0x00a5;
        L_0x009d:
            r0 = r0.intValue();
            if (r0 == r5) goto L_0x00a4;
        L_0x00a3:
            goto L_0x00a5;
        L_0x00a4:
            r2 = 0;
        L_0x00a5:
            if (r2 == 0) goto L_0x00a9;
        L_0x00a7:
            r0 = r1;
            goto L_0x00aa;
        L_0x00a9:
            r0 = r3;
        L_0x00aa:
            if (r0 == 0) goto L_0x00ca;
        L_0x00ac:
            r0 = new com.iqoption.chat.repository.a;
            r2 = r1.cSf;
            r5 = "profile.selectedAssetId";
            kotlin.jvm.internal.h.d(r2, r5);
            r2 = r2.intValue();
            r1 = r1.cSg;
            r5 = "profile.selectedOptionType";
            kotlin.jvm.internal.h.d(r1, r5);
            r1 = r1.intValue();
            r0.<init>(r2, r1);
            r16 = r0;
            goto L_0x00cc;
        L_0x00ca:
            r16 = r3;
        L_0x00cc:
            if (r4 == 0) goto L_0x00d0;
        L_0x00ce:
            r3 = r4.status;
        L_0x00d0:
            r0 = "online";
            r17 = kotlin.jvm.internal.h.E(r3, r0);
            if (r4 == 0) goto L_0x00e2;
        L_0x00d8:
            r0 = r4.cSm;
            if (r0 == 0) goto L_0x00e2;
        L_0x00dc:
            r0 = r0.intValue();
            r0 = (long) r0;
            goto L_0x00e4;
        L_0x00e2:
            r0 = 0;
        L_0x00e4:
            r18 = r0;
            r5 = r20;
            r5.<init>(r6, r8, r9, r10, r12, r13, r14, r15, r16, r17, r18);
            return r20;
        L_0x00ec:
            r0 = new java.lang.RuntimeException;
            r1 = "No profile has been received";
            r0.<init>(r1);
            r0 = (java.lang.Throwable) r0;
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.chat.repository.h.a.U(java.util.List):com.iqoption.chat.repository.g");
        }
    }

    private h() {
    }

    public final s<g> n(long j, long j2) {
        g gVar = (g) aJR.I(Long.valueOf(j));
        if (gVar != null) {
            s<g> aR = o.aR(gVar);
            kotlin.jvm.internal.h.d(aR, "Futures.immediateFuture(cached)");
            return aR;
        }
        s a = o.a(com.iqoption.microservice.c.a.bD(j), com.iqoption.microservice.c.a.I(l.cr(Long.valueOf(j))), com.iqoption.mobbtech.connect.request.api.d.by(j2));
        kotlin.jvm.internal.h.d(a, "Futures\n                …ts.getCountry(countryId))");
        s<g> a2 = af.a(a, (d) a.aJT, null, 2, null);
        af.a(a2, new UserInfoRepository$getUserInfo$1(j), null, null, null, 14, null);
        return a2;
    }
}
