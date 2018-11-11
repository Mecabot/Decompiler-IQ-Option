package com.iqoption.verify.status;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.mobbtech.connect.response.CardStatus;
import com.iqoption.mobbtech.connect.response.q;
import com.iqoption.mobbtech.connect.response.r;
import com.iqoption.util.ar;
import com.iqoption.x.R;
import java.util.HashMap;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u001a\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016¨\u0006\u0010"}, aXE = {"Lcom/iqoption/verify/status/VerifyStatusFragment;", "Lcom/iqoption/verify/status/BaseVerifyStatusFragment;", "()V", "getFooterView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initButton", "", "onButtonClick", "onViewCreated", "view", "savedInstanceState", "Landroid/os/Bundle;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: VerifyStatusFragment.kt */
public final class m extends a {
    private HashMap atz;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: VerifyStatusFragment.kt */
    static final class a implements OnClickListener {
        final /* synthetic */ m dyB;

        a(m mVar) {
            this.dyB = mVar;
        }

        public final void onClick(View view) {
            this.dyB.aHv();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "refreshedCard", "Lcom/iqoption/mobbtech/connect/response/VerifyCard;", "onChanged"})
    /* compiled from: VerifyStatusFragment.kt */
    static final class b<T> implements Observer<q> {
        final /* synthetic */ m dyB;

        b(m mVar) {
            this.dyB = mVar;
        }

        /* renamed from: l */
        public final void onChanged(q qVar) {
            if (qVar != null) {
                TextView textView = this.dyB.aGY().bFA;
                h.d(textView, "binding.verifyStatusDescription");
                h.d(qVar, "it");
                n.a(textView, qVar, qVar.auX());
            }
        }
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

    public View g(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        h.e(layoutInflater, "inflater");
        h.e(viewGroup, "container");
        View inflate = layoutInflater.inflate(R.layout.verify_status_footer_layout, viewGroup, false);
        if (inflate == null) {
            h.aXZ();
        }
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        aHu();
        TextView textView = aGY().bFA;
        h.d(textView, "binding.verifyStatusDescription");
        n.a(textView, aGO(), auX());
        if (com.iqoption.core.ext.a.o(this).getBoolean("ARG_REFRESH_DESCRIPTION", false)) {
            ar.a(VerifyStatusViewModel.dyC.G(com.iqoption.core.ext.a.n(this)).co(aGO().getId()), (Fragment) this, (Observer) new b(this));
        }
    }

    private final void aHu() {
        Integer valueOf;
        CardStatus auX = auX();
        if (auX == CardStatus.DECLINED) {
            valueOf = Integer.valueOf(R.string.try_again);
        } else if (auX == CardStatus.VERIFIED || r.auZ().contains(auX)) {
            valueOf = null;
        } else {
            valueOf = Integer.valueOf(R.string.start);
        }
        View root = aGY().getRoot();
        h.d(root, "binding.root");
        Button button = (Button) root.findViewById(com.iqoption.b.a.verifyDetailsButton);
        if (valueOf != null) {
            button.setText(valueOf.intValue());
            button.setOnClickListener(new a(this));
            h.d(button, "button");
            com.iqoption.core.ext.a.L(button);
            return;
        }
        h.d(button, "button");
        com.iqoption.core.ext.a.M(button);
    }

    private final void aHv() {
        CardStatus auX = auX();
        if (auX == CardStatus.VERIFIED || r.auZ().contains(auX)) {
            aN();
        } else {
            a(CardStatus.NEW, false);
        }
    }
}
