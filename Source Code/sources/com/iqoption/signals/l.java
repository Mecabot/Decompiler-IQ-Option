package com.iqoption.signals;

import android.support.annotation.StringRes;
import com.google.common.collect.ImmutableList;
import com.iqoption.app.IQApp;
import com.iqoption.core.ext.c;
import com.iqoption.x.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.NoWhenBranchMatchedException;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u001d\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0005\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u0005HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00052\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u000e\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0006J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001f"}, aXE = {"Lcom/iqoption/signals/SignalsViewState;", "", "filter", "Lcom/iqoption/signals/SignalFilter;", "signals", "", "Lcom/iqoption/core/microservices/pricemovements/response/Signal;", "(Lcom/iqoption/signals/SignalFilter;Ljava/util/List;)V", "items", "Lcom/iqoption/signals/AdapterItem;", "(Lcom/iqoption/signals/SignalFilter;Ljava/util/List;Ljava/util/List;)V", "getFilter", "()Lcom/iqoption/signals/SignalFilter;", "getItems", "()Ljava/util/List;", "getSignals", "component1", "component2", "component3", "copy", "equals", "", "other", "f", "hashCode", "", "merge", "newSignal", "toString", "", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: SignalsViewState.kt */
public final class l {
    private static final SimpleDateFormat aDM = new SimpleDateFormat("HH:mm", Locale.US);
    private static final SimpleDateFormat aEF = new SimpleDateFormat("d MMM yyyy", Locale.US);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("d MMM", Locale.US);
    private static final l drK = new l(SignalFilter.ALL, l.cr(b.drb), m.emptyList());
    public static final a drL = new a();
    private final SignalFilter drH;
    private final List<com.iqoption.core.microservices.pricemovements.a.a> drI;
    private final List<a> nj;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\fJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u0018H\u0002J(\u0010 \u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u0018H\u0002J3\u0010#\u001a\n $*\u0004\u0018\u00010\u00160\u00162\b\b\u0001\u0010%\u001a\u00020&2\u0012\u0010'\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010(\"\u00020\u0001H\u0002¢\u0006\u0002\u0010)R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, aXE = {"Lcom/iqoption/signals/SignalsViewState$Companion;", "", "()V", "EMPTY", "Lcom/iqoption/signals/SignalsViewState;", "getEMPTY", "()Lcom/iqoption/signals/SignalsViewState;", "dateFormat", "Ljava/text/SimpleDateFormat;", "dateYearFormat", "timeFormat", "convertSignals", "", "Lcom/iqoption/signals/AdapterItem;", "signals", "Lcom/iqoption/core/microservices/pricemovements/response/Signal;", "convertToSignalItem", "Lcom/iqoption/signals/SignalItem;", "signal", "active", "Lcom/iqoption/core/microservices/tradingengine/response/active/Active;", "formatDuration", "", "seconds", "", "formatPercent", "percent", "", "isPositive", "", "formatTitle", "time", "formatValue", "startTime", "finishTime", "getString", "kotlin.jvm.PlatformType", "resId", "", "args", "", "(I[Ljava/lang/Object;)Ljava/lang/String;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: SignalsViewState.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final l aEm() {
            return l.drK;
        }

        public final List<a> bl(List<com.iqoption.core.microservices.pricemovements.a.a> list) {
            h.e(list, "signals");
            List<a> arrayList = new ArrayList();
            com.iqoption.core.microservices.pricemovements.a.a aVar = (com.iqoption.core.microservices.pricemovements.a.a) null;
            com.iqoption.app.helpers.a FI = com.iqoption.app.helpers.a.FI();
            h.d(FI, "ActiveSettingHelper.instance()");
            ImmutableList FO = FI.FO();
            for (com.iqoption.core.microservices.pricemovements.a.a aVar2 : list) {
                h.d(FO, "actives");
                for (Object next : FO) {
                    Object obj;
                    if (((com.iqoption.core.microservices.tradingengine.response.active.a) next).getActiveId() == aVar2.getActiveId()) {
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
                com.iqoption.core.microservices.tradingengine.response.active.a aVar3 = (com.iqoption.core.microservices.tradingengine.response.active.a) next2;
                if (aVar3 != null) {
                    if (aVar == null || !c.l(aVar.getCreateTime(), aVar2.getCreateTime())) {
                        arrayList.add(new f(bX(aVar2.getCreateTime())));
                    }
                    arrayList.add(a(aVar2, aVar3));
                    aVar = aVar2;
                }
            }
            return arrayList;
        }

        public final c a(com.iqoption.core.microservices.pricemovements.a.a aVar, com.iqoption.core.microservices.tradingengine.response.active.a aVar2) {
            com.iqoption.core.microservices.pricemovements.a.a aVar3 = aVar;
            h.e(aVar3, "signal");
            com.iqoption.core.microservices.tradingengine.response.active.a aVar4 = aVar2;
            h.e(aVar4, "active");
            int i = 1;
            boolean z = aVar.Wx() - aVar.Ww() > ((double) null);
            String format = l.aDM.format(Long.valueOf(aVar.getCreateTime()));
            h.d(format, "timeFormat.format(signal.createTime)");
            String s = com.iqoption.util.e.a.s(aVar2);
            if (s == null) {
                s = getString(R.string.n_a, new Object[0]);
                h.d(s, "getString(R.string.n_a)");
            }
            String str = s;
            switch (aVar.getType()) {
                case 1:
                    s = getString(R.string.sharp_jump_drop, new Object[0]);
                    break;
                case 2:
                    s = getString(R.string.gap, new Object[0]);
                    break;
                default:
                    s = "";
                    break;
            }
            String str2 = s;
            h.d(str2, "when (signal.type) {\n   … \"\"\n                    }");
            String a = a(aVar.Wy(), z, aVar.getStartTime(), aVar.Wv());
            if (aVar.Wz()) {
                i = 2;
            }
            return new c(z, format, str, str2, a, i, aVar4, aVar3);
        }

        private final String getString(@StringRes int i, Object... objArr) {
            return IQApp.Dk().getString(i, Arrays.copyOf(objArr, objArr.length));
        }

        private final String bX(long j) {
            String string;
            if (c.aQ(j)) {
                string = getString(R.string.today, new Object[0]);
                h.d(string, "getString(R.string.today)");
                return string;
            } else if (c.aK(j)) {
                string = getString(R.string.yesterday, new Object[0]);
                h.d(string, "getString(R.string.yesterday)");
                return string;
            } else if (c.aL(j)) {
                string = l.dateFormat.format(Long.valueOf(j));
                h.d(string, "dateFormat.format(time)");
                return string;
            } else {
                string = l.aEF.format(Long.valueOf(j));
                h.d(string, "dateYearFormat.format(time)");
                return string;
            }
        }

        private final String a(double d, boolean z, long j, long j2) {
            String string = getString(R.string.n1_in_n2, r0.a(d, z), bY(j2 - j));
            h.d(string, "getString(R.string.n1_in…(finishTime - startTime))");
            return string;
        }

        private final String a(double d, boolean z) {
            StringBuilder stringBuilder;
            if (z) {
                stringBuilder = new StringBuilder();
                stringBuilder.append('+');
                stringBuilder.append(c.b(d, 2));
                stringBuilder.append('%');
                return stringBuilder.toString();
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append('-');
            stringBuilder.append(c.b(d, 2));
            stringBuilder.append('%');
            return stringBuilder.toString();
        }

        private final String bY(long j) {
            long j2 = (long) 60;
            StringBuilder stringBuilder;
            if (j < j2) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(j);
                stringBuilder.append(" s");
                return stringBuilder.toString();
            }
            j /= j2;
            if (j < j2) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(j);
                stringBuilder.append(" m");
                return stringBuilder.toString();
            }
            j /= j2;
            j2 = (long) 24;
            if (j < j2) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(j);
                stringBuilder.append(" h");
                return stringBuilder.toString();
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(j / j2);
            stringBuilder2.append(" d");
            return stringBuilder2.toString();
        }
    }

    public static /* bridge */ /* synthetic */ l a(l lVar, SignalFilter signalFilter, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            signalFilter = lVar.drH;
        }
        if ((i & 2) != 0) {
            list = lVar.nj;
        }
        if ((i & 4) != 0) {
            list2 = lVar.drI;
        }
        return lVar.a(signalFilter, list, list2);
    }

    public final l a(SignalFilter signalFilter, List<? extends a> list, List<com.iqoption.core.microservices.pricemovements.a.a> list2) {
        h.e(signalFilter, "filter");
        h.e(list, "items");
        h.e(list2, "signals");
        return new l(signalFilter, list, list2);
    }

    /* JADX WARNING: Missing block: B:8:0x0024, code:
            if (kotlin.jvm.internal.h.E(r2.drI, r3.drI) != false) goto L_0x0029;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x0029;
    L_0x0002:
        r0 = r3 instanceof com.iqoption.signals.l;
        if (r0 == 0) goto L_0x0027;
    L_0x0006:
        r3 = (com.iqoption.signals.l) r3;
        r0 = r2.drH;
        r1 = r3.drH;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0027;
    L_0x0012:
        r0 = r2.nj;
        r1 = r3.nj;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0027;
    L_0x001c:
        r0 = r2.drI;
        r3 = r3.drI;
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
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.signals.l.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        SignalFilter signalFilter = this.drH;
        int i = 0;
        int hashCode = (signalFilter != null ? signalFilter.hashCode() : 0) * 31;
        List list = this.nj;
        hashCode = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        list = this.drI;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SignalsViewState(filter=");
        stringBuilder.append(this.drH);
        stringBuilder.append(", items=");
        stringBuilder.append(this.nj);
        stringBuilder.append(", signals=");
        stringBuilder.append(this.drI);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public l(SignalFilter signalFilter, List<? extends a> list, List<com.iqoption.core.microservices.pricemovements.a.a> list2) {
        h.e(signalFilter, "filter");
        h.e(list, "items");
        h.e(list2, "signals");
        this.drH = signalFilter;
        this.nj = list;
        this.drI = list2;
    }

    public final SignalFilter aEg() {
        return this.drH;
    }

    public final List<a> getItems() {
        return this.nj;
    }

    public l(SignalFilter signalFilter, List<com.iqoption.core.microservices.pricemovements.a.a> list) {
        h.e(signalFilter, "filter");
        h.e(list, "signals");
        this(signalFilter, drL.bl(list), list);
    }

    public final l c(SignalFilter signalFilter) {
        h.e(signalFilter, "f");
        return new l(signalFilter, l.cr(b.drb), m.emptyList());
    }

    public final l b(com.iqoption.core.microservices.pricemovements.a.a aVar) {
        int i;
        h.e(aVar, "newSignal");
        switch (this.drH) {
            case ALL:
                i = 0;
                break;
            case GAP:
                i = 2;
                break;
            case SHARP_JUMP:
                i = 1;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        if (i != 0 && aVar.getType() != i) {
            return this;
        }
        List arrayList = new ArrayList();
        arrayList.add(aVar);
        arrayList.addAll(this.drI);
        return a(this, null, drL.bl(arrayList), arrayList, 1, null);
    }
}
