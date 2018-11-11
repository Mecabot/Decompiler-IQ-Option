package com.iqoption.fragment.account.security.a;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.iqoption.d.i;
import com.iqoption.view.text.FormattedTextView.a;
import com.iqoption.x.R;

/* compiled from: ConfirmedEmailViewHelper */
public class b {
    public static final String TAG = "com.iqoption.fragment.account.security.a.b";
    private i cum;

    /* compiled from: ConfirmedEmailViewHelper */
    /* renamed from: com.iqoption.fragment.account.security.a.b$1 */
    static class AnonymousClass1 implements a {
        final /* synthetic */ b cun;

        AnonymousClass1(b bVar) {
            this.cun = bVar;
        }

        public void onSizeChanged(int i, int i2, int i3, int i4) {
            this.cun.cum.bhX.setFrameTopGapSize((float) i);
        }
    }

    public static b a(Context context, ViewGroup viewGroup, String str) {
        b bVar = new b();
        bVar.a(context, viewGroup);
        bVar.cum.getRoot().setTag(TAG);
        bVar.cum.bhX.setText(str);
        bVar.cum.bhY.setOnSizeChangedListener(new AnonymousClass1(bVar));
        return bVar;
    }

    public View getView() {
        return this.cum.getRoot();
    }

    private void a(Context context, ViewGroup viewGroup) {
        this.cum = (i) DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.account_security_confirmed_email_fragment, viewGroup, viewGroup != null);
    }
}
