package com.iqoption.withdrawal.common;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.NestedScrollView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.d.an;
import com.iqoption.mobbtech.connect.response.g;
import com.iqoption.withdrawal.common.fields.d;
import com.iqoption.withdrawal.common.history.l;
import com.iqoption.withdrawal.common.methods.f;
import com.iqoption.x.R;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u001b2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0002J\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0002J\b\u0010\u001a\u001a\u00020\u000eH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, aXE = {"Lcom/iqoption/withdrawal/common/WithdrawActivity;", "Lcom/iqoption/activity/IQActivity;", "Lcom/iqoption/withdrawal/common/MethodsCallback;", "Lcom/iqoption/withdrawal/common/WithdrawLimitReasonDialog$OnCloseListener;", "()V", "binding", "Lcom/iqoption/databinding/ActivityWithdrawBinding;", "fieldsFragment", "Lcom/iqoption/withdrawal/common/fields/WithdrawFieldsFragment;", "historyFragment", "Lcom/iqoption/withdrawal/common/history/WithdrawHistoryFragment;", "methodsFragment", "Lcom/iqoption/withdrawal/common/methods/WithdrawMethodsFragment;", "initToolbar", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDialogClose", "onLoadingFail", "error", "Lcom/iqoption/mobbtech/connect/response/MobbError;", "onLoadingSuccess", "hasMethods", "", "showContentUi", "showProgressUi", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: WithdrawActivity.kt */
public final class WithdrawActivity extends com.iqoption.activity.b implements c, com.iqoption.withdrawal.common.e.b {
    public static final a dPP = new a();
    private an dPL;
    private f dPM;
    private d dPN;
    private l dPO;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, aXE = {"Lcom/iqoption/withdrawal/common/WithdrawActivity$Companion;", "", "()V", "start", "", "activity", "Landroid/app/Activity;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: WithdrawActivity.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final void start(Activity activity) {
            h.e(activity, "activity");
            activity.startActivity(new Intent(activity, WithdrawActivity.class));
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: WithdrawActivity.kt */
    static final class b implements OnClickListener {
        final /* synthetic */ WithdrawActivity dPQ;

        b(WithdrawActivity withdrawActivity) {
            this.dPQ = withdrawActivity;
        }

        public final void onClick(View view) {
            this.dPQ.finish();
        }
    }

    public static final void start(Activity activity) {
        dPP.start(activity);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        h.d(window, "window");
        window.getDecorView().setBackgroundColor(ContextCompat.getColor(this, R.color.white));
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, R.layout.activity_withdraw);
        h.d(contentView, "DataBindingUtil.setConte…layout.activity_withdraw)");
        this.dPL = (an) contentView;
        apX();
        aMS();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (bundle == null) {
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            this.dPM = f.dRH.aNT();
            beginTransaction.add(R.id.withdrawMethodsContainer, this.dPM, f.TAG);
            this.dPN = d.dQp.aNp();
            beginTransaction.add(R.id.withdrawFieldsContainer, this.dPN, d.TAG);
            this.dPO = l.dRq.aNI();
            l lVar = this.dPO;
            if (lVar == null) {
                h.lS("historyFragment");
            }
            beginTransaction.add(R.id.withdrawHistoryContainer, lVar, l.TAG);
            beginTransaction.commit();
        } else {
            this.dPM = (f) supportFragmentManager.findFragmentByTag(f.TAG);
            this.dPN = (d) supportFragmentManager.findFragmentByTag(d.TAG);
            Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(l.TAG);
            if (findFragmentByTag == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.iqoption.withdrawal.common.history.WithdrawHistoryFragment");
            }
            this.dPO = (l) findFragmentByTag;
            e eVar = (e) supportFragmentManager.findFragmentByTag(e.dPW.Ll());
            if (eVar != null) {
                eVar.a(this);
            }
        }
        f fVar = this.dPM;
        if (fVar != null) {
            fVar.a((c) this);
        }
    }

    private final void apX() {
        an anVar = this.dPL;
        if (anVar == null) {
            h.lS("binding");
        }
        View root = anVar.getRoot();
        h.d(root, "binding.root");
        ((ImageView) root.findViewById(com.iqoption.b.a.toolbarBack)).setOnClickListener(new b(this));
        anVar = this.dPL;
        if (anVar == null) {
            h.lS("binding");
        }
        root = anVar.getRoot();
        h.d(root, "binding.root");
        TextView textView = (TextView) root.findViewById(com.iqoption.b.a.toolbarTitle);
        h.d(textView, "binding.root.toolbarTitle");
        textView.setText(getString(R.string.withdrawal));
    }

    public void b(g gVar) {
        h.e(gVar, "error");
        gVar.bG(this);
        finish();
    }

    public void fw(boolean z) {
        aMT();
        if (!z && this.dPM != null) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            supportFragmentManager.beginTransaction().remove(this.dPM).remove(this.dPN).commitAllowingStateLoss();
            String string = getString(R.string.there_are_no_available_withdrawal_methods);
            com.iqoption.withdrawal.common.e.a aVar = e.dPW;
            h.d(supportFragmentManager, "fm");
            h.d(string, "message");
            aVar.a(supportFragmentManager, R.id.withdrawOtherContainer, null, string).a(this);
        }
    }

    public void ahp() {
        finish();
    }

    private final void aMS() {
        an anVar = this.dPL;
        if (anVar == null) {
            h.lS("binding");
        }
        NestedScrollView nestedScrollView = anVar.biR;
        h.d(nestedScrollView, "binding.withdrawContent");
        com.iqoption.core.ext.a.M(nestedScrollView);
        anVar = this.dPL;
        if (anVar == null) {
            h.lS("binding");
        }
        FrameLayout frameLayout = anVar.biW;
        h.d(frameLayout, "binding.withdrawProgress");
        com.iqoption.core.ext.a.L(frameLayout);
    }

    private final void aMT() {
        an anVar = this.dPL;
        if (anVar == null) {
            h.lS("binding");
        }
        NestedScrollView nestedScrollView = anVar.biR;
        h.d(nestedScrollView, "binding.withdrawContent");
        com.iqoption.core.ext.a.L(nestedScrollView);
        anVar = this.dPL;
        if (anVar == null) {
            h.lS("binding");
        }
        FrameLayout frameLayout = anVar.biW;
        h.d(frameLayout, "binding.withdrawProgress");
        com.iqoption.core.ext.a.M(frameLayout);
    }
}
