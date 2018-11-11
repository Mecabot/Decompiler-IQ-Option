package com.iqoption.fragment;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.TabLayout.Tab;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import com.google.common.b.e;
import com.iqoption.a.a.d;
import com.iqoption.analytics.EventManager;
import com.iqoption.app.IQApp;
import com.iqoption.app.managers.a.k;
import com.iqoption.app.managers.a.k.f;
import com.iqoption.app.managers.tab.a.g;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.util.i;
import com.iqoption.core.util.n;
import com.iqoption.d.kn;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;
import com.iqoption.dto.entity.expiration.Expiration;
import com.iqoption.dto.entity.strike.Strike;
import com.iqoption.util.ax;
import com.iqoption.util.bg;
import com.iqoption.x.R;
import java.lang.ref.WeakReference;

/* compiled from: DigitalExpirationFragment */
public class at extends com.iqoption.fragment.base.b {
    private Builder adT;
    private kn cpd;
    private b cpe = new b(this, null);
    private com.iqoption.a.a.b cpf;
    private d cpg;
    private a cph = new a(this, null);

    /* compiled from: DigitalExpirationFragment */
    private static class a implements com.iqoption.view.a.b.a {
        private final WeakReference<at> aiy;

        /* synthetic */ a(at atVar, AnonymousClass1 anonymousClass1) {
            this(atVar);
        }

        private a(at atVar) {
            this.aiy = new WeakReference(atVar);
        }

        public void onTick(long j) {
            at atVar = (at) this.aiy.get();
            if (atVar != null && atVar.cpg != null) {
                atVar.cpg.notifyDataSetChanged();
            }
        }
    }

    /* compiled from: DigitalExpirationFragment */
    private static class b extends com.iqoption.system.a.d {
        private final WeakReference<at> ckC;
        private volatile com.iqoption.app.managers.a.k.a cpl;

        /* synthetic */ b(at atVar, AnonymousClass1 anonymousClass1) {
            this(atVar);
        }

        private b(at atVar) {
            this.ckC = new WeakReference(atVar);
        }

        @e
        public void changeExpirationEvent(com.iqoption.app.managers.a.k.a aVar) {
            if ((this.ckC.get() != null || ((at) this.ckC.get()).isAdded()) && aVar.aoq == com.iqoption.app.managers.tab.a.Il().ID()) {
                com.iqoption.core.d.a.aSe.execute(new ax(this, aVar));
            }
        }

        @e
        public void onUpdateExpirationEvent(f fVar) {
            if (this.ckC.get() != null || ((at) this.ckC.get()).isAdded()) {
                com.iqoption.core.d.a.aSe.execute(new Runnable() {
                    public void run() {
                        at atVar = (at) b.this.ckC.get();
                        if (atVar != null && atVar.isAdded() && atVar.cpf != null) {
                            atVar.cpf.dataSetChanged();
                        }
                    }
                });
            }
        }

        @e
        public void onRemoveExpirationEvent(k.e eVar) {
            if (this.ckC.get() != null || ((at) this.ckC.get()).isAdded()) {
                com.iqoption.core.d.a.aSe.execute(new Runnable() {
                    public void run() {
                        at atVar = (at) b.this.ckC.get();
                        if (atVar != null && atVar.isAdded()) {
                            if (atVar.cpf != null) {
                                atVar.cpf.dataSetChanged();
                            }
                            if (atVar.cpg != null) {
                                atVar.cpg.dataSetChanged();
                            }
                        }
                    }
                });
            }
        }
    }

    public long NF() {
        return 400;
    }

    public long NG() {
        return 250;
    }

    private static at ahr() {
        return new at();
    }

    public static void a(FragmentManager fragmentManager, @IdRes int i) {
        fragmentManager.beginTransaction().add(i, ahr(), "DigitalExpirationFragment").addToBackStack("DigitalExpirationFragment").commit();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cpd = (kn) DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.digital_expiration_fragment, viewGroup, false);
        this.cpd.a(this);
        return this.cpd.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        this.cpd.bvl.setLayoutTransition(bg.aGE());
        this.cpf = new com.iqoption.a.a.b(new com.iqoption.a.b.a() {
            public void a(View view, int i) {
                if (i >= 0 && i < at.this.cpf.getItemCount() && at.this.cpf.getItemCount() > 0) {
                    Expiration cz = at.this.cpf.cz(i);
                    com.iqoption.app.managers.tab.a.Il().d(cz);
                    at.this.cpg.dataSetChanged();
                    EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "traderoom_expiration-options-choose-time").setValue(Double.valueOf(cz.expValue.doubleValue())).setParameters(i.ZZ().l("instrument_type", InstrumentType.DIGITAL_INSTRUMENT).aab()).build());
                }
            }
        });
        this.cpd.bvk.setAdapter(this.cpf);
        this.cpd.bvk.addItemDecoration(new com.iqoption.view.stickyheadersrecyclerview.d(this.cpf));
        this.cpd.bvk.setHasFixedSize(true);
        this.cpg = new d(new au(this), new av(this));
        this.cpd.bvq.setAdapter(this.cpg);
        this.cpd.bvq.setHasFixedSize(true);
        this.cpg.dataSetChanged();
        this.cpd.bvi.setOnCheckedChangeListener(new aw(this));
        final g IC = com.iqoption.app.managers.tab.a.Il().IC();
        if (IC != null && IC.apw.Ie()) {
            this.cpd.bvi.setVisibility(8);
            this.cpd.bvp.setVisibility(0);
            this.cpd.bvo.setVisibility(0);
            this.cpd.bvo.addOnTabSelectedListener(new n() {
                public void onTabSelected(Tab tab) {
                    switch (tab.getPosition()) {
                        case 0:
                            at.this.b(false, IC);
                            return;
                        case 1:
                            at.this.a(false, IC);
                            at.this.b(true, IC);
                            return;
                        case 2:
                            at.this.a(true, IC);
                            at.this.b(true, IC);
                            return;
                        default:
                            return;
                    }
                }
            });
        }
        if (IC != null) {
            if (IC.IW()) {
                ahs();
            } else {
                aht();
            }
        }
        IQApp.Dn().aE(new k.d(true));
    }

    final /* synthetic */ void n(View view, int i) {
        if (i >= 0 && i < this.cpg.getItemCount() && this.cpg.getItemCount() > 0) {
            Strike cC = this.cpg.cC(i);
            g IC = com.iqoption.app.managers.tab.a.Il().IC();
            if (IC != null) {
                IC.IT();
                IC.c(cC);
                this.cpd.bvi.setChecked(false);
                this.cpg.notifyDataSetChanged();
                EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "traderoom_choose-strike-traderoom").setParameters(i.ZZ().l("strike_value", String.valueOf(cC.getValue())).l("instrument_type", cC.optionType).aab()).build());
            }
            aN();
        }
    }

    final /* synthetic */ void ahw() {
        d(com.iqoption.app.managers.tab.a.Il().Ix());
    }

    final /* synthetic */ void d(CompoundButton compoundButton, boolean z) {
        g IC = com.iqoption.app.managers.tab.a.Il().IC();
        if (IC != null) {
            b(z, IC);
        }
    }

    private void a(boolean z, g gVar) {
        gVar.bz(z);
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "traderoom_choose-strike-spot").setValue(Double.valueOf(z ? 1.0d : 0.0d)).build());
    }

    private void b(boolean z, g gVar) {
        gVar.by(z);
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "traderoom_choose-strike-automatic-right-panel").setValue(Double.valueOf(z ? 1.0d : 0.0d)).build());
    }

    private void d(Strike strike) {
        int a = this.cpg.a(strike);
        if (a >= 0) {
            this.cpd.bvq.b(a);
        }
    }

    private void ahs() {
        g IC = com.iqoption.app.managers.tab.a.Il().IC();
        if (IC.apw.Ie()) {
            r(IC);
        } else {
            q(IC);
        }
    }

    private void aht() {
        if (com.iqoption.app.managers.tab.a.Il().IC().apw.Ie()) {
            ahv();
        } else {
            ahu();
        }
    }

    private void q(g gVar) {
        if (gVar != null) {
            this.cpd.bvi.setChecked(gVar.IW());
            this.cpd.bvi.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setInterpolator(com.iqoption.view.a.a.d.dEM).start();
            return;
        }
        ahu();
    }

    private void ahu() {
        this.cpd.bvi.setChecked(false);
        this.cpd.bvi.animate().alpha(0.7f).scaleX(0.95f).scaleY(0.95f).setInterpolator(com.iqoption.view.a.a.d.dEM).start();
    }

    private void r(g gVar) {
        if (gVar == null) {
            ahv();
        } else if (gVar.apw.If()) {
            eB(2);
        } else {
            eB(1);
        }
    }

    private void ahv() {
        eB(0);
    }

    private void eB(int i) {
        Tab tabAt = this.cpd.bvo.getTabAt(i);
        if (!tabAt.isSelected()) {
            tabAt.select();
        }
    }

    private void Ba() {
        com.iqoption.view.a.b.aIK().a(this.cph, Integer.valueOf(5));
    }

    private void Bb() {
        com.iqoption.view.a.b.aIK().b(this.cph);
    }

    public void onStart() {
        super.onStart();
        if (this.cpg != null) {
            this.cpg.onStart();
        }
        this.cpe.register();
        Ba();
        this.adT = Event.Builder(Event.CATEGORY_POPUP_SERVED, "traderoom_expiration-time").setParameters(i.ZZ().l("instrument_type", InstrumentType.DIGITAL_INSTRUMENT).aab());
    }

    public void onPause() {
        super.onPause();
    }

    public void onStop() {
        super.onStop();
        Bb();
        this.cpe.unregister();
        if (this.cpg != null) {
            this.cpg.onStop();
        }
        if (this.adT != null) {
            EventManager.Bm().a(this.adT.calcDuration().build());
        }
    }

    public boolean onClose() {
        getFragmentManager().popBackStack();
        IQApp.Dn().aE(new k.d(false));
        return true;
    }

    public void ND() {
        float f;
        if (ax.dws) {
            TimeInterpolator timeInterpolator = com.iqoption.view.a.a.d.dEM;
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dp12);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.dp6);
            float f2 = (float) dimensionPixelSize2;
            this.cpd.blV.setTranslationX(f2);
            f = (float) (-dimensionPixelSize2);
            this.cpd.blV.setTranslationY(f);
            this.cpd.bvk.setTranslationX(f2);
            this.cpd.bvk.setTranslationY(f);
            this.cpd.bvk.setAlpha(0.0f);
            this.cpd.bvq.setTranslationX(f2);
            this.cpd.bvq.setTranslationY(f);
            this.cpd.bvq.setAlpha(0.0f);
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(this.cpd.blV, this.cpd.blV.getWidth() - dimensionPixelSize, dimensionPixelSize, (float) dimensionPixelSize, (float) Math.hypot((double) this.cpd.blV.getWidth(), (double) this.cpd.blV.getHeight()));
            createCircularReveal.setDuration(400).setInterpolator(timeInterpolator);
            FrameLayout frameLayout = this.cpd.blV;
            PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[2];
            propertyValuesHolderArr[0] = PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{0.0f});
            propertyValuesHolderArr[1] = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{0.0f});
            Animator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(frameLayout, propertyValuesHolderArr);
            ofPropertyValuesHolder.setDuration(400).setInterpolator(timeInterpolator);
            RecyclerView recyclerView = this.cpd.bvk;
            propertyValuesHolderArr = new PropertyValuesHolder[3];
            propertyValuesHolderArr[0] = PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{0.0f});
            propertyValuesHolderArr[1] = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{0.0f});
            propertyValuesHolderArr[2] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{1.0f});
            Animator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(recyclerView, propertyValuesHolderArr);
            ofPropertyValuesHolder2.setDuration(200).setInterpolator(timeInterpolator);
            RecyclerView recyclerView2 = this.cpd.bvq;
            r3 = new PropertyValuesHolder[3];
            r3[0] = PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{0.0f});
            r3[1] = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{0.0f});
            r3[2] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{1.0f});
            Animator ofPropertyValuesHolder3 = ObjectAnimator.ofPropertyValuesHolder(recyclerView2, r3);
            ofPropertyValuesHolder3.setDuration(200).setInterpolator(timeInterpolator);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(createCircularReveal).with(ofPropertyValuesHolder);
            animatorSet.play(ofPropertyValuesHolder3).with(ofPropertyValuesHolder2).after(100);
            animatorSet.start();
            return;
        }
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.dp12);
        f = (float) (-dimensionPixelOffset);
        this.cpd.blV.setTranslationX(f);
        this.cpd.blV.setTranslationY(f);
        this.cpd.blV.setPivotX((float) (this.cpd.blV.getWidth() - dimensionPixelOffset));
        this.cpd.blV.setPivotY(1.0f);
        this.cpd.blV.setScaleX(0.3f);
        this.cpd.blV.setScaleY(0.3f);
        this.cpd.blV.setAlpha(0.0f);
        this.cpd.blV.animate().alpha(1.0f).scaleY(1.0f).scaleX(1.0f).translationX(0.0f).translationY(0.0f).setDuration(400).setListener(null).setInterpolator(com.iqoption.view.a.a.d.dEM).start();
    }

    public void NE() {
        this.cpd.blV.animate().alpha(0.0f).setDuration(NG()).setInterpolator(com.iqoption.view.a.a.d.dEM).start();
    }
}
