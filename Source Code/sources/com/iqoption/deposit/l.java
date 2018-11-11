package com.iqoption.deposit;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.iqoption.app.IQApp;
import com.iqoption.core.microservices.billing.response.deposit.PayMethod;
import com.iqoption.core.microservices.billing.response.deposit.PayMethod.PayMethodType;
import com.iqoption.core.microservices.billing.response.deposit.c;
import com.iqoption.core.microservices.billing.response.deposit.g;
import com.iqoption.dto.Balance;
import com.iqoption.dto.entity.Feature;
import com.iqoption.fragment.cashbox.deppage.e;
import com.iqoption.fragment.cashbox.j;
import com.iqoption.fragment.cashbox.k;
import com.iqoption.mobbtech.connect.request.api.Requests;
import com.iqoption.mobbtech.connect.response.MobbErrorException;
import com.iqoption.mobbtech.connect.response.h;
import com.iqoption.mobbtech.connect.response.i;
import com.iqoption.system.c.b;
import com.iqoption.util.ag;
import com.iqoption.x.R;
import java.util.ArrayList;

/* compiled from: DepositPageActivityDelegate */
public class l implements com.iqoption.fragment.cashbox.a.a.a, e, com.iqoption.fragment.cashbox.i.a, com.iqoption.fragment.cashbox.k.a, com.iqoption.fragment.cashbox.l.a {
    private static final String TAG = "com.iqoption.deposit.l";
    private final DepositActivity bVv;

    /* compiled from: DepositPageActivityDelegate */
    private static class a extends b<l, i> {
        public a(l lVar) {
            super((Object) lVar);
        }

        /* renamed from: a */
        public void z(l lVar, i iVar) {
            lVar.a(iVar);
        }

        /* renamed from: a */
        public void c(l lVar, Throwable th) {
            i iVar = (i) MobbErrorException.a(i.class, th);
            String iVar2 = iVar != null ? iVar.toString() : th != null ? th.toString() : "";
            lVar.a(false, iVar != null ? iVar.getErrorMessage() : null, "cashbox_process_error", iVar2);
        }
    }

    public l(DepositActivity depositActivity) {
        this.bVv = depositActivity;
    }

    public s<Boolean> a(PayMethod payMethod, c cVar, Double d, com.iqoption.core.microservices.billing.response.deposit.a aVar, String str, boolean z) {
        if (d != null) {
            double d2 = 0.0d;
            if (d.doubleValue() > 0.0d) {
                if (aaF()) {
                    return o.vT();
                }
                Balance cG = com.iqoption.app.a.aL(this.bVv).cG(1);
                if (cG != null) {
                    d2 = ((Double) com.google.common.base.e.h(cG.amount, Double.valueOf(0.0d))).doubleValue();
                }
                IQApp.Dn().aE(new g.b(d.doubleValue(), d2));
                long UQ = (!z || payMethod.UW() == -1) ? payMethod.UQ() : payMethod.UW();
                long j = UQ;
                String name = cVar.getName();
                if (payMethod.UT() == PayMethodType.UserCard && !z) {
                    com.iqoption.core.i.d(TAG, "onDepositOnDepositPagePressed, one click process");
                    return ag.a(com.iqoption.mobbtech.connect.response.a.a.ava().iM("onDepositOnDepositPagePressed, one click process"), new m(this, payMethod, j, d, name, str));
                } else if (com.iqoption.core.microservices.billing.response.deposit.e.b(payMethod)) {
                    com.iqoption.core.i.d(TAG, "onDepositOnDepositPagePressed, native process");
                    a(payMethod, d, str, name, cVar.getSymbol(), z);
                    return o.aR(Boolean.valueOf(true));
                } else {
                    if (payMethod.UT() == PayMethodType.PaymentMethod) {
                        g gVar = (g) payMethod;
                        if (gVar.Va() != null) {
                            com.iqoption.core.i.d(TAG, "onDepositOnDepositPagePressed, constructor process");
                            this.bVv.getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_right, 17432579).add(R.id.fragment, com.iqoption.fragment.cashbox.a.a.a(gVar, name, d.doubleValue(), str), com.iqoption.fragment.cashbox.a.a.TAG).addToBackStack(com.iqoption.fragment.cashbox.a.a.TAG).commit();
                            return o.aR(Boolean.valueOf(true));
                        }
                    }
                    String str2 = str;
                    com.iqoption.core.i.d(TAG, "onDepositOnDepositPagePressed, pay process");
                    return ag.a(com.iqoption.mobbtech.connect.response.a.a.ava().iM("onDepositOnDepositPagePressed, pay process"), new n(this, j, name, d, str2));
                }
            }
        }
        return o.m(new RuntimeException("deposit amount is zero or null"));
    }

    private void a(@NonNull PayMethod payMethod, Double d, String str, String str2, String str3, boolean z) {
        this.bVv.getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_right, 17432579).add(R.id.fragment, com.iqoption.fragment.cashbox.i.a(payMethod, str2, str3, d.doubleValue(), str, z), com.iqoption.fragment.cashbox.i.TAG).addToBackStack(com.iqoption.fragment.cashbox.i.TAG).commit();
    }

    public void e(boolean z, String str) {
        a(z, null, "pay_response_web_page", str);
    }

    public void aau() {
        com.iqoption.mobbtech.connect.response.a.a.ava().restart();
        this.bVv.getSupportFragmentManager().popBackStack(com.iqoption.fragment.cashbox.l.TAG, 1);
    }

    public void aav() {
        this.bVv.Ag();
    }

    public void cq(boolean z) {
        z = z && this.bVv.aas();
        this.bVv.getSupportFragmentManager().b(com.iqoption.fragment.cashbox.deppage.b.TAG, 1);
        this.bVv.zC();
        com.iqoption.core.d.a.aSe.postDelayed(new o(this, z), 1000);
    }

    final /* synthetic */ void cr(boolean z) {
        this.bVv.zB();
        if (z) {
            new com.iqoption.kyc.activity.KycActivity.a(this.bVv).dQ(true).start();
            this.bVv.finish();
            return;
        }
        this.bVv.Ag();
    }

    public void aaw() {
        FragmentManager supportFragmentManager = this.bVv.getSupportFragmentManager();
        if (supportFragmentManager.findFragmentByTag(com.iqoption.fragment.cashbox.deppage.b.TAG) != null) {
            supportFragmentManager.popBackStack(com.iqoption.fragment.cashbox.deppage.b.TAG, 0);
        } else {
            supportFragmentManager.popBackStack(k.TAG, 1);
        }
    }

    public void aax() {
        this.bVv.aat();
    }

    public void a(i iVar) {
        String str = null;
        if (iVar == null || !iVar.isSuccessful()) {
            if (iVar != null) {
                str = iVar.getErrorMessage();
            }
            a(false, str, "pay_response_error", iVar != null ? iVar.toString() : "null");
        } else if (iVar.cVQ == null || iVar.cVQ.cVS == null || iVar.cVQ.cVS.url == null) {
            a(true, null, "pay_response_no_redirect_success", iVar.toString());
        } else if (iVar.cVQ.cVS.url.contains("redirect/success")) {
            a(true, null, "pay_response_redirect_success", iVar.toString());
        } else if (iVar.cVQ.cVS.url.contains("redirect/failed")) {
            a(false, iVar.getErrorMessage(), "pay_response_redirect_failed", iVar.toString());
        } else {
            this.bVv.getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_right, 17432579).add(R.id.fragment, com.iqoption.fragment.cashbox.l.a(iVar.cVQ.cVS.url, iVar.cVQ.cVS.anM, "POST".equals(iVar.cVQ.cVS.method)), com.iqoption.fragment.cashbox.l.TAG).addToBackStack(com.iqoption.fragment.cashbox.l.TAG).commitAllowingStateLoss();
        }
    }

    public void b(i iVar) {
        a(iVar);
    }

    private void a(boolean z, @Nullable String str, String str2, String str3) {
        com.iqoption.mobbtech.connect.response.a.a.ava().restart();
        if (this.bVv.aaA() && z) {
            com.iqoption.tutorial.b.bO(this.bVv).fa(true);
        }
        IQApp.Dn().aE(new com.iqoption.deposit.g.a(z));
        if (z) {
            aaE();
        }
        this.bVv.getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_in_right, 17432577, R.anim.slide_in_right, 17432577).add(R.id.fragment, k.b(z, str, str2, str3), k.TAG).addToBackStack(k.TAG).commitAllowingStateLoss();
    }

    private void aaE() {
        com.iqoption.app.a aL = com.iqoption.app.a.aL(this.bVv);
        if (Balance.getBalanceType(aL.CC()) != 1) {
            Balance cG = aL.cG(1);
            if (cG != null) {
                Requests.a(this.bVv, cG, new com.iqoption.mobbtech.connect.a.a() {
                    /* renamed from: a */
                    public void onSuccess(h hVar) {
                        com.iqoption.core.i.d(l.TAG, "balance has been changed to normal");
                    }

                    public void a(com.iqoption.mobbtech.connect.response.g gVar) {
                        String access$000 = l.TAG;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("change balance error ");
                        stringBuilder.append(gVar);
                        com.iqoption.core.i.e(access$000, stringBuilder.toString());
                    }
                });
            }
        }
    }

    public void aay() {
        this.bVv.getSupportFragmentManager().popBackStack(com.iqoption.fragment.cashbox.i.TAG, 1);
    }

    public void aaz() {
        this.bVv.getSupportFragmentManager().popBackStack(com.iqoption.fragment.cashbox.a.a.TAG, 1);
    }

    public void a(@Nullable ArrayList<com.iqoption.core.c.c.a> arrayList, String str, boolean z, boolean z2) {
        b(arrayList, str, z, z2);
    }

    private void b(@Nullable ArrayList<com.iqoption.core.c.c.a> arrayList, String str, boolean z, boolean z2) {
        Fragment a;
        this.bVv.zB();
        if (com.iqoption.app.managers.feature.b.HT().ff("crypto-deposit")) {
            a = com.iqoption.fragment.cashbox.deppage.b.cyL.a(0.0d, z, str, z2);
        } else {
            a = j.a(arrayList, str, z, this.bVv.aaB());
        }
        this.bVv.getSupportFragmentManager().beginTransaction().add(R.id.fragment, a, com.iqoption.fragment.cashbox.deppage.b.TAG).addToBackStack(com.iqoption.fragment.cashbox.deppage.b.TAG).commit();
    }

    private boolean aaF() {
        com.iqoption.app.a aL = com.iqoption.app.a.aL(this.bVv);
        if (!this.bVv.zK() || !aaG() || !aL.Dh() || aL.CZ() || aL.akD) {
            return false;
        }
        new com.iqoption.kyc.activity.KycActivity.a(this.bVv).ic(com.iqoption.kyc.fragment.b.TAG).dO(true).start();
        return true;
    }

    private boolean aaG() {
        Feature fd = com.iqoption.app.managers.feature.b.HT().fd("kyc-show-after-registration");
        return fd != null && ("enabled-before-dep".equals(fd.status) || "enabled".equals(fd.status) || "enabled-without-skip".equals(fd.status));
    }
}
