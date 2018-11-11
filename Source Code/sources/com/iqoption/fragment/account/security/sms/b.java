package com.iqoption.fragment.account.security.sms;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.iqoption.analytics.EventManager;
import com.iqoption.core.i;
import com.iqoption.d.e;
import com.iqoption.dto.Event;
import com.iqoption.x.R;

/* compiled from: ConfirmPhone2StepAuthViewHelper */
public class b {
    public static final String TAG = "com.iqoption.fragment.account.security.sms.b";
    private int countryCode;
    private long cuB;
    private e cuX;
    private a cuY;

    /* compiled from: ConfirmPhone2StepAuthViewHelper */
    public interface a {
        void u(int i, long j);
    }

    public static b b(Context context, ViewGroup viewGroup, int i, long j) {
        b bVar = new b();
        bVar.countryCode = i;
        bVar.cuB = j;
        bVar.a(context, viewGroup);
        bVar.cuX.getRoot().setTag(TAG);
        return bVar;
    }

    public View getView() {
        return this.cuX.getRoot();
    }

    public void a(a aVar) {
        this.cuY = aVar;
    }

    private void a(Context context, ViewGroup viewGroup) {
        this.cuX = (e) DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.account_security_confirm_phone_2step_auth_fragment, viewGroup, viewGroup != null);
        this.cuX.a(this);
    }

    public void ajC() {
        i.d(TAG, "onConfirmPhone");
        f(true, true);
        this.cuX.bhP.post(new Runnable() {
            public void run() {
                if (b.this.cuY != null) {
                    b.this.cuY.u(b.this.countryCode, b.this.cuB);
                    b.this.f(false, false);
                }
            }
        });
        EventManager.Bm().a(new Event(Event.CATEGORY_BUTTON_PRESSED, "security-2tep_send"));
    }

    private void f(boolean z, boolean z2) {
        this.cuX.bhP.f(z, z2);
    }
}
