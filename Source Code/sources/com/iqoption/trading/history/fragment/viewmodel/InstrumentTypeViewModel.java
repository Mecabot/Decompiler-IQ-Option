package com.iqoption.trading.history.fragment.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.StringRes;
import android.support.v4.app.FragmentActivity;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.x.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00192\u00020\u0001:\u0002\u0019\u001aB\u0005¢\u0006\u0002\u0010\u0002JF\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\rH\u0002J\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0005R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, aXE = {"Lcom/iqoption/trading/history/fragment/viewmodel/InstrumentTypeViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "items", "", "Lcom/iqoption/trading/history/fragment/viewmodel/InstrumentTypeViewModel$Item;", "getItems", "()Ljava/util/List;", "selected", "Landroid/arch/lifecycle/MutableLiveData;", "generateAllIntrumentArray", "Lcom/iqoption/core/data/model/InstrumentType;", "fakeDigital", "", "isBinaryEnabled", "isDigitalEnabled", "isFxEnabled", "isCFDEnabled", "isCryptoEnabled", "isForexEnabled", "getSelected", "Landroid/arch/lifecycle/LiveData;", "select", "", "item", "Companion", "Item", "IqOption-5.5.1_optionXRelease"})
/* compiled from: InstrumentTypeViewModel.kt */
public final class InstrumentTypeViewModel extends ViewModel {
    private static final String TAG = "InstrumentTypeViewModel";
    public static final a dtR = new a();
    private final MutableLiveData<b> dtQ = new MutableLiveData();
    private final List<b> nj;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, aXE = {"Lcom/iqoption/trading/history/fragment/viewmodel/InstrumentTypeViewModel$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "get", "Lcom/iqoption/trading/history/fragment/viewmodel/InstrumentTypeViewModel;", "a", "Landroid/support/v4/app/FragmentActivity;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: InstrumentTypeViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final InstrumentTypeViewModel C(FragmentActivity fragmentActivity) {
            h.e(fragmentActivity, com.iqoption.fragment.cashbox.deppage.a.TAG);
            return (InstrumentTypeViewModel) ViewModelProviders.b(fragmentActivity).h(InstrumentTypeViewModel.class);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, aXE = {"Lcom/iqoption/trading/history/fragment/viewmodel/InstrumentTypeViewModel$Item;", "", "textResId", "", "instrumentTypes", "", "Lcom/iqoption/core/data/model/InstrumentType;", "(ILjava/util/List;)V", "getInstrumentTypes", "()Ljava/util/List;", "getTextResId", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: InstrumentTypeViewModel.kt */
    public static final class b {
        private final List<InstrumentType> aqi;
        private final int dtK;

        public b() {
            this(0, null, 3, null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                b bVar = (b) obj;
                return (this.dtK == bVar.dtK ? 1 : null) != null && h.E(this.aqi, bVar.aqi);
            }
        }

        public int hashCode() {
            int i = this.dtK * 31;
            List list = this.aqi;
            return i + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Item(textResId=");
            stringBuilder.append(this.dtK);
            stringBuilder.append(", instrumentTypes=");
            stringBuilder.append(this.aqi);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public b(@StringRes int i, List<? extends InstrumentType> list) {
            h.e(list, "instrumentTypes");
            this.dtK = i;
            this.aqi = list;
        }

        public /* synthetic */ b(int i, List list, int i2, f fVar) {
            if ((i2 & 1) != 0) {
                i = -1;
            }
            if ((i2 & 2) != 0) {
                list = m.emptyList();
            }
            this(i, list);
        }

        public final List<InstrumentType> Jk() {
            return this.aqi;
        }

        public final int aFh() {
            return this.dtK;
        }
    }

    public static final InstrumentTypeViewModel C(FragmentActivity fragmentActivity) {
        return dtR.C(fragmentActivity);
    }

    public InstrumentTypeViewModel() {
        List arrayList = new ArrayList();
        boolean HG = com.iqoption.app.managers.feature.a.HG();
        boolean HJ = com.iqoption.app.managers.feature.a.HJ();
        boolean HH = com.iqoption.app.managers.feature.a.HH();
        boolean HI = com.iqoption.app.managers.feature.a.HI();
        boolean HK = com.iqoption.app.managers.feature.a.HK();
        boolean HM = com.iqoption.app.managers.feature.a.HM();
        boolean HL = com.iqoption.app.managers.feature.a.HL();
        if (HJ) {
            arrayList.add(new b(com.iqoption.util.e.a.P(InstrumentType.TURBO_INSTRUMENT), m.listOf(InstrumentType.TURBO_INSTRUMENT, InstrumentType.BINARY_INSTRUMENT)));
        }
        if (HH) {
            List listOf;
            int P = com.iqoption.util.e.a.P(InstrumentType.DIGITAL_INSTRUMENT);
            if (HG) {
                listOf = m.listOf(InstrumentType.DIGITAL_INSTRUMENT, InstrumentType.TURBO_INSTRUMENT, InstrumentType.BINARY_INSTRUMENT);
            } else {
                listOf = l.cr(InstrumentType.DIGITAL_INSTRUMENT);
            }
            arrayList.add(new b(P, listOf));
        }
        if (HI) {
            arrayList.add(new b(com.iqoption.util.e.a.P(InstrumentType.FX_INSTRUMENT), l.cr(InstrumentType.FX_INSTRUMENT)));
        }
        if (HK) {
            arrayList.add(new b(com.iqoption.util.e.a.P(InstrumentType.CFD_INSTRUMENT), l.cr(InstrumentType.CFD_INSTRUMENT)));
        }
        if (HM) {
            arrayList.add(new b(com.iqoption.util.e.a.P(InstrumentType.CRYPTO_INSTRUMENT), l.cr(InstrumentType.CRYPTO_INSTRUMENT)));
        }
        if (HL) {
            arrayList.add(new b(com.iqoption.util.e.a.P(InstrumentType.FOREX_INSTRUMENT), l.cr(InstrumentType.FOREX_INSTRUMENT)));
        }
        b bVar = new b(R.string.all_instruments, a(HG, HJ, HH, HI, HK, HM, HL));
        arrayList.add(bVar);
        this.nj = u.W(arrayList);
        c(bVar);
    }

    public final void c(b bVar) {
        h.e(bVar, "item");
        this.dtQ.postValue(bVar);
    }

    public final LiveData<b> aFg() {
        return this.dtQ;
    }

    public final List<b> getItems() {
        return this.nj;
    }

    private final List<InstrumentType> a(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        List arrayList = new ArrayList();
        if (z2) {
            arrayList.add(InstrumentType.TURBO_INSTRUMENT);
            arrayList.add(InstrumentType.BINARY_INSTRUMENT);
        }
        if (z3) {
            arrayList.add(InstrumentType.DIGITAL_INSTRUMENT);
            if (z && !z2) {
                arrayList.add(InstrumentType.TURBO_INSTRUMENT);
                arrayList.add(InstrumentType.BINARY_INSTRUMENT);
            }
        }
        if (z4) {
            arrayList.add(InstrumentType.FX_INSTRUMENT);
        }
        if (z5) {
            arrayList.add(InstrumentType.CFD_INSTRUMENT);
        }
        if (z6) {
            arrayList.add(InstrumentType.CRYPTO_INSTRUMENT);
        }
        if (z7) {
            arrayList.add(InstrumentType.FOREX_INSTRUMENT);
        }
        return u.W(arrayList);
    }
}
