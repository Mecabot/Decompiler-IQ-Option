package com.iqoption.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.google.common.base.j;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.iqoption.app.IQApp;
import com.iqoption.core.i;
import com.iqoption.dto.Balance;
import com.iqoption.dto.Currencies;
import com.iqoption.dto.Currencies.ConversionCurrency;
import com.iqoption.util.bg;
import com.iqoption.util.l;
import com.iqoption.util.q;
import com.iqoption.view.AnimatedVectorSwitchView;
import com.iqoption.x.R;
import java.util.Comparator;
import java.util.Iterator;

/* compiled from: BalancesAdapter */
public class b extends Adapter {
    private static final String TAG = b.class.getName();
    private static ImmutableMap<String, Integer> ago = ImmutableMap.sU().r(Currencies.OTN_CURRENCY, Integer.valueOf(R.drawable.ic_otn_28)).r(Currencies.BTC_CURRENCY, Integer.valueOf(R.drawable.ic_btc_28)).r(Currencies.ETH_CURRENCY, Integer.valueOf(R.drawable.ic_eth_28)).r("BTG", Integer.valueOf(R.drawable.ic_btg_28)).r("OMG", Integer.valueOf(R.drawable.ic_omg_28)).r("ZEC", Integer.valueOf(R.drawable.ic_zec_28)).r("XRP", Integer.valueOf(R.drawable.ic_xrp_28)).r("NEO", Integer.valueOf(R.drawable.ic_neo_28)).r("ETC", Integer.valueOf(R.drawable.ic_etc_28)).r("BTH", Integer.valueOf(R.drawable.ic_bth_28)).r("DSH", Integer.valueOf(R.drawable.ic_dsh_28)).r("QTM", Integer.valueOf(R.drawable.ic_qtm_28)).r("LTC", Integer.valueOf(R.drawable.ic_ltc_28)).r("XMR", Integer.valueOf(R.drawable.ic_xmr_28)).r("XLM", Integer.valueOf(R.drawable.ic_xlm_28)).r("TRX", Integer.valueOf(R.drawable.ic_trx_28)).r("EOS", Integer.valueOf(R.drawable.ic_eos_28)).tc();
    private final boolean agk;
    private final boolean agl;
    private final ConversionCurrency agm;
    private int agn = -1;
    private c agp;
    private ImmutableList<Balance> agq;
    private Long agr;
    private int ags;
    private final g agt = new g(IQApp.Dk());
    private final Comparator<Balance> agu = new c(this);
    private final j<Balance> agv = d.$instance;
    private final j<Balance> agw = e.$instance;
    private final j<Balance> agx = f.$instance;

    /* compiled from: BalancesAdapter */
    public interface c {
        void a(View view, a aVar, int i);

        void ct(int i);
    }

    /* compiled from: BalancesAdapter */
    public final class g {
        private final String ahb = "(%s)";
        private final String ahc;
        private final String ahd;
        private final String ahe;
        private final int ahf;
        @ColorInt
        public final int ahg;
        @ColorInt
        public final int ahh;
        @ColorInt
        public final int ahi;

        public g(Context context) {
            String string = context.getString(R.string.total);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append(": %s");
            this.ahe = stringBuilder.toString();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("%s ");
            stringBuilder2.append(context.getString(R.string.cash));
            this.ahc = stringBuilder2.toString();
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("%s (");
            stringBuilder2.append(context.getString(R.string.only_exchange));
            stringBuilder2.append(")");
            this.ahd = stringBuilder2.toString();
            this.ahf = context.getResources().getDimensionPixelSize(R.dimen.dp4);
            this.ahg = ContextCompat.getColor(context, R.color.green);
            this.ahh = ContextCompat.getColor(context, R.color.red);
            this.ahi = ContextCompat.getColor(context, R.color.white);
        }
    }

    /* compiled from: BalancesAdapter */
    public static class a extends ViewHolder implements OnClickListener {
        TextView agA;
        TextView agB;
        ViewGroup agC;
        ViewSwitcher agD;
        AnimatedVectorSwitchView agE;
        View agF;
        View agG;
        g agt;
        c agz;

        public void a(ConversionCurrency conversionCurrency) {
        }

        a(View view, c cVar, g gVar) {
            super(view);
            this.agt = gVar;
            this.agC = (ViewGroup) view.findViewById(R.id.base_balance_item);
            this.agC.setLayoutTransition(bg.aGE());
            this.agD = (ViewSwitcher) view.findViewById(R.id.checkboxFrame);
            this.agA = (TextView) view.findViewById(R.id.title);
            this.agB = (TextView) view.findViewById(R.id.balance);
            this.agE = (AnimatedVectorSwitchView) view.findViewById(R.id.selectedCheckView);
            this.agF = view.findViewById(R.id.loading_change);
            this.agG = view.findViewById(R.id.iconCurrency);
            this.agC.setOnClickListener(this);
            if (this.agE != null) {
                this.agE.setOnClickListener(this);
            }
            this.agz = cVar;
        }

        public void onClick(View view) {
            int adapterPosition = getAdapterPosition();
            if (this.agz != null && adapterPosition >= 0) {
                this.agz.a(view, this, adapterPosition);
            }
        }

        public void AR() {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(new Animator[]{com.iqoption.util.b.p(this.agC, this.agt.ahf), com.iqoption.util.b.o(this.agA)});
            animatorSet.start();
        }

        public void AS() {
            if (this.agD != null) {
                this.agD.showNext();
            }
        }

        public void as(boolean z) {
            if (this.agE != null) {
                if (z) {
                    this.agE.setSwitched(true);
                } else {
                    this.agE.setSwitched(false);
                }
            }
        }

        public void at(boolean z) {
            if (this.agD != null) {
                if (z) {
                    if (this.agD.getNextView().getId() == R.id.loading_change) {
                        this.agD.showNext();
                    }
                } else if (this.agD.getNextView().getId() == R.id.selectedCheckView) {
                    this.agD.showNext();
                }
            }
        }
    }

    /* compiled from: BalancesAdapter */
    public static class b extends a {
        TextView agH;
        FrameLayout agI;
        ImageView agJ;
        ProgressBar agK;

        b(View view, c cVar, g gVar) {
            super(view, cVar, gVar);
            this.agH = (TextView) view.findViewById(R.id.balanceExchange);
            this.agK = (ProgressBar) view.findViewById(R.id.withdrawProgress);
            this.agI = (FrameLayout) view.findViewById(R.id.withdrawalBtn);
            this.agJ = (ImageView) view.findViewById(R.id.depositBtn);
            this.agI.setOnClickListener(this);
            this.agJ.setOnClickListener(this);
            this.agI.setOnTouchListener(new com.iqoption.view.d.c());
            this.agJ.setOnTouchListener(new com.iqoption.view.d.c());
        }

        public void au(boolean z) {
            this.agI.animate().cancel();
            if (z) {
                this.agK.setVisibility(0);
                this.agI.setAlpha(0.2f);
                return;
            }
            this.agK.setVisibility(8);
            this.agI.setAlpha(1.0f);
        }

        public void a(ConversionCurrency conversionCurrency) {
            if (conversionCurrency != null) {
                ImageView imageView = (ImageView) this.agG;
                try {
                    Integer num = (Integer) b.ago.get(conversionCurrency.getName());
                    if (num != null) {
                        imageView.setImageResource(num.intValue());
                    } else {
                        imageView.setImageResource(R.drawable.ic_crypto_placeholder_28);
                    }
                } catch (Throwable e) {
                    i.e(b.TAG, "unable to set crypto icon", e);
                }
            }
        }
    }

    /* compiled from: BalancesAdapter */
    public static class d extends a {
        TextView agL;
        TextView agM;
        TextView agN;
        TextView agO;
        TextView agP;
        TextView agQ;
        TextView agR;
        TextView agS;
        TextView agT;
        View agU;

        d(View view, c cVar, g gVar) {
            super(view, cVar, gVar);
            this.agO = (TextView) view.findViewById(R.id.invested);
            this.agP = (TextView) view.findViewById(R.id.investedValue);
            this.agQ = (TextView) view.findViewById(R.id.pnl);
            this.agR = (TextView) view.findViewById(R.id.pnlValue);
            this.agS = (TextView) view.findViewById(R.id.profit);
            this.agT = (TextView) view.findViewById(R.id.profitValue);
            this.agM = (TextView) view.findViewById(R.id.totalBalance);
            this.agN = (TextView) view.findViewById(R.id.totalPnlBalance);
            this.agL = (TextView) view.findViewById(R.id.totalBalanceInfo);
            View findViewById = view.findViewById(R.id.withdrawalBtn);
            View findViewById2 = view.findViewById(R.id.depositBtn);
            findViewById.setOnClickListener(this);
            findViewById2.setOnClickListener(this);
            findViewById.setOnTouchListener(new com.iqoption.view.d.c());
            findViewById2.setOnTouchListener(new com.iqoption.view.d.c());
            this.agU = view.findViewById(R.id.totalArrow);
            this.agU.setOnClickListener(new g(this));
            this.agN.setOnClickListener(new h(this));
        }

        final /* synthetic */ void s(View view) {
            boolean isSelected = this.agU.isSelected() ^ 1;
            this.agU.setSelected(isSelected);
            this.agU.animate().rotation(isSelected ? 180.0f : 0.0f).setInterpolator(com.iqoption.view.a.a.d.dEM).start();
            av(isSelected);
        }

        final /* synthetic */ void r(View view) {
            if (this.agL != null) {
                int i = 0;
                boolean z = this.agL.getVisibility() != 0;
                TextView textView = this.agL;
                if (!z) {
                    i = 8;
                }
                textView.setVisibility(i);
                this.agN.setSelected(z);
            }
        }

        private void av(boolean z) {
            int i = 8;
            this.agO.setVisibility(z ? 0 : 8);
            this.agP.setVisibility(z ? 0 : 8);
            this.agQ.setVisibility(z ? 0 : 8);
            this.agR.setVisibility(z ? 0 : 8);
            this.agS.setVisibility(z ? 0 : 8);
            TextView textView = this.agT;
            if (z) {
                i = 0;
            }
            textView.setVisibility(i);
        }

        public void a(com.iqoption.app.managers.c.g gVar, String str, double d, double d2) {
            String format = String.format(this.agt.ahb, new Object[]{str});
            this.agP.setText(l.e(str, Double.valueOf(gVar.GN())));
            this.agR.setText(l.c(str, Double.valueOf(gVar.GM())));
            this.agT.setText(l.e(str, Double.valueOf(gVar.GO() + d)));
            this.agN.setText(l.d(format, Double.valueOf((d + d2) + gVar.GO())));
            if (gVar.GM() < -0.01d) {
                this.agR.setTextColor(this.agt.ahh);
            } else {
                this.agR.setTextColor(this.agt.ahg);
            }
            this.agN.setVisibility(0);
            this.agU.setVisibility(0);
        }

        public void AT() {
            av(false);
            this.agN.setVisibility(8);
            this.agL.setVisibility(8);
            this.agU.setVisibility(8);
            this.agN.setSelected(false);
        }

        public void a(ConversionCurrency conversionCurrency) {
            if (conversionCurrency != null) {
                ((TextView) this.agG).setText(conversionCurrency.symbol);
            }
        }
    }

    /* compiled from: BalancesAdapter */
    public static class e extends a {
        TextView agL;
        TextView agM;
        TextView agN;
        TextView agO;
        TextView agP;
        TextView agQ;
        TextView agR;
        TextView agS;
        TextView agT;
        View agU;
        View agW;

        e(View view, c cVar, g gVar) {
            super(view, cVar, gVar);
            this.agW = view.findViewById(R.id.refresh_traning_balance);
            this.agW.setOnClickListener(this);
            this.agM = (TextView) view.findViewById(R.id.totalBalance);
            this.agN = (TextView) view.findViewById(R.id.totalPnlBalance);
            this.agL = (TextView) view.findViewById(R.id.totalBalanceInfo);
            this.agO = (TextView) view.findViewById(R.id.invested);
            this.agP = (TextView) view.findViewById(R.id.investedValue);
            this.agQ = (TextView) view.findViewById(R.id.pnl);
            this.agR = (TextView) view.findViewById(R.id.pnlValue);
            this.agS = (TextView) view.findViewById(R.id.profit);
            this.agT = (TextView) view.findViewById(R.id.profitValue);
            this.agU = view.findViewById(R.id.totalArrow);
            this.agU.setOnClickListener(new i(this));
            this.agN.setOnClickListener(new j(this));
        }

        final /* synthetic */ void u(View view) {
            boolean isSelected = this.agU.isSelected() ^ 1;
            this.agU.setSelected(isSelected);
            this.agU.animate().rotation(isSelected ? 180.0f : 0.0f).setInterpolator(com.iqoption.view.a.a.d.dEM).start();
            av(isSelected);
        }

        final /* synthetic */ void t(View view) {
            boolean isSelected = this.agN.isSelected() ^ 1;
            this.agL.setVisibility(isSelected ? 0 : 8);
            this.agN.setSelected(isSelected);
            int adapterPosition = getAdapterPosition();
            if (this.agz != null && adapterPosition >= 0) {
                this.agz.ct(adapterPosition);
            }
        }

        private void av(boolean z) {
            int i = 8;
            this.agO.setVisibility(z ? 0 : 8);
            this.agP.setVisibility(z ? 0 : 8);
            this.agQ.setVisibility(z ? 0 : 8);
            this.agR.setVisibility(z ? 0 : 8);
            this.agS.setVisibility(z ? 0 : 8);
            TextView textView = this.agT;
            if (z) {
                i = 0;
            }
            textView.setVisibility(i);
        }

        public void a(com.iqoption.app.managers.c.g gVar, String str, Double d) {
            String format = String.format(this.agt.ahb, new Object[]{str});
            this.agP.setText(l.e(str, Double.valueOf(gVar.GN())));
            this.agR.setText(l.c(str, Double.valueOf(gVar.GM())));
            this.agT.setText(l.e(str, Double.valueOf(d.doubleValue() + gVar.GO())));
            this.agN.setText(l.d(format, Double.valueOf(d.doubleValue() + gVar.GO())));
            if (gVar.GM() < -0.01d) {
                this.agR.setTextColor(this.agt.ahh);
            } else {
                this.agR.setTextColor(this.agt.ahg);
            }
            this.agN.setVisibility(0);
            this.agU.setVisibility(0);
        }

        public void AT() {
            av(false);
            this.agN.setVisibility(8);
            this.agL.setVisibility(8);
            this.agU.setVisibility(8);
            this.agN.setSelected(false);
        }

        public void AU() {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.agW, View.ROTATION, new float[]{0.0f});
            ofFloat.setInterpolator(com.iqoption.view.a.a.d.aQV);
            ofFloat.start();
        }

        public void AV() {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.agW, View.ROTATION, new float[]{360.0f});
            ofFloat.setDuration(400);
            ofFloat.setInterpolator(com.iqoption.view.a.a.d.aQV);
            ofFloat.setRepeatMode(1);
            ofFloat.setRepeatCount(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            ofFloat.start();
        }

        public void a(ConversionCurrency conversionCurrency) {
            if (conversionCurrency != null) {
                ((TextView) this.agG).setText(conversionCurrency.symbol);
            }
        }
    }

    /* compiled from: BalancesAdapter */
    public static class f extends a {
        TextView agL;
        TextView agM;
        TextView agN;
        TextView agO;
        TextView agP;
        TextView agQ;
        TextView agR;
        TextView agS;
        TextView agT;
        View agU;
        View agY;
        View agZ;

        f(View view, c cVar, g gVar) {
            super(view, cVar, gVar);
            this.agZ = view.findViewById(R.id.registrationButton);
            this.agZ.setOnTouchListener(new com.iqoption.view.d.c());
            this.agZ.setOnClickListener(this);
            this.agY = view.findViewById(R.id.refresh_trial_balance);
            this.agY.setOnClickListener(this);
            this.agM = (TextView) view.findViewById(R.id.totalBalance);
            this.agN = (TextView) view.findViewById(R.id.totalPnlBalance);
            this.agL = (TextView) view.findViewById(R.id.totalBalanceInfo);
            this.agO = (TextView) view.findViewById(R.id.invested);
            this.agP = (TextView) view.findViewById(R.id.investedValue);
            this.agQ = (TextView) view.findViewById(R.id.pnl);
            this.agR = (TextView) view.findViewById(R.id.pnlValue);
            this.agS = (TextView) view.findViewById(R.id.profit);
            this.agT = (TextView) view.findViewById(R.id.profitValue);
            this.agU = view.findViewById(R.id.totalArrow);
            this.agU.setOnClickListener(new k(this));
            this.agN.setOnClickListener(new l(this));
        }

        final /* synthetic */ void w(View view) {
            boolean isSelected = this.agU.isSelected() ^ 1;
            this.agU.setSelected(isSelected);
            this.agU.animate().rotation(isSelected ? 180.0f : 0.0f).setInterpolator(com.iqoption.view.a.a.d.dEM).start();
            av(isSelected);
        }

        final /* synthetic */ void v(View view) {
            boolean isSelected = this.agN.isSelected() ^ 1;
            this.agL.setVisibility(isSelected ? 0 : 8);
            this.agN.setSelected(isSelected);
            int adapterPosition = getAdapterPosition();
            if (this.agz != null && adapterPosition >= 0) {
                this.agz.ct(adapterPosition);
            }
        }

        private void av(boolean z) {
            int i = 8;
            this.agO.setVisibility(z ? 0 : 8);
            this.agP.setVisibility(z ? 0 : 8);
            this.agQ.setVisibility(z ? 0 : 8);
            this.agR.setVisibility(z ? 0 : 8);
            this.agS.setVisibility(z ? 0 : 8);
            TextView textView = this.agT;
            if (z) {
                i = 0;
            }
            textView.setVisibility(i);
        }

        public void a(com.iqoption.app.managers.c.g gVar, String str, Double d) {
            String format = String.format(this.agt.ahb, new Object[]{str});
            this.agP.setText(l.e(str, Double.valueOf(gVar.GN())));
            this.agR.setText(l.c(str, Double.valueOf(gVar.GM())));
            this.agT.setText(l.e(str, Double.valueOf(d.doubleValue() + gVar.GO())));
            this.agN.setText(l.d(format, Double.valueOf(d.doubleValue() + gVar.GO())));
            if (gVar.GM() < -0.01d) {
                this.agR.setTextColor(this.agt.ahh);
            } else {
                this.agR.setTextColor(this.agt.ahg);
            }
            this.agN.setVisibility(0);
            this.agU.setVisibility(0);
        }

        public void AT() {
            av(false);
            this.agN.setVisibility(8);
            this.agL.setVisibility(8);
            this.agU.setVisibility(8);
            this.agN.setSelected(false);
        }

        public void a(ConversionCurrency conversionCurrency) {
            if (conversionCurrency != null) {
                ((TextView) this.agG).setText(conversionCurrency.symbol);
            }
        }
    }

    public b(c cVar) {
        com.iqoption.app.a Cw = com.iqoption.app.a.Cw();
        this.agm = Cw.eh(Balance.getCurrency(Cw.cG(1)));
        this.agk = com.iqoption.app.managers.feature.b.HT().ff("show-crypto-balances");
        this.agl = com.iqoption.app.managers.feature.b.HT().ff("crypto-deposit");
        this.agp = cVar;
        AJ();
    }

    private Integer cr(int i) {
        switch (i) {
            case 1:
                return Integer.valueOf(10);
            case 2:
                return Integer.valueOf(99);
            case 4:
                return Integer.valueOf(40);
            case 5:
                return Integer.valueOf(30);
            default:
                return Integer.valueOf(i);
        }
    }

    static final /* synthetic */ boolean a(Balance balance) {
        boolean z = true;
        if (Balance.getBalanceType(balance) != 5) {
            return true;
        }
        if (Balance.getBalanceValue(balance) <= 0.0d) {
            z = false;
        }
        return z;
    }

    public void AJ() {
        com.iqoption.app.a Cw = com.iqoption.app.a.Cw();
        this.agr = (Long) com.google.common.base.e.h(Cw.getBalanceId(), Long.valueOf(1));
        com.google.common.collect.i c = com.google.common.collect.i.c(Cw.Cz().values());
        if (Cw.CZ()) {
            c = c.c(this.agw);
        }
        if (!this.agk) {
            c = c.c(this.agv);
        }
        this.agq = c.a(this.agu);
        this.agn = AK();
    }

    private int AK() {
        Iterator sI = this.agq.iterator();
        int i = 0;
        while (sI.hasNext()) {
            if (((Balance) sI.next()).type.intValue() == 2) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public long getItemId(int i) {
        return cs(i).id.longValue();
    }

    public int getItemCount() {
        return this.agq == null ? 0 : this.agq.size();
    }

    public final int getItemViewType(int i) {
        if (i == this.agn) {
            return 98;
        }
        i = cr(cs(i).type.intValue()).intValue();
        int i2 = 40;
        if (i != 40) {
            return i;
        }
        if (com.iqoption.app.a.Cw().CZ()) {
            i2 = 1;
        }
        return i2;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new f(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.trial_balance_item, viewGroup, false), this.agp, this.agt);
        }
        if (i == 10) {
            return new d(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.normal_balance_item, viewGroup, false), this.agp, this.agt);
        }
        if (i == 30) {
            return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.crypto_balance_item, viewGroup, false), this.agp, this.agt);
        }
        if (i == 40) {
            return new e(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.training_balance_item, viewGroup, false), this.agp, this.agt);
        }
        switch (i) {
            case 98:
                return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.first_tournament_balance_item, viewGroup, false), this.agp, this.agt);
            case 99:
                return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tournament_balance_item, viewGroup, false), this.agp, this.agt);
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported viewType: ");
                stringBuilder.append(i);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        String str;
        int i2 = i;
        a aVar = (a) viewHolder;
        Balance cs = cs(i2);
        double balanceValue = Balance.getBalanceValue(cs);
        String currency = Balance.getCurrency(cs);
        ConversionCurrency eh = com.iqoption.app.a.Cw().eh(currency);
        if (Balance.getBalanceType(cs) == 5) {
            str = Currencies.REPLACE_CURRENCY_MASK;
        } else {
            str = l.d(eh);
        }
        boolean Gq = com.iqoption.app.managers.c.Gn().Gq();
        boolean c = c(cs.id);
        if (c) {
            this.ags = i2;
        }
        aVar.as(c);
        aVar.a(eh);
        String format = String.format(this.agt.ahe, new Object[]{str});
        int itemViewType = getItemViewType(i2);
        if (itemViewType == 1) {
            f fVar = (f) viewHolder;
            fVar.agA.setText(String.format(this.agt.ahc, new Object[]{l.e(eh)}));
            fVar.agB.setText(l.e(str, Double.valueOf(balanceValue)));
            fVar.agM.setText(l.e(format, Double.valueOf(balanceValue)));
            if (Gq || !c) {
                fVar.AT();
            } else {
                fVar.a(com.iqoption.app.managers.c.Gn().GA(), str, Double.valueOf(balanceValue));
            }
            if (balanceValue >= 10000.0d || !c) {
                fVar.agY.setVisibility(8);
            } else {
                fVar.agY.setRotation(0.0f);
                fVar.agY.setVisibility(0);
            }
        } else if (itemViewType == 10) {
            double AL = AL();
            d dVar = (d) viewHolder;
            dVar.agA.setText(String.format(this.agt.ahc, new Object[]{l.e(eh)}));
            dVar.agB.setText(l.e(str, Double.valueOf(balanceValue)));
            dVar.agM.setText(l.e(format, Double.valueOf(balanceValue + AL)));
            if (Gq || !c) {
                dVar.AT();
            } else {
                dVar.a(com.iqoption.app.managers.c.Gn().GA(), str, balanceValue, AL);
            }
            dVar.agL.setText(this.agk ? R.string.total_balance_summarises_your_initial_balance_crypto : R.string.total_balance_summarises_your_initial_balance);
        } else if (itemViewType == 30) {
            b bVar = (b) viewHolder;
            bVar.agA.setText(String.format(this.agt.ahd, new Object[]{l.e(eh)}));
            bVar.agB.setText(l.a(str, Double.valueOf(balanceValue), q.dX(l.g(eh))));
            String str2 = currency.equalsIgnoreCase(Currencies.OTN_CURRENCY) ? Currencies.OTM_CURRENCY : currency;
            if (this.agl) {
                bVar.agJ.setAlpha(1.0f);
                bVar.agJ.setEnabled(true);
            } else {
                bVar.agJ.setAlpha(0.2f);
                bVar.agJ.setEnabled(false);
            }
            if (cs.amount.equals(Double.valueOf(0.0d)) || !currency.equalsIgnoreCase(Currencies.OTN_CURRENCY)) {
                bVar.agI.setAlpha(0.2f);
                bVar.agI.setEnabled(false);
            } else {
                bVar.agI.setAlpha(1.0f);
                bVar.agI.setEnabled(true);
            }
            bVar.agH.setText(l.e(l.d(this.agm), Double.valueOf(a(balanceValue, com.iqoption.app.a.Cw().eh(str2)))));
        } else if (itemViewType == 40) {
            e eVar = (e) viewHolder;
            eVar.agA.setText(String.format(this.agt.ahc, new Object[]{l.e(eh)}));
            eVar.agB.setText(l.e(str, Double.valueOf(balanceValue)));
            eVar.agM.setText(l.e(format, Double.valueOf(balanceValue)));
            if (Gq || !c) {
                eVar.AT();
            } else {
                eVar.a(com.iqoption.app.managers.c.Gn().GA(), str, Double.valueOf(balanceValue));
            }
            if (balanceValue >= 10000.0d || !c) {
                eVar.agW.setVisibility(8);
            } else {
                eVar.agW.setRotation(0.0f);
                eVar.agW.setVisibility(0);
            }
        } else if (itemViewType == 99) {
            CharSequence stringBuilder;
            TextView textView = aVar.agA;
            if (TextUtils.isEmpty(cs.tournamentName) || cs.tournamentName.equals("null")) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(aVar.agA.getContext().getString(R.string.tournament));
                stringBuilder2.append(i2);
                stringBuilder = stringBuilder2.toString();
            } else {
                stringBuilder = cs.tournamentName;
            }
            textView.setText(stringBuilder);
            aVar.agB.setText(l.e(str, Double.valueOf(balanceValue)));
        }
        aVar.at(cs.isLoadingChange);
    }

    private double a(double d, ConversionCurrency conversionCurrency) {
        return l.d(l.e(Double.valueOf(d), l.c(conversionCurrency)), l.c(this.agm)).doubleValue();
    }

    private double AL() {
        com.iqoption.app.a Cw = com.iqoption.app.a.Cw();
        Iterator sI = this.agq.iterator();
        double d = 0.0d;
        while (sI.hasNext()) {
            Balance balance = (Balance) sI.next();
            if (Balance.getBalanceType(balance) == 5) {
                String currency = Balance.getCurrency(balance);
                if (Currencies.OTN_CURRENCY.equalsIgnoreCase(currency)) {
                    currency = Currencies.OTM_CURRENCY;
                }
                d += a(Balance.getBalanceValue(balance), Cw.eh(currency));
            }
        }
        return d;
    }

    public Balance cs(int i) {
        return (Balance) this.agq.get(i);
    }

    public void b(@Nullable Long l) {
        this.agr = (Long) com.google.common.base.e.h(l, Long.valueOf(-1));
    }

    public void AM() {
        notifyItemChanged(this.ags);
    }

    public void g(int i, boolean z) {
        if (i <= getItemCount()) {
            cs(i).isLoadingChange = z;
        }
    }

    public void AN() {
        int i = 0;
        while (i < this.agq.size()) {
            Balance balance = (Balance) this.agq.get(i);
            if (balance == null || !this.agr.equals(balance.id)) {
                i++;
            } else {
                notifyItemChanged(i);
                return;
            }
        }
    }

    public boolean c(Long l) {
        return this.agr.equals(l);
    }

    public int AO() {
        for (int i = 0; i < this.agq.size(); i++) {
            Balance balance = (Balance) this.agq.get(i);
            if (balance != null && this.agr.equals(balance.id)) {
                return i;
            }
        }
        return -1;
    }
}
