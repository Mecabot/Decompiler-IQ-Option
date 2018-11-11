package com.iqoption.fragment;

import android.databinding.DataBindingUtil;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.iqoption.app.IQApp;
import com.iqoption.core.microservices.risks.response.overnightfee.d;
import com.iqoption.core.util.p;
import com.iqoption.d.jb;
import com.iqoption.d.wf;
import com.iqoption.util.au;
import com.iqoption.util.bc;
import com.iqoption.util.g;
import com.iqoption.util.l;
import com.iqoption.util.o;
import com.iqoption.x.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: OvernightFeeInfoDialog */
public final class bw extends com.iqoption.fragment.base.b {
    private jb cqk;

    /* compiled from: OvernightFeeInfoDialog */
    private final class a extends Adapter<b> {
        private LayoutInflater aDN;
        private double aTA;
        private boolean cjU;
        private final int[] cqm = new int[]{1, 2, 3, 4, 5, 6, 7};
        private Map<Integer, com.iqoption.core.microservices.risks.response.overnightfee.b> cqn = new HashMap();
        private int cqo;
        private String cqp;
        private int leverage;

        public a(d dVar, double d, int i, boolean z) {
            if (dVar != null) {
                this.cqp = l.CD();
                this.aTA = d;
                this.cjU = z;
                this.leverage = i;
                this.cqo = Calendar.getInstance().get(7);
                this.cqn = dVar.WL();
            }
        }

        /* renamed from: H */
        public b onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (this.aDN == null) {
                this.aDN = LayoutInflater.from(viewGroup.getContext());
            }
            return new b(wf.L(this.aDN, viewGroup, false));
        }

        /* renamed from: a */
        public void onBindViewHolder(b bVar, int i) {
            int i2 = this.cqm[i];
            boolean z = this.cqo == i2;
            com.iqoption.core.microservices.risks.response.overnightfee.b bVar2 = (com.iqoption.core.microservices.risks.response.overnightfee.b) this.cqn.get(Integer.valueOf(i2));
            if (bVar2 == null) {
                bVar.bind(i2, z);
            } else {
                bVar.a(i2, bVar2, z, this.aTA, this.leverage, this.cjU, this.cqp);
            }
        }

        public int getItemCount() {
            return this.cqm.length;
        }
    }

    /* compiled from: OvernightFeeInfoDialog */
    private final class b extends ViewHolder {
        private wf cqq;

        public b(wf wfVar) {
            super(wfVar.getRoot());
            this.cqq = wfVar;
        }

        private void a(int i, com.iqoption.core.microservices.risks.response.overnightfee.b bVar, boolean z, double d, int i2, boolean z2, String str) {
            Typeface d2 = com.iqoption.core.ext.a.d((ViewHolder) this, z ? R.font.bold : R.font.regular);
            this.cqq.getRoot().setSelected(z);
            this.cqq.bJp.setTypeface(d2);
            this.cqq.aiq.setTypeface(d2);
            this.cqq.bJq.setTypeface(d2);
            this.cqq.bJr.setTypeface(d2);
            double WJ = z2 ? bVar.WJ() : bVar.WK();
            double i3 = au.i((((double) i2) * d) - d, WJ);
            Object obj = WJ < 0.0d ? 1 : null;
            this.cqq.bJr.setTextColor(com.iqoption.core.ext.a.b((ViewHolder) this, obj != null ? R.color.green : R.color.white));
            this.cqq.bJp.setText(o.gE(i));
            this.cqq.aiq.setText(bVar.getTime());
            this.cqq.bJq.setText(p.e(WJ, 4));
            TextView textView = this.cqq.bJr;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(obj != null ? "+" : "");
            stringBuilder.append(str);
            textView.setText(l.e(stringBuilder.toString(), Double.valueOf(Math.abs(i3))));
        }

        public void bind(int i, boolean z) {
            Typeface d = com.iqoption.core.ext.a.d((ViewHolder) this, z ? R.font.bold : R.font.regular);
            this.cqq.getRoot().setSelected(z);
            this.cqq.bJp.setTypeface(d);
            this.cqq.aiq.setTypeface(d);
            this.cqq.bJq.setTypeface(d);
            this.cqq.bJr.setTypeface(d);
            this.cqq.bJp.setText(o.gE(i));
            this.cqq.aiq.setText(R.string.n_a);
            this.cqq.bJq.setText(R.string.n_a);
            this.cqq.bJr.setText(R.string.n_a);
        }
    }

    /* compiled from: OvernightFeeInfoDialog */
    public static class c extends com.iqoption.system.a.c<Boolean> {
    }

    @NonNull
    private static bw a(int i, int i2, double d, int i3, boolean z, d dVar) {
        bw bwVar = new bw();
        bwVar.setArguments(new g().O("arg.anchorX", i).O("arg.anchorY", i2).e("arg.amount", d).O("arg.leverage", i3).v("arg.is.long", z).b("arg.value", (Parcelable) dVar).toBundle());
        return bwVar;
    }

    public static void a(@NonNull FragmentManager fragmentManager, @IdRes int i, int i2, int i3, double d, int i4, boolean z, d dVar) {
        if (fragmentManager.findFragmentByTag("OvernightFeeInfoDialog") == null) {
            fragmentManager.beginTransaction().add(i, a(i2, i3, d, i4, z, dVar), "OvernightFeeInfoDialog").addToBackStack("OvernightFeeInfoDialog").commit();
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.cqk = (jb) DataBindingUtil.inflate(layoutInflater, R.layout.dialog_overnight_fee_info, viewGroup, false);
        this.cqk.a(this);
        Bundle arguments = getArguments();
        final int i = arguments.getInt("arg.anchorY");
        double d = arguments.getDouble("arg.amount");
        boolean z = arguments.getBoolean("arg.is.long");
        int i2 = arguments.getInt("arg.leverage");
        d dVar = (d) arguments.getParcelable("arg.value");
        String format = new SimpleDateFormat("ZZZZ", Locale.getDefault()).format(new Date());
        this.cqk.btg.setText(new bc().jO(getString(R.string.schedule).toUpperCase()).bM(new ForegroundColorSpan(getColor(R.color.grey_blue))).jO(String.format(" (%s)", new Object[]{format})).aCT());
        this.cqk.btf.setAdapter(new a(dVar, d, i2, z));
        this.cqk.getRoot().getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
            public boolean onPreDraw() {
                bw.this.cqk.getRoot().getViewTreeObserver().removeOnPreDrawListener(this);
                ((LayoutParams) bw.this.cqk.bjl.getLayoutParams()).topMargin = i;
                bw.this.cqk.bjl.requestLayout();
                return false;
            }
        });
        return this.cqk.getRoot();
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        IQApp.Dn().aE(new c().setValue(Boolean.valueOf(true)));
    }

    public boolean onClose() {
        requireFragmentManager().popBackStack();
        IQApp.Dn().aE(new c().setValue(Boolean.valueOf(false)));
        return true;
    }

    public void ND() {
        this.cqk.bjl.setAlpha(0.0f);
        float f = (float) (-getResources().getDimensionPixelOffset(R.dimen.dp12));
        this.cqk.bjl.setTranslationX(f);
        this.cqk.bjl.setTranslationY(f);
        this.cqk.bjl.setPivotX((float) this.cqk.bjl.getWidth());
        this.cqk.bjl.setPivotY(1.0f);
        this.cqk.bjl.setScaleX(0.3f);
        this.cqk.bjl.setScaleY(0.3f);
        this.cqk.bjl.animate().alpha(1.0f).scaleY(1.0f).scaleX(1.0f).translationX(0.0f).translationY(0.0f).setDuration(400).setListener(null).setInterpolator(com.iqoption.view.a.a.d.dEM).start();
    }

    public void NE() {
        this.cqk.bjl.setPivotX((float) this.cqk.bjl.getWidth());
        this.cqk.bjl.setPivotY(1.0f);
        this.cqk.bjl.animate().alpha(0.0f).scaleY(0.7f).scaleX(0.7f).setDuration(300).setInterpolator(com.iqoption.view.a.a.d.dEM).start();
    }
}
