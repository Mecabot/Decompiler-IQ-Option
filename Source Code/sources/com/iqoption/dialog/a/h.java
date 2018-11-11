package com.iqoption.dialog.a;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout.LayoutParams;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.TextView;
import com.google.common.base.Predicates;
import com.google.common.base.n;
import com.google.common.collect.ImmutableList;
import com.google.gson.reflect.TypeToken;
import com.iqoption.analytics.k;
import com.iqoption.app.managers.af;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.ext.c;
import com.iqoption.d.hn;
import com.iqoption.dialog.a.a.d;
import com.iqoption.dto.ChartTimeInterval;
import com.iqoption.dto.Point;
import com.iqoption.dto.entity.position.Position;
import com.iqoption.fragment.base.i;
import com.iqoption.mobbtech.connect.response.options.e;
import com.iqoption.system.c.b;
import com.iqoption.util.ag;
import com.iqoption.util.g;
import com.iqoption.util.l;
import com.iqoption.x.R;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: ClosedDealsDialog */
public final class h extends i {
    private z cgA;
    private hn cgB;
    private d cgC;
    private int cgD;
    private int cgE;
    private boolean cgF;
    private boolean cgG;
    private InstrumentType instrumentType;

    /* compiled from: ClosedDealsDialog */
    private static final class a extends b<h, List<? extends e>> {
        a(h hVar) {
            super((Object) hVar);
        }

        /* renamed from: a */
        public void z(@NonNull h hVar, @NonNull List<? extends e> list) {
            com.iqoption.core.d.a.aSe.execute(new x(hVar, list));
        }

        /* renamed from: b */
        public void c(@NonNull h hVar, Throwable th) {
            com.iqoption.core.i.w("ClosedDealsDialog", th.getMessage(), th);
            com.iqoption.core.d.a.aSe.execute(new y(hVar));
        }

        static final /* synthetic */ void b(@NonNull h hVar) {
            if (hVar.isAdded()) {
                hVar.onClose();
            }
        }
    }

    public String gF() {
        return "closed-positions_open-closed-deal";
    }

    public static void a(FragmentManager fragmentManager, InstrumentType instrumentType, long[] jArr) {
        a(fragmentManager, (int) R.id.other_fragment, new i(instrumentType, jArr));
    }

    public static void a(FragmentManager fragmentManager, InstrumentType instrumentType, String str) {
        a(fragmentManager, (int) R.id.other_fragment, new j(instrumentType, str));
    }

    public static void a(FragmentManager fragmentManager, InstrumentType instrumentType, ArrayList<? extends e> arrayList) {
        a(fragmentManager, (int) R.id.other_fragment, new p(instrumentType, arrayList));
    }

    private static void a(FragmentManager fragmentManager, @IdRes int i, n<h> nVar) {
        if (fragmentManager.findFragmentByTag("ClosedDealsDialog") == null) {
            fragmentManager.beginTransaction().add(i, (Fragment) nVar.get(), "ClosedDealsDialog").setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).addToBackStack("ClosedDealsDialog").commitAllowingStateLoss();
        }
    }

    public static h a(InstrumentType instrumentType, long[] jArr) {
        return V(new g().a("arg.instrumentType", (Serializable) instrumentType).a("arg.ids", jArr).toBundle());
    }

    public static h c(InstrumentType instrumentType, String str) {
        return V(new g().a("arg.instrumentType", (Serializable) instrumentType).aA("arg.json", str).toBundle());
    }

    public static h a(InstrumentType instrumentType, ArrayList<? extends e> arrayList) {
        return V(new g().a("arg.instrumentType", (Serializable) instrumentType).a("arg.options", (ArrayList) arrayList).toBundle());
    }

    private static h V(Bundle bundle) {
        h hVar = new h();
        hVar.setArguments(bundle);
        return hVar;
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cgB = hn.n(layoutInflater, viewGroup, false);
        return this.cgB.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.cgD = ef(R.dimen.dp48);
        aeH();
        Bundle arguments = getArguments();
        this.instrumentType = (InstrumentType) arguments.getSerializable("arg.instrumentType");
        if (this.instrumentType == null) {
            com.iqoption.core.i.w("ClosedDealsDialog", "instrumentType must not be null");
            return;
        }
        Object parcelableArrayList = arguments.getParcelableArrayList("arg.options");
        if (com.iqoption.util.i.H(parcelableArrayList)) {
            String string = arguments.getString("arg.json");
            StringBuilder stringBuilder;
            if (string != null) {
                if (!string.isEmpty()) {
                    switch (this.instrumentType) {
                        case TURBO_INSTRUMENT:
                        case BINARY_INSTRUMENT:
                            hn(string);
                            break;
                        case DIGITAL_INSTRUMENT:
                        case CFD_INSTRUMENT:
                        case FOREX_INSTRUMENT:
                        case CRYPTO_INSTRUMENT:
                        case FX_INSTRUMENT:
                            ho(string);
                            break;
                        default:
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("Unknown instrumentType: ");
                            stringBuilder.append(this.instrumentType);
                            com.iqoption.core.i.w("ClosedDealsDialog", stringBuilder.toString());
                            onClose();
                            break;
                    }
                }
                com.iqoption.core.i.w("ClosedDealsDialog", "json must not be empty");
                onClose();
                return;
            }
            long[] longArray = arguments.getLongArray("arg.ids");
            if (longArray != null) {
                if (longArray.length != 0) {
                    switch (this.instrumentType) {
                        case TURBO_INSTRUMENT:
                        case BINARY_INSTRUMENT:
                            d(longArray);
                            break;
                        case DIGITAL_INSTRUMENT:
                        case CFD_INSTRUMENT:
                        case FOREX_INSTRUMENT:
                        case CRYPTO_INSTRUMENT:
                        case FX_INSTRUMENT:
                            a(longArray, this.instrumentType);
                            break;
                        default:
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("Unknown instrumentType: ");
                            stringBuilder.append(this.instrumentType);
                            com.iqoption.core.i.w("ClosedDealsDialog", stringBuilder.toString());
                            onClose();
                            break;
                    }
                }
                com.iqoption.core.i.w("ClosedDealsDialog", "ids must not be empty");
                onClose();
            } else {
                com.iqoption.core.i.w("ClosedDealsDialog", "there is no any input data found");
                onClose();
            }
            return;
        }
        at(parcelableArrayList);
    }

    protected void aeG() {
        super.aeG();
        if (isAdded()) {
            this.cgF = true;
            if (this.cgC != null && this.cgG) {
                this.cgC.show();
            }
        }
    }

    private void aeH() {
        this.cgB.blw.setOnClickListener(new q(this));
        this.cgB.brd.addOnOffsetChangedListener(new r(this));
    }

    final /* synthetic */ void ad(View view) {
        aN();
        k.a(this.instrumentType);
    }

    void as(List<? extends e> list) {
        String c;
        double d = 0.0d;
        double d2 = d;
        for (e eVar : list) {
            d += eVar.getSellPnl();
            d2 += eVar.getWinAmount();
        }
        String CD = com.iqoption.app.a.Cw().CD();
        if (d2 < 0.0d) {
            c = l.c(CD, Double.valueOf(d2));
        } else {
            c = l.e(CD, Double.valueOf(d2));
        }
        this.cgB.agA.setText(getString(R.string.trade_result, c));
        TextView textView;
        StringBuilder stringBuilder;
        if (d > 0.0d) {
            textView = this.cgB.brm;
            stringBuilder = new StringBuilder();
            stringBuilder.append(" (+");
            stringBuilder.append(l.e(CD, Double.valueOf(d)));
            stringBuilder.append(")");
            textView.setText(stringBuilder.toString());
            this.cgB.brm.setTextColor(ContextCompat.getColor(getContext(), R.color.green));
        } else if (d < 0.0d) {
            textView = this.cgB.brm;
            stringBuilder = new StringBuilder();
            stringBuilder.append(" (-");
            stringBuilder.append(l.e(CD, Double.valueOf(Math.abs(d))));
            stringBuilder.append(")");
            textView.setText(stringBuilder.toString());
            this.cgB.brm.setTextColor(ContextCompat.getColor(getContext(), R.color.red));
        } else {
            this.cgB.brm.setText(null);
        }
    }

    void j(@Nullable final Runnable runnable) {
        LayoutInflater from = LayoutInflater.from(getContext());
        this.cgB.brj.addView(this.cgA.a(from, this.cgB.brj));
        this.cgB.brk.addView(this.cgA.b(from, this.cgB.brk));
        this.cgC = this.cgA.c(from, this.cgB.brh);
        if (this.cgC != null) {
            this.cgB.brh.addView(this.cgC, 0);
            this.cgE = this.cgC.getPaddingBottom() - this.cgC.getPaddingTop();
        }
        a(this.cgB.brj, this.cgB.brf, this.cgD, 0);
        a(this.cgB.brh, this.cgB.bre, -this.cgD, this.cgE);
        this.cgB.axw.setAdapter(this.cgA.aeF());
        this.cgB.axw.setLayoutManager(new LinearLayoutManager(getContext()));
        this.cgB.axw.addItemDecoration(new com.iqoption.widget.h(ef(R.dimen.dp8)));
        this.cgB.axw.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
            public boolean onPreDraw() {
                h.this.cgB.axw.getViewTreeObserver().removeOnPreDrawListener(this);
                int childCount = h.this.cgB.axw.getChildCount();
                int itemCount = h.this.cgB.axw.getAdapter().getItemCount();
                boolean z = true;
                if (childCount == itemCount) {
                    childCount = h.this.cgB.axw.getHeight();
                    itemCount = h.this.cgB.axw.getPaddingBottom();
                    int bottom = h.this.cgB.axw.getChildAt(h.this.cgB.axw.getChildCount() - 1).getBottom();
                    h hVar = h.this;
                    if (childCount - bottom >= itemCount) {
                        z = false;
                    }
                    hVar.cC(z);
                } else {
                    h hVar2 = h.this;
                    if (childCount >= itemCount) {
                        z = false;
                    }
                    hVar2.cC(z);
                }
                if (runnable != null) {
                    runnable.run();
                }
                return false;
            }
        });
    }

    void k(@NonNull ImmutableList<Point> immutableList) {
        if (this.cgC != null) {
            this.cgA.a(this.cgC, (ImmutableList) immutableList);
            this.cgG = true;
            if (this.cgF) {
                this.cgC.show();
            } else {
                this.cgC.setGraphProgress(0.0f);
                this.cgC.setDecorProgress(0.0f);
            }
        }
    }

    private static void a(View view, View view2, int i, int i2) {
        view.measure(MeasureSpec.makeMeasureSpec(0, Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(0, 0));
        int measuredHeight = view.getMeasuredHeight() - i2;
        if (measuredHeight != view2.getHeight()) {
            view2.getLayoutParams().height = measuredHeight + i;
            view2.requestLayout();
        }
    }

    private void cC(boolean z) {
        for (int i = 0; i < this.cgB.brd.getChildCount(); i++) {
            LayoutParams layoutParams = (LayoutParams) this.cgB.brd.getChildAt(i).getLayoutParams();
            int scrollFlags = layoutParams.getScrollFlags();
            layoutParams.setScrollFlags(z ? scrollFlags | 1 : scrollFlags & -2);
        }
        this.cgB.brd.requestLayout();
    }

    private static z b(Context context, List<? extends e> list) {
        if (list == null) {
            throw new NullPointerException("options is null");
        } else if (list.isEmpty()) {
            throw new IllegalArgumentException("options is empty");
        } else {
            e eVar = (e) list.get(0);
            switch (eVar.getInstrumentType()) {
                case TURBO_INSTRUMENT:
                case BINARY_INSTRUMENT:
                case DIGITAL_INSTRUMENT:
                case FX_INSTRUMENT:
                    return new ab(context, ImmutableList.m(list));
                case CFD_INSTRUMENT:
                case FOREX_INSTRUMENT:
                case CRYPTO_INSTRUMENT:
                    return new b(context, com.google.common.collect.i.c((Iterable) list).b(new aj()).sA());
                default:
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("type: ");
                    stringBuilder.append(eVar.getInstrumentType());
                    stringBuilder.append(" is not supported");
                    throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
    }

    boolean aeI() {
        return c.b(this.instrumentType, InstrumentType.TURBO_INSTRUMENT, InstrumentType.BINARY_INSTRUMENT, InstrumentType.FX_INSTRUMENT, InstrumentType.DIGITAL_INSTRUMENT);
    }

    void at(List<? extends e> list) {
        this.cgA = b(getContext(), (List) list);
        as(list);
        j(new s(this, list));
    }

    final /* synthetic */ void av(List list) {
        if (aeI()) {
            this.cgB.getRoot().post(new o(this, list));
        }
    }

    /* renamed from: au */
    void aw(List<? extends e> list) {
        e eVar = (e) Collections.min(list, t.$instance);
        if (eVar == null) {
            com.iqoption.core.i.d("ClosedDealsDialog", "Cannot load points: positions are absent");
            return;
        }
        this.cgB.bri.show();
        long longValue = eVar.getCreated().longValue();
        long longValue2 = eVar.getExpired().longValue();
        long Hv = af.Hu().Hv() / 1000;
        long j = longValue - ((long) (((double) (longValue2 - longValue)) * 0.1d));
        boolean z = longValue2 <= Hv;
        Hv = z ? longValue2 : Hv - 1;
        ag.a(ag.a(new u(eVar, j, Hv, p(j, Hv), z, longValue2), Predicates.pQ(), com.iqoption.core.d.a.aSd, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 1000, "ClosedDealsDialog"), this, v.cgR, w.cgS, com.iqoption.core.d.a.aSe);
    }

    private int p(long j, long j2) {
        int[] iArr = new int[]{1, 5, 10, 15, 30, 60, ChartTimeInterval.CANDLE_2m, 300, 600, ChartTimeInterval.CANDLE_15m, ChartTimeInterval.CANDLE_30m, ChartTimeInterval.CANDLE_1H, ChartTimeInterval.CANDLE_2H, ChartTimeInterval.CANDLE_4H, ChartTimeInterval.CANDLE_8H, ChartTimeInterval.CANDLE_12H, ChartTimeInterval.CANDLE_1D, ChartTimeInterval.CANDLE_1W, ChartTimeInterval.CANDLE_1M};
        float f = (float) (j2 - j);
        float graphWidth = f / this.cgC.getGraphWidth();
        int i = 0;
        int i2 = 0;
        while (i < iArr.length && ((float) iArr[i]) <= graphWidth) {
            i2 = i;
            i++;
        }
        while (f / ((float) iArr[i2]) > 1000.0f && i2 < iArr.length - 1) {
            i2++;
        }
        return iArr[i2];
    }

    private void hn(String str) {
        c(str, new TypeToken<List<e>>() {
        }.getType());
    }

    private void ho(String str) {
        c(str, new TypeToken<List<Position>>() {
        }.getType());
    }

    private void c(String str, Type type) {
        ag.a(com.iqoption.core.d.a.aSc.c(new k(str, type)), new a(this));
    }

    private void d(long[] jArr) {
        ag.a(new ak(jArr).aeJ(), new a(this));
    }

    private void a(long[] jArr, @NonNull InstrumentType instrumentType) {
        ag.a(new al(jArr, instrumentType).aeJ(), new a(this));
    }
}
