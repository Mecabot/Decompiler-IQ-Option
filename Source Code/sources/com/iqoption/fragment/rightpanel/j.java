package com.iqoption.fragment.rightpanel;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.google.common.util.concurrent.y;
import com.iqoption.analytics.EventManager;
import com.iqoption.analytics.m;
import com.iqoption.app.managers.a.k;
import com.iqoption.app.managers.af;
import com.iqoption.app.managers.r;
import com.iqoption.app.managers.tab.a.g;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.util.p;
import com.iqoption.d.ahk;
import com.iqoption.dto.Balance;
import com.iqoption.dto.Currencies;
import com.iqoption.dto.Currencies.ConversionCurrency;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;
import com.iqoption.dto.entity.ActiveQuote;
import com.iqoption.dto.entity.Feature;
import com.iqoption.dto.entity.expiration.Expiration;
import com.iqoption.dto.entity.position.Order;
import com.iqoption.fragment.ah;
import com.iqoption.fragment.ap;
import com.iqoption.fragment.bo;
import com.iqoption.fragment.bq;
import com.iqoption.fragment.bt;
import com.iqoption.fragment.bv;
import com.iqoption.fragment.bw;
import com.iqoption.fragment.bx;
import com.iqoption.system.a.i;
import com.iqoption.tutorial.StepDoneType;
import com.iqoption.tutorial.TutorialViewModel;
import com.iqoption.util.ag;
import com.iqoption.util.au;
import com.iqoption.util.bc;
import com.iqoption.util.bg;
import com.iqoption.util.l;
import com.iqoption.util.q;
import com.iqoption.view.RobotoTextView;
import com.iqoption.view.h;
import com.iqoption.x.R;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/* compiled from: CfdRightPanelDelegate */
public class j extends au implements com.iqoption.view.a.b.a {
    private static final String TAG = "j";
    private double aTA;
    private final TutorialViewModel aeq;
    @ColorInt
    private int ahg;
    @ColorInt
    private int ahh;
    @ColorInt
    private int ahi;
    private com.iqoption.core.microservices.tradingengine.response.active.a aiJ;
    private final y cEC = new y();
    private final SimpleDateFormat cED = new SimpleDateFormat("0:mm:ss", Locale.getDefault());
    private aw cEG;
    private x cEH;
    private int cEK;
    private boolean cEL;
    private final DecimalFormat cEy = q.dX(2);
    private final com.iqoption.view.d.d cFA = new com.iqoption.view.d.d();
    private aw cFB;
    private aw cFC;
    private x cFD;
    private e cFE;
    private Expiration cFF;
    private volatile boolean cFG;
    private final boolean cFH;
    private final boolean cFI;
    private final boolean cFJ;
    ahk cFK;
    private final com.iqoption.view.d.b cFL = new com.iqoption.view.d.b() {
        public void q(View view) {
            ah.a(j.this.getFragmentManager(), R.id.fragment);
        }
    };
    private Builder cFM;
    private final ay cFh = new ay();
    private volatile Double cFi;
    private double cFj;
    private ax cFk;
    private ax cFl;
    private final boolean cFm;
    private final boolean cFn;
    private volatile Boolean cFo = null;
    private volatile Boolean cFp = null;
    @Nullable
    private com.iqoption.core.microservices.risks.response.overnightfee.d cFq = null;
    private final Observer<com.iqoption.core.microservices.risks.response.overnightfee.d> cFr = new k(this);
    private final b cFw = new b(this, null);
    private final d cFx = new d(this);
    private final c cFy = new c(this);
    private final DecimalFormat cFz = q.dX(3);
    private volatile Double ckA = null;
    private volatile Double ckB = null;
    private final boolean cki;
    private final DecimalFormat crm = l.aGc();
    private String mask;
    private int multiplier;

    /* compiled from: CfdRightPanelDelegate */
    private static class e {
        private final View cGm;
        private ObjectAnimator cGn;

        public e(View view) {
            this.cGm = view;
        }

        public void start() {
            if (this.cGn != null) {
                this.cGn.cancel();
            }
            Keyframe ofFloat = Keyframe.ofFloat(0.5f, 1.0f);
            Keyframe ofFloat2 = Keyframe.ofFloat(1.0f, 0.0f);
            View view = this.cGm;
            PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[1];
            propertyValuesHolderArr[0] = PropertyValuesHolder.ofKeyframe(View.ALPHA, new Keyframe[]{ofFloat, ofFloat2});
            this.cGn = ObjectAnimator.ofPropertyValuesHolder(view, propertyValuesHolderArr);
            this.cGn.setRepeatMode(2);
            this.cGn.setRepeatCount(-1);
            this.cGn.setDuration(600);
            this.cGn.start();
        }

        public void stop() {
            if (this.cGn != null) {
                this.cGn.cancel();
            }
            this.cGn = ObjectAnimator.ofFloat(this.cGm, View.ALPHA, new float[]{0.0f});
            this.cGn.start();
        }
    }

    /* compiled from: CfdRightPanelDelegate */
    public static final class f {
        private final e cEY;
        private final j cGo;

        public f(j jVar) {
            this.cGo = jVar;
            this.cEY = new e(jVar);
        }

        public void amY() {
            EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "deal-keyboard_keyboard").setValue(Double.valueOf(h.b(this.cGo.getFragmentManager(), R.id.fragment, this.cGo.UO()) ? 1.0d : 0.0d)).build());
        }

        public void amZ() {
            this.cGo.y(this.cGo.UO() - 1.0d);
            EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "traderoom_deal-minus").build());
        }

        public void ana() {
            this.cGo.y(this.cGo.UO() + 1.0d);
            EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "traderoom_deal-plus").build());
        }

        public void anL() {
            bq.a(this.cGo.getFragmentManager(), R.id.fragment, this.cGo.getInstrumentType(), this.cGo.getActiveId());
        }

        public void bh(View view) {
            this.cGo.aeq.a(com.iqoption.tutorial.utils.d.aFX(), StepDoneType.TAP_ON_TARGET);
            if (this.cGo.amS()) {
                this.cGo.bg(view);
            }
            this.cGo.ds(true);
            this.cEY.ane();
        }

        public void bi(View view) {
            this.cGo.aeq.a(com.iqoption.tutorial.utils.d.aFX(), StepDoneType.TAP_ON_TARGET);
            if (this.cGo.amS()) {
                this.cGo.bg(view);
            }
            this.cGo.ds(false);
            this.cEY.ane();
        }

        public void anb() {
            this.cEY.anf();
            this.cGo.ano();
            this.cGo.anz();
            this.cGo.ann();
            this.cGo.anK();
        }

        public void anj() {
            boolean anf = this.cEY.anf();
            this.cGo.ano();
            if (anf) {
                this.cGo.any();
            }
            this.cGo.anz();
            this.cGo.ann();
            this.cGo.dD(false);
        }

        public void anm() {
            this.cGo.ano();
            this.cGo.anz();
            this.cGo.ann();
        }

        public void anl() {
            this.cGo.ano();
            this.cGo.any();
            this.cGo.ann();
            this.cGo.dD(true);
        }

        public void anM() {
            bx.b(this.cGo.getFragmentManager(), this.cGo.getInstrumentType(), this.cGo.getActiveId(), this.cGo.cFi, true);
        }

        public void anN() {
            this.cGo.any();
        }

        public void anO() {
            this.cGo.any();
            this.cGo.anA();
        }

        public void anP() {
            com.iqoption.dialog.c.b.a(this.cGo.getFragmentManager(), this.cGo.getActiveId(), this.cGo.getInstrumentType(), this.cGo.cEL, this.cGo.cFi, this.cGo.ckA, this.cGo.ckB, this.cGo.cFo, this.cGo.multiplier, this.cGo.aTA, this.cGo.cFp);
            m.BI();
        }

        public void and() {
            com.iqoption.app.managers.tab.a.Il().IB();
        }
    }

    /* compiled from: CfdRightPanelDelegate */
    private static class a extends com.iqoption.system.c.b<j, Order> {
        private Boolean cFp;
        private Double ckA;
        private Double ckB;

        /* renamed from: a */
        public void c(@NonNull j jVar, Throwable th) {
        }

        public a(j jVar, Double d, Double d2, Boolean bool) {
            super((Object) jVar);
            this.ckA = d;
            this.ckB = d2;
            this.cFp = bool;
        }

        /* renamed from: a */
        public void z(@NonNull j jVar, @NonNull Order order) {
            jVar.a(order, this.ckA, this.ckB, this.cFp);
        }
    }

    /* compiled from: CfdRightPanelDelegate */
    public static final class b extends com.iqoption.system.a.e<j> {
        /* synthetic */ b(j jVar, AnonymousClass1 anonymousClass1) {
            this(jVar);
        }

        private b(j jVar) {
            super(jVar);
        }

        @com.google.common.b.e
        public void onShowedExpirationFragmentEvent(final com.iqoption.app.managers.a.k.d dVar) {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    j jVar = (j) b.this.drU.get();
                    if (jVar != null) {
                        jVar.dq(dVar.aos);
                    }
                }
            });
        }

        @com.google.common.b.e
        public void onNativeChangeLimitOrderValueEvent(final com.iqoption.gl.NativeHandler.c cVar) {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    j jVar = (j) b.this.drU.get();
                    if (jVar != null && jVar.cFm) {
                        jVar.j((Double) cVar.getValue());
                        jVar.anB();
                    }
                }
            });
        }

        @com.google.common.b.e
        public void onChangeLimitOrderValueEvent(final com.iqoption.fragment.bx.a aVar) {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    j jVar = (j) b.this.drU.get();
                    if (jVar != null && jVar.cFm) {
                        jVar.j(aVar.value);
                        if (aVar.cqy) {
                            jVar.anA();
                        }
                    }
                }
            });
        }

        @com.google.common.b.e
        public void onShowedPendingEdit(final com.iqoption.fragment.bx.b bVar) {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    j jVar = (j) b.this.drU.get();
                    if (jVar != null && jVar.cFm) {
                        if (!bVar.aos) {
                            jVar.j(bVar.value);
                            jVar.anA();
                        }
                        jVar.dv(bVar.aos);
                        m.a(bVar.aos, jVar.getInstrumentType(), com.iqoption.app.a.Cw().Cy());
                    }
                }
            });
        }

        @com.google.common.b.e
        public void onShowedLimitsDialogEvent(final com.iqoption.dialog.c.b.b bVar) {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    j jVar = (j) b.this.drU.get();
                    if (jVar != null) {
                        jVar.dy(((Boolean) bVar.getValue()).booleanValue());
                    }
                }
            });
        }

        @com.google.common.b.e
        public void onLimitsChangeEvent(final com.iqoption.dialog.c.b.a aVar) {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    j jVar = (j) b.this.drU.get();
                    if (jVar != null) {
                        jVar.a(aVar.ckA, aVar.ckB, aVar.cjX, aVar.cka);
                        jVar.ant();
                    }
                }
            });
        }

        @com.google.common.b.e
        public void onInitializationCompletedEvent(com.iqoption.app.managers.tab.a.d dVar) {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    j jVar = (j) b.this.drU.get();
                    if (jVar != null) {
                        jVar.ans();
                        jVar.amM();
                    }
                }
            });
        }

        @com.google.common.b.e
        public void onAmountChangedIQKeyboardEvent(final com.iqoption.view.h.a aVar) {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    j jVar = (j) b.this.drU.get();
                    if (jVar != null) {
                        jVar.x(((Double) aVar.getValue()).doubleValue());
                    }
                }
            });
        }

        @com.google.common.b.e
        public void onShowedIQKeyboardEvent(final com.iqoption.view.h.b bVar) {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    j jVar = (j) b.this.drU.get();
                    if (jVar != null) {
                        jVar.dr(((Boolean) bVar.getValue()).booleanValue());
                    }
                }
            });
        }

        @com.google.common.b.e
        public void onShowedMultiplierChooser(final com.iqoption.fragment.bq.d dVar) {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    j jVar = (j) b.this.drU.get();
                    if (jVar != null) {
                        jVar.dx(((Boolean) dVar.getValue()).booleanValue());
                    }
                }
            });
        }

        @com.google.common.b.e
        public void onShowedOtnChanged(final com.iqoption.fragment.bt.b bVar) {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    j jVar = (j) b.this.drU.get();
                    if (jVar != null) {
                        jVar.dz(((Boolean) bVar.getValue()).booleanValue());
                    }
                }
            });
        }

        @com.google.common.b.e
        public void onOtnCommissionChanged(com.iqoption.fragment.bt.a aVar) {
            com.iqoption.core.d.a.aSe.execute(new p(this, aVar));
        }

        @com.google.common.b.e
        public void onShowedCommissionInfo(com.iqoption.fragment.ap.a aVar) {
            com.iqoption.core.d.a.aSe.execute(new q(this, aVar));
        }

        @com.google.common.b.e
        public void onShowedOvernightFeeInfo(com.iqoption.fragment.bw.c cVar) {
            com.iqoption.core.d.a.aSe.execute(new r(this, cVar));
        }

        @com.google.common.b.e
        public void onShowedOtnRewardInfo(com.iqoption.fragment.bv.a aVar) {
            com.iqoption.core.d.a.aSe.execute(new s(this, aVar));
        }

        @com.google.common.b.e
        public void onChosenMultiplierChooser(com.iqoption.fragment.bq.c cVar) {
            g IC = com.iqoption.app.managers.tab.a.Il().IC();
            if (IC != null) {
                IC.a("tabSetting.multiplier", Integer.valueOf(cVar.multiplier));
            }
            com.iqoption.core.d.a.aSe.execute(new t(this, cVar));
        }

        @com.google.common.b.e
        public void onShowedMultiplierConfirmDialog(final com.iqoption.fragment.bo.a aVar) {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    j jVar = (j) b.this.drU.get();
                    if (jVar != null) {
                        jVar.dC(aVar.cpW);
                    }
                }
            });
        }

        @com.google.common.b.e
        public void onUpdateCommissionPaidEvent(final com.iqoption.app.helpers.a.f fVar) {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    j jVar = (j) b.this.drU.get();
                    if (jVar != null && jVar.aiJ != null && jVar.aiJ.getInstrumentType() == fVar.getValue()) {
                        jVar.anq();
                    }
                }
            });
        }

        @com.google.common.b.e
        public void onChangeExpirationEvent(com.iqoption.app.managers.a.k.a aVar) {
            if (aVar.aoq == com.iqoption.app.managers.tab.a.Il().ID()) {
                com.iqoption.core.d.a.aSe.execute(new u(this, aVar));
            }
        }
    }

    /* compiled from: CfdRightPanelDelegate */
    private static class c extends com.iqoption.system.a.e<j> {
        private final Map<Long, Order> cGi = new ConcurrentHashMap();
        private final Map<Long, y<Order>> cGj = new ConcurrentHashMap();

        public c(j jVar) {
            super(jVar);
        }

        @com.google.common.b.e
        public void onOrderChanged(com.iqoption.mobbtech.connect.response.options.OptionEvents.f fVar) {
            Order order = (Order) fVar.getValue();
            if (order != null) {
                y yVar = (y) this.cGj.remove(order.getId());
                if (yVar == null) {
                    this.cGi.put(order.getId(), order);
                } else {
                    yVar.P(order);
                }
            }
        }

        public s<Order> t(Long l) {
            Order order = (Order) this.cGi.get(l);
            if (order != null) {
                return o.aR(order);
            }
            s wb = y.wb();
            this.cGj.put(l, wb);
            return wb;
        }
    }

    /* compiled from: CfdRightPanelDelegate */
    public static class d extends i<j> {
        public d(j jVar) {
            super(jVar);
        }

        @com.google.common.b.e
        public void onLeveragesChanged(final com.iqoption.service.e.e eVar) {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    j jVar = (j) d.this.drU.get();
                    if (jVar != null && jVar.getInstrumentType() == eVar.getValue()) {
                        jVar.anH();
                    }
                }
            });
        }

        @com.google.common.b.e
        public void onChangeBalanceType(com.iqoption.service.e.b bVar) {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    j jVar = (j) d.this.drU.get();
                    if (jVar != null) {
                        jVar.y(jVar.Ea());
                        jVar.anE();
                        jVar.anq();
                        jVar.amM();
                    }
                }
            });
        }

        @com.google.common.b.e
        public void onUpdateBalanceValue(com.iqoption.service.e.m mVar) {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    j jVar = (j) d.this.drU.get();
                    if (jVar != null) {
                        jVar.anq();
                        jVar.amM();
                    }
                }
            });
        }

        @com.google.common.b.e
        public void onChangeCurrentCurrency(com.iqoption.service.e.c cVar) {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    j jVar = (j) d.this.drU.get();
                    if (jVar != null) {
                        jVar.anq();
                        jVar.amL();
                        jVar.amM();
                    }
                }
            });
        }
    }

    public boolean amH() {
        return true;
    }

    j(RightPanelFragment rightPanelFragment, com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
        super(rightPanelFragment);
        x(aVar);
        com.iqoption.app.managers.feature.b HT = com.iqoption.app.managers.feature.b.HT();
        this.cFH = HT.fg("hide-emission") ^ true;
        this.cFI = HT.fg("otn-token");
        this.cFm = HT.ff("pending-order");
        this.cki = HT.ff("trailing-stop");
        Feature fd = HT.fd("margin-add-on");
        boolean z = false;
        boolean z2 = (fd == null || "disabled".equals(fd.status)) ? false : true;
        this.cFn = z2;
        if (fd != null && "enabled-with-popup".equals(fd.status)) {
            z = true;
        }
        this.cFJ = z;
        Context context = getContext();
        this.ahg = ContextCompat.getColor(context, R.color.green);
        this.ahh = ContextCompat.getColor(context, R.color.red);
        this.ahi = ContextCompat.getColor(context, R.color.white);
        this.cEK = rightPanelFragment.ef(R.dimen.dp24);
        this.cFw.register();
        this.cFy.register();
        this.cFx.register();
        anE();
        com.iqoption.view.a.b.aIK().a((com.iqoption.view.a.b.a) this);
        this.aeq = TutorialViewModel.D(rightPanelFragment.requireActivity());
        amT().observeForever(this.cFr);
    }

    public void amI() {
        anI();
    }

    public boolean amK() {
        return this.cEL;
    }

    public void x(double d) {
        y(d);
    }

    public double UO() {
        return this.aTA;
    }

    public void onTick(long j) {
        anD();
        if (this.aiJ.ba(j)) {
            if (this.aiJ.isExpired() && this.cFF != null) {
                bu(j);
                if (this.cFD.bl(this.cFK.bQL.bRp)) {
                    if (bs(j)) {
                        this.cFK.bQL.bRp.setTimeToClose(this.cED.format(this.cEC.bw(this.cFF.expValue.longValue() - j)));
                    } else {
                        amP();
                    }
                } else if (bs(j)) {
                    amQ();
                } else {
                    anD();
                }
            }
            if (this.cHt) {
                if (af.Hu().Hz()) {
                    au.bn(this.cFK.bQL.bRn);
                    au.bn(this.cFK.bQL.bRo);
                } else {
                    au.bo(this.cFK.bQL.bRn);
                    au.bo(this.cFK.bQL.bRo);
                }
            }
            return;
        }
        com.iqoption.view.a.b.aIK().b((com.iqoption.view.a.b.a) this);
        amU().resetDelegate();
    }

    private boolean bs(long j) {
        if (j <= this.cFF.expValue.longValue() - k.HB().c(this.aiJ, this.cFF) || j >= this.cFF.expValue.longValue()) {
            return false;
        }
        return com.iqoption.app.managers.c.Gn().b(new com.iqoption.mobbtech.connect.response.options.i(Long.valueOf(this.cFF.expValue.longValue() / 1000), Integer.valueOf(this.aiJ.getActiveId()), this.aiJ.getInstrumentType())) ^ 1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0064 A:{Splitter: B:2:0x0010, ExcHandler: java.lang.InterruptedException (r8_4 'e' java.lang.Throwable)} */
    /* JADX WARNING: Missing block: B:10:0x0064, code:
            r8 = move-exception;
     */
    /* JADX WARNING: Missing block: B:11:0x0065, code:
            com.iqoption.core.i.d("shouldShowExpirationChooser", r8);
     */
    private boolean bt(long r8) {
        /*
        r7 = this;
        r0 = com.iqoption.app.managers.a.k.HB();
        r1 = r7.aiJ;
        r0 = r0.k(r1);
        r1 = r0.isDone();
        if (r1 == 0) goto L_0x006b;
    L_0x0010:
        r0 = r0.get();	 Catch:{ InterruptedException -> 0x0064, InterruptedException -> 0x0064 }
        r0 = (com.iqoption.dto.entity.expiration.Expiration) r0;	 Catch:{ InterruptedException -> 0x0064, InterruptedException -> 0x0064 }
        r1 = com.iqoption.app.managers.a.k.HB();	 Catch:{ InterruptedException -> 0x0064, InterruptedException -> 0x0064 }
        r2 = r7.aiJ;	 Catch:{ InterruptedException -> 0x0064, InterruptedException -> 0x0064 }
        r1 = r1.c(r2, r0);	 Catch:{ InterruptedException -> 0x0064, InterruptedException -> 0x0064 }
        r3 = r0.expValue;	 Catch:{ InterruptedException -> 0x0064, InterruptedException -> 0x0064 }
        r3 = r3.longValue();	 Catch:{ InterruptedException -> 0x0064, InterruptedException -> 0x0064 }
        r5 = 0;
        r5 = r3 - r1;
        r1 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1));
        if (r1 <= 0) goto L_0x006b;
    L_0x002d:
        r1 = r0.expValue;	 Catch:{ InterruptedException -> 0x0064, InterruptedException -> 0x0064 }
        r1 = r1.longValue();	 Catch:{ InterruptedException -> 0x0064, InterruptedException -> 0x0064 }
        r3 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1));
        if (r3 >= 0) goto L_0x006b;
    L_0x0037:
        r8 = new com.iqoption.mobbtech.connect.response.options.i;	 Catch:{ InterruptedException -> 0x0064, InterruptedException -> 0x0064 }
        r9 = r0.expValue;	 Catch:{ InterruptedException -> 0x0064, InterruptedException -> 0x0064 }
        r0 = r9.longValue();	 Catch:{ InterruptedException -> 0x0064, InterruptedException -> 0x0064 }
        r2 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r0 = r0 / r2;
        r9 = java.lang.Long.valueOf(r0);	 Catch:{ InterruptedException -> 0x0064, InterruptedException -> 0x0064 }
        r0 = r7.aiJ;	 Catch:{ InterruptedException -> 0x0064, InterruptedException -> 0x0064 }
        r0 = r0.getActiveId();	 Catch:{ InterruptedException -> 0x0064, InterruptedException -> 0x0064 }
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ InterruptedException -> 0x0064, InterruptedException -> 0x0064 }
        r1 = r7.aiJ;	 Catch:{ InterruptedException -> 0x0064, InterruptedException -> 0x0064 }
        r1 = r1.getInstrumentType();	 Catch:{ InterruptedException -> 0x0064, InterruptedException -> 0x0064 }
        r8.<init>(r9, r0, r1);	 Catch:{ InterruptedException -> 0x0064, InterruptedException -> 0x0064 }
        r9 = com.iqoption.app.managers.c.Gn();	 Catch:{ InterruptedException -> 0x0064, InterruptedException -> 0x0064 }
        r8 = r9.b(r8);	 Catch:{ InterruptedException -> 0x0064, InterruptedException -> 0x0064 }
        r8 = r8 ^ 1;
        return r8;
    L_0x0064:
        r8 = move-exception;
        r9 = "shouldShowExpirationChooser";
        com.iqoption.core.i.d(r9, r8);
    L_0x006b:
        r8 = 0;
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.fragment.rightpanel.j.bt(long):boolean");
    }

    private void bu(long j) {
        if (bt(j)) {
            this.cFK.bQL.bRt.setBackgroundResource(R.drawable.grey_blur_15_spinner_selector);
            this.cFK.bQL.bRt.setOnTouchListener(this.cFA);
            this.cFK.bQL.bRt.setOnClickListener(this.cFL);
            this.cFK.bQL.bRv.setVisibility(0);
            return;
        }
        this.cFK.bQL.bRt.setBackground(null);
        this.cFK.bQL.bRt.setOnTouchListener(null);
        this.cFK.bQL.bRt.setOnClickListener(null);
        this.cFK.bQL.bRv.setVisibility(8);
    }

    private int anC() {
        return this.multiplier == 0 ? 1 : this.multiplier;
    }

    private void anD() {
        ActiveQuote da = com.iqoption.app.managers.c.Gn().da(this.aiJ.getActiveId());
        if (da == null) {
            this.cFK.bQL.bRJ.setText(null);
            this.cFK.bQL.bRl.clear();
            this.cFK.bQL.bRm.clear();
        } else if (!this.cEH.bl(this.cFK.bQK.getRoot())) {
            int anC = anC();
            InstrumentType instrumentType = getInstrumentType();
            this.cFK.bQL.bRJ.f(this.mask, da.getSpread(instrumentType, anC));
            if (this.cFi == null) {
                double ask = da.getAsk(instrumentType, anC);
                double bid = da.getBid(instrumentType, anC);
                this.cFK.bQL.bRl.f(this.mask, ask);
                this.cFK.bQL.bRm.f(this.mask, bid);
            }
        }
    }

    @NonNull
    View f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        int i = 0;
        this.cFK = (ahk) DataBindingUtil.inflate(layoutInflater, R.layout.right_panel_delegate_cfd, viewGroup, false);
        final f fVar = new f(this);
        this.cFB = new aw(this.cFK.bQL.bRw, this.cFK.bQL.bRu);
        this.cEG = new aw(this.cFK.bQL.bwP, this.cFK.bQL.bwO);
        this.cFC = new aw(this.cFK.bQL.bRD, this.cFK.bQL.bRz);
        this.cFk = new ax(this.cFK.bQL.bRc, this.cFK.bQL.bRf, this.cFK.bQL.bRs);
        this.cFl = new ax(this.cFK.bQK.bRc, this.cFK.bQK.bRf, this.cFK.bQK.bQQ, getContext().getResources().getDimension(R.dimen.dp48));
        this.cEH = new x(new w(this.cFK.bQK.getRoot()), this.cFK.bQL.getRoot(), this.cFK.bQK.getRoot());
        this.cFD = new x(this.cEK, this.cFK.bQL.bRr, this.cFK.bQL.bRp);
        this.cFE = new e(this.cFK.bQL.bRy);
        this.cFK.bQL.bRx.setLayoutTransition(bg.aGE());
        this.cFK.bQK.bQS.setLayoutTransition(bg.aGE());
        if (!this.cFm) {
            i = 8;
        }
        this.cFK.bQL.bRG.setVisibility(i);
        this.cFK.bQK.bRd.setVisibility(i);
        any();
        this.cFK.bQL.bRp.setBuyNewListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                fVar.and();
            }
        });
        OnClickListener anonymousClass4 = new com.iqoption.view.d.b() {
            public void q(View view) {
                switch (view.getId()) {
                    case R.id.amountLayout:
                        fVar.amY();
                        return;
                    case R.id.amountMinus:
                        fVar.amZ();
                        return;
                    case R.id.amountPlus:
                        fVar.ana();
                        return;
                    case R.id.buttonCall:
                        fVar.bh(view);
                        return;
                    case R.id.buttonPut:
                        fVar.bi(view);
                        return;
                    case R.id.cancelPendingOrder:
                        fVar.anN();
                        return;
                    case R.id.cancelSubmitPendingOrder:
                        fVar.anO();
                        return;
                    case R.id.limitsLayoutConfirm:
                        fVar.anP();
                        return;
                    case R.id.multiplierLayout:
                        fVar.anL();
                        return;
                    case R.id.pendingLayout:
                        fVar.anM();
                        return;
                    case R.id.pendingLayoutConfirm:
                        fVar.anM();
                        m.BJ();
                        return;
                    default:
                        return;
                }
            }
        };
        this.cFK.bQL.bRh.setOnClickListener(anonymousClass4);
        this.cFK.bQL.bRA.setOnClickListener(anonymousClass4);
        this.cFK.bQL.bRn.setOnClickListener(anonymousClass4);
        this.cFK.bQL.bRo.setOnClickListener(anonymousClass4);
        this.cFK.bQL.bRG.setOnClickListener(anonymousClass4);
        this.cFK.bQL.bRs.setOnClickListener(anonymousClass4);
        this.cFK.bQK.bQQ.setOnClickListener(anonymousClass4);
        this.cFK.bQK.bRd.setOnClickListener(anonymousClass4);
        this.cFK.bQK.bQW.setOnClickListener(anonymousClass4);
        this.cFK.bQK.bQM.setOnClickListener(new com.iqoption.view.d.b(1000) {
            public void q(View view) {
                if (j.this.cFi == null) {
                    fVar.anm();
                } else {
                    fVar.anl();
                }
            }
        });
        this.cFK.bQK.bQN.setOnClickListener(new com.iqoption.view.d.b(1000) {
            public void q(View view) {
                com.iqoption.marginaddon.b.aqN();
                if (j.this.cFi == null) {
                    fVar.anb();
                } else {
                    fVar.anj();
                }
            }
        });
        this.cFK.bQK.bnY.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                Point K = bg.K(view);
                bv.a(j.this.getFragmentManager(), R.id.fragment, K.x, K.y);
            }
        });
        this.cFK.bQK.bnT.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                Point K = bg.K(view);
                com.iqoption.core.microservices.tradingengine.response.a.a a = com.iqoption.app.helpers.a.FI().a(j.this.aiJ.getInstrumentType(), Integer.valueOf(j.this.aiJ.getActiveId()));
                ap.a(j.this.getFragmentManager(), R.id.fragment, K.x, K.y, j.this.cFz.format(a == null ? 0.0d : a.g(j.this.aTA, l.aGa().doubleValue())));
            }
        });
        OnClickListener anonymousClass9 = new com.iqoption.view.d.b() {
            public void q(View view) {
                Point K = bg.K(view);
                bw.a(j.this.getFragmentManager(), R.id.fragment, K.x, K.y, j.this.aTA, j.this.multiplier, j.this.cEL, j.this.cFq);
            }
        };
        this.cFK.bQK.bRa.setText(new bc().jO(getContext().getString(R.string.overnight_fee).toUpperCase()).C(' ').bM(new ImageSpan(getContext(), R.drawable.ic_info_commission, 1)).C(' ').aGw().aCT());
        this.cFK.bQK.bRa.setOnClickListener(anonymousClass9);
        this.cFK.bQK.bnW.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                double d;
                com.iqoption.core.microservices.tradingengine.response.a.a a = com.iqoption.app.helpers.a.FI().a(j.this.aiJ.getInstrumentType(), Integer.valueOf(j.this.aiJ.getActiveId()));
                if (a == null) {
                    d = 0.0d;
                } else {
                    d = a.f(j.this.aTA, l.aGa().doubleValue());
                }
                if (!com.google.common.c.a.b(0.0d, d, 0.001d)) {
                    Point K = bg.K(view);
                    bt.a(j.this.amV(), j.this.getFragmentManager(), R.id.fragment, K.x, K.y, d);
                }
                m.BH();
            }
        });
        y(Ea());
        anu();
        if (com.iqoption.app.a.Cw().Dh() && !com.iqoption.app.af.eN("multiplier_confirmed")) {
            this.cFK.getRoot().getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    j.this.cFK.getRoot().getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    com.iqoption.core.d.a.aSe.postDelayed(new o(this, bg.J(j.this.cFK.bQL.bRA)), 2000);
                }

                final /* synthetic */ void e(Rect rect) {
                    bo.a(j.this.amV(), j.this.getFragmentManager(), R.id.fragment, rect.left, rect.centerY());
                }
            });
        }
        anE();
        anG();
        return this.cFK.getRoot();
    }

    protected double Ea() {
        com.iqoption.app.a Cw = com.iqoption.app.a.Cw();
        double Ea = com.iqoption.app.af.DX().Ea();
        InstrumentType instrumentType = this.aiJ.getInstrumentType();
        double[] N = l.N(instrumentType);
        if (instrumentType == InstrumentType.FOREX_INSTRUMENT && com.iqoption.app.af.eM("first-deal-forex")) {
            double i;
            com.iqoption.app.af.i("first-deal-forex", false);
            int HO = com.iqoption.app.managers.feature.a.HO();
            if (HO > 0) {
                i = au.i(com.iqoption.app.a.Cw().Cx().doubleValue(), (double) HO);
                if (i < N[0]) {
                    i = N[0];
                }
                if (i > N[1]) {
                    i = N[1];
                }
                com.iqoption.app.af.DX().k(i);
            } else if (Ea != 0.0d) {
                return Ea;
            } else {
                if (Cw.Cy() == 4) {
                    i = c(Cw);
                } else {
                    i = N[0];
                }
            }
            return i;
        } else if (Ea != 0.0d) {
            return Ea;
        } else {
            if (Cw.Cy() == 4) {
                return c(Cw);
            }
            return N[0];
        }
    }

    private void ann() {
        this.ckA = null;
        this.ckB = null;
        this.cFo = null;
        this.cFp = null;
    }

    private void a(Double d, Double d2, Boolean bool, Boolean bool2) {
        this.ckA = d;
        this.ckB = d2;
        this.cFo = bool;
        this.cFp = bool2;
    }

    private void anE() {
        boolean z = anF() && com.iqoption.app.af.eN("otn_commmision");
        this.cFG = z;
    }

    private boolean anF() {
        boolean z = false;
        if (this.aiJ.getInstrumentType() == InstrumentType.FOREX_INSTRUMENT) {
            return false;
        }
        com.iqoption.app.a Cw = com.iqoption.app.a.Cw();
        Object obj = Cw.Cy() == 1 ? 1 : null;
        if (!((Cw.CA() != null ? 1 : null) == null || obj == null || !this.cFI)) {
            z = true;
        }
        return z;
    }

    private void b(boolean z, double d) {
        double doubleValue;
        double d2;
        CharSequence charSequence;
        boolean z2;
        com.iqoption.app.a Cw = com.iqoption.app.a.Cw();
        ConversionCurrency CF = Cw.CF();
        double doubleValue2 = l.c(CF).doubleValue();
        if (z) {
            String e;
            boolean z3;
            Balance CA = Cw.CA();
            ConversionCurrency eh = Cw.eh(Currencies.OTN_CURRENCY);
            String d3 = l.d(CF);
            String d4 = l.d(eh);
            doubleValue = l.c(eh).doubleValue();
            double doubleValue3 = l.d(l.e(Double.valueOf(Balance.getBalanceValue(CA)), Double.valueOf(doubleValue)), Double.valueOf(doubleValue2)).doubleValue() - d;
            d2 = doubleValue3;
            double d5 = doubleValue;
            String str = d3;
            String str2 = d4;
            if (com.google.common.c.a.b(Math.abs(doubleValue3), d, 0.001d)) {
                e = l.e(CF);
                z3 = false;
            } else {
                if (d2 > 0.0d) {
                    e = l.a(str2, Double.valueOf(l.d(l.e(Double.valueOf(d), Double.valueOf(doubleValue2)), Double.valueOf(d5)).doubleValue()), this.crm);
                } else {
                    String str3 = str2;
                    e = l.a(str, Double.valueOf(Math.abs(d2)), this.cEy);
                    double doubleValue4 = l.d(l.e(Double.valueOf(d - Math.abs(d2)), Double.valueOf(doubleValue2)), Double.valueOf(d5)).doubleValue();
                    e = String.format(Locale.US, "%s + %s", new Object[]{l.a(str3, Double.valueOf(doubleValue4), this.crm), e});
                }
                z3 = z;
            }
            charSequence = e;
            z2 = z3;
        } else {
            d2 = d;
            charSequence = l.e(CF);
            z2 = z;
        }
        if (this.cFH) {
            Double m = r.GT().m(doubleValue2);
            if (z2 || m == null || m.doubleValue() <= 0.0d || Math.abs(d2) <= 0.0d) {
                this.cFK.bQK.bnY.setVisibility(8);
                this.cFK.bQK.boa.setVisibility(8);
            } else {
                this.cFK.bQK.bnZ.setText(this.crm.format(Math.abs(d2) * m.doubleValue()));
                this.cFK.bQK.bnY.setVisibility(0);
                this.cFK.bQK.boa.setVisibility(0);
            }
        }
        this.cFG = z2;
        doubleValue = this.aTA;
        double abs = (d2 <= 0.0d || !z2) ? Math.abs(d2) : 0.0d;
        this.cFj = doubleValue + abs;
        this.cFK.bQK.bru.setText(l.a(this.cFj, this.cEy));
        this.cFK.bQK.bnV.setText(charSequence);
    }

    private void dw(boolean z) {
        double d;
        com.iqoption.core.microservices.tradingengine.response.a.a a = com.iqoption.app.helpers.a.FI().a(this.aiJ.getInstrumentType(), Integer.valueOf(this.aiJ.getActiveId()));
        if (a == null) {
            d = 0.0d;
        } else {
            d = a.f(this.aTA, l.aGa().doubleValue());
        }
        b(z, d);
    }

    private void anu() {
        com.iqoption.core.microservices.tradingengine.response.b.a y = aq.y(this.aiJ);
        if (y == null) {
            this.cFK.bQL.bRA.setOnClickListener(null);
        }
        setMultiplier(aq.a(y, getInstrumentType()));
    }

    void w(@NonNull com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
        super.w(aVar);
        x(aVar);
        anG();
        anu();
        ano();
        anE();
        ann();
        any();
        anq();
    }

    private void anG() {
        if (this.aiJ.isExpired()) {
            h(com.iqoption.app.managers.tab.a.Il().Iz());
            this.cFK.bQL.bRt.setVisibility(0);
            this.cFK.bQL.bRK.setVisibility(8);
            return;
        }
        this.cFK.bQL.bRt.setVisibility(8);
        this.cFK.bQL.bRK.setVisibility(0);
    }

    private void h(Expiration expiration) {
        this.cFK.bQL.bRw.setText(k.aw(expiration.expValue.longValue()));
        this.cFF = expiration;
    }

    private void dq(boolean z) {
        this.cFK.bQL.bRv.setSelected(z);
        this.cFK.bQL.bRt.setSelected(z);
        if (z) {
            this.cFB.select();
        } else {
            this.cFB.aoe();
        }
    }

    public void x(com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
        this.aiJ = aVar;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("%.");
        stringBuilder.append(aVar.getPrecision());
        stringBuilder.append("f");
        this.mask = stringBuilder.toString();
    }

    void destroy() {
        super.destroy();
        this.cFw.unregister();
        this.cFy.unregister();
        this.cFx.unregister();
        com.iqoption.view.a.b.aIK().b((com.iqoption.view.a.b.a) this);
        amT().removeObserver(this.cFr);
    }

    @Nullable
    public InstrumentType getInstrumentType() {
        return this.aiJ != null ? this.aiJ.instrumentType : null;
    }

    private int getActiveId() {
        return this.aiJ.getActiveId();
    }

    private void y(double d) {
        if (d < 0.0d) {
            d = 0.0d;
        }
        this.aTA = d;
        anq();
        amL();
        amM();
        anv();
    }

    private void amL() {
        this.cFK.bQL.bwP.setText(l.a(this.aTA, this.cEy));
    }

    private void amM() {
        double doubleValue = com.iqoption.app.a.Cw().Cx().doubleValue();
        double[] N = l.N(getInstrumentType());
        if (this.cFj > doubleValue || this.cFj > N[1] || this.cFj < N[0]) {
            this.cFK.bQL.bwP.setTextColor(this.ahh);
        } else {
            this.cFK.bQL.bwP.setTextColor(this.ahi);
        }
    }

    private void anv() {
        this.cFK.bQL.blC.setText(l.a(this.aTA * ((double) this.multiplier), this.cEy));
    }

    private void anH() {
        anu();
    }

    public void setMultiplier(int i) {
        this.multiplier = i;
        anw();
        anv();
        g IC = com.iqoption.app.managers.tab.a.Il().IC();
        if (IC != null) {
            IC.a("tabSetting.multiplier", Integer.valueOf(i));
        }
    }

    private void anw() {
        this.cFK.bQL.bRD.setText(p.ea(this.multiplier));
    }

    void dr(boolean z) {
        this.cFK.bQL.bRh.setSelected(z);
        if (z) {
            this.cEG.select();
        } else {
            this.cEG.aoe();
        }
    }

    void ds(boolean z) {
        this.cEL = z;
    }

    void anI() {
        this.cFM = m.BK();
        this.cEH.L(this.cFK.bQK.getRoot());
        anD();
        ant();
        anr();
        anA();
        anJ();
    }

    private void anJ() {
        if (this.cFJ && com.iqoption.app.a.Cw().Dh() && com.iqoption.marginaddon.b.aqK()) {
            View root = this.cFK.getRoot();
            root.getClass();
            com.iqoption.core.ext.a.a(root, l.bk(root), new m(this, root));
        }
    }

    final /* synthetic */ kotlin.l bj(View view) {
        com.iqoption.marginaddon.b.aqM();
        Display defaultDisplay = ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        Point K = bg.K(this.cFK.bQK.bQW);
        com.iqoption.marginaddon.a.a(amV(), (int) R.id.other_fragment, (point.x - K.x) + getContext().getResources().getDimensionPixelOffset(R.dimen.dp8));
        return kotlin.l.etX;
    }

    void anr() {
        if (this.cFq == null || this.multiplier <= 1) {
            this.cFK.bQK.bQZ.setVisibility(8);
            return;
        }
        Double i = this.cFq.i(getCalendar().get(7), this.cEL);
        if (i != null) {
            this.cFK.bQK.bRb.setText(p.e(i.doubleValue(), 4));
        } else {
            this.cFK.bQK.bRb.setText(R.string.n_a);
        }
        this.cFK.bQK.bQZ.setVisibility(0);
    }

    void ant() {
        if (this.cEH.bl(this.cFK.bQK.getRoot())) {
            this.cFK.bQK.blS.setText(l.a(this.aTA, this.cEy));
            this.cFK.bQK.blT.setText(p.ea(this.multiplier));
            Context context = getContext();
            this.cFK.bQK.bQN.setBackgroundResource(this.cEL ? R.drawable.btn_green_background : R.drawable.btn_red_background);
            RobotoTextView robotoTextView = this.cFK.bQK.bQN;
            Double d = this.cFi;
            int i = R.string.confirm;
            robotoTextView.setText(d == null ? R.string.confirm : R.string.submit);
            robotoTextView = this.cFK.bQK.bQR;
            bc bcVar = new bc();
            if (this.cFi != null) {
                i = R.string.pending;
            }
            bcVar = bcVar.jO(context.getString(i).toUpperCase()).jO(" ").bM(new ForegroundColorSpan(this.cEL ? this.ahg : this.ahh));
            if (this.cEL) {
                i = R.string.buy;
            } else {
                i = R.string.sell;
            }
            robotoTextView.setText(bcVar.jO(context.getString(i).toUpperCase()).aGw().aCT());
            if (this.ckA == null && this.ckB == null) {
                this.cFK.bQK.bQY.setText(getContext().getString(R.string.not_set).toUpperCase());
            } else {
                this.cFK.bQK.bQY.setText(new bc().bM(new ForegroundColorSpan(this.ckA == null ? this.ahi : this.ahg)).jO(this.ckA == null ? getContext().getString(R.string.n_a) : p.n(this.ckA.doubleValue())).aGw().jO(" ").bM(new ForegroundColorSpan(this.ckB == null ? this.ahi : this.ahh)).jO(this.ckB == null ? getContext().getString(R.string.n_a) : p.n(this.ckB.doubleValue())).aGw().aCT());
            }
            if (com.iqoption.app.helpers.a.FI().h(this.aiJ.getInstrumentType())) {
                double d2;
                com.iqoption.core.microservices.tradingengine.response.a.a a = com.iqoption.app.helpers.a.FI().a(this.aiJ.getInstrumentType(), Integer.valueOf(this.aiJ.getActiveId()));
                if (a == null) {
                    d2 = 0.0d;
                } else {
                    d2 = a.f(this.aTA, l.aGa().doubleValue());
                }
                if (com.google.common.c.a.b(0.0d, d2, 0.001d)) {
                    this.cFj = this.aTA;
                    this.cFK.bQK.bnV.setText(R.string.free);
                    this.cFK.bQK.bnR.setText(null);
                    this.cFK.bQK.bru.setText(l.a(this.cFj, this.cEy));
                    this.cFK.bQK.bnX.setVisibility(8);
                    this.cFK.bQK.bnY.setVisibility(8);
                    this.cFK.bQK.boa.setVisibility(8);
                    this.cFK.bQK.bnW.setClickable(false);
                    this.cFK.bQK.bnW.setOnTouchListener(null);
                } else {
                    this.cFj = this.aTA + d2;
                    this.cFK.bQK.bnR.setText(l.a(d2, this.cEy));
                    this.cFK.bQK.bru.setText(l.a(this.cFj, this.cEy));
                    if (anF()) {
                        this.cFK.bQK.bnX.setVisibility(0);
                        this.cFK.bQK.bnW.setClickable(true);
                        this.cFK.bQK.bnW.setOnTouchListener(new com.iqoption.view.d.c());
                        b(com.iqoption.app.af.eN("otn_commmision"), d2);
                        r.GT().GV();
                    } else {
                        this.cFG = false;
                        this.cFK.bQK.bnX.setVisibility(8);
                        this.cFK.bQK.bnW.setOnTouchListener(null);
                        this.cFK.bQK.bnW.setClickable(false);
                        this.cFK.bQK.bnV.setText(l.e(com.iqoption.app.a.Cw().CF()));
                        this.cFK.bQK.bnY.setVisibility(8);
                        this.cFK.bQK.boa.setVisibility(8);
                    }
                    this.cFK.bQK.bnV.setVisibility(0);
                }
                this.cFK.bQK.bnW.setVisibility(0);
                return;
            }
            this.cFK.bQK.bnW.setVisibility(8);
        }
    }

    private void ans() {
        this.cFj = this.cFh.a(this.aTA, this.aiJ, this.cFG);
    }

    private void anq() {
        if (this.cEH.bl(this.cFK.bQK.getRoot())) {
            ant();
        } else {
            ans();
        }
    }

    void ano() {
        this.cEH.L(this.cFK.bQL.getRoot());
        m.a(this.cFM, this.aiJ.getInstrumentType(), com.iqoption.app.a.Cw());
    }

    private void any() {
        if (this.cFm) {
            if (this.cEH.bl(this.cFK.bQK.getRoot())) {
                anA();
            } else {
                anz();
            }
            j(null);
            anB();
        }
    }

    private void anz() {
        if (this.cFm) {
            com.iqoption.gl.b.aow().glchSetLimitOrder(-1.0d, this.cEL, 0);
        }
    }

    private void anA() {
        if (this.cFm && this.cEH.bl(this.cFK.bQK.getRoot())) {
            com.iqoption.gl.b.aow().glchSetLimitOrder(this.cFi == null ? -1.0d : this.cFi.doubleValue(), this.cEL, 1);
        }
    }

    private void amP() {
        this.cFD.L(this.cFK.bQL.bRr);
    }

    private void amQ() {
        this.cFD.L(this.cFK.bQL.bRp);
    }

    void j(Double d) {
        if (this.cFm) {
            if (d == null && this.cFi != null) {
                this.cFK.bQL.bRf.setText(R.string.market);
                this.cFK.bQK.bRf.setText(R.string.market);
                this.cFK.bQL.bRE.animate().alpha(0.0f).setDuration(200).setInterpolator(com.iqoption.view.a.a.d.dEM);
                this.cFK.bQL.bRF.animate().alpha(0.0f).setDuration(200).setInterpolator(com.iqoption.view.a.a.d.dEM);
                this.cFK.bQL.bRl.animate().alpha(1.0f).setDuration(200).setInterpolator(com.iqoption.view.a.a.d.dEM);
                this.cFK.bQL.bRm.animate().alpha(1.0f).setDuration(200).setInterpolator(com.iqoption.view.a.a.d.dEM);
                this.cFK.bQL.bRj.animate().alpha(1.0f).setDuration(200).setInterpolator(com.iqoption.view.a.a.d.dEM);
                this.cFK.bQL.bRk.animate().alpha(1.0f).setDuration(200).setInterpolator(com.iqoption.view.a.a.d.dEM);
            } else if (d != null) {
                this.cFK.bQL.bRf.setText(String.format(Locale.US, this.mask, new Object[]{d}));
                this.cFK.bQK.bRf.setText(String.format(Locale.US, this.mask, new Object[]{d}));
                if (this.cFi == null) {
                    this.cFK.bQL.bRE.animate().alpha(1.0f).setDuration(200).setInterpolator(com.iqoption.view.a.a.d.dEM);
                    this.cFK.bQL.bRF.animate().alpha(1.0f).setDuration(200).setInterpolator(com.iqoption.view.a.a.d.dEM);
                    this.cFK.bQL.bRj.animate().alpha(0.45f).setDuration(200).setInterpolator(com.iqoption.view.a.a.d.dEM);
                    this.cFK.bQL.bRk.animate().alpha(0.45f).setDuration(200).setInterpolator(com.iqoption.view.a.a.d.dEM);
                    this.cFK.bQL.bRl.clear();
                    this.cFK.bQL.bRm.clear();
                    this.cFK.bQL.bRl.setText(R.string.pending);
                    this.cFK.bQL.bRm.setText(R.string.pending);
                    this.cFK.bQL.bRl.animate().alpha(0.45f).setDuration(200).setInterpolator(com.iqoption.view.a.a.d.dEM);
                    this.cFK.bQL.bRm.animate().alpha(0.45f).setDuration(200).setInterpolator(com.iqoption.view.a.a.d.dEM);
                }
            }
            this.cFi = d;
            ant();
            anD();
        }
    }

    void dv(boolean z) {
        this.cFK.bQL.bRG.setSelected(z);
        this.cFK.bQK.bRd.setSelected(z);
        if (z) {
            this.cFk.eY(1);
            this.cFl.eY(1);
            return;
        }
        anB();
    }

    void anB() {
        if (this.cFi == null) {
            this.cFk.eY(0);
            this.cFl.eY(0);
            return;
        }
        this.cFk.eY(2);
        this.cFl.eY(2);
    }

    void dx(boolean z) {
        this.cFK.bQL.bRA.setSelected(z);
        if (z) {
            this.cFC.select();
        } else {
            this.cFC.aoe();
        }
    }

    void dy(boolean z) {
        this.cFK.bQK.bQW.setSelected(z);
    }

    void dz(boolean z) {
        this.cFK.bQK.bnW.setSelected(z);
    }

    void dA(boolean z) {
        this.cFK.bQK.bnU.setSelected(z);
    }

    void du(boolean z) {
        this.cFK.bQK.bRa.setSelected(z);
    }

    void dB(boolean z) {
        this.cFK.bQK.bnY.setSelected(z);
    }

    void dC(boolean z) {
        if (z) {
            this.cFE.start();
        } else {
            this.cFE.stop();
        }
    }

    private void anK() {
        m.a(this.aiJ.getInstrumentType(), com.iqoption.app.a.Cw());
    }

    private void dD(boolean z) {
        if (z) {
            m.BG();
        } else {
            m.BF();
        }
    }

    private void a(Order order, Double d, Double d2, Boolean bool) {
        d2 = com.iqoption.dialog.c.a.a(d2, order.getAvgPriceEnrolled(), Order.BUY.equalsIgnoreCase(order.getSide()), order.getLeverageGL().intValue());
        d = com.iqoption.dialog.c.a.a(d, order.getAvgPriceEnrolled(), Order.BUY.equalsIgnoreCase(order.getSide()), order.getLeverageGL().intValue());
        if (d2 != null || d != null) {
            com.iqoption.mobbtech.connect.request.api.a.c.a(order.getPositionId(), d, d2, bool);
        }
    }

    public void amJ() {
        Boolean valueOf;
        Double currentOpenPriceEnrolled = this.cFi != null ? this.cFi : ActiveQuote.getCurrentOpenPriceEnrolled(getActiveId(), this.cEL, getInstrumentType(), anC());
        Double a = com.iqoption.dialog.c.a.a(this.ckA, currentOpenPriceEnrolled, this.cEL, this.multiplier);
        currentOpenPriceEnrolled = com.iqoption.dialog.c.a.a(this.ckB, currentOpenPriceEnrolled, this.cEL, this.multiplier);
        Boolean bool = null;
        if (this.cFn) {
            valueOf = Boolean.valueOf(this.cFo == null ? com.iqoption.settings.b.aDQ().En() : this.cFo.booleanValue());
        } else {
            valueOf = null;
        }
        if (this.cki) {
            bool = Boolean.valueOf(this.cFp == null ? com.iqoption.settings.b.aDQ().Eo() : this.cFp.booleanValue());
        }
        s a2 = com.iqoption.mobbtech.connect.request.api.a.c.a(new com.iqoption.mobbtech.connect.request.api.a.c.a().a((com.iqoption.core.microservices.tradingengine.response.active.h) this.aiJ).fs(this.multiplier).z(this.aTA).bF(com.iqoption.app.a.Cw().getBalanceId().longValue()).ec(this.cEL).ed(this.cFG).m(this.cFi).n(a).o(currentOpenPriceEnrolled).q(valueOf));
        if (this.cFi == null) {
            ag.b(o.a(ag.a(a2, new n(this)), 10, TimeUnit.SECONDS, com.iqoption.core.d.a.aSd), new a(this, this.ckA, this.ckB, bool));
        }
    }
}
