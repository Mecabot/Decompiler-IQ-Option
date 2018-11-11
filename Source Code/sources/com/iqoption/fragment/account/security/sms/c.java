package com.iqoption.fragment.account.security.sms;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.google.common.b.e;
import com.google.common.util.concurrent.o;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import com.iqoption.analytics.EventManager;
import com.iqoption.app.b.b.n;
import com.iqoption.core.i;
import com.iqoption.d.s;
import com.iqoption.dto.Event;
import com.iqoption.mobbtech.connect.response.l;
import com.iqoption.util.az;
import com.iqoption.x.R;
import java.lang.ref.WeakReference;

/* compiled from: TurnOn2StepAuthViewHelper */
public class c implements OnCheckedChangeListener {
    public static final String TAG = "com.iqoption.fragment.account.security.sms.c";
    private int countryCode;
    private long cuB;
    private s cvh;
    private b cvi;

    /* compiled from: TurnOn2StepAuthViewHelper */
    private static class a {
        private final WeakReference<c> cvj;

        private a(c cVar) {
            this.cvj = new WeakReference(cVar);
        }

        @e
        public void authIsTwoFactor(com.iqoption.app.b.b.c cVar) {
            String str = c.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("authIsTwoFactor event =");
            stringBuilder.append(cVar);
            i.d(str, stringBuilder.toString());
            c cVar2 = (c) this.cvj.get();
            if (cVar2 != null && ViewCompat.isAttachedToWindow(cVar2.getView()) && ((Boolean) cVar.getValue()).booleanValue() != cVar2.cvh.bip.isChecked()) {
                cVar2.de(((Boolean) cVar.getValue()).booleanValue());
                cVar2.cvh.bip.f(false, false);
            }
        }

        @e
        public void phoneChanged(n nVar) {
            String str = c.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("phoneChanged event =");
            stringBuilder.append(nVar);
            i.d(str, stringBuilder.toString());
            c cVar = (c) this.cvj.get();
            if (cVar != null && ViewCompat.isAttachedToWindow(cVar.getView())) {
                int i;
                long j;
                Context context = cVar.getView().getContext();
                PhoneNumber CM = com.iqoption.app.a.aL(context).CM();
                if (CM == null) {
                    i = 0;
                } else {
                    i = CM.xE();
                }
                cVar.countryCode = i;
                if (CM == null) {
                    j = 0;
                } else {
                    j = CM.ye();
                }
                cVar.cuB = j;
                cVar.a(context, cVar.countryCode, cVar.cuB);
            }
        }
    }

    /* compiled from: TurnOn2StepAuthViewHelper */
    public interface b {
        com.google.common.util.concurrent.s<? extends l> a(boolean z, int i, long j);
    }

    /* compiled from: TurnOn2StepAuthViewHelper */
    private static class c extends com.iqoption.system.c.b<c, l> {
        private final boolean cvk;

        public c(c cVar, boolean z) {
            super((Object) cVar);
            this.cvk = z;
        }

        /* renamed from: a */
        public void z(c cVar, l lVar) {
            if (!this.cvk) {
                e(cVar);
            }
        }

        /* renamed from: a */
        public void c(c cVar, Throwable th) {
            e(cVar);
            cVar.de(com.iqoption.app.a.aL(cVar.getView().getContext()).CR());
        }

        private static void e(c cVar) {
            cVar.cvh.bip.f(false, false);
        }
    }

    public static c a(Context context, ViewGroup viewGroup, int i, long j, boolean z, b bVar) {
        c cVar = new c();
        cVar.countryCode = i;
        cVar.cuB = j;
        cVar.cvi = bVar;
        cVar.a(context, viewGroup);
        cVar.cvh.getRoot().setTag(TAG);
        cVar.de(z);
        cVar.cvh.bip.setOnCheckedChangeListener(cVar);
        cVar.a(context, i, j);
        return cVar;
    }

    public Object ajF() {
        return new a();
    }

    private void de(boolean z) {
        this.cvh.bip.setOnCheckedChangeListener(null);
        this.cvh.bip.setChecked(z);
        this.cvh.biq.setText(z ? R.string.turn_off : R.string.turn_on);
        this.cvh.bip.setOnCheckedChangeListener(this);
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        df(z);
    }

    public void df(boolean z) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onCheckedChanged, isChecked=");
        stringBuilder.append(z);
        i.d(str, stringBuilder.toString());
        this.cvh.bip.f(true, true);
        o.a(this.cvi.a(z, this.countryCode, this.cuB), new c(this, z), com.iqoption.core.d.a.aSe);
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "security_2step-auth-set").setValue(Double.valueOf(z ? 1.0d : 0.0d)).build());
    }

    public void a(Context context, int i, long j) {
        CharSequence w = az.w(i, j);
        if (TextUtils.isEmpty(w) || "0".equals(w)) {
            Log.e(TAG, "phone number is not set");
            this.cvh.bio.setText("");
            return;
        }
        this.cvh.bio.setText(context.getString(R.string.via_phone_number, new Object[]{w}));
    }

    public View getView() {
        return this.cvh.getRoot();
    }

    private void a(Context context, ViewGroup viewGroup) {
        this.cvh = (s) DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.account_security_turn_on_2step_auth_fragment, viewGroup, viewGroup != null);
        this.cvh.a(this);
    }
}
