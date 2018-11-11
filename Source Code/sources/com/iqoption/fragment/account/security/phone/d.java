package com.iqoption.fragment.account.security.phone;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.iqoption.d.k;
import com.iqoption.util.az;
import com.iqoption.view.text.FormattedTextView.a;
import com.iqoption.x.R;

/* compiled from: ConfirmedPhoneViewHelper */
public class d {
    public static final String TAG = "com.iqoption.fragment.account.security.phone.d";
    private k cuI;

    /* compiled from: ConfirmedPhoneViewHelper */
    /* renamed from: com.iqoption.fragment.account.security.phone.d$1 */
    static class AnonymousClass1 implements a {
        final /* synthetic */ d cuJ;

        AnonymousClass1(d dVar) {
            this.cuJ = dVar;
        }

        public void onSizeChanged(int i, int i2, int i3, int i4) {
            this.cuJ.cuI.bhZ.setFrameTopGapSize((float) i);
        }
    }

    public static d a(Context context, ViewGroup viewGroup, int i, long j) {
        d dVar = new d();
        dVar.a(context, viewGroup);
        dVar.cuI.getRoot().setTag(TAG);
        dVar.cuI.bhZ.setText(az.w(i, j));
        dVar.cuI.bhY.setOnSizeChangedListener(new AnonymousClass1(dVar));
        return dVar;
    }

    public View getView() {
        return this.cuI.getRoot();
    }

    private void a(Context context, ViewGroup viewGroup) {
        this.cuI = (k) DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.account_security_confirmed_phone_fragment, viewGroup, viewGroup != null);
    }
}
