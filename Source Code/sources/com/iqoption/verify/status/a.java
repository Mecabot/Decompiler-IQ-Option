package com.iqoption.verify.status;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.d.tl;
import com.iqoption.mobbtech.connect.response.CardStatus;
import com.iqoption.mobbtech.connect.response.q;
import com.iqoption.mobbtech.connect.response.r;
import com.iqoption.verify.list.f;
import com.iqoption.x.R;
import java.util.HashMap;
import kotlin.TypeCastException;
import kotlin.d;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000 22\u00020\u00012\u00020\u0002:\u00012B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH&J\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020#H\u0002J\b\u0010%\u001a\u00020#H\u0002J\b\u0010&\u001a\u00020#H\u0002J\b\u0010'\u001a\u00020\u0011H\u0016J&\u0010(\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010+\u001a\u00020#H\u0016J\b\u0010,\u001a\u00020#H\u0016J\u001a\u0010-\u001a\u00020#2\u0006\u0010.\u001a\u00020\u001b2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0018\u0010/\u001a\u00020#2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u00100\u001a\u00020\u0011H\u0004J\b\u00101\u001a\u00020#H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8DX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u00020\u00168DX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u0017\u0010\u0018¨\u00063"}, aXE = {"Lcom/iqoption/verify/status/BaseVerifyStatusFragment;", "Lcom/iqoption/fragment/base/IQAnimationFragment;", "Lcom/iqoption/view/BackController$OnBackListener;", "()V", "binding", "Lcom/iqoption/databinding/FragmentVerifyStatusBinding;", "getBinding", "()Lcom/iqoption/databinding/FragmentVerifyStatusBinding;", "setBinding", "(Lcom/iqoption/databinding/FragmentVerifyStatusBinding;)V", "card", "Lcom/iqoption/mobbtech/connect/response/VerifyCard;", "getCard", "()Lcom/iqoption/mobbtech/connect/response/VerifyCard;", "card$delegate", "Lkotlin/Lazy;", "clearBackStackOnClose", "", "getClearBackStackOnClose", "()Z", "clearBackStackOnClose$delegate", "status", "Lcom/iqoption/mobbtech/connect/response/CardStatus;", "getStatus", "()Lcom/iqoption/mobbtech/connect/response/CardStatus;", "status$delegate", "getFooterView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "getLastPanDigits", "", "initCardName", "", "initImage", "initStatus", "initToolbar", "onClose", "onCreateView", "savedInstanceState", "Landroid/os/Bundle;", "onHideAnimation", "onShowAnimation", "onViewCreated", "view", "openScreenForStatus", "clearBackStack", "prepareImageSize", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: BaseVerifyStatusFragment.kt */
public abstract class a extends com.iqoption.fragment.base.b implements com.iqoption.view.e.a {
    public static final String TAG = "com.iqoption.verify.status.a";
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "card", "getCard()Lcom/iqoption/mobbtech/connect/response/VerifyCard;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), NotificationCompat.CATEGORY_STATUS, "getStatus()Lcom/iqoption/mobbtech/connect/response/CardStatus;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "clearBackStackOnClose", "getClearBackStackOnClose()Z"))};
    public static final a dxZ = new a();
    private HashMap atz;
    protected tl dxW;
    private final d dxX = g.f(new BaseVerifyStatusFragment$status$2(this));
    private final d dxY = g.f(new BaseVerifyStatusFragment$clearBackStackOnClose$2(this));
    private final d dxz = g.f(new BaseVerifyStatusFragment$card$2(this));

    @i(aXC = {1, 1, 11}, aXD = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u0007J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, aXE = {"Lcom/iqoption/verify/status/BaseVerifyStatusFragment$Companion;", "", "()V", "ANIMATION_FOLDER_NAME", "", "ARG_CARD", "ARG_CLEAR_BACK_STACK_ON_CLOSE", "ARG_REFRESH_DESCRIPTION", "ARG_STATUS", "TAG", "newInstance", "Lcom/iqoption/verify/status/BaseVerifyStatusFragment;", "card", "Lcom/iqoption/mobbtech/connect/response/VerifyCard;", "status", "Lcom/iqoption/mobbtech/connect/response/CardStatus;", "clearBackStackOnClose", "", "refreshDescription", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: BaseVerifyStatusFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public static /* synthetic */ a a(a aVar, q qVar, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return aVar.b(qVar, z);
        }

        public final a b(q qVar, boolean z) {
            h.e(qVar, "card");
            return a(qVar, qVar.auX(), false, z);
        }

        public static /* bridge */ /* synthetic */ a a(a aVar, q qVar, CardStatus cardStatus, boolean z, boolean z2, int i, Object obj) {
            if ((i & 8) != 0) {
                z2 = false;
            }
            return aVar.a(qVar, cardStatus, z, z2);
        }

        public final a a(q qVar, CardStatus cardStatus, boolean z, boolean z2) {
            h.e(qVar, "card");
            h.e(cardStatus, NotificationCompat.CATEGORY_STATUS);
            a f = i.dys.f(cardStatus);
            Bundle bundle = new Bundle();
            bundle.putParcelable("ARG_CARD", qVar);
            bundle.putSerializable("ARG_STATUS", cardStatus);
            bundle.putBoolean("ARG_CLEAR_BACK_STACK_ON_CLOSE", z);
            bundle.putBoolean("ARG_REFRESH_DESCRIPTION", z2);
            f.setArguments(bundle);
            return f;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: BaseVerifyStatusFragment.kt */
    static final class b implements OnClickListener {
        final /* synthetic */ a this$0;

        b(a aVar) {
            this.this$0 = aVar;
        }

        public final void onClick(View view) {
            this.this$0.aN();
        }
    }

    private final boolean aGZ() {
        d dVar = this.dxY;
        j jVar = apP[2];
        return ((Boolean) dVar.getValue()).booleanValue();
    }

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
    }

    protected final q aGO() {
        d dVar = this.dxz;
        j jVar = apP[0];
        return (q) dVar.getValue();
    }

    protected final CardStatus auX() {
        d dVar = this.dxX;
        j jVar = apP[1];
        return (CardStatus) dVar.getValue();
    }

    public abstract View g(LayoutInflater layoutInflater, ViewGroup viewGroup);

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        KH();
    }

    static {
        if (a.class.getName() == null) {
            h.aXZ();
        }
    }

    protected final tl aGY() {
        tl tlVar = this.dxW;
        if (tlVar == null) {
            h.lS("binding");
        }
        return tlVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.e(layoutInflater, "inflater");
        tl E = tl.E(layoutInflater, viewGroup, false);
        h.d(E, "this");
        this.dxW = E;
        h.d(E, "FragmentVerifyStatusBind….apply { binding = this }");
        return E.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        tl tlVar = this.dxW;
        if (tlVar == null) {
            h.lS("binding");
        }
        ViewCompat.requestApplyInsets(tlVar.getRoot());
        LayoutInflater from = LayoutInflater.from(getContext());
        h.d(from, "inflater");
        tl tlVar2 = this.dxW;
        if (tlVar2 == null) {
            h.lS("binding");
        }
        FrameLayout frameLayout = tlVar2.bFB;
        h.d(frameLayout, "binding.verifyStatusFooter");
        view = g(from, frameLayout);
        tlVar2 = this.dxW;
        if (tlVar2 == null) {
            h.lS("binding");
        }
        tlVar2.bFB.addView(view);
        apX();
        aHa();
        aHc();
        aHd();
    }

    public boolean onClose() {
        FragmentManager p = com.iqoption.core.ext.a.p(this);
        if (p.getBackStackEntryCount() == 0) {
            com.iqoption.core.ext.a.n(this).finish();
        } else if (!aGZ()) {
            p.popBackStack();
        } else if (com.iqoption.core.ext.a.p(this).findFragmentByTag(f.TAG) != null) {
            p.popBackStack(f.TAG, 0);
        } else {
            com.iqoption.core.ext.a.n(this).finish();
        }
        return true;
    }

    private final void apX() {
        CardStatus auX = auX();
        int i = auX == CardStatus.VERIFIED ? R.string.verified_ : auX == CardStatus.DECLINED ? R.string.declined : r.auZ().contains(auX) ? R.string.verification : R.string.verification_;
        tl tlVar = this.dxW;
        if (tlVar == null) {
            h.lS("binding");
        }
        View root = tlVar.getRoot();
        h.d(root, "binding.root");
        Toolbar toolbar = (Toolbar) root.findViewById(com.iqoption.b.a.toolbar);
        com.iqoption.kyc.i.a((AppCompatActivity) ajV(), toolbar, i);
        toolbar.setNavigationOnClickListener(new b(this));
    }

    private final void aHa() {
        aHb();
        tl tlVar = this.dxW;
        if (tlVar == null) {
            h.lS("binding");
        }
        LottieAnimationView lottieAnimationView = tlVar.bFC;
        if (auX() == CardStatus.DECLINED) {
            lottieAnimationView.setImageDrawable(getDrawable(R.drawable.ic_declined));
            return;
        }
        CardStatus auX = auX();
        String str = auX == CardStatus.VERIFIED ? "verified.json" : r.auZ().contains(auX) ? "awaiting_verification.json" : "non_verified.json";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("lottie/verification/");
        stringBuilder.append(str);
        lottieAnimationView.setAnimation(stringBuilder.toString());
        lottieAnimationView.cT();
    }

    private final void aHb() {
        int dimensionPixelSize;
        int dimensionPixelSize2;
        tl tlVar = this.dxW;
        if (tlVar == null) {
            h.lS("binding");
        }
        LottieAnimationView lottieAnimationView = tlVar.bFC;
        h.d(lottieAnimationView, "imageView");
        LayoutParams layoutParams = lottieAnimationView.getLayoutParams();
        switch (auX()) {
            case VERIFIED:
                dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dp170);
                dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.dp120);
                break;
            case DECLINED:
                dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dp119);
                dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.dp119);
                break;
            default:
                dimensionPixelSize = layoutParams.width;
                dimensionPixelSize2 = layoutParams.height;
                break;
        }
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = dimensionPixelSize2;
        lottieAnimationView.setLayoutParams(layoutParams);
    }

    private final void aHc() {
        CardStatus auX = auX();
        int i = auX == CardStatus.VERIFIED ? R.string.card_verified : auX == CardStatus.DECLINED ? R.string.declined : r.auZ().contains(auX) ? R.string.awaiting_verification : R.string.verify_your_card;
        tl tlVar = this.dxW;
        if (tlVar == null) {
            h.lS("binding");
        }
        tlVar.bFE.setText(i);
    }

    /* JADX WARNING: Missing block: B:3:0x0012, code:
            if (r0 != null) goto L_0x0017;
     */
    private final void aHd() {
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
        r1 = r3.aHe();
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2.append(r0);
        r0 = " **";
        r2.append(r0);
        r2.append(r1);
        r0 = r2.toString();
        r1 = r3.dxW;
        if (r1 != 0) goto L_0x0038;
    L_0x0033:
        r2 = "binding";
        kotlin.jvm.internal.h.lS(r2);
    L_0x0038:
        r1 = r1.bFy;
        r2 = "binding.verifyStatusCard";
        kotlin.jvm.internal.h.d(r1, r2);
        r0 = (java.lang.CharSequence) r0;
        r1.setText(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.verify.status.a.aHd():void");
    }

    private final String aHe() {
        String number = aGO().getNumber();
        int length = number.length() - 4;
        if (number == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        number = number.substring(length);
        h.d(number, "(this as java.lang.String).substring(startIndex)");
        return number;
    }

    public void ND() {
        tl tlVar = this.dxW;
        if (tlVar == null) {
            h.lS("binding");
        }
        View root = tlVar.getRoot();
        h.d(root, "binding.root");
        root.setAlpha(0.0f);
        tlVar = this.dxW;
        if (tlVar == null) {
            h.lS("binding");
        }
        root = tlVar.getRoot();
        h.d(root, "binding.root");
        root.setTranslationX(eN(R.dimen.dp64));
        tlVar = this.dxW;
        if (tlVar == null) {
            h.lS("binding");
        }
        tlVar.getRoot().animate().translationX(0.0f).alpha(1.0f).setInterpolator(com.iqoption.view.a.a.d.dEM).setDuration(getAnimationDuration()).start();
    }

    public void NE() {
        tl tlVar = this.dxW;
        if (tlVar == null) {
            h.lS("binding");
        }
        tlVar.getRoot().animate().translationX(eN(R.dimen.dp64)).alpha(0.0f).setInterpolator(com.iqoption.view.a.a.d.dEM).setDuration(getAnimationDuration()).start();
    }

    protected final void a(CardStatus cardStatus, boolean z) {
        h.e(cardStatus, NotificationCompat.CATEGORY_STATUS);
        com.iqoption.core.ext.a.p(this).beginTransaction().add(R.id.fragmentContainer, a.a(dxZ, aGO(), cardStatus, z, false, 8, null), TAG).addToBackStack(TAG).commit();
    }
}
