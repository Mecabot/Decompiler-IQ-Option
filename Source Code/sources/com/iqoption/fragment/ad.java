package com.iqoption.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import com.iqoption.activity.TradeRoomActivity;
import com.iqoption.analytics.EventManager;
import com.iqoption.app.IQApp;
import com.iqoption.app.managers.ae;
import com.iqoption.app.managers.c.g;
import com.iqoption.dto.Balance;
import com.iqoption.dto.Currencies.ConversionCurrency;
import com.iqoption.dto.Event;
import com.iqoption.dto.entity.result.BalanceListResult;
import com.iqoption.dto.entity.result.KycState;
import com.iqoption.mobbtech.connect.RequestManager;
import com.iqoption.mobbtech.connect.request.api.Requests;
import com.iqoption.mobbtech.connect.response.h;
import com.iqoption.service.e.l;
import com.iqoption.service.e.m;
import com.iqoption.system.a.i;
import com.iqoption.tutorial.StepDoneType;
import com.iqoption.tutorial.TutorialViewModel;
import com.iqoption.tutorial.dictionary.TutorialAction;
import com.iqoption.util.ac;
import com.iqoption.util.ag;
import com.iqoption.util.bg;
import com.iqoption.welcomeonboarding.registration.f;
import com.iqoption.x.R;
import java.util.List;

/* compiled from: BalanceFragment */
public class ad extends com.iqoption.fragment.base.b {
    private RecyclerView cnJ;
    private com.iqoption.a.b cnK;
    private View cnL;
    private final e cnM = new e(this);
    private final b cnN = new b(this);
    private final Handler mHandler = new Handler();

    /* compiled from: BalanceFragment */
    class c extends SimpleOnGestureListener {
        c() {
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            ad.this.onBackPressed();
            return true;
        }
    }

    /* compiled from: BalanceFragment */
    private static class a extends com.iqoption.system.c.b<ad, BalanceListResult> {
        public a(ad adVar, Class<BalanceListResult> cls) {
            super(adVar, cls);
        }

        /* renamed from: a */
        public void z(@NonNull ad adVar, @NonNull BalanceListResult balanceListResult) {
            com.iqoption.app.a.Cw().a(balanceListResult.getMapBalance());
            if (adVar.isAdded()) {
                adVar.cnK.AJ();
                adVar.cnK.notifyDataSetChanged();
            }
        }
    }

    /* compiled from: BalanceFragment */
    private static class b extends com.iqoption.system.a.e<ad> {
        public b(ad adVar) {
            super(adVar);
        }

        @com.google.common.b.e
        public void onTotalPnl(g gVar) {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    ad adVar = (ad) b.this.drU.get();
                    if (adVar != null && adVar.isAdded()) {
                        adVar.GC();
                    }
                }
            });
        }
    }

    /* compiled from: BalanceFragment */
    private static class d extends com.iqoption.system.c.b<ad, List<Parcelable>> {
        private final String assetName;
        private final double cnV;
        private final double cnW;
        private final boolean cnX;
        private final int cnY;

        public d(ad adVar, double d, double d2, String str, boolean z, int i) {
            super((Object) adVar);
            this.cnV = d;
            this.cnW = d2;
            this.assetName = str;
            this.cnX = z;
            this.cnY = i;
        }

        /* renamed from: a */
        public void z(@NonNull ad adVar, List<Parcelable> list) {
            List<Parcelable> list2 = list;
            super.z(adVar, list);
            adVar.ev(this.cnY);
            com.iqoption.withdrawal.crypto.a.a(adVar.getFragmentManager(), R.id.other_fragment, (KycState) list2.get(0), (com.iqoption.microservice.a.b.a) list2.get(1), (com.iqoption.mobbtech.connect.response.e) list2.get(2), this.cnV, this.cnW, this.assetName, null, R.id.other_fragment, this.cnX);
        }

        /* renamed from: a */
        public void c(@NonNull ad adVar, Throwable th) {
            super.c(adVar, th);
            adVar.ev(this.cnY);
            com.iqoption.app.a.b.FG();
        }
    }

    /* compiled from: BalanceFragment */
    private static class e extends i<ad> {
        public e(ad adVar) {
            super(adVar);
        }

        @com.google.common.b.e
        public void onChangeBalanceId(com.iqoption.service.e.a aVar) {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    ad adVar = (ad) e.this.drU.get();
                    if (adVar != null && adVar.isAdded()) {
                        adVar.ahb();
                    }
                }
            });
        }

        @com.google.common.b.e
        public void onUpdateBalanceFragment(l lVar) {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    ad adVar = (ad) e.this.drU.get();
                    if (adVar != null && adVar.isAdded()) {
                        adVar.ahc();
                    }
                }
            });
        }

        @com.google.common.b.e
        public void onUpdateBalanceValue(m mVar) {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    ad adVar = (ad) e.this.drU.get();
                    if (adVar != null && adVar.isAdded()) {
                        adVar.ahc();
                    }
                }
            });
        }
    }

    public long getAnimationDuration() {
        return 300;
    }

    public static ad eu(int i) {
        ad adVar = new ad();
        Bundle bundle = new Bundle();
        bundle.putInt("leftMargin", i);
        adVar.setArguments(bundle);
        return adVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.balance_fragment, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.cnL = view.findViewById(R.id.baseLayout);
        this.cnL.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                ad.this.onBackPressed();
            }
        });
        this.cnK = new com.iqoption.a.b(new com.iqoption.a.b.c() {
            public void ct(int i) {
            }

            public void a(View view, com.iqoption.a.b.a aVar, final int i) {
                TutorialViewModel.D(ad.this.zzakw()).a(TutorialAction.PRACTICE_BALANCE, StepDoneType.TAP_ON_TARGET);
                Balance cs = ad.this.cnK.cs(i);
                TradeRoomActivity tradeRoomActivity;
                switch (view.getId()) {
                    case R.id.depositBtn:
                        ad.this.onBackPressed();
                        tradeRoomActivity = ad.this.getTradeRoomActivity();
                        if (tradeRoomActivity != null) {
                            int intValue = cs.type.intValue();
                            if (intValue != 1) {
                                if (intValue == 5) {
                                    tradeRoomActivity.dP(com.iqoption.util.l.e(com.iqoption.app.a.Cw().eh(Balance.getCurrency(cs))));
                                    break;
                                }
                            }
                            tradeRoomActivity.Aq();
                            break;
                        }
                        break;
                    case R.id.refresh_traning_balance:
                        ((com.iqoption.a.b.e) aVar).AV();
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(IQApp.Dl().getClusterApi());
                        stringBuilder.append("api/demo/reset");
                        new com.iqoption.mobbtech.connect.request.a.a.a(RequestManager.b(stringBuilder.toString(), null, ad.this.getContext()), new com.iqoption.mobbtech.connect.a.a() {
                            /* renamed from: a */
                            public void onSuccess(h hVar) {
                                ae.d(ad.this.getContext(), 524288);
                                ViewHolder findViewHolderForAdapterPosition = ad.this.cnJ.findViewHolderForAdapterPosition(i);
                                if (findViewHolderForAdapterPosition != null && (findViewHolderForAdapterPosition instanceof com.iqoption.a.b.e)) {
                                    ((com.iqoption.a.b.e) findViewHolderForAdapterPosition).AU();
                                }
                                ad.this.onBackPressed();
                            }

                            public void a(com.iqoption.mobbtech.connect.response.g gVar) {
                                if (ad.this.isAdded()) {
                                    ad.this.cnK.notifyItemChanged(i);
                                    gVar.bG(ad.this.getContext());
                                }
                            }
                        }, "api/demo/reset").auG();
                        break;
                    case R.id.refresh_trial_balance:
                    case R.id.registrationButton:
                        ad.this.onBackPressed();
                        f.a(ad.this.zzakw(), ad.this.getFragmentManager());
                        break;
                    case R.id.withdrawalBtn:
                        int intValue2 = cs.type.intValue();
                        if (intValue2 != 1) {
                            if (intValue2 == 5) {
                                ((com.iqoption.a.b.b) aVar).au(true);
                                ad.this.a(i, cs);
                                break;
                            }
                        }
                        ad.this.onBackPressed();
                        tradeRoomActivity = ad.this.getTradeRoomActivity();
                        if (tradeRoomActivity != null) {
                            tradeRoomActivity.Am();
                            break;
                        }
                        break;
                    default:
                        if (!ad.this.cnK.c(cs.id)) {
                            if (cs.type.intValue() != 5) {
                                aVar.AS();
                                ad.this.cnK.g(i, true);
                                Requests.a(ad.this.getContext(), cs, new com.iqoption.mobbtech.connect.a.a() {
                                    /* renamed from: a */
                                    public void onSuccess(h hVar) {
                                    }

                                    public void a(com.iqoption.mobbtech.connect.response.g gVar) {
                                        if (ad.this.isAdded()) {
                                            ad.this.cnK.g(i, false);
                                            ad.this.cnK.notifyItemChanged(i);
                                            gVar.bG(ad.this.getContext());
                                        }
                                    }
                                });
                                EventManager.Bm().a(Event.Builder(Event.CATEGORY_DROPDOWN_CHANGED, "traderoom_balance-type").setValue(Double.valueOf(cs.type.doubleValue())).build());
                                break;
                            }
                            aVar.AR();
                            break;
                        }
                        return;
                }
            }
        });
        this.cnK.setHasStableIds(true);
        LayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        this.cnJ = (RecyclerView) view.findViewById(R.id.balancesListView);
        this.cnJ.setLayoutManager(linearLayoutManager);
        this.cnJ.setAdapter(this.cnK);
        this.cnJ.setItemAnimator(null);
        this.cnJ.setLayoutTransition(bg.aGF());
        this.cnJ.setOnTouchListener(new ae(new GestureDetector(getContext(), new c())));
        int AO = this.cnK.AO();
        if (AO != -1) {
            this.mHandler.post(new af(this, AO));
        }
    }

    final /* synthetic */ void ew(int i) {
        this.cnJ.b(i);
    }

    private void a(int i, Balance balance) {
        ConversionCurrency eh = com.iqoption.app.a.Cw().eh(Balance.getCurrency(balance));
        double balanceValue = Balance.getBalanceValue(balance);
        String e = com.iqoption.util.l.e(eh);
        ag.b(com.iqoption.withdrawal.crypto.a.d(0.0d, balanceValue, e), new d(this, 0.0d, balanceValue, e, true, i));
    }

    public void onStart() {
        super.onStart();
        this.cnM.register();
        this.cnN.register();
        com.iqoption.app.a.Cw();
        this.mHandler.postDelayed(new ag(this, new a(this, BalanceListResult.class)), 250);
    }

    public void onStop() {
        super.onStop();
        this.cnM.unregister();
        this.cnN.unregister();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean onBackPressed() {
        if (super.aN()) {
            return true;
        }
        cr ajW = ajW();
        if (ajW != null) {
            ajW.cry.setSelected(false);
            ajW.crx.animate().rotation(90.0f).setInterpolator(com.iqoption.view.a.a.d.dEM).start();
        }
        ac.v(getFragmentManager());
        return true;
    }

    public void ev(int i) {
        ViewHolder findViewHolderForAdapterPosition = this.cnJ.findViewHolderForAdapterPosition(i);
        if (findViewHolderForAdapterPosition != null && (findViewHolderForAdapterPosition instanceof com.iqoption.a.b.b)) {
            ((com.iqoption.a.b.b) findViewHolderForAdapterPosition).au(false);
        }
    }

    public void ahb() {
        if (isAdded()) {
            Balance CC = com.iqoption.app.a.aL(getContext()).CC();
            if (CC != null) {
                if (!this.cnK.c(CC.id)) {
                    CC.isLoadingChange = false;
                    this.cnK.b(CC.id);
                    this.cnK.AN();
                    this.cnK.AM();
                    onBackPressed();
                } else if (CC.isLoadingChange) {
                    CC.isLoadingChange = false;
                    this.cnK.AN();
                }
            }
        }
    }

    public void ahc() {
        if (isAdded()) {
            this.cnK.notifyDataSetChanged();
        }
    }

    public void GC() {
        if (isAdded()) {
            this.cnK.AN();
        }
    }

    public void ND() {
        this.cnJ.startAnimation(AnimationUtils.loadAnimation(zzakw(), R.anim.appear_from_top_to_bottom_show));
    }

    public void NE() {
        this.cnJ.startAnimation(AnimationUtils.loadAnimation(zzakw(), R.anim.appear_from_bottom_to_top_hide));
    }
}
