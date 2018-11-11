package com.iqoption.fragment.rightpanel;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.common.b.e;
import com.iqoption.app.managers.af;
import com.iqoption.app.managers.tab.a.i;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.d.rx;
import com.iqoption.dto.entity.position.Order;
import com.iqoption.fragment.base.f;
import com.iqoption.fragment.bb;
import com.iqoption.system.a.d;
import com.iqoption.util.bf;
import com.iqoption.view.a.b;
import com.iqoption.x.R;
import java.lang.ref.WeakReference;
import java.text.DateFormat;

public final class RightPanelFragment extends f implements com.iqoption.view.a.b.a {
    private com.iqoption.core.microservices.tradingengine.response.active.a aiJ;
    private final y cEC = new y();
    private final a cHu = new a(this, null);
    private final DateFormat cHv = bf.dwI;
    private au cHw;
    private rx cHx;
    protected RightPanelViewModel cHy;
    private AnimatorSet cwf;

    public static final class a extends d {
        private final WeakReference<RightPanelFragment> ckC;

        /* synthetic */ a(RightPanelFragment rightPanelFragment, AnonymousClass1 anonymousClass1) {
            this(rightPanelFragment);
        }

        private a(RightPanelFragment rightPanelFragment) {
            this.ckC = new WeakReference(rightPanelFragment);
        }

        @e
        public void onCurrentActiveChanged(i iVar) {
            RightPanelFragment rightPanelFragment = (RightPanelFragment) this.ckC.get();
            if (rightPanelFragment != null && rightPanelFragment.isAdded()) {
                com.iqoption.core.d.a.aSe.execute(new av(rightPanelFragment));
            }
        }

        static final /* synthetic */ void b(RightPanelFragment rightPanelFragment) {
            com.iqoption.core.microservices.tradingengine.response.active.a Iw = com.iqoption.app.managers.tab.a.Il().Iw();
            if (Iw != null) {
                if (rightPanelFragment.getContext() != null) {
                    rightPanelFragment.z(Iw);
                }
                rightPanelFragment.x(Iw);
            }
        }
    }

    public void onTick(long j) {
        this.cHx.bBM.setText(this.cHv.format(this.cEC.bw(System.currentTimeMillis())));
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.cHx = (rx) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_right_panel, viewGroup, false);
        return this.cHx.getRoot();
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.cHy = RightPanelViewModel.T(this);
        com.iqoption.core.microservices.tradingengine.response.active.a Iw = com.iqoption.app.managers.tab.a.Il().Iw();
        if (Iw != null) {
            z(Iw);
            x(Iw);
        }
        this.cHu.register();
        b.aIK().a((com.iqoption.view.a.b.a) this);
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (this.cHw != null) {
            this.cHw.destroy();
        }
        this.cHu.unregister();
        b.aIK().b((com.iqoption.view.a.b.a) this);
    }

    public double UO() {
        return this.cHw.UO();
    }

    void x(com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
        this.aiJ = aVar;
        this.cHy.x(aVar);
    }

    private void z(@NonNull com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
        au auVar = this.cHw;
        if (A(aVar)) {
            this.cHw = B(aVar);
            a(auVar, this.cHw);
            return;
        }
        this.cHw.w(aVar);
    }

    private void a(au auVar, au auVar2) {
        final View f = auVar2.f(LayoutInflater.from(getContext()), this.cHx.bBN);
        this.cHx.bBN.addView(f);
        if (auVar != null) {
            final View childAt = this.cHx.bBN.getChildAt(this.cHx.bBN.getChildCount() - 2);
            ObjectAnimator.ofFloat(childAt, View.ALPHA, new float[]{0.0f}).addListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    f.setAlpha(0.0f);
                }

                public void onAnimationEnd(Animator animator) {
                    childAt.setVisibility(8);
                }
            });
            ObjectAnimator.ofFloat(f, View.ALPHA, new float[]{1.0f}).setInterpolator(com.iqoption.view.a.a.d.dEM);
            if (this.cwf != null) {
                this.cwf.cancel();
            }
            this.cwf = new AnimatorSet();
            com.iqoption.util.b.a(this.cwf, 500).setInterpolator(com.iqoption.view.a.a.d.dEM);
            this.cwf.playTogether(new Animator[]{r1, r9});
            this.cwf.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    RightPanelFragment.this.cHx.bBN.removeViewAt(0);
                    RightPanelFragment.this.cwf = null;
                }
            });
            this.cwf.start();
            auVar.destroy();
        }
    }

    public void resetDelegate() {
        au auVar = this.cHw;
        this.cHw = B(this.aiJ);
        a(auVar, this.cHw);
    }

    private boolean A(@NonNull com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
        boolean z = true;
        if (this.aiJ == null) {
            return true;
        }
        InstrumentType instrumentType = aVar.getInstrumentType();
        switch (this.aiJ.getInstrumentType()) {
            case TURBO_INSTRUMENT:
            case BINARY_INSTRUMENT:
                if (com.iqoption.util.e.a.G(this.aiJ) == com.iqoption.util.e.a.G(aVar) && (InstrumentType.TURBO_INSTRUMENT == instrumentType || InstrumentType.BINARY_INSTRUMENT == instrumentType)) {
                    z = false;
                }
                return z;
            case DIGITAL_INSTRUMENT:
                if (com.iqoption.util.e.a.G(this.aiJ) == com.iqoption.util.e.a.G(aVar) && instrumentType == this.aiJ.getInstrumentType()) {
                    z = false;
                }
                return z;
            case CRYPTO_INSTRUMENT:
            case CFD_INSTRUMENT:
            case FOREX_INSTRUMENT:
                if (com.iqoption.util.e.a.G(this.aiJ) == com.iqoption.util.e.a.G(aVar) && C(this.aiJ) == C(aVar) && (InstrumentType.CFD_INSTRUMENT == instrumentType || InstrumentType.FOREX_INSTRUMENT == instrumentType || InstrumentType.CRYPTO_INSTRUMENT == instrumentType)) {
                    z = false;
                }
                return z;
            default:
                if (instrumentType == this.aiJ.getInstrumentType()) {
                    z = false;
                }
                return z;
        }
    }

    private au B(@NonNull com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
        switch (aVar.getInstrumentType()) {
            case TURBO_INSTRUMENT:
            case BINARY_INSTRUMENT:
                if (com.iqoption.util.e.a.G(aVar)) {
                    return new b(this, aVar);
                }
                return new v(this, aVar);
            case DIGITAL_INSTRUMENT:
                if (com.iqoption.util.e.a.G(aVar)) {
                    return new ab(this);
                }
                return new v(this, aVar);
            case CRYPTO_INSTRUMENT:
            case CFD_INSTRUMENT:
            case FOREX_INSTRUMENT:
                if (com.iqoption.util.e.a.G(aVar)) {
                    return new j(this, aVar);
                }
                if (C(aVar)) {
                    return new g(this, aVar);
                }
                return new v(this, aVar);
            case FX_INSTRUMENT:
                if (com.iqoption.util.e.a.G(aVar)) {
                    return new af(this, aVar);
                }
                return new v(this, aVar);
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Active with type: ");
                stringBuilder.append(aVar.getInstrumentType());
                stringBuilder.append(" is not supported");
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    private boolean C(@NonNull com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
        return aVar.getInstrumentType() == InstrumentType.CFD_INSTRUMENT && D(aVar) && com.iqoption.app.managers.feature.a.eW(Order.ON_MKT_OPEN);
    }

    public void aod() {
        bb.a(zzakw(), zzakw().getSupportFragmentManager(), (int) R.id.fragment);
    }

    private boolean D(@NonNull com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
        return aVar.bb(af.Hu().Hw()) != Long.MAX_VALUE;
    }
}
