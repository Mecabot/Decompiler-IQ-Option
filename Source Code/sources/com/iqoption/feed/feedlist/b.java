package com.iqoption.feed.feedlist;

import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.iqoption.core.microservices.feed.response.c;
import com.iqoption.util.l;
import com.iqoption.view.a.b.a;
import com.iqoption.x.R;
import java.util.Locale;

/* compiled from: ContentViewHolder */
public abstract class b extends i implements a {
    private final int ahg;
    private final int ahh;
    private final int aup;
    @Nullable
    private LottieAnimationView bzi;
    private final a clw = new c(this);
    private final d.a cmv;
    @Nullable
    protected e cmw;
    private boolean cmx = false;

    @NonNull
    protected abstract ViewGroup agp();

    @NonNull
    protected abstract TextView agq();

    @NonNull
    protected abstract TextView agr();

    public b(View view, d.a aVar) {
        super(view);
        this.aup = ContextCompat.getColor(view.getContext(), R.color.grey_blur);
        this.cmv = aVar;
        this.ahh = ContextCompat.getColor(view.getContext(), R.color.red);
        this.ahg = ContextCompat.getColor(view.getContext(), R.color.green);
    }

    @CallSuper
    public void i(e eVar) {
        if (this.cmw != eVar) {
            this.cmw = eVar;
            agm();
        }
    }

    protected void a(final e eVar, final LottieAnimationView lottieAnimationView, TextView textView) {
        final com.iqoption.core.microservices.feed.response.a ags = eVar.ags();
        textView.setTextColor(ags.VS() ? -1 : this.aup);
        this.bzi = lottieAnimationView;
        OnClickListener anonymousClass1 = new com.iqoption.view.d.b() {
            public void q(View view) {
                if (!((!b.this.bzi.isAnimating() && !b.this.cmv.h(eVar)) || ags.VS() || b.this.bzi.isAnimating())) {
                    lottieAnimationView.setProgress(0.0f);
                    lottieAnimationView.cT();
                }
            }
        };
        textView.setOnClickListener(anonymousClass1);
        this.bzi.setOnClickListener(anonymousClass1);
        if (!this.bzi.isAnimating()) {
            this.bzi.setProgress(ags.VS() ? 1.0f : 0.0f);
        }
    }

    protected void e(TextView textView, int i) {
        if (i == 0) {
            textView.setText(R.string.like_it);
            return;
        }
        textView.setText(this.itemView.getContext().getString(R.string.like_it_n1, new Object[]{String.valueOf(i)}));
    }

    protected void agk() {
        if (!Lg()) {
            agl();
        }
    }

    protected void agl() {
        c VT = this.cmw.ags().VT();
        if (VT != null) {
            a(VT);
        }
    }

    public void recycle() {
        if (this.bzi != null) {
            this.bzi.cV();
            this.bzi.setProgress(0.0f);
        }
        agm();
    }

    private void agm() {
        a(null);
    }

    private void a(@Nullable c cVar) {
        this.cmx = cVar != null;
        com.iqoption.core.microservices.tradingengine.response.active.a a = cVar != null ? com.iqoption.app.helpers.a.FI().a(Integer.valueOf(cVar.VU()), cVar.getInstrumentType()) : null;
        com.iqoption.view.a.b.aIK().b(this.clw);
        ViewGroup agp = agp();
        if (a != null) {
            com.iqoption.view.a.b.aIK().a(this.clw);
            TextView agq = agq();
            String s = com.iqoption.util.e.a.s(a);
            switch (cVar.getAction()) {
                case 1:
                    agq.setTextColor(this.ahg);
                    agq.setText(this.itemView.getResources().getString(R.string.buy_n1, new Object[]{s}));
                    agp.setBackgroundResource(R.drawable.micro_buy_feed_bg);
                    break;
                case 2:
                    agq.setTextColor(this.ahh);
                    agq.setText(this.itemView.getResources().getString(R.string.sell_n1, new Object[]{s}));
                    agp.setBackgroundResource(R.drawable.micro_sell_feed_bg);
                    break;
                default:
                    agq.setTextColor(this.ahg);
                    agq.setText(this.itemView.getResources().getString(R.string.trade_n1, new Object[]{s}));
                    agp.setBackgroundResource(R.drawable.micro_buy_feed_bg);
                    break;
            }
            agp.setVisibility(0);
            agp.setOnClickListener(new com.iqoption.view.d.b() {
                public void q(View view) {
                    if (b.this.cmw.ags().VT() != null) {
                        b.this.cmv.g(b.this.cmw.ags());
                    }
                }
            });
            ago();
            return;
        }
        agp.setVisibility(8);
    }

    private boolean agn() {
        return this.cmw.ags().VT() != null;
    }

    private void ago() {
        if (agn()) {
            TextView agr = agr();
            c VT = this.cmw.ags().VT();
            com.iqoption.core.microservices.f.a.a.a a = com.iqoption.app.helpers.a.FI().a(VT.VU(), VT.getInstrumentType());
            if (a == null) {
                agr.setText("");
            } else if (a.WZ().isValid() && a.WW().isValid()) {
                double doubleValue;
                Object format;
                CharSequence G = l.G(a.WZ().getValue().doubleValue() + (a.WW().getValue().doubleValue() / 2.0d));
                String str = "";
                if (a.WY().isValid()) {
                    doubleValue = a.WY().getValue().doubleValue();
                    if (doubleValue >= 0.0d) {
                        format = String.format(Locale.US, "(+%.2f%%)", new Object[]{Double.valueOf(doubleValue)});
                    } else {
                        format = String.format(Locale.US, "(%.2f%%)", new Object[]{Double.valueOf(doubleValue)});
                    }
                } else {
                    format = str;
                    doubleValue = 0.0d;
                }
                if (TextUtils.isEmpty(format)) {
                    agr.setText(G);
                } else {
                    CharSequence spannableString = new SpannableString(String.format(Locale.US, "%s %s", new Object[]{G, format}));
                    int i = this.ahh;
                    if (doubleValue >= 0.0d) {
                        i = this.ahg;
                    }
                    spannableString.setSpan(new ForegroundColorSpan(i), spannableString.toString().indexOf(format), spannableString.length(), 17);
                    agr.setText(spannableString);
                }
            } else {
                agr.setText("");
            }
        }
    }

    public boolean agi() {
        return this.cmx;
    }
}
