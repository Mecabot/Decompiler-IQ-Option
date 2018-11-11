package com.iqoption.dialog;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.activity.TradeRoomActivity;
import com.iqoption.analytics.l;
import com.iqoption.app.af;
import com.iqoption.d.ahg;
import com.iqoption.fragment.MenuFragment.MenuItem;
import com.iqoption.fragment.base.b;
import com.iqoption.fragment.dialog.popup.PopupViewModel;
import com.iqoption.util.g;
import com.iqoption.view.a.a.d;
import com.iqoption.x.R;

/* compiled from: RateUsDialog */
public class f extends b {
    private ImageView[] ait = new ImageView[5];
    private final l cfg = new l();
    private ahg cfh;
    private boolean cfj;
    private boolean cfk;

    /* compiled from: RateUsDialog */
    private class a implements OnClickListener {
        private int cff;

        public a(int i) {
            this.cff = i;
        }

        public void onClick(View view) {
            for (int i = 0; i < f.this.ait.length; i++) {
                if (i <= this.cff) {
                    f.this.ait[i].setImageResource(R.drawable.rate_star_on);
                } else {
                    f.this.ait[i].setImageResource(R.drawable.rate_star_off);
                }
            }
            af.aR(f.this.getContext()).cL(2);
            f.this.ed(this.cff + 1);
            f.this.ee(this.cff + 1);
        }
    }

    @NonNull
    private static f cB(boolean z) {
        f fVar = new f();
        fVar.setArguments(new g().v("arg.user.loyalty", z).toBundle());
        return fVar;
    }

    public static void a(FragmentActivity fragmentActivity, @NonNull FragmentManager fragmentManager) {
        PopupViewModel.j(fragmentActivity).a(new g(fragmentManager), "RateUsDialog");
    }

    private static void a(@NonNull FragmentManager fragmentManager, @NonNull f fVar) {
        if (fragmentManager.findFragmentByTag("RateUsDialog") == null) {
            fragmentManager.beginTransaction().add(R.id.other_fragment, fVar, "RateUsDialog").addToBackStack("RateUsDialog").commitAllowingStateLoss();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i = 0;
        this.cfh = (ahg) DataBindingUtil.inflate(layoutInflater, R.layout.rate_us_dialog, viewGroup, false);
        this.cfh.a(this);
        this.cfj = getArguments().getBoolean("arg.user.loyalty", false);
        this.ait[0] = this.cfh.bQC;
        this.ait[1] = this.cfh.bQD;
        this.ait[2] = this.cfh.bQE;
        this.ait[3] = this.cfh.bQF;
        this.ait[4] = this.cfh.bQG;
        while (i < this.ait.length) {
            this.ait[i].setOnClickListener(new a(i));
            i++;
        }
        this.cfh.bQB.setOnClickListener(new h(this));
        this.cfh.bFS.setOnClickListener(new i(this));
        return this.cfh.getRoot();
    }

    final /* synthetic */ void U(View view) {
        if (this.cfk) {
            onClose();
            if (!TextUtils.isEmpty("")) {
                requireActivity().startActivity(new Intent("android.intent.action.VIEW", Uri.parse("")));
                return;
            }
            return;
        }
        onClose();
        TradeRoomActivity tradeRoomActivity = getTradeRoomActivity();
        if (tradeRoomActivity != null) {
            tradeRoomActivity.a(MenuItem.SUPPORT);
        }
    }

    final /* synthetic */ void T(View view) {
        this.cfg.BD();
        onClose();
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.cfg.onStart();
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.cfg.az(this.cfj);
        af DX = af.DX();
        if (DX.Ee() != 2) {
            DX.cL(2);
            ed(0);
        }
    }

    private void ed(int i) {
        com.iqoption.mobbtech.connect.request.api.f.iy("sendMessage").iz("rate").m("rating", Integer.valueOf(i)).m("client_platform_id", Integer.valueOf(17)).exec();
    }

    public void ND() {
        ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(0), Integer.valueOf(-1476395008)});
        ofObject.addUpdateListener(new com.iqoption.view.a.a.a(this.cfh.brJ));
        ofObject.setDuration(300);
        ofObject.setInterpolator(d.dEM);
        this.cfh.bjl.setAlpha(0.0f);
        this.cfh.bjl.setScaleX(0.3f);
        this.cfh.bjl.setScaleY(0.3f);
        this.cfh.bjl.animate().alpha(1.0f).scaleY(1.0f).scaleX(1.0f).setDuration(300).setInterpolator(d.dEM).start();
        ofObject.start();
    }

    public void NE() {
        ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(-1476395008), Integer.valueOf(0)});
        ofObject.addUpdateListener(new com.iqoption.view.a.a.a(this.cfh.brJ));
        ofObject.setDuration(300);
        ofObject.setInterpolator(d.dEM);
        this.cfh.bjl.animate().alpha(0.0f).scaleY(0.7f).scaleX(0.7f).setDuration(300).setInterpolator(d.dEM).start();
        ofObject.start();
    }

    public boolean onClose() {
        requireFragmentManager().popBackStack();
        PopupViewModel.j(requireActivity()).hO("RateUsDialog");
        return true;
    }

    private void ee(int i) {
        this.cfk = i >= 4;
        TextView textView = this.cfh.bQz;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(zzakw().getString(R.string.your_rating2));
        stringBuilder.append(" ");
        stringBuilder.append(i);
        textView.setText(stringBuilder.toString());
        this.cfh.bQB.setVisibility(0);
        this.cfh.bFS.setVisibility(8);
        if (this.cfk) {
            this.cfh.bQB.setText(zzakw().getString(R.string.share));
            this.cfh.bQA.setVisibility(0);
            this.cfg.BE();
            return;
        }
        this.cfh.bQB.setText(zzakw().getString(R.string.leave_feedback));
        this.cfh.bQA.setVisibility(8);
        this.cfg.j((double) i);
    }
}
