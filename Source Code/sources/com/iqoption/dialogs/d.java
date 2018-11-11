package com.iqoption.dialogs;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.transition.AutoTransition;
import android.support.transition.TransitionManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.iqoption.core.f;
import com.iqoption.core.ui.widget.StarBar;
import com.iqoption.dialogs.c.e;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.l;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 !2\u00020\u0001:\u0001!B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0014\u001a\u00020\u000eJ&\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u000eH\u0016J\b\u0010\u001e\u001a\u00020\u000eH\u0016J\b\u0010\u001f\u001a\u00020\u000eH\u0002J\b\u0010 \u001a\u00020\u000eH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\b\u001a\u0004\b\u0011\u0010\u0012¨\u0006\""}, aXE = {"Lcom/iqoption/dialogs/RateUsDialog;", "Lcom/iqoption/core/ui/fragment/IQFragment;", "()V", "animatorFactory", "Lcom/iqoption/core/ui/dialog/DialogAnimatorFactory;", "getAnimatorFactory", "()Lcom/iqoption/core/ui/dialog/DialogAnimatorFactory;", "animatorFactory$delegate", "Lkotlin/Lazy;", "binding", "Lcom/iqoption/dialogs/databinding/DialogRateUsBinding;", "onOpenSupportChat", "Lkotlin/Function1;", "", "", "transition", "Landroid/support/transition/AutoTransition;", "getTransition", "()Landroid/support/transition/AutoTransition;", "transition$delegate", "close", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onEnterAnimation", "onExitAnimation", "openPlayMarket", "scheduleTransition", "Companion", "dialogs_release"})
/* compiled from: RateUsDialog.kt */
public final class d extends com.iqoption.core.ui.fragment.b {
    private static final String TAG = "d";
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(d.class), "animatorFactory", "getAnimatorFactory()Lcom/iqoption/core/ui/dialog/DialogAnimatorFactory;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(d.class), "transition", "getTransition()Landroid/support/transition/AutoTransition;"))};
    public static final a ckG = new a();
    private final kotlin.d aGB = g.f(RateUsDialog$transition$2.ckI);
    private kotlin.jvm.a.b<? super Integer, l> ckD;
    private final kotlin.d ckE = g.f(new RateUsDialog$animatorFactory$2(this));
    private com.iqoption.dialogs.a.a ckF;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bR\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, aXE = {"Lcom/iqoption/dialogs/RateUsDialog$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "newInstance", "Lcom/iqoption/dialogs/RateUsDialog;", "onOpenSupportChat", "Lkotlin/Function1;", "", "", "dialogs_release"})
    /* compiled from: RateUsDialog.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/dialogs/RateUsDialog$onCreateView$1$1"})
    /* compiled from: RateUsDialog.kt */
    static final class b implements OnClickListener {
        final /* synthetic */ d this$0;

        b(d dVar) {
            this.this$0 = dVar;
        }

        public final void onClick(View view) {
            this.this$0.close();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/dialogs/RateUsDialog$onCreateView$1$3"})
    /* compiled from: RateUsDialog.kt */
    static final class d implements OnClickListener {
        final /* synthetic */ com.iqoption.dialogs.a.a ckH;
        final /* synthetic */ d this$0;

        d(com.iqoption.dialogs.a.a aVar, d dVar) {
            this.ckH = aVar;
            this.this$0 = dVar;
        }

        public final void onClick(View view) {
            this.this$0.close();
            StarBar starBar = this.ckH.bmT;
            h.d(starBar, "starBar");
            int stars = starBar.getStars();
            if (stars < 4) {
                kotlin.jvm.a.b b = this.this$0.ckD;
                if (b != null) {
                    l lVar = (l) b.invoke(Integer.valueOf(stars));
                    return;
                }
                return;
            }
            this.this$0.afD();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, aXE = {"<anonymous>", "", "it", "", "onStarsChanged", "com/iqoption/dialogs/RateUsDialog$onCreateView$1$2"})
    /* compiled from: RateUsDialog.kt */
    static final class c implements com.iqoption.core.ui.widget.StarBar.b {
        final /* synthetic */ com.iqoption.dialogs.a.a ckH;
        final /* synthetic */ d this$0;

        c(com.iqoption.dialogs.a.a aVar, d dVar) {
            this.ckH = aVar;
            this.this$0 = dVar;
        }

        public final void dv(int i) {
            this.this$0.afC();
            if (i == 0) {
                TextView textView = this.ckH.ckQ;
                h.d(textView, "btnAction");
                com.iqoption.core.ext.a.M(textView);
                return;
            }
            TextView textView2 = this.ckH.ckQ;
            h.d(textView2, "btnAction");
            com.iqoption.core.ext.a.L(textView2);
            textView2 = this.ckH.ckQ;
            h.d(textView2, "btnAction");
            d dVar = this.this$0;
            if (i < 4) {
                i = e.rate_us_dialog_send_feedback;
            } else {
                i = e.rate_us_dialog_leave_review;
            }
            textView2.setText(dVar.getString(i));
        }
    }

    private final com.iqoption.core.ui.d.a afA() {
        kotlin.d dVar = this.ckE;
        j jVar = apP[0];
        return (com.iqoption.core.ui.d.a) dVar.getValue();
    }

    private final AutoTransition afB() {
        kotlin.d dVar = this.aGB;
        j jVar = apP[1];
        return (AutoTransition) dVar.getValue();
    }

    public static final /* synthetic */ com.iqoption.dialogs.a.a d(d dVar) {
        com.iqoption.dialogs.a.a aVar = dVar.ckF;
        if (aVar == null) {
            h.lS("binding");
        }
        return aVar;
    }

    public void KF() {
        com.iqoption.core.ui.d.a.a(afA(), 0, 1, null).start();
    }

    public void KG() {
        com.iqoption.core.ui.d.a.b(afA(), 0, 1, null).start();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.e(layoutInflater, "inflater");
        if (this.ckD == null) {
            com.iqoption.core.i.d(TAG, "Callback is null -> closing");
            return null;
        }
        com.iqoption.dialogs.a.a aVar = (com.iqoption.dialogs.a.a) com.iqoption.core.ext.a.a((Fragment) this, com.iqoption.dialogs.c.d.dialog_rate_us, viewGroup, false, 4, null);
        this.ckF = aVar;
        aVar.awS.setOnClickListener(new b(this));
        aVar.bmT.setOnStarsChangedListener(new c(aVar, this));
        aVar.ckQ.setOnClickListener(new d(aVar, this));
        return aVar.getRoot();
    }

    private final void afC() {
        com.iqoption.dialogs.a.a aVar = this.ckF;
        if (aVar == null) {
            h.lS("binding");
        }
        TransitionManager.beginDelayedTransition(aVar.btF, afB());
    }

    private final void afD() {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(f.Dp().DI()));
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            com.iqoption.core.i.w(TAG, "Play market is not found", e);
            f.a(e.error, 0, 2, null);
        }
    }

    public final void close() {
        com.iqoption.core.ext.a.p(this).popBackStack();
    }
}
