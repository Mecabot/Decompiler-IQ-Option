package com.iqoption.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.iqoption.app.managers.a.k;
import com.iqoption.app.managers.af;
import com.iqoption.app.managers.c;
import com.iqoption.app.managers.tab.a.g;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.d.ar;
import com.iqoption.dto.entity.expiration.Expiration;
import com.iqoption.mobbtech.connect.response.options.i;
import com.iqoption.util.bg;
import com.iqoption.util.l;
import com.iqoption.view.MultiAssetSpinner.d;
import com.iqoption.x.R;
import com.squareup.picasso.Picasso;
import java.lang.ref.WeakReference;

/* compiled from: AssetSpinner */
public class b extends com.iqoption.view.base.b implements com.iqoption.view.a.b.a {
    public ar dAt;
    private d dAu;
    private d dAv;
    private a dAw;
    private volatile boolean dAx;
    private com.iqoption.mobbtech.connect.response.options.b dAy;

    /* compiled from: AssetSpinner */
    private static class a implements com.iqoption.view.a.b.a {
        private final long dAB;
        private final long dAC;
        private final WeakReference<b> mViewRef;

        /* synthetic */ a(b bVar, long j, long j2, AnonymousClass1 anonymousClass1) {
            this(bVar, j, j2);
        }

        private a(b bVar, long j, long j2) {
            this.mViewRef = new WeakReference(bVar);
            this.dAB = j2;
            this.dAC = j;
        }

        public long getMaxValue() {
            return this.dAB;
        }

        public void onTick(long j) {
            b bVar = (b) this.mViewRef.get();
            if (bVar != null && bVar.aIN()) {
                bVar.dAt.blb.i(this.dAC - j, this.dAB);
                bVar.e(bVar.dAy);
            }
        }
    }

    public b(Context context) {
        this(context, null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dAx = false;
        aIa();
    }

    private void aIa() {
        this.dAt = (ar) DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.asset_spinner_handle, this, true);
        setOnTouchListener(new com.iqoption.view.d.d());
        setOnClickListener(new c(this));
        this.dAt.bkX.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (b.this.dAv != null) {
                    b.this.dAv.gS(b.this.getId());
                }
            }
        });
        this.dAt.aOV.setLayoutTransition(bg.aGE());
        this.dAt.bkW.setLayoutTransition(bg.aGE());
        this.dAt.bkZ.setLayoutTransition(bg.aGE());
    }

    final /* synthetic */ void bX(View view) {
        if (this.dAu != null) {
            this.dAu.gS(getId());
        }
    }

    public void aIb() {
        this.dAx = true;
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.asset_change_step1);
        loadAnimation.setAnimationListener(com.iqoption.view.a.a.a.a.c(new d(this)));
        this.dAt.bkZ.startAnimation(loadAnimation);
    }

    final /* synthetic */ void aIc() {
        if (aIN()) {
            g de = com.iqoption.app.managers.tab.a.Il().de(getId());
            if (de != null) {
                clearAnimation();
                com.iqoption.core.microservices.tradingengine.response.active.a a = com.iqoption.app.helpers.a.FI().a(Integer.valueOf(de.getActiveId()), de.getInstrumentType());
                if (a != null) {
                    if (!TextUtils.isEmpty(a.getImage())) {
                        Picasso.with(getContext()).load(a.getImage()).into(this.dAt.bkT);
                    }
                    this.dAt.bkU.setText(com.iqoption.util.e.a.s(a));
                }
                this.dAx = false;
                e(this.dAy);
                this.dAt.bkZ.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.asset_change_step2));
            }
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.iqoption.view.a.b.aIK().a((com.iqoption.view.a.b.a) this, Integer.valueOf(5));
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.iqoption.view.a.b.aIK().b((com.iqoption.view.a.b.a) this);
        if (this.dAw != null) {
            com.iqoption.view.a.b.aIK().b(this.dAw);
            this.dAw = null;
        }
    }

    private boolean a(long j, com.iqoption.core.microservices.tradingengine.response.active.a aVar, com.iqoption.mobbtech.connect.response.options.b bVar, Expiration expiration) {
        if (j <= expiration.expValue.longValue() - k.HB().c(aVar, expiration) || j >= expiration.expValue.longValue()) {
            return false;
        }
        return c.Gn().b(new i(Long.valueOf(expiration.expValue.longValue() / 1000), bVar.activeId, bVar.instrumentType)) ^ 1;
    }

    public void e(com.iqoption.mobbtech.connect.response.options.b bVar) {
        this.dAy = bVar;
        if (this.dAx) {
            this.dAy = bVar;
            return;
        }
        g de = com.iqoption.app.managers.tab.a.Il().de(getId());
        if (de != null) {
            com.iqoption.core.microservices.tradingengine.response.active.a aVar;
            if (bVar == null) {
                aVar = null;
            } else {
                aVar = com.iqoption.app.helpers.a.FI().a(bVar.activeId, bVar.instrumentType);
            }
            com.iqoption.core.microservices.tradingengine.response.active.a aVar2 = aVar;
            Object obj = (aVar2 == null || !aVar2.isExpired()) ? null : 1;
            Expiration IO = de.IO();
            if (bVar == null || obj == null) {
                s(de);
            } else {
                long c;
                if (com.iqoption.core.ext.c.b(bVar.instrumentType, InstrumentType.CFD_INSTRUMENT, InstrumentType.FOREX_INSTRUMENT, InstrumentType.CRYPTO_INSTRUMENT)) {
                    if (a(af.Hu().Hw(), aVar2, bVar, IO)) {
                        c = k.HB().c(aVar2, IO);
                    } else {
                        s(de);
                        return;
                    }
                }
                c = (bVar.expTime.longValue() - bVar.getCreated().longValue()) * 1000;
                if (!(this.dAt.bla.getNextView().getId() == this.dAt.bkT.getId() && this.dAw != null && c == this.dAw.getMaxValue())) {
                    this.dAt.blb.reset();
                    if (this.dAw != null) {
                        com.iqoption.view.a.b.aIK().b(this.dAw);
                    }
                    this.dAw = new a(this, bVar.expTime.longValue() * 1000, c, null);
                    com.iqoption.view.a.b.aIK().a(this.dAw);
                    if (this.dAt.bla.getNextView().getId() != this.dAt.bkT.getId()) {
                        this.dAt.bla.showNext();
                    }
                }
                CharSequence r = l.r(bVar.avk());
                if (this.dAt.bkS.getVisibility() == 0) {
                    this.dAt.bkV.setText(com.iqoption.util.e.a.O(de.getInstrumentType()));
                    this.dAt.bkV.setTextColor(ContextCompat.getColor(getContext(), R.color.grey_blur_50));
                } else {
                    this.dAt.bkV.setText(r);
                    if (bVar.avk().intValue() == 0) {
                        this.dAt.bkV.setTextColor(ContextCompat.getColor(getContext(), R.color.grey_blur_50));
                    } else {
                        this.dAt.bkV.setTextColor(ContextCompat.getColor(getContext(), R.color.green));
                    }
                }
            }
        }
    }

    private void s(g gVar) {
        this.dAt.bkV.setText(com.iqoption.util.e.a.O(gVar.getInstrumentType()));
        this.dAt.bkV.setTextColor(ContextCompat.getColor(getContext(), R.color.grey_blur_50));
        if (this.dAt.bla.getNextView().getId() == this.dAt.bkT.getId()) {
            this.dAt.bla.showNext();
            com.iqoption.view.a.b.aIK().b(this.dAw);
            this.dAw = null;
            this.dAt.blb.reset();
        }
    }

    public void setClickView(d dVar) {
        this.dAu = dVar;
    }

    public void setClickCloseView(d dVar) {
        this.dAv = dVar;
    }

    public void fe(boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TAB id = ");
        stringBuilder.append(getId());
        stringBuilder.append(" unselect");
        com.iqoption.core.i.d(stringBuilder.toString());
        setTag("unselect");
        int dimensionPixelSize;
        LayoutParams layoutParams;
        if (z) {
            this.dAt.bkW.setLayoutParams(new FrameLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.dp70), -1));
            this.dAt.bkZ.setOrientation(1);
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dp18);
            LayoutParams layoutParams2 = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
            layoutParams2.setMargins(0, 0, 0, 0);
            layoutParams2.gravity = 1;
            this.dAt.bla.setLayoutParams(layoutParams2);
            layoutParams = new LinearLayout.LayoutParams(-2, -2, 0.0f);
            layoutParams.gravity = 17;
            this.dAt.aOV.setLayoutParams(layoutParams);
            this.dAt.bkU.setTextSize(0, (float) getResources().getDimensionPixelSize(R.dimen.sp9));
            this.dAt.blb.setTextSize((float) getResources().getDimensionPixelSize(R.dimen.sp6));
            this.dAt.bkV.setVisibility(8);
        } else {
            this.dAt.bkW.setLayoutParams(new FrameLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.dp100), -1));
            this.dAt.bkZ.setOrientation(0);
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dp5);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.dp10);
            int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.dp24);
            LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimensionPixelSize3, dimensionPixelSize3);
            layoutParams3.setMargins(dimensionPixelSize2, 0, dimensionPixelSize, 0);
            this.dAt.bla.setLayoutParams(layoutParams3);
            layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
            layoutParams.gravity = 17;
            this.dAt.aOV.setLayoutParams(layoutParams);
            this.dAt.bkU.setTextSize(0, (float) getResources().getDimensionPixelSize(R.dimen.sp12));
            this.dAt.blb.setTextSize((float) getResources().getDimensionPixelSize(R.dimen.sp8));
            this.dAt.bkV.setVisibility(0);
        }
        setSelected(false);
        this.dAt.bkS.setVisibility(8);
        this.dAt.bkX.setVisibility(8);
        this.dAt.bkY.setVisibility(8);
        this.dAt.bkW.setBackgroundColor(Color.parseColor("#001d2539"));
        e(this.dAy);
    }

    public void ff(boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TAB id = ");
        stringBuilder.append(getId());
        stringBuilder.append(" select");
        com.iqoption.core.i.d(stringBuilder.toString());
        setTag("select");
        this.dAt.bkW.setLayoutParams(new FrameLayout.LayoutParams(getResources().getDimensionPixelSize(z ? R.dimen.dp100 : R.dimen.dp130), -1));
        this.dAt.bkW.setBackgroundColor(Color.parseColor("#1d2539"));
        this.dAt.bkZ.setOrientation(0);
        this.dAt.bkS.setVisibility(0);
        this.dAt.bkX.setVisibility(z ? 8 : 0);
        this.dAt.bkY.setVisibility(0);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dp5);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.dp10);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.dp24);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize3, dimensionPixelSize3);
        layoutParams.setMargins(dimensionPixelSize2, 0, dimensionPixelSize, 0);
        this.dAt.bla.setLayoutParams(layoutParams);
        LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams2.gravity = 17;
        this.dAt.aOV.setLayoutParams(layoutParams2);
        this.dAt.bkU.setTextSize(0, (float) getResources().getDimensionPixelSize(R.dimen.sp12));
        this.dAt.blb.setTextSize((float) getResources().getDimensionPixelSize(R.dimen.sp8));
        this.dAt.bkV.setVisibility(0);
        e(this.dAy);
    }

    public void onTick(long j) {
        if (aIN() && this.dAw == null) {
            e(this.dAy);
        }
    }
}
