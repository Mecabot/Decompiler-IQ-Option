package com.iqoption.fragment.account.security.sms;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.common.b.e;
import com.google.common.base.Optional;
import com.google.common.util.concurrent.s;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import com.iqoption.app.IQApp;
import com.iqoption.app.af;
import com.iqoption.app.b.b.o;
import com.iqoption.core.i;
import com.iqoption.d.lb;
import com.iqoption.mobbtech.connect.response.l;
import com.iqoption.mobbtech.connect.response.n;
import com.iqoption.util.aw;
import com.iqoption.x.R;
import java.lang.ref.WeakReference;

public class SmsFragment extends Fragment implements com.iqoption.fragment.account.security.phone.a.b, com.iqoption.fragment.account.security.phone.b.b, com.iqoption.fragment.account.security.sms.b.a, com.iqoption.fragment.account.security.sms.c.b {
    public static final String TAG = "com.iqoption.fragment.account.security.sms.SmsFragment";
    private a cuL;
    private lb cuo;
    private com.iqoption.app.a cva;
    private Object cvb;
    private c cvc = new c(this, null);

    private enum SmsScreens {
        waitingForPhoneConfirmation,
        turnOnOffAuthentication,
        confirmationCodeSent,
        confirmationCodeExpired
    }

    private static class c {
        private final WeakReference<SmsFragment> ckC;

        /* synthetic */ c(SmsFragment smsFragment, AnonymousClass1 anonymousClass1) {
            this(smsFragment);
        }

        private c(SmsFragment smsFragment) {
            this.ckC = new WeakReference(smsFragment);
        }

        @e
        public void onTwoFactorAuthEnabled(com.iqoption.app.b.b.c cVar) {
            String str = SmsFragment.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onTwoFactorAuthEnabled event, isAuthTwoFactor=");
            stringBuilder.append(cVar);
            i.d(str, stringBuilder.toString());
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    SmsFragment smsFragment = (SmsFragment) c.this.ckC.get();
                    if (smsFragment != null) {
                        af.aR(smsFragment.getContext()).ad(0);
                        af.aR(smsFragment.getContext()).cQ(0);
                        boolean CR = smsFragment.cva.CR();
                        PhoneNumber CM = smsFragment.cva.CM();
                        if (smsFragment.isAdded() && smsFragment.cuo.bwt.getChildCount() == 1) {
                            View childAt = smsFragment.cuo.bwt.getChildAt(0);
                            boolean equals = aw.equals(childAt.getTag(), com.iqoption.fragment.account.security.phone.a.TAG);
                            boolean equals2 = aw.equals(childAt.getTag(), com.iqoption.fragment.account.security.phone.b.TAG);
                            if (equals || equals2) {
                                com.iqoption.util.b.b(smsFragment.a(CM.xE(), CM.ye(), CR, null), smsFragment.cuo.bwt, true);
                            }
                        }
                    }
                }
            });
        }

        @e
        public void onPhoneConfirmed(o oVar) {
            String str = SmsFragment.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onPhoneConfirmed event, phoneIsConfirmed=");
            stringBuilder.append(oVar);
            i.d(str, stringBuilder.toString());
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    SmsFragment smsFragment = (SmsFragment) c.this.ckC.get();
                    if (smsFragment != null && smsFragment.isAdded() && smsFragment.cuo.bwt.getChildCount() == 1 && aw.equals(smsFragment.cuo.bwt.getChildAt(0).getTag(), b.TAG) && smsFragment.cva.De()) {
                        PhoneNumber CM = smsFragment.cva.CM();
                        com.iqoption.util.b.b(smsFragment.a(CM.xE(), CM.ye(), smsFragment.cva.CR(), null), smsFragment.cuo.bwt, true);
                    }
                }
            });
        }
    }

    public interface d {
        void j(int i, long j);
    }

    private static class a extends com.iqoption.mobbtech.connect.response.n.a<SmsFragment> {
        public a(SmsFragment smsFragment) {
            super(smsFragment);
        }

        /* renamed from: a */
        public void z(SmsFragment smsFragment, n nVar) {
            String str = SmsFragment.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("EnableTwoStepAuthCallback::onSuccess() result=");
            stringBuilder.append(nVar);
            i.d(str, stringBuilder.toString());
            super.z(smsFragment, nVar);
            smsFragment.ajE();
        }
    }

    private static class b extends com.iqoption.mobbtech.connect.response.n.a<SmsFragment> {
        private final boolean cvf;

        public b(SmsFragment smsFragment, boolean z) {
            super(smsFragment);
            this.cvf = z;
        }

        /* renamed from: a */
        public void z(SmsFragment smsFragment, n nVar) {
            String str = SmsFragment.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("EnableTwoStepAuthWithCodeCallback::onSuccess() result=");
            stringBuilder.append(nVar);
            i.d(str, stringBuilder.toString());
            smsFragment.dd(this.cvf);
        }
    }

    public void l(int i, long j) {
    }

    public static SmsFragment ajD() {
        SmsFragment smsFragment = new SmsFragment();
        smsFragment.setArguments(new Bundle());
        return smsFragment;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cuL = new a(getContext());
        this.cuo = (lb) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_account_security_page, viewGroup, false);
        this.cva = com.iqoption.app.a.aL(getContext());
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onCreateView, confirm time left: ");
        stringBuilder.append(ajx());
        stringBuilder.append(", isPhoneConfirmed=");
        stringBuilder.append(this.cva.De());
        stringBuilder.append(", isConfirmationCodeExpired=");
        stringBuilder.append(bk(ajx()));
        i.d(str, stringBuilder.toString());
        if (!this.cva.De()) {
            a(SmsScreens.waitingForPhoneConfirmation);
        } else if (bk(ajx())) {
            a(SmsScreens.turnOnOffAuthentication);
        } else {
            a(SmsScreens.confirmationCodeSent);
        }
        IQApp.Dn().aD(this.cvc);
        if (!(getParentFragment() instanceof d)) {
            Log.e(TAG, "OnFragmentInteractionListener is not implemented by target fragment");
        }
        return this.cuo.getRoot();
    }

    public void onDestroyView() {
        IQApp.Dn().unregister(this.cvc);
        bt(null);
        super.onDestroyView();
    }

    private void bt(Object obj) {
        if (this.cvb != null) {
            IQApp.Dn().unregister(this.cvb);
        }
        this.cvb = obj;
        if (this.cvb != null) {
            IQApp.Dn().aD(this.cvb);
        }
    }

    private void a(SmsScreens smsScreens) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("setStartPhoneView: ");
        stringBuilder.append(smsScreens);
        i.d(str, stringBuilder.toString());
        PhoneNumber CM = this.cva.CM();
        switch (smsScreens) {
            case waitingForPhoneConfirmation:
                d(CM.xE(), CM.ye(), this.cuo.bwt);
                return;
            case turnOnOffAuthentication:
                a(CM.xE(), CM.ye(), this.cva.CR(), this.cuo.bwt);
                return;
            case confirmationCodeSent:
                a(CM.xE(), CM.ye(), af.aR(getContext()).EN(), (int) ajx(), this.cuo.bwt);
                return;
            default:
                return;
        }
    }

    public void u(int i, long j) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onConfirmPhone: ");
        stringBuilder.append(i);
        stringBuilder.append(" ");
        stringBuilder.append(j);
        i.d(str, stringBuilder.toString());
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof d) {
            ((d) parentFragment).j(i, j);
        }
    }

    private void dd(boolean z) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onTwoStepAuthConfirmed, isEnable=");
        stringBuilder.append(z);
        i.d(str, stringBuilder.toString());
        af.aR(getContext()).ad(0);
        af.aR(getContext()).cQ(0);
        PhoneNumber CM = this.cva.CM();
        com.iqoption.util.b.a(a(CM.xE(), CM.ye(), z, null), this.cuo.bwt, true);
    }

    private void ajE() {
        i.d(TAG, "onTwoStepAuthCodeRequested()");
        PhoneNumber CM = this.cva.CM();
        af.aR(getContext()).ad(System.currentTimeMillis());
        com.iqoption.util.b.a(a(CM.xE(), CM.ye(), 0, this.cuL.ajB(), null), this.cuo.bwt, true);
    }

    public s<? extends l> a(boolean z, int i, long j) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onTurnOnTwoStepAuthentication() isTurnOn=");
        stringBuilder.append(z);
        stringBuilder.append(", countryCode=");
        stringBuilder.append(i);
        stringBuilder.append(", nationalNumber=");
        stringBuilder.append(j);
        i.d(str, stringBuilder.toString());
        if (bk(ajx())) {
            s<? extends l> a = com.iqoption.mobbtech.connect.request.api.a.a(getContext(), z, Optional.pN());
            com.google.common.util.concurrent.o.a(a, new a(this), com.iqoption.core.d.a.aSe);
            return a;
        }
        com.iqoption.util.b.a(a(i, j, af.aR(getContext()).EN(), (int) ajx(), null), this.cuo.bwt, true);
        return com.google.common.util.concurrent.o.aR(new l() {
            public String getMessage() {
                return "";
            }

            public boolean isSuccessful() {
                return true;
            }
        });
    }

    public s<? extends l> a(int i, long j, String str) {
        String str2 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onTradeRoomRestrictionFragmentConfirm() confirmCode=");
        stringBuilder.append(str);
        stringBuilder.append(", countryCode=");
        stringBuilder.append(i);
        stringBuilder.append(", nationalNumber=");
        stringBuilder.append(j);
        i.d(str2, stringBuilder.toString());
        boolean CR = this.cva.CR() ^ 1;
        String str3 = TAG;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("onTradeRoomRestrictionFragmentConfirm() countryCode=");
        stringBuilder2.append(i);
        stringBuilder2.append(", nationalNumber=");
        stringBuilder2.append(j);
        stringBuilder2.append(", set auth state=");
        stringBuilder2.append(CR);
        i.d(str3, stringBuilder2.toString());
        s<? extends l> a = com.iqoption.mobbtech.connect.request.api.a.a(getContext(), CR, Optional.F(str));
        com.google.common.util.concurrent.o.a(a, new b(this, CR), com.iqoption.core.d.a.aSe);
        return a;
    }

    public void m(int i, long j) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onConfirmCodeExpired() countryCode=");
        stringBuilder.append(i);
        stringBuilder.append(", nationalNumber=");
        stringBuilder.append(j);
        i.d(str, stringBuilder.toString());
        af.aR(getContext()).ad(0);
        af.aR(getContext()).cQ(0);
        com.iqoption.util.b.a(b(i, j, null), this.cuo.bwt, true);
    }

    public s<? extends l> k(int i, long j) {
        boolean CR = this.cva.CR() ^ 1;
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onSendConfirmationCodeAgain() countryCode=");
        stringBuilder.append(i);
        stringBuilder.append(", nationalNumber=");
        stringBuilder.append(j);
        stringBuilder.append(", request code te set auth state=");
        stringBuilder.append(CR);
        i.d(str, stringBuilder.toString());
        s<? extends l> a = com.iqoption.mobbtech.connect.request.api.a.a(getContext(), CR, Optional.pN());
        com.google.common.util.concurrent.o.a(a, new a(this), com.iqoption.core.d.a.aSe);
        return a;
    }

    public void n(int i, long j) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onCancelConfirm() countryCode=");
        stringBuilder.append(i);
        stringBuilder.append(", nationalNumber=");
        stringBuilder.append(j);
        i.d(str, stringBuilder.toString());
        com.iqoption.util.b.a(a(i, j, this.cva.CR(), null), this.cuo.bwt, true);
    }

    @NonNull
    private View a(int i, long j, boolean z, ViewGroup viewGroup) {
        c a = c.a(getContext(), viewGroup, i, j, z, this);
        bt(a.ajF());
        return a.getView();
    }

    @NonNull
    private View d(int i, long j, ViewGroup viewGroup) {
        b b = b.b(getContext(), viewGroup, i, j);
        b.a(this);
        return b.getView();
    }

    @NonNull
    private View a(int i, long j, int i2, int i3, ViewGroup viewGroup) {
        return com.iqoption.fragment.account.security.phone.b.b(getContext(), viewGroup, i, j, i2, i3, this).getView();
    }

    @NonNull
    private View b(int i, long j, ViewGroup viewGroup) {
        return com.iqoption.fragment.account.security.phone.a.b(getContext(), viewGroup, i, j, this).getView();
    }

    private long ajx() {
        return this.cuL.bl(af.aR(getContext()).EM());
    }

    private boolean bk(long j) {
        return this.cuL.bk(j);
    }
}
