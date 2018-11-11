package com.iqoption.fragment.account.security.phone;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.iqoption.core.i;
import com.iqoption.d.g;
import com.iqoption.mobbtech.connect.response.l;
import com.iqoption.util.az;
import com.iqoption.x.R;

/* compiled from: ConfirmPhoneViewHelper */
public class c {
    public static final String TAG = "com.iqoption.fragment.account.security.phone.c";
    private int countryCode;
    private long cuB;
    private g cuG;
    private b cuH;

    /* compiled from: ConfirmPhoneViewHelper */
    public interface b {
        void l(int i, long j);

        s<? extends l> p(int i, long j);
    }

    /* compiled from: ConfirmPhoneViewHelper */
    private static class a extends com.iqoption.system.c.b<c, l> {
        private a(c cVar) {
            super((Object) cVar);
        }

        /* renamed from: a */
        public void c(c cVar, Throwable th) {
            cVar.f(false, false);
        }
    }

    public static c a(Context context, ViewGroup viewGroup, int i, long j, b bVar) {
        c cVar = new c();
        cVar.countryCode = i;
        cVar.cuB = j;
        cVar.cuH = bVar;
        cVar.a(context, viewGroup);
        cVar.cuG.getRoot().setTag(TAG);
        cVar.o(i, j);
        return cVar;
    }

    public View getView() {
        return this.cuG.getRoot();
    }

    private void a(Context context, ViewGroup viewGroup) {
        this.cuG = (g) DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.account_security_confirm_phone_fragment, viewGroup, viewGroup != null);
        this.cuG.a(this);
    }

    private void o(int i, long j) {
        if (i > 0) {
            this.cuG.bhT.setText(az.w(i, j));
            this.cuG.bhS.setEnabled(true);
        } else if (j > 0) {
            this.cuG.bhT.setText(String.valueOf(j));
            this.cuG.bhS.setEnabled(true);
        } else {
            this.cuG.bhS.setEnabled(false);
        }
    }

    public void ahq() {
        i.d(TAG, "onChangeNumber");
        f(true, true);
        o.a(this.cuH.p(this.countryCode, this.cuB), new a(), com.iqoption.core.d.a.aSe);
    }

    public void ajv() {
        i.d(TAG, "onChangeNumber");
        if (this.cuH != null) {
            this.cuH.l(this.countryCode, this.cuB);
        }
    }

    private void f(boolean z, boolean z2) {
        this.cuG.bhT.setEnabled(z ^ 1);
        this.cuG.bhG.setEnabled(z ^ 1);
        this.cuG.bhS.f(z, z2);
    }
}
