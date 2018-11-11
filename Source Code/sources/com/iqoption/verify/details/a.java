package com.iqoption.verify.details;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.d.tj;
import com.iqoption.mobbtech.connect.response.CardStatus;
import com.iqoption.mobbtech.connect.response.q;
import com.iqoption.mobbtech.connect.response.r;
import com.iqoption.x.R;
import java.util.HashMap;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 #2\u00020\u0001:\u0001#B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u0012\u001a\u00020\fH\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J&\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\fH\u0016J\b\u0010\u001e\u001a\u00020\fH\u0016J\u001a\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010!\u001a\u00020\fH\u0002J\b\u0010\"\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006$"}, aXE = {"Lcom/iqoption/verify/details/VerifyDetailsFragment;", "Lcom/iqoption/fragment/base/IQAnimationFragment;", "()V", "binding", "Lcom/iqoption/databinding/FragmentVerifyDetailsBinding;", "card", "Lcom/iqoption/mobbtech/connect/response/VerifyCard;", "getCard", "()Lcom/iqoption/mobbtech/connect/response/VerifyCard;", "card$delegate", "Lkotlin/Lazy;", "initButton", "", "status", "Lcom/iqoption/mobbtech/connect/response/CardStatus;", "initStatus", "initStatusIcon", "initStatusText", "initToolbar", "onClose", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onHideAnimation", "onShowAnimation", "onViewCreated", "view", "openPerformVerificationScreen", "openStatusScreen", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: VerifyDetailsFragment.kt */
public final class a extends com.iqoption.fragment.base.b {
    public static final String TAG = "com.iqoption.verify.details.a";
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "card", "getCard()Lcom/iqoption/mobbtech/connect/response/VerifyCard;"))};
    public static final a dxA = new a();
    private HashMap atz;
    private tj dxy;
    private final kotlin.d dxz = g.f(new VerifyDetailsFragment$card$2(this));

    @i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, aXE = {"Lcom/iqoption/verify/details/VerifyDetailsFragment$Companion;", "", "()V", "ARG_CARD", "", "TAG", "newInstance", "Lcom/iqoption/verify/details/VerifyDetailsFragment;", "card", "Lcom/iqoption/mobbtech/connect/response/VerifyCard;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: VerifyDetailsFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final a e(q qVar) {
            h.e(qVar, "card");
            a aVar = new a();
            Bundle bundle = new Bundle();
            bundle.putParcelable("ARG_CARD", qVar);
            aVar.setArguments(bundle);
            return aVar;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: VerifyDetailsFragment.kt */
    static final class b implements OnClickListener {
        final /* synthetic */ a this$0;

        b(a aVar) {
            this.this$0 = aVar;
        }

        public final void onClick(View view) {
            this.this$0.aGQ();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: VerifyDetailsFragment.kt */
    static final class c implements OnClickListener {
        final /* synthetic */ a this$0;

        c(a aVar) {
            this.this$0 = aVar;
        }

        public final void onClick(View view) {
            this.this$0.aGP();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: VerifyDetailsFragment.kt */
    static final class d implements OnClickListener {
        final /* synthetic */ a this$0;

        d(a aVar) {
            this.this$0 = aVar;
        }

        public final void onClick(View view) {
            this.this$0.aN();
        }
    }

    private final q aGO() {
        kotlin.d dVar = this.dxz;
        j jVar = apP[0];
        return (q) dVar.getValue();
    }

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        KH();
    }

    static {
        if (a.class.getName() == null) {
            h.aXZ();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.e(layoutInflater, "inflater");
        tj D = tj.D(layoutInflater, viewGroup, false);
        h.d(D, "this");
        this.dxy = D;
        h.d(D, "FragmentVerifyDetailsBin….apply { binding = this }");
        return D.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        tj tjVar = this.dxy;
        if (tjVar == null) {
            h.lS("binding");
        }
        ViewCompat.requestApplyInsets(tjVar.getRoot());
        CardStatus auX = aGO().auX();
        apX();
        a(auX);
        tj tjVar2 = this.dxy;
        if (tjVar2 == null) {
            h.lS("binding");
        }
        TextView textView = tjVar2.bFt;
        h.d(textView, "binding.verifyCardNumber");
        textView.setText(aGO().getNumber());
        tjVar2 = this.dxy;
        if (tjVar2 == null) {
            h.lS("binding");
        }
        textView = tjVar2.bFr;
        h.d(textView, "binding.verifyCardExpiryDate");
        textView.setText(aGO().auW());
        d(auX);
    }

    public boolean onClose() {
        com.iqoption.core.ext.a.p(this).popBackStack();
        return true;
    }

    /* JADX WARNING: Missing block: B:3:0x0012, code:
            if (r0 != null) goto L_0x0017;
     */
    private final void apX() {
        /*
        r3 = this;
        r0 = r3.aGO();
        r0 = r0.getNumber();
        r0 = com.iqoption.core.util.a.gV(r0);
        if (r0 == 0) goto L_0x0015;
    L_0x000e:
        r0 = r0.toString();
        if (r0 == 0) goto L_0x0015;
    L_0x0014:
        goto L_0x0017;
    L_0x0015:
        r0 = "";
    L_0x0017:
        r1 = r3.dxy;
        if (r1 != 0) goto L_0x0020;
    L_0x001b:
        r2 = "binding";
        kotlin.jvm.internal.h.lS(r2);
    L_0x0020:
        r1 = r1.getRoot();
        r2 = "binding.root";
        kotlin.jvm.internal.h.d(r1, r2);
        r2 = com.iqoption.b.a.toolbar;
        r1 = r1.findViewById(r2);
        r1 = (android.support.v7.widget.Toolbar) r1;
        r2 = r3.ajV();
        r2 = (android.support.v7.app.AppCompatActivity) r2;
        r0 = (java.lang.CharSequence) r0;
        com.iqoption.kyc.i.a(r2, r1, r0);
        r0 = new com.iqoption.verify.details.a$d;
        r0.<init>(r3);
        r0 = (android.view.View.OnClickListener) r0;
        r1.setNavigationOnClickListener(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.verify.details.a.apX():void");
    }

    private final void a(CardStatus cardStatus) {
        tj tjVar = this.dxy;
        if (tjVar == null) {
            h.lS("binding");
        }
        TextView textView = tjVar.bFs;
        h.d(textView, "binding.verifyCardInvite");
        com.iqoption.core.ext.a.M(textView);
        tjVar = this.dxy;
        if (tjVar == null) {
            h.lS("binding");
        }
        View view = tjVar.bFx;
        if (view == null) {
            h.aXZ();
        }
        tj tjVar2;
        LinearLayout linearLayout;
        if (cardStatus != CardStatus.VERIFIED) {
            h.d(view, "topDivider");
            com.iqoption.core.ext.a.L(view);
            tjVar = this.dxy;
            if (tjVar == null) {
                h.lS("binding");
            }
            LinearLayout linearLayout2 = tjVar.bFu;
            h.d(linearLayout2, "binding.verifyCardStatusContainer");
            com.iqoption.core.ext.a.L(linearLayout2);
            b(cardStatus);
            c(cardStatus);
            if (cardStatus == CardStatus.DECLINED || r.auZ().contains(cardStatus)) {
                tjVar2 = this.dxy;
                if (tjVar2 == null) {
                    h.lS("binding");
                }
                TextView textView2 = tjVar2.bFs;
                h.d(textView2, "binding.verifyCardInvite");
                com.iqoption.core.ext.a.L(textView2);
                tjVar2 = this.dxy;
                if (tjVar2 == null) {
                    h.lS("binding");
                }
                tjVar2.bFu.setOnClickListener(new c(this));
                tjVar2 = this.dxy;
                if (tjVar2 == null) {
                    h.lS("binding");
                }
                linearLayout = tjVar2.bFu;
                h.d(linearLayout, "binding.verifyCardStatusContainer");
                linearLayout.setEnabled(true);
                return;
            }
            tjVar2 = this.dxy;
            if (tjVar2 == null) {
                h.lS("binding");
            }
            linearLayout = tjVar2.bFu;
            h.d(linearLayout, "binding.verifyCardStatusContainer");
            linearLayout.setEnabled(false);
            return;
        }
        h.d(view, "topDivider");
        com.iqoption.core.ext.a.M(view);
        tjVar2 = this.dxy;
        if (tjVar2 == null) {
            h.lS("binding");
        }
        linearLayout = tjVar2.bFu;
        h.d(linearLayout, "binding.verifyCardStatusContainer");
        com.iqoption.core.ext.a.M(linearLayout);
    }

    private final void b(CardStatus cardStatus) {
        tj tjVar = this.dxy;
        if (tjVar == null) {
            h.lS("binding");
        }
        ImageView imageView = tjVar.bFv;
        Integer valueOf = cardStatus == CardStatus.DECLINED ? Integer.valueOf(R.drawable.ic_attention_transparent) : r.auZ().contains(cardStatus) ? Integer.valueOf(R.drawable.ic_progress) : null;
        if (valueOf != null) {
            h.d(imageView, "imageView");
            com.iqoption.core.ext.a.L(imageView);
            imageView.setImageDrawable(ContextCompat.getDrawable(com.iqoption.core.ext.a.m(this), valueOf.intValue()));
            return;
        }
        h.d(imageView, "imageView");
        com.iqoption.core.ext.a.M(imageView);
    }

    private final void c(CardStatus cardStatus) {
        tj tjVar = this.dxy;
        if (tjVar == null) {
            h.lS("binding");
        }
        TextView textView = tjVar.bFw;
        int i = cardStatus == CardStatus.DECLINED ? R.string.declined : r.auZ().contains(cardStatus) ? R.string.awaiting_verification : R.string.card_non_verified;
        int i2 = r.auZ().contains(cardStatus) ? R.color.slate_grey : R.color.red;
        textView.setText(i);
        textView.setTextColor(ContextCompat.getColor(com.iqoption.core.ext.a.m(this), i2));
    }

    private final void d(CardStatus cardStatus) {
        tj tjVar = this.dxy;
        if (tjVar == null) {
            h.lS("binding");
        }
        Button button = tjVar.bFq;
        if (cardStatus == CardStatus.VERIFIED || r.auZ().contains(cardStatus)) {
            h.d(button, "button");
            com.iqoption.core.ext.a.M(button);
            return;
        }
        button.setOnClickListener(new b(this));
        h.d(button, "button");
        com.iqoption.core.ext.a.L(button);
    }

    private final void aGP() {
        com.iqoption.core.ext.a.p(this).beginTransaction().add(R.id.fragmentContainer, com.iqoption.verify.status.a.a.a(com.iqoption.verify.status.a.dxZ, aGO(), false, 2, null), com.iqoption.verify.status.a.TAG).addToBackStack(com.iqoption.verify.status.a.TAG).commit();
    }

    private final void aGQ() {
        com.iqoption.core.ext.a.p(this).beginTransaction().add(R.id.fragmentContainer, com.iqoption.verify.status.a.a.a(com.iqoption.verify.status.a.dxZ, aGO(), CardStatus.NEW, false, false, 8, null), com.iqoption.verify.status.a.TAG).addToBackStack(com.iqoption.verify.status.a.TAG).commit();
    }

    public void ND() {
        tj tjVar = this.dxy;
        if (tjVar == null) {
            h.lS("binding");
        }
        View root = tjVar.getRoot();
        h.d(root, "binding.root");
        root.setAlpha(0.0f);
        tjVar = this.dxy;
        if (tjVar == null) {
            h.lS("binding");
        }
        root = tjVar.getRoot();
        h.d(root, "binding.root");
        root.setTranslationX(eN(R.dimen.dp64));
        tjVar = this.dxy;
        if (tjVar == null) {
            h.lS("binding");
        }
        tjVar.getRoot().animate().translationX(0.0f).alpha(1.0f).setInterpolator(com.iqoption.view.a.a.d.dEM).setDuration(getAnimationDuration()).start();
    }

    public void NE() {
        tj tjVar = this.dxy;
        if (tjVar == null) {
            h.lS("binding");
        }
        tjVar.getRoot().animate().translationX(eN(R.dimen.dp64)).alpha(0.0f).setInterpolator(com.iqoption.view.a.a.d.dEM).setDuration(getAnimationDuration()).start();
    }
}
