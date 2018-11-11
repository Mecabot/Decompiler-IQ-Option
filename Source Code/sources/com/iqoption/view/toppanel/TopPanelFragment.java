package com.iqoption.view.toppanel;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.DimenRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.google.common.b.e;
import com.iqoption.app.managers.c;
import com.iqoption.app.managers.tab.a.g;
import com.iqoption.app.managers.tab.a.i;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.d.akw;
import com.iqoption.dto.entity.position.Position;
import com.iqoption.fragment.base.f;
import com.iqoption.fragment.cr;
import com.iqoption.gl.NativeHandler.o;
import com.iqoption.mobbtech.connect.response.ArrayBuybackResponse;
import com.iqoption.mobbtech.connect.response.options.OptionEvents;
import com.iqoption.mobbtech.connect.response.options.OptionEvents.h;
import com.iqoption.mobbtech.connect.response.options.OptionEvents.j;
import com.iqoption.mobbtech.connect.response.options.OptionEvents.k;
import com.iqoption.mobbtech.connect.response.options.OptionEvents.m;
import com.iqoption.system.a.d;
import com.iqoption.x.R;
import java.lang.ref.WeakReference;
import java.util.Iterator;

public class TopPanelFragment extends f implements com.iqoption.fragment.dialog.d.a {
    private AnimatorSet cwf;
    private Position dJX;
    private SparseArray<Integer> dKA = new SparseArray();
    private Runnable dKB = new Runnable() {
        public void run() {
            if (TopPanelFragment.this.isAdded()) {
                cr ajW = TopPanelFragment.this.ajW();
                if (ajW != null) {
                    ajW.crz.f(-TopPanelFragment.this.hq(R.dimen.dp32), 200);
                    ajW.crQ.f(TopPanelFragment.this.hq(R.dimen.dp48), 200);
                }
                TopPanelFragment.this.dKu.axh.startAnimation(TopPanelFragment.this.dKv);
            }
        }
    };
    private Runnable dKC = new Runnable() {
        public void run() {
            if (TopPanelFragment.this.isAdded()) {
                cr ajW = TopPanelFragment.this.ajW();
                if (ajW != null) {
                    ajW.crz.f(TopPanelFragment.this.hq(R.dimen.dp32), 200);
                    ajW.crQ.f(TopPanelFragment.this.hq(R.dimen.dp80), 200);
                }
                TopPanelFragment.this.dKz.setVisibility(0);
                TopPanelFragment.this.dKu.axh.startAnimation(TopPanelFragment.this.dKw);
            }
        }
    };
    private b dKD = new b(this, null);
    private com.iqoption.mobbtech.connect.response.options.b dKf;
    private a dKt = new a(this, null);
    private akw dKu;
    private Animation dKv;
    private Animation dKw;
    private final SparseArray<String> dKx = new SparseArray();
    private e dKy;
    private View dKz;
    private boolean isVisible;

    private static class b implements com.iqoption.view.a.b.a {
        private final WeakReference<TopPanelFragment> ckC;

        /* synthetic */ b(TopPanelFragment topPanelFragment, AnonymousClass1 anonymousClass1) {
            this(topPanelFragment);
        }

        private b(TopPanelFragment topPanelFragment) {
            this.ckC = new WeakReference(topPanelFragment);
        }

        public void onTick(long j) {
            TopPanelFragment topPanelFragment = (TopPanelFragment) this.ckC.get();
            if (topPanelFragment != null && topPanelFragment.isAdded()) {
                topPanelFragment.bj(j);
            }
        }
    }

    private static class a extends d {
        private final WeakReference<TopPanelFragment> ckC;

        /* synthetic */ a(TopPanelFragment topPanelFragment, AnonymousClass1 anonymousClass1) {
            this(topPanelFragment);
        }

        private a(TopPanelFragment topPanelFragment) {
            this.ckC = new WeakReference(topPanelFragment);
        }

        @e
        public void onTabChangedEvent(i iVar) {
            com.iqoption.core.i.d("short= onTabChngedEvent");
            if (this.ckC.get() != null || ((TopPanelFragment) this.ckC.get()).isAdded()) {
                com.iqoption.core.d.a.aSe.execute(new i(this));
            }
        }

        final /* synthetic */ void aKp() {
            TopPanelFragment topPanelFragment = (TopPanelFragment) this.ckC.get();
            if (topPanelFragment != null && topPanelFragment.isAdded()) {
                g IC = com.iqoption.app.managers.tab.a.Il().IC();
                if (IC != null) {
                    topPanelFragment.a(c.Gn().a(IC.getOptionKey()), IC.IQ());
                }
            }
        }

        @e
        public void changeExpirationEvent(com.iqoption.app.managers.a.k.a aVar) {
            com.iqoption.core.i.d("short= changeExpirationEvent");
            if ((this.ckC.get() != null || ((TopPanelFragment) this.ckC.get()).isAdded()) && aVar.aoq == com.iqoption.app.managers.tab.a.Il().ID()) {
                com.iqoption.core.d.a.aSe.execute(new j(this, aVar));
            }
        }

        final /* synthetic */ void d(com.iqoption.app.managers.a.k.a aVar) {
            TopPanelFragment topPanelFragment = (TopPanelFragment) this.ckC.get();
            if (topPanelFragment != null && topPanelFragment.isAdded()) {
                topPanelFragment.a(c.Gn().a(aVar.optionKey), aVar.aop.getDigitalExpirationPeriod());
            }
        }

        @e
        public void onOpenOptionGroups(m mVar) {
            com.iqoption.core.i.d("short= onOpenOptionGroups");
            if (this.ckC.get() != null || ((TopPanelFragment) this.ckC.get()).isAdded()) {
                com.iqoption.core.d.a.aSe.execute(new k(this));
            }
        }

        final /* synthetic */ void aKo() {
            TopPanelFragment topPanelFragment = (TopPanelFragment) this.ckC.get();
            if (topPanelFragment != null && topPanelFragment.isAdded()) {
                topPanelFragment.h(null);
            }
        }

        @e
        public void onOpenOptionGroupRemoved(k kVar) {
            com.iqoption.core.i.d("short= onOpenOptionGroupRemoved1");
            if (this.ckC.get() != null || ((TopPanelFragment) this.ckC.get()).isAdded() || ((TopPanelFragment) this.ckC.get()).dKf != null) {
                com.iqoption.core.d.a.aSe.execute(new l(this));
            }
        }

        final /* synthetic */ void aKn() {
            TopPanelFragment topPanelFragment = (TopPanelFragment) this.ckC.get();
            if (topPanelFragment != null && topPanelFragment.isAdded()) {
                g IC = com.iqoption.app.managers.tab.a.Il().IC();
                if (IC != null) {
                    topPanelFragment.a(c.Gn().a(IC.getOptionKey()), IC.IQ());
                }
            }
        }

        @e
        public void onOpenOptionGroupOptionRemoved(j jVar) {
            com.iqoption.core.i.d("short= OpenOptionGroupOptionRemoved");
            if (this.ckC.get() != null || ((TopPanelFragment) this.ckC.get()).isAdded() || ((TopPanelFragment) this.ckC.get()).dKf != null) {
                com.iqoption.core.d.a.aSe.execute(new m(this));
            }
        }

        final /* synthetic */ void aKm() {
            TopPanelFragment topPanelFragment = (TopPanelFragment) this.ckC.get();
            if (topPanelFragment != null && topPanelFragment.isAdded()) {
                g IC = com.iqoption.app.managers.tab.a.Il().IC();
                if (IC != null) {
                    topPanelFragment.a(c.Gn().a(IC.getOptionKey()), IC.IQ());
                }
            }
        }

        @e
        public void onOpenOptionGroupOptionAdded(OptionEvents.i iVar) {
            com.iqoption.core.i.d("short= OpenOptionGroupOptionAdded");
            if (this.ckC.get() != null || ((TopPanelFragment) this.ckC.get()).isAdded()) {
                com.iqoption.core.d.a.aSe.execute(new n(this));
            }
        }

        final /* synthetic */ void aKl() {
            TopPanelFragment topPanelFragment = (TopPanelFragment) this.ckC.get();
            if (topPanelFragment != null && topPanelFragment.isAdded()) {
                g IC = com.iqoption.app.managers.tab.a.Il().IC();
                if (IC != null) {
                    topPanelFragment.a(c.Gn().a(IC.getOptionKey()), IC.IQ());
                }
            }
        }

        @e
        public void onNewOpenOptionGroup(h hVar) {
            if (this.ckC.get() != null || ((TopPanelFragment) this.ckC.get()).isAdded()) {
                com.iqoption.core.d.a.aSe.execute(new o(this));
            }
        }

        final /* synthetic */ void aKk() {
            TopPanelFragment topPanelFragment = (TopPanelFragment) this.ckC.get();
            if (topPanelFragment != null && topPanelFragment.isAdded()) {
                g IC = com.iqoption.app.managers.tab.a.Il().IC();
                if (IC != null) {
                    topPanelFragment.a(c.Gn().a(IC.getOptionKey()), IC.IQ());
                }
            }
        }

        @e
        public void onSellResponse(com.iqoption.mobbtech.connect.request.api.a.c.b bVar) {
            com.iqoption.core.d.a.aSe.execute(new p(this, bVar));
        }

        @e
        public void onBuybackResponse(ArrayBuybackResponse arrayBuybackResponse) {
            com.iqoption.core.i.d("short= onBuybackResponse");
            com.iqoption.core.d.a.aSe.execute(new q(this));
        }

        final /* synthetic */ void aKj() {
            TopPanelFragment topPanelFragment = (TopPanelFragment) this.ckC.get();
            if (topPanelFragment != null && topPanelFragment.isAdded() && topPanelFragment.dKy != null) {
                topPanelFragment.dKy.fr(false);
            }
        }

        @e
        public void onSelectTradingPosition(o oVar) {
            com.iqoption.core.i.d("short=onSelectTradingPosition");
            com.iqoption.core.d.a.aSe.execute(new r(this, oVar));
        }
    }

    private boolean c(@NonNull com.iqoption.mobbtech.connect.response.options.b bVar, Position position) {
        return true;
    }

    public void air() {
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.dKu = (akw) DataBindingUtil.inflate(layoutInflater, R.layout.top_panel, viewGroup, false);
        this.dKz = this.dKu.getRoot();
        return this.dKz;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.dKz.setVisibility(8);
        this.dKv = AnimationUtils.loadAnimation(getContext(), R.anim.appear_from_top_to_bottom_alpha_hide);
        this.dKv.setDuration(200);
        this.dKv.setAnimationListener(com.iqoption.view.a.a.a.a.c(new h(this)));
        this.dKw = AnimationUtils.loadAnimation(getContext(), R.anim.appear_from_top_to_bottom_alpha_show);
        this.dKw.setDuration(200);
        this.dKt.register();
        startTimer();
    }

    final /* synthetic */ void aKi() {
        this.dKz.clearAnimation();
        this.dKz.setVisibility(8);
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (this.dKy != null) {
            this.dKy.destroy();
        }
        this.dKt.unregister();
        afr();
    }

    public void bj(long j) {
        if (this.dKz.getVisibility() == 0 && this.dKy != null) {
            this.dKy.cw(j);
        }
    }

    private int hq(@DimenRes int i) {
        Integer num = (Integer) this.dKA.get(i);
        if (num == null) {
            num = Integer.valueOf(ef(i));
            this.dKA.put(i, num);
        }
        return num.intValue();
    }

    private void hide() {
        if (isAdded() && this.isVisible) {
            this.isVisible = false;
            this.dKu.axh.post(this.dKB);
        }
    }

    private void show() {
        if (isAdded() && !this.isVisible) {
            this.isVisible = true;
            this.dKu.axh.post(this.dKC);
        }
    }

    public void h(com.iqoption.mobbtech.connect.response.options.b bVar) {
        a(bVar, com.iqoption.app.managers.tab.a.Il().Iy());
    }

    public void a(com.iqoption.mobbtech.connect.response.options.b bVar, long j) {
        bVar = b(bVar, j);
        Position position = null;
        if (bVar == null) {
            hide();
        } else {
            switch (bVar.instrumentType) {
                case CFD_INSTRUMENT:
                case FOREX_INSTRUMENT:
                case CRYPTO_INSTRUMENT:
                case FX_INSTRUMENT:
                case DIGITAL_INSTRUMENT:
                    position = i(bVar);
                    break;
            }
            b(bVar, position);
            show();
        }
        this.dKf = bVar;
        this.dJX = position;
    }

    private com.iqoption.mobbtech.connect.response.options.b b(com.iqoption.mobbtech.connect.response.options.b bVar, long j) {
        return (bVar == null || InstrumentType.DIGITAL_INSTRUMENT != bVar.instrumentType) ? bVar : bVar.bH(j);
    }

    private void b(@NonNull com.iqoption.mobbtech.connect.response.options.b bVar, Position position) {
        e eVar = this.dKy;
        if (c(bVar, position)) {
            this.dKy = d(bVar, position);
            View f = this.dKy.f(LayoutInflater.from(getContext()), this.dKu.axh);
            this.dKu.axh.addView(f);
            if (eVar != null) {
                View childAt = this.dKu.axh.getChildAt(this.dKu.axh.getChildCount() - 2);
                boolean z = (this.dJX == null && position == null) ? false : true;
                a(childAt, f, z).start();
                eVar.destroy();
                return;
            }
            return;
        }
        this.dKy.a(bVar, position);
    }

    private e d(@NonNull com.iqoption.mobbtech.connect.response.options.b bVar, Position position) {
        switch (bVar.instrumentType) {
            case CFD_INSTRUMENT:
            case FOREX_INSTRUMENT:
            case CRYPTO_INSTRUMENT:
                if (position != null) {
                    return new a(this, bVar, position);
                }
                return new b(this, bVar);
            case FX_INSTRUMENT:
            case DIGITAL_INSTRUMENT:
                if (position == null) {
                    return new f(this, bVar);
                }
                return new f(this, bVar.n(position));
            case TURBO_INSTRUMENT:
            case BINARY_INSTRUMENT:
                return new f(this, bVar);
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Active with type: ");
                stringBuilder.append(bVar.instrumentType);
                stringBuilder.append(" is not supported");
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    private AnimatorSet a(View view, View view2, boolean z) {
        Animator ofPropertyValuesHolder;
        Animator ofPropertyValuesHolder2;
        if (this.cwf != null) {
            this.cwf.cancel();
        }
        if (z) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dp22);
            PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[4];
            propertyValuesHolderArr[0] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f, 1.0f});
            propertyValuesHolderArr[1] = PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{0.95f, 1.0f});
            propertyValuesHolderArr[2] = PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{0.95f, 1.0f});
            propertyValuesHolderArr[3] = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{(float) (dimensionPixelSize * 2), 0.0f});
            ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view2, propertyValuesHolderArr);
            r4 = new PropertyValuesHolder[4];
            r4[0] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f});
            r4[1] = PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{0.95f});
            r4[2] = PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{0.95f});
            r4[3] = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{(float) (dimensionPixelSize / 2)});
            ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(view, r4);
        } else {
            ofPropertyValuesHolder2 = ObjectAnimator.ofFloat(view, View.ALPHA, new float[]{0.0f});
            ofPropertyValuesHolder = ObjectAnimator.ofFloat(view2, View.ALPHA, new float[]{1.0f});
        }
        ofPropertyValuesHolder.setInterpolator(com.iqoption.view.a.a.d.aQV);
        ofPropertyValuesHolder2.setInterpolator(com.iqoption.view.a.a.d.aQW);
        this.cwf = new AnimatorSet();
        this.cwf.playTogether(new Animator[]{ofPropertyValuesHolder2, ofPropertyValuesHolder});
        com.iqoption.util.b.a(this.cwf, 500);
        this.cwf.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                TopPanelFragment.this.dKu.axh.removeViewAt(0);
                TopPanelFragment.this.cwf = null;
            }
        });
        return this.cwf;
    }

    public void o(com.iqoption.mobbtech.connect.response.options.e eVar) {
        if (this.dKy != null && (this.dKy instanceof d)) {
            ((d) this.dKy).x(eVar);
        }
    }

    public void b(com.iqoption.mobbtech.connect.response.options.b bVar) {
        if (this.dKy != null && (this.dKy instanceof c)) {
            ((c) this.dKy).f(bVar);
        }
    }

    private Position i(com.iqoption.mobbtech.connect.response.options.b bVar) {
        String str = (String) this.dKx.get(com.iqoption.app.managers.tab.a.Il().ID());
        if (!(TextUtils.isEmpty(str) || bVar == null)) {
            Iterator sI = bVar.avh().iterator();
            while (sI.hasNext()) {
                Position position = (Position) ((com.iqoption.mobbtech.connect.response.options.e) sI.next());
                if (position.getPositionSplitId().equals(str)) {
                    return position;
                }
            }
        }
        return null;
    }

    private void startTimer() {
        com.iqoption.view.a.b.aIK().a(this.dKD, Integer.valueOf(5));
    }

    private void afr() {
        com.iqoption.view.a.b.aIK().b(this.dKD);
    }
}
