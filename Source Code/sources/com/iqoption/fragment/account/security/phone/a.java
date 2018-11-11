package com.iqoption.fragment.account.security.phone;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.iqoption.core.i;
import com.iqoption.mobbtech.connect.response.l;
import com.iqoption.x.R;

/* compiled from: ConfirmCodeExpiredViewHelper */
public class a {
    public static final String TAG = "com.iqoption.fragment.account.security.phone.a";
    private int countryCode;
    private b cuA;
    private long cuB;
    private com.iqoption.d.a cuz;

    /* compiled from: ConfirmCodeExpiredViewHelper */
    public interface b {
        s<? extends l> k(int i, long j);
    }

    /* compiled from: ConfirmCodeExpiredViewHelper */
    private static class a extends com.iqoption.system.c.b<a, l> {
        private a(a aVar) {
            super((Object) aVar);
        }

        /* renamed from: a */
        public void z(a aVar, l lVar) {
            super.z(aVar, lVar);
        }

        /* renamed from: a */
        public void c(a aVar, Throwable th) {
            aVar.f(false, false);
        }
    }

    public static a a(Context context, ViewGroup viewGroup, int i, long j, b bVar) {
        a c = c(context, viewGroup, i, j, bVar);
        c.cuz.bhB.setText(R.string.phone_text);
        return c;
    }

    public static a b(Context context, ViewGroup viewGroup, int i, long j, b bVar) {
        a c = c(context, viewGroup, i, j, bVar);
        c.cuz.bhB.setText(R.string.two_factor_text);
        return c;
    }

    private static a c(Context context, ViewGroup viewGroup, int i, long j, b bVar) {
        a aVar = new a();
        aVar.countryCode = i;
        aVar.cuB = j;
        aVar.cuA = bVar;
        aVar.a(context, viewGroup);
        aVar.cuz.getRoot().setTag(TAG);
        return aVar;
    }

    public View getView() {
        return this.cuz.getRoot();
    }

    private void a(Context context, ViewGroup viewGroup) {
        this.cuz = (com.iqoption.d.a) DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.account_security_confirm_code_expired_fragment, viewGroup, viewGroup != null);
        this.cuz.a(this);
    }

    public void ajr() {
        i.d(TAG, "onSendAgain");
        f(true, true);
        o.a(this.cuA.k(this.countryCode, this.cuB), new a(), com.iqoption.core.d.a.aSe);
    }

    private void f(boolean z, boolean z2) {
        this.cuz.bhC.f(z, z2);
    }
}
