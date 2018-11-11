package com.iqoption.fragment.account.security.phone;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.iqoption.analytics.EventManager;
import com.iqoption.core.i;
import com.iqoption.d.c;
import com.iqoption.dto.Event;
import com.iqoption.mobbtech.connect.response.l;
import com.iqoption.util.az;
import com.iqoption.util.bg;
import com.iqoption.view.text.x;
import com.iqoption.widget.CountDownProgressBar;
import com.iqoption.x.R;

/* compiled from: ConfirmCodeViewHelper */
public class b implements com.iqoption.widget.CountDownProgressBar.b {
    public static final String TAG = "com.iqoption.fragment.account.security.phone.b";
    private int countryCode;
    private long cuB;
    private c cuC;
    private b cuD;
    private int cuE;

    /* compiled from: ConfirmCodeViewHelper */
    /* renamed from: com.iqoption.fragment.account.security.phone.b$2 */
    static class AnonymousClass2 implements OnClickListener {
        final /* synthetic */ b cuF;

        AnonymousClass2(b bVar) {
            this.cuF = bVar;
        }

        public void onClick(View view) {
            if (this.cuF.cuC.bhF.getVisibility() == 0) {
                EventManager.Bm().a(new Event(Event.CATEGORY_TEXT_CHANGED, "security-2tep_code"));
            } else {
                EventManager.Bm().a(new Event(Event.CATEGORY_TEXT_CHANGED, "security_phone-confirm"));
            }
        }
    }

    /* compiled from: ConfirmCodeViewHelper */
    public interface b {
        s<? extends l> a(int i, long j, String str);

        void l(int i, long j);

        void m(int i, long j);

        void n(int i, long j);
    }

    /* compiled from: ConfirmCodeViewHelper */
    /* renamed from: com.iqoption.fragment.account.security.phone.b$1 */
    static class AnonymousClass1 extends x {
        final /* synthetic */ b cuF;

        AnonymousClass1(b bVar) {
            this.cuF = bVar;
        }

        public void afterTextChanged(Editable editable) {
            super.afterTextChanged(editable);
            this.cuF.ajt();
        }
    }

    /* compiled from: ConfirmCodeViewHelper */
    private static class a extends com.iqoption.system.c.b<b, l> {
        /* synthetic */ a(b bVar, AnonymousClass1 anonymousClass1) {
            this(bVar);
        }

        private a(b bVar) {
            super((Object) bVar);
        }

        /* renamed from: a */
        public void z(b bVar, l lVar) {
            bVar.cuC.bhJ.stop();
        }

        /* renamed from: a */
        public void c(b bVar, Throwable th) {
            bVar.f(false, false);
            bVar.cuC.bhG.setEnabled(true);
            bVar.cuC.bhF.setEnabled(true);
            bVar.cuC.bhH.setEnabled(true);
        }
    }

    public static b a(Context context, ViewGroup viewGroup, int i, long j, int i2, int i3, b bVar) {
        b c = c(context, viewGroup, i, j, i2, i3, bVar);
        c.setTitle(R.string.phone_text);
        c.cuC.bhG.setVisibility(0);
        c.cuC.bhF.setVisibility(8);
        return c;
    }

    public static b b(Context context, ViewGroup viewGroup, int i, long j, int i2, int i3, b bVar) {
        b c = c(context, viewGroup, i, j, i2, i3, bVar);
        c.setTitle(R.string.two_factor_text);
        c.cuC.bhG.setVisibility(8);
        c.cuC.bhF.setVisibility(0);
        return c;
    }

    @NonNull
    private static b c(Context context, ViewGroup viewGroup, int i, long j, int i2, int i3, b bVar) {
        b bVar2 = new b();
        bVar2.countryCode = i;
        bVar2.cuB = j;
        bVar2.cuE = i2;
        bVar2.cuD = bVar;
        bVar2.a(context, viewGroup);
        bVar2.cuC.getRoot().setTag(TAG);
        bVar2.a(context, i, j);
        bVar2.ajt();
        bVar2.cuC.bhH.addTextChangedListener(new AnonymousClass1(bVar2));
        bVar2.cuC.bhH.setOnClickListener(new AnonymousClass2(bVar2));
        bVar2.eL(i2);
        bVar2.cuC.bhJ.setCountDownFinishListener(bVar2);
        bVar2.cuC.bhJ.gs(i3);
        return bVar2;
    }

    public View getView() {
        return this.cuC.getRoot();
    }

    public void setTitle(int i) {
        this.cuC.bhI.setText(i);
    }

    private void a(Context context, ViewGroup viewGroup) {
        this.cuC = (c) DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.account_security_confirm_code_fragment, viewGroup, viewGroup != null);
        this.cuC.a(this);
    }

    public String ajs() {
        return this.cuE > 0 ? String.valueOf(this.cuE) : "";
    }

    private void eL(int i) {
        if (i > 0) {
            this.cuC.bhH.setText(String.valueOf(i));
            ajt();
        }
    }

    public void ajt() {
        this.cuC.bhK.setEnabled(this.cuC.bhH.length() >= 6);
    }

    private void a(Context context, int i, long j) {
        Object w = az.w(i, j);
        if (TextUtils.isEmpty(w)) {
            this.cuC.bhH.setEnabled(false);
            return;
        }
        this.cuC.bhH.setEnabled(true);
        bg.a(context.getString(R.string.sending_phone_code_description, new Object[]{w}), w, this.cuC.bhA, -1, true);
    }

    public void aju() {
        i.d(TAG, "onSubmit");
        this.cuC.bhH.clearFocus();
        this.cuC.bhG.setEnabled(false);
        this.cuC.bhF.setEnabled(false);
        this.cuC.bhH.setEnabled(false);
        f(true, true);
        o.a(this.cuD.a(this.countryCode, this.cuB, this.cuC.bhH.getText().toString().trim()), new a(this, null), com.iqoption.core.d.a.aSe);
        EventManager.Bm().a(new Event(Event.CATEGORY_BUTTON_PRESSED, "security_phone-confirm"));
    }

    public void ajv() {
        i.d(TAG, "onChangeNumber");
        this.cuC.bhH.clearFocus();
        this.cuD.l(this.countryCode, this.cuB);
    }

    public void ajw() {
        i.d(TAG, "onCancelConfirm");
        this.cuC.bhH.clearFocus();
        this.cuD.n(this.countryCode, this.cuB);
        EventManager.Bm().a(new Event(Event.CATEGORY_BUTTON_PRESSED, "security-2tep_cancel"));
    }

    public void a(CountDownProgressBar countDownProgressBar) {
        i.d(TAG, "onCountDownFinish");
        this.cuC.bhH.clearFocus();
        this.cuD.m(this.countryCode, this.cuB);
    }

    private void f(boolean z, boolean z2) {
        this.cuC.bhH.setEnabled(z ^ 1);
        this.cuC.bhG.setEnabled(z ^ 1);
        this.cuC.bhK.f(z, z2);
    }
}
