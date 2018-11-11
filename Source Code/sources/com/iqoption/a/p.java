package com.iqoption.a;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.common.base.f;
import com.google.common.collect.ImmutableList;
import com.google.gson.JsonObject;
import com.iqoption.analytics.EventManager;
import com.iqoption.app.IQApp;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.util.i;
import com.iqoption.d.agu;
import com.iqoption.d.agw;
import com.iqoption.d.agy;
import com.iqoption.d.aha;
import com.iqoption.dto.Event;
import com.iqoption.dto.entity.iqbus.SignalLegacy;
import com.iqoption.util.au;
import com.iqoption.util.bf;
import com.iqoption.widget.g;
import com.iqoption.x.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* compiled from: PriceMovementsAdapter */
public class p extends Adapter<ViewHolder> {
    private static final int aht = Math.min(1000, 5000);
    private final c ahu;
    private ArrayList<b> ahv;
    @Nullable
    private a ahw;
    @Nullable
    private RecyclerView ahx;

    /* compiled from: PriceMovementsAdapter */
    private static class a implements Runnable {
        private final WeakReference<View> ahz;

        public a(View view) {
            this.ahz = new WeakReference(view);
        }

        public void run() {
            View view = (View) this.ahz.get();
            if (view != null && ViewCompat.isAttachedToWindow(view)) {
                view.setVisibility(8);
            }
        }
    }

    /* compiled from: PriceMovementsAdapter */
    public static class b {
        public int activeId;
        public int ahA;
        public int[] ahB;
        public boolean ahC;
        public long ahD;
        public long ahE;
        public long ahF;
        public long ahG;
        public String ahH;
        public String ahI;
        public String ahJ;
        public String ahK;
        public String ahL;
        public int ahM;
        public long ahN;
        public long ahO;
        public SignalLegacy ahP;
        public int filter;
        public InstrumentType instrumentType;
        public int level;
        public long startTime;
        public int type;
        public double value;

        public static int cx(int i) {
            return (i == 0 || i == 1 || i == 10) ? 0 : 1;
        }

        public b(Context context, SignalLegacy signalLegacy) {
            this.ahP = signalLegacy;
            int intValue = signalLegacy.type.intValue();
            this.ahH = cw(intValue);
            this.startTime = signalLegacy.start_time.longValue();
            this.ahD = signalLegacy.finish_time.longValue();
            this.activeId = signalLegacy.active_id.intValue();
            this.ahE = signalLegacy.start_value.longValue();
            this.ahF = signalLegacy.finish_value.longValue();
            this.ahC = signalLegacy.finish_value.longValue() > signalLegacy.start_value.longValue();
            this.instrumentType = signalLegacy.getOptionType();
            this.ahK = a(context, signalLegacy);
            this.ahO = signalLegacy.id.longValue();
            this.ahN = signalLegacy.created.longValue();
            this.level = signalLegacy.level == null ? 0 : signalLegacy.level.intValue();
            Date date = new Date(TimeUnit.SECONDS.toMillis(this.ahN));
            this.ahJ = bf.cgr.format(date);
            this.ahG = Long.parseLong(bf.dwE.format(date));
            this.ahL = bf.cgq.format(date);
            this.filter = 0;
            this.type = cx(intValue);
            switch (intValue) {
                case 0:
                    this.filter = 1;
                    break;
                case 1:
                    this.filter = 2;
                    break;
                case 4:
                    this.filter = 3;
                    break;
                case 5:
                    this.filter = 4;
                    break;
                case 8:
                    this.filter = 5;
                    break;
                case 9:
                    this.filter = 6;
                    break;
            }
            e b = p.b(signalLegacy);
            this.ahA = b.ahA;
            this.ahM = b.ahM;
            this.ahI = b.ahI;
            this.value = b.value;
            this.ahB = b.ahB;
        }

        public static String cw(int i) {
            return (i < 0 || i >= com.iqoption.fragment.b.b.cHR.length) ? "" : com.iqoption.fragment.b.b.cHR[i];
        }

        public static String a(Context context, SignalLegacy signalLegacy) {
            com.iqoption.core.microservices.tradingengine.response.active.a a = com.iqoption.app.helpers.a.FI().a(signalLegacy.active_id, signalLegacy.getOptionType());
            if (a == null) {
                return "";
            }
            return com.iqoption.util.e.a.s(a);
        }
    }

    /* compiled from: PriceMovementsAdapter */
    public interface c {
        void x(View view);
    }

    /* compiled from: PriceMovementsAdapter */
    public static class e {
        @DrawableRes
        public int ahA = 0;
        @DrawableRes
        public int[] ahB;
        public String ahI = "";
        public int ahM = -1;
        double value;
    }

    /* compiled from: PriceMovementsAdapter */
    public class d extends n<agw> implements OnClickListener {
        public b ahQ;

        /* synthetic */ d(p pVar, agw agw, int i, AnonymousClass1 anonymousClass1) {
            this(agw, i);
        }

        private d(agw agw, int i) {
            super(agw, i);
            agw.getRoot().setOnClickListener(this);
        }

        public void onClick(View view) {
            p.a(this.ahQ.ahP, view.getRootView());
            if (p.this.ahu != null) {
                p.this.ahu.x(view);
            }
        }
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.ahx = recyclerView;
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.ahx = null;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        switch (i) {
            case 0:
                aha aha = (aha) DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.price_movements_tittle_item, viewGroup, false);
                aha.bQr.setText(R.string.move_right_now);
                return new n(aha, 0);
            case 1:
                return new n((agu) DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.price_movements_high_frequency_layout, viewGroup, false), 1);
            case 2:
                return new d(this, (agw) DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.price_movements_item, viewGroup, false), 2, null);
            case 3:
                return new n((agy) DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.price_movements_progress, viewGroup, false), 3);
            default:
                return null;
        }
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        n nVar = (n) viewHolder;
        switch (nVar.type) {
            case 1:
                agu agu = (agu) nVar.ahp;
                ImmutableList d = com.iqoption.fragment.b.b.aoi().d(true, 10);
                if (agu.bQg.getAdapter() == null) {
                    agu.bQg.setAdapter(new q(new com.iqoption.a.q.a() {
                        public void b(SignalLegacy signalLegacy, View view) {
                            p.a(signalLegacy, view.getRootView());
                            if (p.this.ahu != null) {
                                p.this.ahu.x(null);
                            }
                        }
                    }, d));
                    a(agu, d);
                    agu.bQg.addItemDecoration(new g(agu.getRoot().getContext().getResources().getDimensionPixelOffset(R.dimen.dp10), true, false));
                    return;
                }
                ((q) agu.bQg.getAdapter()).b(d);
                a(agu, d);
                return;
            case 2:
                d dVar = (d) viewHolder;
                agw agw = (agw) dVar.ahp;
                int i2 = i - 2;
                b bVar = (b) this.ahv.get(i2);
                dVar.ahQ = bVar;
                agw.bQi.setImageResource(bVar.ahA);
                agw.bQo.setText(bVar.ahH);
                agw.bHY.setTextColor(bVar.ahM);
                int indexOf = bVar.ahI.indexOf(37);
                if (indexOf == -1) {
                    agw.bHY.setText(bVar.ahI);
                } else {
                    CharSequence spannableString = new SpannableString(bVar.ahI);
                    spannableString.setSpan(new StyleSpan(1), indexOf, indexOf + 1, 33);
                    agw.bHY.setText(spannableString);
                }
                agw.bHW.setText(bVar.ahK);
                agw.bQn.setText(bVar.ahJ);
                agw.bQh.setText(bVar.ahJ);
                if (bVar.ahB != null) {
                    agw.bQk.setImageResource(bVar.ahB[0]);
                    agw.bQl.setImageResource(bVar.ahB[1]);
                    agw.bQm.setImageResource(bVar.ahB[2]);
                    agw.bQj.setVisibility(0);
                } else {
                    agw.bQj.setVisibility(8);
                }
                if (i <= 2 || bVar.ahG != ((b) this.ahv.get(i2 - 1)).ahG) {
                    agw.bQh.setText(bf.f(agw.getRoot().getContext(), bVar.ahN * 1000));
                    agw.bQh.setVisibility(0);
                } else {
                    agw.bQh.setVisibility(8);
                }
                agw.getRoot().setAlpha(bVar.ahP.isActiveAvailable() ? 1.0f : 0.5f);
                return;
            case 3:
                agy agy = (agy) nVar.ahp;
                agy.bQp.setVisibility(0);
                if (this.ahw != null) {
                    agy.bQp.removeCallbacks(this.ahw);
                }
                this.ahw = new a(agy.bQp);
                agy.bQp.postDelayed(this.ahw, 10000);
                return;
            default:
                return;
        }
    }

    public static void a(SignalLegacy signalLegacy, View view) {
        SignalLegacy signalLegacy2 = signalLegacy;
        View view2 = view;
        InstrumentType optionType = signalLegacy.getOptionType();
        if (optionType != null) {
            com.iqoption.app.managers.tab.a.Il().d(signalLegacy2.active_id.intValue(), optionType);
            int cx = b.cx(signalLegacy2.type.intValue());
            String a = b.a(IQApp.Dk().getApplicationContext(), signalLegacy2);
            String cw = b.cw(signalLegacy2.type.intValue());
            e b = b(signalLegacy);
            boolean equal = f.equal(signalLegacy2.type, Integer.valueOf(10));
            Context applicationContext = IQApp.Dk().getApplicationContext();
            EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, equal ? "signals_show-signal-move-now" : "signals_show-signal-today").setValue(Double.valueOf(signalLegacy2.id.doubleValue())).setParameters(a(signalLegacy)).build());
            double longValue = (double) (((float) signalLegacy2.finish_value.longValue()) / 1000000.0f);
            Context context = applicationContext;
            com.iqoption.gl.b.aow().glchTabShowSignal(cx, signalLegacy2.active_id.intValue(), signalLegacy2.start_time.longValue(), signalLegacy2.finish_time.longValue(), (double) (((float) signalLegacy2.start_value.longValue()) / 1000000.0f), longValue, a, cw, b.ahI, true, signalLegacy2.id.longValue(), optionType.getOptionActiveOrInstrumentValue());
            EventManager.Bm().a(Event.Builder(Event.CATEGORY_POPUP_SERVED, "left-bar_new-tab-signals-history").setValue(Double.valueOf((double) com.iqoption.app.managers.tab.a.Il().IG())).setParameters(i.ZZ().l("instrument_type", optionType).aab()).build());
            if (view2 != null) {
                com.iqoption.fragment.b.a.aof().a(context, view2, 800);
            }
        }
    }

    private static JsonObject a(SignalLegacy signalLegacy) {
        return i.ZZ().l(Param.TYPE, signalLegacy.type).l("created", signalLegacy.created).l("active_id", signalLegacy.active_id).l("start_time", signalLegacy.start_time).l("finish_time", signalLegacy.finish_time).l("start_value", signalLegacy.start_value).l("finish_value", signalLegacy.finish_value).l(com.google.firebase.analytics.FirebaseAnalytics.b.LEVEL, signalLegacy.level).aab();
    }

    private void a(agu agu, ImmutableList<SignalLegacy> immutableList) {
        if (immutableList.isEmpty()) {
            agu.bQf.setVisibility(0);
            agu.bQg.setVisibility(8);
            return;
        }
        agu.bQg.setVisibility(0);
        agu.bQf.setVisibility(8);
    }

    public int getItemViewType(int i) {
        switch (i) {
            case 0:
                return 0;
            case 1:
                return 1;
            default:
                return cv(i) ? 3 : 2;
        }
    }

    public long getItemId(int i) {
        if (i <= 2) {
            return (long) ((-i) - 2);
        }
        if (cv(i)) {
            return -4;
        }
        i -= 2;
        return i < this.ahv.size() ? ((b) this.ahv.get(i)).ahO : -1;
    }

    private boolean cv(int i) {
        return i >= this.ahv.size() + 2;
    }

    public int getItemCount() {
        return (this.ahv.size() + 2) + 1;
    }

    public static e b(SignalLegacy signalLegacy) {
        e eVar = new e();
        Context applicationContext = IQApp.Dk().getApplicationContext();
        if (signalLegacy.type.intValue() < 2 || signalLegacy.type.intValue() == 10) {
            if (signalLegacy.finish_value.longValue() <= signalLegacy.start_value.longValue()) {
                eVar.ahA = R.drawable.ic_signals_bear;
                eVar.ahM = ContextCompat.getColor(applicationContext, R.color.red);
                eVar.ahI = "";
                switch (signalLegacy.level.intValue()) {
                    case 1:
                        eVar.ahB = new int[]{R.drawable.ic_signal_dot_red1, R.drawable.ic_signal_dot_red2, R.drawable.ic_signal_dot_red2};
                        break;
                    case 2:
                        eVar.ahB = new int[]{R.drawable.ic_signal_dot_red1, R.drawable.ic_signal_dot_red1, R.drawable.ic_signal_dot_red2};
                        break;
                    case 3:
                        eVar.ahB = new int[]{R.drawable.ic_signal_dot_red1, R.drawable.ic_signal_dot_red1, R.drawable.ic_signal_dot_red1};
                        break;
                }
            }
            eVar.ahA = R.drawable.ic_signals_bull;
            eVar.ahM = ContextCompat.getColor(applicationContext, R.color.green);
            eVar.ahI = "+";
            switch (signalLegacy.level.intValue()) {
                case 1:
                    eVar.ahB = new int[]{R.drawable.ic_signal_dot_green1, R.drawable.ic_signal_dot_green2, R.drawable.ic_signal_dot_green2};
                    break;
                case 2:
                    eVar.ahB = new int[]{R.drawable.ic_signal_dot_green1, R.drawable.ic_signal_dot_green1, R.drawable.ic_signal_dot_green2};
                    break;
                case 3:
                    eVar.ahB = new int[]{R.drawable.ic_signal_dot_green1, R.drawable.ic_signal_dot_green1, R.drawable.ic_signal_dot_green1};
                    break;
            }
            float longValue = signalLegacy.start_value.longValue() != 0 ? ((((float) signalLegacy.finish_value.longValue()) / ((float) signalLegacy.start_value.longValue())) - 1.0f) * 100.0f : 0.0f;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(eVar.ahI);
            stringBuilder.append(String.format(Locale.US, "%.2f%%", new Object[]{Float.valueOf(longValue)}));
            eVar.ahI = stringBuilder.toString();
            if (signalLegacy.type.intValue() == 1 || signalLegacy.type.intValue() == 10) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(eVar.ahI);
                stringBuilder2.append(" in ");
                stringBuilder2.append(bf.ck(signalLegacy.finish_time.longValue() - signalLegacy.start_time.longValue()));
                eVar.ahI = stringBuilder2.toString();
            }
            eVar.value = ((double) (signalLegacy.finish_value.longValue() - signalLegacy.start_value.longValue())) / ((double) signalLegacy.start_value.longValue());
        } else {
            if (signalLegacy.type.intValue() % 2 == 0) {
                eVar.ahA = R.drawable.ic_signals_hi;
                eVar.ahM = ContextCompat.getColor(applicationContext, R.color.green);
            } else {
                eVar.ahA = R.drawable.ic_signals_lo;
                eVar.ahM = ContextCompat.getColor(applicationContext, R.color.red);
            }
            eVar.ahI = String.format(Locale.US, "%.6f", new Object[]{Double.valueOf(au.c((double) (((float) signalLegacy.finish_value.longValue()) / 1000000.0f), 6))});
            eVar.value = (double) signalLegacy.finish_value.longValue();
        }
        return eVar;
    }
}
