package com.iqoption.vip;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import com.google.common.util.concurrent.n;
import com.iqoption.microservice.vip.e;
import com.iqoption.microservice.vip.f;
import com.iqoption.util.ag;
import com.iqoption.util.ba;
import com.iqoption.util.bf;
import com.iqoption.x.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\f\u0018\u0000 32\u00020\u0001:\u000223B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\r\u001a\u00020\u000eH\u0002J(\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00102\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00120\u0014H\u0002J\u001a\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0012H\u0002J\u0014\u0010\u001b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b0\u001cJ\u0006\u0010\u001d\u001a\u00020\u001eJ0\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00102\u0006\u0010 \u001a\u00020\u00112\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00120\u0014H\u0002J5\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\b0\u001c2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010(¢\u0006\u0002\u0010)J\u000e\u0010*\u001a\u00020&2\u0006\u0010 \u001a\u00020\u0011J\u0016\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020(2\u0006\u0010,\u001a\u00020\u0012J$\u0010-\u001a\u00020\u00182\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00102\u0006\u0010/\u001a\u00020\u000eH\u0002J\u0010\u00100\u001a\u00020\u00152\u0006\u00101\u001a\u00020\u000bH\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u00064"}, aXE = {"Lcom/iqoption/vip/VipManagerViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "calendar", "Ljava/util/Calendar;", "kotlin.jvm.PlatformType", "vipManagerLiveData", "Landroid/arch/lifecycle/MutableLiveData;", "Lcom/iqoption/util/Resource;", "Lcom/iqoption/microservice/vip/VipManager;", "calculateDayDiff", "", "weekDay", "canOrderCallback", "", "chooseFirstWorkingDate", "Lkotlin/Pair;", "Ljava/util/Date;", "Lcom/iqoption/vip/WorkingPeriod;", "managerWorkPeriodUtc", "", "Lcom/iqoption/vip/WeekDay;", "getCallPeriods", "Lkotlin/Triple;", "Lcom/iqoption/vip/VipManagerViewModel$CallPeriod;", "getPreferredStartDate", "period", "getVipManager", "Landroid/arch/lifecycle/LiveData;", "initialize", "", "nextWorkingDate", "date", "requestCall", "Ljava/lang/Void;", "context", "Landroid/content/Context;", "time", "", "traningSession", "", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Long;)Landroid/arch/lifecycle/LiveData;", "requestCallTimeFormat", "selectedDate", "selectedPeriod", "splitPeriod", "periodPair", "choosePreffered", "weekDayByDayOfWeek", "dayOfWeek", "CallPeriod", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: VipManagerViewModel.kt */
public final class VipManagerViewModel extends ViewModel {
    public static final b dLy = new b();
    private final Calendar calendar = Calendar.getInstance();
    private final MutableLiveData<ba<com.iqoption.microservice.vip.d>> dLx = new MutableLiveData();

    @i(aXC = {1, 1, 11}, aXD = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, aXE = {"Lcom/iqoption/vip/VipManagerViewModel$CallPeriod;", "", "date", "Ljava/util/Date;", "titleDate", "", "periods", "", "Lcom/iqoption/vip/WorkingPeriod;", "(Ljava/util/Date;Ljava/lang/String;Ljava/util/List;)V", "getDate", "()Ljava/util/Date;", "getPeriods", "()Ljava/util/List;", "getTitleDate", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: VipManagerViewModel.kt */
    public static final class a {
        private final List<j> dKO;
        private final String dLz;
        private final Date date;

        /* JADX WARNING: Missing block: B:8:0x0024, code:
            if (kotlin.jvm.internal.h.E(r2.dKO, r3.dKO) != false) goto L_0x0029;
     */
        public boolean equals(java.lang.Object r3) {
            /*
            r2 = this;
            if (r2 == r3) goto L_0x0029;
        L_0x0002:
            r0 = r3 instanceof com.iqoption.vip.VipManagerViewModel.a;
            if (r0 == 0) goto L_0x0027;
        L_0x0006:
            r3 = (com.iqoption.vip.VipManagerViewModel.a) r3;
            r0 = r2.date;
            r1 = r3.date;
            r0 = kotlin.jvm.internal.h.E(r0, r1);
            if (r0 == 0) goto L_0x0027;
        L_0x0012:
            r0 = r2.dLz;
            r1 = r3.dLz;
            r0 = kotlin.jvm.internal.h.E(r0, r1);
            if (r0 == 0) goto L_0x0027;
        L_0x001c:
            r0 = r2.dKO;
            r3 = r3.dKO;
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
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.vip.VipManagerViewModel.a.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            Date date = this.date;
            int i = 0;
            int hashCode = (date != null ? date.hashCode() : 0) * 31;
            String str = this.dLz;
            hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
            List list = this.dKO;
            if (list != null) {
                i = list.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("CallPeriod(date=");
            stringBuilder.append(this.date);
            stringBuilder.append(", titleDate=");
            stringBuilder.append(this.dLz);
            stringBuilder.append(", periods=");
            stringBuilder.append(this.dKO);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public a(Date date, String str, List<j> list) {
            h.e(date, "date");
            h.e(str, "titleDate");
            h.e(list, "periods");
            this.date = date;
            this.dLz = str;
            this.dKO = list;
        }

        public final String aKy() {
            return this.dLz;
        }

        public final List<j> aKz() {
            return this.dKO;
        }

        public final Date getDate() {
            return this.date;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, aXE = {"Lcom/iqoption/vip/VipManagerViewModel$Companion;", "", "()V", "get", "Lcom/iqoption/vip/VipManagerViewModel;", "activity", "Landroid/support/v4/app/FragmentActivity;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: VipManagerViewModel.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(f fVar) {
            this();
        }

        public final VipManagerViewModel J(FragmentActivity fragmentActivity) {
            h.e(fragmentActivity, "activity");
            ViewModel h = ViewModelProviders.b(fragmentActivity).h(VipManagerViewModel.class);
            h.d(h, "ViewModelProviders.of(ac…gerViewModel::class.java)");
            return (VipManagerViewModel) h;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, aXE = {"com/iqoption/vip/VipManagerViewModel$initialize$1", "Lcom/google/common/util/concurrent/FutureCallback;", "Lcom/iqoption/microservice/vip/VipManagerResponse;", "onFailure", "", "t", "", "onSuccess", "result", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: VipManagerViewModel.kt */
    public static final class c implements n<f> {
        final /* synthetic */ VipManagerViewModel dLA;

        c(VipManagerViewModel vipManagerViewModel) {
            this.dLA = vipManagerViewModel;
        }

        /* renamed from: a */
        public void onSuccess(f fVar) {
            if (fVar == null) {
                return;
            }
            if (!fVar.Pg() || fVar.ats() == null) {
                this.dLA.dLx.postValue(com.iqoption.util.ba.a.a(ba.dww, null, null, null, 7, null));
                return;
            }
            this.dLA.dLx.postValue(ba.dww.bK(fVar.ats()));
            com.iqoption.fragment.leftmenu.h.alI().dl(true);
        }

        public void l(Throwable th) {
            this.dLA.dLx.postValue(com.iqoption.util.ba.a.a(ba.dww, null, null, null, 7, null));
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, aXE = {"com/iqoption/vip/VipManagerViewModel$requestCall$1", "Lcom/google/common/util/concurrent/FutureCallback;", "Lcom/iqoption/microservice/vip/BasicResponse;", "onFailure", "", "t", "", "onSuccess", "result", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: VipManagerViewModel.kt */
    public static final class d implements n<com.iqoption.microservice.vip.a> {
        final /* synthetic */ MutableLiveData bWl;

        d(MutableLiveData mutableLiveData) {
            this.bWl = mutableLiveData;
        }

        /* renamed from: a */
        public void onSuccess(com.iqoption.microservice.vip.a aVar) {
            if (aVar == null || !aVar.Pg()) {
                this.bWl.postValue(com.iqoption.util.ba.a.a(ba.dww, null, null, null, 7, null));
            } else {
                this.bWl.postValue(com.iqoption.util.ba.a.a(ba.dww, null, 1, null));
            }
        }

        public void l(Throwable th) {
            this.bWl.postValue(com.iqoption.util.ba.a.a(ba.dww, null, null, null, 7, null));
        }
    }

    private final int hr(int i) {
        switch (i) {
            case 6:
                return 3;
            case 7:
                return 2;
            default:
                return 1;
        }
    }

    public final void initialize() {
        if (com.iqoption.app.managers.feature.a.eW("vip-manager")) {
            ag.b(e.cTk.atr(), new c(this));
        }
    }

    public final LiveData<ba<com.iqoption.microservice.vip.d>> aKv() {
        return this.dLx;
    }

    public final Triple<a, a, a> aKw() {
        ba baVar = (ba) this.dLx.getValue();
        if (baVar != null) {
            com.iqoption.microservice.vip.d dVar = (com.iqoption.microservice.vip.d) baVar.getData();
            if (dVar == null || dVar.atq().isEmpty()) {
                return null;
            }
            Pair F = F(dVar.atq());
            Calendar calendar = this.calendar;
            h.d(calendar, "calendar");
            calendar.setTime((Date) F.getFirst());
            this.calendar.add(5, 1);
            calendar = this.calendar;
            h.d(calendar, "calendar");
            Date time = calendar.getTime();
            h.d(time, "calendar.time");
            Pair a = a(time, dVar.atq());
            Calendar calendar2 = this.calendar;
            h.d(calendar2, "calendar");
            calendar2.setTime((Date) a.getFirst());
            this.calendar.add(5, 1);
            Calendar calendar3 = this.calendar;
            h.d(calendar3, "calendar");
            Date time2 = calendar3.getTime();
            h.d(time2, "calendar.time");
            return new Triple(a(F, true), a(a, false), a(a(time2, dVar.atq()), false));
        }
        return null;
    }

    private final a a(Pair<? extends Date, j> pair, boolean z) {
        List arrayList = new ArrayList();
        Calendar calendar = this.calendar;
        h.d(calendar, "calendar");
        calendar.setTime((Date) pair.getFirst());
        int i = this.calendar.get(5);
        Calendar calendar2 = this.calendar;
        h.d(calendar2, "calendar");
        calendar2.setTimeInMillis(System.currentTimeMillis());
        int i2 = this.calendar.get(11);
        int i3 = this.calendar.get(12);
        Object obj = i == this.calendar.get(5) ? 1 : null;
        Date b = z ? b((j) pair.aXF()) : ((j) pair.aXF()).getStartDate();
        Date endDate = ((j) pair.aXF()).getEndDate();
        Calendar calendar3 = this.calendar;
        h.d(calendar3, "calendar");
        calendar3.setTime(b);
        while (b.compareTo(endDate) < 0) {
            if ((obj == null || this.calendar.get(11) >= i2) && (this.calendar.get(11) != i2 || this.calendar.get(12) >= i3)) {
                this.calendar.add(12, 15);
                calendar3 = this.calendar;
                h.d(calendar3, "calendar");
                Date time = calendar3.getTime();
                h.d(time, "calendar.time");
                arrayList.add(new j(b, time));
                b = time;
            } else {
                this.calendar.add(12, 15);
                Calendar calendar4 = this.calendar;
                h.d(calendar4, "calendar");
                b = calendar4.getTime();
                h.d(b, "calendar.time");
            }
        }
        String format = arrayList.isEmpty() ? "" : bf.cgq.format((Date) pair.getFirst());
        Date date = (Date) pair.getFirst();
        h.d(format, "titleDate");
        return new a(date, format, arrayList);
    }

    private final Date b(j jVar) {
        Calendar calendar = this.calendar;
        h.d(calendar, "calendar");
        calendar.setTimeInMillis(System.currentTimeMillis());
        int i = this.calendar.get(11);
        int i2 = this.calendar.get(12);
        Calendar calendar2 = this.calendar;
        h.d(calendar2, "calendar");
        calendar2.setTime(jVar.getStartDate());
        if (i < this.calendar.get(11)) {
            return jVar.getStartDate();
        }
        Date startDate = jVar.getStartDate();
        while (i <= this.calendar.get(11) && this.calendar.get(12) <= i2) {
            this.calendar.add(12, 15);
            Calendar calendar3 = this.calendar;
            h.d(calendar3, "calendar");
            startDate = calendar3.getTime();
            h.d(startDate, "calendar.time");
        }
        return startDate;
    }

    private final Pair<Date, j> a(Date date, Map<WeekDay, j> map) {
        int i = this.calendar.get(7);
        j jVar = (j) map.get(hs(i));
        if (jVar == null) {
            return new Pair(new Date(), new j(new Date(), new Date()));
        }
        if (i != 7 && i != 1) {
            return new Pair(date, jVar);
        }
        Calendar calendar = this.calendar;
        h.d(calendar, "calendar");
        calendar.setTime(date);
        this.calendar.add(5, hr(i));
        Calendar calendar2 = this.calendar;
        h.d(calendar2, "calendar");
        return new Pair(calendar2.getTime(), jVar);
    }

    private final Pair<Date, j> F(Map<WeekDay, j> map) {
        Calendar calendar = this.calendar;
        h.d(calendar, "calendar");
        calendar.setTimeInMillis(System.currentTimeMillis());
        int i = this.calendar.get(7);
        int i2 = this.calendar.get(11);
        j jVar = (j) map.get(hs(i));
        if (jVar == null) {
            return new Pair(new Date(), new j(new Date(), new Date()));
        }
        Calendar calendar2 = this.calendar;
        h.d(calendar2, "calendar");
        calendar2.setTime(jVar.getEndDate());
        if (i2 < this.calendar.get(11)) {
            return new Pair(new Date(), jVar);
        }
        j jVar2 = (j) map.get(hs(i + 1));
        if (jVar2 == null) {
            return new Pair(new Date(), new j(new Date(), new Date()));
        }
        Calendar calendar3 = this.calendar;
        h.d(calendar3, "calendar");
        calendar3.setTimeInMillis(System.currentTimeMillis());
        this.calendar.add(5, hr(i));
        calendar3 = this.calendar;
        h.d(calendar3, "calendar");
        return new Pair(calendar3.getTime(), jVar2);
    }

    private final WeekDay hs(int i) {
        switch (i) {
            case 3:
                return WeekDay.TUE;
            case 4:
                return WeekDay.WED;
            case 5:
                return WeekDay.THU;
            case 6:
                return WeekDay.FRI;
            default:
                return WeekDay.MON;
        }
    }

    public final LiveData<ba<Void>> a(Context context, String str, Long l) {
        MutableLiveData mutableLiveData = new MutableLiveData();
        if (aKx()) {
            ag.b(e.cTk.c(str, l), new d(mutableLiveData));
        } else {
            mutableLiveData.postValue(com.iqoption.util.ba.a.a(ba.dww, null, context != null ? context.getString(R.string.this_option_is_not_available_yet) : null, null, 5, null));
        }
        return mutableLiveData;
    }

    private final boolean aKx() {
        ba baVar = (ba) this.dLx.getValue();
        com.iqoption.microservice.vip.d dVar = baVar != null ? (com.iqoption.microservice.vip.d) baVar.getData() : null;
        return dVar == null || dVar.ate();
    }

    public final String e(long j, j jVar) {
        h.e(jVar, "selectedPeriod");
        Calendar instance = Calendar.getInstance();
        h.d(instance, "calendar");
        instance.setTime(jVar.getStartDate());
        int i = instance.get(11);
        int i2 = instance.get(12);
        instance.setTimeInMillis(j);
        instance.set(11, i);
        instance.set(12, i2);
        Date time = instance.getTime();
        h.d(time, "calendar.time");
        return h(time);
    }

    public final String h(Date date) {
        h.e(date, "date");
        TimeZone timeZone = TimeZone.getTimeZone("UTC");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        simpleDateFormat.setTimeZone(timeZone);
        String format = simpleDateFormat.format(date);
        h.d(format, "df.format(date)");
        return format;
    }
}
