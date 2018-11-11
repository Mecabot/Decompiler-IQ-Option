package com.iqoption.withdrawal.crypto.fragment;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.common.base.Suppliers;
import com.google.common.base.n;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.iqoption.core.i;
import com.iqoption.d.va;
import com.iqoption.dto.Event;
import com.iqoption.dto.entity.position.Order;
import com.iqoption.dto.entity.position.Position;
import com.iqoption.dto.entity.result.KycState;
import com.iqoption.mobbtech.connect.response.e;
import com.iqoption.portfolio.a.g;
import com.iqoption.util.ac;
import com.iqoption.util.ag;
import com.iqoption.util.am;
import com.iqoption.util.aw;
import com.iqoption.withdrawal.crypto.kyc.KycWithdrawalStatus;
import com.iqoption.x.R;
import java.text.DecimalFormat;
import java.util.List;

public class WithdrawalCryptoPagerFragment extends Fragment implements com.iqoption.view.e.a, com.iqoption.withdrawal.crypto.barcode.a.a, com.iqoption.withdrawal.crypto.fragment.a.a, com.iqoption.withdrawal.crypto.fragment.b.a, com.iqoption.withdrawal.crypto.fragment.d.a {
    public static final String TAG = "com.iqoption.withdrawal.crypto.fragment.WithdrawalCryptoPagerFragment";
    private String assetName;
    private KycState cJn;
    private double cnV;
    private double cnW;
    private boolean cnX;
    private int ctU = 0;
    private e dSM;
    private com.iqoption.microservice.a.b.a dSR;
    @IdRes
    private int dSX;
    private a dSY;
    private va dSZ;
    private c dTa;
    private boolean dTb;
    private boolean dTc;
    private double dTd;
    private KycWithdrawalStatus dTe;
    private ScrollDirection dTf = ScrollDirection.none;
    private ImmutableList<n<Fragment>> dTg = ImmutableList.sL();
    private ImmutableList<Integer> dTh = ImmutableList.sL();
    private ImmutableList<View> dTi = ImmutableList.sL();
    private DecimalFormat duM;
    private Position position;

    private enum ScrollDirection {
        none,
        left,
        right
    }

    public interface a {
    }

    private class d implements OnPageChangeListener {
        private d() {
        }

        /* synthetic */ d(WithdrawalCryptoPagerFragment withdrawalCryptoPagerFragment, AnonymousClass1 anonymousClass1) {
            this();
        }

        public void onPageScrolled(int i, float f, int i2) {
            String str = WithdrawalCryptoPagerFragment.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onPageScrolled position: ");
            stringBuilder.append(i);
            stringBuilder.append(", positionOffset: ");
            stringBuilder.append(f);
            stringBuilder.append(", positionOffsetPixels: ");
            stringBuilder.append(i2);
            i.v(str, stringBuilder.toString());
            if (WithdrawalCryptoPagerFragment.this.dTf == ScrollDirection.none && WithdrawalCryptoPagerFragment.this.ctU == 1) {
                if (f < 0.5f) {
                    WithdrawalCryptoPagerFragment.this.dTf = ScrollDirection.right;
                } else {
                    WithdrawalCryptoPagerFragment.this.dTf = ScrollDirection.left;
                }
            }
            if (!WithdrawalCryptoPagerFragment.this.dTi.isEmpty() && WithdrawalCryptoPagerFragment.this.dTf != ScrollDirection.none) {
                int min;
                if (WithdrawalCryptoPagerFragment.this.dTf == ScrollDirection.right) {
                    min = Math.min(i + 1, WithdrawalCryptoPagerFragment.this.dTa.getCount() - 1);
                } else {
                    min = i;
                    i = Math.min(i + 1, WithdrawalCryptoPagerFragment.this.dTa.getCount() - 1);
                }
                String str2 = WithdrawalCryptoPagerFragment.TAG;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("CUR PAGE: ");
                stringBuilder2.append(i);
                stringBuilder2.append(", nextPage: ");
                stringBuilder2.append(min);
                stringBuilder2.append(", scroll direction:");
                stringBuilder2.append(WithdrawalCryptoPagerFragment.this.dTf);
                i.v(str2, stringBuilder2.toString());
                if (f != 0.0f && i2 != 0) {
                    float f2 = ((WithdrawalCryptoPagerFragment.this.dTf == ScrollDirection.right ? 1.0f - f : f) * 0.7f) + 0.3f;
                    ((View) WithdrawalCryptoPagerFragment.this.dTi.get(i)).setAlpha(f2);
                    String str3 = WithdrawalCryptoPagerFragment.TAG;
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("CUR PAGE alpha:");
                    stringBuilder3.append(f2);
                    i.v(str3, stringBuilder3.toString());
                    if (i != min) {
                        if (WithdrawalCryptoPagerFragment.this.dTf != ScrollDirection.right) {
                            f = 1.0f - f;
                        }
                        f = (f * 0.7f) + 0.3f;
                        ((View) WithdrawalCryptoPagerFragment.this.dTi.get(min)).setAlpha(f);
                        String str4 = WithdrawalCryptoPagerFragment.TAG;
                        StringBuilder stringBuilder4 = new StringBuilder();
                        stringBuilder4.append("Next PAGE alpha:");
                        stringBuilder4.append(f);
                        i.v(str4, stringBuilder4.toString());
                    }
                }
            }
        }

        public void onPageScrollStateChanged(int i) {
            String str = WithdrawalCryptoPagerFragment.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onPageScrollStateChanged state: ");
            stringBuilder.append(i);
            i.v(str, stringBuilder.toString());
            WithdrawalCryptoPagerFragment.this.ctU = i;
            if (i == 0) {
                WithdrawalCryptoPagerFragment.this.dTf = ScrollDirection.none;
            }
        }

        public void onPageSelected(int i) {
            String str = WithdrawalCryptoPagerFragment.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onPageSelected position: ");
            stringBuilder.append(i);
            i.v(str, stringBuilder.toString());
        }
    }

    private static class b extends com.iqoption.system.c.b<WithdrawalCryptoPagerFragment, List<Parcelable>> {
        public b(WithdrawalCryptoPagerFragment withdrawalCryptoPagerFragment) {
            super((Object) withdrawalCryptoPagerFragment);
        }

        /* renamed from: a */
        public void z(@NonNull WithdrawalCryptoPagerFragment withdrawalCryptoPagerFragment, List<Parcelable> list) {
            super.z(withdrawalCryptoPagerFragment, list);
            KycState kycState = (KycState) list.get(0);
            com.iqoption.microservice.a.b.a aVar = (com.iqoption.microservice.a.b.a) list.get(1);
            e eVar = (e) list.get(2);
            String str = WithdrawalCryptoPagerFragment.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("cryptoPayoutAvailable: ");
            stringBuilder.append(eVar);
            i.v(str, stringBuilder.toString());
            if (!aw.equals(withdrawalCryptoPagerFragment.dSR, aVar) || !aw.equals(withdrawalCryptoPagerFragment.dSM, eVar)) {
                withdrawalCryptoPagerFragment.a(kycState, aVar, eVar);
            }
        }
    }

    private class c extends FragmentPagerAdapter {
        public int getItemPosition(Object obj) {
            return -2;
        }

        public c(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        public Fragment getItem(int i) {
            return (Fragment) ((n) WithdrawalCryptoPagerFragment.this.dTg.get(i)).get();
        }

        public int getCount() {
            return WithdrawalCryptoPagerFragment.this.dTg.size();
        }

        public long getItemId(int i) {
            if (i < WithdrawalCryptoPagerFragment.this.dTh.size()) {
                i = ((Integer) WithdrawalCryptoPagerFragment.this.dTh.get(i)).intValue();
            }
            return (long) i;
        }
    }

    public static WithdrawalCryptoPagerFragment a(KycState kycState, com.iqoption.microservice.a.b.a aVar, e eVar, double d, double d2, String str, Position position, @IdRes int i, boolean z) {
        WithdrawalCryptoPagerFragment withdrawalCryptoPagerFragment = new WithdrawalCryptoPagerFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("ARG_KYC_STATE", kycState);
        bundle.putParcelable("ARG_KYC_DOCUMENTS_STATUS", aVar);
        bundle.putParcelable("ARG_CRYPTO_PAYOUT_AVAILABLE", eVar);
        bundle.putDouble("ARG_PURCHASE_AMOUNT", d);
        bundle.putDouble("ARG_ASSET_AMOUNT", d2);
        bundle.putString("ARG_ASSET_NAME", str);
        bundle.putParcelable("ARG_POSITION", position);
        bundle.putInt("ARG_MESSAGE_LAYER_ID", i);
        bundle.putBoolean("ARG_IS_AMOUNT_CHANGE_ALLOWED", z);
        withdrawalCryptoPagerFragment.setArguments(bundle);
        return withdrawalCryptoPagerFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.cJn = (KycState) arguments.getParcelable("ARG_KYC_STATE");
            this.dSR = (com.iqoption.microservice.a.b.a) arguments.getParcelable("ARG_KYC_DOCUMENTS_STATUS");
            this.dSM = (e) arguments.getParcelable("ARG_CRYPTO_PAYOUT_AVAILABLE");
            this.dTd = com.iqoption.withdrawal.crypto.a.b(this.dSM);
            this.cnV = arguments.getDouble("ARG_PURCHASE_AMOUNT");
            this.cnW = arguments.getDouble("ARG_ASSET_AMOUNT");
            this.assetName = arguments.getString("ARG_ASSET_NAME");
            this.position = (Position) arguments.getParcelable("ARG_POSITION");
            this.dSX = arguments.getInt("ARG_MESSAGE_LAYER_ID");
            this.cnX = arguments.getBoolean("ARG_IS_AMOUNT_CHANGE_ALLOWED");
            this.duM = com.iqoption.withdrawal.crypto.a.kr(this.assetName);
        }
        if (bundle != null) {
            this.dTb = bundle.getBoolean("WAS_KYC_ACTIVITY_STARTED", this.dTb);
            this.dTc = bundle.getBoolean("WAS_3_DS_DEPOSIT_STARTED", this.dTc);
            this.dTd = bundle.getDouble("NECESSARY_3_DS_AMOUNT", this.dTd);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("WAS_KYC_ACTIVITY_STARTED", this.dTb);
        bundle.putBoolean("WAS_3_DS_DEPOSIT_STARTED", this.dTc);
        bundle.putDouble("NECESSARY_3_DS_AMOUNT", this.dTd);
        super.onSaveInstanceState(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.dSZ = (va) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_withdrawal_crypto_pager, viewGroup, false);
        aOm();
        h(layoutInflater, viewGroup);
        this.dTa = new c(getChildFragmentManager());
        this.dSZ.bmI.setAdapter(this.dTa);
        this.dSZ.bmI.addOnPageChangeListener(new d(this, null));
        this.dSZ.getRoot().setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                WithdrawalCryptoPagerFragment.this.close();
            }
        });
        return this.dSZ.getRoot();
    }

    private void close() {
        am.n(zzakw());
        getFragmentManager().popBackStackImmediate();
    }

    private void aOm() {
        com.google.common.collect.ImmutableList.a aVar = new com.google.common.collect.ImmutableList.a();
        com.google.common.collect.ImmutableList.a aVar2 = new com.google.common.collect.ImmutableList.a();
        this.dTe = com.iqoption.withdrawal.crypto.a.a(this.cJn, this.dSR);
        final boolean aOp = aOp();
        if (this.dTe != KycWithdrawalStatus.Done) {
            aVar2.ae(Suppliers.a(new n<Fragment>() {
                /* renamed from: aOq */
                public Fragment get() {
                    return b.a(WithdrawalCryptoPagerFragment.this.cJn, WithdrawalCryptoPagerFragment.this.dSR, aOp, WithdrawalCryptoPagerFragment.this.assetName, WithdrawalCryptoPagerFragment.this.cnW);
                }
            }));
            aVar.ae(Integer.valueOf(View.generateViewId()));
        }
        if (!aOp) {
            aVar2.ae(Suppliers.a(new n<Fragment>() {
                /* renamed from: aOq */
                public Fragment get() {
                    return a.a(WithdrawalCryptoPagerFragment.this.dSM, WithdrawalCryptoPagerFragment.this.assetName);
                }
            }));
            aVar.ae(Integer.valueOf(View.generateViewId()));
        }
        aVar2.ae(Suppliers.a(new n<Fragment>() {
            /* renamed from: aOq */
            public Fragment get() {
                return d.a(WithdrawalCryptoPagerFragment.this.assetName, WithdrawalCryptoPagerFragment.this.cnW, WithdrawalCryptoPagerFragment.this.dSM, WithdrawalCryptoPagerFragment.this.cnX, WithdrawalCryptoPagerFragment.this.cJn, WithdrawalCryptoPagerFragment.this.dSR);
            }
        }));
        aVar.ae(Integer.valueOf(268435456));
        this.dTg = aVar2.sP();
        this.dTh = aVar.sP();
    }

    private void h(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.dSZ.bwd.removeAllViews();
        if (this.dTg.size() > 1) {
            com.google.common.collect.ImmutableList.a aVar = new com.google.common.collect.ImmutableList.a();
            int i = 0;
            while (i < this.dTg.size()) {
                View inflate = layoutInflater.inflate(R.layout.dot_layout, viewGroup, false);
                this.dSZ.bwd.addView(inflate);
                aVar.ae(inflate);
                inflate.setAlpha(i == 0 ? 1.0f : 0.3f);
                inflate.setOnClickListener(new OnClickListener() {
                    public void onClick(View view) {
                        int currentItem = WithdrawalCryptoPagerFragment.this.dSZ.bmI.getCurrentItem();
                        if (currentItem != i) {
                            WithdrawalCryptoPagerFragment.this.dSZ.bmI.setCurrentItem(i);
                            ((View) WithdrawalCryptoPagerFragment.this.dTi.get(currentItem)).setAlpha(0.3f);
                            ((View) WithdrawalCryptoPagerFragment.this.dTi.get(i)).setAlpha(1.0f);
                        }
                    }
                });
                i++;
            }
            this.dTi = aVar.sP();
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof com.iqoption.view.e) {
            ((com.iqoption.view.e) context).a(this);
        }
        if (context instanceof a) {
            this.dSY = (a) context;
        }
    }

    public void onDetach() {
        super.onDetach();
        Context context = getContext();
        if (context instanceof com.iqoption.view.e) {
            ((com.iqoption.view.e) context).b(this);
        }
        this.dSY = null;
    }

    public boolean onBackPressed() {
        am.n(zzakw());
        int currentItem = this.dSZ.bmI.getCurrentItem();
        if (currentItem == 0) {
            return false;
        }
        int i = currentItem - 1;
        this.dSZ.bmI.setCurrentItem(i);
        if (!this.dTi.isEmpty()) {
            ((View) this.dTi.get(currentItem)).setAlpha(0.3f);
            ((View) this.dTi.get(i)).setAlpha(1.0f);
        }
        return true;
    }

    public void onResume() {
        super.onResume();
        if (this.dTb || this.dTc) {
            aOo();
            this.dTb = false;
            this.dTc = false;
        }
    }

    public void aOn() {
        int currentItem = this.dSZ.bmI.getCurrentItem();
        if (currentItem != this.dTg.size() - 1) {
            int i = currentItem + 1;
            this.dSZ.bmI.setCurrentItem(i);
            if (!this.dTi.isEmpty()) {
                ((View) this.dTi.get(currentItem)).setAlpha(0.3f);
                ((View) this.dTi.get(i)).setAlpha(1.0f);
            }
        }
    }

    private void aOo() {
        ag.b(com.iqoption.withdrawal.crypto.a.d(this.cnV, this.cnW, this.assetName), new b(this));
    }

    private void a(KycState kycState, com.iqoption.microservice.a.b.a aVar, e eVar) {
        this.cJn = kycState;
        this.dSR = aVar;
        this.dSM = eVar;
        this.dTd = com.iqoption.withdrawal.crypto.a.b(eVar);
        int count = this.dTa.getCount();
        int currentItem = this.dSZ.bmI.getCurrentItem();
        aOm();
        h(getLayoutInflater(), (ViewGroup) this.dSZ.getRoot());
        this.dTa.notifyDataSetChanged();
        if (this.dTa.getCount() != count) {
            currentItem = 0;
        }
        hD(currentItem);
    }

    private void hD(int i) {
        int i2 = 0;
        this.dSZ.bmI.setCurrentItem(i, false);
        while (i2 < this.dTi.size()) {
            ((View) this.dTi.get(i2)).setAlpha(i2 == i ? 1.0f : 0.3f);
            i2++;
        }
    }

    public void b(KycWithdrawalStatus kycWithdrawalStatus) {
        switch (kycWithdrawalStatus) {
            case NotFilled:
                new com.iqoption.kyc.activity.KycActivity.a(zzakw()).d(this.cJn).dP(true).start();
                this.dTb = true;
                return;
            case DocumentsNotUploaded:
                new com.iqoption.kyc.activity.KycActivity.a(zzakw()).d(this.cJn).dP(true).ic(com.iqoption.kyc.fragment.jumio.d.TAG).start();
                this.dTb = true;
                return;
            case UploadIsNotFinishingByUser:
                new com.iqoption.kyc.activity.KycActivity.a(zzakw()).d(this.cJn).dP(true).ic(com.iqoption.kyc.fragment.jumio.e.TAG).start();
                this.dTb = true;
                return;
            case DocumentOnVerification:
                if (this.dTg.size() > 2) {
                    aOn();
                    return;
                } else {
                    close();
                    return;
                }
            case DocumentsIsDeclined:
                new com.iqoption.kyc.activity.KycActivity.a(zzakw()).d(this.cJn).dP(true).ic(com.iqoption.kyc.fragment.jumio.e.TAG).start();
                this.dTb = true;
                return;
            default:
                return;
        }
    }

    public void aOk() {
        com.iqoption.deposit.i.o(zzakw());
        this.dTc = true;
    }

    private boolean aOp() {
        return this.dSM != null && com.iqoption.withdrawal.crypto.a.b(this.dSM) == 0.0d;
    }

    public void a(Barcode barcode) {
        for (com.iqoption.withdrawal.crypto.barcode.a.a a : ac.a(getChildFragmentManager(), com.iqoption.withdrawal.crypto.barcode.a.a.class)) {
            a.a(barcode);
        }
    }

    private void c(boolean z, double d) {
        com.iqoption.withdrawal.crypto.a.a.a.aI(Event.CATEGORY_BUTTON_PRESSED, "crypto_withdraw-popup-withdraw").O(d).ks(this.assetName).fE(z).R(this.dSM.cVI.doubleValue()).S(this.dSM.getMinimum()).T(this.dSM.cVI.doubleValue()).send();
    }

    public s<?> g(String str, final double d) {
        Object aG = com.iqoption.withdrawal.crypto.a.aG(str, this.assetName);
        if (!TextUtils.isEmpty(aG)) {
            s<?> a;
            if (this.position != null) {
                a = com.iqoption.mobbtech.connect.request.api.a.c.a(this.position, aG);
                ag.b(a, new com.iqoption.system.c.b<WithdrawalCryptoPagerFragment, Order>(this) {
                    /* renamed from: a */
                    public void z(@NonNull WithdrawalCryptoPagerFragment withdrawalCryptoPagerFragment, Order order) {
                        super.z(withdrawalCryptoPagerFragment, order);
                        withdrawalCryptoPagerFragment.close();
                        g.a(WithdrawalCryptoPagerFragment.this.dSX, WithdrawalCryptoPagerFragment.this.getFragmentManager(), WithdrawalCryptoPagerFragment.this.getString(R.string.you_position_has_been_withdrawn));
                        WithdrawalCryptoPagerFragment.this.c(true, d);
                    }

                    /* renamed from: a */
                    public void c(@NonNull WithdrawalCryptoPagerFragment withdrawalCryptoPagerFragment, Throwable th) {
                        super.c(withdrawalCryptoPagerFragment, th);
                        WithdrawalCryptoPagerFragment.this.c(false, d);
                    }
                });
                return a;
            } else if (d > 0.0d) {
                a = o.a(com.iqoption.mobbtech.connect.response.a.a.ava().iM(TAG), new c(this, com.iqoption.app.managers.feature.a.HP(), d, str));
                ag.b(a, new com.iqoption.system.c.b<WithdrawalCryptoPagerFragment, com.iqoption.mobbtech.connect.response.s>(this) {
                    /* renamed from: a */
                    public void z(@NonNull WithdrawalCryptoPagerFragment withdrawalCryptoPagerFragment, com.iqoption.mobbtech.connect.response.s sVar) {
                        super.z(withdrawalCryptoPagerFragment, sVar);
                        withdrawalCryptoPagerFragment.close();
                        if (withdrawalCryptoPagerFragment.duM != null) {
                            g.a(WithdrawalCryptoPagerFragment.this.dSX, WithdrawalCryptoPagerFragment.this.getFragmentManager(), WithdrawalCryptoPagerFragment.this.getString(R.string.otn_tokens_have_been_withdrawn, withdrawalCryptoPagerFragment.duM.format(d)));
                            WithdrawalCryptoPagerFragment.this.c(true, d);
                        }
                    }

                    /* renamed from: a */
                    public void c(@NonNull WithdrawalCryptoPagerFragment withdrawalCryptoPagerFragment, Throwable th) {
                        super.c(withdrawalCryptoPagerFragment, th);
                        WithdrawalCryptoPagerFragment.this.c(false, d);
                    }
                });
                return a;
            }
        }
        return o.vT();
    }
}
