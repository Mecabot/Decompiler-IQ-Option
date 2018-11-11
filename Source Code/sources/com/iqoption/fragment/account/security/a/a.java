package com.iqoption.fragment.account.security.a;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.iqoption.analytics.EventManager;
import com.iqoption.core.util.p;
import com.iqoption.d.m;
import com.iqoption.dto.Event;
import com.iqoption.view.text.x;
import com.iqoption.x.R;

/* compiled from: ConfirmEmailViewHelper */
public class a {
    public static final String TAG = "com.iqoption.fragment.account.security.a.a";
    private m cui;
    private b cuj;
    private TextWatcher cuk = new x() {
        public void afterTextChanged(Editable editable) {
            a.this.ajl();
        }
    };

    /* compiled from: ConfirmEmailViewHelper */
    public interface b {
        s<com.iqoption.mobbtech.connect.response.m> hE(String str);
    }

    /* compiled from: ConfirmEmailViewHelper */
    private static class a extends com.iqoption.system.c.b<a, com.iqoption.mobbtech.connect.response.m> {
        public a(a aVar) {
            super((Object) aVar);
        }

        /* renamed from: a */
        public void c(a aVar, Throwable th) {
            aVar.f(false, false);
        }
    }

    public static a a(Context context, ViewGroup viewGroup, String str, b bVar) {
        a aVar = new a();
        aVar.a(context, viewGroup);
        aVar.cui.getRoot().setTag(TAG);
        aVar.cuj = bVar;
        if (!TextUtils.isEmpty(str)) {
            aVar.cui.bib.setText(str);
            aVar.ajl();
        }
        return aVar;
    }

    public View getView() {
        return this.cui.getRoot();
    }

    private void a(Context context, ViewGroup viewGroup) {
        this.cui = (m) DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.account_security_email_confirm_fragment, viewGroup, viewGroup != null);
        this.cui.a(this);
        this.cui.bia.setEnabled(false);
        this.cui.bib.addTextChangedListener(this.cuk);
        this.cui.bib.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                EventManager.Bm().a(new Event(Event.CATEGORY_TEXT_CHANGED, "security_email-resend"));
            }
        });
    }

    public void ahq() {
        if (this.cuj != null) {
            String obj = this.cui.bib.getText().toString();
            this.cui.bib.clearFocus();
            f(true, true);
            o.a(this.cuj.hE(obj), new a(this), com.iqoption.core.d.a.aSe);
            EventManager.Bm().a(new Event(Event.CATEGORY_BUTTON_PRESSED, "security_email-resend-confirm"));
        }
    }

    private void f(boolean z, boolean z2) {
        this.cui.bib.setEnabled(z ^ 1);
        this.cui.bia.f(z, z2);
    }

    private void ajl() {
        this.cui.bia.setEnabled(p.u(this.cui.bib.getText()));
    }
}
