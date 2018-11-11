package com.iqoption.fragment.dialog;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.google.common.base.Suppliers;
import com.google.common.base.n;
import com.iqoption.analytics.k;
import com.iqoption.core.i;
import com.iqoption.dto.entity.position.Order;
import com.iqoption.fragment.base.b;
import com.iqoption.util.EventSenderLifecycleObserver;
import com.iqoption.util.ac;
import com.iqoption.util.bc;
import com.iqoption.util.g;
import com.iqoption.x.R;

/* compiled from: ConfirmClosePendingPositionDialog */
public final class c extends b {
    private static final String TAG = "com.iqoption.fragment.dialog.c";
    private n<com.iqoption.core.ui.d.a> cAh = Suppliers.a(new n<com.iqoption.core.ui.d.a>() {
        /* renamed from: akZ */
        public com.iqoption.core.ui.d.a get() {
            return new com.iqoption.core.ui.d.a(c.this.ckK.awS, c.this.ckK.btF);
        }
    });
    private a cAl;
    private com.iqoption.dialogs.a.c ckK;

    /* compiled from: ConfirmClosePendingPositionDialog */
    public interface a {
        void l(Order order);

        void m(Order order);
    }

    public long getAnimationDuration() {
        return 250;
    }

    public static void a(@IdRes int i, FragmentManager fragmentManager, a aVar, Order order) {
        if (ac.d(fragmentManager, TAG)) {
            fragmentManager.beginTransaction().add(i, a(aVar, order), TAG).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).addToBackStack(TAG).commit();
        } else {
            i.w(TAG, "Fragment exists");
        }
    }

    private static c a(a aVar, Order order) {
        c cVar = new c();
        cVar.setArguments(new g().a("arg.order", (Parcelable) order).toBundle());
        cVar.cAl = aVar;
        return cVar;
    }

    public void ND() {
        ((com.iqoption.core.ui.d.a) this.cAh.get()).bd(NF()).start();
    }

    public void NE() {
        ((com.iqoption.core.ui.d.a) this.cAh.get()).be(NG()).start();
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.cAl == null) {
            i.w(TAG, "Callback is null");
            onClose();
            return null;
        }
        bundle = getArguments();
        if (bundle == null) {
            i.w(TAG, "Arguments is null");
            onClose();
            return null;
        }
        final Order order = (Order) bundle.getParcelable("arg.order");
        if (order == null) {
            i.w(TAG, "Order is null");
            onClose();
            return null;
        }
        com.iqoption.core.microservices.tradingengine.response.active.a a = com.iqoption.app.helpers.a.FI().a(order.getInstrumentActiveId(), order.getInstrumentType());
        if (a == null) {
            i.w(TAG, "Active is null");
            onClose();
            return null;
        }
        int i;
        this.ckK = (com.iqoption.dialogs.a.c) DataBindingUtil.inflate(layoutInflater, R.layout.dialog_simple, viewGroup, false);
        this.ckK.agA.setVisibility(8);
        this.ckK.blj.setVisibility(8);
        OnClickListener anonymousClass2 = new com.iqoption.view.d.b() {
            public void q(View view) {
                c.this.cAl.m(order);
                c.this.onClose();
            }
        };
        this.ckK.getRoot().setOnClickListener(anonymousClass2);
        if (order.getType().equals(Order.ON_MKT_OPEN)) {
            i = R.string.confirm_cancellation_of_mkt_on_open_order;
        } else {
            i = R.string.confirm_cancellation_of_limit_order_for;
        }
        this.ckK.aip.setText(new bc().jO(getString(i)).jO(" ").bM(new ForegroundColorSpan(-1)).jO(com.iqoption.util.e.a.s(a)).aCT());
        this.ckK.ckR.setText(R.string.cancel);
        this.ckK.ckS.setText(R.string.confirm);
        this.ckK.ckR.setOnClickListener(anonymousClass2);
        this.ckK.ckS.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                c.this.cAl.l(order);
                c.this.onClose();
                k.ay(true);
            }
        });
        return this.ckK.getRoot();
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        getLifecycle().a(new EventSenderLifecycleObserver(k.BC(), null));
    }

    public boolean onClose() {
        requireFragmentManager().popBackStack();
        return true;
    }
}
