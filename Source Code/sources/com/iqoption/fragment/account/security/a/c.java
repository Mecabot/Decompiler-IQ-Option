package com.iqoption.fragment.account.security.a;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.common.b.e;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.iqoption.analytics.EventManager;
import com.iqoption.app.IQApp;
import com.iqoption.app.b.b.g;
import com.iqoption.core.i;
import com.iqoption.d.lb;
import com.iqoption.dto.Event;
import com.iqoption.kyc.f;
import com.iqoption.mobbtech.connect.response.m;
import com.iqoption.mobbtech.connect.response.n;
import com.iqoption.x.R;

/* compiled from: EmailFragment */
public class c extends Fragment implements com.iqoption.fragment.account.security.a.a.b, com.iqoption.fragment.account.security.a.d.a {
    public static final String TAG = "com.iqoption.fragment.account.security.a.c";
    private lb cuo;
    private Handler cup = new Handler(Looper.getMainLooper());
    private a cuq;

    /* compiled from: EmailFragment */
    private class a {
        private boolean cus;
        private boolean cut;

        public a(boolean z, boolean z2) {
            String str = c.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("initialize AccountEventReceiver isEmailWasSent=");
            stringBuilder.append(z);
            stringBuilder.append(", isEmailConfirmed=");
            stringBuilder.append(z2);
            i.d(str, stringBuilder.toString());
            this.cut = z;
            this.cus = z2;
        }

        @e
        public void emailChanged(g gVar) {
            String str = c.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("emailChanged ");
            stringBuilder.append((String) gVar.getValue());
            i.d(str, stringBuilder.toString());
            update();
        }

        @e
        public void accountIsActivated(com.iqoption.app.b.b.a aVar) {
            String str = c.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("accountIsActivated ");
            stringBuilder.append(aVar.getValue());
            i.d(str, stringBuilder.toString());
            update();
        }

        private void update() {
            c.this.cup.post(new Runnable() {
                public void run() {
                    i.d(c.TAG, "update confirmation state");
                    if (!a.this.cus && c.bl(c.this.getContext())) {
                        c.this.hG(com.iqoption.app.a.aL(c.this.getContext()).getEmail());
                    } else if (!a.this.cut && c.this.ajp()) {
                        c.this.hF(c.this.getEmail());
                    } else if (a.this.cus && !c.bl(c.this.getContext())) {
                        c.this.hF(c.this.getEmail());
                    }
                    a.this.cus = c.bl(c.this.getContext());
                    a.this.cut = c.this.ajp();
                }
            });
        }
    }

    /* compiled from: EmailFragment */
    private static class b extends com.iqoption.mobbtech.connect.response.n.a<c> {
        private final String email;

        private b(c cVar, String str) {
            super(cVar);
            this.email = str;
        }

        /* renamed from: a */
        public void onSuccess(n nVar) {
            c cVar = (c) getReferent();
            if (cVar != null) {
                if (!TextUtils.isEmpty(nVar.getMessage())) {
                    com.iqoption.app.a.b.b(nVar.getMessage(), cVar.getContext());
                }
                cVar.hF(this.email);
            }
        }
    }

    public static c ajm() {
        return new c();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cuo = (lb) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_account_security_page, viewGroup, false);
        ajo();
        this.cuq = new a(ajp(), bl(getContext()));
        IQApp.Dn().aD(this.cuq);
        return this.cuo.getRoot();
    }

    public void onDestroyView() {
        if (this.cuq != null) {
            IQApp.Dn().unregister(this.cuq);
        }
        super.onDestroyView();
    }

    public s<m> hE(String str) {
        String str2 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onConfirmEmail: ");
        stringBuilder.append(str);
        i.d(str2, stringBuilder.toString());
        s<m> hX = new f(getContext()).hX(str);
        o.a(hX, new b(str), com.iqoption.core.d.a.aSe);
        return hX;
    }

    public void ajn() {
        i.d(TAG, "onChangeEmail");
        com.iqoption.util.b.a(a.a(getContext(), null, getEmail(), this).getView(), this.cuo.bwt, true);
        EventManager.Bm().a(new Event(Event.CATEGORY_BUTTON_PRESSED, "security_email-resend"));
    }

    private void ajo() {
        if (!ajp()) {
            a.a(getContext(), this.cuo.bwt, getEmail(), this);
        } else if (bl(getContext())) {
            b.a(getContext(), this.cuo.bwt, getEmail());
        } else {
            d.a(getContext(), this.cuo.bwt, getEmail(), this);
        }
    }

    private void hF(String str) {
        String str2 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onConfirmEmailSent ");
        stringBuilder.append(str);
        i.d(str2, stringBuilder.toString());
        com.iqoption.util.b.a(d.a(getContext(), null, str, this).getView(), this.cuo.bwt, true);
    }

    private void hG(String str) {
        String str2 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onEmailConfirmed ");
        stringBuilder.append(str);
        i.d(str2, stringBuilder.toString());
        com.iqoption.util.b.a(b.a(getContext(), null, str).getView(), this.cuo.bwt, true);
    }

    private boolean ajp() {
        return TextUtils.isEmpty(com.iqoption.app.a.aL(getContext()).getEmail()) ^ 1;
    }

    public static boolean bl(Context context) {
        return com.iqoption.app.a.aL(context).Dg();
    }

    private String getEmail() {
        return com.iqoption.app.a.aL(getContext()).CQ();
    }
}
