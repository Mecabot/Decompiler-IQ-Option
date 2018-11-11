package com.iqoption.fragment.account.security.phone;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.google.common.util.concurrent.s;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import com.iqoption.analytics.EventManager;
import com.iqoption.core.i;
import com.iqoption.d.o;
import com.iqoption.dto.Event;
import com.iqoption.mobbtech.connect.response.l;
import com.iqoption.util.az;
import com.iqoption.view.ConfirmButtonView;
import com.iqoption.view.text.x;
import com.iqoption.x.R;
import java.util.Locale;

/* compiled from: PhoneNumberViewHelper */
public class e {
    public static final String TAG = "com.iqoption.fragment.account.security.phone.e";
    private final PhoneNumberUtil ZJ = PhoneNumberUtil.xo();
    private o cuQ;
    private b cuR;
    private TextWatcher cuS = new x() {
        public void afterTextChanged(Editable editable) {
            e.this.ajA();
        }
    };

    /* compiled from: PhoneNumberViewHelper */
    public interface b {
        s<? extends l> r(int i, long j);
    }

    /* compiled from: PhoneNumberViewHelper */
    private static class a extends com.iqoption.system.c.b<e, l> {
        /* synthetic */ a(e eVar, AnonymousClass1 anonymousClass1) {
            this(eVar);
        }

        private a(e eVar) {
            super((Object) eVar);
        }

        /* renamed from: a */
        public void c(e eVar, Throwable th) {
            eVar.f(false, false);
        }
    }

    public static e a(Context context, ViewGroup viewGroup, int i, long j, b bVar) {
        e eVar = new e();
        eVar.a(context, viewGroup);
        eVar.cuQ.getRoot().setTag(TAG);
        eVar.o(i, j);
        eVar.cuR = bVar;
        return eVar;
    }

    public View getView() {
        return this.cuQ.getRoot();
    }

    private void o(int i, long j) {
        if (i > 0) {
            this.cuQ.bif.setText(az.w(i, j));
        } else if (j > 0) {
            this.cuQ.bif.setText(String.valueOf(j));
        }
        ajA();
    }

    private void a(Context context, ViewGroup viewGroup) {
        this.cuQ = (o) DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.account_security_phone_number_fragment, viewGroup, viewGroup != null);
        this.cuQ.a(this);
        this.cuQ.bif.addTextChangedListener(this.cuS);
        this.cuQ.bif.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                EventManager.Bm().a(new Event(Event.CATEGORY_TEXT_CHANGED, "security_phone-country-code"));
                EventManager.Bm().a(new Event(Event.CATEGORY_TEXT_CHANGED, "security_phone-number"));
            }
        });
        ajy();
    }

    private void ajy() {
        this.cuQ.bif.setHint(this.ZJ.a(this.ZJ.a(Locale.getDefault().getCountry(), PhoneNumberType.MOBILE), PhoneNumberFormat.INTERNATIONAL));
    }

    public void ajz() {
        this.cuQ.bif.clearFocus();
        try {
            PhoneNumber CM = CM();
            String a = this.ZJ.a(CM, PhoneNumberFormat.INTERNATIONAL);
            int xE = CM.xE();
            long ye = CM.ye();
            f(true, true);
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("internationalPhoneNumber: ");
            stringBuilder.append(a);
            i.d(str, stringBuilder.toString());
            a = TAG;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("phone country code: ");
            stringBuilder2.append(xE);
            i.d(a, stringBuilder2.toString());
            a = TAG;
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("phone nationalNumber: ");
            stringBuilder2.append(ye);
            i.d(a, stringBuilder2.toString());
            a = TAG;
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("phone extension: ");
            stringBuilder2.append(CM.getExtension());
            i.d(a, stringBuilder2.toString());
            com.google.common.util.concurrent.o.a(this.cuR.r(xE, ye), new a(this, null), com.iqoption.core.d.a.aSe);
        } catch (NumberParseException e) {
            e.printStackTrace();
        }
        EventManager.Bm().a(new Event(Event.CATEGORY_BUTTON_PRESSED, "security_phone-send"));
    }

    private void f(boolean z, boolean z2) {
        this.cuQ.bif.setEnabled(z ^ 1);
        this.cuQ.big.f(z, z2);
    }

    private void ajA() {
        try {
            PhoneNumber CM = CM();
            ConfirmButtonView confirmButtonView = this.cuQ.big;
            boolean z = CM.yc() && CM.yd() && this.ZJ.b(CM);
            confirmButtonView.setEnabled(z);
        } catch (NumberParseException unused) {
            this.cuQ.big.setEnabled(false);
        }
    }

    private PhoneNumber CM() {
        return this.ZJ.b(this.cuQ.bif.getText().toString(), Locale.getDefault().getCountry());
    }
}
