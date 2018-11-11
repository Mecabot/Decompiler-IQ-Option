package com.iqoption.fragment.account.security.a;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.iqoption.d.q;
import com.iqoption.util.bg;
import com.iqoption.x.R;

/* compiled from: ResendEmailViewHelper */
public class d {
    public static final String TAG = "com.iqoption.fragment.account.security.a.d";
    private q cuw;
    private com.iqoption.widget.d cux;
    private a cuy;

    /* compiled from: ResendEmailViewHelper */
    public interface a {
        void ajn();
    }

    public static d a(Context context, ViewGroup viewGroup, String str, a aVar) {
        d dVar = new d();
        dVar.a(context, viewGroup);
        dVar.cuw.getRoot().setTag(TAG);
        dVar.cuy = aVar;
        a(context, str, dVar);
        return dVar;
    }

    private static void a(Context context, String str, d dVar) {
        bg.a(context.getString(R.string.sending_email_description, new Object[]{str}), str, dVar.cuw.bij, -1, true);
    }

    public View getView() {
        return this.cuw.getRoot();
    }

    private void a(Context context, ViewGroup viewGroup) {
        this.cuw = (q) DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.account_security_resend_email_fragment, viewGroup, viewGroup != null);
        this.cuw.a(this);
        bm(context);
    }

    private void bm(Context context) {
        this.cux = new com.iqoption.widget.d(context, this.cuw.getRoot());
        this.cuw.bik.setImageDrawable(this.cux);
    }

    public void ajn() {
        if (this.cuy != null) {
            this.cuw.bil.setClickable(false);
            this.cuy.ajn();
        }
    }

    public com.iqoption.widget.d ajq() {
        return this.cux;
    }
}
