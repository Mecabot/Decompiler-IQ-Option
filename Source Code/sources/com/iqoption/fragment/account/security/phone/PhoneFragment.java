package com.iqoption.fragment.account.security.phone;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.common.b.e;
import com.google.common.util.concurrent.g;
import com.google.common.util.concurrent.s;
import com.iqoption.app.IQApp;
import com.iqoption.app.af;
import com.iqoption.app.b.b.o;
import com.iqoption.core.i;
import com.iqoption.d.lb;
import com.iqoption.mobbtech.connect.response.MobbErrorException;
import com.iqoption.mobbtech.connect.response.l;
import com.iqoption.mobbtech.connect.response.m;
import com.iqoption.mobbtech.connect.response.n;
import com.iqoption.x.R;
import java.lang.ref.WeakReference;

public class PhoneFragment extends Fragment implements com.iqoption.fragment.account.security.phone.a.b, com.iqoption.fragment.account.security.phone.b.b, com.iqoption.fragment.account.security.phone.c.b, com.iqoption.fragment.account.security.phone.e.b {
    private static final String ARG_COUNTRY_CODE;
    public static final String TAG = "com.iqoption.fragment.account.security.phone.PhoneFragment";
    private static final String cuK;
    private int countryCode;
    private long cuB;
    private com.iqoption.fragment.account.security.sms.a cuL;
    private b cuM = new b(this, null);
    private lb cuo;

    private enum ConfirmState {
        waitingForNumber,
        requestConfirmCode,
        waitingForConfirmationCode,
        confirmationCodeReceived,
        confirmationCodeSubmitted,
        confirmationCodeExpired,
        confirmed
    }

    private static class b {
        private final WeakReference<PhoneFragment> ckC;

        /* synthetic */ b(PhoneFragment phoneFragment, AnonymousClass1 anonymousClass1) {
            this(phoneFragment);
        }

        private b(PhoneFragment phoneFragment) {
            this.ckC = new WeakReference(phoneFragment);
        }

        @e
        public void onPhoneConfirmed(o oVar) {
            String str = PhoneFragment.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onPhoneConfirmed() phoneIsConfirmed=");
            stringBuilder.append(oVar.getValue());
            i.d(str, stringBuilder.toString());
            if (((Boolean) oVar.getValue()).booleanValue()) {
                com.iqoption.core.d.a.aSe.execute(new Runnable() {
                    public void run() {
                        PhoneFragment phoneFragment = (PhoneFragment) b.this.ckC.get();
                        if (phoneFragment != null) {
                            phoneFragment.s(phoneFragment.countryCode, phoneFragment.cuB);
                        }
                    }
                });
            }
        }
    }

    private static class d extends com.iqoption.mobbtech.connect.response.n.a<PhoneFragment> {
        /* synthetic */ d(PhoneFragment phoneFragment, AnonymousClass1 anonymousClass1) {
            this(phoneFragment);
        }

        private d(PhoneFragment phoneFragment) {
            super(phoneFragment);
        }

        /* renamed from: a */
        public void z(PhoneFragment phoneFragment, n nVar) {
            if (!TextUtils.isEmpty(nVar.getMessage())) {
                com.iqoption.app.a.b.b(nVar.getMessage(), phoneFragment.getContext());
            }
        }
    }

    private static class a extends d {
        private final int countryCode;
        private final long cuB;

        public a(PhoneFragment phoneFragment, int i, long j) {
            super(phoneFragment, null);
            this.countryCode = i;
            this.cuB = j;
        }

        /* renamed from: a */
        public void z(PhoneFragment phoneFragment, n nVar) {
            String str = PhoneFragment.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ConfirmPhoneCallback::onSuccess() result=");
            stringBuilder.append(nVar);
            i.d(str, stringBuilder.toString());
            phoneFragment.s(this.countryCode, this.cuB);
        }

        public void l(Throwable th) {
            i.e(PhoneFragment.TAG, th.toString(), th);
            if (th instanceof MobbErrorException) {
                String errorMessage = ((MobbErrorException) th).auU().getErrorMessage();
                if (TextUtils.isEmpty(errorMessage)) {
                    com.iqoption.app.a.b.aT(IQApp.Dk());
                } else if (errorMessage.indexOf(44) == -1) {
                    com.iqoption.app.a.b.b(errorMessage, IQApp.Dk());
                } else {
                    com.iqoption.app.a.b.b(errorMessage.substring(0, errorMessage.indexOf(44)), IQApp.Dk());
                }
            }
        }
    }

    private static class c extends d {
        private final int countryCode;
        private final long cuB;

        public c(PhoneFragment phoneFragment, int i, long j) {
            super(phoneFragment, null);
            this.countryCode = i;
            this.cuB = j;
        }

        /* renamed from: a */
        public void z(PhoneFragment phoneFragment, n nVar) {
            String str = PhoneFragment.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("RequestConfirmCallback::onSuccess() result=");
            stringBuilder.append(nVar);
            i.d(str, stringBuilder.toString());
            phoneFragment.t(this.countryCode, this.cuB);
        }
    }

    public void n(int i, long j) {
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TAG);
        stringBuilder.append(".ARG_COUNTRY_CODE");
        ARG_COUNTRY_CODE = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(TAG);
        stringBuilder.append(".ARG_NATIONAL_PHONE");
        cuK = stringBuilder.toString();
    }

    public static PhoneFragment q(int i, long j) {
        PhoneFragment phoneFragment = new PhoneFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_COUNTRY_CODE, i);
        bundle.putLong(cuK, j);
        phoneFragment.setArguments(bundle);
        return phoneFragment;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cuL = new com.iqoption.fragment.account.security.sms.a(getContext());
        this.cuo = (lb) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_account_security_page, viewGroup, false);
        if (getArguments() != null) {
            this.countryCode = getArguments().getInt(ARG_COUNTRY_CODE);
            this.cuB = getArguments().getLong(cuK);
        }
        IQApp.Dn().aD(this.cuM);
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onCreateView, confirm time left: ");
        stringBuilder.append(ajx());
        i.d(str, stringBuilder.toString());
        if (this.cuB == 0) {
            a(ConfirmState.waitingForNumber);
        } else if (com.iqoption.app.a.aL(getContext()).De()) {
            a(ConfirmState.confirmed);
        } else if (bk(ajx())) {
            a(ConfirmState.requestConfirmCode);
        } else {
            a(ConfirmState.waitingForConfirmationCode);
        }
        return this.cuo.getRoot();
    }

    public void onDestroyView() {
        IQApp.Dn().unregister(this.cuM);
        super.onDestroyView();
    }

    private void a(ConfirmState confirmState) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("setStartPhoneView: ");
        stringBuilder.append(confirmState);
        i.d(str, stringBuilder.toString());
        switch (confirmState) {
            case waitingForNumber:
                c(this.countryCode, this.cuB, this.cuo.bwt);
                return;
            case requestConfirmCode:
                d(this.countryCode, this.cuB, this.cuo.bwt);
                return;
            case waitingForConfirmationCode:
                a(this.countryCode, this.cuB, af.aR(getContext()).EL(), (int) ajx(), this.cuo.bwt);
                return;
            case confirmed:
                a(this.countryCode, this.cuB, this.cuo.bwt);
                return;
            default:
                stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported state: ");
                stringBuilder.append(confirmState);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public s<? extends l> r(int i, long j) {
        boolean z = i == this.countryCode && j == this.cuB;
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onSavePhone() countryCode=");
        stringBuilder.append(i);
        stringBuilder.append(", nationalNumber=");
        stringBuilder.append(j);
        stringBuilder.append(", isSamePhone=");
        stringBuilder.append(z);
        i.d(str, stringBuilder.toString());
        s<? extends l> bE;
        if (z) {
            long ajx = ajx();
            if (bk(ajx)) {
                i.d(TAG, "confirmation code is expired");
                bE = com.iqoption.mobbtech.connect.request.api.a.bE(getContext());
                com.google.common.util.concurrent.o.a(bE, new c(this, i, j), com.iqoption.core.d.a.aSe);
                return bE;
            }
            int EL = af.aR(getContext()).EL();
            String str2 = TAG;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("confirmation code is not expired, confirmCode:");
            stringBuilder2.append(EL);
            i.d(str2, stringBuilder2.toString());
            com.iqoption.mobbtech.connect.response.o oVar = new com.iqoption.mobbtech.connect.response.o();
            oVar.isSuccessful = Boolean.valueOf(true);
            bE = com.google.common.util.concurrent.o.aR(oVar);
            com.iqoption.util.b.a(a(i, j, EL, (int) ajx, null), this.cuo.bwt, true);
            return bE;
        }
        i.d(TAG, "save phone & request confirm code");
        this.countryCode = i;
        this.cuB = j;
        bE = com.google.common.util.concurrent.o.a(com.iqoption.mobbtech.connect.request.api.a.b(getContext(), (long) i, j), new g<m, com.iqoption.mobbtech.connect.response.o>() {
            /* renamed from: a */
            public s<com.iqoption.mobbtech.connect.response.o> aP(m mVar) {
                return com.iqoption.mobbtech.connect.request.api.a.bE(PhoneFragment.this.getContext());
            }
        });
        com.google.common.util.concurrent.o.a(bE, new c(this, i, j), com.iqoption.core.d.a.aSe);
        return bE;
    }

    public s<? extends l> a(int i, long j, String str) {
        String str2 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onTradeRoomRestrictionFragmentConfirm() countryCode=");
        stringBuilder.append(i);
        stringBuilder.append(", nationalNumber=");
        stringBuilder.append(j);
        i.d(str2, stringBuilder.toString());
        s<? extends l> D = com.iqoption.mobbtech.connect.request.api.a.D(getContext(), str);
        com.google.common.util.concurrent.o.a(D, new a(this, i, j), com.iqoption.core.d.a.aSe);
        return D;
    }

    private void s(int i, long j) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onPhoneConfirmed() countryCode=");
        stringBuilder.append(i);
        stringBuilder.append(", nationalNumber=");
        stringBuilder.append(j);
        i.d(str, stringBuilder.toString());
        this.countryCode = i;
        this.cuB = j;
        af.aR(getContext()).ac(0);
        af.aR(getContext()).cP(0);
        com.iqoption.util.b.a(a(i, j, null), this.cuo.bwt, true);
    }

    public void m(int i, long j) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onConfirmCodeExpired() countryCode=");
        stringBuilder.append(i);
        stringBuilder.append(", nationalNumber=");
        stringBuilder.append(j);
        i.d(str, stringBuilder.toString());
        this.countryCode = i;
        this.cuB = j;
        af.aR(getContext()).ac(0);
        af.aR(getContext()).cP(0);
        com.iqoption.util.b.a(b(i, j, null), this.cuo.bwt, true);
    }

    public s<? extends l> p(int i, long j) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onRequestConfirm() countryCode=");
        stringBuilder.append(i);
        stringBuilder.append(", nationalNumber=");
        stringBuilder.append(j);
        i.d(str, stringBuilder.toString());
        this.countryCode = i;
        this.cuB = j;
        long ajx = ajx();
        if (bk(ajx)) {
            i.d(TAG, "confirmation code is expired");
            s<? extends l> bE = com.iqoption.mobbtech.connect.request.api.a.bE(getContext());
            com.google.common.util.concurrent.o.a(bE, new c(this, i, j), com.iqoption.core.d.a.aSe);
            return bE;
        }
        int EL = af.aR(getContext()).EL();
        String str2 = TAG;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("confirmation code is not expired, confirmCode:");
        stringBuilder2.append(EL);
        i.d(str2, stringBuilder2.toString());
        com.iqoption.mobbtech.connect.response.o oVar = new com.iqoption.mobbtech.connect.response.o();
        oVar.isSuccessful = Boolean.valueOf(true);
        s<? extends l> aR = com.google.common.util.concurrent.o.aR(oVar);
        com.iqoption.util.b.a(a(i, j, EL, (int) ajx, null), this.cuo.bwt, true);
        return aR;
    }

    public void l(int i, long j) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onChangeNumber() countryCode=");
        stringBuilder.append(i);
        stringBuilder.append(", nationalNumber=");
        stringBuilder.append(j);
        i.d(str, stringBuilder.toString());
        this.countryCode = i;
        this.cuB = j;
        com.iqoption.util.b.a(c(i, j, null), this.cuo.bwt, true);
    }

    public void t(int i, long j) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onConfirmCodeSent() countryCode=");
        stringBuilder.append(i);
        stringBuilder.append(", nationalNumber=");
        stringBuilder.append(j);
        i.d(str, stringBuilder.toString());
        this.countryCode = i;
        this.cuB = j;
        af.aR(getContext()).ac(System.currentTimeMillis());
        com.iqoption.util.b.a(a(i, j, 0, this.cuL.ajB(), null), this.cuo.bwt, true);
    }

    public s<? extends l> k(int i, long j) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onSendConfirmationCodeAgain() countryCode=");
        stringBuilder.append(i);
        stringBuilder.append(", nationalNumber=");
        stringBuilder.append(j);
        i.d(str, stringBuilder.toString());
        this.countryCode = i;
        this.cuB = j;
        s<? extends l> bE = com.iqoption.mobbtech.connect.request.api.a.bE(getContext());
        com.google.common.util.concurrent.o.a(bE, new c(this, i, j), com.iqoption.core.d.a.aSe);
        return bE;
    }

    @NonNull
    private View a(int i, long j, ViewGroup viewGroup) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("createConfirmedPhoneView() countryCode=");
        stringBuilder.append(i);
        stringBuilder.append(", nationalNumber=");
        stringBuilder.append(j);
        i.d(str, stringBuilder.toString());
        return d.a(getContext(), viewGroup, i, j).getView();
    }

    @NonNull
    private View b(int i, long j, ViewGroup viewGroup) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("createConfirmationCodeExpiredView() countryCode=");
        stringBuilder.append(i);
        stringBuilder.append(", nationalNumber=");
        stringBuilder.append(j);
        i.d(str, stringBuilder.toString());
        return a.a(getContext(), viewGroup, i, j, this).getView();
    }

    @NonNull
    private View c(int i, long j, ViewGroup viewGroup) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("createPhoneNumberView() countryCode=");
        stringBuilder.append(i);
        stringBuilder.append(", nationalNumber=");
        stringBuilder.append(j);
        i.d(str, stringBuilder.toString());
        return e.a(getContext(), viewGroup, i, j, this).getView();
    }

    @NonNull
    private View d(int i, long j, ViewGroup viewGroup) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("createConfirmPhoneView() countryCode=");
        stringBuilder.append(i);
        stringBuilder.append(", nationalNumber=");
        stringBuilder.append(j);
        i.d(str, stringBuilder.toString());
        return c.a(getContext(), viewGroup, i, j, this).getView();
    }

    @NonNull
    private View a(int i, long j, int i2, int i3, ViewGroup viewGroup) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("createConfirmCodeView() countryCode=");
        int i4 = i;
        stringBuilder.append(i4);
        stringBuilder.append(", nationalNumber=");
        long j2 = j;
        stringBuilder.append(j2);
        i.d(str, stringBuilder.toString());
        return b.a(getContext(), viewGroup, i4, j2, i2, i3, this).getView();
    }

    private long ajx() {
        return this.cuL.bl(af.aR(getContext()).EK());
    }

    private boolean bk(long j) {
        return this.cuL.bk(j);
    }
}
