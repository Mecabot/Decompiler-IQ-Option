package com.iqoption.verify.status;

import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.transition.AutoTransition;
import android.support.transition.Transition;
import android.support.transition.Transition.TransitionListener;
import android.support.transition.TransitionListenerAdapter;
import android.support.transition.TransitionManager;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.d.ade;
import com.iqoption.d.ale;
import com.iqoption.dto.entity.iqbus.VerifyInitData;
import com.iqoption.dto.entity.iqbus.VerifyInitResult;
import com.iqoption.fragment.as;
import com.iqoption.mobbtech.connect.response.CardStatus;
import com.iqoption.util.af;
import com.iqoption.util.be;
import com.iqoption.view.text.n;
import com.iqoption.view.text.q;
import com.iqoption.view.text.y;
import com.iqoption.x.R;
import com.jumio.MobileSDK;
import com.jumio.dv.DocumentVerificationSDK;
import java.util.HashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 F2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001FB\u0005¢\u0006\u0002\u0010\u0005J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\"\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u001aH\u0016J\u0012\u0010%\u001a\u00020\u001a2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010(\u001a\u00020\u001aH\u0016J\u001a\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020+2\b\u0010 \u001a\u0004\u0018\u00010,H\u0002J\u0010\u0010-\u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010.\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020\u0013H\u0002J-\u00100\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001e2\u000e\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u000203022\u0006\u00104\u001a\u000205H\u0016¢\u0006\u0002\u00106J\u0010\u00107\u001a\u00020\u001a2\u0006\u00108\u001a\u00020'H\u0016J\b\u00109\u001a\u00020\u001aH\u0002J\u001a\u0010:\u001a\u00020\u001a2\u0006\u0010;\u001a\u00020\u00152\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010<\u001a\u00020\u001aH\u0002J\b\u0010=\u001a\u00020\u001aH\u0002J\b\u0010>\u001a\u00020\u001aH\u0002J\u0010\u0010?\u001a\u00020\u001a2\u0006\u0010@\u001a\u000203H\u0002J\b\u0010A\u001a\u00020\u001aH\u0002J$\u0010B\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020\u00132\u0006\u0010C\u001a\u00020#2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010EH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000¨\u0006G"}, aXE = {"Lcom/iqoption/verify/status/PerformVerifyFragment;", "Lcom/iqoption/verify/status/BaseVerifyStatusFragment;", "Lcom/iqoption/view/BackController$OnBackListener;", "Lcom/iqoption/verify/status/VerifyHintBottomSheetFragment$OnMakePhotoListener;", "Lcom/iqoption/fragment/DarkDialogFragment$OnDialogListener;", "()V", "backBinding", "Lcom/iqoption/databinding/VerifySideItemBinding;", "footerBinding", "Lcom/iqoption/databinding/PerformVerifyFooterBinding;", "frontBinding", "verifyState", "Lcom/iqoption/verify/status/VerifyState;", "viewModel", "Lcom/iqoption/verify/status/PerformVerifyViewModel;", "addSideItem", "container", "Landroid/widget/LinearLayout;", "cardSide", "Lcom/iqoption/verify/status/CardSide;", "getFooterView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "initDescription", "", "initFooter", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "", "onConfirm", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDialogClose", "onInitialized", "userId", "", "Lcom/iqoption/verify/status/PerformVerifyData;", "onMakePhotoClick", "onNextScanClick", "side", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onSaveInstanceState", "outState", "onVerificationCompleted", "onViewCreated", "view", "performNextScan", "showContentUI", "showErrorUI", "showPermissionAbsenceSnack", "permission", "showProgressUI", "showSideCompleted", "animate", "listener", "Landroid/support/transition/Transition$TransitionListener;", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: PerformVerifyFragment.kt */
public final class g extends a implements com.iqoption.fragment.as.b, com.iqoption.verify.status.j.b, com.iqoption.view.e.a {
    public static final a dyi = new a();
    private HashMap atz;
    private ale dyd;
    private ale dye;
    private l dyf;
    private ade dyg;
    private PerformVerifyViewModel dyh;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, aXE = {"Lcom/iqoption/verify/status/PerformVerifyFragment$Companion;", "", "()V", "REQUEST_CODE_VERIFY_CARD_PERMISSIONS", "", "STATE_VERIFY", "", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: PerformVerifyFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: PerformVerifyFragment.kt */
    static final class b implements OnClickListener {
        final /* synthetic */ CardSide dyj;
        final /* synthetic */ g this$0;

        b(g gVar, CardSide cardSide) {
            this.this$0 = gVar;
            this.dyj = cardSide;
        }

        public final void onClick(View view) {
            com.iqoption.verify.status.j.a aVar = j.dyv;
            FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
            h.d(childFragmentManager, "childFragmentManager");
            aVar.a(childFragmentManager, R.id.verifyStatusOther, new e(this.dyj));
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: PerformVerifyFragment.kt */
    static final class c implements OnClickListener {
        final /* synthetic */ CardSide dyj;
        final /* synthetic */ g this$0;

        c(g gVar, CardSide cardSide) {
            this.this$0 = gVar;
            this.dyj = cardSide;
        }

        public final void onClick(View view) {
            this.this$0.b(this.dyj);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: PerformVerifyFragment.kt */
    static final class g implements OnClickListener {
        final /* synthetic */ g this$0;

        g(g gVar) {
            this.this$0 = gVar;
        }

        public final void onClick(View view) {
            be.bS(this.this$0.getContext());
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, aXE = {"com/iqoption/verify/status/PerformVerifyFragment$initDescription$clickableSpan$1", "Lcom/iqoption/view/text/TouchableSpan;", "onClick", "", "textView", "Landroid/view/View;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: PerformVerifyFragment.kt */
    public static final class d extends y {
        final /* synthetic */ String dyk;
        final /* synthetic */ int dyl;
        final /* synthetic */ int dym;
        final /* synthetic */ g this$0;

        d(g gVar, String str, int i, int i2, int i3, int i4) {
            this.this$0 = gVar;
            this.dyk = str;
            this.dyl = i;
            this.dym = i2;
            super(i3, i4);
        }

        public void onClick(View view) {
            h.e(view, "textView");
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.dyk));
            intent.addFlags(268435456);
            this.this$0.startActivity(intent);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "result", "Lcom/iqoption/verify/status/PerformVerifyData;", "onChanged"})
    /* compiled from: PerformVerifyFragment.kt */
    static final class f<T> implements Observer<f> {
        final /* synthetic */ long $userId;
        final /* synthetic */ g this$0;

        f(g gVar, long j) {
            this.this$0 = gVar;
            this.$userId = j;
        }

        /* renamed from: a */
        public final void onChanged(f fVar) {
            this.this$0.a(this.$userId, fVar);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, aXE = {"com/iqoption/verify/status/PerformVerifyFragment$onActivityResult$1", "Landroid/support/transition/TransitionListenerAdapter;", "onTransitionEnd", "", "transition", "Landroid/support/transition/Transition;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: PerformVerifyFragment.kt */
    public static final class e extends TransitionListenerAdapter {
        final /* synthetic */ boolean dyn;
        final /* synthetic */ g this$0;

        e(g gVar, boolean z) {
            this.this$0 = gVar;
            this.dyn = z;
        }

        public void onTransitionEnd(Transition transition) {
            h.e(transition, "transition");
            if (this.this$0.isAdded() && this.dyn) {
                TransitionManager.beginDelayedTransition(this.this$0.aGY().bFB);
                this.this$0.acu();
            }
        }
    }

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
    }

    public void ahp() {
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        KH();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.dyf = (l) bundle.getParcelable("STATE_VERIFY");
        }
        this.dyh = PerformVerifyViewModel.dyr.ab(this);
    }

    public void onViewCreated(View view, Bundle bundle) {
        h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        aHk();
        if (this.dyf == null) {
            acu();
            long userId = com.iqoption.app.a.aL(getContext()).getUserId();
            PerformVerifyViewModel performVerifyViewModel = this.dyh;
            if (performVerifyViewModel == null) {
                h.lS("viewModel");
            }
            performVerifyViewModel.v(userId, aGO().getId()).observe(this, new f(this, userId));
        } else {
            acw();
            l lVar = this.dyf;
            if (lVar != null) {
                CardSide aHs = lVar.aHs();
                if (aHs != null) {
                    a(this, aHs, false, null, 4, null);
                }
            }
        }
        aHl();
    }

    public void onSaveInstanceState(Bundle bundle) {
        h.e(bundle, "outState");
        bundle.putParcelable("STATE_VERIFY", this.dyf);
        super.onSaveInstanceState(bundle);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == DocumentVerificationSDK.REQUEST_CODE) {
            l lVar = this.dyf;
            if (lVar == null) {
                h.aXZ();
            }
            if (i2 == -1) {
                CardSide aHt = lVar.aHt();
                boolean z = lVar.aHs() != CardSide.NONE;
                a(aHt, true, (TransitionListener) new e(this, z));
                if (z) {
                    PerformVerifyViewModel performVerifyViewModel = this.dyh;
                    if (performVerifyViewModel == null) {
                        h.lS("viewModel");
                    }
                    VerifyInitData decrypt = lVar.aHq().decrypt();
                    if (decrypt == null) {
                        h.aXZ();
                    }
                    af.a(performVerifyViewModel.iu(decrypt.getUuid()), new PerformVerifyFragment$onActivityResult$2(this), new PerformVerifyFragment$onActivityResult$3(this), null, 4, null);
                    performVerifyViewModel = this.dyh;
                    if (performVerifyViewModel == null) {
                        h.lS("viewModel");
                    }
                    performVerifyViewModel.aHn();
                } else {
                    lVar.c(aHt);
                }
            }
            lVar.d(CardSide.NONE);
        }
    }

    private final void aHj() {
        a(CardStatus.VERIFY_PENDING, true);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        h.e(strArr, "permissions");
        h.e(iArr, "grantResults");
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 300) {
            if (((iArr.length == 0 ? 1 : 0) ^ 1) != 0) {
                i = iArr.length;
                for (int i2 = 0; i2 < i; i2++) {
                    if (iArr[i2] != 0) {
                        jR(strArr[i2]);
                        return;
                    }
                }
                aHm();
            } else {
                com.iqoption.app.a.b.aT(getContext());
            }
        }
    }

    public boolean onBackPressed() {
        Object obj;
        FragmentManager childFragmentManager = getChildFragmentManager();
        l lVar = this.dyf;
        CardSide aHs = lVar != null ? lVar.aHs() : null;
        if (aHs != null) {
            switch (aHs) {
                case FRONT:
                case BACK:
                    obj = 1;
                    break;
            }
        }
        obj = null;
        if (obj == null) {
            return super.aN();
        }
        com.iqoption.fragment.as.a aVar = as.coZ;
        h.d(childFragmentManager, "fm");
        CharSequence string = getString(R.string.confirm_back);
        String string2 = getString(R.string.you_still_need_to_upload_the_other_side);
        h.d(string2, "getString(R.string.you_s…to_upload_the_other_side)");
        aVar.a(childFragmentManager, R.id.verifyStatusOther, string, string2, getString(R.string.cancel), getString(R.string.confirm));
        return true;
    }

    private final void jR(String str) {
        Snackbar make = Snackbar.make((View) aGY().bFz, (int) R.string.please_enable_camera_access, 0);
        if (!shouldShowRequestPermissionRationale(str)) {
            make.setAction((int) R.string.settings, (OnClickListener) new g(this));
        }
        make.show();
    }

    private final void aHk() {
        View root = aGY().getRoot();
        h.d(root, "binding.root");
        LinearLayout linearLayout = (LinearLayout) root.findViewById(com.iqoption.b.a.performVerifyContainer);
        h.d(linearLayout, "container");
        this.dyd = a(linearLayout, CardSide.FRONT);
        ale ale = this.dyd;
        if (ale == null) {
            h.lS("frontBinding");
        }
        ale.bUc.setText(R.string.front_side);
        this.dye = a(linearLayout, CardSide.BACK);
        ale ale2 = this.dye;
        if (ale2 == null) {
            h.lS("backBinding");
        }
        ale2.bUc.setText(R.string.back_side);
    }

    private final ale a(LinearLayout linearLayout, CardSide cardSide) {
        ale aB = ale.aB(LayoutInflater.from(getContext()), linearLayout, true);
        LinearLayout linearLayout2 = aB.bUd;
        h.d(linearLayout2, "binding.verifySideUploaded");
        com.iqoption.core.ext.a.M(linearLayout2);
        aB.bUb.setOnTouchListener(new com.iqoption.view.d.c());
        aB.bUb.setOnClickListener(new b(this, cardSide));
        aB.bTZ.setOnClickListener(new c(this, cardSide));
        h.d(aB, "binding");
        return aB;
    }

    public void a(CardSide cardSide) {
        h.e(cardSide, "cardSide");
        b(cardSide);
    }

    private final void acu() {
        ade ade = this.dyg;
        if (ade == null) {
            h.lS("footerBinding");
        }
        ContentLoadingProgressBar contentLoadingProgressBar = ade.bNX;
        h.d(contentLoadingProgressBar, "footerBinding.performVerifyProgress");
        contentLoadingProgressBar.setVisibility(0);
        ade = this.dyg;
        if (ade == null) {
            h.lS("footerBinding");
        }
        TextView textView = ade.bNW;
        h.d(textView, "footerBinding.performVerifyError");
        com.iqoption.core.ext.a.M(textView);
        ade = this.dyg;
        if (ade == null) {
            h.lS("footerBinding");
        }
        LinearLayout linearLayout = ade.bNV;
        h.d(linearLayout, "footerBinding.performVerifyContainer");
        com.iqoption.core.ext.a.M(linearLayout);
    }

    private final void acv() {
        ade ade = this.dyg;
        if (ade == null) {
            h.lS("footerBinding");
        }
        ContentLoadingProgressBar contentLoadingProgressBar = ade.bNX;
        h.d(contentLoadingProgressBar, "footerBinding.performVerifyProgress");
        com.iqoption.core.ext.a.M(contentLoadingProgressBar);
        ade = this.dyg;
        if (ade == null) {
            h.lS("footerBinding");
        }
        TextView textView = ade.bNW;
        h.d(textView, "footerBinding.performVerifyError");
        com.iqoption.core.ext.a.L(textView);
        ade = this.dyg;
        if (ade == null) {
            h.lS("footerBinding");
        }
        LinearLayout linearLayout = ade.bNV;
        h.d(linearLayout, "footerBinding.performVerifyContainer");
        com.iqoption.core.ext.a.M(linearLayout);
    }

    private final void acw() {
        ade ade = this.dyg;
        if (ade == null) {
            h.lS("footerBinding");
        }
        LinearLayout linearLayout = ade.bNV;
        h.d(linearLayout, "footerBinding.performVerifyContainer");
        com.iqoption.core.ext.a.L(linearLayout);
        ade = this.dyg;
        if (ade == null) {
            h.lS("footerBinding");
        }
        TextView textView = ade.bNW;
        h.d(textView, "footerBinding.performVerifyError");
        com.iqoption.core.ext.a.M(textView);
        ade = this.dyg;
        if (ade == null) {
            h.lS("footerBinding");
        }
        ContentLoadingProgressBar contentLoadingProgressBar = ade.bNX;
        h.d(contentLoadingProgressBar, "footerBinding.performVerifyProgress");
        com.iqoption.core.ext.a.M(contentLoadingProgressBar);
    }

    static /* bridge */ /* synthetic */ void a(g gVar, CardSide cardSide, boolean z, TransitionListener transitionListener, int i, Object obj) {
        if ((i & 4) != 0) {
            transitionListener = (TransitionListener) null;
        }
        gVar.a(cardSide, z, transitionListener);
    }

    private final void a(CardSide cardSide, boolean z, TransitionListener transitionListener) {
        ale ale;
        switch (cardSide) {
            case FRONT:
                ale = this.dyd;
                if (ale == null) {
                    h.lS("frontBinding");
                    break;
                }
                break;
            case BACK:
                ale = this.dye;
                if (ale == null) {
                    h.lS("backBinding");
                    break;
                }
                break;
            case NONE:
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
        if (z) {
            AutoTransition autoTransition = new AutoTransition();
            if (transitionListener != null) {
                autoTransition.addListener(transitionListener);
            }
            View root = ale.getRoot();
            if (root == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
            }
            TransitionManager.beginDelayedTransition((ViewGroup) root, autoTransition);
        }
        TextView textView = ale.bTZ;
        h.d(textView, "sideBinding.verifySideButton");
        com.iqoption.core.ext.a.M(textView);
        LinearLayout linearLayout = ale.bUd;
        h.d(linearLayout, "sideBinding.verifySideUploaded");
        com.iqoption.core.ext.a.L(linearLayout);
        ImageView imageView = ale.bUa;
        h.d(imageView, "sideBinding.verifySideHint");
        com.iqoption.core.ext.a.hide(imageView);
        ale.bUb.setOnTouchListener(null);
        ale.bUb.setOnClickListener(null);
    }

    private final void a(long j, f fVar) {
        if (fVar != null) {
            acw();
            VerifyInitResult aHh = fVar.aHh();
            String str = fVar.aHi().nameIso;
            h.d(str, "data.country.nameIso");
            this.dyf = new l(j, aHh, str, CardSide.NONE, CardSide.NONE);
            return;
        }
        acv();
    }

    public View g(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        h.e(layoutInflater, "inflater");
        h.e(viewGroup, "container");
        ade ai = ade.ai(layoutInflater, viewGroup, false);
        h.d(ai, "PerformVerifyFooterBindi…flater, container, false)");
        this.dyg = ai;
        ai = this.dyg;
        if (ai == null) {
            h.lS("footerBinding");
        }
        View root = ai.getRoot();
        h.d(root, "footerBinding.root");
        return root;
    }

    private final void aHl() {
        String string = getString(R.string.aml_policy);
        String bY = q.bY(com.iqoption.core.ext.a.m(this));
        String string2 = getString(R.string.in_order_to_confirm_your_card_ownership_n1, string);
        CharSequence charSequence = string2;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        TextView textView = aGY().bFA;
        int color = getColor(R.color.white);
        int color2 = getColor(R.color.white_60);
        d dVar = new d(this, bY, color, color2, color, color2);
        h.d(string2, "text");
        h.d(string, "linkText");
        int a = v.a(charSequence, string, 0, false, 6, null);
        int length = string.length() + a;
        spannableStringBuilder.setSpan(dVar, a, length, 33);
        spannableStringBuilder.setSpan(new StyleSpan(1), a, length, 33);
        h.d(textView, "textView");
        textView.setText(spannableStringBuilder);
        textView.setMovementMethod(new n());
        textView.setHighlightColor(0);
    }

    private final void b(CardSide cardSide) {
        l lVar = this.dyf;
        if (lVar == null) {
            h.aXZ();
        }
        lVar.d(cardSide);
        PerformVerifyViewModel performVerifyViewModel = this.dyh;
        if (performVerifyViewModel == null) {
            h.lS("viewModel");
        }
        if (performVerifyViewModel.a(com.iqoption.core.ext.a.n(this), lVar) != null) {
            Object missingPermissions = MobileSDK.getMissingPermissions(getContext());
            h.d(missingPermissions, "missingPermissions");
            if ((missingPermissions.length == 0 ? 1 : null) != null) {
                aHm();
                return;
            } else {
                requestPermissions(missingPermissions, 300);
                return;
            }
        }
        acv();
    }

    private final void aHm() {
        l lVar = this.dyf;
        if (lVar == null) {
            h.aXZ();
        }
        PerformVerifyViewModel performVerifyViewModel = this.dyh;
        if (performVerifyViewModel == null) {
            h.lS("viewModel");
        }
        DocumentVerificationSDK a = performVerifyViewModel.a(com.iqoption.core.ext.a.n(this), lVar);
        if (a != null) {
            a.setDocumentName(getString(lVar.aHt() == CardSide.FRONT ? R.string.front_side : R.string.back_side));
            startActivityForResult(a.getIntent(), DocumentVerificationSDK.REQUEST_CODE);
            return;
        }
        acv();
    }

    public void ahq() {
        onClose();
    }
}
