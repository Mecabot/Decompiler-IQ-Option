package com.iqoption.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.iqoption.app.IQApp;
import com.iqoption.core.a.e;
import com.iqoption.core.i;
import com.iqoption.fragment.as.b;
import com.iqoption.fragment.base.f;
import com.iqoption.fragment.leftpanel.BackListenerObserver;
import com.iqoption.menu.SupportView;
import com.iqoption.menu.c;
import com.iqoption.menu.c.a;
import com.iqoption.verify.NonVerifiedCardsViewModel;
import com.iqoption.x.R;

public class MenuFragment extends f implements b, a {
    public static final String TAG = "com.iqoption.fragment.MenuFragment";
    private e aMD;
    private View aeJ;
    private FrameLayout bLh;
    private MenuItem cpO;
    private MenuViewModel cpP;

    public enum MenuItem {
        PERSONAL_INFO,
        SUPPORT
    }

    public static Fragment ahz() {
        Fragment menuFragment = new MenuFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("item", MenuItem.SUPPORT);
        menuFragment.setArguments(bundle);
        return menuFragment;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.cpP = MenuViewModel.i(zzakw());
        this.aMD = IQApp.Dk().Ds();
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.menu_fragment, viewGroup, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        Y(view);
        zY();
        if (ahA() && !com.iqoption.app.a.aL(getContext()).CZ() && com.iqoption.app.managers.feature.a.HR()) {
            NonVerifiedCardsViewModel.E(zzakw()).aED().observe(this, new bk(this));
        }
        if (zzakw() instanceof com.iqoption.view.e) {
            getLifecycle().a(new BackListenerObserver((com.iqoption.view.e) zzakw(), new bl(this)));
        }
    }

    final /* synthetic */ void l(Boolean bool) {
        ((c) this.aeJ).setCardVerificationFailed(Boolean.TRUE.equals(bool));
    }

    final /* synthetic */ Boolean ahE() {
        if (this.cpO == MenuItem.SUPPORT) {
            ((SupportView) this.aeJ).onBackPressed();
        } else if (this.cpO == MenuItem.PERSONAL_INFO) {
            ((c) this.aeJ).onBackPressed();
        }
        requireFragmentManager().popBackStackImmediate();
        return Boolean.valueOf(true);
    }

    private void Y(View view) {
        this.bLh = (FrameLayout) view.findViewById(R.id.layout);
    }

    private void zY() {
        b((MenuItem) getArguments().getSerializable("item"));
    }

    public void b(MenuItem menuItem) {
        if (this.cpO != menuItem) {
            this.bLh.removeAllViews();
            this.cpO = menuItem;
            switch (menuItem) {
                case PERSONAL_INFO:
                    View cVar = new c(getTradeRoomActivity());
                    cVar.setCallback(this);
                    this.aeJ = cVar;
                    break;
                case SUPPORT:
                    this.aeJ = new SupportView(zzakw());
                    break;
            }
            this.bLh.addView(this.aeJ);
        }
    }

    public void b(long j, int i) {
        if (this.aeJ != null && (this.aeJ instanceof SupportView)) {
            ((SupportView) this.aeJ).b(j, i);
        }
    }

    public boolean ahA() {
        return this.aeJ != null && (this.aeJ instanceof c);
    }

    public void ahB() {
        if (this.aeJ != null && (this.aeJ instanceof c)) {
            ((c) this.aeJ).ahB();
        }
    }

    public void onResume() {
        super.onResume();
        ahB();
    }

    public void ahp() {
        this.aMD.b("delete-account_choose-answer", 0.0d);
    }

    public void ahC() {
        if (isAdded()) {
            this.aMD.dY("delete-account_show").Bs();
            as.coZ.a(getChildFragmentManager(), R.id.menuOtherFragment, getString(R.string.attention), getString(R.string.are_you_sure_you_want_to_deactivate), getString(R.string.no), getString(R.string.yes));
        }
    }

    @SuppressLint({"CheckResult"})
    public void ahq() {
        this.aMD.b("delete-account_choose-answer", 1.0d);
        this.cpP.ahF().a(new bm(this), bn.cpR);
    }

    final /* synthetic */ void ahD() {
        if (isAdded()) {
            getFragmentManager().popBackStack();
        }
    }

    static final /* synthetic */ void u(Throwable th) {
        i.e("Unable to delete account", th);
        com.iqoption.app.a.b.FG();
    }
}
