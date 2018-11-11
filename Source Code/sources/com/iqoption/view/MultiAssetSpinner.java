package com.iqoption.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.common.util.concurrent.o;
import com.iqoption.analytics.EventManager;
import com.iqoption.app.IQApp;
import com.iqoption.app.af;
import com.iqoption.app.managers.tab.a.g;
import com.iqoption.app.managers.tab.a.i;
import com.iqoption.d.abk;
import com.iqoption.dto.Event;
import com.iqoption.mobbtech.connect.response.options.OptionEvents;
import com.iqoption.mobbtech.connect.response.options.OptionEvents.h;
import com.iqoption.mobbtech.connect.response.options.OptionEvents.j;
import com.iqoption.mobbtech.connect.response.options.OptionEvents.k;
import com.iqoption.mobbtech.connect.response.options.OptionEvents.m;
import com.iqoption.system.a.e;
import com.iqoption.tutorial.StepDoneType;
import com.iqoption.tutorial.TutorialViewModel;
import com.iqoption.tutorial.dictionary.TutorialAction;
import com.iqoption.util.bg;
import com.iqoption.x.R;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.Callable;

public class MultiAssetSpinner extends com.iqoption.view.base.c {
    public c dCp = new c(this, null);
    private abk dCq;
    private int dCr = 4;
    private SparseArray<WeakReference<b>> dCs = new SparseArray();
    private WeakReference<b> dCt = new WeakReference(null);

    private static class a implements Callable<Drawable> {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        /* renamed from: agX */
        public Drawable call() {
            return ContextCompat.getDrawable(IQApp.Dk(), R.drawable.add_tab_button_anim_bg);
        }
    }

    public interface d {
        void gS(int i);
    }

    private static class b extends com.iqoption.system.c.b<MultiAssetSpinner, Drawable> {
        public b(MultiAssetSpinner multiAssetSpinner) {
            super((Object) multiAssetSpinner);
        }

        /* renamed from: a */
        public void z(@NonNull MultiAssetSpinner multiAssetSpinner, @NonNull Drawable drawable) {
            int dimensionPixelSize = multiAssetSpinner.getContext().getResources().getDimensionPixelSize(R.dimen.dp10);
            multiAssetSpinner.dCq.bMm.setBackground(drawable);
            multiAssetSpinner.dCq.bMm.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            ((AnimationDrawable) ((LayerDrawable) drawable).getDrawable(1)).start();
        }
    }

    public static class c extends e<MultiAssetSpinner> {
        /* synthetic */ c(MultiAssetSpinner multiAssetSpinner, AnonymousClass1 anonymousClass1) {
            this(multiAssetSpinner);
        }

        private c(MultiAssetSpinner multiAssetSpinner) {
            super(multiAssetSpinner);
        }

        public void gT(final int i) {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    MultiAssetSpinner multiAssetSpinner = (MultiAssetSpinner) c.this.drU.get();
                    if (multiAssetSpinner != null && multiAssetSpinner.aIN()) {
                        multiAssetSpinner.dh(i);
                    }
                }
            });
        }

        public void gU(final int i) {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    MultiAssetSpinner multiAssetSpinner = (MultiAssetSpinner) c.this.drU.get();
                    if (multiAssetSpinner != null && multiAssetSpinner.aIN()) {
                        multiAssetSpinner.dg(i);
                    }
                }
            });
        }

        public void c(final g gVar, final boolean z) {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    MultiAssetSpinner multiAssetSpinner = (MultiAssetSpinner) c.this.drU.get();
                    if (multiAssetSpinner != null && multiAssetSpinner.aIN()) {
                        multiAssetSpinner.b(gVar, z);
                    }
                }
            });
        }

        public void bz(final List<g> list) {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    MultiAssetSpinner multiAssetSpinner = (MultiAssetSpinner) c.this.drU.get();
                    if (multiAssetSpinner != null && multiAssetSpinner.aIN()) {
                        multiAssetSpinner.D(list);
                    }
                }
            });
        }

        public void aIu() {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    MultiAssetSpinner multiAssetSpinner = (MultiAssetSpinner) c.this.drU.get();
                    if (multiAssetSpinner != null && multiAssetSpinner.aIN()) {
                        multiAssetSpinner.aIq();
                    }
                }
            });
        }

        @com.google.common.b.e
        public void onShowedEvent(final com.iqoption.fragment.a.d dVar) {
            if ((this.drU.get() != null || ((MultiAssetSpinner) this.drU.get()).aIN()) && !dVar.cnr) {
                com.iqoption.core.d.a.aSe.execute(new Runnable() {
                    public void run() {
                        MultiAssetSpinner multiAssetSpinner = (MultiAssetSpinner) c.this.drU.get();
                        if (multiAssetSpinner != null && multiAssetSpinner.aIN()) {
                            b bVar = (b) multiAssetSpinner.dCt.get();
                            if (bVar != null && bVar.aIN()) {
                                bVar.setSelected(dVar.aos);
                            }
                        }
                    }
                });
            }
        }

        @com.google.common.b.e
        public void onTabChangedEvent(i iVar) {
            com.iqoption.core.i.d("multi= onTabChngedEvent");
            if (this.drU.get() != null || ((MultiAssetSpinner) this.drU.get()).aIN()) {
                com.iqoption.core.d.a.aSe.execute(new Runnable() {
                    public void run() {
                        MultiAssetSpinner multiAssetSpinner = (MultiAssetSpinner) c.this.drU.get();
                        g IC = com.iqoption.app.managers.tab.a.Il().IC();
                        if (IC != null && multiAssetSpinner != null && multiAssetSpinner.aIN()) {
                            WeakReference weakReference = (WeakReference) multiAssetSpinner.dCs.get(IC.getId());
                            b bVar = weakReference != null ? (b) weakReference.get() : null;
                            if (bVar != null && bVar.aIN()) {
                                bVar.e(com.iqoption.app.managers.c.Gn().a(IC.getOptionKey()));
                            }
                        }
                    }
                });
            }
        }

        @com.google.common.b.e
        public void changeExpirationEvent(final com.iqoption.app.managers.a.k.a aVar) {
            if (this.drU.get() != null || ((MultiAssetSpinner) this.drU.get()).aIN()) {
                com.iqoption.core.d.a.aSe.execute(new Runnable() {
                    public void run() {
                        MultiAssetSpinner multiAssetSpinner = (MultiAssetSpinner) c.this.drU.get();
                        if (multiAssetSpinner != null && multiAssetSpinner.aIN() && multiAssetSpinner.dCs.get(aVar.aoq) != null) {
                            b bVar = (b) ((WeakReference) multiAssetSpinner.dCs.get(aVar.aoq)).get();
                            if (bVar != null && bVar.aIN()) {
                                bVar.e(com.iqoption.app.managers.c.Gn().a(aVar.optionKey));
                            }
                        }
                    }
                });
            }
        }

        @com.google.common.b.e
        public void onOpenOptionGroups(m mVar) {
            if (this.drU.get() != null || ((MultiAssetSpinner) this.drU.get()).aIN()) {
                com.iqoption.core.d.a.aSe.execute(new Runnable() {
                    public void run() {
                        MultiAssetSpinner multiAssetSpinner = (MultiAssetSpinner) c.this.drU.get();
                        if (multiAssetSpinner != null && multiAssetSpinner.aIN()) {
                            for (int i = 0; i < multiAssetSpinner.dCs.size(); i++) {
                                b bVar = (b) ((WeakReference) multiAssetSpinner.dCs.get(multiAssetSpinner.dCs.keyAt(i))).get();
                                if (bVar != null && bVar.aIN()) {
                                    bVar.e(null);
                                }
                            }
                        }
                    }
                });
            }
        }

        @com.google.common.b.e
        public void onOpenOptionGroupRemoved(final k kVar) {
            if (this.drU.get() != null || ((MultiAssetSpinner) this.drU.get()).aIN()) {
                com.iqoption.core.d.a.aSe.execute(new Runnable() {
                    public void run() {
                        MultiAssetSpinner multiAssetSpinner = (MultiAssetSpinner) c.this.drU.get();
                        if (multiAssetSpinner != null && multiAssetSpinner.aIN()) {
                            for (int i = 0; i < multiAssetSpinner.dCs.size(); i++) {
                                b bVar = (b) ((WeakReference) multiAssetSpinner.dCs.get(multiAssetSpinner.dCs.keyAt(i))).get();
                                if (bVar != null && bVar.aIN()) {
                                    g de = com.iqoption.app.managers.tab.a.Il().de(bVar.getId());
                                    if (de != null && de.getInstrumentType().equals(kVar.cWK.instrumentType) && de.getActiveId() == kVar.cWK.activeId.intValue() && de.getExpiration() == kVar.cWK.expTime.longValue() * 1000) {
                                        bVar.e(null);
                                    }
                                }
                            }
                        }
                    }
                });
            }
        }

        @com.google.common.b.e
        public void onNewOpenOptionGroup(final h hVar) {
            if (this.drU.get() != null || ((MultiAssetSpinner) this.drU.get()).aIN()) {
                com.iqoption.core.d.a.aSe.execute(new Runnable() {
                    public void run() {
                        MultiAssetSpinner multiAssetSpinner = (MultiAssetSpinner) c.this.drU.get();
                        if (multiAssetSpinner != null && multiAssetSpinner.aIN()) {
                            for (int i = 0; i < multiAssetSpinner.dCs.size(); i++) {
                                b bVar = (b) ((WeakReference) multiAssetSpinner.dCs.get(multiAssetSpinner.dCs.keyAt(i))).get();
                                if (bVar != null && bVar.aIN()) {
                                    g de = com.iqoption.app.managers.tab.a.Il().de(bVar.getId());
                                    if (de != null && de.getInstrumentType().equals(hVar.cWF.instrumentType) && de.getActiveId() == hVar.cWF.activeId.intValue() && de.getExpiration() == hVar.cWF.expTime.longValue() * 1000) {
                                        bVar.e(hVar.cWF);
                                    }
                                }
                            }
                        }
                    }
                });
            }
        }

        @com.google.common.b.e
        public void onOpenOptionGroupOptionRemoved(final j jVar) {
            if (this.drU.get() != null || ((MultiAssetSpinner) this.drU.get()).aIN()) {
                com.iqoption.core.d.a.aSe.execute(new Runnable() {
                    public void run() {
                        MultiAssetSpinner multiAssetSpinner = (MultiAssetSpinner) c.this.drU.get();
                        if (multiAssetSpinner != null && multiAssetSpinner.aIN()) {
                            for (int i = 0; i < multiAssetSpinner.dCs.size(); i++) {
                                b bVar = (b) ((WeakReference) multiAssetSpinner.dCs.get(multiAssetSpinner.dCs.keyAt(i))).get();
                                if (bVar != null && bVar.aIN()) {
                                    g de = com.iqoption.app.managers.tab.a.Il().de(bVar.getId());
                                    if (de != null && de.getInstrumentType().equals(jVar.cWI.instrumentType) && de.getActiveId() == jVar.cWI.activeId.intValue() && de.getExpiration() == jVar.cWI.expTime.longValue() * 1000) {
                                        bVar.e(jVar.cWI);
                                    }
                                }
                            }
                        }
                    }
                });
            }
        }

        @com.google.common.b.e
        public void onOpenOptionGroupOptionAdded(final OptionEvents.i iVar) {
            if (this.drU.get() != null || ((MultiAssetSpinner) this.drU.get()).aIN()) {
                com.iqoption.core.d.a.aSe.execute(new Runnable() {
                    public void run() {
                        MultiAssetSpinner multiAssetSpinner = (MultiAssetSpinner) c.this.drU.get();
                        if (multiAssetSpinner != null && multiAssetSpinner.aIN()) {
                            for (int i = 0; i < multiAssetSpinner.dCs.size(); i++) {
                                b bVar = (b) ((WeakReference) multiAssetSpinner.dCs.get(multiAssetSpinner.dCs.keyAt(i))).get();
                                if (bVar != null && bVar.aIN()) {
                                    g de = com.iqoption.app.managers.tab.a.Il().de(bVar.getId());
                                    if (de != null && de.getInstrumentType().equals(iVar.cWG.instrumentType) && de.getActiveId() == iVar.cWG.activeId.intValue() && de.getExpiration() == iVar.cWG.expTime.longValue() * 1000) {
                                        bVar.e(iVar.cWG);
                                    }
                                }
                            }
                        }
                    }
                });
            }
        }
    }

    public MultiAssetSpinner(Context context) {
        super(context);
        aIa();
    }

    public MultiAssetSpinner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        aIa();
    }

    public MultiAssetSpinner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        aIa();
    }

    @TargetApi(21)
    public MultiAssetSpinner(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        aIa();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.dCp.register();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.dCp.unregister();
    }

    private void aIa() {
        this.dCq = (abk) DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.multi_asset_view, this, true);
        this.dCq.bMm.setOnTouchListener(new com.iqoption.view.d.d());
        this.dCq.bMm.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                MultiAssetSpinner.this.aIs();
                TutorialViewModel.D(MultiAssetSpinner.this.getTradeRoomActivity()).a(TutorialAction.ADD_TAB, StepDoneType.TAP_ON_TARGET);
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                MultiAssetSpinner.this.getTradeRoomActivity().b(true, iArr[0]);
                EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "traderoom_add-tab").build());
            }
        });
        this.dCq.avm.setLayoutTransition(bg.aGE());
        aIt();
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        gR(i - getResources().getDimensionPixelSize(R.dimen.dp80));
    }

    private void D(List<g> list) {
        this.dCs.clear();
        this.dCq.avm.removeAllViews();
        for (g b : list) {
            b(b, false);
        }
        aIr();
    }

    private void b(g gVar, boolean z) {
        a(gVar, true, z);
    }

    private void a(g gVar, boolean z, boolean z2) {
        View bVar = new b(getContext());
        bVar.setId(gVar.getId());
        bVar.setClickView(new d() {
            public void gS(int i) {
                double d;
                if (MultiAssetSpinner.this.dCt == null || MultiAssetSpinner.this.dCt.get() == null || i != ((b) MultiAssetSpinner.this.dCt.get()).getId()) {
                    com.iqoption.app.managers.tab.a.Il().dh(i);
                    d = 1.0d;
                } else {
                    int[] iArr = new int[2];
                    ((b) MultiAssetSpinner.this.dCt.get()).getLocationOnScreen(iArr);
                    MultiAssetSpinner.this.getTradeRoomActivity().b(false, iArr[0]);
                    d = 0.0d;
                }
                g de = com.iqoption.app.managers.tab.a.Il().de(i);
                if (de != null) {
                    EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "traderoom_choose-tab").setValue(Double.valueOf(d)).setParameters(com.iqoption.core.util.i.ZZ().l("instrument_type", de.getInstrumentType()).aab()).build());
                }
            }
        });
        bVar.setClickCloseView(new d() {
            public void gS(int i) {
                g de = com.iqoption.app.managers.tab.a.Il().de(i);
                if (de != null) {
                    EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "traderoom_close-tab").setParameters(com.iqoption.core.util.i.ZZ().l("instrument_type", de.getInstrumentType()).aab()).build());
                }
                com.iqoption.app.managers.tab.a.Il().dg(i);
                MultiAssetSpinner.this.gQ(i);
            }
        });
        bVar.aIb();
        this.dCs.put(gVar.getId(), new WeakReference(bVar));
        this.dCq.avm.addView(bVar, z2 ? -1 : 0);
        if (z) {
            dh(gVar.getId());
            aIr();
        }
    }

    private void gQ(int i) {
        for (int i2 = 0; i2 < this.dCq.avm.getChildCount(); i2++) {
            if (this.dCq.avm.getChildAt(i2).getId() == i) {
                if (i2 == 0) {
                    com.iqoption.app.managers.tab.a.Il().dh(this.dCq.avm.getChildAt(i2 + 1).getId());
                } else {
                    com.iqoption.app.managers.tab.a.Il().dh(this.dCq.avm.getChildAt(i2 - 1).getId());
                }
            }
        }
    }

    private void dh(int i) {
        this.dCt = (WeakReference) this.dCs.get(i);
        aIp();
    }

    private void aIp() {
        b bVar = this.dCt != null ? (b) this.dCt.get() : null;
        for (int i = 0; i < this.dCs.size(); i++) {
            b bVar2 = (b) ((WeakReference) this.dCs.get(this.dCs.keyAt(i))).get();
            if (bVar2 != null && bVar2.aIN()) {
                boolean z = true;
                if (bVar == null || bVar.getId() != bVar2.getId()) {
                    if (this.dCs.size() <= this.dCr) {
                        z = false;
                    }
                    bVar2.fe(z);
                } else {
                    if (this.dCs.size() != 1) {
                        z = false;
                    }
                    bVar2.ff(z);
                }
            }
        }
    }

    private void dg(int i) {
        WeakReference weakReference = (WeakReference) this.dCs.get(i);
        if (weakReference != null && weakReference.get() != null) {
            this.dCq.avm.removeView((View) weakReference.get());
            this.dCs.remove(i);
            aIr();
        }
    }

    private void aIq() {
        if (this.dCt != null) {
            b bVar = (b) this.dCt.get();
            if (bVar != null && bVar.getId() == com.iqoption.app.managers.tab.a.Il().ID()) {
                bVar.aIb();
            }
        }
    }

    private void aIr() {
        if (this.dCs.size() < 4) {
            this.dCq.bMm.setVisibility(0);
        } else {
            this.dCq.bMm.setVisibility(8);
        }
    }

    private void gR(int i) {
        i /= getResources().getDimensionPixelSize(R.dimen.dp100);
        if (i == 0) {
            i = 4;
        }
        this.dCr = i;
    }

    private void aIs() {
        boolean z = false;
        if (com.iqoption.app.managers.feature.a.HI() && af.eM("first_do_add_experience_fx")) {
            af.i("first_do_add_experience_fx", false);
            z = true;
        }
        if (z) {
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.dp10);
            this.dCq.bMm.setBackground(ContextCompat.getDrawable(getContext(), R.color.black_20));
            this.dCq.bMm.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        }
    }

    private void aIt() {
        if (com.iqoption.app.managers.feature.a.HI() && af.eM("first_do_add_experience_fx")) {
            o.a(com.iqoption.core.d.a.aSc.c(new a()), new b(this), com.iqoption.core.d.a.aSe);
        }
    }
}
